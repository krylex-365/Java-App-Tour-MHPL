/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ChiPhiDTO;
import DTO.LoaiHinhTourDTO;
import DTO.NhanVienDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author minhk
 */
public class LoaiHinhTourDAO {
    Connect conn;
    

    public LoaiHinhTourDAO() {
        
    }
    
    public ArrayList<LoaiHinhTourDTO> getList(){
        ArrayList<LoaiHinhTourDTO> dsChiPhi = new ArrayList<LoaiHinhTourDTO>();
        conn = new Connect();
        conn.getConnection();
        String query = "select * from LoaiHinhTour where Status=1";
        try {
            conn.executeQuery(query);
            while (conn.rs.next()) {
                LoaiHinhTourDTO lhcp = new LoaiHinhTourDTO();
                lhcp.setMaLoai(conn.rs.getString(1));
                lhcp.setTenLoai(conn.rs.getString(2));
                dsChiPhi.add(lhcp);
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
