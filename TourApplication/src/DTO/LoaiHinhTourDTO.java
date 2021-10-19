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
public class LoaiHinhTourDTO {
    private String maLoai;
    private String tenLoai;

    public LoaiHinhTourDTO() {
    }

    public String getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public LoaiHinhTourDTO(String maLoai, String tenLoai) {
        this.maLoai = maLoai;
        this.tenLoai = tenLoai;
    }

    @Override
    public String toString() {
        return "LoaiHinhTourDTO{" + "maLoai=" + maLoai + ", tenLoai=" + tenLoai + '}';
    }
    
    
}
