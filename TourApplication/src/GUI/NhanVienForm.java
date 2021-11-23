/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.*;
import DTO.DoanDuLichDTO;
import DTO.NhanVienDTO;
import DTO.NhiemVuNhanVienDTO;
//import DAO.XuatExcel;
//import DTO.ChucVuDTO;
//import DTO.CongViecDTO;
//import DTO.PhongBanDTO;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Hyung
 */
public class NhanVienForm extends javax.swing.JPanel
{

    /**
     * Creates new form jPanel2
     */
    static int flagtkmk = 0;
    DefaultTableModel modelnv, modelThongKe;
    private int flagAcc;
    private String manv;
    private NhanVienBUS nhanVienBUS;
    private DoanDuLichBUS doanDuLichBUS;
    private int selectedRow;
    private Utils ult = new Utils();

    public NhanVienForm()
    {
        initComponents();
        jBtnCapPhatMaNV.setEnabled(true);
        jBtnThemNV.setEnabled(false);
        jBtnSuaNV.setEnabled(false);
        jBtnXoaNV.setEnabled(false);
        jBtnHuy1.setEnabled(false);
        jTextMaNhanVien.setText("");
        jTextTenNhanVien.setText("");
        jTextSDT.setText("");
        jTextDiaChi.setText("");
        jDateNgaySinh.setCalendar(null);
        //loadData();
//        tk.setVisible(false);
    }

    public void loadData()
    {
        nhanVienBUS = new NhanVienBUS();
        doanDuLichBUS = new DoanDuLichBUS();
        modelnv.setRowCount(0);
        tbModelNhanVien(modelnv);
    }

    public void tbModelNhanVien(DefaultTableModel model)
    {
        Vector row;
        for (NhanVienDTO a : DashBoard.nhanVienDTOs)
        {
            row = new Vector();
            row.add(a.getMaNhanVien());
            row.add(a.getTenNhanVien());
            if (a.getGioiTinh().equals("1"))
            {
                row.add("Nam");
            } else
            {
                row.add("Nữ");
            }
            row.add(a.getNgaySinh());
            row.add(a.getSDT());
            row.add(a.getDiaChi());
            model.addRow(row);
        }
    }

    public boolean add(String maNhanVien, String tenNhanVien, String gioiTinh, String ngaySinh, String sdt, String diaChi)
    {
        return nhanVienBUS.add(new NhanVienDTO(maNhanVien, tenNhanVien, gioiTinh, ngaySinh, sdt, diaChi), DashBoard.nhanVienDTOs);
    }

    public boolean update(String maNhanVien, String tenNhanVien, String gioiTinh, String ngaySinh, String sdt, String diaChi)
    {
        return nhanVienBUS.update(new NhanVienDTO(maNhanVien, tenNhanVien, gioiTinh, ngaySinh, sdt, diaChi), DashBoard.nhanVienDTOs);
    }

    public boolean delete(String maNhanVien)
    {
        return nhanVienBUS.delete(maNhanVien, DashBoard.nhanVienDTOs);
    }

    public void searchNhanVienByMaNhanVien(DefaultTableModel model, String maNhanVien)
    {
        Vector row;
        for (NhanVienDTO a : nhanVienBUS.searchNhanVienByMaNhanVien(maNhanVien, DashBoard.nhanVienDTOs))
        {
            row = new Vector();
            System.out.println(a);
            row.add(a.getMaNhanVien());
            row.add(a.getTenNhanVien());
            if (a.getGioiTinh().equals("1"))
            {
                row.add("Nam");
            } else
            {
                row.add("Nữ");
            }
            row.add(a.getNgaySinh());
            row.add(a.getSDT());
            row.add(a.getDiaChi());
            model.addRow(row);
            break;
        }
    }

