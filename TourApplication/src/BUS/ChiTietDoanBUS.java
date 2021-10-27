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

    public ChiTietDoanBUS(ChiTietDoanDAO chiTietDoanDAO, ArrayList<ChiTietDoanDTO> chiTietDoanDTOs) {
        this.chiTietDoanDAO = chiTietDoanDAO;
        this.chiTietDoanDTOs = chiTietDoanDTOs;
    }

    public ChiTietDoanBUS() {
        chiTietDoanDAO = new ChiTietDoanDAO();
        chiTietDoanDTOs = chiTietDoanDAO.getList();
    }

    public ChiTietDoanDAO getChiTietDoanDAO() {
        return chiTietDoanDAO;
    }

    public void setChiTietDoanDAO(ChiTietDoanDAO chiTietDoanDAO) {
        this.chiTietDoanDAO = chiTietDoanDAO;
    }

    public ArrayList<ChiTietDoanDTO> getChiTietDoanDTOs() {
        return chiTietDoanDTOs;
    }

    public void setChiTietDoanDTOs(ArrayList<ChiTietDoanDTO> chiTietDoanDTOs) {
        this.chiTietDoanDTOs = chiTietDoanDTOs;
    }
    
    public int peopleCount(String maDoan){
        int count;
        for(count = 1;count<=chiTietDoanDTOs.size();count++){}
        return count;
    }
}
