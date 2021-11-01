/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.ChiTietDoanDAO;
import DTO.ChiTietDoanDTO;
import java.util.ArrayList;

/**
 *
 * @author minhk
 */
public class ChiTietDoanBUS {
    private ChiTietDoanDAO chiTietDoanDAO;
    private ArrayList<ChiTietDoanDTO> chiTietDoanDTOs;
    
    public ChiTietDoanBUS(){
        chiTietDoanDAO = new ChiTietDoanDAO();
        chiTietDoanDTOs = chiTietDoanDAO.getList();
    }
    
    public int peopleCountByMaDoan(String maDoan){
        int result = 0;
        for(ChiTietDoanDTO a : chiTietDoanDTOs){
            if(a.getMaDoan().equals(maDoan))result++;
        }
        return result;
    }
}