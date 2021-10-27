/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BUS.ChiTietDoanBUS;
import BUS.DiaDiemThamQuanBUS;
import BUS.DoanDuLichBUS;
import BUS.DiaDiemBUS;
import DTO.DiaDiemThamQuanDTO;
import DTO.DoanDuLichDTO;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author minhk
 */
public class ChiTietTour {
    ChiTietDoanBUS chiTietDoanBUS;
    DoanDuLichBUS doanDuLichBUS;
    DiaDiemThamQuanBUS diaDiemThamQuanBUS;
    DiaDiemBUS diaDiemBUS;

    public ChiTietTour() {
        chiTietDoanBUS = new ChiTietDoanBUS();
        doanDuLichBUS = new DoanDuLichBUS();
        diaDiemThamQuanBUS = new DiaDiemThamQuanBUS();
        diaDiemBUS = new DiaDiemBUS();
    }
    
    public void tbModelDiaDiemThamQuan(DefaultTableModel model,String maTour){
        Vector row = new Vector();
        for(DiaDiemThamQuanDTO a : diaDiemThamQuanBUS.searchDiaDiemThamQuanByMaTour(maTour)){
            row.add(a.getMaTour());
            row.add(diaDiemBUS.searchTenDiaDiemByMaDiaDiem(a.getMaDiaDiem()));
            row.add(a.getThuTu());
            model.addRow(row);
        }
    }
    
    public void tbModelDoanDuLich(DefaultTableModel model,String maTour){
        Vector row = new Vector();
        //System.out.println("ChiTietTour");
        for(DoanDuLichDTO a : doanDuLichBUS.searchDoanDuLichByMaTour(maTour)){
            row.add(a.getMaDoan());
            row.add(a.getTenDoan());
            row.add(a.getGiaTour());
            row.add(a.getNgayKhoiHanh());
            row.add(a.getNgayKetThuc());
            System.out.println(a);
            row.add(chiTietDoanBUS.peopleCount(a.getMaDoan()));
            model.addRow(row);
        }
    }

    public void tbModelSearchDoanDuLich(DefaultTableModel model,String maDoan){
        Vector row = new Vector();
        for(DoanDuLichDTO a : doanDuLichBUS.searchDoanDuLichByMaDoan(maDoan)){
            row.add(a.getMaDoan());
            row.add(a.getTenDoan());
            row.add(a.getGiaTour());
            row.add(a.getNgayKhoiHanh());
            row.add(a.getNgayKetThuc());
            row.add(chiTietDoanBUS.peopleCount(a.getMaDoan()));
            model.addRow(row);
        }
    }    
    
    
}
