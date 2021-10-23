/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

//import BUS.*;
//import DAO.XuatExcel;
//import DTO.ChucVuDTO;
//import DTO.CongViecDTO;
//import DTO.PhongBanDTO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
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

    public TourForm()
    {
        initComponents();
//        tk.setVisible(false);
    }

//    public void initThongtinNhanvien()
//    {
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
//                JOptionPane.showMessageDialog(TourForm.this, e);
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
//                JOptionPane.showMessageDialog(TourForm.this, e);
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
//    }
//    public void initTableNhanvien()
//    {
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
//    }
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
        jLabelTTTour = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jBtnChonGiaTour = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        jTextGiaTour = new javax.swing.JTextField();
        jDateNgaySinh2 = new com.toedter.calendar.JDateChooser();
        jLabel22 = new javax.swing.JLabel();
        jTextTenTour = new javax.swing.JTextField();
        jTextLoaiHinh = new javax.swing.JTextField();
        jBtnChonLoaiHinh = new javax.swing.JButton();
        jDateNgayBD = new com.toedter.calendar.JDateChooser();
        jBtnCapPhatMaTour = new javax.swing.JButton();
        jTextMaTour = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLbManv = new javax.swing.JLabel();
        jBtnThem = new javax.swing.JButton();
        jBtnXoa = new javax.swing.JButton();
        jBtnSua = new javax.swing.JButton();
        jTextTimKiemNV = new javax.swing.JTextField();
        jButtonTimKiem = new javax.swing.JButton();
        jBtnRefresh = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTour = new javax.swing.JTable();
        jBtnXem = new javax.swing.JButton();
        jBtnHuy = new javax.swing.JButton();
        jPanelChiTietTour = new javax.swing.JPanel();
        jBtnLuu = new javax.swing.JButton();
        jBtnThayDoi = new javax.swing.JButton();
        jTextTimKiemNV1 = new javax.swing.JTextField();
        jButtonTimKiem1 = new javax.swing.JButton();
        jBtnRefresh1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTextMaTour1 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jTextTenTour1 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jTextGiaTour1 = new javax.swing.JTextField();
        jTextLoaiHinh1 = new javax.swing.JTextField();
        jBtnChonLoaiHinh1 = new javax.swing.JButton();
        jLbManv1 = new javax.swing.JLabel();
        jBtnXoa1 = new javax.swing.JButton();
        jBtnThem2 = new javax.swing.JButton();
        jBtnSua2 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableDiadiem = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableDoan = new javax.swing.JTable();
        jPanelTLTour = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextManv = new javax.swing.JTextField();
        jLabelHinh = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextHonv = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextTennv = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextNoiSinh = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextTdhv = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextCmnd = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextDiaChi = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTextSDT = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jTextEmail = new javax.swing.JTextField();
        jDateNgaycapcmnd = new com.toedter.calendar.JDateChooser();
        jCbCongViec = new javax.swing.JComboBox<>();
        jDateNgaySinh = new com.toedter.calendar.JDateChooser();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jCbGioiTinh = new javax.swing.JComboBox<>();
        //pb= tbpb.pbCombobox (pb);
        jCbPhongBan = new javax.swing.JComboBox<>();
        jCbChucVu = new javax.swing.JComboBox<>();
        jBtnCapPhatMaNV = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jTextLuongcb = new javax.swing.JTextField();

        setBackground(new java.awt.Color(233, 242, 249));
        setPreferredSize(new java.awt.Dimension(990, 650));

        jTabbedPane1.setBackground(new java.awt.Color(233, 242, 249));
        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jPanelQLTour.setBackground(new java.awt.Color(233, 242, 249));

        jLabelTTTour.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabelTTTour.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTTTour.setText("Thông Tin Tour");

        jPanel4.setBackground(new java.awt.Color(233, 242, 249));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Loại Hình", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(0, 51, 102)));
        jPanel4.setPreferredSize(new java.awt.Dimension(1000, 550));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel26.setText("<html> <body>Ngày Kết Thúc<span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");
        jPanel4.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 140, -1, 30));

        jBtnChonGiaTour.setBackground(new java.awt.Color(136, 193, 184));
        jBtnChonGiaTour.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        jBtnChonGiaTour.setText("...");
        jBtnChonGiaTour.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnChonGiaTour.setPreferredSize(new java.awt.Dimension(30, 30));
        jBtnChonGiaTour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnChonGiaTourActionPerformed(evt);
            }
        });
        jPanel4.add(jBtnChonGiaTour, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 40, -1, -1));

        jLabel24.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel24.setText("<html> <body>Loại Hình<span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");
        jPanel4.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, 30));

        jTextGiaTour.setForeground(new java.awt.Color(51, 51, 51));
        jTextGiaTour.setRequestFocusEnabled(false);
        jPanel4.add(jTextGiaTour, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 40, 140, 30));

        jDateNgaySinh2.setBackground(new java.awt.Color(214, 217, 223));
        jDateNgaySinh2.setDateFormatString("yyyy-MM-dd");
        jPanel4.add(jDateNgaySinh2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 140, 180, 30));

        jLabel22.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel22.setText("<html> <body>Tên Tour<span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");
        jPanel4.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, 30));

        jTextTenTour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextTenTourActionPerformed(evt);
            }
        });
        jPanel4.add(jTextTenTour, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 170, 30));
        jPanel4.add(jTextLoaiHinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 170, 30));

        jBtnChonLoaiHinh.setBackground(new java.awt.Color(136, 193, 184));
        jBtnChonLoaiHinh.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        jBtnChonLoaiHinh.setText("...");
        jBtnChonLoaiHinh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnChonLoaiHinh.setPreferredSize(new java.awt.Dimension(30, 30));
        jBtnChonLoaiHinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnChonLoaiHinhActionPerformed(evt);
            }
        });
        jPanel4.add(jBtnChonLoaiHinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, -1, -1));

        jDateNgayBD.setBackground(new java.awt.Color(214, 217, 223));
        jDateNgayBD.setDateFormatString("yyyy-MM-dd");
        jPanel4.add(jDateNgayBD, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 90, 180, 30));

        jBtnCapPhatMaTour.setBackground(new java.awt.Color(81, 113, 131));
        jBtnCapPhatMaTour.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_add_32.png"))); // NOI18N
        jBtnCapPhatMaTour.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnCapPhatMaTour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCapPhatMaTourActionPerformed(evt);
            }
        });
        jPanel4.add(jBtnCapPhatMaTour, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 30, 30));

        jTextMaTour.setEditable(false);
        jTextMaTour.setBackground(new java.awt.Color(214, 217, 223));
        jTextManv.setEditable(false);
        jPanel4.add(jTextMaTour, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 170, 30));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("<html> <body> Mã Tour <span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, 30));

        jLabel25.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel25.setText("<html> <body>Ngày Bắt Đầu<span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");
        jPanel4.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, -1, 30));

        jLbManv.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLbManv.setText("<html> <body>Giá Tour<span style=\"color:rgb(234, 21, 21)\"> *</span> </body> </html>");
        jPanel4.add(jLbManv, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, -1, 30));

        jBtnThem.setBackground(new java.awt.Color(136, 193, 184));
        jBtnThem.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnThem.setText("Thêm");
        jBtnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnThemActionPerformed(evt);
            }
        });

        jBtnXoa.setBackground(new java.awt.Color(136, 193, 184));
        jBtnXoa.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnXoa.setText("Xóa");
        jBtnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnXoaActionPerformed(evt);
            }
        });

        jBtnSua.setBackground(new java.awt.Color(136, 193, 184));
        jBtnSua.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnSua.setText("Sửa");
        jBtnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSuaActionPerformed(evt);
            }
        });

        jButtonTimKiem.setText("Tìm kiếm");
        jButtonTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTimKiemActionPerformed(evt);
            }
        });

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

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setAutoscrolls(true);

        jTableTour.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableTour.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableTourMouseClicked(evt);
            }
        });
        tbColTour.add("Mă Tour");
        tbColTour.add("Tên Tour");
        tbColTour.add("Loại Hình");
        tbColTour.add("Giá Tour");
        tbColTour.add("Ngày Bắt Đầu");
        tbColTour.add("Ngày Kết Thúc");
        tbModelTour= new DefaultTableModel(tbColTour,5);
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

        jBtnXem.setBackground(new java.awt.Color(136, 193, 184));
        jBtnXem.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnXem.setText("Xem");
        jBtnXem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnXemActionPerformed(evt);
            }
        });

        jBtnHuy.setBackground(new java.awt.Color(136, 193, 184));
        jBtnHuy.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnHuy.setText("Hủy");
        jBtnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnHuyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelQLTourLayout = new javax.swing.GroupLayout(jPanelQLTour);
        jPanelQLTour.setLayout(jPanelQLTourLayout);
        jPanelQLTourLayout.setHorizontalGroup(
            jPanelQLTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelQLTourLayout.createSequentialGroup()
                .addGroup(jPanelQLTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelQLTourLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanelQLTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelQLTourLayout.createSequentialGroup()
                                .addComponent(jLabelTTTour, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanelQLTourLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextTimKiemNV, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(62, 62, 62))
            .addGroup(jPanelQLTourLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanelQLTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelQLTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jBtnXoa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                        .addComponent(jBtnSua, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(42, 42, 42)
                .addGroup(jPanelQLTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBtnXem, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanelQLTourLayout.setVerticalGroup(
            jPanelQLTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelQLTourLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTTTour, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanelQLTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelQLTourLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanelQLTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelQLTourLayout.createSequentialGroup()
                                .addComponent(jBtnXem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jBtnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelQLTourLayout.createSequentialGroup()
                                .addComponent(jBtnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jBtnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)
                                .addComponent(jBtnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 75, Short.MAX_VALUE))
                    .addGroup(jPanelQLTourLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelQLTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextTimKiemNV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelQLTourLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        jTabbedPane1.addTab("Quản lý Tour", jPanelQLTour);

        jPanelChiTietTour.setBackground(new java.awt.Color(233, 242, 249));

        jBtnLuu.setBackground(new java.awt.Color(136, 193, 184));
        jBtnLuu.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnLuu.setText("Lưu");
        jBtnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnLuuActionPerformed(evt);
            }
        });

        jBtnThayDoi.setBackground(new java.awt.Color(136, 193, 184));
        jBtnThayDoi.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnThayDoi.setText("Thay đổi thứ tự");
        jBtnThayDoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnThayDoiActionPerformed(evt);
            }
        });

        jButtonTimKiem1.setText("Tìm kiếm");
        jButtonTimKiem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTimKiem1ActionPerformed(evt);
            }
        });

        jBtnRefresh1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/refresh_25px.png"))); // NOI18N
        jBtnRefresh1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnRefresh1.setMaximumSize(new java.awt.Dimension(50, 50));
        jBtnRefresh1.setMinimumSize(new java.awt.Dimension(50, 50));
        jBtnRefresh1.setPreferredSize(new java.awt.Dimension(50, 50));
        jBtnRefresh1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRefresh1ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("<html> <body> Mã Tour <span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");

        jTextMaTour1.setEditable(false);
        jTextMaTour1.setBackground(new java.awt.Color(214, 217, 223));
        jTextManv.setEditable(false);

        jLabel27.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel27.setText("<html> <body>Tên Tour<span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");

        jTextTenTour1.setEditable(false);
        jTextTenTour1.setBackground(new java.awt.Color(214, 217, 223));
        jTextTenTour1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
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

        jTextGiaTour1.setForeground(new java.awt.Color(51, 51, 51));
        jTextGiaTour1.setRequestFocusEnabled(false);
        jPanel5.add(jTextGiaTour1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 170, 30));
        jPanel5.add(jTextLoaiHinh1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 170, 30));

        jBtnChonLoaiHinh1.setBackground(new java.awt.Color(136, 193, 184));
        jBtnChonLoaiHinh1.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        jBtnChonLoaiHinh1.setText("...");
        jBtnChonLoaiHinh1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnChonLoaiHinh1.setPreferredSize(new java.awt.Dimension(30, 30));
        jBtnChonLoaiHinh1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnChonLoaiHinh1ActionPerformed(evt);
            }
        });
        jPanel5.add(jBtnChonLoaiHinh1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, -1, -1));

        jLbManv1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLbManv1.setText("<html> <body>Tên Địa Điểm<span style=\"color:rgb(234, 21, 21)\"> *</span> </body> </html>");
        jPanel5.add(jLbManv1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, 30));

        jBtnXoa1.setBackground(new java.awt.Color(136, 193, 184));
        jBtnXoa1.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnXoa1.setText("Xóa");
        jBtnXoa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnXoa1ActionPerformed(evt);
            }
        });
        jPanel5.add(jBtnXoa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, 80, 40));

        jBtnThem2.setBackground(new java.awt.Color(136, 193, 184));
        jBtnThem2.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnThem2.setText("Thêm");
        jBtnThem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnThem2ActionPerformed(evt);
            }
        });
        jPanel5.add(jBtnThem2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 80, 40));

        jBtnSua2.setBackground(new java.awt.Color(136, 193, 184));
        jBtnSua2.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnSua2.setText("Sửa");
        jBtnSua2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSua2ActionPerformed(evt);
            }
        });
        jPanel5.add(jBtnSua2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 80, 40));

        jTableDiadiem.setAutoCreateRowSorter(true);
        jTableDiadiem.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTableDiadiem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableDiadiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableDiadiemMouseClicked(evt);
            }
        });
        tbColDiadiem.add("Mă Địa Điểm");
        tbColDiadiem.add("Tên Địa Điểm");
        tbColDiadiem.add("Thứ Tự");
        tbModelDiadiem= new DefaultTableModel(tbColDiadiem,20);
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
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableDoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableDoanMouseClicked(evt);
            }
        });
        tbColDoan.add("Mă Đoàn");
        tbColDoan.add("Tên Ðoàn");
        tbColDoan.add("Giá Ðoàn");
        tbColDoan.add("Ngày Bắt Đầu");
        tbColDoan.add("Ngày Kết Thúc");
        tbColDoan.add("Số Người");
        tbModelDoan= new DefaultTableModel(tbColDoan,20);
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

        javax.swing.GroupLayout jPanelChiTietTourLayout = new javax.swing.GroupLayout(jPanelChiTietTour);
        jPanelChiTietTour.setLayout(jPanelChiTietTourLayout);
        jPanelChiTietTourLayout.setHorizontalGroup(
            jPanelChiTietTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelChiTietTourLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelChiTietTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelChiTietTourLayout.createSequentialGroup()
                        .addGroup(jPanelChiTietTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelChiTietTourLayout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addComponent(jTextMaTour1, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE))
                            .addGroup(jPanelChiTietTourLayout.createSequentialGroup()
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)
                                .addComponent(jTextTenTour1)))
                        .addGap(690, 690, 690))
                    .addGroup(jPanelChiTietTourLayout.createSequentialGroup()
                        .addGroup(jPanelChiTietTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(jPanelChiTietTourLayout.createSequentialGroup()
                                .addComponent(jBtnThayDoi, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jBtnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE))
                        .addGap(38, 38, 38)
                        .addGroup(jPanelChiTietTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelChiTietTourLayout.createSequentialGroup()
                                .addComponent(jTextTimKiemNV1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonTimKiem1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtnRefresh1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanelChiTietTourLayout.setVerticalGroup(
            jPanelChiTietTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelChiTietTourLayout.createSequentialGroup()
                .addGroup(jPanelChiTietTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelChiTietTourLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanelChiTietTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextMaTour1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanelChiTietTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextTenTour1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE))
                    .addGroup(jPanelChiTietTourLayout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addGroup(jPanelChiTietTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextTimKiemNV1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonTimKiem1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtnRefresh1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelChiTietTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnThayDoi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        jTabbedPane1.addTab("Chi tiết Tour", jPanelChiTietTour);

        jPanelTLTour.setBackground(new java.awt.Color(233, 242, 249));
        jPanelTLTour.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelTLTour.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Hồ Sơ Lý Lịch Nhân Viên");
        jPanelTLTour.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 390, 50));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/nguoidung.png"))); // NOI18N
        jLabel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(160, 147, 144), 2, true));
        jPanelTLTour.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 200, 240));

        jLabel3.setFont(new java.awt.Font("DialogInput", 1, 20)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Hình Ảnh");
        jPanelTLTour.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 100, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("<html> <body> Mã Nhân Viên <span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");
        jPanelTLTour.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, -1, 30));

        jTextManv.setBackground(new java.awt.Color(214, 217, 223));
        jTextManv.setEditable(false);
        jPanelTLTour.add(jTextManv, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 100, 140, 30));

        jLabelHinh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelHinh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_refresh_32.png"))); // NOI18N
        jLabelHinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelHinhMouseClicked(evt);
            }
        });
        jPanelTLTour.add(jLabelHinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 350, 50, 50));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setText("<html> <body>Họ Nhân Viên <span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");
        jPanelTLTour.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 150, -1, 30));
        jPanelTLTour.add(jTextHonv, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 150, 180, 30));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setText("<html>  <body> Tên Nhân Viên <span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");
        jPanelTLTour.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 200, -1, 30));
        jPanelTLTour.add(jTextTennv, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 200, 180, 30));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setText("<html> <body> Ngày Sinh <span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");
        jPanelTLTour.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 250, -1, 30));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setText("<html> <body>Nơi Sinh <span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");
        jPanelTLTour.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 300, -1, 30));
        jPanelTLTour.add(jTextNoiSinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 300, 180, 30));

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setText("<html> <body> Giới Tính <span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");
        jPanelTLTour.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 350, -1, 30));

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel12.setText("<html> <body>Trình Độ Học Vấn <span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");
        jPanelTLTour.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 400, -1, 30));

        jTextTdhv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextTdhvActionPerformed(evt);
            }
        });
        jPanelTLTour.add(jTextTdhv, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 400, 180, 30));

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel13.setText("<html> <body>CMND <span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");
        jPanelTLTour.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 450, 60, 30));
        jPanelTLTour.add(jTextCmnd, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 450, 180, 30));

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel14.setText("<html><body>Ngày Cấp CMND <span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");
        jPanelTLTour.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 500, -1, 30));

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel15.setText("<html> <body>Địa Chỉ <span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");
        jPanelTLTour.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 550, 70, 30));
        jPanelTLTour.add(jTextDiaChi, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 550, 180, 30));

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel16.setText("<html> <body>SĐT <span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");
        jPanelTLTour.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 100, 40, 30));
        jPanelTLTour.add(jTextSDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 100, 180, 30));

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel17.setText("<html>  <body>Email <span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");
        jPanelTLTour.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 150, 50, 30));
        jPanelTLTour.add(jTextEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 150, 180, 30));

        jDateNgaycapcmnd.setBackground(new java.awt.Color(214, 217, 223));
        jDateNgaycapcmnd.setDateFormatString("yyyy-MM-dd");
        jPanelTLTour.add(jDateNgaycapcmnd, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 500, 180, 30));

        //jCbCongViec.setModel (new javax.swing.DefaultComboBoxModel<>(tbcviec.congviecCombobox ()));
        jCbCongViec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCbCongViecActionPerformed(evt);
            }
        });
        jPanelTLTour.add(jCbCongViec, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 300, 180, 30));

        jDateNgaySinh.setBackground(new java.awt.Color(214, 217, 223));
        jDateNgaySinh.setDateFormatString("yyyy-MM-dd");
        jPanelTLTour.add(jDateNgaySinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 250, 180, 30));

        jLabel18.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel18.setText("<html>  <body>Phòng Ban <span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");
        jPanelTLTour.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 200, -1, 30));

        jLabel19.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel19.setText("<html>  <body>Chức Vụ <span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");
        jPanelTLTour.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 250, -1, 30));

        jLabel20.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel20.setText("<html>  <body>Công Việc <span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");
        jPanelTLTour.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 300, -1, 30));

        jCbGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));
        jPanelTLTour.add(jCbGioiTinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 350, 180, 30));

        //jCbPhongBan.setModel (new javax.swing.DefaultComboBoxModel<>(tbpb.pbCombobox ()));
        jCbPhongBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCbPhongBanActionPerformed(evt);
            }
        });
        jPanelTLTour.add(jCbPhongBan, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 200, 180, 30));

        //jCbChucVu.setModel (new javax.swing.DefaultComboBoxModel<>(tbchucvu.chucvuCombobox ()));
        jPanelTLTour.add(jCbChucVu, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 250, 180, 30));

        jBtnCapPhatMaNV.setBackground(new java.awt.Color(81, 113, 131));
        jBtnCapPhatMaNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_edit_account_16.png"))); // NOI18N
        jBtnCapPhatMaNV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnCapPhatMaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCapPhatMaNVActionPerformed(evt);
            }
        });
        jPanelTLTour.add(jBtnCapPhatMaNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 100, 30, 30));

        jLabel21.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel21.setText("<html> <body>Lương Căn Bản <span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");
        jPanelTLTour.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 350, 120, 30));
        jPanelTLTour.add(jTextLuongcb, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 350, 180, 30));

        jTabbedPane1.addTab("Thể loại Tour", jPanelTLTour);

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

    private void jCbPhongBanActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jCbPhongBanActionPerformed
    {//GEN-HEADEREND:event_jCbPhongBanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCbPhongBanActionPerformed

    private void jCbCongViecActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jCbCongViecActionPerformed
    {//GEN-HEADEREND:event_jCbCongViecActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCbCongViecActionPerformed

    private void jTextTdhvActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jTextTdhvActionPerformed
    {//GEN-HEADEREND:event_jTextTdhvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextTdhvActionPerformed

    private void jLabelHinhMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jLabelHinhMouseClicked
    {//GEN-HEADEREND:event_jLabelHinhMouseClicked
        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "JPG & PNG images", "jpg", "png");
        fc.setFileFilter(filter);
        int result = fc.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION)
        {
            try
            {
                File file = fc.getSelectedFile(); //Lấy URL hình
                i = ImageIO.read(file); // Lấy hình
                imgName = jTextManv.getText().concat(".jpg"); //Tên hình
                System.out.println(imgName);
                // Thay đổi hình hiển thị
                jLabel2.setText("");
                jLabel2.setIcon(new ImageIcon(i.getScaledInstance(200, 230, Image.SCALE_DEFAULT)));

                revalidate();
                repaint();
            } catch (IOException ex)
            {
                java.util.logging.Logger.getLogger(TourForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jLabelHinhMouseClicked
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
            java.util.logging.Logger.getLogger(TourForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

    public void cleanView()
    {
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/nguoidung.png")));
        jLabel2.setText("Image");

//        imgName = "null";
    }

    public String ktra()
    {
        String temp = "";

        if (jTextManv.getText().equals(""))
        {
            temp += "Vui lòng cấp phát mã nhân viên!\n";
        }

        String hoten = "^[(AÁÀẢÃẠÂẤẦẨẪẬĂẮẰẲẴẶEÉÈẺẼẸÊẾỀỂỄỆIÍÌỈĨỊOÓÒỎÕỌÔỐỒỔỖỘƠỚỜỞỠỢUÚÙỦŨỤƯỨỪỬỮỰYÝỲỶỸỴĐaáàảãạâấầẩẫậăắằẳẵặeéèẻẽẹêếềểễệiíìỉĩịoóòỏõọôốồổỗộơớờởỡợuúùủũụưứừửữựyýỳỷỹỵđ|a-z|A-Z|\\s]{5,32}$";
        if (!Pattern.matches(hoten, jTextHonv.getText()))
        {
            temp += "- Họ Nhân Viên không hợp lệ!\n";
        }

        String ten = "^[(AÁÀẢÃẠÂẤẦẨẪẬĂẮẰẲẴẶEÉÈẺẼẸÊẾỀỂỄỆIÍÌỈĨỊOÓÒỎÕỌÔỐỒỔỖỘƠỚỜỞỠỢUÚÙỦŨỤƯỨỪỬỮỰYÝỲỶỸỴĐaáàảãạâấầẩẫậăắằẳẵặeéèẻẽẹêếềểễệiíìỉĩịoóòỏõọôốồổỗộơớờởỡợuúùủũụưứừửữựyýỳỷỹỵđ|a-z|A-Z|\\s]{2,32}$";
        if (!Pattern.matches(ten, jTextTennv.getText()))
        {
            temp += "- Tên Nhân Viên không hợp lệ!\n";
        }
        String ngaysinh = ((JTextField) jDateNgaySinh.getDateEditor().getUiComponent()).getText();
        String ngaycmnd = ((JTextField) jDateNgaycapcmnd.getDateEditor().getUiComponent()).getText();
        if (ngaysinh.equals(""))
        {
            temp += "- Ngày sinh không được để trống!\n";
        }
        if (ngaycmnd.equals(""))
        {
            temp += "- Ngày cấp CMND không được để trống!\n";
        }
        if (!ngaysinh.equals("") && !ngaycmnd.equals(""))
        {
            String[] arrNgaySinh = ngaysinh.split("-");
            String[] arrNgayCap = ngaycmnd.split("-");
            if (Integer.parseInt(arrNgayCap[0]) - Integer.parseInt(arrNgaySinh[0]) < 14)
            {
                temp += "- Ngày Cấp CMND không hợp lệ!\n";
            } else if (Integer.parseInt(arrNgayCap[0]) - Integer.parseInt(arrNgaySinh[0]) == 14 && Integer.parseInt(arrNgayCap[1]) - Integer.parseInt(arrNgaySinh[1]) < 0)
            {
                temp += "- Ngày Cấp CMND không hợp lệ!\n";
            } else if (Integer.parseInt(arrNgayCap[0]) - Integer.parseInt(arrNgaySinh[0]) == 14 && Integer.parseInt(arrNgayCap[1]) - Integer.parseInt(arrNgaySinh[1]) == 0 && Integer.parseInt(arrNgayCap[2]) - Integer.parseInt(arrNgaySinh[2]) < 0)
            {
                temp += "- Ngày Cấp CMND không hợp lệ!\n";
            }
        }

        String noisinh = "^[(AÁÀẢÃẠÂẤẦẨẪẬĂẮẰẲẴẶEÉÈẺẼẸÊẾỀỂỄỆIÍÌỈĨỊOÓÒỎÕỌÔỐỒỔỖỘƠỚỜỞỠỢUÚÙỦŨỤƯỨỪỬỮỰYÝỲỶỸỴĐaáàảãạâấầẩẫậăắằẳẵặeéèẻẽẹêếềểễệiíìỉĩịoóòỏõọôốồổỗộơớờởỡợuúùủũụưứừửữựyýỳỷỹỵđ|a-z|A-Z|\\s|/-|0-9]{3,100}$";
        if (!Pattern.matches(noisinh, jTextNoiSinh.getText()))
        {
            temp += "- Nơi Sinh không hợp lệ!\n";
        }

        String trinhdo = "^[(AÁÀẢÃẠÂẤẦẨẪẬĂẮẰẲẴẶEÉÈẺẼẸÊẾỀỂỄỆIÍÌỈĨỊOÓÒỎÕỌÔỐỒỔỖỘƠỚỜỞỠỢUÚÙỦŨỤƯỨỪỬỮỰYÝỲỶỸỴĐaáàảãạâấầẩẫậăắằẳẵặeéèẻẽẹêếềểễệiíìỉĩịoóòỏõọôốồổỗộơớờởỡợuúùủũụưứừửữựyýỳỷỹỵđ|a-z|A-Z|\\s|/-|0-9]{3,100}$";
        if (!Pattern.matches(trinhdo, jTextTdhv.getText()))
        {
            temp += "- Trình Độ Học Vấn không hợp lệ!\n";
        }

        String diachi = "^[(AÁÀẢÃẠÂẤẦẨẪẬĂẮẰẲẴẶEÉÈẺẼẸÊẾỀỂỄỆIÍÌỈĨỊOÓÒỎÕỌÔỐỒỔỖỘƠỚỜỞỠỢUÚÙỦŨỤƯỨỪỬỮỰYÝỲỶỸỴĐaáàảãạâấầẩẫậăắằẳẵặeéèẻẽẹêếềểễệiíìỉĩịoóòỏõọôốồổỗộơớờởỡợuúùủũụưứừửữựyýỳỷỹỵđ|a-z|A-Z|\\s|/-|0-9]{3,100}$";
        if (!Pattern.matches(diachi, jTextDiaChi.getText()))
        {
            temp += "- Địa Chỉ không hợp lệ!\n";
        }

        String cmnd = "^\\d{12}$|^\\d{9}$";
        if (!Pattern.matches(cmnd, jTextCmnd.getText()))
        {
            temp += "- CMND không hợp lệ!\n";
        }

        String sdt = "^\\d{8}$|(^[0]+[1-9]\\d{8})$";
        if (!Pattern.matches(sdt, jTextSDT.getText()))
        {
            temp += "- Số Điện Thoại không hợp lệ!\n";
        }

        String gmail = "^[a-zA-z]+[a-zA-z0-9]+@+[azA-z0-9]+.+com$";
        if (!Pattern.matches(gmail, jTextEmail.getText()))
        {
            temp += "- Email không hợp lệ!\n";
        }
//        System.out.println(jDateNgaySinh.get());

        String luongcb = "([\\d]+.[\\d]+|[\\d]+)";
        if (!Pattern.matches(luongcb, jTextLuongcb.getText()))
        {
            temp += "- Lương Căn Bản không hợp lệ!\n";
        }
        return temp;
    }
    private void jBtnCapPhatMaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCapPhatMaNVActionPerformed
        // TODO add your handling code here:
//        String cpmanv = null;
//        cpmanv = tbnv.getDsnv().CapPhatManv();
//        tk.getjBtnThemNv().setEnabled(true);
//        jBtnHuy.setEnabled(true);
//        jTextManv.setText(cpmanv);
    }//GEN-LAST:event_jBtnCapPhatMaNVActionPerformed

    private void jBtnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnThemActionPerformed
        // TODO add your handling code here:
//        XuatExcel excel = new XuatExcel();
//        excel.xuatFileExcelNhanVien();
//        flagtkmk = 0;
//        tk.getjBtnThemNv().setEnabled(false);
//        tk.getjBtnSuaNv().setEnabled(false);
//        jBtnHuy.setEnabled(false);
//        jBtnCapNhatNV.setEnabled(false);
//        jBtnXoaNV.setEnabled(false);
//        jBtnCapPhatMaNV.setEnabled(true);
//        jTextHonv.requestFocus();
//        tk.setVisible(false);
    }//GEN-LAST:event_jBtnThemActionPerformed

    private void jBtnLuuActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnLuuActionPerformed
    {//GEN-HEADEREND:event_jBtnLuuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnLuuActionPerformed

    private void jBtnThayDoiActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnThayDoiActionPerformed
    {//GEN-HEADEREND:event_jBtnThayDoiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnThayDoiActionPerformed

    private void jButtonTimKiem1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonTimKiem1ActionPerformed
    {//GEN-HEADEREND:event_jButtonTimKiem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonTimKiem1ActionPerformed

    private void jBtnRefresh1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnRefresh1ActionPerformed
    {//GEN-HEADEREND:event_jBtnRefresh1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnRefresh1ActionPerformed

    private void jBtnRefreshActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnRefreshActionPerformed
    {//GEN-HEADEREND:event_jBtnRefreshActionPerformed
        //        // TODO add your handling code here:
        //        jTextTimKiemNV.setText("");
        //        tbnv.loadDataNV();
        //        modelnv.setRowCount(0);
        //        tbnv.bangnhanvien(modelnv);
    }//GEN-LAST:event_jBtnRefreshActionPerformed

    private void jButtonTimKiemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonTimKiemActionPerformed
    {//GEN-HEADEREND:event_jButtonTimKiemActionPerformed
        // TODO add your handling code here:
        //        String manv = jTextTimKiemNV.getText();
        //        tbnv.searchbangnhanvien(modelnv, manv);
        //        jTable1.setModel(modelnv);
        //        System.out.println("click tim kiem");
    }//GEN-LAST:event_jButtonTimKiemActionPerformed

    private void jBtnCapPhatMaTourActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnCapPhatMaTourActionPerformed
    {//GEN-HEADEREND:event_jBtnCapPhatMaTourActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnCapPhatMaTourActionPerformed

    private void jBtnChonGiaTourActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnChonGiaTourActionPerformed
    {//GEN-HEADEREND:event_jBtnChonGiaTourActionPerformed
        // TODO add your handling code here:
        BangGia bangGia = new BangGia();
        bangGia.tourForm = this;
    }//GEN-LAST:event_jBtnChonGiaTourActionPerformed

    private void jBtnChonLoaiHinhActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnChonLoaiHinhActionPerformed
    {//GEN-HEADEREND:event_jBtnChonLoaiHinhActionPerformed
        // TODO add your handling code here:
        BangLoaiHinh bangLoaiHinh = new BangLoaiHinh();
        bangLoaiHinh.tourForm = this;
    }//GEN-LAST:event_jBtnChonLoaiHinhActionPerformed

    private void jBtnXoaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnXoaActionPerformed
    {//GEN-HEADEREND:event_jBtnXoaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnXoaActionPerformed

    private void jBtnSuaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnSuaActionPerformed
    {//GEN-HEADEREND:event_jBtnSuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnSuaActionPerformed

    private void jTableTourMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jTableTourMouseClicked
    {//GEN-HEADEREND:event_jTableTourMouseClicked

    }//GEN-LAST:event_jTableTourMouseClicked

    private void jTextTenTourActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jTextTenTourActionPerformed
    {//GEN-HEADEREND:event_jTextTenTourActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextTenTourActionPerformed

    private void jTextTenTour1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jTextTenTour1ActionPerformed
    {//GEN-HEADEREND:event_jTextTenTour1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextTenTour1ActionPerformed

    private void jBtnChonLoaiHinh1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnChonLoaiHinh1ActionPerformed
    {//GEN-HEADEREND:event_jBtnChonLoaiHinh1ActionPerformed
        // TODO add your handling code here:
        BangDiaDiem bangDiaDiem = new BangDiaDiem();
        bangDiaDiem.tourForm = this;
    }//GEN-LAST:event_jBtnChonLoaiHinh1ActionPerformed

    private void jBtnXoa1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnXoa1ActionPerformed
    {//GEN-HEADEREND:event_jBtnXoa1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnXoa1ActionPerformed

    private void jBtnThem2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnThem2ActionPerformed
    {//GEN-HEADEREND:event_jBtnThem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnThem2ActionPerformed

    private void jBtnSua2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnSua2ActionPerformed
    {//GEN-HEADEREND:event_jBtnSua2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnSua2ActionPerformed

    private void jTableDiadiemMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jTableDiadiemMouseClicked
    {//GEN-HEADEREND:event_jTableDiadiemMouseClicked
        // TODO add your handling code here:
        int rowTbl = jTableDiadiem.getSelectedRow();
        jTextMaTour.setText((String) jTableDiadiem.getValueAt(rowTbl, 0));
//        jTextMaGia.setText((String) jTableDsnv.getValueAt(rowTbl, 1));
        jTextGiaTour.setText((String) jTableDiadiem.getValueAt(rowTbl, 2));
        //        jTextPban.setText((String) jTableDsnv.getValueAt(rowTbl, 3));
        //        jTextCviec.setText((String) jTableDsnv.getValueAt(rowTbl, 4));
        jBtnThem.setEnabled(true);
        jBtnSua.setEnabled(true);
    }//GEN-LAST:event_jTableDiadiemMouseClicked

    private void jTableDoanMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jTableDoanMouseClicked
    {//GEN-HEADEREND:event_jTableDoanMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableDoanMouseClicked

    private void jBtnXemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnXemActionPerformed
    {//GEN-HEADEREND:event_jBtnXemActionPerformed
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_jBtnXemActionPerformed

    private void jBtnHuyActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnHuyActionPerformed
    {//GEN-HEADEREND:event_jBtnHuyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnHuyActionPerformed

    Vector tbColTour = new Vector();//Vector chứa các dòng dữ liệu của bảng.
    Vector tbColDiadiem = new Vector();//Vector chứa các tiêu đề của bảng.
    Vector tbColDoan = new Vector();
    DefaultTableModel tbModelTour, tbModelDiadiem, tbModelDoan;
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
//    public void listCongviec(JComboBox cmb)
//    {
//        ArrayList<CongViecDTO> cbdscviec = tbcviec.getDscviec().getDscviec();
//        addCombo(cmb, cbdscviec);
//    }
//
//    public void addCombo(JComboBox cmb, ArrayList list)
//    {
//        for (Object a : list)
//        {
//            cmb.addItem(a);
//        }
//    }
//    public JTable getjTable1()
//    {
////        return jTable1;
//    }
    public DefaultTableModel getModelnv()
    {
        return modelnv;
    }

//    public JButton getjBtnCapNhatNV()
//    {
//        return jBtnHuy1;
//    }

    public JButton getjBtnCapPhatMaNV()
    {
        return jBtnCapPhatMaNV;
    }

//    public JButton getjBtnHuy()
//    {
//        return jBtnHuy;
//    }
    public JButton getjBtnXoaNV()
    {
        return jBtnXem;
    }

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

//    public JButton getjBtnXacNhan()
//    {
//        return jBtnXacNhan;
//    }
//
//    public void setjBtnXacNhan(JButton jBtnXacNhan)
//    {
//        this.jBtnXacNhan = jBtnXacNhan;
//    }
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
        return jTextTimKiemNV;
    }

    public void setjTextTimKiemNV(JTextField jTextTimKiemNV)
    {
        this.jTextTimKiemNV = jTextTimKiemNV;
    }

    public JButton getjButtonTimKiem()
    {
        return jButtonTimKiem;
    }

    public void setjButtonTimKiem(JButton jButtonTimKiem)
    {
        this.jButtonTimKiem = jButtonTimKiem;
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
        return jBtnThem;
    }

    public void setjButtonExcel(JButton jButtonExcel)
    {
        this.jBtnThem = jButtonExcel;
    }

    public JLabel getjLabelHinh()
    {
        return jLabelHinh;
    }

    public void setjLabelHinh(JLabel jLabelHinh)
    {
        this.jLabelHinh = jLabelHinh;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnCapPhatMaNV;
    private javax.swing.JButton jBtnCapPhatMaTour;
    private javax.swing.JButton jBtnChonGiaTour;
    private javax.swing.JButton jBtnChonLoaiHinh;
    private javax.swing.JButton jBtnChonLoaiHinh1;
    private javax.swing.JButton jBtnHuy;
    private javax.swing.JButton jBtnLuu;
    private javax.swing.JButton jBtnRefresh;
    private javax.swing.JButton jBtnRefresh1;
    private javax.swing.JButton jBtnSua;
    private javax.swing.JButton jBtnSua2;
    private javax.swing.JButton jBtnThayDoi;
    private javax.swing.JButton jBtnThem;
    private javax.swing.JButton jBtnThem2;
    private javax.swing.JButton jBtnXem;
    private javax.swing.JButton jBtnXoa;
    private javax.swing.JButton jBtnXoa1;
    private javax.swing.JButton jButtonTimKiem;
    private javax.swing.JButton jButtonTimKiem1;
    private javax.swing.JComboBox<String> jCbChucVu;
    private javax.swing.JComboBox<String> jCbCongViec;
    private javax.swing.JComboBox<String> jCbGioiTinh;
    private javax.swing.JComboBox<String> jCbPhongBan;
    //private Vector<String> pb=new Vector<String>();
    private com.toedter.calendar.JDateChooser jDateNgayBD;
    private com.toedter.calendar.JDateChooser jDateNgaySinh;
    private com.toedter.calendar.JDateChooser jDateNgaySinh2;
    private com.toedter.calendar.JDateChooser jDateNgaycapcmnd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelHinh;
    private javax.swing.JLabel jLabelTTTour;
    private javax.swing.JLabel jLbManv;
    private javax.swing.JLabel jLbManv1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanelChiTietTour;
    private javax.swing.JPanel jPanelQLTour;
    private javax.swing.JPanel jPanelTLTour;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableDiadiem;
    private javax.swing.JTable jTableDoan;
    private javax.swing.JTable jTableTour;
    private javax.swing.JTextField jTextCmnd;
    private javax.swing.JTextField jTextDiaChi;
    private javax.swing.JTextField jTextEmail;
    private javax.swing.JTextField jTextGiaTour;
    private javax.swing.JTextField jTextGiaTour1;
    private javax.swing.JTextField jTextHonv;
    private javax.swing.JTextField jTextLoaiHinh;
    private javax.swing.JTextField jTextLoaiHinh1;
    private javax.swing.JTextField jTextLuongcb;
    private javax.swing.JTextField jTextMaTour;
    private javax.swing.JTextField jTextMaTour1;
    private javax.swing.JTextField jTextManv;
    private javax.swing.JTextField jTextNoiSinh;
    private javax.swing.JTextField jTextSDT;
    private javax.swing.JTextField jTextTdhv;
    private javax.swing.JTextField jTextTenTour;
    private javax.swing.JTextField jTextTenTour1;
    private javax.swing.JTextField jTextTennv;
    private javax.swing.JTextField jTextTimKiemNV;
    private javax.swing.JTextField jTextTimKiemNV1;
    // End of variables declaration//GEN-END:variables
}
