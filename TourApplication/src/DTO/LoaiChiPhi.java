/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

public class LoaiChiPhi {
    private String MaLoaiChiPhi;
    private String TenLoai;

    public LoaiChiPhi() {
    }

    public LoaiChiPhi(String MaLoaiChiPhi, String TenLoai) {
        this.MaLoaiChiPhi = MaLoaiChiPhi;
        this.TenLoai = TenLoai;
    }

    public String getMaLoaiChiPhi() {
        return MaLoaiChiPhi;
    }

    public void setMaLoaiChiPhi(String MaLoaiChiPhi) {
        this.MaLoaiChiPhi = MaLoaiChiPhi;
    }

    public String getTenLoai() {
        return TenLoai;
    }

    public void setTenLoai(String TenLoai) {
        this.TenLoai = TenLoai;
    }
    
    
}
