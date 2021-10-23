/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.DiaDiemThamQuanBUS;
import BUS.DoanDuLichBUS;
import BUS.TourBUS;
import DTO.DiaDiemThamQuanDTO;
import DTO.DoanDuLichDTO;
import java.util.ArrayList;

/**
 *
 * @author minhk
 */
public class ChiTietTour {
    private TourBUS tourBUS;
    private DiaDiemThamQuanBUS diaDiemThamQuanBUS;
    private DoanDuLichBUS doanDuLichBUS;    

    public ChiTietTour(TourBUS tourBUS, DiaDiemThamQuanBUS diaDiemThamQuanBUS, DoanDuLichBUS doanDuLichBUS) {
        this.tourBUS = tourBUS;
        this.diaDiemThamQuanBUS = diaDiemThamQuanBUS;
        this.doanDuLichBUS = doanDuLichBUS;
    }

    public ChiTietTour() {
        tourBUS = new TourBUS();
        diaDiemThamQuanBUS = new DiaDiemThamQuanBUS();
        doanDuLichBUS = new DoanDuLichBUS();
    }
    
    //Phần này có thể không cần cũng đc có thể gọi trược tiếp từ các biến BUS trên nhưng phải thêm get,set cho biến BUS trên
    // |
    // |
    // V
    
    //          ĐỊA ĐIỂM THAM QUAN
    //tìm kiếm danh sách điểm du lịch dựa trên mã tour
    public ArrayList<DiaDiemThamQuanDTO> searchDiaDiemDuLichByMaTour(String maTour){
        return diaDiemThamQuanBUS.searchDiaDiemThamQuanByMaTour(maTour);
    }
    
    //          ĐOÀN DU LICH
    //tìm kiếm đoàn dựa trên mã đoàn
    public ArrayList<DoanDuLichDTO> searchDoanDuLichByMaDoan(String maDoan){
        return doanDuLichBUS.searchDoanDuLichByMaDoan(maDoan);
    }
    
    //tìm kiếm danh sách doàn du lịch dựa trên mã tour
    public ArrayList<DoanDuLichDTO> searchDoanDuLichByMaTour(String maTour){
        return doanDuLichBUS.searchDoanDuLichByMaDoan(maTour);
    }
    
    //
    
}
