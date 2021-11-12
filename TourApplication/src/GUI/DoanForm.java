/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.*;
import BUS.DoanDuLichBUS;
import BUS.Utils;
import DAO.DoanDuLichDAO;
import DTO.ChiPhiDTO;
import DTO.ChiTietDoanDTO;
import DTO.DoanDuLichDTO;
import DTO.GiaTourDTO;
import DTO.KhachHangDTO;
import DTO.NhanVienDTO;
import DTO.NhiemVuNhanVienDTO;
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
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hyung
 */
public class DoanForm extends javax.swing.JPanel {

    /**
     * Creates new form jPanel2
     */
    DoanDuLichBUS doanDuLichBUS;
    public static ArrayList<DoanDuLichDTO> doanDuLichDTOs;
    public static ArrayList<NhanVienDTO> nhanVienDTOs;
    public static ArrayList<KhachHangDTO> khachHangDTOs;
    DoanDuLichDAO doanDuLichDAO;
    int rowDoan, rowKhach, flagThemDiaDiem, rowNV;
    private String maDoan, tenDoan, maTour, maTourHienHanh, tongChiPhi;
    Vector tbColDoan = new Vector();//Vector chứa các dòng dữ liệu của bảng.
    Vector tbColKhach = new Vector();//Vector chứa các tiêu đề của bảng.
    Vector tbColNhanVien = new Vector();
    DefaultTableModel tbModelDoan, tbModelDiadiem, tbModelKhach, tbModelNhanVien;
    private Utils ult = new Utils();
    private String ngayBatDauGia = "";
    private String ngayKetThucGia = "";
    private String ngayKhoiHanh = "";

    public DoanForm() {
        initComponents();
        //initTableTour();
        jBtnCapPhatMaDoan.setEnabled(true);
        jBtnThemDoan.setEnabled(false);
        jBtnSuaDoan.setEnabled(false);
        jBtnXoaDoan.setEnabled(false);
        jBtnHuyDoan.setEnabled(false);
        jBtnXemDoan.setEnabled(false);
        jBtnChonTour.setEnabled(false);
        jBtnChonChiPhi.setEnabled(false);
        jDateNgayKH.setEnabled(false);
        jDateNgayKT.setEnabled(false);
        jBtnChonNV.setEnabled(false);
        jBtnThemNV.setEnabled(false);
        jBtnSuaNV.setEnabled(false);
        jBtnHuyNV.setEnabled(false);
        jBtnXoaNV.setEnabled(false);
        jBtnChonKhach.setEnabled(false);
        jBtnThemKhach.setEnabled(false);
        jBtnXoaKhach.setEnabled(false);
        jBtnHuyKhach.setEnabled(false);
    }

    public void tableModelDoan(DefaultTableModel model) {
        long startTime = System.currentTimeMillis();
        Vector row;
        for (DoanDuLichDTO doan : DashBoard.doanDuLichDTOs) {
            row = new Vector();
            row.add(doan.getMaDoan());
            row.add(doan.getTenDoan());
//            row.add(doanDuLichDAO.getTenTour(doan.getMaTour()));
//            row.add(doanDuLichDAO.getGiaTour(doan.getMaTour()));
            for (TourDTO tour : DashBoard.tourDTOs) {
                if (tour.getMaTour().equals(doan.getMaTour())) {
                    row.add(tour.getTenTour());
                    break;
                }
            }
            for (GiaTourDTO giaTour : DashBoard.giaTourDTOs) {
                if (giaTour.getMaTour().equals(doan.getMaTour()) && giaTour.getHienHanh() == 1) {
                    row.add(giaTour.getThanhTien());
                    break;
                }
            }
            row.add(doan.getNgayKhoiHanh());
            row.add(doan.getNgayKetThuc());
            model.addRow(row);
        }
        long finishTime = System.currentTimeMillis();
        long totalTime = finishTime - startTime;
        System.out.println("- Thời gian chạy: " + totalTime + " ms");
    }
    

    public void themVectorDoan(DefaultTableModel model, DoanDuLichDTO doanDTO, String tenTour) {
        Vector newrow = new Vector();
        newrow.add(doanDTO.getMaDoan());
        newrow.add(doanDTO.getTenDoan());
        newrow.add(tenTour);
        newrow.add(doanDTO.getGiaTour());
        newrow.add(doanDTO.getNgayKhoiHanh());
        newrow.add(doanDTO.getNgayKetThuc());
        model.addRow(newrow);
    }

    public void suaVectorDoan(DefaultTableModel model, int row, DoanDuLichDTO doanDTO, String tenTour) {
        model.setValueAt(doanDTO.getTenDoan(), row, 1);
        model.setValueAt(tenTour, row, 2);
        model.setValueAt(doanDTO.getGiaTour(), row, 3);
        model.setValueAt(doanDTO.getNgayKhoiHanh(), row, 4);
        model.setValueAt(doanDTO.getNgayKetThuc(), row, 5);
    }

    public void xoaVectorDoan(DefaultTableModel model, int row) {
        model.removeRow(row);
    }
    
    public void tableModelKhachHang(DefaultTableModel model) {
        long startTime = System.currentTimeMillis();
        Vector row;
        for (ChiTietDoanDTO chitietdoan : DashBoard.chiTietDoanDTOs) {
            if(chitietdoan.getMaDoan().equals(maDoan)){
                for(KhachHangDTO khachhang: DashBoard.khachHangDTOs){
                    if(khachhang.getMaKhachHang().equals(chitietdoan.getMaKhachHang())){
                        row = new Vector();
                        row.add(khachhang.getMaKhachHang());
                        row.add(khachhang.getTenKhachHang());
                        row.add(khachhang.getSDT());
                        model.addRow(row);
                    }
                } 
            }            
        }
        long finishTime = System.currentTimeMillis();
        long totalTime = finishTime - startTime;
        System.out.println("- Thời gian chạy: " + totalTime + " ms");
    }
    
    public void themVectorKhachHang(DefaultTableModel model, KhachHangDTO khachHangDTO) {
        Vector newrow = new Vector();
        newrow.add(khachHangDTO.getMaKhachHang());
        newrow.add(khachHangDTO.getTenKhachHang());
        newrow.add(khachHangDTO.getSDT());
        model.addRow(newrow);
    }

    public void suaVectorKhachHang(DefaultTableModel model, int row, KhachHangDTO khachHangDTO, String tenKhachHang,String sdt) {
        model.setValueAt(khachHangDTO.getMaKhachHang(), rowKhach, 1);
        model.setValueAt(khachHangDTO.getTenKhachHang(), rowKhach, 2);
        model.setValueAt(khachHangDTO.getSDT(), rowKhach, 3);
    }

    public void xoaVectorKhachHang(DefaultTableModel model, int row) {
        model.removeRow(row);
    }
    
    public void tableModelNhanVien(DefaultTableModel model) {
        long startTime = System.currentTimeMillis();
        Vector row;
        for (NhiemVuNhanVienDTO nhiemvunhanvien : DashBoard.nhiemVuNhanVienDTOs) {
//            System.out.println(nhiemvunhanvien);
//            row = new Vector();
//            row.add(nhiemvunhanvien.getMaNhanVien());
//            row.add(nhiemvunhanvien.getMaDoan());
//            row.add(nhiemvunhanvien.getTenNhiemVu());
            if(nhiemvunhanvien.getMaDoan().equals(maDoan)){
                
                for(NhanVienDTO nhanvien : DashBoard.nhanVienDTOs){
                    if(nhanvien.getMaNhanVien().equals(nhiemvunhanvien.getMaNhanVien())){
                        row = new Vector();
                        row.add(nhanvien.getMaNhanVien());
                        row.add(nhanvien.getTenNhanVien());
                        row.add(nhiemvunhanvien.getTenNhiemVu());
                        model.addRow(row);
                    }
                }
            }
        }
        long finishTime = System.currentTimeMillis();
        long totalTime = finishTime - startTime;
        System.out.println("- Thời gian chạy: " + totalTime + " ms");
    }
    
