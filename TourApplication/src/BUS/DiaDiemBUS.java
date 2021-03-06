/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.DiaDiemDAO;
import DAO.MaDuLieuCuoiDAO;
import DTO.DiaDiemDTO;
import DTO.DiaDiemThamQuanDTO;

import java.util.ArrayList;

/**
 *
 * @author minhk
 */
public class DiaDiemBUS {
    private DiaDiemDAO diaDiemDAO;
//    private ArrayList<DiaDiemDTO> diaDiemDTOs;
    private Utils utl = new Utils();
    private MaDuLieuCuoiDAO maLast = new MaDuLieuCuoiDAO();

    public DiaDiemBUS(DiaDiemDAO diaDiemDAO) {
        this.diaDiemDAO = diaDiemDAO;
    }

    public DiaDiemBUS() {
        diaDiemDAO = new DiaDiemDAO();
    }

//    public String CapPhat(String init) {
//        System.out.println("- cap 1");
//        init = utl.initMaDiaDiem(init);
//        System.out.println("- cap 2");
//        return init;
//    }

    public DiaDiemDAO getDiaDiemDAO() {
        return diaDiemDAO;
    }

    public void setDiaDiemDAO(DiaDiemDAO diaDiemDAO) {
        this.diaDiemDAO = diaDiemDAO;
    }
    
    public String searchTenDiaDiemByMaDiaDiem(String maDiaDiem, ArrayList<DiaDiemDTO> diaDiemDTOs){
        String result="Lối !!";
        for(DiaDiemDTO a : diaDiemDTOs){
            if(maDiaDiem.equals(a.getMaDiaDiem()))result = a.getTenDiaDiem();
        }
        return result;
    }
    
    public ArrayList<DiaDiemDTO> searchListDiaDiemByMaDiaDiem(String maDiaDiem, ArrayList<DiaDiemDTO> diaDiemDTOs){
        ArrayList<DiaDiemDTO> result = new ArrayList<>();
        for(DiaDiemDTO a : diaDiemDTOs){
            if(maDiaDiem.equals(a.getMaDiaDiem()))result.add(a);
        }
        return result;
    }

    public boolean themDiaDiem(String maDiaDiem, String tenDiaDiem, ArrayList<DiaDiemDTO> diaDiemDTOs){
        DiaDiemDTO diaDiemDTO = new DiaDiemDTO(maDiaDiem, tenDiaDiem);
        if(diaDiemDAO.insertDiaDiem(diaDiemDTO)){
            diaDiemDTOs.add(diaDiemDTO);
            maLast.updateMaDiaDiem(maDiaDiem);
            System.out.println("Thêm thành công themDiaDiem");
            return true;
        }
        System.out.println("Thêm thất bại themDiaDiem");
        return false;
    }

    public boolean suaDiaDiem(String maDiaDiem, String tenDiaDiem, ArrayList<DiaDiemDTO> diaDiemDTOs){
        DiaDiemDTO diaDiemDTO = searchDiaDiemByMaDiaDiem(maDiaDiem, diaDiemDTOs);
        if(diaDiemDTO != null){
            if(diaDiemDAO.updateMaDiaDiem(maDiaDiem, tenDiaDiem)){
                diaDiemDTO.setTenDiaDiem(tenDiaDiem);
                System.out.println("Sửa thành công suaDiaDiem");
                return true;
            }
        }
        System.out.println("Sửa thất bại suaDiaDiem - Địa điểm chưa có");
        return false;
    }

    public boolean xoaDiaDiem(String maDiaDiem,ArrayList<DiaDiemThamQuanDTO> diaDiemThamQuanDTOs, ArrayList<DiaDiemDTO> diaDiemDTOs){
        DiaDiemDTO diaDiemDTO = searchDiaDiemByMaDiaDiem(maDiaDiem, diaDiemDTOs);
        DiaDiemThamQuanDTO diaDiemThamQuanDTO = new DiaDiemThamQuanBUS()
                .searchDiaDiemThamQuanByMaDiaDiem(maDiaDiem,diaDiemThamQuanDTOs);
        if(diaDiemDTO != null && diaDiemThamQuanDTO == null){
            if(diaDiemDAO.deleteDiaDiem(maDiaDiem)){
                diaDiemDTOs.remove(diaDiemDTO);
                System.out.println("Xóa thành công xoaDiaDiem");
                return true;
            }
        }
        System.out.println("Xóa thất bại xoaDiaDiem - Địa điểm chưa có hoặc Địa điểm tham quan đang tham chiếu tới");
        return false;
    }

    private DiaDiemDTO searchDiaDiemByMaDiaDiem(String maDiaDiem, ArrayList<DiaDiemDTO> diaDiemDTOs) {
        for (DiaDiemDTO diaDiemDTO: diaDiemDTOs){
            if(diaDiemDTO.getMaDiaDiem().equals(maDiaDiem)) return diaDiemDTO;
        }
        return null;
    }

}