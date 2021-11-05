/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.DoanDuLichDAO;
import DAO.MaDuLieuCuoiDAO;
import DTO.DoanDuLichDTO;
import java.util.ArrayList;
//import org.codehaus.groovy.runtime.DefaultGroovyMethods;

/**
 *
 * @author User
 */
public class DoanDuLichBUS {

    private DoanDuLichDAO doanDuLichDAO;
    private ArrayList<DoanDuLichDTO> doanDuLichDTOs;
    private MaDuLieuCuoiDAO maLast = new MaDuLieuCuoiDAO();

    public DoanDuLichBUS(DoanDuLichDAO doanDuLichDAO, ArrayList<DoanDuLichDTO> doanDuLichDTOs) {
        this.doanDuLichDAO = doanDuLichDAO;
        this.doanDuLichDTOs = doanDuLichDTOs;
    }

    public DoanDuLichBUS() {
        doanDuLichDAO = new DoanDuLichDAO();
        doanDuLichDTOs = doanDuLichDAO.getList();
    }

    public ArrayList<DoanDuLichDTO> getDoanDuLichDTOs() {
        return doanDuLichDAO.getList();
    }

    public ArrayList<DoanDuLichDTO> searchDoanDuLichByMaTour(String maTour) {
        ArrayList<DoanDuLichDTO> result = new ArrayList<DoanDuLichDTO>();
        for (DoanDuLichDTO a : doanDuLichDTOs) {
            if (a.getMaTour().equals(maTour)) {
                result.add(a);
                System.out.println(a);
            }
        }
        return result;
    }

    public ArrayList<DoanDuLichDTO> searchDoanDuLichByMaDoan(String maDoan) {
        ArrayList<DoanDuLichDTO> result = new ArrayList<DoanDuLichDTO>();
        for (DoanDuLichDTO a : doanDuLichDTOs) {
            if (a.getMaDoan().equals(maDoan)) {
                result.add(a);
            }
        }
        return result;
    }

//    public int soKhach(String maDoan) {
//        int count = 0;
//        for (DoanDuLichDTO dto : doanDuLichDTOs) {
//            if (dto.getMaDoan().equals(maDoan)) {
//                count++;
//            }
//        }
//        return count;
//    }
    public DoanDuLichDTO getDoanDuLichByMaTour(String maTour) {
        for (DoanDuLichDTO doanDuLichDTO : doanDuLichDTOs) {
            if (doanDuLichDTO.getMaTour().equals(maTour)) {
                return doanDuLichDTO;
            }
        }
        return null;
    }

    public int countDoanTrongTour(String maTour) {
        int count = 0;
        for (DoanDuLichDTO a : doanDuLichDTOs) {
            if (a.getMaTour().equals(maTour)) {
                count++;
            }
        }
        return count;
    }
    
    private int indexDoan(String maDoan) {
        for (int i = 0; i < doanDuLichDTOs.size(); i++) {
            if (maDoan.equals(doanDuLichDTOs.get(i).getMaDoan())) {
                return i;
            }
        }
        return -1;
    }

    public boolean themDoan(String MaDoan, String MaTour, String TenDoan, 
            String GiaTour, String NgayKhoiHanh, String NgayKetThuc, String ChiTietNoiDung) {
        for (DoanDuLichDTO doanDL : doanDuLichDTOs) {
            if (doanDL.getMaDoan().equals(MaDoan)) {
                return false;
            }
        }
        DoanDuLichDTO doanDuLichDTO = new DoanDuLichDTO(MaDoan, MaTour, TenDoan, GiaTour, NgayKhoiHanh, NgayKetThuc, ChiTietNoiDung);
        if (doanDuLichDAO.insertDoan(doanDuLichDTO)) {
            doanDuLichDTOs.add(doanDuLichDTO);
            maLast.updateMaDoanDuLich(doanDuLichDTO.getMaDoan());
            System.out.println("Thêm thành công themDoanDuLichBUS");
            return true;
        }
        System.out.println("Thêm thất bại themDoanDuLichBUS");
        return false;
    }

    public boolean suaDoan(String MaDoan, String MaTourHH, String MaTour, String TenDoan, 
            String GiaTour, String NgayKhoiHanh, String NgayKetThuc, String ChiTietNoiDung) {
        int index = indexDoan(MaDoan);
        if (index == -1) {
            return false;
        }
        DoanDuLichDTO doanDuLichDTO = new DoanDuLichDTO(MaDoan, MaTour, TenDoan, GiaTour, NgayKhoiHanh, NgayKetThuc, ChiTietNoiDung);
        boolean checkTour;
        if (MaTourHH.equals(MaTour)){
            // NẾU KHÔNG SỬA TOUR
            checkTour = false;
        } else {
            // NẾU SỬA TOUR
            checkTour = true;
        }
        if (doanDuLichDAO.updateDoan(doanDuLichDTO, checkTour)) {
            doanDuLichDTOs.set(index, doanDuLichDTO);
            System.out.println("Sửa thành công suaDoanDuLichBUS");
            return true;
        }
        System.out.println("Sửa thất bại suaDoanDuLichBUS");
        return false;
    }

    public boolean xoaDoan(String MaDoan, String MaTour, String TenDoan, 
            String GiaTour, String NgayKhoiHanh, String NgayKetThuc, String ChiTietNoiDung) {
        return false;
    }

}
