/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.LoaiHinhTourBUS;
import BUS.Utils;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import DTO.LoaiHinhTourDTO;

/**
 *
 * @author VAN
 */
public class LoaiHinh {
    LoaiHinhTourBUS loaiHinhTourBUS;

    public LoaiHinh() {
        loaiHinhTourBUS = new LoaiHinhTourBUS();
    }
    
    public boolean isNullOrEmpty(String text) {
        if (text == null || text.equals("")) {
            return true;
        }
        return false;
    }
    
    public void tbModelSearchLoaiHinh(DefaultTableModel model, String maLH) {
        Vector row = new Vector();
        for (LoaiHinhTourDTO a : loaiHinhTourBUS.searchLoaiHinhByMaLH(maLH)) {
            System.out.println(a);
            row.add(a.getMaLoai());
            row.add(a.getTenLoai());
            model.addRow(row);
            break;
        }
    }

    public void tableModelLoaiHinh(DefaultTableModel model) {
        for (LoaiHinhTourDTO lh : loaiHinhTourBUS.getLoaiHinhTourDTOs()) {
            Vector row = new Vector();
            row.add(lh.getMaLoai());
            row.add(lh.getTenLoai());
            model.addRow(row);
        }
    }

    public void themVectorLoaiHinh(DefaultTableModel model, LoaiHinhTourDTO loaiHinhDTO){
        Vector newrow = new Vector();
        newrow.add(loaiHinhDTO.getMaLoai());
        newrow.add(loaiHinhDTO.getTenLoai());
        model.addRow(newrow);
    }
    
    public void suaVectorLoaiHinh(DefaultTableModel model, int row, LoaiHinhTourDTO loaiHinhDTO){
        model.setValueAt(loaiHinhDTO.getTenLoai(), row, 1);
    }
    
    public void xoaVectorLoaiHinh(DefaultTableModel model, int row){
        model.removeRow(row);
    }
}
