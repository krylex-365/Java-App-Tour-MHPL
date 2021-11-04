/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ChiPhiDTO;
import DTO.DoanDuLichDTO;
import DTO.NhanVienDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author minhk
 */
public class DoanDuLichDAO {

    Connect conn;

    public DoanDuLichDAO() {

    }

    public ArrayList<DoanDuLichDTO> getList() {
        ArrayList<DoanDuLichDTO> dsChiPhi = new ArrayList<DoanDuLichDTO>();
        conn = new Connect();
        conn.getConnection();
        String query = "select * from DoanDuLich where Status=1";
        try {
            conn.executeQuery(query);
            while (conn.rs.next()) {
                DoanDuLichDTO ddl = new DoanDuLichDTO();
                ddl.setMaDoan(conn.rs.getString(1));
                ddl.setMaTour(conn.rs.getString(2));
                ddl.setTenDoan(conn.rs.getString(3));
                ddl.setGiaTour(conn.rs.getString(4));
                ddl.setNgayKhoiHanh(conn.rs.getString(5));
                ddl.setNgayKetThuc(conn.rs.getString(6));
                ddl.setChiTietNoiDung(conn.rs.getString(7));
                dsChiPhi.add(ddl);
            }
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("DoanDuLichDAO.getList.executeQuery error.");
        }
        try {
            conn.getConn().close();
        } catch (SQLException e) {
            System.out.println("DoanDuLichDAO.getList.close error.");
        }
        return dsChiPhi;
    }

    public boolean insertDoan(DoanDuLichDTO doanDuLichDTO) {
        conn = new Connect();
        conn.getConnection();
        String query = "INSERT INTO DoanDuLich"
                + " VALUES ('" + doanDuLichDTO.getMaDoan()
                + "','" + doanDuLichDTO.getMaTour()
                + "','" + doanDuLichDTO.getTenDoan()
                + "','" + doanDuLichDTO.getGiaTour()
                + "','" + doanDuLichDTO.getNgayKhoiHanh()
                + "','" + doanDuLichDTO.getNgayKetThuc()
                + "','" + doanDuLichDTO.getChiTietNoiDung()
                + "', 1);";
        if (conn.executeUpdate(query)) {
            conn.close();
            System.out.println("DoanDuLichDAO insert success.");
            return true;
        }
        conn.close();
        System.out.println("DoanDuLichDAO insert fail.");
        return false;
    }

    public boolean updateDoan(DoanDuLichDTO tourDTO, boolean checkTour) {
        conn = new Connect();
        conn.getConnection();
        String sql;
        if (checkTour) {
            sql = "UPDATE DoanDuLich SET"
                    + " TenDoan='" + tourDTO.getTenDoan() + "',"
                    + " ChiTietNoiDung='" + tourDTO.getChiTietNoiDung() + "',"
                    + " MaTour='" + tourDTO.getMaTour() + "'"
                    + " WHERE MaDoan='" + tourDTO.getMaDoan() + "';";
        } else {
            sql = "UPDATE DoanDuLich SET"
                    + " TenDoan='" + tourDTO.getTenDoan() + "',"
                    + " ChiTietNoiDung='" + tourDTO.getChiTietNoiDung() + "',"
                    + " WHERE MaDoan='" + tourDTO.getMaDoan() + "';";
        }
        if (conn.executeUpdate(sql)) {
            conn.close();
            System.out.println("DoanDuLichDAO update success.");
            return true;
        }
        conn.close();
        System.out.println("DoanDuLichDAO update fail.");
        return false;
    }

    public boolean deleteDoan(String maDoan) {
        String sql = "update DoanDuLich "
                + "set Status=0 "
                + "where MaDoan='" + maDoan + "'";
        conn = new Connect();
        conn.getConnection();
        if (conn.executeUpdate(sql)) {
            conn.close();
            System.out.println("DoanDuLich delete success.");
            return true;
        }
        conn.close();
        System.out.println("DoanDuLich delete fail.");
        return false;
    }

//    public static void main(String[] args) {
//        DoanDuLichDAO doanDAO = new DoanDuLichDAO();
//        ArrayList<DoanDuLichDTO> test = new ArrayList<DoanDuLichDTO>();
//        test = doanDAO.getList();
//        System.out.println(test);
//    }
}
