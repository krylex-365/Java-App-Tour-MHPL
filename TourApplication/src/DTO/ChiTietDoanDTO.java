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
public class ChiTietDoanDTO {
    private String maDoan;
    private String maKhachHang;

    public ChiTietDoanDTO(String maDoan, String maKhachHang) {
        this.maDoan = maDoan;
        this.maKhachHang = maKhachHang;
    }
    
    public ChiTietDoanDTO() {
    }

    public String getMaDoan() {
        return maDoan;
    }

    @Override
    public String toString() {
        return "ChiTietDoanDTO{" + "maDoan=" + maDoan + ", maKhachHang=" + maKhachHang + '}';
    }

    public void setMaDoan(String maDoan) {
        this.maDoan = maDoan;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }
    
}
