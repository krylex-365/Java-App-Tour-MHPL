/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.*;
//import DAO.XuatExcel;
//import DTO.ChucVuDTO;
//import DTO.CongViecDTO;
//import DTO.PhongBanDTO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.ComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Hyung
 */
public class KhachHangForm extends javax.swing.JPanel
{

    /**
     * Creates new form jPanel2
     */
    static int flagtkmk = 0;
//    BangNhanvienBUS tbnv = new BangNhanvienBUS();
//    BangPhongBanBUS tbpb = new BangPhongBanBUS();
//    CongViecBUS tbcviec = new CongViecBUS();
//    ChucVuBUS tbchucvu = new ChucVuBUS();
    DefaultTableModel modelnv;
//    TaiKhoanForm tk = new TaiKhoanForm();
    public BufferedImage i = null;
    public String imgName = null;
    private int flagAcc;
    private String manv;
    private String mapb;
    private KhachHang khachHang;
    private int selectedRow;
    private Vector addRow;
    private Utils ult = new Utils();

    public KhachHangForm()
    {
        initComponents();
        loadData();
        jBtnThemNV.setEnabled(false);
        jBtnSuaNV.setEnabled(false);
        jBtnXoaNV.setEnabled(false);
        jBtnHuy1.setEnabled(false);
//        tk.setVisible(false);
    }
    
    public void loadData(){
        khachHang = new KhachHang();
        modelnv.setRowCount(0);
        khachHang.tbModelKhachHang(modelnv);
    }

    public void initThongtinNhanvien()
    {
//        if (flagAcc == 2)
//        {
//            int iDongDaChon = 0;
//            jTextManv.setText(jTable1.getModel().getValueAt(iDongDaChon, 0).toString());
//            jTextHonv.setText(jTable1.getModel().getValueAt(iDongDaChon, 1).toString());
//            jTextTennv.setText(jTable1.getModel().getValueAt(iDongDaChon, 2).toString());
//            try
//            {
//                Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(jTable1.getModel().getValueAt(iDongDaChon, 3).toString());
//                jDateNgaySinh.setDate(date2);
//            } catch (Exception e)
//            {
//                JOptionPane.showMessageDialog(nhanvienForm.this, e);
//                System.out.println("33333");
//            }
//            //                jDateChooser2.setDateFormatString (jTable1.getModel ().getValueAt (iDongDaChon, 4).toString ());
//            jTextNoiSinh.setText(jTable1.getModel().getValueAt(iDongDaChon, 4).toString());
//            jCbGioiTinh.setSelectedItem(jTable1.getModel().getValueAt(iDongDaChon, 5).toString());
//            jTextTdhv.setText(jTable1.getModel().getValueAt(iDongDaChon, 6).toString());
//            jTextCmnd.setText(jTable1.getModel().getValueAt(iDongDaChon, 7).toString());
//
//            try
//            {
//                Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(jTable1.getModel().getValueAt(iDongDaChon, 8).toString());
//                jDateNgaycapcmnd.setDate(date1);
//            } catch (Exception e)
//            {
//                JOptionPane.showMessageDialog(nhanvienForm.this, e);
//                System.out.println("222222");
//            }
//            //                jDateChooser1.setDateFormatString (jTable1.getModel ().getValueAt (iDongDaChon, 10).toString ());
//            jTextDiaChi.setText(jTable1.getModel().getValueAt(iDongDaChon, 9).toString());
//            jTextSDT.setText(jTable1.getModel().getValueAt(iDongDaChon, 10).toString());
//            jTextEmail.setText(jTable1.getModel().getValueAt(iDongDaChon, 11).toString());
//            String tenpb = (String) jTable1.getModel().getValueAt(iDongDaChon, 12);
//            String tencvu = (String) jTable1.getModel().getValueAt(iDongDaChon, 13);
//            String tencviec = (String) jTable1.getModel().getValueAt(iDongDaChon, 14);
//            jCbPhongBan.setSelectedItem(tbpb.getDspb().searchItem(tenpb));
//            jCbChucVu.setSelectedItem(tbchucvu.searchItem(tencvu));
//            jCbCongViec.setSelectedItem(tbcviec.searchItem(tencviec));
//            jTextLuongcb.setText(tbnv.returnLuongCB(jTable1.getModel().getValueAt(iDongDaChon, 0).toString()));
//            jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/" + jTextManv.getText() + ".jpg")));
//            flagtkmk = 1;
//            tk.getjTextTaiKhoan().setText(jTable1.getModel().getValueAt(iDongDaChon, 15).toString());
//            tk.getjPasswordField1().setText(jTable1.getModel().getValueAt(iDongDaChon, 16).toString());
//            jTabbedPane1.setSelectedComponent(jPanel1);
//            jBtnCapNhatNV.setEnabled(false);
//            tk.getjBtnThemNv().setEnabled(false);
//            tk.getjBtnSuaNv().setEnabled(true);
//            tk.getjCBquyen().setEnabled(false);
//            jBtnQuaylai.setEnabled(false);
//            jBtnHuy.setEnabled(false);
//            jButtonTimKiem.setEnabled(false);
//            jBtnRefresh.setEnabled(false);
//            jBtnXoaNV.setEnabled(false);
//            jBtnCapPhatMaNV.setEnabled(false);
//            jBtnCapNhatNV.setEnabled(false);
//            jTextHonv.setEditable(false);
//            jTextTennv.setEditable(false);
//            jTextLuongcb.setEditable(false);
//            jTextEmail.setEditable(false);
//            jTextDiaChi.setEditable(false);
//            jTextNoiSinh.setEditable(false);
//            jTextSDT.setEditable(false);
//            jTextTdhv.setEditable(false);
//            jTextCmnd.setEditable(false);
//            jCbGioiTinh.setEditable(false);
//            jCbChucVu.setEditable(false);
//            jCbCongViec.setEditable(false);
//            jCbPhongBan.setEditable(false);
//            jCbGioiTinh.setEnabled(false);
//            jCbChucVu.setEnabled(false);
//            jCbCongViec.setEnabled(false);
//            jCbPhongBan.setEnabled(false);
//            jDateNgaySinh.setEnabled(false);
//            jDateNgaycapcmnd.setEnabled(false);
//        }
    }