    public void themVectorNhanVien(DefaultTableModel model, String maNhanVien, String tenNhanVien, String nhiemVu) {
        Vector newrow = new Vector();
        newrow.add(maNhanVien);
        newrow.add(tenNhanVien);
        newrow.add(nhiemVu);
        model.addRow(newrow);
    }

    public void suaVectorNhanVien(DefaultTableModel model, String maNhanVien, String tenNhanVien, String nhiemVu) {
        model.setValueAt(maNhanVien, rowNV, 1);
        model.setValueAt(tenNhanVien, rowNV, 2);
        model.setValueAt(nhiemVu, rowNV, 3);
    }

    public void xoaVectorNhanVien(DefaultTableModel model, int row) {
        model.removeRow(row);
    }
    
    

    public void loadDataDoan() {
        doanDuLichBUS = new DoanDuLichBUS();
        tbModelDoan.setRowCount(0);
        tableModelDoan(tbModelDoan);
        jTableDoan.setModel(tbModelDoan);
    }

    public String getNgayBatDauGia() {
        return ngayBatDauGia;
    }

    public void setNgayBatDauGia(String ngayBatDauGia) {
        this.ngayBatDauGia = ngayBatDauGia;
    }

    public String getNgayKetThucGia() {
        return ngayKetThucGia;
    }

    public void setNgayKetThucGia(String ngayKetThucGia) {
        this.ngayKetThucGia = ngayKetThucGia;
    }

