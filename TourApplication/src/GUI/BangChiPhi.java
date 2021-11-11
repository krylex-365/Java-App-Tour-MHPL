/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

//import BUS.CongViecBUS;
import BUS.ChiPhiBUS;
import BUS.GiaTourBUS;
import BUS.Utils;
import BUS.Validation;
import DTO.ChiPhiDTO;
import DTO.GiaTourDTO;
import DTO.LoaiChiPhiDTO;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
//import BUS.NhanVienBUS;
//import BUS.NhanVienCongViecBUS;
//import BUS.PhongBanBUS;
//import DTO.NhanVienDTO;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Hyung
 */
public class BangChiPhi extends javax.swing.JFrame {

    /**
     * Creates new form DSNV
     */
    int rowTbl;
    DoanForm doanForm;
    Vector tbCol = new Vector();
    DefaultTableModel tbModel;
    String maDoan, tenDoan, tongChiPhi, maLoaiCPHH, soTienHH;
    ChiPhiBUS chiPhiBUS;
    private Utils ult = new Utils();

    public BangChiPhi() {
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
    }

    public BangChiPhi(String maDoan, String tenDoan, String tongChiPhi) {
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
        this.maDoan = maDoan;
        this.tenDoan = tenDoan;
        this.tongChiPhi = tongChiPhi;
        initTable();
        jTableChiPhi.setEditingColumn(5);
        jTextMaDoan.setText(this.maDoan);
        jTextTenDoan.setText(this.tenDoan);
        jBtnCapPhatMaChiPhi.setEnabled(true);
        jBtnThem.setEnabled(false);
        jBtnSua.setEnabled(false);
        jBtnXoa.setEnabled(false);
        jBtnHuy.setEnabled(false);
        jBtnThoat.setEnabled(true);
    }

    public void initTable() {
        chiPhiBUS = new ChiPhiBUS();
        tbModel.setRowCount(0);
        tableModel(tbModel);
        jTableChiPhi.setModel(tbModel);
        jCbLoaiCP.removeAllItems();
        addCombo(jCbLoaiCP);
    }

    public void tableModel(DefaultTableModel model) {
        for (ChiPhiDTO chiPhi : DashBoard.chiPhiDTOs) {
            if (chiPhi.getMaDoan().equals(this.maDoan)) {
                Vector row = new Vector();
                row.add(chiPhi.getMaChiPhi());
                for (LoaiChiPhiDTO loaiCP : DashBoard.loaiChiPhiDTOs) {
                    if (loaiCP.getMaLoaiChiPhi().equals(chiPhi.getMaLoaiChiPhi())) {
                        row.add(loaiCP.getTenLoai());
                    }
                }
                row.add(chiPhi.getSoTien());
                model.addRow(row);
            }
        }
    }

    public void themVectorChiPhi(DefaultTableModel model, ChiPhiDTO chiPhiDTO, String tenLoaiCP) {
        Vector newrow = new Vector();
        newrow.add(chiPhiDTO.getMaChiPhi());
        newrow.add(tenLoaiCP);
        newrow.add(chiPhiDTO.getSoTien());
        model.addRow(newrow);
    }

    public void suaVectorChiPhi(DefaultTableModel model, int row, ChiPhiDTO chiPhiDTO, String tenLoaiCP) {
        model.setValueAt(tenLoaiCP, row, 1);
        model.setValueAt(chiPhiDTO.getSoTien(), row, 2);
    }

