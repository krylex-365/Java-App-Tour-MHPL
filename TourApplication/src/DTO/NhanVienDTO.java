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
public class NhanVienDTO {
    private String maNhanVien;
    private String tenNhanVien;
    private String sdt;
    private String diaChi;

    public NhanVienDTO(String maNhanVien, String tenNhanVien, String sdt, String diaChi) {
        this.maNhanVien = maNhanVien;
        this.tenNhanVien = tenNhanVien;
        this.sdt = sdt;
        this.diaChi = diaChi;
    }

    public NhanVienDTO() {
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    @Override
    public String toString() {
        return "NhanVienDTO{" + "maNhanVien=" + maNhanVien + ", tenNhanVien=" + tenNhanVien + ", sdt=" + sdt + ", diaChi=" + diaChi + '}';
    }    
    
}
