/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.KhachHangDAO;
import DTO.KhachHangDTO;
import java.util.ArrayList;

/**
 *
 * @author minhk
 */
public class KhachHangBUS {
    private KhachHangDAO khachHangDAO;
    private ArrayList<KhachHangDTO> khachHangDTOs;
    private Utils utl = new Utils();

    public KhachHangBUS(KhachHangDAO khachHangDAO, ArrayList<KhachHangDTO> khachHangDTOs) {
        this.khachHangDAO = khachHangDAO;
        this.khachHangDTOs = khachHangDTOs;
    }
    
    public String CapPhat(String init) {
        System.out.println("- cap 1");
        init = utl.initMaKhachHang(init);
        System.out.println("- cap 2");
        return init;
    }

    public KhachHangBUS() {
        khachHangDAO = new KhachHangDAO();
        khachHangDTOs = khachHangDAO.getList();
    }

    public KhachHangDAO getKhachHangDAO() {
        return khachHangDAO;
    }

    public void setKhachHangDAO(KhachHangDAO khachHangDAO) {
        this.khachHangDAO = khachHangDAO;
    }

    public ArrayList<KhachHangDTO> getKhachHangDTOs() {
        return khachHangDTOs;
    }

    public void setKhachHangDTOs(ArrayList<KhachHangDTO> khachHangDTOs) {
        this.khachHangDTOs = khachHangDTOs;
    }
    
    public boolean addKhachHang(String maKhachHang,String tenKhachHang,String cmnd,String diaChi,String gioiTinh,String sdt,String mail,String quocTich){
        if(khachHangDAO.add(maKhachHang, tenKhachHang, cmnd, diaChi, gioiTinh, sdt, mail, quocTich)){
            khachHangDTOs.add(new KhachHangDTO(maKhachHang, tenKhachHang, cmnd, diaChi, gioiTinh, sdt, mail, quocTich));
        }
        return false;
    }
    
    public boolean deleteKhachHang(String maKhachHang){
        if(khachHangDAO.delete(maKhachHang)){
            for(int i = 0; i< khachHangDTOs.size();i++){
                if(khachHangDTOs.get(i).getMaKhachHang().equals(maKhachHang)){
                    khachHangDTOs.remove(i);
                    break;
                }                        
            }
        }
        return false;
    }
    
    public boolean updateKhachHang(String maKhachHang,String tenKhachHang,String cmnd,String diaChi,String gioiTinh,String sdt,String mail,String quocTich){
        if(khachHangDAO.update(maKhachHang, tenKhachHang, cmnd, diaChi, gioiTinh, sdt, mail, quocTich)){
            for(KhachHangDTO a: khachHangDTOs){
                if(a.getMaKhachHang().equals(maKhachHang)){
                    a.setMaKhachHang(maKhachHang);
                    a.setTenKhachHang(tenKhachHang);
                    a.setCMND(cmnd);
                    a.setDiaChi(diaChi);
                    a.setGioiTinh(gioiTinh);
                    a.setSDT(sdt);
                    a.setMail(mail);
                    a.setQuocTich(quocTich);
                }                        
            }
        }
        return false;
    }
    
    public static void main(String args[]){
        KhachHangBUS temp = new KhachHangBUS();
        //temp.addKhachHang("KH00003", "Nguyen Van A", "123456789", "TP.HCM", "nam", "0221546821", "hello@gmail.com", "VietName");
        //temp.updateKhachHang("KH00003", "Nguyen Van ABC", "123456789", "TP.HCM", "nam", "0221546821", "hello@gmail.com", "VietName");
        temp.deleteKhachHang("KH00003");
    }
}
