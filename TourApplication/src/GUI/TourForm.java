/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.*;
import DTO.DiaDiemDTO;
import DTO.DiaDiemThamQuanDTO;
import DTO.DoanDuLichDTO;
import DTO.GiaTourDTO;
import DTO.LoaiHinhTourDTO;
import DTO.TourDTO;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hyung
 */
public class TourForm extends javax.swing.JPanel
{

    /**
     * Creates new form jPanel2
     */
    static int flagtkmk = 0;
    TourBUS tourBUS;
    GiaTourBUS giaTourBUS;
    //ChiTietTour chiTietTour;
    LoaiHinhTourBUS loaiHinhTourBUS;
    public BufferedImage i = null;
    public String imgName = null;
    int rowTour, rowDiaDiemThamQuan, flagThemDiaDiem, rowLoaiHinh;
    private String maTour, tenTour, maLoai, maLoaiHienHanh, maGia, maGiaHienHanh,
            maTourChiTiet, tenTourChiTiet, maLH;
    private String maDiaDiem, tenDiaDiem, thuTu;
    private ArrayList<DiaDiemThamQuanDTO> diaDiemThamQuanTempArr;
    int countNoti;
    Vector tbColTour = new Vector();//Vector chứa các dòng dữ liệu của bảng.
    Vector tbColDiadiem = new Vector();//Vector chứa các tiêu đề của bảng.
    Vector tbColDoan = new Vector();
    Vector tbColLoaiHinh = new Vector();
    DefaultTableModel tbModelTour, tbModelDiadiem, tbModelDoan, tbModelLoaiHinh;
    private Utils ult = new Utils();

    DoanDuLichBUS doanDuLichBUS;
    DiaDiemThamQuanBUS diaDiemThamQuanBUS;
    DiaDiemBUS diaDiemBUS;
    ChiTietDoanBUS chiTietDoanBUS;

    public TourForm()
    {
        initComponents();
        //initTableTour();
        jBtnCapPhatMaTour.setEnabled(true);
        jBtnThemTour.setEnabled(false);
        jBtnSuaTour.setEnabled(false);
        jBtnXoaTour.setEnabled(false);
        jBtnHuyTour.setEnabled(false);
        jBtnXemTour.setEnabled(false);
        jTextGiaTour.setEditable(false);
        jTextGiaTour.setBackground(new Color(214, 217, 223));
        jBtnChonLoaiHinh.setEnabled(false);
        jBtnChonGiaTour.setEnabled(false);
        jDateNgayBD.setEnabled(false);
        jDateNgayKT.setEnabled(false);
        jBtnThemDD.setEnabled(false);
        jBtnSuaDD.setEnabled(false);
        jBtnHuyDD.setEnabled(false);
        jBtnLuuDD.setEnabled(false);
        jBtnXoaDD.setEnabled(false);
        jBtnChonDiaDiem.setEnabled(false);
//        jBtnCapPhatMaLH.setEnabled(true);
//        jBtnThemLH.setEnabled(false);
//        jBtnSuaLH.setEnabled(false);
//        jBtnXoaLH.setEnabled(false);
//        jBtnHuyLH.setEnabled(false);
//        jTabbedPane1.getTabComponentAt(1).setVisible(false);

    }

    public void tbModelDiaDiemThamQuan(DefaultTableModel model, String maTour)
    {
        Vector row;
        for (DiaDiemThamQuanDTO a : diaDiemThamQuanTempArr)
        {
            row = new Vector();
            row.add(a.getMaDiaDiem());
            row.add(diaDiemBUS.searchTenDiaDiemByMaDiaDiem(a.getMaDiaDiem(), DashBoard.diaDiemDTOs));
            row.add(a.getThuTu());
            model.addRow(row);
        }
    }

    public void tbModelDoanDuLich(DefaultTableModel model, String maTour)
    {
        Vector row;
        //System.out.println("ChiTietTour");
        for (DoanDuLichDTO a : doanDuLichBUS.searchDoanDuLichByMaTour(maTour, DashBoard.doanDuLichDTOs))
        {
            row = new Vector();
            row.add(a.getMaDoan());
            row.add(a.getTenDoan());
            row.add(a.getGiaTour());
            row.add(a.getNgayKhoiHanh());
            row.add(a.getNgayKetThuc());
            System.out.println(a);
//            row.add(chiTietDoanBUS.peopleCount(a.getMaDoan()));
            row.add(chiTietDoanBUS.peopleCountByMaDoan(a.getMaDoan(), DashBoard.chiTietDoanDTOs));
            model.addRow(row);
        }
    }

    public void tbModelSearchDoanDuLich(DefaultTableModel model, String maDoan)
    {
        Vector row = new Vector();
        for (DoanDuLichDTO a : doanDuLichBUS.searchDoanDuLichByMaDoan(maDoan, DashBoard.doanDuLichDTOs))
        {
            row.add(a.getMaDoan());
            row.add(a.getTenDoan());
            row.add(a.getGiaTour());
            row.add(a.getNgayKhoiHanh());
            row.add(a.getNgayKetThuc());
//            row.add(chiTietDoanBUS.peopleCount(a.getMaDoan()));
            row.add(chiTietDoanBUS.peopleCountByMaDoan(a.getMaDoan(), DashBoard.chiTietDoanDTOs));
            model.addRow(row);
        }
    }

    public void tableModelTour(DefaultTableModel model)
    {
        for (TourDTO tour : DashBoard.tourDTOs)
        {
            Vector row = new Vector();
            row.add(tour.getMaTour());
            row.add(tour.getTenTour());
            for (LoaiHinhTourDTO loaiHinhTour : DashBoard.loaiHinhTourDTOs)
            {
                if (loaiHinhTour.getMaLoai().equals(tour.getMaLoai()))
                {
                    row.add(loaiHinhTour.getTenLoai());
                    break;
                }
            }
            for (GiaTourDTO giaTour : DashBoard.giaTourDTOs)
            {
                if (giaTour.getMaTour().equals(tour.getMaTour()) && giaTour.getHienHanh() == 1)
                {
                    row.add(giaTour.getThanhTien());
                    row.add(giaTour.getTgBatDau());
                    row.add(giaTour.getTgKetThuc());
                    break;
                }
            }
            model.addRow(row);
        }
    }

    public void themVectorTour(DefaultTableModel model, String maTour, String tenTour,
            String tenLoai, String giaTour, String ngayBD, String ngayKT)
    {
        Vector newrow = new Vector();
        newrow.add(maTour);
        newrow.add(tenTour);
        newrow.add(tenLoai);
        newrow.add(giaTour);
        newrow.add(ngayBD);
        newrow.add(ngayKT);
        model.addRow(newrow);
    }

    public void suaVectorTour(DefaultTableModel model, int row, String tenTour,
            String tenLoai, String giaTour, String ngayBD, String ngayKT)
    {
        model.setValueAt(tenTour, row, 1);
        model.setValueAt(tenLoai, row, 2);
        model.setValueAt(giaTour, row, 3);
        model.setValueAt(ngayBD, row, 4);
        model.setValueAt(ngayKT, row, 5);
    }

    public void xoaVectorTour(DefaultTableModel model, int row)
    {
        model.removeRow(row);
    }

    public void timKiem(DefaultTableModel model, String value)
    {
        model.setRowCount(0);
        for (TourDTO tourDTO : DashBoard.tourDTOs)
        {
            if (tourDTO.getMaTour().equals(value) || tourDTO.getTenTour().indexOf(value) != -1)
            {
                Vector row = new Vector();
                row.add(tourDTO.getMaTour());
                row.add(tourDTO.getTenTour());
                for (LoaiHinhTourDTO loaiHinhTour : DashBoard.loaiHinhTourDTOs)
                {
                    if (loaiHinhTour.getMaLoai().equals(tourDTO.getMaLoai()))
                    {
                        row.add(loaiHinhTour.getTenLoai());
                        break;
                    }
                }
                for (GiaTourDTO giaTour : DashBoard.giaTourDTOs)
                {
                    if (giaTour.getMaTour().equals(tourDTO.getMaTour()) && giaTour.getHienHanh() == 1)
                    {
                        row.add(giaTour.getThanhTien());
                        row.add(giaTour.getTgBatDau());
                        row.add(giaTour.getTgKetThuc());
                        break;
                    }
                }
                model.addRow(row);
                break;
            }
        }
    }

    public boolean isNullOrEmpty(String text)
    {
        if (text == null || text.equals(""))
        {
            return true;
        }
        return false;
    }

    public void tbModelSearchLoaiHinh(DefaultTableModel model, String value)
    {
        Vector row = new Vector();
        model.setRowCount(0);
        for (LoaiHinhTourDTO a : DashBoard.loaiHinhTourDTOs)
        {
            if (a.getMaLoai().equals(value) || a.getTenLoai().indexOf(value) != -1)
            {
                System.out.println(a);
                row.add(a.getMaLoai());
                row.add(a.getTenLoai());
                model.addRow(row);
                break;
            }
        }
    }

    public void tableModelLoaiHinh(DefaultTableModel model)
    {
        for (LoaiHinhTourDTO lh : DashBoard.loaiHinhTourDTOs)
        {
            Vector row = new Vector();
            row.add(lh.getMaLoai());
            row.add(lh.getTenLoai());
            model.addRow(row);
        }
    }

    public void themVectorLoaiHinh(DefaultTableModel model, LoaiHinhTourDTO loaiHinhDTO)
    {
        Vector newrow = new Vector();
        newrow.add(loaiHinhDTO.getMaLoai());
        newrow.add(loaiHinhDTO.getTenLoai());
        model.addRow(newrow);
    }

    public void suaVectorLoaiHinh(DefaultTableModel model, int row, LoaiHinhTourDTO loaiHinhDTO)
    {
        model.setValueAt(loaiHinhDTO.getTenLoai(), row, 1);
    }

    public void xoaVectorLoaiHinh(DefaultTableModel model, int row)
    {
        model.removeRow(row);
    }

    public void loadDataTour()
    {
        tourBUS = new TourBUS();
        giaTourBUS = new GiaTourBUS();
        //chiTietTour = new ChiTietTour();
        loaiHinhTourBUS = new LoaiHinhTourBUS();
        doanDuLichBUS = new DoanDuLichBUS();
        diaDiemThamQuanBUS = new DiaDiemThamQuanBUS();
        diaDiemBUS = new DiaDiemBUS();
        chiTietDoanBUS = new ChiTietDoanBUS();

        tbModelTour.setRowCount(0);
        tableModelTour(tbModelTour);
        jTableTour.setModel(tbModelTour);
    }

