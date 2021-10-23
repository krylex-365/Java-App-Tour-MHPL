/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BUS.TourBUS;
import DTO.ChiTietDoanDTO;
import DTO.DiaDiemThamQuanDTO;
import DTO.DoanDuLichDTO;
import DTO.GiaTourDTO;
import DTO.KhachHangDTO;
import DTO.LoaiChiPhiDTO;
import DTO.LoaiHinhTourDTO;
import DTO.NhanVienDTO;
import DTO.TourDTO;

/**
 *
 * @author minhk
 */
public class RunTest {
    
    public static void main(String[] args) {
        TourDAO dsNhanVien = new TourDAO();
        for(TourDTO a : dsNhanVien.getList()){
            System.out.println(a.toString());
        }

        TourBUS tourBUS = new TourBUS();
        tourBUS.xoaTour("T001");
    }
}