    public void initTableNhanvien()
    {
//        tbnv.loadDataNV();
//        modelnv.setRowCount(0);
//        if (flagAcc == 0)
//        {
//            tbnv.bangnhanvien(modelnv);
//            tk.setFlagAcc(0);
//        }
//        if (flagAcc == 1)
//        {
//            tbnv.bangnhanvienPB(modelnv, mapb);
//            tk.setFlagAcc(1);
//        }
//        if (flagAcc == 2)
//        {
//            tbnv.bangnhanvienNV(modelnv, manv);
//            tk.setFlagAcc(2);
//        }
//        jTable1.setModel(modelnv);//Set dữ liệu cho bảng
//        jTable1.getColumn(tableCol.elementAt(0)).setPreferredWidth(100);
//        jTable1.getColumn(tableCol.elementAt(1)).setPreferredWidth(150);
//        jTable1.getColumn(tableCol.elementAt(2)).setPreferredWidth(150);
//        jTable1.getColumn(tableCol.elementAt(3)).setPreferredWidth(100);
//        jTable1.getColumn(tableCol.elementAt(4)).setPreferredWidth(150);
//        jTable1.getColumn(tableCol.elementAt(5)).setPreferredWidth(80);
//        jTable1.getColumn(tableCol.elementAt(6)).setPreferredWidth(150);
//        jTable1.getColumn(tableCol.elementAt(7)).setPreferredWidth(100);
//        jTable1.getColumn(tableCol.elementAt(8)).setPreferredWidth(130);
//        jTable1.getColumn(tableCol.elementAt(9)).setPreferredWidth(200);
//        jTable1.getColumn(tableCol.elementAt(10)).setPreferredWidth(120);
//        jTable1.getColumn(tableCol.elementAt(11)).setPreferredWidth(150);
//        jTable1.getColumn(tableCol.elementAt(12)).setPreferredWidth(150);
//        jTable1.getColumn(tableCol.elementAt(13)).setPreferredWidth(150);
//        jTable1.getColumn(tableCol.elementAt(14)).setPreferredWidth(150);
//        jTable1.getColumn(tableCol.elementAt(15)).setPreferredWidth(150);
//        jTable1.getColumn(tableCol.elementAt(16)).setPreferredWidth(150);
//        tbpb = new BangPhongBanBUS();
//        tbcviec = new CongViecBUS();
//        tbchucvu = new ChucVuBUS();
//        jCbPhongBan.removeAllItems();
//        jCbChucVu.removeAllItems();
//        jCbCongViec.removeAllItems();
//        listPhongban(jCbPhongBan);
//        listChucvu(jCbChucVu);
//        listCongviec(jCbCongViec);
//        initThongtinNhanvien();
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
        jPanelNV = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jBtnThemNV = new javax.swing.JButton();
        jBtnSuaNV = new javax.swing.JButton();
        jBtnXoaNV = new javax.swing.JButton();
        jBtnHuy1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextMaKhachHang = new javax.swing.JTextField();
        jBtnCapPhatMaNV = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jTextTen = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTextSDT = new javax.swing.JTextField();
        jButtonExcel1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jCbGioiTinh = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jTextDiaChi = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jTextQuocTich = new javax.swing.JTextField();
        jTextMail = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jDateNgaySinh = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        jTextCmnd = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jTextTimKiemKH = new javax.swing.JTextField();
        jButtonTimKiem = new javax.swing.JButton();
        jBtnRefresh = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableKH = new javax.swing.JTable();

        setBackground(new java.awt.Color(233, 242, 249));
        setPreferredSize(new java.awt.Dimension(990, 650));

        jTabbedPane1.setBackground(new java.awt.Color(233, 242, 249));
        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jPanelNV.setBackground(new java.awt.Color(233, 242, 249));
        jPanelNV.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelNV.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(233, 242, 249));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hồ Sơ Khách Hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(0, 51, 102))); // NOI18N

        jBtnThemNV.setBackground(new java.awt.Color(136, 193, 184));
        jBtnThemNV.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnThemNV.setText("Thêm");
        jBtnThemNV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnThemNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnThemNVActionPerformed(evt);
            }
        });

        jBtnSuaNV.setBackground(new java.awt.Color(136, 193, 184));
        jBtnSuaNV.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnSuaNV.setText("Sửa");
        jBtnSuaNV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnSuaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSuaNVActionPerformed(evt);
            }
        });

        jBtnXoaNV.setBackground(new java.awt.Color(136, 193, 184));
        jBtnXoaNV.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnXoaNV.setText("Xóa");
        jBtnXoaNV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnXoaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnXoaNVActionPerformed(evt);
            }
        });

        jBtnHuy1.setBackground(new java.awt.Color(136, 193, 184));
        jBtnHuy1.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnHuy1.setText("Hủy");
        jBtnHuy1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnHuy1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnHuy1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("<html> <body> Mã Khách Hàng <span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");

        jTextMaKhachHang.setBackground(new java.awt.Color(214, 217, 223));
        jTextMaKhachHang.setEditable(false);

        jBtnCapPhatMaNV.setBackground(new java.awt.Color(81, 113, 131));
        jBtnCapPhatMaNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_edit_account_16.png"))); // NOI18N
        jBtnCapPhatMaNV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnCapPhatMaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCapPhatMaNVActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setText("<html> <body>Họ Tên Khách Hàng <span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel16.setText("<html> <body>SĐT <span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");

        jButtonExcel1.setBackground(new java.awt.Color(136, 193, 184));
        jButtonExcel1.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jButtonExcel1.setText("Xuất Excel");
        jButtonExcel1.setPreferredSize(new java.awt.Dimension(79, 23));
        jButtonExcel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcel1ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setText("<html> <body> Giới Tính <span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");

        jCbGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel15.setText("<html> <body>Địa Chỉ <span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel14.setText("<html> <body>Mail <span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel17.setText("<html> <body>Quốc Tịch <span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");

        jLabel25.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel25.setText("<html> <body>Ngày Sinh<span style=\"color:rgb(216, 74, 67);\"> *</span> </body> </html> ");

        jDateNgaySinh.setBackground(new java.awt.Color(214, 217, 223));
        jDateNgaySinh.setDateFormatString("yyyy-MM-dd");

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel13.setText("<html> <body>CMND <span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jBtnThemNV, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtnSuaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtnXoaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addComponent(jBtnHuy1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonExcel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextMail, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextQuocTich, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextMaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(10, 10, 10)
                                    .addComponent(jBtnCapPhatMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jCbGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextTen, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(72, 72, 72)
                                .addComponent(jDateNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(90, 90, 90)
                                .addComponent(jTextCmnd, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextMaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnCapPhatMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextTen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCbGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextCmnd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextMail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextQuocTich, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnThemNV, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnSuaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnXoaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnHuy1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonExcel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanelNV.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 380, 530));

        jLabel22.setText("Mã KH");
        jPanelNV.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 30, -1, 30));
        jPanelNV.add(jTextTimKiemKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 30, 160, 30));

        jButtonTimKiem.setText("Tìm kiếm");
        jButtonTimKiem.setPreferredSize(new java.awt.Dimension(79, 30));
        jButtonTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTimKiemActionPerformed(evt);
            }
        });
        jPanelNV.add(jButtonTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 30, -1, -1));

        jBtnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/refresh_25px.png"))); // NOI18N
        jBtnRefresh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnRefresh.setMaximumSize(new java.awt.Dimension(50, 50));
        jBtnRefresh.setMinimumSize(new java.awt.Dimension(50, 50));
        jBtnRefresh.setPreferredSize(new java.awt.Dimension(50, 50));
        jBtnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRefreshActionPerformed(evt);
            }
        });
        jPanelNV.add(jBtnRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 30, 40, 30));

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setAutoscrolls(true);

        jTableKH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableKH.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTableKHAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jTableKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableKHMouseClicked(evt);
            }
        });
        tableCol.add ("Mã Khách Hàng");
        tableCol.add ("Tên Khách Hàng");
        tableCol.add ("Ngày Sinh");
        tableCol.add ("Số ĐT");
        tableCol.add ("Mail");
        tableCol.add ("CMND");
        tableCol.add ("Giới Tính");
        tableCol.add ("Địa Chỉ");
        tableCol.add ("Quốc Tịch");
        modelnv = new DefaultTableModel(tableCol, 5);
        jTableKH.setModel(modelnv);
        jTableKH.setShowGrid(true);
        jTableKH.setFocusable(false);
        jTableKH.setIntercellSpacing(new Dimension(0,0));
        jTableKH.setRowHeight(25);
        jTableKH.getTableHeader().setOpaque(false);
        jTableKH.setFillsViewportHeight(true);
        jTableKH.getTableHeader().setBackground(new Color(232,57,99));
        jTableKH.getTableHeader().setForeground(new Color(141, 22, 22));
        jTableKH.getTableHeader().setFont (new Font("Dialog", Font.BOLD, 13));
        jTableKH.setSelectionBackground(new Color(52,152,219));
        jTableKH.setGridColor(new java.awt.Color(83, 86, 88));
        jScrollPane2.setViewportView(jTableKH);
        jTableKH.setAutoResizeMode (javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);

        jPanelNV.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, 560, 520));

        jTabbedPane1.addTab("Quản Lý Khách Hàng", jPanelNV);

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
    public void saveIMG()
    {
        try
        {
            if (i != null)
            {
                File save = new File("src/img/" + imgName);//Tạo file
                ImageIO.write(i, "jpg", save); // Lưu hình i vào đường dẫn file save

                i = null; //Xóa hình trong bộ nhớ 
            }
        } catch (IOException ex)
        {
            java.util.logging.Logger.getLogger(KhachHangForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    public boolean DeleteAnh(String anh)
    {
        boolean t = true;
        try
        {

            File file = new File("src/img/" + anh);
            if (file.delete())
            {
                t = true;
            } else
            {
                t = false;
            }
            Thread.sleep(2000);
            saveIMG();
        } catch (Exception e)
        {
            t = false;
            e.printStackTrace();
        }
        return t;
    }

    private void jButtonTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTimKiemActionPerformed
        // TODO add your handling code here:
        
        modelnv.setRowCount(0);
        khachHang.searchKhachHangByMaKhachHang(modelnv,jTextTimKiemKH.getText().toString());
        System.out.println(jTextTimKiemKH.getText().toString());
//        String manv = jTextTimKiemNV.getText();
//        tbnv.searchbangnhanvien(modelnv, manv);
//        jTable1.setModel(modelnv);
//        System.out.println("click tim kiem");
    }//GEN-LAST:event_jButtonTimKiemActionPerformed

    private void jBtnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRefreshActionPerformed
        loadData();
//        // TODO add your handling code here:
//        jTextTimKiemNV.setText("");
//        tbnv.loadDataNV();
//        modelnv.setRowCount(0);
//        tbnv.bangnhanvien(modelnv);
    }//GEN-LAST:event_jBtnRefreshActionPerformed

    private void jBtnCapPhatMaNVActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnCapPhatMaNVActionPerformed
    {//GEN-HEADEREND:event_jBtnCapPhatMaNVActionPerformed
     
        // TODO add your handling code here:
        jBtnThemNV.setEnabled(true);
        jBtnHuy1.setEnabled(true);
        jBtnSuaNV.setEnabled(false);
        jBtnXoaNV.setEnabled(false);
        jTextMaKhachHang.setText(ult.initMaKhachHang());
    }//GEN-LAST:event_jBtnCapPhatMaNVActionPerformed

    private void jTableKHMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jTableKHMouseClicked
    {//GEN-HEADEREND:event_jTableKHMouseClicked
        // TODO add your handling code here:
        jBtnSuaNV.setEnabled(true);
        jBtnXoaNV.setEnabled(true);
        jBtnThemNV.setEnabled(false);
        jBtnHuy1.setEnabled(true);
        selectedRow = jTableKH.getSelectedRow();
        jTextMaKhachHang.setText((String)modelnv.getValueAt(selectedRow, 0));
        jTextTen.setText((String)modelnv.getValueAt(selectedRow, 1));
        
        if(modelnv.getValueAt(selectedRow, 6).equals("nam")){
            jCbGioiTinh.setSelectedIndex(0);
        }
        else{
            jCbGioiTinh.setSelectedIndex(1);
        }
        
        Date ngaySinh;
        try {
            ngaySinh = new SimpleDateFormat("yyyy-MM-dd").parse(modelnv.getValueAt(selectedRow, 2).toString());
            jDateNgaySinh.setDate(ngaySinh);
        } catch (ParseException ex) {
            Logger.getLogger(KhachHangForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        jTextCmnd.setText((String)modelnv.getValueAt(selectedRow, 5));
        jTextSDT.setText((String)modelnv.getValueAt(selectedRow, 3));
        jTextMail.setText((String)modelnv.getValueAt(selectedRow, 4));
        jTextDiaChi.setText((String)modelnv.getValueAt(selectedRow, 7));
        jTextQuocTich.setText((String)modelnv.getValueAt(selectedRow, 8));
    }//GEN-LAST:event_jTableKHMouseClicked

    private void jButtonExcel1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonExcel1ActionPerformed
    {//GEN-HEADEREND:event_jButtonExcel1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonExcel1ActionPerformed

    private void jBtnThemNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnThemNVActionPerformed
        // TODO add your handling code here:
        //System.out.println((String) ((JTextField) jDateNgaySinh.getDateEditor().getUiComponent()).getText());
        String ngaySinh = (String) ((JTextField) jDateNgaySinh.getDateEditor().getUiComponent()).getText();
        String gioiTinh;
        if(jCbGioiTinh.getSelectedItem().equals("Nam")){
            gioiTinh = "1";
        }
        else{
            gioiTinh = "0";
        }
        if(khachHang.add(
                jTextMaKhachHang.getText()
                ,jTextTen.getText()
                ,gioiTinh
                ,ngaySinh
                ,jTextCmnd.getText()
                ,jTextSDT.getText()
                ,jTextMail.getText()
                ,jTextDiaChi.getText()
                ,jTextQuocTich.getText())){
            
            addRow = new Vector();
            addRow.add(jTextMaKhachHang.getText());
            addRow.add(jTextTen.getText());
            addRow.add(ngaySinh);
            addRow.add(jTextSDT.getText());
            addRow.add(jTextMail.getText());
            addRow.add(jTextCmnd.getText());
            addRow.add(gioiTinh);
            addRow.add(jTextDiaChi.getText());
            addRow.add(jTextQuocTich.getText());
            modelnv.addRow(addRow);
            
        }else{
            
        }
    }//GEN-LAST:event_jBtnThemNVActionPerformed

    private void jBtnSuaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSuaNVActionPerformed
        // TODO add your handling code here:
        jBtnThemNV.setEnabled(false);
        jBtnXoaNV.setEnabled(true);
        String ngaySinh = (String) ((JTextField) jDateNgaySinh.getDateEditor().getUiComponent()).getText();
        String gioiTinh;
        if(jCbGioiTinh.getSelectedItem().equals("Nam")){
            gioiTinh = "1";
        }
        else{
            gioiTinh = "0";
        }
        if(khachHang.update(
                jTextMaKhachHang.getText()
                ,jTextTen.getText()
                ,gioiTinh
                ,ngaySinh
                ,jTextCmnd.getText()
                ,jTextSDT.getText()
                ,jTextMail.getText()
                ,jTextDiaChi.getText()
                ,jTextQuocTich.getText()))
            
           
        {
            modelnv.setValueAt(jTextMaKhachHang.getText(),selectedRow,0);
            modelnv.setValueAt(jTextTen.getText(),selectedRow,1);
            modelnv.setValueAt(ngaySinh,selectedRow,2);
            modelnv.setValueAt(jTextSDT.getText(),selectedRow,3);
            modelnv.setValueAt(jTextMail.getText(),selectedRow,4);
            modelnv.setValueAt(jTextCmnd.getText(),selectedRow,5);
            modelnv.setValueAt(jCbGioiTinh.getSelectedItem(),selectedRow,6);
            modelnv.setValueAt(jTextDiaChi.getText(),selectedRow,7);
            modelnv.setValueAt(jTextQuocTich.getText(),selectedRow,8);
        }else{
            
        }
    }//GEN-LAST:event_jBtnSuaNVActionPerformed

    private void jBtnXoaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnXoaNVActionPerformed
        if(khachHang.delete(modelnv.getValueAt(selectedRow, 0).toString())){
            modelnv.removeRow(selectedRow);
        }else{
            
        }
        
    }//GEN-LAST:event_jBtnXoaNVActionPerformed

    private void jTableKHAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTableKHAncestorAdded

    }//GEN-LAST:event_jTableKHAncestorAdded

    private void jBtnHuy1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnHuy1ActionPerformed
        // TODO add your handling code here:
        jBtnThemNV.setEnabled(false);
        jBtnSuaNV.setEnabled(false);
        jBtnXoaNV.setEnabled(false);
        
        jTextMaKhachHang.setText(null);
        jTextTen.setText(null);
        jDateNgaySinh.setCalendar(null);
        jTextCmnd.setText(null);
        jTextDiaChi.setText(null);
        jTextQuocTich.setText(null);
        jTextMail.setText(null);
        jTextSDT.setText(null);
    }//GEN-LAST:event_jBtnHuy1ActionPerformed

