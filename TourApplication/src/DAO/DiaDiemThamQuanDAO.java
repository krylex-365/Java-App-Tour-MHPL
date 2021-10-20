/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ChiPhiDTO;
import DTO.DiaDiemThamQuanDTO;
import DTO.NhanVienDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author minhk
 */
public class DiaDiemThamQuanDAO {
    Connect conn;
    

    public DiaDiemThamQuanDAO() {
        
    }
    
    public ArrayList<DiaDiemThamQuanDTO> getList(){
        ArrayList<DiaDiemThamQuanDTO> dsDiaDiemThamQuan = new ArrayList<DiaDiemThamQuanDTO>();
        conn = new Connect();
        conn.getConnection();
        String query = "select * from DiaDiemThamQuan";
        try {
            conn.executeQuery(query);
            while (conn.rs.next()) {
                DiaDiemThamQuanDTO ddtq = new DiaDiemThamQuanDTO();
                ddtq.setMaTour(conn.rs.getString(1));
                ddtq.setMaDiaDiem(conn.rs.getString(2));
                ddtq.setThuTu(conn.rs.getString(3));
                dsDiaDiemThamQuan.add(ddtq);
            }
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("DiDiemThamQuanDAO.getList.executeQuery error.");
        }
        try{
        conn.getConn().close();
        }catch (SQLException e){
            System.out.println("DiDiemThamQuanDAO.getList.close error.");
        }
        return dsDiaDiemThamQuan;
    }
    
}
