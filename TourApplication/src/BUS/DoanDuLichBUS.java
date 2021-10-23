/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.DoanDuLichDAO;
import DTO.DoanDuLichDTO;
import java.util.ArrayList;

/**
 *
 * @author minhk
 */
public class DoanDuLichBUS {
    private DoanDuLichDAO doanDuLichDAO;
    private ArrayList<DoanDuLichDTO> doanDuLichDTOs;
    
    public DoanDuLichBUS(DoanDuLichDAO doanDuLichDAO, ArrayList<DoanDuLichDTO> doanDuLichDTOs) {
        this.doanDuLichDAO = doanDuLichDAO;
        this.doanDuLichDTOs = doanDuLichDTOs;
    }

    public DoanDuLichBUS() {
        doanDuLichDAO = new DoanDuLichDAO();
        doanDuLichDTOs = new ArrayList<>();        
    }

    public ArrayList<DoanDuLichDTO> getDoanDuLichDTOs(){
        return doanDuLichDAO.getList();
    }
    
    public ArrayList<DoanDuLichDTO> searchDoanDuLichByMaTour(String maTour){
        ArrayList<DoanDuLichDTO> result = new ArrayList<DoanDuLichDTO>();
        for(DoanDuLichDTO a : doanDuLichDTOs){
            if(a.getMaTour().equals(maTour))
                result.add(a);
        }
        return result;
    }
    
    public ArrayList<DoanDuLichDTO> searchDoanDuLichByMaDoan(String maDoan){
        ArrayList<DoanDuLichDTO> result = new ArrayList<DoanDuLichDTO>();
        for(DoanDuLichDTO a : doanDuLichDTOs){
            if(a.getMaTour().equals(maDoan))
                result.add(a);
        }
        return result;
    }
}