//    Vector tableRow = new Vector ();//Vector chứa các dòng dữ liệu của bảng.
    Vector tableCol = new Vector();//Vector chứa các tiêu đề của bảng.
//    DefaultTableModel md=tbnv.bangnhanvien ();

//    public void listPhongban(JComboBox cmb)
//    {
//        ArrayList<PhongBanDTO> cbdspb = tbpb.getDspb().getDspb().getDspb();
//        System.out.println("nhanvienForm " + tbpb.getDspb().getDspb().getDspb());
//        addCombo(cmb, cbdspb);
//    }
//    public void listChucvu(JComboBox cmb)
//    {
//        ArrayList<ChucVuDTO> cbdscvu = tbchucvu.getDscv().getDscv();
//        addCombo(cmb, cbdscvu);
//    }
//
//    public void listCongviec(JComboBox cmb)
//    {
//        ArrayList<CongViecDTO> cbdscviec = tbcviec.getDscviec().getDscviec();
//        addCombo(cmb, cbdscviec);
//    }
    public void addCombo(JComboBox cmb, ArrayList list)
    {
        for (Object a : list)
        {
            cmb.addItem(a);
        }
    }

//    public JComboBox<String> getjComboBox3()
//    {
//        return jCbPhongBan;
//    }
    public JPanel getjPanel1()
    {
        return jPanelNV;
    }

