/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import javax.swing.JOptionPane;

public class NhanVienDTO {

    private String MaNhanVien;
    private String TenNhanVien;
    private String SDT;
    private String DiaChi;

    public NhanVienDTO() {
    }

    public NhanVienDTO(String MaNhanVien, String TenNhanVien, String SDT, String DiaChi) {
        this.MaNhanVien = MaNhanVien;
        this.TenNhanVien = TenNhanVien;
        this.SDT = SDT;
        this.DiaChi = DiaChi;
    }

    public String getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(String MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    public String getTenNhanVien() {
        return TenNhanVien;
    }

    public void setTenNhanVien(String TenNhanVien) {
        this.TenNhanVien = TenNhanVien;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    @Override
    public String toString() {
        return "NhanVienDTO{" + "MaNhanVien=" + MaNhanVien + ", TenNhanVien=" + TenNhanVien + ", SDT=" + SDT + ", DiaChi=" + DiaChi + '}';
    } 
}