    public void tbModelThongKeNhanVien(DefaultTableModel model,Date start,Date end){
        //ArrayList<NhanVienDTO> arr = new ArrayList<>();
        ArrayList<DoanDuLichDTO> arrDoan = doanDuLichBUS.searchDoanByDate(start, end, DashBoard.doanDuLichDTOs);
        Vector rowVector;
//        if(jDateNgayBDTK.getDate()!=null&&jDateNgayKTTK.getDate()!=null)
        if(arrDoan.size() >0){
            int count = 0;        

            for(NhanVienDTO a : DashBoard.nhanVienDTOs){
                rowVector = new Vector();
                for(NhiemVuNhanVienDTO b : DashBoard.nhiemVuNhanVienDTOs){
                    for(DoanDuLichDTO c : arrDoan){
                        if((a.getMaNhanVien().equals(b.getMaNhanVien()))&&(b.getMaDoan().equals(c.getMaDoan()))){
                           count++; 
                        }
                    }   
                }
                rowVector.add(a.getMaNhanVien());
                rowVector.add(a.getTenNhanVien());
                rowVector.add(count);
//                System.out.println(rowVector);
                model.addRow(rowVector);
                count = 0;            
            }    
        }
        else{
            for(NhanVienDTO a : DashBoard.nhanVienDTOs){
                rowVector = new Vector();
                rowVector.add(a.getMaNhanVien());
                rowVector.add(a.getTenNhanVien());
                rowVector.add(0);
            }       
        }

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
        jTextMaNhanVien = new javax.swing.JTextField();
        jBtnCapPhatMaNV = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jTextTenNhanVien = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTextSDT = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jDateNgaySinh = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        jCbGioiTinh = new javax.swing.JComboBox<>();
        jTextDiaChi = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jTextTimKiemNV = new javax.swing.JTextField();
        jButtonTimKiem = new javax.swing.JButton();
        jBtnRefresh = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableNV = new javax.swing.JTable();
        jPanelThongkeNV = new javax.swing.JPanel();
        jButtonThongKe = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableThongke = new javax.swing.JTable();
        jLabel26 = new javax.swing.JLabel();
        jDateNgayBDTK = new com.toedter.calendar.JDateChooser();
        jLabel27 = new javax.swing.JLabel();
        jDateNgayKTTK = new com.toedter.calendar.JDateChooser();

        setBackground(new java.awt.Color(233, 242, 249));
        setPreferredSize(new java.awt.Dimension(990, 650));

        jTabbedPane1.setBackground(new java.awt.Color(233, 242, 249));
        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jPanelNV.setBackground(new java.awt.Color(233, 242, 249));
        jPanelNV.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelNV.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(233, 242, 249));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hồ Sơ Nhân Viên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(0, 51, 102))); // NOI18N

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
        jLabel4.setText("<html> <body> Mã Nhân Viên <span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");

        jTextMaNhanVien.setBackground(new java.awt.Color(214, 217, 223));
        jTextMaNhanVien.setEditable(false);

        jBtnCapPhatMaNV.setBackground(new java.awt.Color(81, 113, 131));
        jBtnCapPhatMaNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_edit_account_16.png"))); // NOI18N
        jBtnCapPhatMaNV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnCapPhatMaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCapPhatMaNVActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setText("<html> <body>Họ Tên Nhân Viên <span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel16.setText("<html> <body>SĐT <span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");

        jLabel25.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel25.setText("<html> <body>Ngày Sinh<span style=\"color:rgb(216, 74, 67);\"> *</span> </body> </html> ");

        jDateNgaySinh.setBackground(new java.awt.Color(214, 217, 223));
        jDateNgaySinh.setDateFormatString("yyyy-MM-dd");
        JTextFieldDateEditor editor1 = (JTextFieldDateEditor) jDateNgaySinh.getDateEditor();
        editor1.setEditable(false);

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setText("<html> <body> Giới Tính <span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");

        jCbGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));
        jCbGioiTinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCbGioiTinhActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel17.setText("<html> <body>Địa Chỉ <span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)
                        .addComponent(jDateNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCbGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jBtnCapPhatMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtnXoaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnThemNV, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBtnSuaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnHuy1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnCapPhatMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCbGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDateNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnThemNV, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnSuaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnHuy1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnXoaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanelNV.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 400, 460));

        jLabel22.setText("Mã NV");
        jPanelNV.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 30, -1, 30));

        jTextTimKiemNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextTimKiemNVActionPerformed(evt);
            }
        });
        jPanelNV.add(jTextTimKiemNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 30, 160, 30));

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

        jTableNV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableNVMouseClicked(evt);
            }
        });
        tableCol.add ("Mã Nhân Viên");
        tableCol.add ("Tên Nhân Viên");
        tableCol.add ("Giới Tính");
        tableCol.add ("Ngày Sinh");
        tableCol.add ("Số ĐT");
        tableCol.add ("Địa Chỉ");
        modelnv = new DefaultTableModel(tableCol, 5){
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex){
                return false;
            }
        };
        jTableNV.setModel(modelnv);
        jTableNV.setShowGrid(true);
        jTableNV.setFocusable(false);
        jTableNV.setIntercellSpacing(new Dimension(0,0));
        jTableNV.setRowHeight(25);
        jTableNV.getTableHeader().setOpaque(false);
        jTableNV.setFillsViewportHeight(true);
        jTableNV.getTableHeader().setBackground(new Color(232,57,99));
        jTableNV.getTableHeader().setForeground(new Color(141, 22, 22));
        jTableNV.getTableHeader().setFont (new Font("Dialog", Font.BOLD, 13));
        jTableNV.setSelectionBackground(new Color(52,152,219));
        jTableNV.setGridColor(new java.awt.Color(83, 86, 88));

        jTableNV.getColumn (tableCol.elementAt (0)).setPreferredWidth (150);
        jTableNV.getColumn (tableCol.elementAt (1)).setPreferredWidth (150);
        jTableNV.getColumn (tableCol.elementAt (2)).setPreferredWidth (120);
        jTableNV.getColumn (tableCol.elementAt (3)).setPreferredWidth (160);
        jTableNV.getColumn (tableCol.elementAt (4)).setPreferredWidth (160);
        jTableNV.getColumn (tableCol.elementAt (5)).setPreferredWidth (160);
        jScrollPane2.setViewportView(jTableNV);
        jTableNV.setAutoResizeMode (javax.swing.JTable.AUTO_RESIZE_OFF);

        jPanelNV.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 70, 540, 520));

        jTabbedPane1.addTab("Quản Lý Nhân Viên", jPanelNV);

        jPanelThongkeNV.setBackground(new java.awt.Color(233, 242, 249));
        jPanelThongkeNV.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelThongkeNV.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonThongKe.setText("Thống Kê");
        jButtonThongKe.setPreferredSize(new java.awt.Dimension(79, 30));
        jButtonThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonThongKeActionPerformed(evt);
            }
        });
        jPanelThongkeNV.add(jButtonThongKe, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 30, 120, -1));

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane3.setAutoscrolls(true);

        jTableThongke.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableThongke.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableThongkeMouseClicked(evt);
            }
        });
        tableColThongKe.add ("Mã Nhân Viên");
        tableColThongKe.add ("Tên Nhân Viên");
        tableColThongKe.add ("Số Lần Đi Tour");
        modelThongKe = new DefaultTableModel(tableColThongKe, 0){
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex){
                return false;
            }
        };
        jTableThongke.setModel(modelThongKe);
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<TableModel>(modelThongKe);
        jTableThongke.setRowSorter(rowSorter);
        jTableThongke.setShowGrid(true);
        jTableThongke.setFocusable(false);
        jTableThongke.setIntercellSpacing(new Dimension(0,0));
        jTableThongke.setRowHeight(25);
        jTableThongke.getTableHeader().setOpaque(false);
        jTableThongke.setFillsViewportHeight(true);
        jTableThongke.getTableHeader().setBackground(new Color(232,57,99));
        jTableThongke.getTableHeader().setForeground(new Color(141, 22, 22));
        jTableThongke.getTableHeader().setFont (new Font("Dialog", Font.BOLD, 13));
        jTableThongke.setSelectionBackground(new Color(52,152,219));
        jTableThongke.setGridColor(new java.awt.Color(83, 86, 88));
        jScrollPane3.setViewportView(jTableThongke);

        jPanelThongkeNV.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 950, 520));

        jLabel26.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel26.setText("<html> <body>Ngày Băt Đầu<span style=\"color:rgb(216, 74, 67);\"> *</span> </body> </html> ");
        jPanelThongkeNV.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, 30));

        jDateNgayBDTK.setBackground(new java.awt.Color(214, 217, 223));
        jDateNgayBDTK.setDateFormatString("yyyy-MM-dd");
        JTextFieldDateEditor editor2 = (JTextFieldDateEditor) jDateNgayBDTK.getDateEditor();
        editor2.setEditable(false);
        jPanelThongkeNV.add(jDateNgayBDTK, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 170, 30));

        jLabel27.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel27.setText("<html> <body>Ngày Kết Thúc<span style=\"color:rgb(216, 74, 67);\"> *</span> </body> </html> ");
        jPanelThongkeNV.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, -1, 30));

        jDateNgayKTTK.setBackground(new java.awt.Color(214, 217, 223));
        jDateNgayKTTK.setDateFormatString("yyyy-MM-dd");
        JTextFieldDateEditor editor3 = (JTextFieldDateEditor) jDateNgayKTTK.getDateEditor();
        editor3.setEditable(false);
        jPanelThongkeNV.add(jDateNgayKTTK, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 30, 180, 30));

        jTabbedPane1.addTab("Thống Kê", jPanelThongkeNV);

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

    private void jButtonTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTimKiemActionPerformed
        // TODO add your handling code here:
//        String manv = jTextTimKiemNV.getText();
//        tbnv.searchbangnhanvien(modelnv, manv);
//        jTable1.setModel(modelnv);
//        System.out.println("click tim kiem");
        modelnv.setRowCount(0);
        searchNhanVienByMaNhanVien(modelnv, jTextTimKiemNV.getText());
    }//GEN-LAST:event_jButtonTimKiemActionPerformed

    private void jBtnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRefreshActionPerformed
//        // TODO add your handling code here:
//        jTextTimKiemNV.setText("");
//        tbnv.loadDataNV();
//        modelnv.setRowCount(0);
//        tbnv.bangnhanvien(modelnv);
    }//GEN-LAST:event_jBtnRefreshActionPerformed

    private void jBtnCapPhatMaNVActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnCapPhatMaNVActionPerformed
    {//GEN-HEADEREND:event_jBtnCapPhatMaNVActionPerformed
        // TODO add your handling code here:
        jTextMaNhanVien.setText(ult.initMaNhanVien());
        jBtnCapPhatMaNV.setEnabled(false);
        jBtnThemNV.setEnabled(true);
        jBtnSuaNV.setEnabled(false);
        jBtnXoaNV.setEnabled(false);
        jBtnHuy1.setEnabled(true);
        jTextTenNhanVien.setText("");
        jTextSDT.setText("");
        jTextDiaChi.setText("");
        jDateNgaySinh.setCalendar(null);
    }//GEN-LAST:event_jBtnCapPhatMaNVActionPerformed

    private void jTableNVMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jTableNVMouseClicked
    {//GEN-HEADEREND:event_jTableNVMouseClicked
        if (evt.getSource() == jTableNV)
        {
            selectedRow = jTableNV.getSelectedRow();
            if (selectedRow != -1)
            {
                jTextMaNhanVien.setText((String) modelnv.getValueAt(selectedRow, 0));
                jTextTenNhanVien.setText((String) modelnv.getValueAt(selectedRow, 1));
                if (modelnv.getValueAt(selectedRow, 2).equals("Nam"))
                {
                    jCbGioiTinh.setSelectedIndex(0);
                } else
                {
                    jCbGioiTinh.setSelectedIndex(1);
                }
                Date ngaySinh;
                try
                {
                    ngaySinh = new SimpleDateFormat("yyyy-MM-dd").parse(modelnv.getValueAt(selectedRow, 3).toString());
                    jDateNgaySinh.setDate(ngaySinh);
                } catch (ParseException ex)
                {
                    Logger.getLogger(KhachHangForm.class.getName()).log(Level.SEVERE, null, ex);
                }
                jTextSDT.setText((String) modelnv.getValueAt(selectedRow, 4));
                jTextDiaChi.setText((String) modelnv.getValueAt(selectedRow, 5));
                jBtnCapPhatMaNV.setEnabled(false);
                jBtnThemNV.setEnabled(false);
                jBtnSuaNV.setEnabled(true);
                jBtnXoaNV.setEnabled(true);
                jBtnHuy1.setEnabled(true);
            }
        }
    }//GEN-LAST:event_jTableNVMouseClicked

    private void jTextTimKiemNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextTimKiemNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextTimKiemNVActionPerformed

    private void jBtnThemNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnThemNVActionPerformed
        String ngaySinh = (String) ((JTextField) jDateNgaySinh.getDateEditor().getUiComponent()).getText();
        String gioiTinh;
        Vector addRow = new Vector();
        if (jCbGioiTinh.getSelectedItem().equals("Nam"))
        {
            gioiTinh = "1";
        } else
        {
            gioiTinh = "0";
        }
        if (add(jTextMaNhanVien.getText(), jTextTenNhanVien.getText(), gioiTinh, ngaySinh, jTextSDT.getText(), jTextDiaChi.getText()))
        {
            addRow = new Vector();
            addRow.add(jTextMaNhanVien.getText());
            addRow.add(jTextTenNhanVien.getText());
            addRow.add(jCbGioiTinh.getSelectedItem());
            addRow.add(ngaySinh);
            addRow.add(jTextSDT.getText());
            addRow.add(jTextDiaChi.getText());
            modelnv.addRow(addRow);
        } else
        {

        }
        jBtnCapPhatMaNV.setEnabled(true);
        jBtnThemNV.setEnabled(false);
        jBtnSuaNV.setEnabled(false);
        jBtnXoaNV.setEnabled(false);
        jBtnHuy1.setEnabled(false);
        jTextMaNhanVien.setText("");
        jTextTenNhanVien.setText("");
        jTextSDT.setText("");
        jTextDiaChi.setText("");
        jDateNgaySinh.setCalendar(null);
    }//GEN-LAST:event_jBtnThemNVActionPerformed

    private void jBtnSuaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSuaNVActionPerformed
        String ngaySinh = (String) ((JTextField) jDateNgaySinh.getDateEditor().getUiComponent()).getText();
        String gioiTinh;
        if (jCbGioiTinh.getSelectedItem().equals("Nam"))
        {
            gioiTinh = "1";
        } else
        {
            gioiTinh = "0";
        }
        if (update(jTextMaNhanVien.getText(), jTextTenNhanVien.getText(), gioiTinh, ngaySinh, jTextSDT.getText(), jTextDiaChi.getText()))
        {
            modelnv.setValueAt(jTextMaNhanVien.getText(), selectedRow, 0);
            modelnv.setValueAt(jTextTenNhanVien.getText(), selectedRow, 1);
            modelnv.setValueAt(jCbGioiTinh.getSelectedItem(), selectedRow, 2);
            modelnv.setValueAt(ngaySinh, selectedRow, 3);
            modelnv.setValueAt(jTextSDT.getText(), selectedRow, 4);
            modelnv.setValueAt(jTextDiaChi.getText(), selectedRow, 5);
        } else
        {

        }
        jBtnCapPhatMaNV.setEnabled(true);
        jBtnThemNV.setEnabled(false);
        jBtnSuaNV.setEnabled(false);
        jBtnXoaNV.setEnabled(false);
        jBtnHuy1.setEnabled(false);
        jTextMaNhanVien.setText("");
        jTextTenNhanVien.setText("");
        jTextSDT.setText("");
        jTextDiaChi.setText("");
        jDateNgaySinh.setCalendar(null);
    }//GEN-LAST:event_jBtnSuaNVActionPerformed

    private void jBtnXoaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnXoaNVActionPerformed
        if (delete(modelnv.getValueAt(selectedRow, 0).toString()))
        {
            modelnv.removeRow(selectedRow);
        }
        jBtnCapPhatMaNV.setEnabled(true);
        jBtnThemNV.setEnabled(false);
        jBtnSuaNV.setEnabled(false);
        jBtnXoaNV.setEnabled(false);
        jBtnHuy1.setEnabled(false);
        jTextMaNhanVien.setText("");
        jTextTenNhanVien.setText("");
        jTextSDT.setText("");
        jTextDiaChi.setText("");
        jDateNgaySinh.setCalendar(null);
    }//GEN-LAST:event_jBtnXoaNVActionPerformed

    private void jBtnHuy1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnHuy1ActionPerformed
        jBtnCapPhatMaNV.setEnabled(true);
        jBtnThemNV.setEnabled(false);
        jBtnSuaNV.setEnabled(false);
        jBtnXoaNV.setEnabled(false);
        jBtnHuy1.setEnabled(false);
        jTextMaNhanVien.setText("");
        jTextTenNhanVien.setText("");
        jTextSDT.setText("");
        jTextDiaChi.setText("");
        jDateNgaySinh.setCalendar(null);
    }//GEN-LAST:event_jBtnHuy1ActionPerformed

    private void jCbGioiTinhActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jCbGioiTinhActionPerformed
    {//GEN-HEADEREND:event_jCbGioiTinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCbGioiTinhActionPerformed

    private void jButtonThongKeActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonThongKeActionPerformed
    {//GEN-HEADEREND:event_jButtonThongKeActionPerformed
        // TODO add your handling code here:
        modelThongKe.setRowCount(0);
        if (jDateNgayBDTK.getDate() == null || jDateNgayKTTK.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Ngày Bắt Đầu và Ngày Kết Thúc không được bỏ trống!");
            return;
        }
        String ngayBD = (String) ((JTextField) jDateNgayBDTK.getDateEditor().getUiComponent()).getText(),
                ngayKT = (String) ((JTextField) jDateNgayKTTK.getDateEditor().getUiComponent()).getText();
        //Validation
        StringBuilder message = new StringBuilder();
        Validation.afterOrEquals(message, "Ngày kết thúc", ngayKT, "Ngày bắt đầu", ngayBD);
        if(!message.toString().equals("")){
            JOptionPane.showMessageDialog(this, message.toString());
            return;
        }
        tbModelThongKeNhanVien(modelThongKe,jDateNgayBDTK.getDate(),jDateNgayKTTK.getDate());
    }//GEN-LAST:event_jButtonThongKeActionPerformed

    private void jTableThongkeMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jTableThongkeMouseClicked
    {//GEN-HEADEREND:event_jTableThongkeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableThongkeMouseClicked

//    Vector tableRow = new Vector ();//Vector chứa các dòng dữ liệu của bảng.
    Vector tableCol = new Vector();//Vector chứa các tiêu đề của bảng.
    Vector tableColThongKe = new Vector();

    public JPanel getjPanel1()
    {
        return jPanelNV;
    }

    public JTextField getjTextManv()
    {
        return jTextMaNhanVien;
    }

    public DefaultTableModel getModelnv()
    {
        return modelnv;
    }

    public JButton getjBtnCapPhatMaNV()
    {
        return jBtnCapPhatMaNV;
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnCapPhatMaNV;
    private javax.swing.JButton jBtnHuy1;
    private javax.swing.JButton jBtnRefresh;
    private javax.swing.JButton jBtnSuaNV;
    private javax.swing.JButton jBtnThemNV;
    private javax.swing.JButton jBtnXoaNV;
    private javax.swing.JButton jButtonThongKe;
    private javax.swing.JButton jButtonTimKiem;
    private javax.swing.JComboBox<String> jCbGioiTinh;
    private com.toedter.calendar.JDateChooser jDateNgayBDTK;
    private com.toedter.calendar.JDateChooser jDateNgayKTTK;
    private com.toedter.calendar.JDateChooser jDateNgaySinh;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelNV;
    private javax.swing.JPanel jPanelThongkeNV;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableNV;
    private javax.swing.JTable jTableThongke;
    private javax.swing.JTextField jTextDiaChi;
    private javax.swing.JTextField jTextMaNhanVien;
    private javax.swing.JTextField jTextSDT;
    private javax.swing.JTextField jTextTenNhanVien;
    private javax.swing.JTextField jTextTimKiemNV;
    // End of variables declaration//GEN-END:variables
}
