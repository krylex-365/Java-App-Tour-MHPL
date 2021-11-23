package BUS;

import DAO.GiaTourDAO;
import DAO.MaDuLieuCuoiDAO;
import DAO.TourDAO;
import DTO.DiaDiemThamQuanDTO;
import DTO.DoanDuLichDTO;
import DTO.GiaTourDTO;
import DTO.TourDTO;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class TourBUS {

    private TourDAO tourDAO;
    private GiaTourBUS giaTourBUS;
    private Utils utl = new Utils();
    private MaDuLieuCuoiDAO maLast = new MaDuLieuCuoiDAO();

    public TourBUS() {
        tourDAO = new TourDAO();
        giaTourBUS = new GiaTourBUS();
    }
    
    public String CapPhat(String init) {
        System.out.println("- cap 1");
        init = utl.initMaTour(init);
        System.out.println("- cap 2");
        return init;
    }
    
    public boolean themTour(String MaTour, String MaLoai, String TenTour, String DacDiem, 
            String ThanhTien, String TgBatDau, String TgKetThuc, 
            ArrayList<TourDTO> tourDTOs, ArrayList<GiaTourDTO> giaTourDTOs) {
        for (TourDTO tour : tourDTOs) {
            if (tour.getMaTour().equals(MaTour)) {
                JOptionPane.showMessageDialog(null, "Mã tour" + MaTour + " đã tồn tại!");
                return false;
            }
        }
        TourDTO newTour = new TourDTO(MaTour,MaLoai,TenTour,DacDiem);
        if (tourDAO.insertTour(newTour)) {
            if (giaTourBUS.themGiaTourByTour(MaTour, ThanhTien, TgBatDau, TgKetThuc, giaTourDTOs)) {
                tourDTOs.add(newTour);
                System.out.println("Thêm thành công themTourBUS");
                maLast.updateMaTour(MaTour);
                return true;
            }
        }
        System.out.println("Thêm thất bại themTourBUS");
        return false;
    }

    public boolean suaTour(String maTour, String tenTour, String dacDiem, String maLoaiHH, 
            String maLoai, String maGiaHH, String maGia,
            ArrayList<TourDTO> tourDTOs, ArrayList<GiaTourDTO> giaTourDTOs) {
        int indexTour = indexTour(maTour, tourDTOs);
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
            if (maGiaHH.equals(maGia)){
                return true;
            }
            if (giaTourBUS.suaHienHanh(maGia, maTour, giaTourDTOs)) {
                System.out.println("Sửa thành công suaTourBUS");
                return true;
            }
        }
        System.out.println("Sửa thất bại suaTourBUS");
        return false;
    }
    
    public boolean xoaTour(String maTour, ArrayList<TourDTO> tourDTOs, 
            ArrayList<GiaTourDTO> giaTourDTOs, ArrayList<DiaDiemThamQuanDTO> diaDiemThamQuanDTOs, ArrayList<DoanDuLichDTO> doanDuLichDTOs){
        DoanDuLichDTO doanDuLichDTO = new DoanDuLichBUS().getDoanDuLichByMaTour(maTour, doanDuLichDTOs);
        if(doanDuLichDTO == null) {
            if(tourDAO.deleteTour(maTour)){
                tourDTOs.remove(indexTour(maTour, tourDTOs));
                new DiaDiemThamQuanBUS().xoaDiaDiemThamQuanByMaTour(maTour, diaDiemThamQuanDTOs);
                new GiaTourBUS().xoaGiaTourByMaTour(maTour, giaTourDTOs);
                System.out.println("Xóa thành công xoaTourBUS");
                return true;
            }
        }
        System.out.println("Xóa thất bại xoaTourBUS");
        return false;
    }

    private int indexTour(String maTour, ArrayList<TourDTO> tourDTOs) {
        for (int i = 0; i < tourDTOs.size(); i++) {
            if (maTour.equals(tourDTOs.get(i).getMaTour())) {
                return i;
            }
        }
        return -1;
    }
}
