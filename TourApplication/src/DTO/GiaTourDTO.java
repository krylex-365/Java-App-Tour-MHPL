/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author minhk
 */
public class GiaTourDTO {
    private String maGia;
    private String maTour;
    private String thanhTien;
    private String thoiGianBatDau;
    private String thoiGianKetThuc;

    public GiaTourDTO() {
    }

    public String getMaGia() {
        return maGia;
    }

    public void setMaGia(String giaTour) {
        this.maGia = giaTour;
    }

    public String getMaTour() {
        return maTour;
    }

    public void setMaTour(String maTour) {
        this.maTour = maTour;
    }

    public String getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(String thanhTien) {
        this.thanhTien = thanhTien;
    }

    public String getThoiGianBatDau() {
        return thoiGianBatDau;
    }

    public void setThoiGianBatDau(String thoiGianBatDau) {
        this.thoiGianBatDau = thoiGianBatDau;
    }

    public String getThoiGianKetThuc() {
        return thoiGianKetThuc;
    }

    public void setThoiGianKetThuc(String thoiGianKetThuc) {
        this.thoiGianKetThuc = thoiGianKetThuc;
    }

    public GiaTourDTO(String giaTour, String maTour, String thanhTien, String thoiGianBatDau, String thoiGianKetThuc) {
        this.maGia = giaTour;
        this.maTour = maTour;
        this.thanhTien = thanhTien;
        this.thoiGianBatDau = thoiGianBatDau;
        this.thoiGianKetThuc = thoiGianKetThuc;
    }

    @Override
    public String toString() {
        return "GiaTourDTO{" + "maGia=" + maGia + ", maTour=" + maTour + ", thanhTien=" + thanhTien + ", thoiGianBatDau=" + thoiGianBatDau + ", thoiGianKetThuc=" + thoiGianKetThuc + '}';
    }
    
    
}
