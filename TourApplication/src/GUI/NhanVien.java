/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BUS.NhanVienBUS;
import DTO.KhachHangDTO;
import DTO.NhanVienDTO;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author minhk
 */
public class NhanVien {
    private NhanVienBUS nhanVienBUS;
    
    public NhanVien(){
        nhanVienBUS = new NhanVienBUS();
    }
    
    public void tbModelNhanVien(DefaultTableModel model){
        Vector row;
        for(NhanVienDTO a : nhanVienBUS.getNhanVienDTOs()){
            row = new Vector();
            row.add(a.getMaNhanVien());
            row.add(a.getTenNhanVien());
            if(a.getGioiTinh().equals("1")){
                row.add("Nam");
            }else{
                row.add("Nữ");
            }
            row.add(a.getNgaySinh());
            row.add(a.getSDT());
            row.add(a.getDiaChi());
            model.addRow(row);
        }
    }
    
    public boolean add(String maNhanVien,String tenNhanVien,String gioiTinh,String ngaySinh,String sdt,String diaChi){
        return nhanVienBUS.add(new NhanVienDTO(maNhanVien, tenNhanVien, gioiTinh, ngaySinh, sdt, diaChi));
    }
    
    public boolean update(String maNhanVien,String tenNhanVien,String gioiTinh,String ngaySinh,String sdt,String diaChi){
        return nhanVienBUS.update(new NhanVienDTO(maNhanVien, tenNhanVien, gioiTinh, ngaySinh, sdt, diaChi));
    }
    
    public boolean delete(String maNhanVien){
        return nhanVienBUS.delete(maNhanVien);
    }
    
    public void searchNhanVienByMaNhanVien(DefaultTableModel model,String maNhanVien){
        Vector row;
        for(NhanVienDTO a : nhanVienBUS.searchNhanVienByMaNhanVien(maNhanVien)){
                row = new Vector();
                System.out.println(a);
                row.add(a.getMaNhanVien());
                row.add(a.getTenNhanVien());
                if(a.getGioiTinh().equals("1")){
                    row.add("Nam");
                }else{
                    row.add("Nữ");
                }
                row.add(a.getNgaySinh());
                row.add(a.getSDT());
                row.add(a.getDiaChi());
                model.addRow(row);
                break;
        }  
    }
}
