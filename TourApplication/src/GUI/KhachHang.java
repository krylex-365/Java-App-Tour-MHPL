/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BUS.KhachHangBUS;
import BUS.Utils;
import DTO.KhachHangDTO;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author minhk
 */
public class KhachHang {
    private KhachHangBUS khachHangBUS;
    private Utils ult;

    public KhachHang() {
        khachHangBUS = new KhachHangBUS();
        ult = new Utils();
    }
    
    public void tbModelKhachHang(DefaultTableModel model){
        Vector row;
        for(KhachHangDTO a : khachHangBUS.getKhachHangDTOs()){
            row = new Vector();
            row.add(a.getMaKhachHang());
            row.add(a.getTenKhachHang());
            row.add(a.getNgaySinh());
            row.add(a.getSDT());
            row.add(a.getMail());
            row.add(a.getCMND());
            if(a.getGioiTinh().equals("1")){
                row.add("Nam");
            }else{
                row.add("Nữ");
            }
            
            row.add(a.getDiaChi());
            row.add(a.getQuocTich());
            model.addRow(row);
        }  
    }
    
    public boolean add(String maKhachHang,String tenKhachHang,String gioiTinh,String ngaySinh,String cmnd,String sdt,String mail,String diaChi,String quocTich){  
        return khachHangBUS.addKhachHang(new KhachHangDTO(maKhachHang,tenKhachHang,gioiTinh,ngaySinh,cmnd,sdt,mail,diaChi,quocTich));
    }
    
    public boolean update(String maKhachHang,String tenKhachHang,String gioiTinh,String ngaySinh,String cmnd,String sdt,String mail,String diaChi,String quocTich){
        return khachHangBUS.updateKhachHang(new KhachHangDTO(maKhachHang,tenKhachHang,gioiTinh,ngaySinh,cmnd,sdt,mail,diaChi,quocTich));
    }
    
    public boolean delete(String maKhachHang){
        return khachHangBUS.deleteKhachHang(maKhachHang);
    }
    
    public void searchKhachHangByMaKhachHang(DefaultTableModel model,String maKhachHang){
        Vector row;
        for(KhachHangDTO a : khachHangBUS.searchKhachHangByMaKhachHang(maKhachHang)){
                row = new Vector();
                System.out.println(a);
                row.add(a.getMaKhachHang());
                row.add(a.getTenKhachHang());
                row.add(a.getNgaySinh());
                row.add(a.getSDT());
                row.add(a.getMail());
                row.add(a.getCMND());
                if(a.getGioiTinh().equals("1")){
                    row.add("Nam");
                }else{
                    row.add("Nữ");
                }
                row.add(a.getDiaChi());
                row.add(a.getQuocTich());
                model.addRow(row);
                break;
        }  
    }
}
        
    
    