//    public JComboBox<String> getjCbChucVu()
//    {
//        return jCbChucVu;
//    }
//
//    public JComboBox<String> getjCbCongViec()
//    {
//        return jCbCongViec;
//    }

    public JTextField getjTextHonv()
    {
        return jTextTen;
    }

    public JTextField getjTextManv()
    {
        return jTextMaKhachHang;
    }

//    public JTable getjTable1()
//    {
//        return jTable1;
//    }

    public DefaultTableModel getModelnv()
    {
        return modelnv;
    }

//    public JButton getjBtnCapNhatNV()
//    {
//        return jBtnCapNhatNV;
//    }

    public JButton getjBtnCapPhatMaNV()
    {
        return jBtnCapPhatMaNV;
    }
//
//    public JButton getjBtnHuy()
//    {
//        return jBtnHuy;
//    }
//
//    public JButton getjBtnXoaNV()
//    {
//        return jBtnXoaNV;
//    }

    public int getFlagAcc()
    {
        return flagAcc;
    }

    public void setFlagAcc(int flagAcc)
    {
        this.flagAcc = flagAcc;
    }

    public String getManv()
    {
        return manv;
    }

    public void setManv(String manv)
    {
        this.manv = manv;
    }

    public String getMapb()
    {
        return mapb;
    }

    public void setMapb(String mapb)
    {
        this.mapb = mapb;
    }

