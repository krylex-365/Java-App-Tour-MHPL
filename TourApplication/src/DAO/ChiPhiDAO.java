/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ChiPhiDTO;
import DTO.NhanVienDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author minhk
 */
public class ChiPhiDAO {
    Connect conn;
    

    public ChiPhiDAO() {
        
    }
    
    public ArrayList<ChiPhiDTO> getList(){
        ArrayList<ChiPhiDTO> dsChiPhi = new ArrayList<ChiPhiDTO>();
        conn = new Connect();
        conn.getConnection();
        String query = "select * from ChiPhi";
        try {
            conn.executeQuery(query);
            while (conn.rs.next()) {
                ChiPhiDTO cp = new ChiPhiDTO();
                cp.setMaChiPhi(conn.rs.getString(1));
                cp.setMaDoan(conn.rs.getString(2));
                cp.setMaLoaiChiPhi(conn.rs.getString(3));
                cp.setSoTien(conn.rs.getString(4));
                cp.setGhiChu(conn.rs.getString(5));
                dsChiPhi.add(cp);
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
        return dsChiPhi;
    }
    
}
