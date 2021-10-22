/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DTO.TourDTO;
import DAO.TourDAO;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class TourBus {

    private TourDAO tourDAO;

    public TourBus() {
        tourDAO = new TourDAO();
    }

    public ArrayList<TourDTO> docDanhSachTour() {
        return tourDAO.getList();
    }

    public boolean themTour(String MaTour, String MaLoai, String TenTour, String DacDiem) {
        for (TourDTO tour : tourDAO.getList()) {
            if (tour.getMaTour().equals(MaTour)) {
                JOptionPane.showMessageDialog(null, "Mã tour" + tour.getMaTour() + " đã tồn tại!");
                return false;
            }
        }
        TourDTO newtour = new TourDTO();
        if (tourDAO.insertTour(MaTour, MaLoai, TenTour, DacDiem)) {

            newtour.setMaLoai(MaLoai);
            newtour.setMaTour(MaTour);
            newtour.setTenTour(TenTour);
            newtour.setDacDiem(DacDiem);
            docDanhSachTour().add(newtour);
            System.out.println("Thêm thành công");
            tourDAO.updateTour();

            GiaTourBus giatourBUS = new GiaTourBus();

            if (giatourBUS.themGiaTour(MaTour, DacDiem, TenTour, TenTour)) {
                return true;
            }
            return true;
        } else {
            System.out.println("Thêm thất bại");
            return false;
        }

    }
}
