package BUS;

import DAO.DiaDiemThamQuanDAO;
import DTO.DiaDiemThamQuanDTO;
import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author minhk
 */
public class DiaDiemThamQuanBUS {
    private DiaDiemThamQuanDAO diaDiemThamQuanDAO;
    private ArrayList<DiaDiemThamQuanDTO> diaDiemThamQuanDTOs;

    public DiaDiemThamQuanBUS() {
        diaDiemThamQuanDAO = new DiaDiemThamQuanDAO();
        diaDiemThamQuanDTOs = diaDiemThamQuanDAO.getList();        
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
    
    public boolean add(String maTour,String maDiaDiem,int thuTu){
        if(diaDiemThamQuanDAO.add(maTour, maDiaDiem, thuTu)){
            DiaDiemThamQuanDTO newDiaDiemThamQuan = new DiaDiemThamQuanDTO(maTour,maDiaDiem,thuTu);
            diaDiemThamQuanDTOs.add(newDiaDiemThamQuan);
            return true;
        }
        return false;
    }
    
    public boolean update(ArrayList<DiaDiemThamQuanDTO> newDiaDiemThamQuanDTOs){
        String maTour = newDiaDiemThamQuanDTOs.get(0).getMaTour();
        newDiaDiemThamQuanDTOs.sort(new Comparator<DiaDiemThamQuanDTO>(){
            @Override
            public int compare(DiaDiemThamQuanDTO o1, DiaDiemThamQuanDTO o2) {
                return o1.getThuTu().compare(o2.getThuTu());
            }
        });
        if(diaDiemThamQuanDAO.deleteAll(maTour)){
            int i = 1;
            for(DiaDiemThamQuanDTO a : newDiaDiemThamQuanDTOs){
                diaDiemThamQuanDAO.add(a.getMaTour(),a.getMaDiaDiem(), Integer.toString(i));
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

    
}
