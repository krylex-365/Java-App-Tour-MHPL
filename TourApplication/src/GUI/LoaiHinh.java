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
    private Utils ult;

    public LoaiHinh() {
        loaiHinhTourBUS = new LoaiHinhTourBUS();
        ult = new Utils();
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
        Vector row = new Vector();
        for (LoaiHinhTourDTO lh : loaiHinhTourBUS.getLoaiHinhTourDTOs()) {
            row.add(lh.getMaLoai());
            row.add(lh.getTenLoai());
        }
        model.addRow(row);
    }

}
