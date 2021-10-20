/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ChiPhiDTO;
import DTO.GiaTourDTO;
import DTO.NhanVienDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author minhk
 */
public class GiaTourDAO {
    Connect conn;
    

    public GiaTourDAO() {
        
    }
    
    public ArrayList<GiaTourDTO> getList(){
        ArrayList<GiaTourDTO> dsGiaTour = new ArrayList<GiaTourDTO>();
        conn = new Connect();
        conn.getConnection();
        String query = "select * from GiaTour";
        try {
            conn.executeQuery(query);
            while (conn.rs.next()) {
                GiaTourDTO gt = new GiaTourDTO();
                gt.setMaGia(conn.rs.getString(1));
                gt.setMaTour(conn.rs.getString(2));
                gt.setThanhTien(conn.rs.getString(3));
                gt.setThoiGianBatDau(conn.rs.getString(4));
                gt.setThoiGianKetThuc(conn.rs.getString(5));
                dsGiaTour.add(gt);
            }
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("GiaTourDAO.getList.executeQuery error.");
        }
        try{
        conn.getConn().close();
        }catch (SQLException e){
            System.out.println("GiaTourDAO.getList.close error.");
        }
        return dsGiaTour;
    }
    
}