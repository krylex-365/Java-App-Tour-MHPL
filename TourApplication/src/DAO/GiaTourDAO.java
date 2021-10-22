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
                gt.setTgBatDau(conn.rs.getString(4));
                gt.setTgKetThuc(conn.rs.getString(5));
                gt.setHienHanh(conn.rs.getInt(6));
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

    public boolean insertGiaTour(String MaGia, String MaTour, String ThanhTien, String TgBatDau, String TgKetThuc, String HienHanh){
        conn.getConnection();
        String query = "INSERT INTO GiaTour (MaGia,MaTour,ThanhTien,TgBatDau,TgKetThuc,HienHanh)"
                + " VALUE ('" + MaGia + "','" + MaTour + "','" + ThanhTien + "','" + TgBatDau + "','" + TgKetThuc + "','" + HienHanh + "')";
        if (conn.executeUpdate(query)){
            conn.close ();
            return true;
        }
        conn.close();
        return false;
    }
    
    public boolean updateGiaTour(String maGia, String maTour) {
        //sua hien hanh thanh 1
        //cac bang co ma tour khac sua thanh 0
        String sql =    "UPDATE GiaTour     \n" +
                        "SET HienHanh = 0   \n" +
                        "WHERE MaTour = " + maTour + " and HienHanh = 1 ;\n" +
                        "UPDATE GiaTour     \n" +
                        "SET HienHanh = 1   \n" +
                        "WHERE MaGia = " + maGia + " and MaTour = " + maTour;

        conn = new Connect();
        conn.getConnection();
        if(conn.executeUpdate(sql)) return true;
        return false;
    }
}
