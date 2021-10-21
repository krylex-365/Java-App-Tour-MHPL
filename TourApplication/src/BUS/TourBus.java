/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DTO.TourDTO;
import DAO.TourDAO;
import DTO.GiaTourDTO;
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

    public boolean themTour(TourDTO tourDTO) {
        for (int i = 0; i < tourDAO.getList().size(); i++) {
            TourDTO tour = tourDAO.getList().get(i);
            if (tour.getMaTour().compareTo(tourDTO.getMaTour()) == 0) {
                JOptionPane.showMessageDialog(null, "Mã tour đã tồn tại -_-");
                return false;
            }
            tourDAO.insertTour(tourDTO.getMaTour(), tourDTO.getMaTour(), tourDTO.getTenTour(), tourDTO.getDacDiem());
            docDanhSachTour().add(tour);

            GiaTourDTO gtDTO = new GiaTourDTO();
            GiaTourBus giatourBUS = new GiaTourBus();
            if (tourDTO.getMaTour().equals(gtDTO.getMaTour())) {
                giatourBUS.themGiaTour(gtDTO);
            }

        }
        return true;

    }
}
