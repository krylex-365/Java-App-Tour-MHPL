package BUS;

import DAO.GiaTourDAO;
import DAO.MaDuLieuCuoiDAO;
import DAO.TourDAO;
import DTO.DoanDuLichDTO;
import DTO.TourDTO;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class TourBUS {

    private ArrayList<TourDTO> tourDTOs;
    private TourDAO tourDAO;
    private GiaTourBUS giaTourBUS;
    private Utils utl = new Utils();
    private MaDuLieuCuoiDAO maLast = new MaDuLieuCuoiDAO();

    public TourBUS() {
        tourDAO = new TourDAO();
        this.tourDTOs = tourDAO.getList();
    }
    
    public String CapPhat(String init) {
        System.out.println("- cap 1");
        init = utl.initMaTour(init);
        System.out.println("- cap 2");
        return init;
    }
    
    public boolean themTour(String MaTour, String MaLoai, String TenTour, String DacDiem, 
            String ThanhTien, String TgBatDau, String TgKetThuc) {
        for (TourDTO tour : tourDTOs) {
            if (tour.getMaTour().equals(MaTour)) {
                JOptionPane.showMessageDialog(null, "Mã tour" + MaTour + " đã tồn tại!");
                return false;
            }
        }
        TourDTO newTour = new TourDTO(MaTour,MaLoai,TenTour,DacDiem);
        if (tourDAO.insertTour(newTour)) {
            tourDTOs.add(newTour);
            System.out.println("Thêm thành công themTourBUS");
            maLast.updateMaTour(MaTour);
            giaTourBUS = new GiaTourBUS();
            if (giaTourBUS.themGiaTourByTour(MaTour, ThanhTien, TgBatDau, TgKetThuc)) {
                return true;
            }
        }
        System.out.println("Thêm thất bại themTourBUS");
        return false;
    }

    public boolean suaTour(String maTour, String tenTour, String dacDiem, String maLoaiHH, 
            String maLoai, String maGiaHH, String maGia) {
        int indexTour = indexTour(maTour);
        if (indexTour == -1) {
            return false;
        }
        TourDTO tourDTO = tourDTO = new TourDTO(maTour, maLoai, tenTour, dacDiem);
        boolean checkLH;
        if (maLoaiHH.equals(maLoai)){
            // NẾU KHÔNG SỬA LOẠI HÌNH
            checkLH = false;
        } else {
            // NẾU SỬA LOẠI HÌNH
            checkLH = true;
        }
        if (tourDAO.updateTour(tourDTO, checkLH)) {
            tourDTOs.set(indexTour, tourDTO);
            giaTourBUS = new GiaTourBUS();
            if (maGiaHH.equals(maGia)){
                return true;
            }
            if (giaTourBUS.suaHienHanh(maGia, maTour)) {
                System.out.println("Sửa thành công suaTourBUS");
                return true;
            }
        }
        System.out.println("Sửa thất bại suaTourBUS");
        return false;
    }
    
    public boolean xoaTour(String maTour){
        DoanDuLichDTO doanDuLichDTO = new DoanDuLichBUS().getDoanDuLichByMaTour(maTour);
        if(doanDuLichDTO == null) {
            if(tourDAO.xoaTour(maTour)){
                tourDTOs.remove(indexTour(maTour));
                new DiaDiemThamQuanBUS().xoaDiaDiemThamQuanByMaTour(maTour);
                new GiaTourBUS().xoaGiaTourByMaTour(maTour);
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
