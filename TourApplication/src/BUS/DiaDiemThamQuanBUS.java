/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    //private ArrayList<DiaDiemThamQuanDTO> diaDiemThamQuanDTOs;

    public DiaDiemThamQuanBUS() {
        diaDiemThamQuanDAO = new DiaDiemThamQuanDAO();
        //diaDiemThamQuanDTOs = diaDiemThamQuanDAO.getList();        
    }

    public DiaDiemThamQuanBUS(DiaDiemThamQuanDAO diaDiemThamQuanDAO, ArrayList<DiaDiemThamQuanDTO> diaDiemThamQuanDTOs) {
        this.diaDiemThamQuanDAO = diaDiemThamQuanDAO;
        //this.diaDiemThamQuanDTOs = diaDiemThamQuanDTOs;
    }

    public ArrayList<DiaDiemThamQuanDTO> searchDiaDiemThamQuanByMaTour(String maTour, ArrayList<DiaDiemThamQuanDTO> diaDiemThamQuanDTOs){
        ArrayList<DiaDiemThamQuanDTO> result = new ArrayList<DiaDiemThamQuanDTO>();
        for(DiaDiemThamQuanDTO a : diaDiemThamQuanDTOs){
            if(a.getMaTour().equals(maTour))
                result.add(a);
        }
        return result;  
    }
    
//    public ArrayList<DiaDiemThamQuanDTO> getDiaDiemThamQuanDTOs() {
//        return diaDiemThamQuanDTOs;
//    }

