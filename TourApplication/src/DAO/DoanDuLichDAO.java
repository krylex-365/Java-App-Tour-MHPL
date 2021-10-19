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
    
    public ArrayList<DoanDuLichDTO> getList(){
        ArrayList<DoanDuLichDTO> dsChiPhi = new ArrayList<DoanDuLichDTO>();
        conn = new Connect();
        conn.getConnection();
        String query = "select * from DoanDuLich";
        try {
            conn.executeQuery(query);
            while (conn.rs.next()) {
                DoanDuLichDTO ddl = new DoanDuLichDTO();
                ddl.setMaDoan(conn.rs.getString(1));
                ddl.setMaTour(conn.rs.getString(2));
                ddl.setTenDoan(conn.rs.getString(3));
                ddl.setGiaTour(conn.rs.getFloat(4));
                ddl.setNgayKhoiHanh(conn.rs.getString(5));
                ddl.setNgayKetThuc(conn.rs.getString(6));
                ddl.setChiTietNoiDung(conn.rs.getString(7));
                dsChiPhi.add(ddl);
            }
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("DoanDuLichDAO.getList.executeQuery error.");
        }
        try{
        conn.getConn().close();
        }catch (SQLException e){
            System.out.println("DoanDuLichDAO.getList.close error.");
        }
        return dsChiPhi;
    }
    
}
