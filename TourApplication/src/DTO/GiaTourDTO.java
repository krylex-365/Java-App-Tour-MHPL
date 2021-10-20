/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;


public class GiaTourDTO {
    private String MaGia;
    private String MaTour;
    private String ThanhTien;
    private String TgBatDau;
    private String TgKetThuc;

    public GiaTourDTO() {
    }

    public GiaTourDTO(String MaGia, String MaTour, String ThanhTien, String TgBatDau, String TgKetThuc) {
        this.MaGia = MaGia;
        this.MaTour = MaTour;
        this.ThanhTien = ThanhTien;
        this.TgBatDau = TgBatDau;
        this.TgKetThuc = TgKetThuc;
    }

    public String getMaGia() {
        return MaGia;
    }

    public void setMaGia(String MaGia) {
        this.MaGia = MaGia;
    }

    public String getMaTour() {
        return MaTour;
    }

    public void setMaTour(String MaTour) {
        this.MaTour = MaTour;
    }

    public String getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(String ThanhTien) {
        this.ThanhTien = ThanhTien;
    }

    public String getTgBatDau() {
        return TgBatDau;
    }

    public void setTgBatDau(String TgBatDau) {
        this.TgBatDau = TgBatDau;
    }

    public String getTgKetThuc() {
        return TgKetThuc;
    }

    public void setTgKetThuc(String TgKetThuc) {
        this.TgKetThuc = TgKetThuc;
    }
    
    @Override
    public String toString() {
        return "GiaTourDTO{" + "MaGia=" + MaGia + ", MaTour=" + MaTour + ", ThanhTien=" + ThanhTien + ", ThoiGianBatDau=" + TgBatDau + ", ThoiGianKetThuc=" + TgKetThuc + '}';
    }
}