    public void xoaVectorChiPhi(DefaultTableModel model, int row) {
        model.removeRow(row);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new keeptoo.KGradientPanel();
        jPanel4 = new javax.swing.JPanel();
        jLbMaGia = new javax.swing.JLabel();
        jTextMaChiPhi = new javax.swing.JTextField();
        jLbGiaTour = new javax.swing.JLabel();
        jBtnSua = new javax.swing.JButton();
        jBtnThem = new javax.swing.JButton();
        jBtnXoa = new javax.swing.JButton();
        jBtnHuy = new javax.swing.JButton();
        jBtnThoat = new javax.swing.JButton();
        jLbMaTour = new javax.swing.JLabel();
        jTextMaDoan = new javax.swing.JTextField();
        jLbMaGiaNow = new javax.swing.JLabel();
        jTextTenDoan = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jBtnCapPhatMaChiPhi = new javax.swing.JButton();
        jLbGiaTour1 = new javax.swing.JLabel();
        jTextSoTien = new javax.swing.JTextField();
        jCbLoaiCP = new javax.swing.JComboBox<>();
        jLbGiaTour2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextGhiChu = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableChiPhi = new javax.swing.JTable();
        jTextTimKiemGia = new javax.swing.JTextField();
        jBtnTimKiemCP = new javax.swing.JButton();
        jBtnRefresh = new javax.swing.JButton();

        setBackground(new java.awt.Color(236, 245, 252));
        setMinimumSize(new java.awt.Dimension(1000, 500));
        setSize(new java.awt.Dimension(1000, 500));
        setType(java.awt.Window.Type.POPUP);

        kGradientPanel1.setkEndColor(new java.awt.Color(236, 245, 252));
        kGradientPanel1.setkStartColor(new java.awt.Color(236, 245, 252));
        kGradientPanel1.setPreferredSize(new java.awt.Dimension(1000, 500));

        jPanel4.setBackground(new java.awt.Color(236, 245, 252));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chi Phí Tour", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(0, 51, 102)));
        jPanel4.setPreferredSize(new java.awt.Dimension(1000, 550));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLbMaGia.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLbMaGia.setText("<html><body>Mã Chi Phí <span style=\"color:rgb(234, 21, 21)\"> *</span> </body> </html>");
        jPanel4.add(jLbMaGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 110, 30));

