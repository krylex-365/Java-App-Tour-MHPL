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
public class LoaiChiPhiDTO {
    private String maLoaiChiPhi;
    private String tenLoai;

    public LoaiChiPhiDTO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getMaLoaiChiPhi() {
        return maLoaiChiPhi;
    }

    public void setMaLoaiChiPhi(String maLoaiChiPhi) {
        this.maLoaiChiPhi = maLoaiChiPhi;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public LoaiChiPhiDTO(String maLoaiChiPhi, String tenLoai) {
        this.maLoaiChiPhi = maLoaiChiPhi;
        this.tenLoai = tenLoai;
    }
}
