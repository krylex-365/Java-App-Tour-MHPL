/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BUS.DiaDiemThamQuanBUS;
import DTO.ChiTietDoanDTO;
import DTO.DiaDiemThamQuanDTO;
import DTO.DoanDuLichDTO;
import DTO.GiaTourDTO;
import DTO.KhachHangDTO;
import DTO.LoaiChiPhiDTO;
import DTO.LoaiHinhTourDTO;
import DTO.NhanVienDTO;
import DTO.TourDTO;
import java.util.ArrayList;

/**
 *
 * @author minhk
 */
public class RunTest {
    
    public static void main(String[] args) {
//        TourDAO dsNhanVien = new TourDAO();
//        for(TourDTO a : dsNhanVien.getList()){
//            System.out.println(a.toString());
//        }
            DiaDiemThamQuanBUS bus = new DiaDiemThamQuanBUS();
            //bus.deleteAll("0001");
            ArrayList<DiaDiemThamQuanDTO> a = new ArrayList<>();
            DiaDiemThamQuanDTO temp = new DiaDiemThamQuanDTO("0001","0001",1);
            a.add(temp);
            DiaDiemThamQuanDTO temp1 = new DiaDiemThamQuanDTO("0001","0001",2);
            a.add(temp1);
            DiaDiemThamQuanDTO temp2 = new DiaDiemThamQuanDTO("0001","0001",3);
            a.add(temp2);
            DiaDiemThamQuanDTO temp3 = new DiaDiemThamQuanDTO("0001","0001",4);
            a.add(temp3);
            
            bus.update(a);
            
            
            
            
    }
}
