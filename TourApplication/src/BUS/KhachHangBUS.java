/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.KhachHangDAO;
import DAO.MaDuLieuCuoiDAO;
import DTO.KhachHangDTO;
import java.util.ArrayList;

/**
 *
 * @author minhk
 */
public class KhachHangBUS {
    private KhachHangDAO khachHangDAO;
    //private ArrayList<KhachHangDTO> khachHangDTOs;
    private Utils utl = new Utils();
    private MaDuLieuCuoiDAO maLast = new MaDuLieuCuoiDAO();

    public KhachHangBUS(KhachHangDAO khachHangDAO, ArrayList<KhachHangDTO> khachHangDTOs) {
        this.khachHangDAO = khachHangDAO;
        //this.khachHangDTOs = khachHangDTOs;
    }
    
    public String CapPhat() {
        System.out.println("- cap 1");
        System.out.println("- cap 2");
        return utl.initMaKhachHang();
    }

    public KhachHangBUS() {
        khachHangDAO = new KhachHangDAO();
       //khachHangDTOs = khachHangDAO.getList();
    }

    public KhachHangDAO getKhachHangDAO() {
        return khachHangDAO;
    }

    public void setKhachHangDAO(KhachHangDAO khachHangDAO) {
        this.khachHangDAO = khachHangDAO;
    }

//    public ArrayList<KhachHangDTO> getKhachHangDTOs() {
//        return khachHangDTOs;
//    }

//    public void setKhachHangDTOs(ArrayList<KhachHangDTO> khachHangDTOs) {
//        this.khachHangDTOs = khachHangDTOs;
//    }
    
    public boolean addKhachHang(KhachHangDTO khachHang,ArrayList<KhachHangDTO> khachHangDTOs){
        for(KhachHangDTO a  : khachHangDTOs)
            if(a.getMaKhachHang().equals(khachHang.getMaKhachHang()))return false;

        if(khachHangDAO.add(khachHang)){
            // NHỚ SỬA LẠI
            khachHangDTOs.add(khachHang);
            maLast.updateMaKhach(khachHang.getMaKhachHang());
            return true;
        }
        return false;
    }
    
    public boolean deleteKhachHang(String maKhachHang,ArrayList<KhachHangDTO> khachHangDTOs){
        if(khachHangDAO.delete(maKhachHang)){
            for(int i = 0; i< khachHangDTOs.size();i++){
                if(khachHangDTOs.get(i).getMaKhachHang().equals(maKhachHang)){
                    khachHangDTOs.remove(i);
                    return true;
                }                        
            }
        }
        return false;
    }
    
    public ArrayList<KhachHangDTO> searchKhachHangByMaKhachHang(String maKhachHang,ArrayList<KhachHangDTO> khachHangDTOs){
        ArrayList<KhachHangDTO> result = new ArrayList<>();
        for(KhachHangDTO a : khachHangDTOs){
            if(a.getMaKhachHang().equals(maKhachHang))result.add(a);
        }
        return result;
    }
    
    public boolean updateKhachHang(KhachHangDTO khachHang,ArrayList<KhachHangDTO> khachHangDTOs){
        if(khachHangDAO.update(khachHang)){
            for(KhachHangDTO a: khachHangDTOs){
                if(a.getMaKhachHang().equals(khachHang.getMaKhachHang())){
                    //a.setMaKhachHang(maKhachHang);
                    a.setTenKhachHang(khachHang.getTenKhachHang());
                    a.setCMND(khachHang.getCMND());
                    a.setDiaChi(khachHang.getDiaChi());
                    a.setGioiTinh(khachHang.getGioiTinh());
                    a.setSDT(khachHang.getSDT());
                    a.setMail(khachHang.getMail());
                    a.setQuocTich(khachHang.getQuocTich());
                    a.setNgaySinh(khachHang.getNgaySinh());
                }                        
            }
            return true;
        }
        return false;
    }
    
//    public static void main(String args[]){
//        KhachHangBUS temp = new KhachHangBUS();
//        //temp.addKhachHang("KH00003", "Nguyen Van A", "123456789", "TP.HCM", "nam", "0221546821", "hello@gmail.com", "VietName");
//        //temp.updateKhachHang("KH00003", "Nguyen Van ABC", "123456789", "TP.HCM", "nam", "0221546821", "hello@gmail.com", "VietName");
//        temp.deleteKhachHang("KH00003");
//    }
}
