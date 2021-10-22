package BUS;

import DAO.GiaTourDAO;
import DTO.GiaTourDTO;

import java.util.ArrayList;

public class GiaTourBUS {

    private static ArrayList<GiaTourDTO> giaTourDTOs;
    private GiaTourDAO giaTourDAO;

    public GiaTourBUS() {
        this.giaTourDAO = new GiaTourDAO();
        if (giaTourDTOs == null) {
            this.giaTourDTOs = giaTourDAO.getList();
        }
    }
    
    public boolean themGiaTour(String MaTour, String ThanhTien, String TgBatDau, String TgKetThuc) {
        int newMaGia = giaTourDTOs.size() + 1 ;
        String MaGia = String.valueOf(newMaGia);
        GiaTourDTO giaTourDTO = new GiaTourDTO(MaGia, MaTour, ThanhTien, TgBatDau, TgKetThuc, 1);
        if (giaTourDAO.insertGiaTour(giaTourDTO)) {
            giaTourDTOs.add(giaTourDTO);
            System.out.println("Thêm thành công");
            return true;
        }
        System.out.println("Thêm thất bại");
        return false;
    }

    public boolean suaHienHanh(String maGia, String maTour) {
//        if (!giaTourDAO.updateHienHanh(maGia, maTour)) {
//            return false;
//        }
//        setHienHanh(maGia, maTour);
//        return true;
        if (giaTourDAO.updateHienHanh(maGia, maTour)) {
            setHienHanh(maGia, maTour);
            System.out.println("Sửa thành công suaHienHanhBUS");
            return true;
        }
        System.out.println("Sửa thất bại suaHienHanhBUS");
        return false;
    }

    private boolean setHienHanh(String maGia, String maTour) {
        for (int i = 0; i < giaTourDTOs.size(); i++) {
            GiaTourDTO giaTour = giaTourDTOs.get(i);
            if (giaTour.getMaGia().equals(maGia) && giaTour.getMaTour().equals(maTour)) {
                giaTour.setHienHanh(1);
            } else if (giaTour.getMaTour().equals(maTour)) {
                giaTour.setHienHanh(0);
            }
        }
        return true;
    }

    public ArrayList<GiaTourDTO> getGiaTourDTOs() {
        return giaTourDTOs;
    }

    public void setGiaTourDTOs(ArrayList<GiaTourDTO> giaTourDTOs) {
        this.giaTourDTOs = giaTourDTOs;
    }

    public GiaTourDAO getGiaTourDAO() {
        return giaTourDAO;
    }

    public void setGiaTourDAO(GiaTourDAO giaTourDAO) {
        this.giaTourDAO = giaTourDAO;
    }

}
