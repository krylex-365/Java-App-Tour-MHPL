/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.NhanVienDTO;

/**
 *
 * @author minhk
 */
public class RunTest {
    public static NhanVienDAO dsNhanVien;
    
    public static void main(String[] args) {
        dsNhanVien = new NhanVienDAO();
        for(NhanVienDTO a : dsNhanVien.getList()){
            System.out.println(a.toString());
        }
    }
}
