/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author User
 */
public class ChiPhiDTO {
    private String maChiPhi;
    private String maDoan;
    private String loaiChiPhi;
    private float soTien;
    private String ghiChu;

    public ChiPhiDTO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getMaChiPhi() {
        return maChiPhi;
    }

    public void setMaChiPhi(String maChiPhi) {
        this.maChiPhi = maChiPhi;
    }

    public String getMaDoan() {
        return maDoan;
    }

    public void setMaDoan(String maDoan) {
        this.maDoan = maDoan;
    }

    public String getLoaiChiPhi() {
        return loaiChiPhi;
    }

    public void setLoaiChiPhi(String loaiChiPhi) {
        this.loaiChiPhi = loaiChiPhi;
    }

    public float getSoTien() {
        return soTien;
    }

    public void setSoTien(float soTien) {
        this.soTien = soTien;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public ChiPhiDTO(String maChiPhi, String maDoan, String loaiChiPhi, float soTien, String ghiChu) {
        this.maChiPhi = maChiPhi;
        this.maDoan = maDoan;
        this.loaiChiPhi = loaiChiPhi;
        this.soTien = soTien;
        this.ghiChu = ghiChu;
    }
    
    
    
}
