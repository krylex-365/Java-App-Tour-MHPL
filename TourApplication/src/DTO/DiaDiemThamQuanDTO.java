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
public class DiaDiemThamQuanDTO {
    private String maTour;
    private String maDiaDiem;
    private String thuTu;

    public DiaDiemThamQuanDTO() {
    }

    public String getMaTour() {
        return maTour;
    }

    public void setMaTour(String maTour) {
        this.maTour = maTour;
    }

    public String getMaDiaDiem() {
        return maDiaDiem;
    }

    public void setMaDiaDiem(String maDiaDiem) {
        this.maDiaDiem = maDiaDiem;
    }

    public String getThuTu() {
        return thuTu;
    }

    public void setThuTu(String thuTu) {
        this.thuTu = thuTu;
    }

    public DiaDiemThamQuanDTO(String maTour, String maDiaDiem, String thuTu) {
        this.maTour = maTour;
        this.maDiaDiem = maDiaDiem;
        this.thuTu = thuTu;
    }

    @Override
    public String toString() {
        return "DiaDiemThamQuanDTO{" + "maTour=" + maTour + ", maDiaDiem=" + maDiaDiem + ", thuTu=" + thuTu + '}';
    }
    
}