    public void initTableDoan() {
        loadDataDoan();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanelQLTour = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jTextGiaTour = new javax.swing.JTextField();
        jDateNgayKT = new com.toedter.calendar.JDateChooser();
        jLabel22 = new javax.swing.JLabel();
        jTextTenDoan = new javax.swing.JTextField();
        jTextTour = new javax.swing.JTextField();
        jBtnChonChiPhi = new javax.swing.JButton();
        jDateNgayKH = new com.toedter.calendar.JDateChooser();
        jBtnCapPhatMaDoan = new javax.swing.JButton();
        jTextMaDoan = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLbManv = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLbManv1 = new javax.swing.JLabel();
        jTextChiPhi = new javax.swing.JTextField();
        jBtnChonTour = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextChiTiet = new javax.swing.JTextArea();
        jBtnThemDoan = new javax.swing.JButton();
        jBtnXoaDoan = new javax.swing.JButton();
        jBtnSuaDoan = new javax.swing.JButton();
        jTextTimKiemDoan = new javax.swing.JTextField();
        jBtnTimKiemDoan = new javax.swing.JButton();
        jBtnRefreshDoan = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDoan = new javax.swing.JTable();
        jBtnXemDoan = new javax.swing.JButton();
        jBtnHuyDoan = new javax.swing.JButton();
        jPanelChiTietTour = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jTextMaDoanChiTiet = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jTextTenDoanChiTiet = new javax.swing.JTextField();
        jPanelNhanVien = new javax.swing.JPanel();
        jLbMaNV = new javax.swing.JLabel();
        jTextTenNV = new javax.swing.JTextField();
        jTextMaNV = new javax.swing.JTextField();
        jLbTenNV = new javax.swing.JLabel();
        jBtnThemNV = new javax.swing.JButton();
        jBtnSuaNV = new javax.swing.JButton();
        jTextNhiemVu = new javax.swing.JTextField();
        jBtnHuyNV = new javax.swing.JButton();
        jBtnXoaNV = new javax.swing.JButton();
        jLbNhiemVu = new javax.swing.JLabel();
        jBtnChonNV = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableNhanVien = new javax.swing.JTable();
        jPanelKhachHang = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jTextTenKhach = new javax.swing.JTextField();
        jTextMaKhach = new javax.swing.JTextField();
        jBtnChonKhach = new javax.swing.JButton();
        jLbTenKhach = new javax.swing.JLabel();
        jBtnThemKhach = new javax.swing.JButton();
        jTextSDT = new javax.swing.JTextField();
        jBtnHuyKhach = new javax.swing.JButton();
        jBtnXoaKhach = new javax.swing.JButton();
        jLbSDT = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableKhachHang = new javax.swing.JTable();

        setBackground(new java.awt.Color(233, 242, 249));
        setPreferredSize(new java.awt.Dimension(990, 650));

        jTabbedPane1.setBackground(new java.awt.Color(233, 242, 249));
        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jPanelQLTour.setBackground(new java.awt.Color(233, 242, 249));

        jPanel4.setBackground(new java.awt.Color(233, 242, 249));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin Ðoàn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(0, 51, 102)));
        jPanel4.setPreferredSize(new java.awt.Dimension(1000, 550));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel26.setText("<html> <body>Ngày Kết Thúc<span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");
        jPanel4.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, -1, 30));

        jLabel24.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel24.setText("<html> <body>Chi Tiết<span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");
        jPanel4.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, 30));

        jTextGiaTour.setEditable(false);
        jTextGiaTour.setBackground(new java.awt.Color(214, 217, 223));
        jTextGiaTour.setForeground(new java.awt.Color(51, 51, 51));
        jTextGiaTour.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel4.add(jTextGiaTour, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 30, 200, 30));

        jDateNgayKT.setBackground(new java.awt.Color(214, 217, 223));
        jDateNgayKT.setDateFormatString("yyyy-MM-dd");
        JTextFieldDateEditor editorKT = (JTextFieldDateEditor) jDateNgayKT.getDateEditor();
        editorKT.setEditable(false);
        jPanel4.add(jDateNgayKT, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 110, 200, 30));

        jLabel22.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel22.setText("<html> <body>Tên Ðoàn<span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");
        jPanel4.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, 30));

        jTextTenDoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextTenDoanActionPerformed(evt);
            }
        });
        jPanel4.add(jTextTenDoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 170, 30));

        jTextTour.setEditable(false);
        jTextTour.setBackground(new java.awt.Color(214, 217, 223));
        jPanel4.add(jTextTour, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 170, 30));

        jBtnChonChiPhi.setBackground(new java.awt.Color(136, 193, 184));
        jBtnChonChiPhi.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        jBtnChonChiPhi.setText("...");
        jBtnChonChiPhi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnChonChiPhi.setPreferredSize(new java.awt.Dimension(30, 30));
        jBtnChonChiPhi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnChonChiPhiActionPerformed(evt);
            }
        });
        jPanel4.add(jBtnChonChiPhi, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 150, -1, -1));

        jDateNgayKH.setBackground(new java.awt.Color(214, 217, 223));
        jDateNgayKH.setDateFormatString("yyyy-MM-dd");
        JTextFieldDateEditor editorKH = (JTextFieldDateEditor) jDateNgayKH.getDateEditor();
        editorKH.setEditable(false);
        jPanel4.add(jDateNgayKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, 200, 30));

        jBtnCapPhatMaDoan.setBackground(new java.awt.Color(81, 113, 131));
        jBtnCapPhatMaDoan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_add_32.png"))); // NOI18N
        jBtnCapPhatMaDoan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnCapPhatMaDoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCapPhatMaDoanActionPerformed(evt);
            }
        });
        jPanel4.add(jBtnCapPhatMaDoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, 30, 30));

        jTextMaDoan.setEditable(false);
        jTextMaDoan.setBackground(new java.awt.Color(214, 217, 223));
        jTextChiPhi.setEditable(false);
        jPanel4.add(jTextMaDoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 170, 30));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("<html> <body> Mã Đoàn <span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, 30));

        jLabel25.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel25.setText("<html> <body>Ngày Khởi Hành<span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");
        jPanel4.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, -1, 30));

        jLbManv.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLbManv.setText("<html> <body>Giá Tour<span style=\"color:rgb(234, 21, 21)\"> *</span> </body> </html>");
        jPanel4.add(jLbManv, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, -1, 30));

        jLabel28.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel28.setText("<html> <body>Tour<span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");
        jPanel4.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, 30));

        jLbManv1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLbManv1.setText("<html> <body>Tổng Chi Phí<span style=\"color:rgb(234, 21, 21)\"> *</span> </body> </html>");
        jPanel4.add(jLbManv1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 150, -1, 30));

        jTextChiPhi.setEditable(false);
        jTextChiPhi.setBackground(new java.awt.Color(214, 217, 223));
        jTextChiPhi.setForeground(new java.awt.Color(51, 51, 51));
        jTextChiPhi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel4.add(jTextChiPhi, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 150, 160, 30));

        jBtnChonTour.setBackground(new java.awt.Color(136, 193, 184));
        jBtnChonTour.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        jBtnChonTour.setText("...");
        jBtnChonTour.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnChonTour.setPreferredSize(new java.awt.Dimension(30, 30));
        jBtnChonTour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnChonTourActionPerformed(evt);
            }
        });
        jPanel4.add(jBtnChonTour, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, -1, -1));

        jTextChiTiet.setColumns(20);
        jTextChiTiet.setRows(5);
        jScrollPane2.setViewportView(jTextChiTiet);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 210, 70));

        jBtnThemDoan.setBackground(new java.awt.Color(136, 193, 184));
        jBtnThemDoan.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnThemDoan.setText("Thêm");
        jBtnThemDoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnThemDoanActionPerformed(evt);
            }
        });

        jBtnXoaDoan.setBackground(new java.awt.Color(136, 193, 184));
        jBtnXoaDoan.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnXoaDoan.setText("Xóa");
        jBtnXoaDoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnXoaDoanActionPerformed(evt);
            }
        });

        jBtnSuaDoan.setBackground(new java.awt.Color(136, 193, 184));
        jBtnSuaDoan.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnSuaDoan.setText("Sửa");
        jBtnSuaDoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSuaDoanActionPerformed(evt);
            }
        });

        jBtnTimKiemDoan.setText("Tìm kiếm");
        jBtnTimKiemDoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnTimKiemDoanActionPerformed(evt);
            }
        });

        jBtnRefreshDoan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/refresh_25px.png"))); // NOI18N
        jBtnRefreshDoan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnRefreshDoan.setMaximumSize(new java.awt.Dimension(50, 50));
        jBtnRefreshDoan.setMinimumSize(new java.awt.Dimension(50, 50));
        jBtnRefreshDoan.setPreferredSize(new java.awt.Dimension(50, 50));
        jBtnRefreshDoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRefreshDoanActionPerformed(evt);
            }
        });

        jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setAutoscrolls(true);

        jTableDoan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableDoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableDoanMouseClicked(evt);
            }
        });
        tbColDoan.add("Mă Ðoàn");
        tbColDoan.add("Tên Ðoàn");
        tbColDoan.add("Tên Tour");
        tbColDoan.add("Giá Tour");
        tbColDoan.add("Ngày Khởi Hành");
        tbColDoan.add("Ngày Kết Thúc");

        tbModelDoan= new DefaultTableModel(tbColDoan,40){
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex){
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
        jScrollPane1.setViewportView(jTableDoan);
        jTableDoan.setAutoResizeMode (javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);

        jBtnXemDoan.setBackground(new java.awt.Color(136, 193, 184));
        jBtnXemDoan.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnXemDoan.setText("Xem");
        jBtnXemDoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnXemDoanActionPerformed(evt);
            }
        });

        jBtnHuyDoan.setBackground(new java.awt.Color(136, 193, 184));
        jBtnHuyDoan.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnHuyDoan.setText("Hủy");
        jBtnHuyDoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnHuyDoanActionPerformed(evt);
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
                        .addComponent(jTextTimKiemDoan, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnTimKiemDoan, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnRefreshDoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelQLTourLayout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 706, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanelQLTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelQLTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jBtnXoaDoan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBtnSuaDoan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jBtnThemDoan, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanelQLTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jBtnXemDoan, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtnHuyDoan, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                                    .addComponent(jBtnXemDoan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jBtnThemDoan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jBtnHuyDoan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelQLTourLayout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(jBtnSuaDoan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)
                                .addComponent(jBtnXoaDoan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanelQLTourLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelQLTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBtnRefreshDoan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelQLTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextTimKiemDoan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBtnTimKiemDoan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                .addGap(27, 27, 27))
        );

        jTabbedPane1.addTab("Quản Lý Ðoàn", jPanelQLTour);

        jPanelChiTietTour.setBackground(new java.awt.Color(233, 242, 249));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("<html> <body> Mã Đoàn <span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");

        jTextMaDoanChiTiet.setEditable(false);
        jTextMaDoanChiTiet.setBackground(new java.awt.Color(214, 217, 223));
        jTextChiPhi.setEditable(false);

        jLabel27.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel27.setText("<html> <body>Tên Đoàn<span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");

        jTextTenDoanChiTiet.setEditable(false);
        jTextTenDoanChiTiet.setBackground(new java.awt.Color(214, 217, 223));
        jTextTenDoanChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextTenDoanChiTietActionPerformed(evt);
            }
        });

        jPanelNhanVien.setBackground(new java.awt.Color(233, 242, 249));
        jPanelNhanVien.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nhân Viên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(0, 51, 102)));
        jPanelNhanVien.setPreferredSize(new java.awt.Dimension(1000, 550));
        jPanelNhanVien.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLbMaNV.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLbMaNV.setText("<html> <body>Mã Nhân Viên<span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");
        jPanelNhanVien.add(jLbMaNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, 30));

        jTextTenNV.setEditable(false);
        jTextTenNV.setBackground(new java.awt.Color(214, 217, 223));
        jTextTenNV.setForeground(new java.awt.Color(51, 51, 51));
        jTextTenNV.setRequestFocusEnabled(false);
        jPanelNhanVien.add(jTextTenNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 160, 30));

        jTextMaNV.setEditable(false);
        jTextMaNV.setBackground(new java.awt.Color(214, 217, 223));
        jPanelNhanVien.add(jTextMaNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 160, 30));

        jLbTenNV.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLbTenNV.setText("<html> <body>Tên Nhân Viên<span style=\"color:rgb(234, 21, 21)\">*</span> </body> </html>");
        jPanelNhanVien.add(jLbTenNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, 30));

        jBtnThemNV.setBackground(new java.awt.Color(136, 193, 184));
        jBtnThemNV.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnThemNV.setText("Thêm");
        jBtnThemNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnThemNVActionPerformed(evt);
            }
        });
        jPanelNhanVien.add(jBtnThemNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 80, 40));

        jBtnSuaNV.setBackground(new java.awt.Color(136, 193, 184));
        jBtnSuaNV.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnSuaNV.setText("Sửa");
        jBtnSuaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSuaNVActionPerformed(evt);
            }
        });
        jPanelNhanVien.add(jBtnSuaNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 80, 40));

        jTextNhiemVu.setForeground(new java.awt.Color(51, 51, 51));
        jTextNhiemVu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelNhanVien.add(jTextNhiemVu, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 160, 30));

        jBtnHuyNV.setBackground(new java.awt.Color(136, 193, 184));
        jBtnHuyNV.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnHuyNV.setText("Hủy");
        jBtnHuyNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnHuyNVActionPerformed(evt);
            }
        });
        jPanelNhanVien.add(jBtnHuyNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 170, 80, 40));

        jBtnXoaNV.setBackground(new java.awt.Color(136, 193, 184));
        jBtnXoaNV.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnXoaNV.setText("Xóa");
        jBtnXoaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnXoaNVActionPerformed(evt);
            }
        });
        jPanelNhanVien.add(jBtnXoaNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 80, 40));

        jLbNhiemVu.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLbNhiemVu.setText("<html> <body>Nhiệm Vụ<span style=\"color:rgb(234, 21, 21)\">*</span> </body> </html>");
        jPanelNhanVien.add(jLbNhiemVu, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, 30));

        jBtnChonNV.setBackground(new java.awt.Color(136, 193, 184));
        jBtnChonNV.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        jBtnChonNV.setText("...");
        jBtnChonNV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnChonNV.setPreferredSize(new java.awt.Dimension(30, 30));
        jBtnChonNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnChonNVActionPerformed(evt);
            }
        });
        jPanelNhanVien.add(jBtnChonNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, -1, -1));

        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jTableNhanVien.setAutoCreateRowSorter(true);
        jTableNhanVien.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTableNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableNhanVienMouseClicked(evt);
            }
        });
        tbColNhanVien.add("Mă Nhân Viên");
        tbColNhanVien.add("Tên Nhân Viên");
        tbColNhanVien.add("Nhiệm Vụ");
        tbModelNhanVien= new DefaultTableModel(tbColNhanVien,5){
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex){
                return false;
            }
        };
        jTableNhanVien.setModel (tbModelNhanVien);
        jTableNhanVien.setShowGrid(true);
        jTableNhanVien.setFocusable(false);
        jTableNhanVien.setIntercellSpacing(new Dimension(0,0));
        jTableNhanVien.setRowHeight(25);
        jTableNhanVien.getTableHeader().setOpaque(false);
        jTableNhanVien.setFillsViewportHeight(true);
        jTableNhanVien.getTableHeader().setBackground(new Color(232,57,99));
        jTableNhanVien.getTableHeader().setForeground(new Color(141, 22, 22));
        jTableNhanVien.getTableHeader().setFont (new Font("Dialog", Font.BOLD, 13));
        jTableNhanVien.setSelectionBackground(new Color(52,152,219));
        jTableNhanVien.setAutoResizeMode (javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane3.setViewportView(jTableNhanVien);

        jPanelKhachHang.setBackground(new java.awt.Color(233, 242, 249));
        jPanelKhachHang.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Khách Hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(0, 51, 102)));
        jPanelKhachHang.setPreferredSize(new java.awt.Dimension(1000, 550));
        jPanelKhachHang.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel30.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel30.setText("<html> <body>Mã Khách<span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");
        jPanelKhachHang.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, 30));

        jTextTenKhach.setEditable(false);
        jTextTenKhach.setBackground(new java.awt.Color(214, 217, 223));
        jTextTenKhach.setForeground(new java.awt.Color(51, 51, 51));
        jTextTenKhach.setRequestFocusEnabled(false);
        jPanelKhachHang.add(jTextTenKhach, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 160, 30));

        jTextMaKhach.setEditable(false);
        jTextMaKhach.setBackground(new java.awt.Color(214, 217, 223));
        jPanelKhachHang.add(jTextMaKhach, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 160, 30));

        jBtnChonKhach.setBackground(new java.awt.Color(136, 193, 184));
        jBtnChonKhach.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        jBtnChonKhach.setText("...");
        jBtnChonKhach.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnChonKhach.setPreferredSize(new java.awt.Dimension(30, 30));
        jBtnChonKhach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnChonKhachActionPerformed(evt);
            }
        });
        jPanelKhachHang.add(jBtnChonKhach, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, -1, -1));

        jLbTenKhach.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLbTenKhach.setText("<html> <body>Tên Khách<span style=\"color:rgb(234, 21, 21)\">*</span> </body> </html>");
        jPanelKhachHang.add(jLbTenKhach, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, 30));

        jBtnThemKhach.setBackground(new java.awt.Color(136, 193, 184));
        jBtnThemKhach.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnThemKhach.setText("Thêm");
        jBtnThemKhach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnThemKhachActionPerformed(evt);
            }
        });
        jPanelKhachHang.add(jBtnThemKhach, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 80, 40));

        jTextSDT.setEditable(false);
        jTextSDT.setBackground(new java.awt.Color(214, 217, 223));
        jTextSDT.setForeground(new java.awt.Color(51, 51, 51));
        jTextSDT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelKhachHang.add(jTextSDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 160, 30));

        jBtnHuyKhach.setBackground(new java.awt.Color(136, 193, 184));
        jBtnHuyKhach.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnHuyKhach.setText("Hủy");
        jBtnHuyKhach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnHuyKhachActionPerformed(evt);
            }
        });
        jPanelKhachHang.add(jBtnHuyKhach, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 170, 80, 40));

        jBtnXoaKhach.setBackground(new java.awt.Color(136, 193, 184));
        jBtnXoaKhach.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnXoaKhach.setText("Xóa");
        jBtnXoaKhach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnXoaKhachActionPerformed(evt);
            }
        });
        jPanelKhachHang.add(jBtnXoaKhach, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 80, 40));

        jLbSDT.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLbSDT.setText("<html> <body>Số Điện Thoại<span style=\"color:rgb(234, 21, 21)\">*</span> </body> </html>");
        jPanelKhachHang.add(jLbSDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, 30));

        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jTableKhachHang.setAutoCreateRowSorter(true);
        jTableKhachHang.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTableKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableKhachHangMouseClicked(evt);
            }
        });
        tbColKhach.add("Mă Khách");
        tbColKhach.add("Tên Khách");
        tbColKhach.add("SÐT");
        tbModelKhach= new DefaultTableModel(tbColKhach,5){
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex){
                return false;
            }
        };
        jTableKhachHang.setModel (tbModelKhach);
        jTableKhachHang.setShowGrid(true);
        jTableKhachHang.setFocusable(false);
        jTableKhachHang.setIntercellSpacing(new Dimension(0,0));
        jTableKhachHang.setRowHeight(25);
        jTableKhachHang.getTableHeader().setOpaque(false);
        jTableKhachHang.setFillsViewportHeight(true);
        jTableKhachHang.getTableHeader().setBackground(new Color(232,57,99));
        jTableKhachHang.getTableHeader().setForeground(new Color(141, 22, 22));
        jTableKhachHang.getTableHeader().setFont (new Font("Dialog", Font.BOLD, 13));
        jTableNhanVien.setSelectionBackground(new Color(52,152,219));
        jTableKhachHang.setAutoResizeMode (javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane4.setViewportView(jTableKhachHang);

        javax.swing.GroupLayout jPanelChiTietTourLayout = new javax.swing.GroupLayout(jPanelChiTietTour);
        jPanelChiTietTour.setLayout(jPanelChiTietTourLayout);
        jPanelChiTietTourLayout.setHorizontalGroup(
            jPanelChiTietTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelChiTietTourLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextMaDoanChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextTenDoanChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(375, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelChiTietTourLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanelChiTietTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelChiTietTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
                    .addComponent(jPanelNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(28, 28, 28))
        );
        jPanelChiTietTourLayout.setVerticalGroup(
            jPanelChiTietTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelChiTietTourLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelChiTietTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextMaDoanChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextTenDoanChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanelChiTietTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanelNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelChiTietTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Chi Tiết Ðoàn", jPanelChiTietTour);

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

    public String ktra() {
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

    private void jBtnThemDoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnThemDoanActionPerformed
        // TODO add your handling code here:jBtnCapPhatMaTour.setEnabled(true);
        DoanDuLichDTO doanDTO = new DoanDuLichDTO((String) jTextMaDoan.getText(),
                maTour,
                (String) jTextTenDoan.getText(),
                (String) jTextGiaTour.getText(),
                (String) ((JTextField) jDateNgayKH.getDateEditor().getUiComponent()).getText(),
                (String) ((JTextField) jDateNgayKT.getDateEditor().getUiComponent()).getText(),
                (String) jTextChiTiet.getText());

        //Validation
        StringBuilder message = new StringBuilder();
        Validation.notNullOrEmpty(message, "Tên đoàn", doanDTO.getTenDoan(), "Tour", doanDTO.getMaTour(),
                "Chi tiết", doanDTO.getChiTietNoiDung());
        Validation.positiveNumbers(message, "Gia tour", doanDTO.getGiaTour());
        boolean isDate = Validation.isDate(message, "Ngày khởi hành", doanDTO.getNgayKhoiHanh(), "Ngày kết thúc", doanDTO.getNgayKetThuc());
        if(isDate){
            Validation.afterOrEquals(message, "Ngày khởi hành", doanDTO.getNgayKhoiHanh(), "Ngày hiện tại",
                    new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            Validation.afterOrEquals(message, "Ngày khởi hành", doanDTO.getNgayKhoiHanh(), "Ngày bắt đầu của giá", ngayBatDauGia);
            Validation.afterOrEquals(message, "Ngày kết thúc", doanDTO.getNgayKetThuc(), "Ngày khởi hành", doanDTO.getNgayKhoiHanh());
            Validation.beforeOrEquals(message, "Ngày kết thúc", doanDTO.getNgayKetThuc(), "Ngày kết thúc của giá", ngayKetThucGia);
        }
        if(!message.toString().equals("")){
            JOptionPane.showMessageDialog(this, message.toString());
            return;
        }

        if (doanDuLichBUS.themDoan(doanDTO, DashBoard.doanDuLichDTOs)) {
            themVectorDoan(tbModelDoan, doanDTO, (String) jTextTour.getText());
            JOptionPane.showMessageDialog(this, "Thêm Đoàn thành công!");
        } else {
            JOptionPane.showMessageDialog(this, "Thêm Đoàn thất bại!");
        }
        jBtnCapPhatMaDoan.setEnabled(true);
        jBtnThemDoan.setEnabled(false);
        jBtnSuaDoan.setEnabled(false);
        jBtnXoaDoan.setEnabled(false);
        jBtnHuyDoan.setEnabled(false);
        jBtnXemDoan.setEnabled(false);
        jTextMaDoan.setText("");
        jTextTenDoan.setText("");
        jTextTour.setText("");
        jTextChiTiet.setText("");
        jTextGiaTour.setText("");
        jDateNgayKH.setCalendar(null);
        jDateNgayKT.setCalendar(null);
        jTextChiPhi.setText("");
        jBtnChonTour.setEnabled(false);
        jBtnChonChiPhi.setEnabled(false);
        jDateNgayKH.setEnabled(false);
        jDateNgayKT.setEnabled(false);
    }//GEN-LAST:event_jBtnThemDoanActionPerformed

    private void jBtnHuyNVActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnHuyNVActionPerformed
    {//GEN-HEADEREND:event_jBtnHuyNVActionPerformed
        // TODO add your handling code here:
        jBtnChonNV.setEnabled(true);
        jBtnThemNV.setEnabled(false);
        jBtnSuaNV.setEnabled(false);
        jBtnXoaNV.setEnabled(false);
        jBtnHuyNV.setEnabled(false);
//        jBtnLuuDD.setEnabled(false);
    }//GEN-LAST:event_jBtnHuyNVActionPerformed

    private void jBtnRefreshDoanActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnRefreshDoanActionPerformed
    {//GEN-HEADEREND:event_jBtnRefreshDoanActionPerformed
        //        // TODO add your handling code here:
        //        jTextTimKiemNV.setText("");
        //        tbnv.loadDataNV();
        //        tbModelTour.setRowCount(0);
        //        tbnv.bangnhanvien(tbModelTour);
        jTextTimKiemDoan.setText("");
        loadDataDoan();
    }//GEN-LAST:event_jBtnRefreshDoanActionPerformed

    private void jBtnTimKiemDoanActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnTimKiemDoanActionPerformed
    {//GEN-HEADEREND:event_jBtnTimKiemDoanActionPerformed
        // TODO add your handling code here:
        //        String manv = jTextTimKiemNV.getText();
        //        tbnv.searchbangnhanvien(tbModelTour, manv);
        //        jTable1.setModel(tbModelTour);
        //        System.out.println("click tim kiem");
    }//GEN-LAST:event_jBtnTimKiemDoanActionPerformed

    private void jBtnCapPhatMaDoanActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnCapPhatMaDoanActionPerformed
    {//GEN-HEADEREND:event_jBtnCapPhatMaDoanActionPerformed
        // TODO add your handling code here:
        jTextMaDoan.setText(ult.initMaDoanDuLich());
        jBtnCapPhatMaDoan.setEnabled(false);
        jBtnThemDoan.setEnabled(true);
        jBtnSuaDoan.setEnabled(false);
        jBtnXoaDoan.setEnabled(false);
        jBtnHuyDoan.setEnabled(true);
        jBtnXemDoan.setEnabled(false);
        jTextTenDoan.setText("");
        jTextTour.setText("");
        jTextChiTiet.setText("");
        jTextGiaTour.setText("");
        jDateNgayKH.setCalendar(null);
        jDateNgayKT.setCalendar(null);
        jBtnChonTour.setEnabled(true);
        jBtnChonChiPhi.setEnabled(false);
        jDateNgayKH.setEnabled(true);
        jDateNgayKT.setEnabled(true);
    }//GEN-LAST:event_jBtnCapPhatMaDoanActionPerformed

    private void jBtnChonChiPhiActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnChonChiPhiActionPerformed
    {//GEN-HEADEREND:event_jBtnChonChiPhiActionPerformed
        // TODO add your handling code here:
        BangChiPhi BangChiPhi = new BangChiPhi(maDoan, tenDoan, tongChiPhi);
//        bangLoaiHinh.tourForm = this;
        BangChiPhi.doanForm = this;
    }//GEN-LAST:event_jBtnChonChiPhiActionPerformed

    private void jBtnXoaDoanActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnXoaDoanActionPerformed
    {//GEN-HEADEREND:event_jBtnXoaDoanActionPerformed
        // TODO add your handling code here:
        DoanDuLichDTO doanDuLichDTO = new DoanDuLichDTO();
        doanDuLichDTO = searchDoan(maDoan);
        System.out.println(doanDuLichDTO);
        if (doanDuLichBUS.xoaDoan(doanDuLichDTO, DashBoard.doanDuLichDTOs)) {
            xoaVectorDoan(tbModelDoan, rowDoan);
            JOptionPane.showMessageDialog(this, "Xóa Đoàn thành công!");
        } else {
            JOptionPane.showMessageDialog(this, "Xóa Đoàn thất bại!");
        }
        jBtnCapPhatMaDoan.setEnabled(true);
        jBtnThemDoan.setEnabled(false);
        jBtnSuaDoan.setEnabled(false);
        jBtnXoaDoan.setEnabled(false);
        jBtnHuyDoan.setEnabled(false);
        jBtnXemDoan.setEnabled(false);
        jTextMaDoan.setText("");
        jTextTenDoan.setText("");
        jTextTour.setText("");
        jTextChiTiet.setText("");
        jTextGiaTour.setText("");
        jDateNgayKH.setCalendar(null);
        jDateNgayKT.setCalendar(null);
        jTextChiPhi.setText("");
        jBtnChonTour.setEnabled(false);
        jBtnChonChiPhi.setEnabled(false);
        jDateNgayKH.setEnabled(false);
        jDateNgayKT.setEnabled(false);
    }//GEN-LAST:event_jBtnXoaDoanActionPerformed

    private void jBtnSuaDoanActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnSuaDoanActionPerformed
    {//GEN-HEADEREND:event_jBtnSuaDoanActionPerformed
        // TODO add your handling code here:
        String tenTour = (String) jTextTour.getText();
        System.out.println("Sua tour: " + maDoan);
        DoanDuLichDTO doanDTO = new DoanDuLichDTO(maDoan,
                maTour,
                (String) jTextTenDoan.getText(),
                (String) jTextGiaTour.getText(),
                (String) ((JTextField) jDateNgayKH.getDateEditor().getUiComponent()).getText(),
                (String) ((JTextField) jDateNgayKT.getDateEditor().getUiComponent()).getText(),
                (String) jTextChiTiet.getText());

        //Validation
        StringBuilder message = new StringBuilder();
        Validation.notNullOrEmpty(message, "Tên đoàn", doanDTO.getTenDoan(), "Tour", doanDTO.getMaTour(),
                "Chi tiết", doanDTO.getChiTietNoiDung());
        Validation.positiveNumbers(message, "Gia tour", doanDTO.getGiaTour());
        boolean isDate = Validation.isDate(message, "Ngày khởi hành", doanDTO.getNgayKhoiHanh(), "Ngày kết thúc", doanDTO.getNgayKetThuc());
        if(isDate){
            Validation.afterOrEquals(message, "Ngày khởi hành", doanDTO.getNgayKhoiHanh(), "Ngày hiện tại", ngayKhoiHanh);
            Validation.afterOrEquals(message, "Ngày khởi hành", doanDTO.getNgayKhoiHanh(), "Ngày bắt đầu của giá", ngayBatDauGia);
            Validation.afterOrEquals(message, "Ngày kết thúc", doanDTO.getNgayKetThuc(), "Ngày khởi hành", doanDTO.getNgayKhoiHanh());
            Validation.beforeOrEquals(message, "Ngày kết thúc", doanDTO.getNgayKetThuc(), "Ngày kết thúc của giá", ngayKetThucGia);
        }
        if(!message.toString().equals("")){
            JOptionPane.showMessageDialog(this, message.toString());
            return;
        }

        if (doanDuLichBUS.suaDoan(doanDTO, DashBoard.doanDuLichDTOs, maTourHienHanh)) {
            suaVectorDoan(tbModelDoan, rowDoan, doanDTO, tenTour);
            JOptionPane.showMessageDialog(this, "Sửa Đoàn thành công!");
        } else {
            JOptionPane.showMessageDialog(this, "Sửa Đoàn thất bại!");
        }
        jBtnCapPhatMaDoan.setEnabled(true);
        jBtnThemDoan.setEnabled(false);
        jBtnSuaDoan.setEnabled(false);
        jBtnXoaDoan.setEnabled(false);
        jBtnHuyDoan.setEnabled(false);
        jBtnXemDoan.setEnabled(false);
        jTextMaDoan.setText("");
        jTextTenDoan.setText("");
        jTextTour.setText("");
        jTextChiTiet.setText("");
        jTextGiaTour.setText("");
        jDateNgayKH.setCalendar(null);
        jDateNgayKT.setCalendar(null);
        jTextChiPhi.setText("");
        jBtnChonChiPhi.setEnabled(false);
        jBtnChonTour.setEnabled(false);
        jDateNgayKH.setEnabled(false);
        jDateNgayKT.setEnabled(false);
    }//GEN-LAST:event_jBtnSuaDoanActionPerformed

    private void jTextTenDoanActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jTextTenDoanActionPerformed
    {//GEN-HEADEREND:event_jTextTenDoanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextTenDoanActionPerformed

    private void jTextTenDoanChiTietActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jTextTenDoanChiTietActionPerformed
    {//GEN-HEADEREND:event_jTextTenDoanChiTietActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextTenDoanChiTietActionPerformed

    private void jBtnChonNVActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnChonNVActionPerformed
    {//GEN-HEADEREND:event_jBtnChonNVActionPerformed
        // TODO add your handling code here:
        BangNhanVien bangNhanVien = new BangNhanVien();
        bangNhanVien.doanForm = this;
//        bangDiaDiem.tourForm = this;
//        bangDiaDiem.loadData();
    }//GEN-LAST:event_jBtnChonNVActionPerformed

    private void jBtnXoaNVActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnXoaNVActionPerformed
    {//GEN-HEADEREND:event_jBtnXoaNVActionPerformed
        // TODO add your handling code here:
        jBtnChonNV.setEnabled(true);
        jBtnThemNV.setEnabled(false);
        jBtnSuaNV.setEnabled(false);
        jBtnXoaNV.setEnabled(false);
        jBtnHuyNV.setEnabled(false);
    }//GEN-LAST:event_jBtnXoaNVActionPerformed

    private void jBtnThemNVActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnThemNVActionPerformed
    {//GEN-HEADEREND:event_jBtnThemNVActionPerformed
        // TODO add your handling code here:
        jBtnChonNV.setEnabled(true);
        jBtnThemNV.setEnabled(false);
        jBtnSuaNV.setEnabled(false);
        jBtnXoaNV.setEnabled(false);
        jBtnHuyNV.setEnabled(false);
    }//GEN-LAST:event_jBtnThemNVActionPerformed

    private void jBtnSuaNVActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnSuaNVActionPerformed
    {//GEN-HEADEREND:event_jBtnSuaNVActionPerformed
        // TODO add your handling code here:
        jBtnChonNV.setEnabled(true);
        jBtnThemNV.setEnabled(false);
        jBtnSuaNV.setEnabled(false);
        jBtnXoaNV.setEnabled(false);
        jBtnHuyNV.setEnabled(false);
    }//GEN-LAST:event_jBtnSuaNVActionPerformed

    private void jTableNhanVienMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jTableNhanVienMouseClicked
    {//GEN-HEADEREND:event_jTableNhanVienMouseClicked
        // TODO add your handling code here:
        rowNV = jTableNhanVien.getSelectedRow();
        jTextMaNV.setText(tbModelNhanVien.getValueAt(rowNV, 0).toString());
        jTextTenNV.setText(tbModelNhanVien.getValueAt(rowNV, 1).toString());
        jTextNhiemVu.setText(tbModelNhanVien.getValueAt(rowNV, 2).toString());
//        rowKhach = jTableNhanVien.getSelectedRow();
//        jTextMaNV.setText((String) jTableNhanVien.getValueAt(rowKhach, 0));
//        //System.out.println((String) jTableDiadiem.getValueAt(rowKhach, 0));
//        jTextTenNV.setText((String) jTableNhanVien.getValueAt(rowKhach, 1));
//        jTextNhiemVu.setText(Integer.toString((int) jTableNhanVien.getValueAt(rowKhach, 2)));
        //System.out.println(Integer.toString( Integer.parseInt((String)jTableDiadiem.getValueAt(rowKhach, 2))));
//        if (flagThemDiaDiem == 1) { // NẾU TOUR CHƯA CÓ ĐOÀN
//            jBtnChonNV.setEnabled(false);
//            jBtnThemNV.setEnabled(false);
//            jBtnSuaNV.setEnabled(true);
//            jBtnXoaNV.setEnabled(true);
//            jBtnHuyNV.setEnabled(true);
////            jBtnLuuDD.setEnabled(false);
//        } else { // NẾU CÓ ĐOÀN
//            jBtnChonNV.setEnabled(false);
//            jBtnThemNV.setEnabled(false);
//            jBtnSuaNV.setEnabled(false);
//            jBtnXoaNV.setEnabled(false);
//            jBtnHuyNV.setEnabled(false);
////            jBtnLuuDD.setEnabled(false);
//        }
        jBtnChonNV.setEnabled(false);
        jBtnThemNV.setEnabled(false);
        jBtnSuaNV.setEnabled(true);
        jBtnXoaNV.setEnabled(true);
        jBtnHuyNV.setEnabled(true);
    }//GEN-LAST:event_jTableNhanVienMouseClicked

    private void jBtnXemDoanActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnXemDoanActionPerformed
    {//GEN-HEADEREND:event_jBtnXemDoanActionPerformed
        jTabbedPane1.setSelectedIndex(1);
        tbModelKhach.setRowCount(0);
        tbModelNhanVien.setRowCount(0);
        tableModelKhachHang(tbModelKhach);
        tableModelNhanVien(tbModelNhanVien);//tbModelNhanVien
        jTextMaDoanChiTiet.setText(maDoan);
        jTextTenDoanChiTiet.setText(tenDoan);
        
//        rowDoan = jTableDoan.getSelectedRow();
//        jTextMaTour1.setText(maDoan);//System.out.println(maTourChiTiet);
//        jTextTenTour1.setText(tenDoan);
//        System.out.println(tenDoan);
//        tbModelDoan.setRowCount(0);
//        tbModelDiadiem.setRowCount(0);
//        chiTietTour.tbModelDiaDiemThamQuan(tbModelDiadiem, maDoan);
//        chiTietTour.tbModelDoanDuLich(tbModelDoan, maDoan);
//        System.out.println(chiTietTour.countDoanTrongTour(maDoan));
//        System.out.println(maDoan);
//        if (chiTietTour.countDoanTrongTour(maDoan) == 0) { // NẾU TOUR CHƯA CÓ ĐOÀN
//            flagThemDiaDiem = 1;
//            jBtnChonNV.setEnabled(true);
//            jBtnThemNV.setEnabled(false);
//            jBtnSuaNV.setEnabled(false);
//            jBtnXoaNV.setEnabled(false);
//            jBtnHuyNV.setEnabled(false);
////            jBtnLuuDD.setEnabled(false);
//        } else { // NẾU CÓ ĐOÀN
//            flagThemDiaDiem = 0;
//            jBtnChonNV.setEnabled(false);
//            jBtnThemNV.setEnabled(false);
//            jBtnSuaNV.setEnabled(false);
//            jBtnXoaNV.setEnabled(false);
//            jBtnHuyNV.setEnabled(false);
////            jBtnLuuDD.setEnabled(false);
//        }
        jBtnChonNV.setEnabled(true);
        jBtnThemNV.setEnabled(false);
        jBtnSuaNV.setEnabled(false);
        jBtnHuyNV.setEnabled(false);
        jBtnXoaNV.setEnabled(false);
        jBtnChonKhach.setEnabled(true);
        jBtnThemKhach.setEnabled(false);
        jBtnXoaKhach.setEnabled(false);
        jBtnHuyKhach.setEnabled(false);
    }//GEN-LAST:event_jBtnXemDoanActionPerformed

    private void jBtnHuyDoanActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnHuyDoanActionPerformed
    {//GEN-HEADEREND:event_jBtnHuyDoanActionPerformed
        // TODO add your handling code here:
        jBtnCapPhatMaDoan.setEnabled(true);
        jBtnThemDoan.setEnabled(false);
        jBtnSuaDoan.setEnabled(false);
        jBtnXoaDoan.setEnabled(false);
        jBtnHuyDoan.setEnabled(false);
        jBtnXemDoan.setEnabled(false);
        jTextMaDoan.setText("");
        jTextTenDoan.setText("");
        jTextTour.setText("");
        jTextChiTiet.setText("");
        jTextGiaTour.setText("");
        jDateNgayKH.setCalendar(null);
        jDateNgayKT.setCalendar(null);
        jTextChiPhi.setText("");
        jBtnChonTour.setEnabled(false);
        jBtnChonChiPhi.setEnabled(false);
        jDateNgayKH.setEnabled(false);
        jDateNgayKT.setEnabled(false);
    }//GEN-LAST:event_jBtnHuyDoanActionPerformed

    private void jTableDoanMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jTableDoanMouseClicked
    {//GEN-HEADEREND:event_jTableDoanMouseClicked
        long startTime = System.currentTimeMillis();
        if (evt.getSource() == jTableDoan) {
            rowDoan = jTableDoan.getSelectedRow();
            if (rowDoan != -1) {
                maDoan = (String) jTableDoan.getModel().getValueAt(rowDoan, 0);
                tenDoan = (String) jTableDoan.getModel().getValueAt(rowDoan, 1);
                if (!maDoan.equals("")) {
                    jTextMaDoan.setText(maDoan);
                    jTextTenDoan.setText(tenDoan);
                    jTextTour.setText(((String) jTableDoan.getModel().getValueAt(rowDoan, 2)));
                    jTextGiaTour.setText((String) jTableDoan.getModel().getValueAt(rowDoan, 3));
                    ngayKhoiHanh = (String) jTableDoan.getModel().getValueAt(rowDoan, 4);
                    try {
                        Date dateKH = new SimpleDateFormat("yyyy-MM-dd").parse(jTableDoan.getModel().getValueAt(rowDoan, 4).toString());
                        jDateNgayKH.setDate(dateKH);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(DoanForm.this, e);
                        System.out.println("- Load sai ngày bắt đầu!");
                    }
                    try {
                        Date dateKT = new SimpleDateFormat("yyyy-MM-dd").parse(jTableDoan.getModel().getValueAt(rowDoan, 5).toString());
                        jDateNgayKT.setDate(dateKT);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(DoanForm.this, e);
                        System.out.println("- Load sai ngày kết thúc!");
                    }
                    for (DoanDuLichDTO doan : DashBoard.doanDuLichDTOs) {
                        if (maDoan.equals(doan.getMaDoan())) {
                            jTextChiTiet.setText(doan.getChiTietNoiDung());
                            setMaTour(doan.getMaTour());
                            setMaTourHienHanh(doan.getMaTour());
                        }
                    }
                    // lấy giá trị ngày của giá tour
                    for (GiaTourDTO giaTourDTO: DashBoard.giaTourDTOs){
                        if(maTour.equals(giaTourDTO.getMaTour())){
                            ngayBatDauGia = giaTourDTO.getTgBatDau();
                            ngayKetThucGia = giaTourDTO.getTgKetThuc();
                            break;
                        }
                    }
                    long tongCP = 0;
                    for (ChiPhiDTO chiPhi : DashBoard.chiPhiDTOs) {
                        if (maDoan.equals(chiPhi.getMaDoan())) {
                            tongCP += Long.parseLong(chiPhi.getSoTien());
                        }
                    }
                    jTextChiPhi.setText(String.valueOf(tongCP));
                    setMaDoan(maDoan);
                    tongChiPhi = String.valueOf(tongCP);
                    jBtnCapPhatMaDoan.setEnabled(false);
                    jBtnThemDoan.setEnabled(false);
                    jBtnSuaDoan.setEnabled(true);
                    jBtnXoaDoan.setEnabled(true);
                    jBtnHuyDoan.setEnabled(true);
                    jBtnXemDoan.setEnabled(true);
                    jBtnChonTour.setEnabled(true);
                    jBtnChonChiPhi.setEnabled(true);
                    jDateNgayKH.setEnabled(true);
                    jDateNgayKT.setEnabled(true);
                } else {
                    jBtnCapPhatMaDoan.setEnabled(true);
                    jBtnThemDoan.setEnabled(false);
                    jBtnSuaDoan.setEnabled(false);
                    jBtnXoaDoan.setEnabled(false);
                    jBtnHuyDoan.setEnabled(false);
                    jBtnXemDoan.setEnabled(false);
                    jBtnChonTour.setEnabled(false);
                    jBtnChonChiPhi.setEnabled(false);
                    jDateNgayKH.setEnabled(false);
                    jDateNgayKT.setEnabled(false);
                }
            }
        }
        long finishTime = System.currentTimeMillis();
        long totalTime = finishTime - startTime;
        System.out.println("- Thời gian chạy: " + totalTime + " ms");
    }//GEN-LAST:event_jTableDoanMouseClicked

    private void jBtnChonKhachActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnChonKhachActionPerformed
    {//GEN-HEADEREND:event_jBtnChonKhachActionPerformed
        // TODO add your handling code here:
        BangKhach bangKhach = new BangKhach();
        bangKhach.doanForm = this;
    }//GEN-LAST:event_jBtnChonKhachActionPerformed

    private void jBtnThemKhachActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnThemKhachActionPerformed
    {//GEN-HEADEREND:event_jBtnThemKhachActionPerformed
        // TODO add your handling code here:
        jBtnChonKhach.setEnabled(true);
        jBtnThemKhach.setEnabled(false);
        jBtnXoaKhach.setEnabled(false);
        jBtnHuyKhach.setEnabled(false);
    }//GEN-LAST:event_jBtnThemKhachActionPerformed

    private void jBtnHuyKhachActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnHuyKhachActionPerformed
    {//GEN-HEADEREND:event_jBtnHuyKhachActionPerformed
        // TODO add your handling code here:
        jBtnChonKhach.setEnabled(true);
        jBtnThemKhach.setEnabled(false);
        jBtnXoaKhach.setEnabled(false);
        jBtnHuyKhach.setEnabled(false);
    }//GEN-LAST:event_jBtnHuyKhachActionPerformed

    private void jBtnXoaKhachActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnXoaKhachActionPerformed
    {//GEN-HEADEREND:event_jBtnXoaKhachActionPerformed
        // TODO add your handling code here:
        jBtnChonKhach.setEnabled(true);
        jBtnThemKhach.setEnabled(false);
        jBtnXoaKhach.setEnabled(false);
        jBtnHuyKhach.setEnabled(false);
    }//GEN-LAST:event_jBtnXoaKhachActionPerformed

    private void jTableKhachHangMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jTableKhachHangMouseClicked
    {//GEN-HEADEREND:event_jTableKhachHangMouseClicked
        // TODO add your handling code here:
        rowKhach = jTableKhachHang.getSelectedRow();
        jTextMaKhach.setText(tbModelKhach.getValueAt(rowKhach, 0).toString());
        jTextTenKhach.setText(tbModelKhach.getValueAt(rowKhach, 1).toString());
        jTextSDT.setText(tbModelKhach.getValueAt(rowKhach, 2).toString());
        jBtnChonKhach.setEnabled(false);
        jBtnThemKhach.setEnabled(false);
        jBtnXoaKhach.setEnabled(true);
        jBtnHuyKhach.setEnabled(true);
    }//GEN-LAST:event_jTableKhachHangMouseClicked

    private void jBtnChonTourActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnChonTourActionPerformed
    {//GEN-HEADEREND:event_jBtnChonTourActionPerformed
        // TODO add your handling code here:
        BangTour bangTour = new BangTour();
        bangTour.doanForm = this;
    }//GEN-LAST:event_jBtnChonTourActionPerformed

    public DoanDuLichDTO searchDoan(String maDoan) {
        for (DoanDuLichDTO a : DashBoard.doanDuLichDTOs) {
            if (a.getMaDoan().equals(maDoan)) {
                return a;
            }
        }
        return null;
    }

    public int getRowDoan() {
        return rowDoan;
    }

    public void setRowDoan(int rowDoan) {
        this.rowDoan = rowDoan;
    }

    public int getRowKhach() {
        return rowKhach;
    }

    public void setRowKhach(int rowKhach) {
        this.rowKhach = rowKhach;
    }

    public int getRowNV() {
        return rowNV;
    }

    public void setRowNV(int rowNV) {
        this.rowNV = rowNV;
    }

    public String getMaDoan() {
        return maDoan;
    }

    public void setMaDoan(String maDoan) {
        this.maDoan = maDoan;
    }

    public String getTenDoan() {
        return tenDoan;
    }

    public void setTenDoan(String tenDoan) {
        this.tenDoan = tenDoan;
    }

    public String getMaTour() {
        return maTour;
    }

    public void setMaTour(String maTour) {
        this.maTour = maTour;
    }

    public String getMaTourHienHanh() {
        return maTourHienHanh;
    }

    public void setMaTourHienHanh(String maTourHienHanh) {
        this.maTourHienHanh = maTourHienHanh;
    }

    public JTextField getjTextGiaTour() {
        return jTextGiaTour;
    }

    public void setjTextGiaTour(JTextField jTextGiaTour) {
        this.jTextGiaTour = jTextGiaTour;
    }

    public JTextField getjTextTour() {
        return jTextTour;
    }

    public void setjTextTour(JTextField jTextTour) {
        this.jTextTour = jTextTour;
    }

    public JTextField getjTextChiPhi() {
        return jTextChiPhi;
    }

    public void setjTextChiPhi(JTextField jTextChiPhi) {
        this.jTextChiPhi = jTextChiPhi;
    }

    public JButton getjBtnChonKhach() {
        return jBtnChonKhach;
    }

    public void setjBtnChonKhach(JButton jBtnChonKhach) {
        this.jBtnChonKhach = jBtnChonKhach;
    }

    public JButton getjBtnChonNV() {
        return jBtnChonNV;
    }

    public void setjBtnChonNV(JButton jBtnChonNV) {
        this.jBtnChonNV = jBtnChonNV;
    }

    public JButton getjBtnThemKhach() {
        return jBtnThemKhach;
    }

    public void setjBtnThemKhach(JButton jBtnThemKhach) {
        this.jBtnThemKhach = jBtnThemKhach;
    }

    public JButton getjBtnThemNV() {
        return jBtnThemNV;
    }

    public void setjBtnThemNV(JButton jBtnThemNV) {
        this.jBtnThemNV = jBtnThemNV;
    }

    public JButton getjBtnHuyKhach() {
        return jBtnHuyKhach;
    }

    public void setjBtnHuyKhach(JButton jBtnHuyKhach) {
        this.jBtnHuyKhach = jBtnHuyKhach;
    }

    public JButton getjBtnHuyNV() {
        return jBtnHuyNV;
    }

    public void setjBtnHuyNV(JButton jBtnHuyNV) {
        this.jBtnHuyNV = jBtnHuyNV;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnCapPhatMaDoan;
    private javax.swing.JButton jBtnChonChiPhi;
    private javax.swing.JButton jBtnChonKhach;
    private javax.swing.JButton jBtnChonNV;
    private javax.swing.JButton jBtnChonTour;
    private javax.swing.JButton jBtnHuyDoan;
    private javax.swing.JButton jBtnHuyKhach;
    private javax.swing.JButton jBtnHuyNV;
    private javax.swing.JButton jBtnRefreshDoan;
    private javax.swing.JButton jBtnSuaDoan;
    private javax.swing.JButton jBtnSuaNV;
    private javax.swing.JButton jBtnThemDoan;
    private javax.swing.JButton jBtnThemKhach;
    private javax.swing.JButton jBtnThemNV;
    private javax.swing.JButton jBtnTimKiemDoan;
    private javax.swing.JButton jBtnXemDoan;
    private javax.swing.JButton jBtnXoaDoan;
    private javax.swing.JButton jBtnXoaKhach;
    private javax.swing.JButton jBtnXoaNV;
    private com.toedter.calendar.JDateChooser jDateNgayKH;
    private com.toedter.calendar.JDateChooser jDateNgayKT;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLbMaNV;
    private javax.swing.JLabel jLbManv;
    private javax.swing.JLabel jLbManv1;
    private javax.swing.JLabel jLbNhiemVu;
    private javax.swing.JLabel jLbSDT;
    private javax.swing.JLabel jLbTenKhach;
    private javax.swing.JLabel jLbTenNV;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelChiTietTour;
    private javax.swing.JPanel jPanelKhachHang;
    private javax.swing.JPanel jPanelNhanVien;
    private javax.swing.JPanel jPanelQLTour;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableDoan;
    private javax.swing.JTable jTableKhachHang;
    private javax.swing.JTable jTableNhanVien;
    private javax.swing.JTextField jTextChiPhi;
    private javax.swing.JTextArea jTextChiTiet;
    private javax.swing.JTextField jTextGiaTour;
    private javax.swing.JTextField jTextMaDoan;
    private javax.swing.JTextField jTextMaDoanChiTiet;
    private javax.swing.JTextField jTextMaKhach;
    private javax.swing.JTextField jTextMaNV;
    private javax.swing.JTextField jTextNhiemVu;
    private javax.swing.JTextField jTextSDT;
    private javax.swing.JTextField jTextTenDoan;
    private javax.swing.JTextField jTextTenDoanChiTiet;
    private javax.swing.JTextField jTextTenKhach;
    private javax.swing.JTextField jTextTenNV;
    private javax.swing.JTextField jTextTimKiemDoan;
    private javax.swing.JTextField jTextTour;
    // End of variables declaration//GEN-END:variables
}
