/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.NhanVienDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author minhk
 */
public class NhanVienDAO {
    Connect conn;
    

    public NhanVienDAO() {
        
    }
    
    public ArrayList<NhanVienDTO> getList(){
        ArrayList<NhanVienDTO> dsNhanVien = new ArrayList<NhanVienDTO>();
        conn = new Connect();
        conn.getConnection();
        String query = "select * from nhanvien where not MaNhanVien='admin'";
        try {
            conn.executeQuery(query);
            while (conn.rs.next()) {
                NhanVienDTO nv = new NhanVienDTO();
                nv.setMaNhanVien(conn.rs.getString(1));
                nv.setTenNhanVien(conn.rs.getString(2));
                nv.setSdt(conn.rs.getString(3));
                nv.setDiaChi(conn.rs.getString(4));
                dsNhanVien.add(nv);
            }
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("NhanVienDao.getList.executeQuery error.");
        }
        try{
        conn.getConn().close();
        }catch (SQLException e){
            System.out.println("NhanVienDao.getList.close error.");
        }
        return dsNhanVien;
    }
    
}
