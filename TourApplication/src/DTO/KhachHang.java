/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import javax.swing.JOptionPane;

public class KhachHang {

    private String MaKhachHang;
    private String TenKhachHang;
    private String CMND;
    private String DiaChi;
    private String GioiTinh;
    private String SDT;
    private String Mail;
    private String QuocTich;

    public KhachHang() {
    }

    public KhachHang(String MaKhachHang, String TenKhachHang, String CMND, String DiaChi, String GioiTinh, String SDT, String Mail, String QuocTich) {
        this.MaKhachHang = MaKhachHang;
        this.TenKhachHang = TenKhachHang;
        this.CMND = CMND;
        this.DiaChi = DiaChi;
        this.GioiTinh = GioiTinh;
        this.SDT = SDT;
        this.Mail = Mail;
        this.QuocTich = QuocTich;
    }

    public String getMaKhachHang() {
        return MaKhachHang;
    }

    public void setMaKhachHang(String MaKhachHang) {
        this.MaKhachHang = MaKhachHang;
    }

    public String getTenKhachHang() {
        return TenKhachHang;
    }

    public void setTenKhachHang(String TenKhachHang) {
        this.TenKhachHang = TenKhachHang;
    }

    public boolean setTenKH(String Ten) {
        for (int i = 0; i < Ten.length(); i++) {
            if (Ten.substring(i, i + 1).matches("\\d")) {
                JOptionPane.showMessageDialog(null, "Tên không được chứa số");
                return false;
            }
        }

        this.TenKhachHang = TenKhachHang;
        return true;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String Mail) {
        this.Mail = Mail;
    }

    public String getQuocTich() {
        return QuocTich;
    }

    public void setQuocTich(String QuocTich) {
        this.QuocTich = QuocTich;
    }

}
