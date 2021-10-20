/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ChiPhiDTO;
import DTO.NhanVienDTO;
import DTO.TourDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author minhk
 */
public class TourDAO {
    Connect conn;
    ArrayList<TourDTO> dsTour = new ArrayList<TourDTO>();

    public TourDAO() {
    }
    
    public ArrayList<TourDTO> getList(){
        conn = new Connect();
        conn.getConnection();
        String query = "select * from Tour";
        try {
            conn.executeQuery(query);
            while (conn.rs.next()) {
                TourDTO cp = new TourDTO();
                cp.setMaTour(conn.rs.getString(1));
                cp.setMaLoai(conn.rs.getString(2));
                cp.setTenTour(conn.rs.getString(3));
                cp.setDacDiem(conn.rs.getString(4));
                dsTour.add(cp);
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
        return dsTour;
    }

    public ArrayList<TourDTO> getDsTour() {
        return dsTour;
    }

    public void setDsTour(ArrayList<TourDTO> dsTour) {
        this.dsTour = dsTour;
    }
    
    public boolean insertTour(String MaTour, String MaLoai, String TenTour, String DacDiem){
        conn.getConnection();
        String query = "INSERT INTO Tour (MaTour,MaLoai,TenTour,DacDiem)"
                + " VALUE ('" + MaTour + "','" + MaLoai + "','" + TenTour + "','" + DacDiem + "')";
        if (conn.executeUpdate(query)){
            conn.close ();
            return true;
        }
        conn.close();
        return false;
    }
    
    public boolean updateTour(){
        // ...
        return false;
    }
    
    public boolean deleteTour(){
        // ...
        return false;
    }
}
