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

    public boolean suaHienHanh(String maGia, String maTour) {
//        if (!giaTourDAO.updateGiaTour(maGia, maTour)) {
//            return false;
//        }
//        setHienHanh(maGia, maTour);
//        return true;
        if (giaTourDAO.updateGiaTour(maGia, maTour)) {
            setHienHanh(maGia, maTour);
            return true;
        }
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

}
