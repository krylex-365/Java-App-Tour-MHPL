package BUS;

import DAO.GiaTourDAO;
import DAO.TourDAO;
import DTO.TourDTO;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class TourBUS {

    private ArrayList<TourDTO> tourDTOs;
    private TourDAO tourDAO;
    private GiaTourBUS giaTourBUS;

    public TourBUS() {
        tourDAO = new TourDAO();
        this.tourDTOs = tourDAO.getList();
    }
    
    public boolean themTour(String MaTour, String MaLoai, String TenTour, String DacDiem, 
            String ThanhTien, String TgBatDau, String TgKetThuc) {
        for (TourDTO tour : tourDTOs) {
            if (tour.getMaTour().equals(MaTour)) {
                JOptionPane.showMessageDialog(null, "Mã tour" + tour.getMaTour() + " đã tồn tại!");
                return false;
            }
        }
        TourDTO newTour = new TourDTO(MaTour,MaLoai,TenTour,DacDiem);
        if (tourDAO.insertTour(newTour)) {
            tourDTOs.add(newTour);
            System.out.println("Thêm thành công themTourBUS");
            giaTourBUS = new GiaTourBUS();
            if (giaTourBUS.themGiaTour(MaTour, ThanhTien, TgBatDau, TgKetThuc)) {
                return true;
            }
        }
        System.out.println("Thêm thất bại themTourBUS");
        return false;
    }

    public boolean suaTour(String maTour, String tenTour, String dacDiem, String maLoai, String maGia) {
        int indexTour = indexTour(maTour);
        if (indexTour == -1) {
            return false;
        }
        TourDTO tourDTO = new TourDTO(maTour, maLoai, tenTour, dacDiem);
        if (tourDAO.updateTour(tourDTO)) {
            tourDTOs.set(indexTour, tourDTO);
            giaTourBUS = new GiaTourBUS();
            if (giaTourBUS.suaHienHanh(maGia, maTour)) {
                System.out.println("Sửa thành công suaTourBUS");
                return true;
            }
        }
        System.out.println("Sửa thất bại suaTourBUS");
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
