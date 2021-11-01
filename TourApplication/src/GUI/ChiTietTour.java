/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

//import BUS.ChiTietDoanBUS;
import BUS.ChiTietDoanBUS;
import BUS.DiaDiemThamQuanBUS;
import BUS.DoanDuLichBUS;
import BUS.DiaDiemBUS;
import DTO.DiaDiemDTO;
import DTO.DiaDiemThamQuanDTO;
import DTO.DoanDuLichDTO;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author minhk
 */
public class ChiTietTour {
//    ChiTietDoanBUS chiTietDoanBUS;
    DoanDuLichBUS doanDuLichBUS;
    DiaDiemThamQuanBUS diaDiemThamQuanBUS;
    DiaDiemBUS diaDiemBUS;
    ChiTietDoanBUS chiTietDoanBUS;

    public ChiTietTour() {
//        chiTietDoanBUS = new ChiTietDoanBUS();
        doanDuLichBUS = new DoanDuLichBUS();
        diaDiemThamQuanBUS = new DiaDiemThamQuanBUS();
        diaDiemBUS = new DiaDiemBUS();
    }
    
    public void tbModelDiaDiemThamQuan(DefaultTableModel model,String maTour){
        Vector row;
        for(DiaDiemThamQuanDTO a : diaDiemThamQuanBUS.searchDiaDiemThamQuanByMaTour(maTour)){
            row = new Vector();
            row.add(a.getMaDiaDiem());
            row.add(diaDiemBUS.searchTenDiaDiemByMaDiaDiem(a.getMaDiaDiem()));
            row.add(a.getThuTu());
            model.addRow(row);
        }
    }
    
    public void tbModelDoanDuLich(DefaultTableModel model,String maTour){
        Vector row;
        //System.out.println("ChiTietTour");
        for(DoanDuLichDTO a : doanDuLichBUS.searchDoanDuLichByMaTour(maTour)){
            row = new Vector();
            row.add(a.getMaDoan());
            row.add(a.getTenDoan());
            row.add(a.getGiaTour());
            row.add(a.getNgayKhoiHanh());
            row.add(a.getNgayKetThuc());
            System.out.println(a);
//            row.add(chiTietDoanBUS.peopleCount(a.getMaDoan()));
            row.add(chiTietDoanBUS.peopleCountByMaDoan(a.getMaDoan()));
            model.addRow(row);
        }
    }

    public void tbModelSearchDoanDuLich(DefaultTableModel model,String maDoan){
        Vector row = new Vector();
        for(DoanDuLichDTO a : doanDuLichBUS.searchDoanDuLichByMaDoan(maDoan)){
            row.add(a.getMaDoan());
            row.add(a.getTenDoan());
            row.add(a.getGiaTour());
            row.add(a.getNgayKhoiHanh());
            row.add(a.getNgayKetThuc());
//            row.add(chiTietDoanBUS.peopleCount(a.getMaDoan()));
            row.add(doanDuLichBUS.soKhach(a.getMaDoan()));
            model.addRow(row);
        }
    }    
    
    public void tbModelDiaDiem(DefaultTableModel model){
        Vector row;
        for(DiaDiemDTO a : diaDiemBUS.getDiaDiemDTOs()){
            row = new Vector();
            row.add(a.getMaDiaDiem());
            row.add(a.getTenDiaDiem());
            model.addRow(row);
        }
    }

    public void tbModelSearchDiaDiemByMaDiaDiem(DefaultTableModel model,String maDiaDiem){
        Vector row;
        for(DiaDiemDTO a : diaDiemBUS.searchListDiaDiemByMaDiaDiem(maDiaDiem)){
            row = new Vector();
            row.add(a.getMaDiaDiem());
            row.add(a.getTenDiaDiem());
            model.addRow(row);
        }
    }

    public ArrayList<DiaDiemThamQuanDTO> DiaDiemThamQuanDTOs(){
        return diaDiemThamQuanBUS.getDiaDiemThamQuanDTOs();
    }

    public int countDoanTrongTour(String maTour){
        return doanDuLichBUS.countDoanTrongTour(maTour);
    }

    public boolean checkDuplicateThuTu(String maTour,int num){
        return diaDiemThamQuanBUS.checkDuplicateThuTu(maTour,num);
    }

    public boolean addDiaDiemThamQuan(String maTour,String maDiaDiem,int thuTu){
        return diaDiemThamQuanBUS.addDiaDiemThamQuan(maTour, maDiaDiem, thuTu);

    }

    public boolean deleteDiaDiemThamQuan(String maTour,String maDiaDiem,int thuTu){
        return diaDiemThamQuanBUS.deleteDiaDiemThamQuan(maTour, maDiaDiem, thuTu);
    }

    public boolean updateDiaDiemThamQuan(String maTour,String maDiaDiem,int thuTu,int newThuTu){
        return diaDiemThamQuanBUS.updateDiaDiemThamQuan(maTour, maDiaDiem, thuTu, newThuTu);
    }
}