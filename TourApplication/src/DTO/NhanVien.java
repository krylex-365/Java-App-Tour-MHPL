/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import javax.swing.JOptionPane;

public class NhanVien {

    private String MaNhanVien;
    private String TenNhanVien;
    private String SDT;
    private String DiaChi;

    public NhanVien() {
    }

    public NhanVien(String MaNhanVien, String TenNhanVien, String SDT, String DiaChi) {
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

    public boolean setTenNV(String Ten) {
        for (int i = 0; i < Ten.length(); i++) {
            if (Ten.substring(i, i + 1).matches("\\d")) {
                JOptionPane.showMessageDialog(null, "Tên không được chứa số");
                return false;
            }
        }

        this.TenNhanVien = TenNhanVien;
        return true;
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

}