//    public JButton getjBtnQuaylai()
//    {
//        return jBtnQuaylai;
//    }
//
//    public void setjBtnQuaylai(JButton jBtnQuaylai)
//    {
//        this.jBtnQuaylai = jBtnQuaylai;
//    }

    public JButton getjBtnRefresh()
    {
        return jBtnRefresh;
    }

    public void setjBtnRefresh(JButton jBtnRefresh)
    {
        this.jBtnRefresh = jBtnRefresh;
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
        return jTextTimKiemKH;
    }

    public void setjTextTimKiemNV(JTextField jTextTimKiemNV)
    {
        this.jTextTimKiemKH = jTextTimKiemNV;
    }

    public JButton getjButtonTimKiem()
    {
        return jButtonTimKiem;
    }

    public void setjButtonTimKiem(JButton jButtonTimKiem)
    {
        this.jButtonTimKiem = jButtonTimKiem;
    }

//    public JPanel getjPanel2()
//    {
//        return jPanel2;
//    }

//    public void setjPanel2(JPanel jPanel2)
//    {
//        this.jPanel2 = jPanel2;
//    }
//
//    public JButton getjButtonExcel()
//    {
//        return jButtonExcel;
//    }
//
//    public void setjButtonExcel(JButton jButtonExcel)
//    {
//        this.jButtonExcel = jButtonExcel;
//    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnCapPhatMaNV;
    private javax.swing.JButton jBtnHuy1;
    private javax.swing.JButton jBtnRefresh;
    private javax.swing.JButton jBtnSuaNV;
    private javax.swing.JButton jBtnThemNV;
    private javax.swing.JButton jBtnXoaNV;
    private javax.swing.JButton jButtonExcel1;
    private javax.swing.JButton jButtonTimKiem;
    private javax.swing.JComboBox<String> jCbGioiTinh;
    private com.toedter.calendar.JDateChooser jDateNgaySinh;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelNV;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableKH;
    private javax.swing.JTextField jTextCmnd;
    private javax.swing.JTextField jTextDiaChi;
    private javax.swing.JTextField jTextMaKhachHang;
    private javax.swing.JTextField jTextMail;
    private javax.swing.JTextField jTextQuocTich;
    private javax.swing.JTextField jTextSDT;
    private javax.swing.JTextField jTextTen;
    private javax.swing.JTextField jTextTimKiemKH;
    // End of variables declaration//GEN-END:variables
}
