/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ChiPhiDTO;
import DTO.LoaiChiPhiDTO;
import DTO.NhanVienDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author minhk
 */
public class LoaiChiPhiDAO {
    Connect conn;
    

    public LoaiChiPhiDAO() {
        
    }
    
    public ArrayList<LoaiChiPhiDTO> getList(){
        ArrayList<LoaiChiPhiDTO> dsLoaiChiPhi = new ArrayList<LoaiChiPhiDTO>();
        conn = new Connect();
        conn.getConnection();
        String query = "select * from LoaiChiPhi";
        try {
            conn.executeQuery(query);
            while (conn.rs.next()) {
                LoaiChiPhiDTO lcp = new LoaiChiPhiDTO();
                lcp.setMaLoaiChiPhi(conn.rs.getString(1));
                lcp.setTenLoai(conn.rs.getString(2));
                dsLoaiChiPhi.add(lcp);
            }
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("LoaiChiPhiDAO.getList.executeQuery error.");
        }
        try{
        conn.getConn().close();
        }catch (SQLException e){
            System.out.println("LoaiChiPhiDAO.getList.close error.");
        }
        return dsLoaiChiPhi;
    }
    
}
