
package BUS;

import DAO.DoanDuLichDAO;
import DTO.DoanDuLichDTO;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class DoanDuLichBUS {

    private static ArrayList<DoanDuLichDTO> doanDuLichDTOs;
    private DoanDuLichDAO doanDuLichDAO;

    public DoanDuLichBUS() {
        doanDuLichDAO = new DoanDuLichDAO();
        if(doanDuLichDTOs == null){
            doanDuLichDTOs = doanDuLichDAO.getList();
        }
    }

    public DoanDuLichBUS(DoanDuLichDAO doanDuLichDAO, ArrayList<DoanDuLichDTO> doanDuLichDTOs) {
        this.doanDuLichDAO = doanDuLichDAO;
        this.doanDuLichDTOs = doanDuLichDTOs;
    }

    public ArrayList<DoanDuLichDTO> getDoanDuLichDTOs() {
        return doanDuLichDAO.getList();
    }

    public ArrayList<DoanDuLichDTO> searchDoanDuLichByMaTour(String maTour) {
        ArrayList<DoanDuLichDTO> result = new ArrayList<DoanDuLichDTO>();
        for (DoanDuLichDTO a : doanDuLichDTOs) {
            if (a.getMaTour().equals(maTour)) {
                result.add(a);
            }
        }
        return result;
    }

    public ArrayList<DoanDuLichDTO> searchDoanDuLichByMaDoan(String maDoan) {
        ArrayList<DoanDuLichDTO> result = new ArrayList<DoanDuLichDTO>();
        for (DoanDuLichDTO a : doanDuLichDTOs) {
            if (a.getMaTour().equals(maDoan)) {
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
