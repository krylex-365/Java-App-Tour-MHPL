package GUI;

import BUS.DiaDiemBUS;
import BUS.GiaTourBUS;
import BUS.LoaiHinhTourBUS;
import BUS.TourBUS;
import DTO.DiaDiemDTO;
import DTO.GiaTourDTO;
import DTO.LoaiHinhTourDTO;
import DTO.TourDTO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Vector;

public class DiaDiem {
    DiaDiemBUS diaDiemBUS;


    public DiaDiem(DiaDiemBUS diaDiemBUS) {
        this.diaDiemBUS = diaDiemBUS;
    }

    public void tableModelDiaDiem(DefaultTableModel model) {
        for (DiaDiemDTO diaDiemDTO : diaDiemBUS.getDiaDiemDTOs()) {
            Vector row = new Vector();
            row.add(diaDiemDTO.getMaDiaDiem());
            row.add(diaDiemDTO.getTenDiaDiem());
            model.addRow(row);
        }
    }

    public void suaDiaDiem(DefaultTableModel model, int row, DiaDiemDTO diaDiemDTO){
        model.setValueAt(diaDiemDTO.getMaDiaDiem(),row, 0);
        model.setValueAt(diaDiemDTO.getTenDiaDiem(), row, 1);
    }

    public void themDiaDiem(DefaultTableModel model, DiaDiemDTO diaDiemDTO){
        Vector row = new Vector();
        row.add(diaDiemDTO.getMaDiaDiem());
        row.add(diaDiemDTO.getTenDiaDiem());
        model.addRow(row);
    }

    public void xoaDiaDiem(DefaultTableModel model, int row){
        model.removeRow(row);
    }

    public void timKiem(DefaultTableModel model, JTable jTable, String value){
        int size = model.getRowCount();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < size; i++){
            String maDiaDiem = (String) model.getValueAt(i, 0);
            String tenDiaDiem = (String) model.getValueAt(i, 1);
            if(!maDiaDiem.equals(value) && tenDiaDiem.indexOf(value) == -1){
                list.add(i);
            }
        }
        int downIndex = 0;
        for (Integer i: list){
            model.removeRow(i - downIndex);
            downIndex++;
        }
    }
}
