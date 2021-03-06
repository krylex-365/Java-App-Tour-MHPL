/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.LoaiHinhTourDAO;
import DAO.MaDuLieuCuoiDAO;
import DTO.LoaiHinhTourDTO;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class LoaiHinhTourBUS {

    private LoaiHinhTourDAO loaiHinhTourDAO;
    private Utils utl = new Utils();
    private MaDuLieuCuoiDAO maLast = new MaDuLieuCuoiDAO();

    public LoaiHinhTourBUS() {
        this.loaiHinhTourDAO = new LoaiHinhTourDAO();
    }

//    public String CapPhat(String init) {
//        System.out.println("- cap 1");
//        init = utl.initMaLoai(init);
//        System.out.println("- cap 2");
//        return init;
//    }

    private int indexLoaiHinh(String maLoai, ArrayList<LoaiHinhTourDTO> loaiHinhTourDTOs) {
        for (int i = 0; i < loaiHinhTourDTOs.size(); i++) {
            if (maLoai.equals(loaiHinhTourDTOs.get(i).getMaLoai())) {
                return i;
            }
        }
        return -1;
    }

    public boolean themLoaiHinhTour(String maLoai, String tenLoai, ArrayList<LoaiHinhTourDTO> loaiHinhTourDTOs) {
        if (loaiHinhTourDAO.insertLoaiHinh(maLoai, tenLoai)) {
            LoaiHinhTourDTO newLoaiHinh = new LoaiHinhTourDTO(maLoai, tenLoai);
            loaiHinhTourDTOs.add(newLoaiHinh);
            maLast.updateMaLoai(maLoai);
            System.out.println("Thêm thành công themLoaiHinhTourBUS");
            return true;
        }
        System.out.println("Thêm thất bại themLoaiHinhTourBUS");
        return false;
    }

    public boolean suaLoaiHinhTour(String maLoai, String tenLoai, ArrayList<LoaiHinhTourDTO> loaiHinhTourDTOs) {
        int indexMaLH = indexLoaiHinh(maLoai, loaiHinhTourDTOs);
        if (indexMaLH == -1) {
            return false;
        }
        LoaiHinhTourDTO loaihinhDTO = new LoaiHinhTourDTO(maLoai, tenLoai);
        if (loaiHinhTourDAO.updateLoaiHinh(loaihinhDTO)) {
            loaiHinhTourDTOs.set(indexMaLH, loaihinhDTO);
            System.out.println("Sửa thành công suaLoaiHinhTourBUS");
            return true;
        }
        System.out.println("Sửa thất bại suaLoaiHinhTourBUS");
        return false;
    }

    public boolean xoaLoaiHinhTour(String maLoai, ArrayList<LoaiHinhTourDTO> loaiHinhTourDTOs) {
        if (loaiHinhTourDAO.deleteLoaiHinh(maLoai)) {
            loaiHinhTourDTOs.remove(indexLoaiHinh(maLoai, loaiHinhTourDTOs));
            System.out.println("Xóa thành công xoaLoaiHinhTourBUS");
            return true;
        }
        System.out.println("Xóa thất bại xoaLoaiHinhTourBUS");
        return false;
    }
    
    public ArrayList<LoaiHinhTourDTO> searchLoaiHinhByMaLH(String maLoaiHinh, ArrayList<LoaiHinhTourDTO> loaiHinhTourDTOs) {
        ArrayList<LoaiHinhTourDTO> result = new ArrayList<>();
        for (LoaiHinhTourDTO a : loaiHinhTourDTOs) {
            if (a.getMaLoai().equals(maLoaiHinh)) {
                result.add(a);
            }
        }
        return result;
    }
}
