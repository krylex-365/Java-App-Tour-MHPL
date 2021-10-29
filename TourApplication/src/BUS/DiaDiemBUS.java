/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
    
    public ArrayList<DiaDiemDTO> searchDiaDiemByMaDiaDiem(String maDiaDiem){
        ArrayList<DiaDiemDTO> result = new ArrayList<>();
        for(DiaDiemDTO a : diaDiemDTOs){
            if(maDiaDiem.equals(a.getMaDiaDiem()))result.add(a);
        }
        return result;
    }
    
}