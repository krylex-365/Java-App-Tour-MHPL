/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.GiaTourBUS;
import BUS.LoaiHinhTourBUS;
import BUS.TourBUS;
import DTO.GiaTourDTO;
import DTO.LoaiHinhTourDTO;
import DTO.TourDTO;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class Tour {
    TourBUS tourBUS;
    GiaTourBUS giaTourBUS;
    ChiTietTour chiTietTour;
    LoaiHinhTourBUS loaiHinhTourBUS;

    public Tour() {
        tourBUS = new TourBUS();
        giaTourBUS = new GiaTourBUS();
        chiTietTour = new ChiTietTour();
        loaiHinhTourBUS = new LoaiHinhTourBUS();
    }
    
    public void tableModelTour(DefaultTableModel model) {
        for (TourDTO tour : tourBUS.getTourDTOS()) {
            Vector row = new Vector();
            row.add(tour.getMaTour());
            row.add(tour.getTenTour());
            for (LoaiHinhTourDTO loaiHinhTour : loaiHinhTourBUS.getLoaiHinhTourDTOs()) {
                if (loaiHinhTour.getMaLoai().equals(tour.getMaLoai())) {
                    row.add(loaiHinhTour.getTenLoai());
                }
            }
            for (GiaTourDTO giaTour : giaTourBUS.getGiaTourDTOs()) {
                if (giaTour.getMaTour().equals(tour.getMaTour()) && giaTour.getHienHanh() == 1) {
                    row.add(giaTour.getThanhTien());
                    row.add(giaTour.getTgBatDau());
                    row.add(giaTour.getTgKetThuc());
                }
            }
            model.addRow(row);
        }
    }
}
