/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ChiPhiDTO;
import DTO.DiaDiemDTO;
import DTO.NhanVienDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author minhk
 */
public class DiaDiemDAO {
    Connect conn;
    

    public DiaDiemDAO() {
        
    }
    
    public ArrayList<DiaDiemDTO> getList(){
        ArrayList<DiaDiemDTO> dsDiaDiem = new ArrayList<DiaDiemDTO>();
        conn = new Connect();
        conn.getConnection();
        String query = "select * from DiaDiem where Status=1";
        try {
            conn.executeQuery(query);
            while (conn.rs.next()) {
                DiaDiemDTO dd = new DiaDiemDTO();
                dd.setMaDiaDiem(conn.rs.getString(1));
                dd.setTenDiaDiem(conn.rs.getString(2));
                dsDiaDiem.add(dd);
            }
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("DiaDiemDAO.getList.executeQuery error.");
        }
        try{
        conn.getConn().close();
        }catch (SQLException e){
            System.out.println("DiaDiemDAO.getList.close error.");
        }
        return dsDiaDiem;
    }

    public boolean themDiaDiem(DiaDiemDTO diaDiemDTO) {
        String sql = "insert into DiaDiem\n" +
                "values ('"+diaDiemDTO.getMaDiaDiem()+"', '"+diaDiemDTO.getTenDiaDiem()+"', 1)";
        conn = new Connect();
        conn.getConnection();
        if(conn.executeUpdate(sql)){
            return true;
        }
        return false;
    }

    public boolean suaMaDiaDiem(String maDiaDiem, String tenDiaDiem) {
        String sql = "update DiaDiem set\n" +
                    "TenDiaDiem = '" + maDiaDiem + "'\n" +
                    "where MaDiaDiem = '" + tenDiaDiem + "'";
        conn = new Connect();
        conn.getConnection();
        if(conn.executeUpdate(sql)){
            return true;
        }
        return false;
    }

    public boolean xoaDiaDiem(String maDiaDiem) {
        String sql = "update DiaDiem set\n" +
                "Status = 0\n" +
                "where MaDiaDiem = '" + maDiaDiem + "'";
        conn = new Connect();
        conn.getConnection();
        if(conn.executeUpdate(sql)){
            return true;
        }
        return false;
    }
}
