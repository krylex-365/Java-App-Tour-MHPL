/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ChiPhiDTO;
import DTO.KhachHangDTO;
import DTO.NhanVienDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author minhk
 */
public class KhachHangDAO {
    Connect conn;
    

    public KhachHangDAO() {
        
    }
    
    public ArrayList<KhachHangDTO> getList(){
        ArrayList<KhachHangDTO> dsKhachHang = new ArrayList<KhachHangDTO>();
        conn = new Connect();
        conn.getConnection();
        String query = "select * from KhachHang";
        try {
            conn.executeQuery(query);
            while (conn.rs.next()) {
                KhachHangDTO kh = new KhachHangDTO();
                kh.setMaKhachHang(conn.rs.getString(1));
                kh.setTenKhachHang(conn.rs.getString(2));
                kh.setCmnd(conn.rs.getString(3));
                kh.setDiaChi(conn.rs.getString(4));
                kh.setGioiTinh(conn.rs.getString(5));
                kh.setSdt(conn.rs.getString(6));
                kh.setMail(conn.rs.getString(7));
                kh.setQuocTich(conn.rs.getString(8));
                dsKhachHang.add(kh);
            }
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("ChiPhiDao.getList.executeQuery error.");
        }
        try{
        conn.getConn().close();
        }catch (SQLException e){
            System.out.println("ChiPhiDao.getList.close error.");
        }
        return dsKhachHang;
    }
    
}
