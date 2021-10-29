/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.SQLException;
/**
 *
 * @author User
 */
public class MaDuLieuCuoiDAO {
    public String MaLoaiLast;
    public String MaTourLast;
    public String MaGiaLast;
    public String MaDiaDiemLast;
    public String MaDoanLast;
    public String MaKhachHangLast;
    public String MaChiPhiLast;
    public String MaLoaiChiPhiLast;
    public String MaNhanVienLast;
    Connect conn;

    public MaDuLieuCuoiDAO() {
        getLastData();
    }
    
    public void getLastData() {
        conn = new Connect();
        conn.getConnection();
        String query = "select * from MaDuLieuCuoi";
        try {
            conn.executeQuery(query);
            while (conn.rs.next()) {
                setMaLoaiLast(conn.rs.getString(1));
                setMaTourLast(conn.rs.getString(2));
                setMaGiaLast(conn.rs.getString(3));
                setMaDiaDiemLast(conn.rs.getString(4));
                setMaDoanLast(conn.rs.getString(5));
                setMaKhachHangLast(conn.rs.getString(6));
                setMaChiPhiLast(conn.rs.getString(7));
                setMaLoaiChiPhiLast(conn.rs.getString(8));
                setMaNhanVienLast(conn.rs.getString(9));
            }
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("DuLieuLast.executeQuery error.");
        }
        try {
            conn.getConn().close();
        } catch (SQLException e) {
            System.out.println("DuLieuLast.close error.");
        }
    }
    
    public boolean updateMaTour(String newLatestMaTour){
        conn = new Connect();
        conn.getConnection();
        String query = "UPDATE MaDuLieuCuoi SET"
                    + " MaTour='"+newLatestMaTour+"'"
                    + " WHERE MaTour='"+getMaTourLast()+"'";
        if (conn.executeUpdate(query)) {
            System.out.println("Update last MaTour success.");
            setMaTourLast(newLatestMaTour);
            conn.close();
            return true;
        }
        System.out.println("Update last MaTour fail.");
        conn.close();
        return false;
    }
    
    public boolean updateMaGia(String newLatestMaGia){
        conn = new Connect();
        conn.getConnection();
        String query = "UPDATE MaDuLieuCuoi SET"
                    + " MaGia='"+newLatestMaGia+"'"
                    + " WHERE MaGia='"+getMaGiaLast()+"'";
        if (conn.executeUpdate(query)) {
            System.out.println("Update last MaGia success.");
            setMaGiaLast(newLatestMaGia);
            conn.close();
            return true;
        }
        System.out.println("Update last MaGia fail.");
        conn.close();
        return false;
    }
    
    public boolean updateMaLoai(String newLatestMaLoai) {
        conn = new Connect();
        conn.getConnection();
        String query = "UPDATE MaDuLieuCuoi SET"
                + " MaLoai='" + newLatestMaLoai + "'"
                + " WHERE MaLoai='" + getMaLoaiLast() + "'";
        if (conn.executeUpdate(query)) {
            System.out.println("Update last MaLoai success.");
            setMaLoaiLast(newLatestMaLoai);
            conn.close();
            return true;
        }
        System.out.println("Update last MaLoai fail.");
        conn.close();
        return false;
    }


    public boolean updateMaDiaDiem(String newLatestDiaDiem) {
        conn = new Connect();
        conn.getConnection();
        String query = "UPDATE MaDuLieuCuoi SET"
                + " MaDiaDiem='"+newLatestDiaDiem+"'"
                + " WHERE MaDiaDiem='"+getMaDiaDiemLast()+"'";
        if (conn.executeUpdate(query)) {
            System.out.println("Update last MaGia success.");
            setMaDiaDiemLast(newLatestDiaDiem);
            conn.close();
            return true;
        }
        System.out.println("Update last MaGia fail.");
        conn.close();
        return false;
    }

    public String getMaLoaiLast() {
        return MaLoaiLast;
    }

    public void setMaLoaiLast(String MaLoaiLast) {
        this.MaLoaiLast = MaLoaiLast;
    }

    public String getMaTourLast() {
        return MaTourLast;
    }

    public void setMaTourLast(String MaTourLast) {
        this.MaTourLast = MaTourLast;
    }

    public String getMaGiaLast() {
        return MaGiaLast;
    }

    public void setMaGiaLast(String MaGiaLast) {
        this.MaGiaLast = MaGiaLast;
    }

    public String getMaDiaDiemLast() {
        return MaDiaDiemLast;
    }

    public void setMaDiaDiemLast(String MaDiaDiemLast) {
        this.MaDiaDiemLast = MaDiaDiemLast;
    }

    public String getMaDoanLast() {
        return MaDoanLast;
    }

    public void setMaDoanLast(String MaDoanLast) {
        this.MaDoanLast = MaDoanLast;
    }

    public String getMaKhachHangLast() {
        return MaKhachHangLast;
    }

    public void setMaKhachHangLast(String MaKhachHangLast) {
        this.MaKhachHangLast = MaKhachHangLast;
    }

    public String getMaChiPhiLast() {
        return MaChiPhiLast;
    }

    public void setMaChiPhiLast(String MaChiPhiLast) {
        this.MaChiPhiLast = MaChiPhiLast;
    }

    public String getMaLoaiChiPhiLast() {
        return MaLoaiChiPhiLast;
    }

    public void setMaLoaiChiPhiLast(String MaLoaiChiPhiLast) {
        this.MaLoaiChiPhiLast = MaLoaiChiPhiLast;
    }

    public String getMaNhanVienLast() {
        return MaNhanVienLast;
    }

    public void setMaNhanVienLast(String MaNhanVienLast) {
        this.MaNhanVienLast = MaNhanVienLast;
    }


}
