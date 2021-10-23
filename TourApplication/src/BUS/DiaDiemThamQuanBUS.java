
package BUS;
import DAO.DiaDiemThamQuanDAO;
import DTO.DiaDiemThamQuanDTO;
import java.util.ArrayList;
import java.util.Comparator;
/**
 *
 * @author User
 */
public class DiaDiemThamQuanBUS {
    private DiaDiemThamQuanDAO diaDiemThamQuanDAO;
    private static ArrayList<DiaDiemThamQuanDTO> diaDiemThamQuanDTOs;

    public DiaDiemThamQuanBUS() {
        this.diaDiemThamQuanDAO = new DiaDiemThamQuanDAO();
        if(diaDiemThamQuanDTOs == null){
            diaDiemThamQuanDTOs = diaDiemThamQuanDAO.getList();
        }
    }

    public DiaDiemThamQuanBUS(DiaDiemThamQuanDAO diaDiemThamQuanDAO, ArrayList<DiaDiemThamQuanDTO> diaDiemThamQuanDTOs) {
        this.diaDiemThamQuanDAO = diaDiemThamQuanDAO;
        this.diaDiemThamQuanDTOs = diaDiemThamQuanDTOs;
    }

    public ArrayList<DiaDiemThamQuanDTO> searchDiaDiemThamQuanByMaTour(String maTour){
        ArrayList<DiaDiemThamQuanDTO> result = new ArrayList<DiaDiemThamQuanDTO>();
        for(DiaDiemThamQuanDTO a : diaDiemThamQuanDAO.getList()){
            if(a.getMaTour().equals(maTour))
                result.add(a);
        }
        return result;  
    }
    
    public boolean themDDiemTQuan(String maTour,String maDiaDiem,int thuTu){
        if(diaDiemThamQuanDAO.add(maTour, maDiaDiem, thuTu)){
            DiaDiemThamQuanDTO newDiaDiemThamQuan = new DiaDiemThamQuanDTO(maTour,maDiaDiem,thuTu);
            diaDiemThamQuanDTOs.add(newDiaDiemThamQuan);
            return true;
        }
        return false;
    }
    
    public boolean xoaDDiemTQuan(String maTour,String maDiaDiem,int thuTu){
        if(diaDiemThamQuanDAO.delete(maTour, maDiaDiem, thuTu)){
            DiaDiemThamQuanDTO newDiaDiemThamQuan = new DiaDiemThamQuanDTO(maTour,maDiaDiem,thuTu);
            diaDiemThamQuanDTOs.remove(newDiaDiemThamQuan);
            System.out.println("hello");
            return true;
        }
        return false;
    }
    
    public boolean deleteAll(String maTour){
        if(diaDiemThamQuanDAO.deleteAll(maTour)){
            System.out.println("hello");
            return true;
        }
        return false;
    }
    
    public boolean suaThuTuTQuan(ArrayList<DiaDiemThamQuanDTO> newDiaDiemThamQuanDTOs){
        String maTour = newDiaDiemThamQuanDTOs.get(0).getMaTour();
        newDiaDiemThamQuanDTOs.sort(new Comparator<DiaDiemThamQuanDTO>(){
            @Override
            public int compare(DiaDiemThamQuanDTO o1, DiaDiemThamQuanDTO o2) {
                return Integer.compare(o1.getThuTu(), o2.getThuTu());
            }
        });
        if(diaDiemThamQuanDAO.deleteAll(maTour)){
            int i = 1;
            for(DiaDiemThamQuanDTO a : newDiaDiemThamQuanDTOs){
                diaDiemThamQuanDAO.add(a.getMaTour(),a.getMaDiaDiem(), i);
                i++;
            }
            for(int k = 0; k < diaDiemThamQuanDTOs.size();k++){
                if(diaDiemThamQuanDTOs.get(k).getMaTour().equals(maTour)){
                    diaDiemThamQuanDTOs.remove(k);
                }
            }
            for(DiaDiemThamQuanDTO a : newDiaDiemThamQuanDTOs){
                diaDiemThamQuanDTOs.add(a);
            }
            return true;
        }
        return false;
    }

    public static ArrayList<DiaDiemThamQuanDTO> getDiaDiemThamQuanDTOs() {
        return diaDiemThamQuanDTOs;
    }

    public boolean xoaDiaDiemThamQuanByMaTour(String maTour) {
        if (diaDiemThamQuanDAO.xoaDiaDiemThamQuanByMaTour(maTour)){
            ArrayList<DiaDiemThamQuanDTO> ddtq = new ArrayList<>();
            for (DiaDiemThamQuanDTO diaDiemThamQuanDTO: diaDiemThamQuanDTOs){
                if(diaDiemThamQuanDTO.getMaTour().equals(maTour)){
                    ddtq.add(diaDiemThamQuanDTO);
                }
            }
            diaDiemThamQuanDTOs.removeAll(ddtq);
            return true;
        }
        return false;
    }
}
