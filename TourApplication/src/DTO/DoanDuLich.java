/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

public class DoanDuLich {

    private String MaDoan;
    private String MaTour;
    private String TenDoan;
    private String GiaTout;
    private String NgayKhoiHanh;
    private String NgayKetThuc;
    private String ChiTietNoiDung;

    public DoanDuLich() {
    }

    public DoanDuLich(String MaDoan, String MaTour, String TenDoan, String GiaTout, String NgayKhoiHanh, String NgayKetThuc, String ChiTietNoiDung) {
        this.MaDoan = MaDoan;
        this.MaTour = MaTour;
        this.TenDoan = TenDoan;
        this.GiaTout = GiaTout;
        this.NgayKhoiHanh = NgayKhoiHanh;
        this.NgayKetThuc = NgayKetThuc;
        this.ChiTietNoiDung = ChiTietNoiDung;
    }

    public String getMaDoan() {
        return MaDoan;
    }

    public void setMaDoan(String MaDoan) {
        this.MaDoan = MaDoan;
    }

    public String getMaTour() {
        return MaTour;
    }

    public void setMaTour(String MaTour) {
        this.MaTour = MaTour;
    }

    public String getTenDoan() {
        return TenDoan;
    }

    public void setTenDoan(String TenDoan) {
        this.TenDoan = TenDoan;
    }

    public String getGiaTout() {
        return GiaTout;
    }

    public void setGiaTout(String GiaTout) {
        this.GiaTout = GiaTout;
    }

    public String getNgayKhoiHanh() {
        return NgayKhoiHanh;
    }

    public void setNgayKhoiHanh(String NgayKhoiHanh) {
        this.NgayKhoiHanh = NgayKhoiHanh;
    }

    public boolean setNgKhoiHanh(String NgayKhoiHanh) {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        formatter.setLenient(false);
        try {
            formatter.parse(NgayKhoiHanh);
            this.NgayKhoiHanh = NgayKhoiHanh;
            return true;
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Nhập ngày dang YYYY-MM-DD");
            return false;
        }
    }

    public String getNgayKetThuc() {
        return NgayKetThuc;
    }

    public void setNgayKetThuc(String NgayKetThuc) {
        this.NgayKetThuc = NgayKetThuc;
    }

    public boolean setNgNgayKetThuc(String NgayKetThuc) {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        formatter.setLenient(false);
        try {
            formatter.parse(NgayKetThuc);
            this.NgayKetThuc = NgayKetThuc;
            return true;
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Nhập ngày dang YYYY-MM-DD");
            return false;
        }
    }

    public String getChiTietNoiDung() {
        return ChiTietNoiDung;
    }

    public void setChiTietNoiDung(String ChiTietNoiDung) {
        this.ChiTietNoiDung = ChiTietNoiDung;
    }

}
