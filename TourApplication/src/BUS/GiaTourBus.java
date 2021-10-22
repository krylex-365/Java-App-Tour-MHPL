/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.GiaTourDAO;
import DTO.GiaTourDTO;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class GiaTourBus {

    private GiaTourDAO gtDAO;
    private String MaGia;

    public GiaTourBus() {
        gtDAO = new GiaTourDAO();

    }

    public ArrayList<GiaTourDTO> docDanhSachGiaTour() {
        return gtDAO.getList();
    }

    public boolean themGiaTour(String MaTour, String ThanhTien, String TgBatDau, String TgKetThuc) {
        String Magia = MaGia;

        GiaTourDTO newgia = new GiaTourDTO();
        newgia.setMaGia(Magia);
        newgia.setMaTour(MaTour);
        newgia.setTgBatDau(TgBatDau);
        newgia.setTgKetThuc(TgKetThuc);
        newgia.setThanhTien(ThanhTien);

        if (gtDAO.insertGiaTour(Magia, MaTour, ThanhTien, TgBatDau, TgKetThuc)) {
            docDanhSachGiaTour().add(newgia);
            System.out.println("Thêm thành công");
            return true;
        } else {
            System.out.println("Thêm thất bại");

        }

        return false;
    }
}
