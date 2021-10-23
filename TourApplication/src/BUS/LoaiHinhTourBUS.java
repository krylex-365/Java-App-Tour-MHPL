/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.LoaiHinhTourDAO;
import DTO.LoaiHinhTourDTO;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class LoaiHinhTourBUS {
    private ArrayList<LoaiHinhTourDTO> loaiHinhTourDTOs;
    private LoaiHinhTourDAO loaiHinhTourDAO;

    public LoaiHinhTourBUS() {
        this.loaiHinhTourDAO = new LoaiHinhTourDAO();
        this.loaiHinhTourDTOs = loaiHinhTourDAO.getList();
    }

    public ArrayList<LoaiHinhTourDTO> getLoaiHinhTourDTOs() {
        return loaiHinhTourDTOs;
    }

    public void setLoaiHinhTourDTOs(ArrayList<LoaiHinhTourDTO> loaiHinhTourDTOs) {
        this.loaiHinhTourDTOs = loaiHinhTourDTOs;
    }
    
}
