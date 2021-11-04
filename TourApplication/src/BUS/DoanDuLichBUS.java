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

    public boolean themDoan(String MaDoan, String MaTour, String TenDoan, String GiaTour, String NgayKhoiHanh, String NgayKetThuc, String ChiTietNoiDung) {
        for (DoanDuLichDTO doanDL : doanDuLichDTOs) {
            if (doanDL.getMaDoan().equals(MaDoan)) {
                return false;
            }
        }
        DoanDuLichDTO doanDuLichDTO = new DoanDuLichDTO(MaDoan, MaTour, TenDoan, GiaTour, NgayKhoiHanh, NgayKetThuc, ChiTietNoiDung);
        if (doanDuLichDAO.insertDoan(doanDuLichDTO)) {
            doanDuLichDTOs.add(doanDuLichDTO);
            maLast.updateMaDoanDuLich(doanDuLichDTO.getMaDoan());
            System.out.println("Thêm Đoàn thành công BUS");
            return true;
        }
        System.out.println("Thêm Đoàn thất bại BUS");
        return false;
    }

    public boolean suaDoan(String MaDoan, String MaTour, String TenDoan, String GiaTour, String NgayKhoiHanh, String NgayKetThuc, String ChiTietNoiDung) {
        return false;
    }

    public boolean xoaDoan(String MaDoan, String MaTour, String TenDoan, String GiaTour, String NgayKhoiHanh, String NgayKetThuc, String ChiTietNoiDung) {
        return false;
    }

}
