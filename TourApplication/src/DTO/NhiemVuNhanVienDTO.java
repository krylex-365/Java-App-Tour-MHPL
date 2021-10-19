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
public class NhiemVuNhanVienDTO {
    private String maNhanVien;
    private String maDoan;
    private String tenNhiemVu;

    public NhiemVuNhanVienDTO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getMaDoan() {
        return maDoan;
    }

    public void setMaDoan(String maDoan) {
        this.maDoan = maDoan;
    }

    public String getTenNhiemVu() {
        return tenNhiemVu;
    }

    public void setTenNhiemVu(String tenNhiemVu) {
        this.tenNhiemVu = tenNhiemVu;
    }

    public NhiemVuNhanVienDTO(String maNhanVien, String maDoan, String tenNhiemVu) {
        this.maNhanVien = maNhanVien;
        this.maDoan = maDoan;
        this.tenNhiemVu = tenNhiemVu;
    }
}