        jTextMaChiPhi.setEditable(false);
        jTextMaChiPhi.setBackground(new java.awt.Color(214, 217, 223));
        jTextMaChiPhi.setForeground(new java.awt.Color(51, 51, 51));
        jPanel4.add(jTextMaChiPhi, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 170, 30));

        jLbGiaTour.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLbGiaTour.setText("<html> <body>Loai Chi Phí <span style=\"color:rgb(234, 21, 21)\"> *</span> </body> </html>");
        jPanel4.add(jLbGiaTour, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, 30));

        jBtnSua.setBackground(new java.awt.Color(136, 193, 184));
        jBtnSua.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnSua.setText("Sửa");
        jBtnSua.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSuaActionPerformed(evt);
            }
        });
        jPanel4.add(jBtnSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 340, 100, 40));

        jBtnThem.setBackground(new java.awt.Color(136, 193, 184));
        jBtnThem.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnThem.setText("Thêm");
        jBtnThem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnThemActionPerformed(evt);
            }
        });
        jPanel4.add(jBtnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 100, 40));

        jBtnXoa.setBackground(new java.awt.Color(136, 193, 184));
        jBtnXoa.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnXoa.setText("Xóa");
        jBtnXoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnXoaActionPerformed(evt);
            }
        });
        jPanel4.add(jBtnXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 100, 40));

        jBtnHuy.setBackground(new java.awt.Color(136, 193, 184));
        jBtnHuy.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnHuy.setText("Hủy");
        jBtnHuy.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnHuyActionPerformed(evt);
            }
        });
        jPanel4.add(jBtnHuy, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 390, 100, 40));

        jBtnThoat.setBackground(new java.awt.Color(136, 193, 184));
        jBtnThoat.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnThoat.setText("Thoát");
        jBtnThoat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnThoatActionPerformed(evt);
            }
        });
        jPanel4.add(jBtnThoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 390, 100, 40));

        jLbMaTour.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLbMaTour.setText("<html> <body> Mã Đoàn</body> </html>");
        jPanel4.add(jLbMaTour, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, 30));

        jTextMaDoan.setEditable(false);
        jTextMaDoan.setBackground(new java.awt.Color(214, 217, 223));
        jTextMaDoan.setForeground(new java.awt.Color(51, 51, 51));
        jPanel4.add(jTextMaDoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 170, 30));

        jLbMaGiaNow.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLbMaGiaNow.setText("<html><body>Tên Đoàn</body> </html>");
        jPanel4.add(jLbMaGiaNow, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 110, 50));

        jTextTenDoan.setEditable(false);
        jTextTenDoan.setBackground(new java.awt.Color(214, 217, 223));
        jTextTenDoan.setForeground(new java.awt.Color(51, 51, 51));
        jPanel4.add(jTextTenDoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 170, 30));
        jPanel4.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 320, 10));

        jBtnCapPhatMaChiPhi.setBackground(new java.awt.Color(81, 113, 131));
        jBtnCapPhatMaChiPhi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_add_32.png"))); // NOI18N
        jBtnCapPhatMaChiPhi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnCapPhatMaChiPhi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCapPhatMaChiPhiActionPerformed(evt);
            }
        });
        jPanel4.add(jBtnCapPhatMaChiPhi, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 30, 30));

        jLbGiaTour1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLbGiaTour1.setText("<html> <body>Ghi Chú <span style=\"color:rgb(234, 21, 21)\"> *</span> </body> </html>");
        jPanel4.add(jLbGiaTour1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, 30));

        jTextSoTien.setForeground(new java.awt.Color(51, 51, 51));
        jPanel4.add(jTextSoTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 170, 30));

        /*
        jCbLoaiCP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "L1", "L2", "L3", "L4..." }));
        */
        jCbLoaiCP.setPreferredSize(new java.awt.Dimension(64, 22));
        jPanel4.add(jCbLoaiCP, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 172, 170, 30));

        jLbGiaTour2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLbGiaTour2.setText("<html><body>Số Tiền <span style=\"color:rgb(234, 21, 21)\"> *</span> </body> </html>");
        jPanel4.add(jLbGiaTour2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, 30));

        jTextGhiChu.setColumns(20);
        jTextGhiChu.setRows(5);
        jScrollPane2.setViewportView(jTextGhiChu);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 170, 80));

        jTableChiPhi.setAutoCreateRowSorter(true);
        jTableChiPhi.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTableChiPhi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbCol.add("Mă Chi Phí");
        tbCol.add("Loại Chi Phí");
        tbCol.add("Số Tiền");
        tbModel= new DefaultTableModel(tbCol,5){
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex){
                return false;
            }
        };
        jTableChiPhi.setModel (tbModel);
        jTableChiPhi.setShowGrid(true);
        jTableChiPhi.setFocusable(false);
        jTableChiPhi.setIntercellSpacing(new Dimension(0,0));
        jTableChiPhi.setRowHeight(25);
        jTableChiPhi.getTableHeader().setOpaque(false);
        jTableChiPhi.setFillsViewportHeight(true);
        jTableChiPhi.getTableHeader().setBackground(new Color(232,57,99));
        jTableChiPhi.getTableHeader().setForeground(new Color(141, 22, 22));
        jTableChiPhi.getTableHeader().setFont (new Font("Dialog", Font.BOLD, 13));
        jTableChiPhi.setSelectionBackground(new Color(52,152,219));
        //listSP();
        jTableChiPhi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableChiPhiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableChiPhi);

        jBtnTimKiemCP.setText("Tìm kiếm");
        jBtnTimKiemCP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnTimKiemCPActionPerformed(evt);
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

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 622, Short.MAX_VALUE)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(jTextTimKiemGia, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnTimKiemCP, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextTimKiemGia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtnTimKiemCP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnSuaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnSuaActionPerformed
    {//GEN-HEADEREND:event_jBtnSuaActionPerformed
        String maCP = (String) jTextMaChiPhi.getText(),
                tenLoaiCP = jCbLoaiCP.getSelectedItem().toString(),
                maLoaiCP = searchMaLoai(tenLoaiCP),
                soTien = (String) jTextSoTien.getText(),
                ghiChu = (String) jTextGhiChu.getText();

        //Validation
        StringBuilder message = new StringBuilder();
        Validation.notNullOrEmpty(message, "Loại chi phí", tenLoaiCP, "Ghi chú", ghiChu);
        Validation.positiveNumbers(message, "Số tiền", soTien);
        if(!message.toString().equals("")){
            JOptionPane.showMessageDialog(this, message.toString());
            return;
        }

        ChiPhiDTO chiPhiDTO = new ChiPhiDTO(maCP, maDoan, maLoaiCP, soTien, ghiChu);
        System.out.println(chiPhiDTO);
        System.out.println(maLoaiCPHH);
        if (chiPhiBUS.suaChiPhi(chiPhiDTO, DashBoard.chiPhiDTOs, maLoaiCPHH)) {
            suaVectorChiPhi(tbModel, rowTbl, chiPhiDTO, tenLoaiCP);
            long tongCP = Long.parseLong(tongChiPhi) - Long.parseLong(soTienHH) + Long.parseLong(soTien);
            tongChiPhi = String.valueOf(tongCP);
            doanForm.getjTextChiPhi().setText(tongChiPhi);
            JOptionPane.showMessageDialog(this, "Sửa Chi phí thành công!");
        } else {
            JOptionPane.showMessageDialog(this, "Sửa Chi phí thất bại!");
        }
        jBtnCapPhatMaChiPhi.setEnabled(true);
        jBtnThem.setEnabled(false);
        jBtnSua.setEnabled(false);
        jBtnXoa.setEnabled(false);
        jBtnHuy.setEnabled(false);
        jBtnThoat.setEnabled(true);
        jTextMaChiPhi.setText("");
        jTextSoTien.setText("");
        jTextGhiChu.setText("");
    }//GEN-LAST:event_jBtnSuaActionPerformed

    public String ktra() {
        String temp = "";
        return temp;
    }

    private void jBtnThemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnThemActionPerformed
    {//GEN-HEADEREND:event_jBtnThemActionPerformed
        String maCP = (String) jTextMaChiPhi.getText(),
                tenLoaiCP = jCbLoaiCP.getSelectedItem().toString(),
                maLoaiCP = searchMaLoai(tenLoaiCP),
                soTien = (String) jTextSoTien.getText(),
                ghiChu = (String) jTextGhiChu.getText();

        //Validation
        StringBuilder message = new StringBuilder();
        Validation.notNullOrEmpty(message, "Loại chi phí", tenLoaiCP, "Ghi chú", ghiChu);
        Validation.positiveNumbers(message, "Số tiền", soTien);
        if(!message.toString().equals("")){
            JOptionPane.showMessageDialog(this, message.toString());
            return;
        }

        System.out.println(maLoaiCP);
        System.out.println(tenLoaiCP);
        ChiPhiDTO chiPhiDTO = new ChiPhiDTO(maCP, maDoan, maLoaiCP, soTien, ghiChu);
        if (chiPhiBUS.themChiPhi(chiPhiDTO, DashBoard.chiPhiDTOs)) {
            themVectorChiPhi(tbModel, chiPhiDTO, tenLoaiCP);
            long tongCP = Long.parseLong(tongChiPhi) + Long.parseLong(soTien);
            tongChiPhi = String.valueOf(tongCP);
            doanForm.getjTextChiPhi().setText(tongChiPhi);
            JOptionPane.showMessageDialog(this, "Thêm Chi phí thành công!");
        } else {
            JOptionPane.showMessageDialog(this, "Thêm Chi phí thất bại!");
        }
        jBtnCapPhatMaChiPhi.setEnabled(true);
        jBtnThem.setEnabled(false);
        jBtnSua.setEnabled(false);
        jBtnXoa.setEnabled(false);
        jBtnHuy.setEnabled(false);
        jBtnThoat.setEnabled(true);
        jTextMaChiPhi.setText("");
        jTextSoTien.setText("");
        jTextGhiChu.setText("");
    }//GEN-LAST:event_jBtnThemActionPerformed

    private void jTableChiPhiMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jTableChiPhiMouseClicked
    {//GEN-HEADEREND:event_jTableChiPhiMouseClicked
        // TODO add your handling code here:
        if (evt.getSource() == jTableChiPhi) {
            rowTbl = jTableChiPhi.getSelectedRow();
            if (rowTbl != -1) {
                jTextMaChiPhi.setText((String) jTableChiPhi.getModel().getValueAt(rowTbl, 0));
                jCbLoaiCP.setSelectedItem(searchLoaiCP((String) jTableChiPhi.getModel().getValueAt(rowTbl, 1)));
                jTextSoTien.setText((String) jTableChiPhi.getModel().getValueAt(rowTbl, 2));
                soTienHH = (String) jTableChiPhi.getModel().getValueAt(rowTbl, 2);
                System.out.println(soTienHH);
                for (ChiPhiDTO chiPhi : DashBoard.chiPhiDTOs) {
                    if (chiPhi.getMaChiPhi().equals((String) jTableChiPhi.getModel().getValueAt(rowTbl, 0))) {
                        jTextGhiChu.setText(chiPhi.getGhiChu());
                    }
                }
                jBtnCapPhatMaChiPhi.setEnabled(false);
                jBtnThem.setEnabled(false);
                jBtnSua.setEnabled(true);
                jBtnXoa.setEnabled(true);
                jBtnHuy.setEnabled(true);
            } else {
                jBtnCapPhatMaChiPhi.setEnabled(true);
                jBtnThem.setEnabled(false);
                jBtnSua.setEnabled(false);
                jBtnXoa.setEnabled(false);
                jBtnHuy.setEnabled(false);
            }
        }
    }//GEN-LAST:event_jTableChiPhiMouseClicked

    private void jBtnTimKiemCPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnTimKiemCPActionPerformed
//        // TODO add your handling code here:
//        String manv = jTextTimKiemNV.getText();
//        if (manv.equals(""))
//        {
//            JOptionPane.showMessageDialog(this, "Má»i nháº­p mÃ£ nhÃ¢n viÃªn cáº§n tÃ¬m");
//        }
//        ArrayList<NhanVienDTO> temp = new ArrayList<NhanVienDTO>(nvBUS.getDsnv().getDsnv());
//        for (int i = 0; i < temp.size(); i++)
//        {
//            if (!(temp.get(i).getManhanvien().equalsIgnoreCase(manv)))
//            {
//                temp.remove(i);
//                i = i - 1;
//            }
//        }
//        searchlistSP(temp);
//        System.out.println("click tim kiem");
    }//GEN-LAST:event_jBtnTimKiemCPActionPerformed

    private void jBtnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRefreshActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnRefreshActionPerformed

    private void jBtnXoaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnXoaActionPerformed
    {//GEN-HEADEREND:event_jBtnXoaActionPerformed
        // TODO add your handling code here:
        String maCP = (String) jTextMaChiPhi.getText();
        ChiPhiDTO chiPhiDTO = new ChiPhiDTO();
        chiPhiDTO = searchCP(maCP);
        if (chiPhiBUS.xoaChiPhi(chiPhiDTO, DashBoard.chiPhiDTOs)) {
            xoaVectorChiPhi(tbModel, rowTbl);
            long tongCP = Long.parseLong(tongChiPhi) - Long.parseLong(soTienHH);
            tongChiPhi = String.valueOf(tongCP);
            doanForm.getjTextChiPhi().setText(tongChiPhi);
            JOptionPane.showMessageDialog(this, "Thêm Chi phí thành công!");
        } else {
            JOptionPane.showMessageDialog(this, "Thêm Chi phí thất bại!");
        }
        jBtnCapPhatMaChiPhi.setEnabled(true);
        jBtnThem.setEnabled(false);
        jBtnSua.setEnabled(false);
        jBtnXoa.setEnabled(false);
        jBtnHuy.setEnabled(false);
        jBtnThoat.setEnabled(true);
        jTextMaChiPhi.setText("");
        jTextSoTien.setText("");
        jTextGhiChu.setText("");
    }//GEN-LAST:event_jBtnXoaActionPerformed

    private void jBtnHuyActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnHuyActionPerformed
    {//GEN-HEADEREND:event_jBtnHuyActionPerformed
        // TODO add your handling code here:
        jBtnCapPhatMaChiPhi.setEnabled(true);
        jBtnThem.setEnabled(false);
        jBtnSua.setEnabled(false);
        jBtnXoa.setEnabled(false);
        jBtnHuy.setEnabled(false);
        jBtnThoat.setEnabled(true);
        jTextMaChiPhi.setText("");
        jTextSoTien.setText("");
        jTextGhiChu.setText("");
    }//GEN-LAST:event_jBtnHuyActionPerformed

    private void jBtnThoatActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnThoatActionPerformed
    {//GEN-HEADEREND:event_jBtnThoatActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtnThoatActionPerformed

    private void jBtnCapPhatMaChiPhiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCapPhatMaChiPhiActionPerformed
        // TODO add your handling code here:
        jTextMaChiPhi.setText(ult.initMaChiPhi());
        jBtnCapPhatMaChiPhi.setEnabled(false);
        jBtnThem.setEnabled(true);
        jBtnSua.setEnabled(false);
        jBtnXoa.setEnabled(false);
        jBtnHuy.setEnabled(true);
        jBtnThoat.setEnabled(true);
    }//GEN-LAST:event_jBtnCapPhatMaChiPhiActionPerformed

    public void addCombo(JComboBox cmb) {
        for (LoaiChiPhiDTO a : DashBoard.loaiChiPhiDTOs) {
            cmb.addItem(a);
        }
    }

    public LoaiChiPhiDTO searchLoaiCP(String ten) {
        for (LoaiChiPhiDTO a : DashBoard.loaiChiPhiDTOs) {
            if (a.getTenLoai().equals(ten)) {
                maLoaiCPHH = a.getMaLoaiChiPhi();
                return a;
            }
        }
        return null;
    }

    public String searchMaLoai(String ten) {
        for (LoaiChiPhiDTO a : DashBoard.loaiChiPhiDTOs) {
            if (a.getTenLoai().equals(ten)) {
                return a.getMaLoaiChiPhi();
            }
        }
        return null;
    }
    
    public ChiPhiDTO searchCP(String maCP) {
        for (ChiPhiDTO a : DashBoard.chiPhiDTOs) {
            if (a.getMaChiPhi().equals(maCP)) {
                return a;
            }
        }
        return null;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnCapPhatMaChiPhi;
    private javax.swing.JButton jBtnHuy;
    private javax.swing.JButton jBtnRefresh;
    private javax.swing.JButton jBtnSua;
    private javax.swing.JButton jBtnThem;
    private javax.swing.JButton jBtnThoat;
    private javax.swing.JButton jBtnTimKiemCP;
    private javax.swing.JButton jBtnXoa;
    private javax.swing.JComboBox<String> jCbLoaiCP;
    private javax.swing.JLabel jLbGiaTour;
    private javax.swing.JLabel jLbGiaTour1;
    private javax.swing.JLabel jLbGiaTour2;
    private javax.swing.JLabel jLbMaGia;
    private javax.swing.JLabel jLbMaGiaNow;
    private javax.swing.JLabel jLbMaTour;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTableChiPhi;
    private javax.swing.JTextArea jTextGhiChu;
    private javax.swing.JTextField jTextMaChiPhi;
    private javax.swing.JTextField jTextMaDoan;
    private javax.swing.JTextField jTextSoTien;
    private javax.swing.JTextField jTextTenDoan;
    private javax.swing.JTextField jTextTimKiemGia;
    private keeptoo.KGradientPanel kGradientPanel1;
    // End of variables declaration//GEN-END:variables
}
