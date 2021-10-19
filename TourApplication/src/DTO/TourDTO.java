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
public class TourDTO {
    private String maTour;
    private String maLoai;
    private String tenTour;
    private String dacDiem;

    public TourDTO(String maTour, String maLoai, String tenTour, String dacDiem) {
        this.maTour = maTour;
        this.maLoai = maLoai;
        this.tenTour = tenTour;
        this.dacDiem = dacDiem;
    }

    public TourDTO() {
    }

    public String getMaTour() {
        return maTour;
    }

    public void setMaTour(String maTour) {
        this.maTour = maTour;
    }

    public String getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }

    public String getTenTour() {
        return tenTour;
    }

    public void setTenTour(String tenTour) {
        this.tenTour = tenTour;
    }

    public String getDacDiem() {
        return dacDiem;
    }

    public void setDacDiem(String dacDiem) {
        this.dacDiem = dacDiem;
    }

    @Override
    public String toString() {
        return "TourDTO{" + "maTour=" + maTour + ", maLoai=" + maLoai + ", tenTour=" + tenTour + ", dacDiem=" + dacDiem + '}';
    }
    
    
}
