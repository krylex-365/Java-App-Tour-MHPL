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
public class DoanDuLichDTO {
    private String maDoan;
    private String maTour;
    private String tenDoan;
    private float giaTour;
    private String ngayKhoiHanh;
    private String ngayKetThuc;
    private String chiTietNoiDung;

    public DoanDuLichDTO(String maDoan, String maTour, String tenDoan, float giaTour, String ngayKhoiHanh, String ngayKetThuc, String chiTietNoiDung) {
        this.maDoan = maDoan;
        this.maTour = maTour;
        this.tenDoan = tenDoan;
        this.giaTour = giaTour;
        this.ngayKhoiHanh = ngayKhoiHanh;
        this.ngayKetThuc = ngayKetThuc;
        this.chiTietNoiDung = chiTietNoiDung;
    }

    public DoanDuLichDTO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getMaDoan() {
        return maDoan;
    }

    public void setMaDoan(String maDoan) {
        this.maDoan = maDoan;
    }

    public String getMaTour() {
        return maTour;
    }

    public void setMaTour(String maTour) {
        this.maTour = maTour;
    }

    public String getTenDoan() {
        return tenDoan;
    }

    public void setTenDoan(String tenDoan) {
        this.tenDoan = tenDoan;
    }

    public float getGiaTour() {
        return giaTour;
    }

    public void setGiaTour(float giaTour) {
        this.giaTour = giaTour;
    }

    public String getNgayKhoiHanh() {
        return ngayKhoiHanh;
    }

    public void setNgayKhoiHanh(String ngayKhoiHanh) {
        this.ngayKhoiHanh = ngayKhoiHanh;
    }

    public String getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(String ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getChiTietNoiDung() {
        return chiTietNoiDung;
    }

    public void setChiTietNoiDung(String chiTietNoiDung) {
        this.chiTietNoiDung = chiTietNoiDung;
    }
    
}
