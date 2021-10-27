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
 * @author User
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
        doanDuLichDTOs = doanDuLichDAO.getList();
    }

    public ArrayList<DoanDuLichDTO> getDoanDuLichDTOs() {
        return doanDuLichDAO.getList();
    }

    public ArrayList<DoanDuLichDTO> searchDoanDuLichByMaTour(String maTour) {
        ArrayList<DoanDuLichDTO> result = new ArrayList<DoanDuLichDTO>();
        for (DoanDuLichDTO a : doanDuLichDTOs) {
            if (a.getMaTour().equals(maTour)) {
                result.add(a);
                System.out.println(a);
            }
        }
        return result;
    }

    public ArrayList<DoanDuLichDTO> searchDoanDuLichByMaDoan(String maDoan) {
        ArrayList<DoanDuLichDTO> result = new ArrayList<DoanDuLichDTO>();
        for (DoanDuLichDTO a : doanDuLichDTOs) {
            if (a.getMaDoan().equals(maDoan)) {
                result.add(a);
            }
        }
        return result;
    }

    public int soKhach(String maDoan) {
        int count = 0;
        for (DoanDuLichDTO dto : doanDuLichDTOs) {
            if (dto.getMaDoan().equals(maDoan)) {
                count++;
            }
        }
        return count;
    }
    
    public DoanDuLichDTO getDoanDuLichByMaTour(String maTour) {
        for (DoanDuLichDTO doanDuLichDTO: doanDuLichDTOs){
            if(doanDuLichDTO.getMaTour().equals(maTour)) return doanDuLichDTO;
        }
        return null;
    }
}