    public void initTableTour()
    {
        loadDataTour();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanelQLTour = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jBtnChonGiaTour = new javax.swing.JButton();
        jLabelDacDiem = new javax.swing.JLabel();
        jTextGiaTour = new javax.swing.JTextField();
        jDateNgayKT = new com.toedter.calendar.JDateChooser();
        jLabelTenTour = new javax.swing.JLabel();
        jTextTenTour = new javax.swing.JTextField();
        jTextLoaiHinh = new javax.swing.JTextField();
        jBtnChonLoaiHinh = new javax.swing.JButton();
        jDateNgayBD = new com.toedter.calendar.JDateChooser();
        jBtnCapPhatMaTour = new javax.swing.JButton();
        jTextMaTour = new javax.swing.JTextField();
        jLabelMaTour = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLbManv = new javax.swing.JLabel();
        jLabelLoạiHinh = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextDacDiem = new javax.swing.JTextArea();
        jBtnThemTour = new javax.swing.JButton();
        jBtnXoaTour = new javax.swing.JButton();
        jBtnSuaTour = new javax.swing.JButton();
        jTextTimKiemTour = new javax.swing.JTextField();
        jBtnTimKiemTour = new javax.swing.JButton();
        jBtnRefreshTour = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTour = new javax.swing.JTable();
        jBtnXemTour = new javax.swing.JButton();
        jBtnHuyTour = new javax.swing.JButton();
        jPanelChiTietTour = new javax.swing.JPanel();
        jTextTimKiemNV1 = new javax.swing.JTextField();
        jButtonTimKiem1 = new javax.swing.JButton();
        jBtnRefresh1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTextMaTour1 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jTextTenTour1 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jTextTenDiaDiem = new javax.swing.JTextField();
        jTextMaDiaDiem = new javax.swing.JTextField();
        jBtnChonDiaDiem = new javax.swing.JButton();
        jLbDiaDiem = new javax.swing.JLabel();
        jBtnThemDD = new javax.swing.JButton();
        jBtnSuaDD = new javax.swing.JButton();
        jTextThuTu = new javax.swing.JTextField();
        jBtnLuuDD = new javax.swing.JButton();
        jBtnHuyDD = new javax.swing.JButton();
        jBtnXoaDD = new javax.swing.JButton();
        jLbThuTu1 = new javax.swing.JLabel();
        jBtnXoaDD1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableDiadiem = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableDoan = new javax.swing.JTable();
        jLbThuTu = new javax.swing.JLabel();
        jButtonQuayLai = new javax.swing.JButton();

        setBackground(new java.awt.Color(233, 242, 249));
        setPreferredSize(new java.awt.Dimension(990, 650));

        jTabbedPane1.setBackground(new java.awt.Color(233, 242, 249));
        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jPanelQLTour.setBackground(new java.awt.Color(233, 242, 249));

        jPanel4.setBackground(new java.awt.Color(233, 242, 249));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin Tour", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(0, 51, 102)));
        jPanel4.setPreferredSize(new java.awt.Dimension(1000, 550));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel26.setText("<html> <body>Ngày Kết Thúc<span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");
        jPanel4.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, -1, 30));

        jBtnChonGiaTour.setBackground(new java.awt.Color(136, 193, 184));
        jBtnChonGiaTour.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        jBtnChonGiaTour.setText("...");
        jBtnChonGiaTour.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnChonGiaTour.setPreferredSize(new java.awt.Dimension(30, 30));
        jBtnChonGiaTour.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jBtnChonGiaTourActionPerformed(evt);
            }
        });
        jPanel4.add(jBtnChonGiaTour, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 30, -1, -1));

        jLabelDacDiem.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelDacDiem.setText("<html> <body>Đặc Điểm<span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");
        jPanel4.add(jLabelDacDiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, 30));

        jTextGiaTour.setBackground(new java.awt.Color(214, 217, 223));
        jTextGiaTour.setForeground(new java.awt.Color(51, 51, 51));
        jTextGiaTour.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel4.add(jTextGiaTour, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 30, 160, 30));

        jDateNgayKT.setBackground(new java.awt.Color(214, 217, 223));
        jDateNgayKT.setDateFormatString("yyyy-MM-dd");
        JTextFieldDateEditor editorKT = (JTextFieldDateEditor) jDateNgayKT.getDateEditor();
        editorKT.setEditable(false);
        jPanel4.add(jDateNgayKT, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 110, 200, 30));

        jLabelTenTour.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelTenTour.setText("<html> <body>Tên Tour<span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");
        jPanel4.add(jLabelTenTour, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, 30));

        jTextTenTour.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jTextTenTourActionPerformed(evt);
            }
        });
        jPanel4.add(jTextTenTour, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 170, 30));

        jTextLoaiHinh.setEditable(false);
        jTextLoaiHinh.setBackground(new java.awt.Color(214, 217, 223));
        jPanel4.add(jTextLoaiHinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 170, 30));

        jBtnChonLoaiHinh.setBackground(new java.awt.Color(136, 193, 184));
        jBtnChonLoaiHinh.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        jBtnChonLoaiHinh.setText("...");
        jBtnChonLoaiHinh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnChonLoaiHinh.setPreferredSize(new java.awt.Dimension(30, 30));
        jBtnChonLoaiHinh.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jBtnChonLoaiHinhActionPerformed(evt);
            }
        });
        jPanel4.add(jBtnChonLoaiHinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, -1, -1));

        jDateNgayBD.setBackground(new java.awt.Color(214, 217, 223));
        jDateNgayBD.setDateFormatString("yyyy-MM-dd");
        JTextFieldDateEditor editorBD = (JTextFieldDateEditor) jDateNgayBD.getDateEditor();
        editorBD.setEditable(true);
        jPanel4.add(jDateNgayBD, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, 200, 30));

        jBtnCapPhatMaTour.setBackground(new java.awt.Color(81, 113, 131));
        jBtnCapPhatMaTour.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_add_32.png"))); // NOI18N
        jBtnCapPhatMaTour.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnCapPhatMaTour.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jBtnCapPhatMaTourActionPerformed(evt);
            }
        });
        jPanel4.add(jBtnCapPhatMaTour, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, 30, 30));

        jTextMaTour.setEditable(false);
        jTextMaTour.setBackground(new java.awt.Color(214, 217, 223));
        jPanel4.add(jTextMaTour, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 170, 30));

        jLabelMaTour.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelMaTour.setText("<html> <body> Mã Tour <span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");
        jPanel4.add(jLabelMaTour, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, 30));

        jLabel25.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel25.setText("<html> <body>Ngày Bắt Đầu<span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");
        jPanel4.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, -1, 30));

        jLbManv.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLbManv.setText("<html> <body>Giá Tour<span style=\"color:rgb(234, 21, 21)\"> *</span> </body> </html>");
        jPanel4.add(jLbManv, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, -1, 30));

        jLabelLoạiHinh.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelLoạiHinh.setText("<html> <body>Loại Hình<span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");
        jPanel4.add(jLabelLoạiHinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, 30));

        jTextDacDiem.setColumns(20);
        jTextDacDiem.setRows(5);
        jScrollPane2.setViewportView(jTextDacDiem);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 210, 60));

        jBtnThemTour.setBackground(new java.awt.Color(136, 193, 184));
        jBtnThemTour.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnThemTour.setText("Thêm");
        jBtnThemTour.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jBtnThemTourActionPerformed(evt);
            }
        });

        jBtnXoaTour.setBackground(new java.awt.Color(136, 193, 184));
        jBtnXoaTour.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnXoaTour.setText("Xóa");
        jBtnXoaTour.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jBtnXoaTourActionPerformed(evt);
            }
        });

        jBtnSuaTour.setBackground(new java.awt.Color(136, 193, 184));
        jBtnSuaTour.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnSuaTour.setText("Sửa");
        jBtnSuaTour.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jBtnSuaTourActionPerformed(evt);
            }
        });

        jBtnTimKiemTour.setText("Tìm kiếm");
        jBtnTimKiemTour.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jBtnTimKiemTourActionPerformed(evt);
            }
        });

        jBtnRefreshTour.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/refresh_25px.png"))); // NOI18N
        jBtnRefreshTour.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnRefreshTour.setMaximumSize(new java.awt.Dimension(50, 50));
        jBtnRefreshTour.setMinimumSize(new java.awt.Dimension(50, 50));
        jBtnRefreshTour.setPreferredSize(new java.awt.Dimension(50, 50));
        jBtnRefreshTour.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jBtnRefreshTourActionPerformed(evt);
            }
        });

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setAutoscrolls(true);

        jTableTour.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {

            }
        ));
        jTableTour.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jTableTourMouseClicked(evt);
            }
        });
        tbColTour.add("Mă Tour");
        tbColTour.add("Tên Tour");
        tbColTour.add("Loại Hình");
        tbColTour.add("Giá Tour");
        tbColTour.add("Ngày Bắt Đầu");
        tbColTour.add("Ngày Kết Thúc");
        tbModelTour= new DefaultTableModel(tbColTour,5)
        {
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return false;
            }
        };
        jTableTour.setModel (tbModelTour);
        jTableTour.setShowGrid(true);
        jTableTour.setFocusable(false);
        jTableTour.setIntercellSpacing(new Dimension(0,0));
        jTableTour.setRowHeight(25);
        jTableTour.getTableHeader().setOpaque(false);
        jTableTour.setFillsViewportHeight(true);
        jTableTour.getTableHeader().setBackground(new Color(232,57,99));
        jTableTour.getTableHeader().setForeground(new Color(141, 22, 22));
        jTableTour.getTableHeader().setFont (new Font("Dialog", Font.BOLD, 13));
        jTableTour.setSelectionBackground(new Color(52,152,219));
        jScrollPane1.setViewportView(jTableTour);
        jTableTour.setAutoResizeMode (javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        //jTable1.setModel (new DefaultTableModel(tableRow,tableCol));

        jBtnXemTour.setBackground(new java.awt.Color(136, 193, 184));
        jBtnXemTour.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnXemTour.setText("Xem");
        jBtnXemTour.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jBtnXemTourActionPerformed(evt);
            }
        });

        jBtnHuyTour.setBackground(new java.awt.Color(136, 193, 184));
        jBtnHuyTour.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnHuyTour.setText("Hủy");
        jBtnHuyTour.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jBtnHuyTourActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelQLTourLayout = new javax.swing.GroupLayout(jPanelQLTour);
        jPanelQLTour.setLayout(jPanelQLTourLayout);
        jPanelQLTourLayout.setHorizontalGroup(
            jPanelQLTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelQLTourLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanelQLTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 923, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelQLTourLayout.createSequentialGroup()
                        .addGap(596, 596, 596)
                        .addComponent(jTextTimKiemTour, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnTimKiemTour, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnRefreshTour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelQLTourLayout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 706, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanelQLTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelQLTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jBtnXoaTour, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBtnSuaTour, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jBtnThemTour, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanelQLTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jBtnXemTour, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtnHuyTour, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanelQLTourLayout.setVerticalGroup(
            jPanelQLTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelQLTourLayout.createSequentialGroup()
                .addGroup(jPanelQLTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelQLTourLayout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addGroup(jPanelQLTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelQLTourLayout.createSequentialGroup()
                                .addGroup(jPanelQLTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jBtnXemTour, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jBtnThemTour, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jBtnHuyTour, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelQLTourLayout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(jBtnSuaTour, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)
                                .addComponent(jBtnXoaTour, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanelQLTourLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelQLTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBtnRefreshTour, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelQLTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextTimKiemTour, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBtnTimKiemTour, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                .addGap(27, 27, 27))
        );

        jTabbedPane1.addTab("Quản Lý Tour", jPanelQLTour);

        jPanelChiTietTour.setBackground(new java.awt.Color(233, 242, 249));

        jButtonTimKiem1.setText("Tìm kiếm");
        jButtonTimKiem1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonTimKiem1ActionPerformed(evt);
            }
        });

        jBtnRefresh1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/refresh_25px.png"))); // NOI18N
        jBtnRefresh1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnRefresh1.setMaximumSize(new java.awt.Dimension(50, 50));
        jBtnRefresh1.setMinimumSize(new java.awt.Dimension(50, 50));
        jBtnRefresh1.setPreferredSize(new java.awt.Dimension(50, 50));
        jBtnRefresh1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jBtnRefresh1ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("<html> <body> Mã Tour <span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");

        jTextMaTour1.setEditable(false);
        jTextMaTour1.setBackground(new java.awt.Color(214, 217, 223));

        jLabel27.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel27.setText("<html> <body>Tên Tour<span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");

        jTextTenTour1.setEditable(false);
        jTextTenTour1.setBackground(new java.awt.Color(214, 217, 223));
        jTextTenTour1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jTextTenTour1ActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(233, 242, 249));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Địa Điểm Tham Quan", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(0, 51, 102)));
        jPanel5.setPreferredSize(new java.awt.Dimension(1000, 550));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel29.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel29.setText("<html> <body>Mã Địa Điểm<span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");
        jPanel5.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, 30));

        jTextTenDiaDiem.setEditable(false);
        jTextTenDiaDiem.setBackground(new java.awt.Color(214, 217, 223));
        jTextTenDiaDiem.setForeground(new java.awt.Color(51, 51, 51));
        jTextTenDiaDiem.setRequestFocusEnabled(false);
        jPanel5.add(jTextTenDiaDiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 160, 30));

        jTextMaDiaDiem.setEditable(false);
        jTextMaDiaDiem.setBackground(new java.awt.Color(214, 217, 223));
        jPanel5.add(jTextMaDiaDiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 160, 30));

        jBtnChonDiaDiem.setBackground(new java.awt.Color(136, 193, 184));
        jBtnChonDiaDiem.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        jBtnChonDiaDiem.setText("...");
        jBtnChonDiaDiem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnChonDiaDiem.setPreferredSize(new java.awt.Dimension(30, 30));
        jBtnChonDiaDiem.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jBtnChonDiaDiemActionPerformed(evt);
            }
        });
        jPanel5.add(jBtnChonDiaDiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, -1, -1));

        jLbDiaDiem.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLbDiaDiem.setText("<html> <body>Tên Địa Điểm<span style=\"color:rgb(234, 21, 21)\">*</span> </body> </html>");
        jPanel5.add(jLbDiaDiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, 30));

        jBtnThemDD.setBackground(new java.awt.Color(136, 193, 184));
        jBtnThemDD.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnThemDD.setText("Thêm");
        jBtnThemDD.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jBtnThemDDActionPerformed(evt);
            }
        });
        jPanel5.add(jBtnThemDD, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 80, 40));

        jBtnSuaDD.setBackground(new java.awt.Color(136, 193, 184));
        jBtnSuaDD.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnSuaDD.setText("Sửa");
        jBtnSuaDD.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jBtnSuaDDActionPerformed(evt);
            }
        });
        jPanel5.add(jBtnSuaDD, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 80, 40));

        jTextThuTu.setEditable(false);
        jTextThuTu.setBackground(new java.awt.Color(214, 217, 223));
        jTextThuTu.setForeground(new java.awt.Color(51, 51, 51));
        jTextThuTu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel5.add(jTextThuTu, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 160, 30));

        jBtnLuuDD.setBackground(new java.awt.Color(136, 193, 184));
        jBtnLuuDD.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnLuuDD.setText("Lưu Thứ Tự");
        jBtnLuuDD.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jBtnLuuDDActionPerformed(evt);
            }
        });
        jPanel5.add(jBtnLuuDD, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 180, 40));

        jBtnHuyDD.setBackground(new java.awt.Color(136, 193, 184));
        jBtnHuyDD.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnHuyDD.setText("Hủy");
        jBtnHuyDD.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jBtnHuyDDActionPerformed(evt);
            }
        });
        jPanel5.add(jBtnHuyDD, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, 80, 40));

        jBtnXoaDD.setBackground(new java.awt.Color(136, 193, 184));
        jBtnXoaDD.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnXoaDD.setText("Xóa");
        jBtnXoaDD.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jBtnXoaDDActionPerformed(evt);
            }
        });
        jPanel5.add(jBtnXoaDD, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 80, 40));

        jLbThuTu1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLbThuTu1.setText("<html> <body>Thứ Tự<span style=\"color:rgb(234, 21, 21)\">*</span> </body> </html>");
        jPanel5.add(jLbThuTu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, 30));

        jBtnXoaDD1.setBackground(new java.awt.Color(136, 193, 184));
        jBtnXoaDD1.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnXoaDD1.setText("Xóa");
        jBtnXoaDD1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jBtnXoaDD1ActionPerformed(evt);
            }
        });
        jPanel5.add(jBtnXoaDD1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 80, 40));

        jTableDiadiem.setAutoCreateRowSorter(true);
        jTableDiadiem.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTableDiadiem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {},
                {},
                {},
                {}
            },
            new String []
            {

            }
        ));
        jTableDiadiem.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jTableDiadiemMouseClicked(evt);
            }
        });
        tbColDiadiem.add("Mă Địa Điểm");
        tbColDiadiem.add("Tên Địa Điểm");
        tbColDiadiem.add("Thứ Tự");
        tbModelDiadiem= new DefaultTableModel(tbColDiadiem,5)
        {
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return false;
            }
        };
        jTableDiadiem.setModel (tbModelDiadiem);
        jTableDiadiem.setShowGrid(true);
        jTableDiadiem.setFocusable(false);
        jTableDiadiem.setIntercellSpacing(new Dimension(0,0));
        jTableDiadiem.setRowHeight(25);
        jTableDiadiem.getTableHeader().setOpaque(false);
        jTableDiadiem.setFillsViewportHeight(true);
        jTableDiadiem.getTableHeader().setBackground(new Color(232,57,99));
        jTableDiadiem.getTableHeader().setForeground(new Color(141, 22, 22));
        jTableDiadiem.getTableHeader().setFont (new Font("Dialog", Font.BOLD, 13));
        jTableDiadiem.setSelectionBackground(new Color(52,152,219));
        jTableDiadiem.setAutoResizeMode (javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane3.setViewportView(jTableDiadiem);

        jTableDoan.setAutoCreateRowSorter(true);
        jTableDoan.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTableDoan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {},
                {},
                {},
                {}
            },
            new String []
            {

            }
        ));
        jTableDoan.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jTableDoanMouseClicked(evt);
            }
        });
        tbColDoan.add("Mă Đoàn");
        tbColDoan.add("Tên Ðoàn");
        tbColDoan.add("Giá Ðoàn");
        tbColDoan.add("Ngày Bắt Đầu");
        tbColDoan.add("Ngày Kết Thúc");
        tbColDoan.add("Số Người");
        tbModelDoan= new DefaultTableModel(tbColDoan,5)
        {
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return false;
            }
        };
        jTableDoan.setModel (tbModelDoan);
        jTableDoan.setShowGrid(true);
        jTableDoan.setFocusable(false);
        jTableDoan.setIntercellSpacing(new Dimension(0,0));
        jTableDoan.setRowHeight(25);
        jTableDoan.getTableHeader().setOpaque(false);
        jTableDoan.setFillsViewportHeight(true);
        jTableDoan.getTableHeader().setBackground(new Color(232,57,99));
        jTableDoan.getTableHeader().setForeground(new Color(141, 22, 22));
        jTableDoan.getTableHeader().setFont (new Font("Dialog", Font.BOLD, 13));
        jTableDoan.setSelectionBackground(new Color(52,152,219));
        jTableDoan.setAutoResizeMode (javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane4.setViewportView(jTableDoan);

        jLbThuTu.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLbThuTu.setText("<html><body>Danh Sách Đoàn Của Tour</body> </html>");

        jButtonQuayLai.setText("Quay Lại");
        jButtonQuayLai.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jButtonQuayLaiMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelChiTietTourLayout = new javax.swing.GroupLayout(jPanelChiTietTour);
        jPanelChiTietTour.setLayout(jPanelChiTietTourLayout);
        jPanelChiTietTourLayout.setHorizontalGroup(
            jPanelChiTietTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelChiTietTourLayout.createSequentialGroup()
                .addGroup(jPanelChiTietTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelChiTietTourLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanelChiTietTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelChiTietTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelChiTietTourLayout.createSequentialGroup()
                                .addComponent(jLbThuTu, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextTimKiemNV1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonTimKiem1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtnRefresh1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanelChiTietTourLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jButtonQuayLai, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextMaTour1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86)
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextTenTour1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanelChiTietTourLayout.setVerticalGroup(
            jPanelChiTietTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelChiTietTourLayout.createSequentialGroup()
                .addGroup(jPanelChiTietTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelChiTietTourLayout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addGroup(jPanelChiTietTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextTimKiemNV1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonTimKiem1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtnRefresh1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLbThuTu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4))
                    .addGroup(jPanelChiTietTourLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanelChiTietTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextMaTour1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextTenTour1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonQuayLai, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28))
        );

        jTabbedPane1.addTab("Chi Tiết Tour", jPanelChiTietTour);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
    }// </editor-fold>//GEN-END:initComponents

    public String ktra()
    {
        /*String temp = "";
        if (jTextMaLoaiHinh.getText().equals("")) {
            temp += "Vui lòng cấp phát mã nhân viên!\n";
        }

        String hoten = "^[(AÁÀẢÃẠÂẤẦẨẪẬĂẮẰẲẴẶEÉÈẺẼẸÊẾỀỂỄỆIÍÌỈĨỊOÓÒỎÕỌÔỐỒỔỖỘƠỚỜỞỠỢUÚÙỦŨỤƯỨỪỬỮỰYÝỲỶỸỴĐaáàảãạâấầẩẫậăắằẳẵặeéèẻẽẹêếềểễệiíìỉĩịoóòỏõọôốồổỗộơớờởỡợuúùủũụưứừửữựyýỳỷỹỵđ|a-z|A-Z|\\s]{5,32}$";
        if (!Pattern.matches(hoten, jTextHonv.getText())) {
            temp += "- Họ Nhân Viên không hợp lệ!\n";
        }

        String ten = "^[(AÁÀẢÃẠÂẤẦẨẪẬĂẮẰẲẴẶEÉÈẺẼẸÊẾỀỂỄỆIÍÌỈĨỊOÓÒỎÕỌÔỐỒỔỖỘƠỚỜỞỠỢUÚÙỦŨỤƯỨỪỬỮỰYÝỲỶỸỴĐaáàảãạâấầẩẫậăắằẳẵặeéèẻẽẹêếềểễệiíìỉĩịoóòỏõọôốồổỗộơớờởỡợuúùủũụưứừửữựyýỳỷỹỵđ|a-z|A-Z|\\s]{2,32}$";
        if (!Pattern.matches(ten, jTextTenLoaiHinh.getText())) {
            temp += "- Tên Nhân Viên không hợp lệ!\n";
        }
        String ngaysinh = ((JTextField) jDateNgaySinh.getDateEditor().getUiComponent()).getText();
        String ngaycmnd = ((JTextField) jDateNgaycapcmnd.getDateEditor().getUiComponent()).getText();
        if (ngaysinh.equals("")) {
            temp += "- Ngày sinh không được để trống!\n";
        }
        if (ngaycmnd.equals("")) {
            temp += "- Ngày cấp CMND không được để trống!\n";
        }
        if (!ngaysinh.equals("") && !ngaycmnd.equals("")) {
            String[] arrNgaySinh = ngaysinh.split("-");
            String[] arrNgayCap = ngaycmnd.split("-");
            if (Integer.parseInt(arrNgayCap[0]) - Integer.parseInt(arrNgaySinh[0]) < 14) {
                temp += "- Ngày Cấp CMND không hợp lệ!\n";
            } else if (Integer.parseInt(arrNgayCap[0]) - Integer.parseInt(arrNgaySinh[0]) == 14 && Integer.parseInt(arrNgayCap[1]) - Integer.parseInt(arrNgaySinh[1]) < 0) {
                temp += "- Ngày Cấp CMND không hợp lệ!\n";
            } else if (Integer.parseInt(arrNgayCap[0]) - Integer.parseInt(arrNgaySinh[0]) == 14 && Integer.parseInt(arrNgayCap[1]) - Integer.parseInt(arrNgaySinh[1]) == 0 && Integer.parseInt(arrNgayCap[2]) - Integer.parseInt(arrNgaySinh[2]) < 0) {
                temp += "- Ngày Cấp CMND không hợp lệ!\n";
            }
        }

        String noisinh = "^[(AÁÀẢÃẠÂẤẦẨẪẬĂẮẰẲẴẶEÉÈẺẼẸÊẾỀỂỄỆIÍÌỈĨỊOÓÒỎÕỌÔỐỒỔỖỘƠỚỜỞỠỢUÚÙỦŨỤƯỨỪỬỮỰYÝỲỶỸỴĐaáàảãạâấầẩẫậăắằẳẵặeéèẻẽẹêếềểễệiíìỉĩịoóòỏõọôốồổỗộơớờởỡợuúùủũụưứừửữựyýỳỷỹỵđ|a-z|A-Z|\\s|/-|0-9]{3,100}$";
        if (!Pattern.matches(noisinh, jTextNoiSinh.getText())) {
            temp += "- Nơi Sinh không hợp lệ!\n";
        }

        String trinhdo = "^[(AÁÀẢÃẠÂẤẦẨẪẬĂẮẰẲẴẶEÉÈẺẼẸÊẾỀỂỄỆIÍÌỈĨỊOÓÒỎÕỌÔỐỒỔỖỘƠỚỜỞỠỢUÚÙỦŨỤƯỨỪỬỮỰYÝỲỶỸỴĐaáàảãạâấầẩẫậăắằẳẵặeéèẻẽẹêếềểễệiíìỉĩịoóòỏõọôốồổỗộơớờởỡợuúùủũụưứừửữựyýỳỷỹỵđ|a-z|A-Z|\\s|/-|0-9]{3,100}$";
        if (!Pattern.matches(trinhdo, jTextTdhv.getText())) {
            temp += "- Trình Độ Học Vấn không hợp lệ!\n";
        }

        String diachi = "^[(AÁÀẢÃẠÂẤẦẨẪẬĂẮẰẲẴẶEÉÈẺẼẸÊẾỀỂỄỆIÍÌỈĨỊOÓÒỎÕỌÔỐỒỔỖỘƠỚỜỞỠỢUÚÙỦŨỤƯỨỪỬỮỰYÝỲỶỸỴĐaáàảãạâấầẩẫậăắằẳẵặeéèẻẽẹêếềểễệiíìỉĩịoóòỏõọôốồổỗộơớờởỡợuúùủũụưứừửữựyýỳỷỹỵđ|a-z|A-Z|\\s|/-|0-9]{3,100}$";
        if (!Pattern.matches(diachi, jTextDiaChi.getText())) {
            temp += "- Địa Chỉ không hợp lệ!\n";
        }

        String cmnd = "^\\d{12}$|^\\d{9}$";
        if (!Pattern.matches(cmnd, jTextCmnd.getText())) {
            temp += "- CMND không hợp lệ!\n";
        }

        String sdt = "^\\d{8}$|(^[0]+[1-9]\\d{8})$";
        if (!Pattern.matches(sdt, jTextSDT.getText())) {
            temp += "- Số Điện Thoại không hợp lệ!\n";
        }

        String gmail = "^[a-zA-z]+[a-zA-z0-9]+@+[azA-z0-9]+.+com$";
        if (!Pattern.matches(gmail, jTextEmail.getText())) {
            temp += "- Email không hợp lệ!\n";
        }
//        System.out.println(jDateNgaySinh.get());

        String luongcb = "([\\d]+.[\\d]+|[\\d]+)";
        if (!Pattern.matches(luongcb, jTextLuongcb.getText())) {
            temp += "- Lương Căn Bản không hợp lệ!\n";
        }*/
        return "";
    }

    private void jBtnThemTourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnThemTourActionPerformed
        // TODO add your handling code here:jBtnCapPhatMaTour.setEnabled(true);
        String maTour = (String) jTextMaTour.getText(),
                tenTour = (String) jTextTenTour.getText(),
                giaTour = (String) jTextGiaTour.getText(),
                ngayBD = (String) ((JTextField) jDateNgayBD.getDateEditor().getUiComponent()).getText(),
                ngayKT = (String) ((JTextField) jDateNgayKT.getDateEditor().getUiComponent()).getText();

        //Validation
        StringBuilder message = new StringBuilder();
        Validation.notNullOrEmpty(message, "Tên tour", tenTour, "Loại hình", jTextLoaiHinh.getText(),
                "Đặc điểm", jTextDacDiem.getText());
        Validation.positiveNumbers(message, "Giá tour", giaTour);
        boolean isDate = Validation.isDate(message, "Ngày bắt đầu", ngayBD, "Ngày kết thúc", ngayKT);
        if (isDate)
        {
            Validation.afterOrEquals(message, "Ngày bắt đầu", ngayBD, "Ngày hiện tại",
                    new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            Validation.afterOrEquals(message, "Ngày kết thúc", ngayKT, "Ngày bắt đầu", ngayBD);
        }
        if (!message.toString().equals(""))
        {
            JOptionPane.showMessageDialog(this, message.toString());
            return;
        }

        if (tourBUS.themTour(maTour, (String) getMaLoai(), tenTour,
                (String) jTextDacDiem.getText(), giaTour, ngayBD, ngayKT,
                DashBoard.tourDTOs, DashBoard.giaTourDTOs))
        {
            themVectorTour(tbModelTour, maTour, tenTour, (String) jTextLoaiHinh.getText(), giaTour, ngayBD, ngayKT);
            JOptionPane.showMessageDialog(this, "Thêm Tour thành công!");
        } else
        {
            JOptionPane.showMessageDialog(this, "Thêm Tour thất bại!");
        }
        jBtnCapPhatMaTour.setEnabled(true);
        jBtnThemTour.setEnabled(false);
        jBtnSuaTour.setEnabled(false);
        jBtnXoaTour.setEnabled(false);
        jBtnHuyTour.setEnabled(false);
        jBtnXemTour.setEnabled(false);
        jTextMaTour.setText("");
        jTextTenTour.setText("");
        jTextLoaiHinh.setText("");
        jTextDacDiem.setText("");
        jTextGiaTour.setText("");
        jDateNgayBD.setCalendar(null);
        jDateNgayKT.setCalendar(null);
        jTextGiaTour.setEditable(false);
        jTextGiaTour.setBackground(new Color(214, 217, 223));
        jBtnChonLoaiHinh.setEnabled(false);
        jBtnChonGiaTour.setEnabled(false);
        jDateNgayBD.setEnabled(false);
        jDateNgayKT.setEnabled(false);
        jTableTour.clearSelection();
    }//GEN-LAST:event_jBtnThemTourActionPerformed

    private void jBtnLuuDDActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnLuuDDActionPerformed
    {//GEN-HEADEREND:event_jBtnLuuDDActionPerformed
        // TODO add your handling code here:
        System.out.println(diaDiemThamQuanTempArr.size());
        if (diaDiemThamQuanBUS.suaThuTuTQuan(diaDiemThamQuanTempArr, DashBoard.diaDiemThamQuanDTOs))
        {
            System.out.println("Luu thu tu tham quan thanh cong");
            System.out.println(diaDiemThamQuanTempArr.size());
            tbModelDiadiem.setRowCount(0);
            Vector rowTemp;
            for (DiaDiemThamQuanDTO a : diaDiemThamQuanTempArr)
            {
                //System.out.println(a);
                rowTemp = new Vector();
                rowTemp.add(a.getMaDiaDiem());
                rowTemp.add(diaDiemBUS.searchTenDiaDiemByMaDiaDiem(a.getMaDiaDiem(), DashBoard.diaDiemDTOs));
                rowTemp.add(a.getThuTu());
                System.out.println(a);
                tbModelDiadiem.addRow(rowTemp);
            }
            System.out.println(diaDiemThamQuanTempArr.size());
        }

        jBtnChonDiaDiem.setEnabled(true);
        jBtnThemDD.setEnabled(true);
        jBtnSuaDD.setEnabled(false);
        jBtnXoaDD.setEnabled(false);
        jBtnHuyDD.setEnabled(false);
        jBtnLuuDD.setEnabled(false);
        jTextMaDiaDiem.setText("");
        jTextTenDiaDiem.setText("");
        jTextThuTu.setText("");
        jTextThuTu.setEditable(false);
        jTextThuTu.setBackground(new Color(214, 217, 223));
        jTableDiadiem.clearSelection();
    }//GEN-LAST:event_jBtnLuuDDActionPerformed

    private void jBtnHuyDDActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnHuyDDActionPerformed
    {//GEN-HEADEREND:event_jBtnHuyDDActionPerformed
        // TODO add your handling code here:
        jBtnChonDiaDiem.setEnabled(true);
        jBtnThemDD.setEnabled(false);
        jBtnSuaDD.setEnabled(false);
        jBtnXoaDD.setEnabled(false);
        jBtnHuyDD.setEnabled(false);
        jBtnLuuDD.setEnabled(false);
        jTextMaDiaDiem.setText("");
        jTextTenDiaDiem.setText("");
        jTextThuTu.setText("");
        jTextThuTu.setEditable(false);
        jTextThuTu.setBackground(new Color(214, 217, 223));
        jTableDiadiem.clearSelection();
    }//GEN-LAST:event_jBtnHuyDDActionPerformed

    private void jButtonTimKiem1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonTimKiem1ActionPerformed
    {//GEN-HEADEREND:event_jButtonTimKiem1ActionPerformed
        // TODO add your handling code here:
        tbModelDoan.setRowCount(0);
        String maDoan = jTextTimKiemNV1.getText();
        System.out.println(maDoan);
        tbModelSearchDoanDuLich(tbModelDoan, maDoan);
    }//GEN-LAST:event_jButtonTimKiem1ActionPerformed

    private void jBtnRefresh1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnRefresh1ActionPerformed
    {//GEN-HEADEREND:event_jBtnRefresh1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnRefresh1ActionPerformed

    private void jBtnRefreshTourActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnRefreshTourActionPerformed
    {//GEN-HEADEREND:event_jBtnRefreshTourActionPerformed
        //        // TODO add your handling code here:
        jTextTimKiemTour.setText("");
        loadDataTour();
    }//GEN-LAST:event_jBtnRefreshTourActionPerformed

    private void jBtnTimKiemTourActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnTimKiemTourActionPerformed
    {//GEN-HEADEREND:event_jBtnTimKiemTourActionPerformed
        // TODO add your handling code here:
        //        String manv = jTextTimKiemNV.getText();
        //        tbnv.searchbangnhanvien(tbModelTour, manv);
        //        jTable1.setModel(tbModelTour);
        //        System.out.println("click tim kiem");
        timKiem(tbModelTour, (String) jTextTimKiemTour.getText());
    }//GEN-LAST:event_jBtnTimKiemTourActionPerformed

    private void jBtnCapPhatMaTourActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnCapPhatMaTourActionPerformed
    {//GEN-HEADEREND:event_jBtnCapPhatMaTourActionPerformed
        // TODO add your handling code here:
        loadDataTour();
        String init = null;
        init = tourBUS.CapPhat(init);
        jTextMaTour.setText(init);
        jBtnCapPhatMaTour.setEnabled(false);
        jBtnThemTour.setEnabled(true);
        jBtnSuaTour.setEnabled(false);
        jBtnXoaTour.setEnabled(false);
        jBtnHuyTour.setEnabled(true);
        jBtnXemTour.setEnabled(false);
        jTextTenTour.setText("");
        jTextLoaiHinh.setText("");
        jTextDacDiem.setText("");
        jTextGiaTour.setText("");
        jDateNgayBD.setCalendar(null);
        jDateNgayKT.setCalendar(null);
        jTextGiaTour.setEditable(true);
        jTextGiaTour.setBackground(new Color(255, 255, 255));
        jBtnChonLoaiHinh.setEnabled(true);
        jBtnChonGiaTour.setEnabled(false);
        jDateNgayBD.setEnabled(true);
        jDateNgayKT.setEnabled(true);
    }//GEN-LAST:event_jBtnCapPhatMaTourActionPerformed

    private void jBtnChonGiaTourActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnChonGiaTourActionPerformed
    {//GEN-HEADEREND:event_jBtnChonGiaTourActionPerformed
        // TODO add your handling code here:
        BangGia bangGia = new BangGia(getMaTour(), getMaGiaHienHanh());
        bangGia.tourForm = this;
    }//GEN-LAST:event_jBtnChonGiaTourActionPerformed

    private void jBtnChonLoaiHinhActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnChonLoaiHinhActionPerformed
    {//GEN-HEADEREND:event_jBtnChonLoaiHinhActionPerformed
        // TODO add your handling code here:
        BangLoaiHinh bangLoaiHinh = new BangLoaiHinh();
        bangLoaiHinh.tourForm = this;
    }//GEN-LAST:event_jBtnChonLoaiHinhActionPerformed

    private void jBtnXoaTourActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnXoaTourActionPerformed
    {//GEN-HEADEREND:event_jBtnXoaTourActionPerformed
        // TODO add your handling code here:
        if (tourBUS.xoaTour(maTour, DashBoard.tourDTOs, DashBoard.giaTourDTOs, DashBoard.diaDiemThamQuanDTOs, DashBoard.doanDuLichDTOs))
        {
            xoaVectorTour(tbModelTour, rowTour);
            JOptionPane.showMessageDialog(this, "Xóa Tour thành công!");
        } else
        {
            JOptionPane.showMessageDialog(this, "Xóa Tour thất bại!");
        }
        jBtnCapPhatMaTour.setEnabled(true);
        jBtnThemTour.setEnabled(false);
        jBtnSuaTour.setEnabled(false);
        jBtnXoaTour.setEnabled(false);
        jBtnHuyTour.setEnabled(false);
        jBtnXemTour.setEnabled(false);
        jTextMaTour.setText("");
        jTextTenTour.setText("");
        jTextLoaiHinh.setText("");
        jTextDacDiem.setText("");
        jTextGiaTour.setText("");
        jDateNgayBD.setCalendar(null);
        jDateNgayKT.setCalendar(null);
        jTextGiaTour.setEditable(false);
        jTextGiaTour.setBackground(new Color(214, 217, 223));
        jBtnChonLoaiHinh.setEnabled(false);
        jBtnChonGiaTour.setEnabled(false);
        jDateNgayBD.setEnabled(false);
        jDateNgayKT.setEnabled(false);
        jTableTour.clearSelection();
    }//GEN-LAST:event_jBtnXoaTourActionPerformed

    private void jBtnSuaTourActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnSuaTourActionPerformed
    {//GEN-HEADEREND:event_jBtnSuaTourActionPerformed
        // TODO add your handling code here:
        String tenTour = (String) jTextTenTour.getText(),
                ngayBD = (String) ((JTextField) jDateNgayBD.getDateEditor().getUiComponent()).getText(),
                ngayKT = (String) ((JTextField) jDateNgayKT.getDateEditor().getUiComponent()).getText();

        //Validation
        StringBuilder message = new StringBuilder();
        Validation.notNullOrEmpty(message, "Tên tour", tenTour, "Loại hình", jTextLoaiHinh.getText(),
                "Đặc điểm", jTextDacDiem.getText());
        if (!message.toString().equals(""))
        {
            JOptionPane.showMessageDialog(this, message.toString());
            return;
        }

        System.out.println("Sua tour: " + maTour);
        if (tourBUS.suaTour(getMaTour(), tenTour, (String) jTextDacDiem.getText(), getMaLoaiHienHanh(), getMaLoai(),
                getMaGiaHienHanh(), getMaGia(), DashBoard.tourDTOs, DashBoard.giaTourDTOs))
        {
            suaVectorTour(tbModelTour, rowTour, tenTour, jTextLoaiHinh.getText(), jTextGiaTour.getText(), ngayBD, ngayKT);
            JOptionPane.showMessageDialog(this, "Sửa Tour thành công!");
        } else
        {
            JOptionPane.showMessageDialog(this, "Sửa Tour thất bại!");
        }
        jBtnCapPhatMaTour.setEnabled(true);
        jBtnThemTour.setEnabled(false);
        jBtnSuaTour.setEnabled(false);
        jBtnXoaTour.setEnabled(false);
        jBtnHuyTour.setEnabled(false);
        jBtnXemTour.setEnabled(false);
        jTextMaTour.setText("");
        jTextTenTour.setText("");
        jTextLoaiHinh.setText("");
        jTextDacDiem.setText("");
        jTextGiaTour.setText("");
        jDateNgayBD.setCalendar(null);
        jDateNgayKT.setCalendar(null);
        jTextGiaTour.setEditable(false);
        jTextGiaTour.setBackground(new Color(214, 217, 223));
        jBtnChonLoaiHinh.setEnabled(false);
        jBtnChonGiaTour.setEnabled(false);
        jDateNgayBD.setEnabled(false);
        jDateNgayKT.setEnabled(false);
        jTableTour.clearSelection();
    }//GEN-LAST:event_jBtnSuaTourActionPerformed

    private void jTableTourMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jTableTourMouseClicked
    {//GEN-HEADEREND:event_jTableTourMouseClicked
        if (evt.getSource() == jTableTour)
        {
            rowTour = jTableTour.getSelectedRow();
            if (rowTour != -1)
            {
                maTour = (String) jTableTour.getModel().getValueAt(rowTour, 0);
                tenTour = (String) jTableTour.getModel().getValueAt(rowTour, 1);
                if (!maTour.equals("null"))
                {
                    jTextMaTour.setText(maTour);
                    jTextTenTour.setText(tenTour);
                    jTextLoaiHinh.setText((String) jTableTour.getModel().getValueAt(rowTour, 2));
                    jTextGiaTour.setText((String) jTableTour.getModel().getValueAt(rowTour, 3));
                    try
                    {
                        Date dateBD = new SimpleDateFormat("yyyy-MM-dd").parse(jTableTour.getModel().getValueAt(rowTour, 4).toString());
                        jDateNgayBD.setDate(dateBD);
                        System.out.println("dateBD" + dateBD.toString());
                    } catch (Exception e)
                    {
                        JOptionPane.showMessageDialog(TourForm.this, e);
                        System.out.println("- Load sai ngày bắt đầu!");
                    }
                    try
                    {
                        Date dateKT = new SimpleDateFormat("yyyy-MM-dd").parse(jTableTour.getModel().getValueAt(rowTour, 5).toString());
                        jDateNgayKT.setDate(dateKT);
                        System.out.println("dateKT" + dateKT.toString());
                    } catch (Exception e)
                    {
                        JOptionPane.showMessageDialog(TourForm.this, e);
                        System.out.println("- Load sai ngày kết thúc!");
                    }
                    for (TourDTO tour : DashBoard.tourDTOs)
                    {
                        if (maTour.equals(tour.getMaTour()))
                        {
                            jTextDacDiem.setText(tour.getDacDiem());
                            setMaLoaiHienHanh(tour.getMaLoai());
                            setMaLoai(tour.getMaLoai());
                        }
                    }
                    setMaTour(maTour);
                    System.out.println("maTour: " + getMaTour());
                    System.out.println("maLoaiHH: " + getMaLoaiHienHanh());
                    for (GiaTourDTO giaTour : DashBoard.giaTourDTOs)
                    {
                        if (giaTour.getMaTour().equals(getMaTour()) && giaTour.getHienHanh() == 1)
                        {
                            setMaGiaHienHanh(giaTour.getMaGia());
                            setMaGia(giaTour.getMaGia());
                            System.out.println("for maGiaHH: " + getMaGiaHienHanh());
                            System.out.println("for maGia: " + getMaGia());
                        }
                    }
                    System.out.println("maGiaHH: " + getMaGiaHienHanh());
                    System.out.println("maGia: " + getMaGia());
                    jBtnCapPhatMaTour.setEnabled(false);
                    jBtnThemTour.setEnabled(false);
                    jBtnSuaTour.setEnabled(true);
                    jBtnXoaTour.setEnabled(true);
                    jBtnHuyTour.setEnabled(true);
                    jBtnXemTour.setEnabled(true);
                    jTextGiaTour.setEditable(false);
                    jTextGiaTour.setBackground(new Color(214, 217, 223));
                    jBtnChonLoaiHinh.setEnabled(true);
                    jBtnChonGiaTour.setEnabled(true);
                    jDateNgayBD.setEnabled(false);
                    jDateNgayKT.setEnabled(false);
                } else
                {
                    jBtnCapPhatMaTour.setEnabled(true);
                    jBtnThemTour.setEnabled(false);
                    jBtnSuaTour.setEnabled(false);
                    jBtnXoaTour.setEnabled(false);
                    jBtnHuyTour.setEnabled(false);
                    jBtnXemTour.setEnabled(false);
                    jTextGiaTour.setEditable(false);
                    jTextGiaTour.setBackground(new Color(214, 217, 223));
                    jBtnChonLoaiHinh.setEnabled(false);
                    jBtnChonGiaTour.setEnabled(false);
                    jDateNgayBD.setEnabled(false);
                    jDateNgayKT.setEnabled(false);
                }
            }
        }

    }//GEN-LAST:event_jTableTourMouseClicked

    private void jTextTenTourActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jTextTenTourActionPerformed
    {//GEN-HEADEREND:event_jTextTenTourActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextTenTourActionPerformed

    private void jTextTenTour1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jTextTenTour1ActionPerformed
    {//GEN-HEADEREND:event_jTextTenTour1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextTenTour1ActionPerformed

    private void jBtnChonDiaDiemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnChonDiaDiemActionPerformed
    {//GEN-HEADEREND:event_jBtnChonDiaDiemActionPerformed
        // TODO add your handling code here:
        BangDiaDiem bangDiaDiem = new BangDiaDiem();
        bangDiaDiem.tourForm = this;
        bangDiaDiem.loadData();
    }//GEN-LAST:event_jBtnChonDiaDiemActionPerformed

    private void jBtnXoaDDActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnXoaDDActionPerformed
    {//GEN-HEADEREND:event_jBtnXoaDDActionPerformed
        // TODO add your handling code here:
        Vector row = new Vector();
        row.add(jTextMaDiaDiem.getText());
        row.add(jTextTenDiaDiem.getText());
        row.add(Integer.parseInt(jTextThuTu.getText()));
        if (diaDiemThamQuanBUS.deleteDiaDiemThamQuan(maTourChiTiet, jTextMaDiaDiem.getText(), Integer.parseInt(jTextThuTu.getText()), DashBoard.diaDiemThamQuanDTOs))
        {
            //System.out.println(jTableDiadiem.getValueAt(rowDiaDiemThamQuan, 2));
            DiaDiemThamQuanDTO a;
            //System.out.println(jTextMaDiaDiem.getText());
            for (int i = 0; i < diaDiemThamQuanTempArr.size(); i++)
            {
                a = diaDiemThamQuanTempArr.get(i);

                if ((a.getMaDiaDiem().equals(jTextMaDiaDiem.getText())) && (a.getMaTour().equals(maTourChiTiet)) && (a.getThuTu() == Integer.parseInt(jTableDiadiem.getValueAt(rowDiaDiemThamQuan, 2).toString())))
                {
                    diaDiemThamQuanTempArr.remove(i);
                    break;
                }
            }
            tbModelDiadiem.removeRow(rowDiaDiemThamQuan);
            JOptionPane.showMessageDialog(this, "Xóa Địa điểm khỏi Tour thành công!");
        } else
        {
            JOptionPane.showMessageDialog(this, "Xóa Địa điểm khỏi Tour thất bại!");
        }
        jBtnChonDiaDiem.setEnabled(true);
        jBtnThemDD.setEnabled(false);
        jBtnSuaDD.setEnabled(false);
        jBtnXoaDD.setEnabled(false);
        jBtnHuyDD.setEnabled(false);
        jBtnLuuDD.setEnabled(false);
        jTextMaDiaDiem.setText("");
        jTextTenDiaDiem.setText("");
        jTextThuTu.setText("");
        jTextThuTu.setEditable(false);
        jTextThuTu.setBackground(new Color(214, 217, 223));
        jTableDiadiem.clearSelection();
    }//GEN-LAST:event_jBtnXoaDDActionPerformed

    private void jBtnThemDDActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnThemDDActionPerformed
    {//GEN-HEADEREND:event_jBtnThemDDActionPerformed
        // TODO add your handling code here:
        int flagDiaDiem = 1;
        if (jTextThuTu.getText() == null || jTextThuTu.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Thứ tự không được bỏ trống!");
        } else
        {
            for (DiaDiemThamQuanDTO a : diaDiemThamQuanTempArr)
            {
                System.out.println(a);
                if (a.getThuTu() == (Integer.parseInt(jTextThuTu.getText())))
                {
                    flagDiaDiem = 0;
                    System.out.println("thu tu da ton tai");
                }
            }
            if (flagDiaDiem == 1 && diaDiemThamQuanBUS.addDiaDiemThamQuan(maTourChiTiet, jTextMaDiaDiem.getText(), Integer.parseInt(jTextThuTu.getText()), DashBoard.diaDiemThamQuanDTOs))
            {
                diaDiemThamQuanTempArr.add(new DiaDiemThamQuanDTO(maTourChiTiet, jTextMaDiaDiem.getText(), diaDiemThamQuanTempArr.size() + 1));
                Vector row = new Vector();
                row.add(jTextMaDiaDiem.getText());
                row.add(jTextTenDiaDiem.getText());
                row.add(Integer.parseInt(jTextThuTu.getText()));
                tbModelDiadiem.addRow(row);
                JOptionPane.showMessageDialog(this, "Thêm Địa điểm vào Tour thành công!");
            } else
            {
                JOptionPane.showMessageDialog(this, "Thêm Địa điểm vào Tour thất bại!");
            }
            jBtnChonDiaDiem.setEnabled(true);
            jBtnThemDD.setEnabled(false);
            jBtnSuaDD.setEnabled(false);
            jBtnXoaDD.setEnabled(false);
            jBtnHuyDD.setEnabled(false);
            jBtnLuuDD.setEnabled(false);
            jTextMaDiaDiem.setText("");
            jTextTenDiaDiem.setText("");
            jTextThuTu.setText("");
            jTableDiadiem.clearSelection();
        }

//        DiaDiemThamQuanDTO temp = new DiaDiemThamQuanDTO(jTextMaDiaDiem.getText(),maTourChiTiet,Integer.parseInt(jTextThuTu.getText()));
//        //System.out.println(jTextThuTu.getText());
//        int flag = 1;
//        for(DiaDiemThamQuanDTO a : chiTietTour.DiaDiemThamQuanDTOs()){
//            if(a.getMaDiaDiem().equals(jTextMaDiaDiem.getText())&&(a.getThuTu()==(Integer.parseInt(jTextThuTu.getText())))){
//                    flag=0;
//                    //System.out.println("Dup");
//                    break;
//                };
//            }
//        if(flag==1&&!jTextMaDiaDiem.getText().equals("")&&!jTextTenDiaDiem.getText().equals("")&&!jTextThuTu.getText().equals("")&&chiTietTour.checkDuplicateThuTu(maTourChiTiet,Integer.parseInt(jTextThuTu.getText()))){
//            tbModelDiadiem.addRow(row);
//            
//        }else {
//            System.out.println("Trùng hoặc rỗng");
//        }

    }//GEN-LAST:event_jBtnThemDDActionPerformed

    private void jBtnSuaDDActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnSuaDDActionPerformed
    {//GEN-HEADEREND:event_jBtnSuaDDActionPerformed
        // TODO add your handling code here:
        //        int flag = 1;
//        if(diaDiemThamQuanTempArr.size()>0){
//            System.out.println("hello");
//            for(DiaDiemThamQuanDTO a : diaDiemThamQuanTempArr){
//                System.out.println(a.elementAt(2)+" "+jTextThuTu.getText());
//                if(a.elementAt(2).equals(jTextThuTu.getText())){
//                    flag=0;
//                    System.out.println();
//                    //break;
//                };
//            }
//        }
//        if(flag==1&&chiTietTour.checkDuplicateThuTu(maTourChiTiet,Integer.parseInt(jTextThuTu.getText()))){
//            if(diaDiemThamQuanTempArr.size()>0){
//                for(Vector a : diaDiemThamQuanTempArr){
//                    if(a.elementAt(0).equals(jTextMaDiaDiem.getText())&&a.elementAt(2).equals(tbModelDiadiem.getValueAt(rowDiaDiemThamQuan, 2))){
//                        a.setElementAt(jTextThuTu.getText(), 2);
//                        break;
//                    }
//                }
//            }
//            tbModelDiadiem.setValueAt(jTextThuTu.getText(), rowDiaDiemThamQuan, 2);
//   
        int flagSuaDiaDiem = 1;
        for (DiaDiemThamQuanDTO a : diaDiemThamQuanTempArr)
        {
            if (a.getThuTu() == (Integer.parseInt(jTextThuTu.getText())))
            {
                flagSuaDiaDiem = 0;
                break;
            }
        }
        //&&diaDiemThamQuanBUS.updateDiaDiemThamQuan(maTourChiTiet, jTextMaDiaDiem.getText(), (int) tbModelDiadiem.getValueAt(rowDiaDiemThamQuan, 2), Integer.parseInt(jTextThuTu.getText()))
        if (flagSuaDiaDiem == 1)
        {
            for (DiaDiemThamQuanDTO a : diaDiemThamQuanTempArr)
            {
                if ((a.getMaDiaDiem().equals(jTextMaDiaDiem.getText())) && (a.getMaTour().equals(maTourChiTiet)) && (a.getThuTu() == Integer.parseInt(tbModelDiadiem.getValueAt(rowDiaDiemThamQuan, 2).toString())))
                {
                    a.setThuTu(Integer.parseInt(jTextThuTu.getText()));
                    break;
                }
            }
            tbModelDiadiem.setValueAt(Integer.parseInt(jTextThuTu.getText()), rowDiaDiemThamQuan, 2);
            if (countNoti == 1)
            {
                JOptionPane.showMessageDialog(this, "Hãy bấm <Lưu Thứ Tự> sau khi hoàn tất sửa thứ tự các địa điểm!");
                countNoti = 0;
            }
            jBtnLuuDD.setEnabled(true);
        } else
        {
            JOptionPane.showMessageDialog(this, "Thứ tự này đã tồn tại. Không thể sửa!");
        }
        jBtnChonDiaDiem.setEnabled(true);
        if (flagThemDiaDiem == 1)
        {
            jBtnThemDD.setEnabled(true);
        } else
        {
            jBtnThemDD.setEnabled(false);
        }
        jBtnSuaDD.setEnabled(false);
        jBtnXoaDD.setEnabled(false);
        jBtnHuyDD.setEnabled(false);
        jTextMaDiaDiem.setText("");
        jTextTenDiaDiem.setText("");
        jTextThuTu.setText("");
        jTextThuTu.setEditable(false);
        jTextThuTu.setBackground(new Color(214, 217, 223));
        jTableDiadiem.clearSelection();
    }//GEN-LAST:event_jBtnSuaDDActionPerformed

    private void jTableDiadiemMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jTableDiadiemMouseClicked
    {//GEN-HEADEREND:event_jTableDiadiemMouseClicked
        // TODO add your handling code here:
        rowDiaDiemThamQuan = jTableDiadiem.getSelectedRow();
        System.out.println(rowDiaDiemThamQuan);
        jTextMaDiaDiem.setText((String) jTableDiadiem.getValueAt(rowDiaDiemThamQuan, 0));
        //System.out.println((String) jTableDiadiem.getValueAt(rowDiaDiemThamQuan, 0));
        jTextTenDiaDiem.setText((String) jTableDiadiem.getValueAt(rowDiaDiemThamQuan, 1));
        jTextThuTu.setText(Integer.toString((int) jTableDiadiem.getValueAt(rowDiaDiemThamQuan, 2)));
        //System.out.println(Integer.toString( Integer.parseInt((String)jTableDiadiem.getValueAt(rowDiaDiemThamQuan, 2))));
        if (flagThemDiaDiem == 1)
        { // NẾU TOUR CHƯA CÓ ĐOÀN
            jBtnChonDiaDiem.setEnabled(false);
            jBtnThemDD.setEnabled(false);
            jBtnSuaDD.setEnabled(true);
            jBtnXoaDD.setEnabled(true);
            jBtnHuyDD.setEnabled(true);
            jBtnLuuDD.setEnabled(false);
            jTextThuTu.setEditable(true);
            jTextThuTu.setBackground(new Color(240, 240, 240));
        } else
        { // NẾU CÓ ĐOÀN
            jBtnChonDiaDiem.setEnabled(false);
            jBtnThemDD.setEnabled(false);
            jBtnSuaDD.setEnabled(false);
            jBtnXoaDD.setEnabled(false);
            jBtnHuyDD.setEnabled(false);
            jBtnLuuDD.setEnabled(false);
        }
    }//GEN-LAST:event_jTableDiadiemMouseClicked

    private void jTableDoanMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jTableDoanMouseClicked
    {//GEN-HEADEREND:event_jTableDoanMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableDoanMouseClicked

    private void jBtnXemTourActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnXemTourActionPerformed
    {//GEN-HEADEREND:event_jBtnXemTourActionPerformed
//        jTabbedPane1.add("Chi Tiết Tour", jPanelChiTietTour);
//        jTabbedPane1.getTabComponentAt(1).setVisible(true);

        jTabbedPane1.add(jPanelChiTietTour, 1);
        jTabbedPane1.setTitleAt(1, "Chi Tiết Tour");
        jTabbedPane1.setSelectedIndex(1);
        jTabbedPane1.setEnabledAt(0, false);
        countNoti = 1;
        rowTour = jTableTour.getSelectedRow();
        maTourChiTiet = (String) jTableTour.getModel().getValueAt(rowTour, 0);
        tenTourChiTiet = (String) jTableTour.getModel().getValueAt(rowTour, 1);
        jTextMaTour1.setText(maTourChiTiet);//System.out.println(maTourChiTiet);
        jTextTenTour1.setText(tenTour);
//        System.out.println(tenTour);
        tbModelDoan.setRowCount(0);
        tbModelDiadiem.setRowCount(0);
        diaDiemThamQuanTempArr = diaDiemThamQuanBUS.searchDiaDiemThamQuanByMaTour(maTourChiTiet, DashBoard.diaDiemThamQuanDTOs);
        tbModelDiaDiemThamQuan(tbModelDiadiem, maTourChiTiet);
        tbModelDoanDuLich(tbModelDoan, maTourChiTiet);
//        System.out.println(doanDuLichBUS.countDoanTrongTour(maTourChiTiet, DashBoard.doanDuLichDTOs));
//        System.out.println(maTourChiTiet);
        if (doanDuLichBUS.countDoanTrongTour(maTourChiTiet, DashBoard.doanDuLichDTOs) == 0)
        { // NẾU TOUR CHƯA CÓ ĐOÀN
            flagThemDiaDiem = 1;
            jBtnChonDiaDiem.setEnabled(true);
        } else
        { // NẾU CÓ ĐOÀN
            flagThemDiaDiem = 0;
            jBtnChonDiaDiem.setEnabled(false);
        }
        jBtnThemDD.setEnabled(false);
        jBtnSuaDD.setEnabled(false);
        jBtnXoaDD.setEnabled(false);
        jBtnHuyDD.setEnabled(false);
        jBtnLuuDD.setEnabled(false);
        jTextMaDiaDiem.setText("");
        jTextTenDiaDiem.setText("");
        jTextThuTu.setText("");
        jTextThuTu.setEditable(false);
        jTextThuTu.setBackground(new Color(214, 217, 223));
        jTableTour.clearSelection();
    }//GEN-LAST:event_jBtnXemTourActionPerformed

    private void jBtnHuyTourActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnHuyTourActionPerformed
    {//GEN-HEADEREND:event_jBtnHuyTourActionPerformed
        // TODO add your handling code here:
        jBtnCapPhatMaTour.setEnabled(true);
        jBtnThemTour.setEnabled(false);
        jBtnSuaTour.setEnabled(false);
        jBtnXoaTour.setEnabled(false);
        jBtnHuyTour.setEnabled(false);
        jBtnXemTour.setEnabled(false);
        jTextMaTour.setText("");
        jTextTenTour.setText("");
        jTextLoaiHinh.setText("");
        jTextDacDiem.setText("");
        jTextGiaTour.setText("");
        jDateNgayBD.setCalendar(null);
        jDateNgayKT.setCalendar(null);
        jTextGiaTour.setEditable(false);
        jTextGiaTour.setBackground(new Color(214, 217, 223));
        jBtnChonGiaTour.setEnabled(false);
        jBtnChonLoaiHinh.setEnabled(false);
        jDateNgayBD.setEnabled(false);
        jDateNgayKT.setEnabled(false);
        jTableTour.clearSelection();
    }//GEN-LAST:event_jBtnHuyTourActionPerformed

    private void jBtnXoaDD1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnXoaDD1ActionPerformed
    {//GEN-HEADEREND:event_jBtnXoaDD1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnXoaDD1ActionPerformed

    private void jButtonQuayLaiMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jButtonQuayLaiMouseClicked
    {//GEN-HEADEREND:event_jButtonQuayLaiMouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setEnabledAt(0, true);
        jTabbedPane1.setSelectedIndex(0);
        jTabbedPane1.remove(jPanelChiTietTour);
        resetAll();
    }//GEN-LAST:event_jButtonQuayLaiMouseClicked

    public int getRowTour()
    {
        return rowTour;
    }

    public void setRowTour(int rowTour)
    {
        this.rowTour = rowTour;
    }

    public DefaultTableModel getTbModelTour()
    {
        return tbModelTour;
    }

    public void setTbModelTour(DefaultTableModel tbModelTour)
    {
        this.tbModelTour = tbModelTour;
    }

    public JButton getjBtnXoaNV()
    {
        return jBtnXemTour;
    }

    public JButton getjBtnRefresh()
    {
        return jBtnRefreshTour;
    }

    public void setjBtnRefresh(JButton jBtnRefresh)
    {
        this.jBtnRefreshTour = jBtnRefresh;
    }

    public JTabbedPane getjTabbedPane1()
    {
        return jTabbedPane1;
    }

    public void setjTabbedPane1(JTabbedPane jTabbedPane1)
    {
        this.jTabbedPane1 = jTabbedPane1;
    }

    public JTextField getjTextTimKiemNV()
    {
        return jTextTimKiemTour;
    }

    public void setjTextTimKiemNV(JTextField jTextTimKiemNV)
    {
        this.jTextTimKiemTour = jTextTimKiemNV;
    }

    public JButton getjButtonTimKiem()
    {
        return jBtnTimKiemTour;
    }

    public void setjButtonTimKiem(JButton jButtonTimKiem)
    {
        this.jBtnTimKiemTour = jButtonTimKiem;
    }

    public JTextField getjTextMaDiaDiem()
    {
        return jTextMaDiaDiem;
    }

    public void setjTextMaDiaDiem(JTextField jTextMaDiaDiem)
    {
        this.jTextMaDiaDiem = jTextMaDiaDiem;
    }

    public JTextField getjTextTenDiaDiem()
    {
        return jTextTenDiaDiem;
    }

    public void setjTextTenDiaDiem(JTextField jTextTenDiaDiem)
    {
        this.jTextTenDiaDiem = jTextTenDiaDiem;
    }

    public String getMaDiaDiem()
    {
        return maDiaDiem;
    }

    public void setMaDiaDiem(String maDiaDiem)
    {
        this.maDiaDiem = maDiaDiem;
    }

    public String getTenDiaDiem()
    {
        return tenDiaDiem;
    }

    public void setTenDiaDiem(String TenDiaDiem)
    {
        this.tenDiaDiem = TenDiaDiem;
    }

    public JPanel getjPanel2()
    {
        return jPanelQLTour;
    }

    public void setjPanel2(JPanel jPanel2)
    {
        this.jPanelQLTour = jPanel2;
    }

    public JButton getjButtonExcel()
    {
        return jBtnThemTour;
    }

    public void setjButtonExcel(JButton jButtonExcel)
    {
        this.jBtnThemTour = jButtonExcel;
    }

    public JTextField getjTextGiaTour()
    {
        return jTextGiaTour;
    }

    public void setjTextGiaTour(JTextField jTextGiaTour)
    {
        this.jTextGiaTour = jTextGiaTour;
    }

    public JTextField getjTextLoaiHinh()
    {
        return jTextLoaiHinh;
    }

    public void setjTextLoaiHinh(JTextField jTextLoaiHinh)
    {
        this.jTextLoaiHinh = jTextLoaiHinh;
    }

    public String getMaTour()
    {
        return maTour;
    }

    public void setMaTour(String maTour)
    {
        this.maTour = maTour;
    }

    public String getMaLoai()
    {
        return maLoai;
    }

    public void setMaLoai(String maLoai)
    {
        this.maLoai = maLoai;
    }

    public String getMaGia()
    {
        return maGia;
    }

    public void setMaGia(String maGia)
    {
        this.maGia = maGia;
    }

    public String getMaGiaHienHanh()
    {
        return maGiaHienHanh;
    }

    public void setMaGiaHienHanh(String maGiaHienHanh)
    {
        this.maGiaHienHanh = maGiaHienHanh;
    }

    public String getMaLoaiHienHanh()
    {
        return maLoaiHienHanh;
    }

    public void setMaLoaiHienHanh(String maLoaiHienHanh)
    {
        this.maLoaiHienHanh = maLoaiHienHanh;
    }

    public String getTenTour()
    {
        return tenTour;
    }

    public void setTenTour(String tenTour)
    {
        this.tenTour = tenTour;
    }

    public JDateChooser getjDateNgayBD()
    {
        return jDateNgayBD;
    }

    public void setjDateNgayBD(JDateChooser jDateNgayBD)
    {
        this.jDateNgayBD = jDateNgayBD;
    }

    public JDateChooser getjDateNgayKT()
    {
        return jDateNgayKT;
    }

    public void setjDateNgayKT(JDateChooser jDateNgayKT)
    {
        this.jDateNgayKT = jDateNgayKT;
    }

    public JButton getjBtnThemDD()
    {
        return jBtnThemDD;
    }

    public void setjBtnThemDD(JButton jBtnThemDD)
    {
        this.jBtnThemDD = jBtnThemDD;
    }

    public JButton getjBtnHuyDD()
    {
        return jBtnHuyDD;
    }

    public void setjBtnHuyDD(JButton jBtnHuyDD)
    {
        this.jBtnHuyDD = jBtnHuyDD;
    }

    public ArrayList<DiaDiemThamQuanDTO> getDiaDiemThamQuanTempArr()
    {
        return diaDiemThamQuanTempArr;
    }

    public void setDiaDiemThamQuanTempArr(ArrayList<DiaDiemThamQuanDTO> diaDiemThamQuanTempArr)
    {
        this.diaDiemThamQuanTempArr = diaDiemThamQuanTempArr;
    }

    public JTextField getjTextThuTu()
    {
        return jTextThuTu;
    }

    public void setjTextThuTu(JTextField jTextThuTu)
    {
        this.jTextThuTu = jTextThuTu;
    }

    public JPanel getjPanelChiTietTour()
    {
        return jPanelChiTietTour;
    }

    public void setjPanelChiTietTour(JPanel jPanelChiTietTour)
    {
        this.jPanelChiTietTour = jPanelChiTietTour;
    }

    public void resetAll()
    {
        System.out.println("Reset ALL!!");
        jTextMaTour.setText("");
        jTextTenTour.setText("");
        jTextLoaiHinh.setText("");
        jTextDacDiem.setText("");
        jTextGiaTour.setText("");
        jDateNgayBD.setCalendar(null);
        jDateNgayKT.setCalendar(null);
        jBtnXemTour.setEnabled(false);
        jBtnSuaTour.setEnabled(false);
        jBtnThemTour.setEnabled(false);
        jBtnHuyTour.setEnabled(false);
        jBtnXoaTour.setEnabled(false);
        jBtnCapPhatMaTour.setEnabled(true);
        jBtnChonLoaiHinh.setEnabled(false);
        jBtnChonGiaTour.setEnabled(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnCapPhatMaTour;
    private javax.swing.JButton jBtnChonDiaDiem;
    private javax.swing.JButton jBtnChonGiaTour;
    private javax.swing.JButton jBtnChonLoaiHinh;
    private javax.swing.JButton jBtnHuyDD;
    private javax.swing.JButton jBtnHuyTour;
    private javax.swing.JButton jBtnLuuDD;
    private javax.swing.JButton jBtnRefresh1;
    private javax.swing.JButton jBtnRefreshTour;
    private javax.swing.JButton jBtnSuaDD;
    private javax.swing.JButton jBtnSuaTour;
    private javax.swing.JButton jBtnThemDD;
    private javax.swing.JButton jBtnThemTour;
    private javax.swing.JButton jBtnTimKiemTour;
    private javax.swing.JButton jBtnXemTour;
    private javax.swing.JButton jBtnXoaDD;
    private javax.swing.JButton jBtnXoaDD1;
    private javax.swing.JButton jBtnXoaTour;
    private javax.swing.JButton jButtonQuayLai;
    private javax.swing.JButton jButtonTimKiem1;
    private com.toedter.calendar.JDateChooser jDateNgayBD;
    private com.toedter.calendar.JDateChooser jDateNgayKT;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelDacDiem;
    private javax.swing.JLabel jLabelLoạiHinh;
    private javax.swing.JLabel jLabelMaTour;
    private javax.swing.JLabel jLabelTenTour;
    private javax.swing.JLabel jLbDiaDiem;
    private javax.swing.JLabel jLbManv;
    private javax.swing.JLabel jLbThuTu;
    private javax.swing.JLabel jLbThuTu1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanelChiTietTour;
    private javax.swing.JPanel jPanelQLTour;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableDiadiem;
    private javax.swing.JTable jTableDoan;
    private javax.swing.JTable jTableTour;
    private javax.swing.JTextArea jTextDacDiem;
    private javax.swing.JTextField jTextGiaTour;
    private javax.swing.JTextField jTextLoaiHinh;
    private javax.swing.JTextField jTextMaDiaDiem;
    private javax.swing.JTextField jTextMaTour;
    private javax.swing.JTextField jTextMaTour1;
    private javax.swing.JTextField jTextTenDiaDiem;
    private javax.swing.JTextField jTextTenTour;
    private javax.swing.JTextField jTextTenTour1;
    private javax.swing.JTextField jTextThuTu;
    private javax.swing.JTextField jTextTimKiemNV1;
    private javax.swing.JTextField jTextTimKiemTour;
    // End of variables declaration//GEN-END:variables
}
