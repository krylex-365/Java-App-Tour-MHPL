/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ChiPhiDTO;
import DTO.KhachHangDTO;
import DTO.NhanVienDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author minhk
 */
public class KhachHangDAO {
    Connect conn;
    

    public KhachHangDAO() {
        
    }
    
    public ArrayList<KhachHangDTO> getList(){
        ArrayList<KhachHangDTO> dsKhachHang = new ArrayList<KhachHangDTO>();
        conn = new Connect();
        conn.getConnection();
        String query = "select * from KhachHang where Status=1";
        try {
            conn.executeQuery(query);
            while (conn.rs.next()) {
                KhachHangDTO kh = new KhachHangDTO();
                kh.setMaKhachHang(conn.rs.getString(1));
                kh.setTenKhachHang(conn.rs.getString(2));
                kh.setCMND(conn.rs.getString(3));
                kh.setDiaChi(conn.rs.getString(4));
                kh.setGioiTinh(conn.rs.getString(5));
                kh.setSDT(conn.rs.getString(6));
                kh.setMail(conn.rs.getString(7));
                kh.setQuocTich(conn.rs.getString(8));
                dsKhachHang.add(kh);
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
        return dsKhachHang;
    }
    
    public boolean add(String maKhachHang,String tenKhachHang,String cmnd,String diaChi,String gioiTinh,String sdt,String mail,String quocTich){
        conn = new Connect();
        conn.getConnection();
        //System.out.println(maTour);
        String query = "insert into KhachHang"
                + " (MaKhachHang,TenKhachHang,Cmnd,DiaChi,GioiTinh,Sdt,Mail,QuocTich)"
                + " values ('"+maKhachHang+"','"+tenKhachHang+"','"+cmnd+"','"+diaChi+"','"+gioiTinh+"','"+sdt+"','"+mail+"','"+quocTich+"')";
        if(conn.executeUpdate(query)){
            System.out.println("KhachHangDAO add success.");
            return true;
        }
        return false;
    }
    
    public boolean delete(String maKhachHang){
        conn = new Connect();
        conn.getConnection();
        String query = "update KhachHang " +
                        "set Status=0 " +"where MaKhachHang='"+maKhachHang+"'";
        if(conn.executeUpdate(query)){
            System.out.println("KhachHangDAO delete success.");
            return true;
        }
        return false;
    }
    
    public boolean update(String maKhachHang,String tenKhachHang,String cmnd,String diaChi,String gioiTinh,String sdt,String mail,String quocTich){
        String sql =    "update KhachHang " +
                        "set TenKhachHang='"+ tenKhachHang +"' "+
                        ",Cmnd='"+cmnd+"'" +
                        ",DiaChi='"+diaChi+"'" +
                        ",GioiTinh='"+gioiTinh+"'" +
                        ",Sdt='"+sdt+"'" +
                        ",Mail='"+mail+"'" +
                        ",QuocTich='"+quocTich+"'" +
                        " where MaKhachHang='"+maKhachHang+"'";
        conn = new Connect();
        conn.getConnection();
        if(conn.executeUpdate(sql)){
            System.out.println("KhachHangDAO update success.");
            conn.close();
            return true;
        }
        return false;
    }
    
}
