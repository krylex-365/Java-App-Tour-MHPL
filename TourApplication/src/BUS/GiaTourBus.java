/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.GiaTourDAO;
import DTO.GiaTourDTO;
import java.util.ArrayList;

public class GiaTourBus {

    private GiaTourDAO gtDAO;

    public GiaTourBus() {
        gtDAO = new GiaTourDAO();

    }

    public ArrayList<GiaTourDTO> docDanhSachGiaTour() {
        return gtDAO.getList();
    }
    private String magia;

    public boolean themGiaTour(GiaTourDTO giatourDTO) {
        gtDAO.insertGiaTour(giatourDTO.getMaGia(), giatourDTO.getMaTour(), giatourDTO.getThanhTien(), giatourDTO.getTgBatDau(), giatourDTO.getTgKetThuc());
        for (int i = 0; i < gtDAO.getList().size(); i++) {
            magia = giatourDTO.getMaGia();
            if (magia.equals(docDanhSachGiaTour().get(i).getMaGia())) {
                docDanhSachGiaTour().add(giatourDTO);
                return true;
            }
            return false;

        }
        return true;
    }
}
