/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.DiaDiemDAO;
import DTO.DiaDiemDTO;
import java.util.ArrayList;

/**
 *
 * @author minhk
 */
public class DiaDiemBUS {
    private DiaDiemDAO diaDiemDAO;
    private ArrayList<DiaDiemDTO> diaDiemDTOs;

    public DiaDiemBUS(DiaDiemDAO diaDiemDAO, ArrayList<DiaDiemDTO> diaDiemDTOs) {
        this.diaDiemDAO = diaDiemDAO;
        this.diaDiemDTOs = diaDiemDTOs;
    }

    public DiaDiemBUS() {
        diaDiemDAO = new DiaDiemDAO();
        diaDiemDTOs = diaDiemDAO.getList();
    }

    public DiaDiemDAO getDiaDiemDAO() {
        return diaDiemDAO;
    }

    public void setDiaDiemDAO(DiaDiemDAO diaDiemDAO) {
        this.diaDiemDAO = diaDiemDAO;
    }

    public ArrayList<DiaDiemDTO> getDiaDiemDTOs() {
        return diaDiemDTOs;
    }

    public void setDiaDiemDTOs(ArrayList<DiaDiemDTO> diaDiemDTOs) {
        this.diaDiemDTOs = diaDiemDTOs;
    }
    
    public String searchTenDiaDiemByMaDiaDiem(String maDiaDiem){
        String result="Lối !!";
        for(DiaDiemDTO a : diaDiemDTOs){
            if(maDiaDiem.equals(a.getMaDiaDiem()))result = a.getTenDiaDiem();
        }
        return result;
    }
    
}
