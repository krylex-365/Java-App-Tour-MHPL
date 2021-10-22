package BUS;

import DAO.GiaTourDAO;
import DAO.TourDAO;
import DTO.TourDTO;

import java.util.ArrayList;

public class TourBUS {

    private ArrayList<TourDTO> tourDTOs;
    private TourDAO tourDAO;

    public TourBUS() {
        tourDAO = new TourDAO();
        this.tourDTOs = tourDAO.getList();
    }

    public boolean suaTour(String maTour, String tenTour, String dacDiem, String maLoai, String maGia) {
        int indexTour = indexTour(maTour);
        if (indexTour == -1) {
            return false;
        }
        TourDTO tourDTO = new TourDTO(maTour, maLoai, tenTour, dacDiem);
        if (tourDAO.update(tourDTO)) {
            tourDTOs.set(indexTour, tourDTO);
            GiaTourBUS giaTourBUS = new GiaTourBUS();
            if (giaTourBUS.suaHienHanh(maGia, maTour)) {
                return true;
            }
        }
        return false;
    }

    private int indexTour(String maTour) {
        for (int i = 0; i < tourDTOs.size(); i++) {
            if (maTour.equals(tourDTOs.get(i).getMaTour())) {
                return i;
            }
        }
        return -1;
    }

    public ArrayList<TourDTO> getTourDTOS() {
        return tourDTOs;
    }

    public void setTourDTOS(ArrayList<TourDTO> tourDTOS) {
        this.tourDTOs = tourDTOS;
    }
}