//    public void setDiaDiemThamQuanDTOs(ArrayList<DiaDiemThamQuanDTO> diaDiemThamQuanDTOs) {
//        this.diaDiemThamQuanDTOs = diaDiemThamQuanDTOs;
//    }
    
    public boolean themDDiemTQuan(String maTour,String maDiaDiem,int thuTu,ArrayList<DiaDiemThamQuanDTO> diaDiemThamQuanDTOs){
        if(diaDiemThamQuanDAO.add(maTour, maDiaDiem, thuTu)){
            DiaDiemThamQuanDTO newDiaDiemThamQuan = new DiaDiemThamQuanDTO(maTour,maDiaDiem,thuTu);
            diaDiemThamQuanDTOs.add(newDiaDiemThamQuan);
            return true;
        }
        return false;
    }
    
    public boolean xoaDDiemTQuan(String maTour,String maDiaDiem,int thuTu,ArrayList<DiaDiemThamQuanDTO> diaDiemThamQuanDTOs){
        if(diaDiemThamQuanDAO.delete(maTour, maDiaDiem, thuTu)){
            DiaDiemThamQuanDTO newDiaDiemThamQuan = new DiaDiemThamQuanDTO(maTour,maDiaDiem,thuTu);
            diaDiemThamQuanDTOs.remove(newDiaDiemThamQuan);
            System.out.println("hello");
            return true;
        }
        return false;
    }
    
    public boolean deleteAll(String maTour, ArrayList<DiaDiemThamQuanDTO> diaDiemThamQuanDTOs){
        if(diaDiemThamQuanDAO.deleteAll(maTour)){
            for(int i = 0;i < diaDiemThamQuanDTOs.size();i++){
                if(diaDiemThamQuanDTOs.get(i).getMaTour().equals(maTour)){
                    diaDiemThamQuanDTOs.remove(i);
                }
            }
            System.out.println("hello");
            return true;
        }
        return false;
    }
    
    public boolean suaThuTuTQuan(ArrayList<DiaDiemThamQuanDTO> newDiaDiemThamQuanDTOs,ArrayList<DiaDiemThamQuanDTO> diaDiemThamQuanDTOs){
        String maTour = newDiaDiemThamQuanDTOs.get(0).getMaTour();
        newDiaDiemThamQuanDTOs.sort(new Comparator<DiaDiemThamQuanDTO>(){
            @Override
            public int compare(DiaDiemThamQuanDTO o1, DiaDiemThamQuanDTO o2) {
                return Integer.compare(o1.getThuTu(), o2.getThuTu());
            }
        });
        //newDiaDiemThamQuanDTOs = newDiaDiemThamQuanDTOs;
        if(diaDiemThamQuanDAO.deleteAll(maTour)){
            int i = 1;
            for(DiaDiemThamQuanDTO a : newDiaDiemThamQuanDTOs){
                diaDiemThamQuanDAO.add(a.getMaTour(),a.getMaDiaDiem(), i);
                a.setThuTu(i);
                i++;
            }
            for(int k = 0; k < diaDiemThamQuanDTOs.size();k++){
                if(diaDiemThamQuanDTOs.get(k).getMaTour().equals(maTour)){
                    diaDiemThamQuanDTOs.remove(k);
                    k--;
                }
            }
            for(DiaDiemThamQuanDTO a : newDiaDiemThamQuanDTOs){
                //System.out.println(a);
                diaDiemThamQuanDTOs.add(a);
            }
            
            return true;
        }
        System.out.println(newDiaDiemThamQuanDTOs.size());
        return false;
    }
    
    public boolean xoaDiaDiemThamQuanByMaTour(String maTour, ArrayList<DiaDiemThamQuanDTO> diaDiemThamQuanDTOs) {
        if (diaDiemThamQuanDAO.deleteDDTQuanByMaTour(maTour)){
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
    
    public boolean checkDuplicateThuTu(String maTour,int num,ArrayList<DiaDiemThamQuanDTO> diaDiemThamQuanDTOs){
        for(DiaDiemThamQuanDTO a : diaDiemThamQuanDTOs){
            if(a.getMaTour().equals(maTour)&&a.getThuTu()==num)return false;
        }
        return true;
    }

    public boolean addDiaDiemThamQuan(String maTour,String maDiaDiem,int thuThu,ArrayList<DiaDiemThamQuanDTO> diaDiemThamQuanDTOs){

        if(diaDiemThamQuanDAO.Add(maTour, maDiaDiem, thuThu)){
            diaDiemThamQuanDTOs.add(new DiaDiemThamQuanDTO(maTour,maDiaDiem,thuThu));
            System.out.println("Add Success");
            return true;
        }
        return false;
    }

    public boolean deleteDiaDiemThamQuan(String maTour,String maDiaDiem,int thuTu,ArrayList<DiaDiemThamQuanDTO> diaDiemThamQuanDTOs){
        if(diaDiemThamQuanDAO.delete(maTour, maDiaDiem, thuTu)){
            for(int i = 0;i< diaDiemThamQuanDTOs.size();i++){
                if(diaDiemThamQuanDTOs.get(i).getMaDiaDiem().equals(maDiaDiem)&&diaDiemThamQuanDTOs.get(i).getMaTour().equals(maTour)&&diaDiemThamQuanDTOs.get(i).getThuTu()== thuTu){
                    diaDiemThamQuanDTOs.remove(i);
                }
            }
            return true;
        }
        return false;
    }

    public boolean updateDiaDiemThamQuan(String  maTour,String maDiaDiem,int thuTu,int newThuTu,ArrayList<DiaDiemThamQuanDTO> diaDiemThamQuanDTOs){
        System.out.println(maTour +" "+ maDiaDiem +" "+ thuTu +" "+ newThuTu);
        if(diaDiemThamQuanDAO.updateDiaDiemThamQuan(maTour, maDiaDiem, thuTu,newThuTu)){
            for(int i = 0;i< diaDiemThamQuanDTOs.size();i++){
                if(diaDiemThamQuanDTOs.get(i).getMaDiaDiem().equals(maDiaDiem)&&diaDiemThamQuanDTOs.get(i).getMaTour().equals(maTour)&&diaDiemThamQuanDTOs.get(i).getThuTu()== thuTu){
                    diaDiemThamQuanDTOs.get(i).setThuTu(newThuTu);
                }
            }
            return true;
        }
        return false;
    }

    public DiaDiemThamQuanDTO searchDiaDiemThamQuanByMaDiaDiem(String maDiaDiem,ArrayList<DiaDiemThamQuanDTO> diaDiemThamQuanDTOs) {
        for (DiaDiemThamQuanDTO diaDiemThamQuanDTO: diaDiemThamQuanDTOs){
            if(diaDiemThamQuanDTO.getMaDiaDiem().equals(maDiaDiem)) return diaDiemThamQuanDTO;
        }
        return null;
    }
}
