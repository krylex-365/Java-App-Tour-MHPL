/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

//import BUS.CongViecBUS;
import BUS.GiaTourBUS;
import BUS.Validation;
import DTO.GiaTourDTO;
import com.toedter.calendar.JTextFieldDateEditor;
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
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;

/**
 *
 * @author Hyung
 */
public class BangGia extends javax.swing.JFrame {

    /**
     * Creates new form DSNV
     */
    int rowTbl;
    public TourForm tourForm;
    public GiaTourBUS giaTourBUS;
    private boolean thuongphatAc = false;
    Vector tbCol = new Vector();
    DefaultTableModel tbModel;
    String maTour, maGiaHH;
    int hienHanh;
    GiaTourDTO giaTourHH;
    String ngayBatDau = "";

    public BangGia() {
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
    }

    public BangGia(String maTour, String maGiaHH) {
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
        this.maTour = maTour;
        this.maGiaHH = maGiaHH;
        System.out.println("maTourCon: " + this.maTour);
        System.out.println("maGiaCon: " + this.maGiaHH);
        initTable();
        jTableGiaTour.setEditingColumn(5);
        jTextMaTour.setText(this.maTour);
        jTextMaGiaHienHanh.setText(this.maGiaHH);
        jBtnCapPhatMaGia.setEnabled(true);
        jBtnThem.setEnabled(false);
        jBtnSua.setEnabled(false);
        jBtnXoa.setEnabled(false);
        jBtnHuy.setEnabled(false);
        jBtnXacNhan.setEnabled(false);
        jBtnThoat.setEnabled(true);
    }

    public void initTable() {
        giaTourBUS = new GiaTourBUS();
        tbModel.setRowCount(0);
        tableModel(tbModel);
        jTableGiaTour.setRowSorter(null);
        jTableGiaTour.setAutoCreateRowSorter(true);
        jTableGiaTour.setModel(tbModel);
        jTableGiaTour.clearSelection();
    }

    public void tableModel(DefaultTableModel model) {
        for (GiaTourDTO giaTour : DashBoard.giaTourDTOs) {
            if (giaTour.getMaTour().equals(this.maTour)) {
                Vector row = new Vector();
                row.add(giaTour.getMaGia());
                row.add(giaTour.getThanhTien());
                row.add(giaTour.getTgBatDau());
                row.add(giaTour.getTgKetThuc());
                if (giaTour.getHienHanh() == 1) {
                    row.add("X");
                    giaTourHH = new GiaTourDTO(giaTour.getMaGia(),
                            giaTour.getMaTour(),
                            giaTour.getThanhTien(),
                            giaTour.getTgBatDau(),
                            giaTour.getTgKetThuc(),
                            giaTour.getHienHanh());
                } else {
                    row.add("");
                }
                model.addRow(row);
            }
        }
    }
    
    private void filter(String query) {
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(tbModel);
        jTableGiaTour.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(query));
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
        jTextMaGia = new javax.swing.JTextField();
        jLbGiaTour = new javax.swing.JLabel();
        jTextGiaTour = new javax.swing.JTextField();
        jLbNgayBD = new javax.swing.JLabel();
        jLbNgayKT = new javax.swing.JLabel();
        jBtnSua = new javax.swing.JButton();
        jBtnThem = new javax.swing.JButton();
        jDateKetThuc = new com.toedter.calendar.JDateChooser();
        jDateBatDau = new com.toedter.calendar.JDateChooser();
        jBtnXoa = new javax.swing.JButton();
        jBtnHuy = new javax.swing.JButton();
        jBtnXacNhan = new javax.swing.JButton();
        jBtnThoat = new javax.swing.JButton();
        jLbMaTour = new javax.swing.JLabel();
        jTextMaTour = new javax.swing.JTextField();
        jLbMaGiaNow = new javax.swing.JLabel();
        jTextMaGiaHienHanh = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jBtnCapPhatMaGia = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableGiaTour = new javax.swing.JTable();
        jLbTimKiem = new javax.swing.JLabel();
        jTextTimKiem = new javax.swing.JTextField();
        jBtnRefresh = new javax.swing.JButton();

        setBackground(new java.awt.Color(236, 245, 252));
        setMinimumSize(new java.awt.Dimension(1000, 500));
        setSize(new java.awt.Dimension(1000, 500));
        setType(java.awt.Window.Type.POPUP);

        kGradientPanel1.setkEndColor(new java.awt.Color(236, 245, 252));
        kGradientPanel1.setkStartColor(new java.awt.Color(236, 245, 252));
        kGradientPanel1.setPreferredSize(new java.awt.Dimension(1000, 500));

        jPanel4.setBackground(new java.awt.Color(236, 245, 252));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chi Ti???t Gi?? Tour", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(0, 51, 102)));
        jPanel4.setPreferredSize(new java.awt.Dimension(1000, 550));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLbMaGia.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLbMaGia.setText("<html><body>M?? Gi?? <span style=\"color:rgb(234, 21, 21)\"> *</span> </body> </html>");
        jPanel4.add(jLbMaGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 110, 30));

        jTextMaGia.setEditable(false);
        jTextMaGia.setBackground(new java.awt.Color(214, 217, 223));
        jTextMaGia.setForeground(new java.awt.Color(51, 51, 51));
        jTextMaGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextMaGiaActionPerformed(evt);
            }
        });
        jPanel4.add(jTextMaGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 160, 30));

        jLbGiaTour.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLbGiaTour.setText("<html> <body>Gi?? Tour <span style=\"color:rgb(234, 21, 21)\"> *</span> </body> </html>");
        jPanel4.add(jLbGiaTour, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, 30));

        jTextGiaTour.setForeground(new java.awt.Color(51, 51, 51));
        jPanel4.add(jTextGiaTour, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 200, 30));

        jLbNgayBD.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLbNgayBD.setText("<html><body>Ng??y B???t ?????u<span style=\"color:rgb(234, 21, 21)\"> *</span> </body> </html>");
        jPanel4.add(jLbNgayBD, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, 30));

        jLbNgayKT.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLbNgayKT.setText("<html><body>Ng??y K???t Th??c<span style=\"color:rgb(234, 21, 21)\"> *</span> </body> </html>");
        jLbNgayKT.setVerifyInputWhenFocusTarget(false);
        jPanel4.add(jLbNgayKT, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, 30));

        jBtnSua.setBackground(new java.awt.Color(136, 193, 184));
        jBtnSua.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnSua.setText("S???a");
        jBtnSua.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSuaActionPerformed(evt);
            }
        });
        jPanel4.add(jBtnSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 310, 100, 40));

        jBtnThem.setBackground(new java.awt.Color(136, 193, 184));
        jBtnThem.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnThem.setText("Th??m");
        jBtnThem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnThemActionPerformed(evt);
            }
        });
        jPanel4.add(jBtnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, 100, 40));

        jDateKetThuc.setBackground(new java.awt.Color(214, 217, 223));
        jDateKetThuc.setDateFormatString("yyyy-MM-dd");
        JTextFieldDateEditor editorKT = (JTextFieldDateEditor) jDateKetThuc.getDateEditor();
        editorKT.setEditable(false);
        jPanel4.add(jDateKetThuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, 200, 30));

        jDateBatDau.setBackground(new java.awt.Color(214, 217, 223));
        jDateBatDau.setDateFormatString("yyyy-MM-dd");
        JTextFieldDateEditor editorBD = (JTextFieldDateEditor) jDateBatDau.getDateEditor();
        editorBD.setEditable(false);
        jPanel4.add(jDateBatDau, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 200, 30));

        jBtnXoa.setBackground(new java.awt.Color(136, 193, 184));
        jBtnXoa.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnXoa.setText("X??a");
        jBtnXoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnXoaActionPerformed(evt);
            }
        });
        jPanel4.add(jBtnXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, 100, 40));

        jBtnHuy.setBackground(new java.awt.Color(136, 193, 184));
        jBtnHuy.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnHuy.setText("H???y");
        jBtnHuy.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnHuyActionPerformed(evt);
            }
        });
        jPanel4.add(jBtnHuy, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 360, 100, 40));

        jBtnXacNhan.setBackground(new java.awt.Color(136, 193, 184));
        jBtnXacNhan.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnXacNhan.setText("X??c Nh???n");
        jBtnXacNhan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnXacNhanActionPerformed(evt);
            }
        });
        jPanel4.add(jBtnXacNhan, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 410, 100, 40));

        jBtnThoat.setBackground(new java.awt.Color(136, 193, 184));
        jBtnThoat.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnThoat.setText("Tho??t");
        jBtnThoat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnThoatActionPerformed(evt);
            }
        });
        jPanel4.add(jBtnThoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 410, 100, 40));

        jLbMaTour.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLbMaTour.setText("<html> <body> M?? Tour</body> </html>");
        jPanel4.add(jLbMaTour, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, 30));

        jTextMaTour.setEditable(false);
        jTextMaTour.setBackground(new java.awt.Color(214, 217, 223));
        jTextMaTour.setForeground(new java.awt.Color(51, 51, 51));
        jTextMaTour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextMaTourActionPerformed(evt);
            }
        });
        jPanel4.add(jTextMaTour, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 200, 30));

        jLbMaGiaNow.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLbMaGiaNow.setText("<html><body>M?? Gi?? Hi???n H??nh</body> </html>");
        jPanel4.add(jLbMaGiaNow, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 110, 50));

        jTextMaGiaHienHanh.setEditable(false);
        jTextMaGiaHienHanh.setBackground(new java.awt.Color(214, 217, 223));
        jTextMaGiaHienHanh.setForeground(new java.awt.Color(51, 51, 51));
        jTextMaGiaHienHanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextMaGiaHienHanhActionPerformed(evt);
            }
        });
        jPanel4.add(jTextMaGiaHienHanh, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 200, 30));
        jPanel4.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 320, 10));

        jBtnCapPhatMaGia.setBackground(new java.awt.Color(81, 113, 131));
        jBtnCapPhatMaGia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_add_32.png"))); // NOI18N
        jBtnCapPhatMaGia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnCapPhatMaGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCapPhatMaGiaActionPerformed(evt);
            }
        });
        jPanel4.add(jBtnCapPhatMaGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 30, 30));

        jTableGiaTour.setAutoCreateRowSorter(true);
        jTableGiaTour.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTableGiaTour.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbCol.add("M?? Gi??");
        tbCol.add("Gi?? Tour");
        tbCol.add("Ng??y B???t ?????u");
        tbCol.add("Ng??y K???t Th??c");
        tbCol.add("Hi???n H??nh");
        tbModel= new DefaultTableModel(tbCol,5){
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex){
                return false;
            }
        };
        jTableGiaTour.setModel (tbModel);
        jTableGiaTour.setShowGrid(true);
        jTableGiaTour.setFocusable(false);
        jTableGiaTour.setIntercellSpacing(new Dimension(0,0));
        jTableGiaTour.setRowHeight(25);
        jTableGiaTour.getTableHeader().setOpaque(false);
        jTableGiaTour.setFillsViewportHeight(true);
        jTableGiaTour.getTableHeader().setBackground(new Color(232,57,99));
        jTableGiaTour.getTableHeader().setForeground(new Color(141, 22, 22));
        jTableGiaTour.getTableHeader().setFont (new Font("Dialog", Font.BOLD, 13));
        jTableGiaTour.setSelectionBackground(new Color(52,152,219));
        //listSP();
        jTableGiaTour.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableGiaTourMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableGiaTour);

        jLbTimKiem.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLbTimKiem.setText("<html><body>T??m Ki???m<span style=\"color:rgb(234, 21, 21)\"> *</span> </body></html>");

        jTextTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextTimKiemKeyReleased(evt);
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLbTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jTextTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jBtnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLbTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
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
        String maGia = (String) jTextMaGia.getText(),
                giaTour = (String) jTextGiaTour.getText(),
                ngayBD = (String) ((JTextField) jDateBatDau.getDateEditor().getUiComponent()).getText(),
                ngayKT = (String) ((JTextField) jDateKetThuc.getDateEditor().getUiComponent()).getText();

        //Validation
        StringBuilder message = new StringBuilder();
        Validation.positiveNumbers(message, "Gi?? tour", giaTour);
        boolean isDate = Validation.isDate(message, "Ng??y b???t ?????u", ngayBD, "Ng??y k???t th??c", ngayKT);
        if (isDate) {
            Validation.afterOrEquals(message, "Ng??y b???t ?????u", ngayBD, "Ng??y b???t ?????u tr?????c", ngayBatDau);
            Validation.afterOrEquals(message, "Ng??y k???t th??c", ngayKT, "Ng??y b???t ?????u", ngayBD);
        }
        if (!message.toString().equals("")) {
            JOptionPane.showMessageDialog(this, message.toString());
            return;
        }

        if (giaTourBUS.suaGiaTour(tourForm.getMaTour(), maGia, giaTour, ngayBD, ngayKT, hienHanh, DashBoard.giaTourDTOs)) {
            if (maGia.equals(maGiaHH)) {
                tourForm.getjTextGiaTour().setText(giaTour);
                tourForm.getjDateNgayBD().setCalendar(jDateBatDau.getCalendar());
                tourForm.getjDateNgayKT().setCalendar(jDateKetThuc.getCalendar());
                tourForm.getTbModelTour().setValueAt(giaTour, tourForm.getRowTour(), 3);
                tourForm.getTbModelTour().setValueAt(ngayBD, tourForm.getRowTour(), 4);
                tourForm.getTbModelTour().setValueAt(ngayKT, tourForm.getRowTour(), 5);
            }
            if (maGia.equals(tourForm.getMaGia())) {
                tourForm.getjTextGiaTour().setText(giaTour);
                tourForm.getjDateNgayBD().setCalendar(jDateBatDau.getCalendar());
                tourForm.getjDateNgayKT().setCalendar(jDateKetThuc.getCalendar());
            }
            initTable();
            JOptionPane.showMessageDialog(this, "S???a Gi?? Tour th??nh c??ng!");
        } else {
            JOptionPane.showMessageDialog(this, "S???a Gi?? Tour th???t b???i!");
        }
        jTextMaGia.setText("");
        jTextGiaTour.setText("");
        jDateBatDau.setCalendar(null);
        jDateKetThuc.setCalendar(null);
        jBtnCapPhatMaGia.setEnabled(true);
        jBtnThem.setEnabled(false);
        jBtnSua.setEnabled(false);
        jBtnXoa.setEnabled(false);
        jBtnHuy.setEnabled(false);
        jBtnXacNhan.setEnabled(false);
        jBtnThoat.setEnabled(true);
        jTableGiaTour.clearSelection();
    }//GEN-LAST:event_jBtnSuaActionPerformed

    private void jTextMaGiaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jTextMaGiaActionPerformed
    {//GEN-HEADEREND:event_jTextMaGiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextMaGiaActionPerformed

    private void jTextMaTourActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jTextMaTourActionPerformed
    {//GEN-HEADEREND:event_jTextMaTourActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextMaTourActionPerformed
    public String ktra() {
        String temp = "";
        if (jTextMaTour.getText().equals("")) {
            temp += "- Vui l??ng ch???n gi?? tour!";
        }
        return temp;
    }
    private void jBtnThemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnThemActionPerformed
    {//GEN-HEADEREND:event_jBtnThemActionPerformed
        String maGia = (String) jTextMaGia.getText(),
                maTour = (String) jTextMaTour.getText(),
                giaTour = (String) jTextGiaTour.getText(),
                ngayBD = (String) ((JTextField) jDateBatDau.getDateEditor().getUiComponent()).getText(),
                ngayKT = (String) ((JTextField) jDateKetThuc.getDateEditor().getUiComponent()).getText();

        //Validation
        StringBuilder message = new StringBuilder();
        Validation.positiveNumbers(message, "Gi?? tour", giaTour);
        boolean isDate = Validation.isDate(message, "Ng??y b???t ?????u", ngayBD, "Ng??y k???t th??c", ngayKT);
        if (isDate) {
            Validation.afterOrEquals(message, "Ng??y b???t ?????u", ngayBD, "Ng??y hi???n t???i",
                    new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            Validation.afterOrEquals(message, "Ng??y k???t th??c", ngayKT, "Ng??y b???t ?????u", ngayBD);
        }
        if (!message.toString().equals("")) {
            JOptionPane.showMessageDialog(this, message.toString());
            return;
        }

        if (giaTourBUS.themGiaTour(maGia, maTour, giaTour, ngayBD, ngayKT, DashBoard.giaTourDTOs)) {
            initTable();
            JOptionPane.showMessageDialog(this, "Th??m Gi?? Tour th??nh c??ng!");
        } else {
            JOptionPane.showMessageDialog(this, "Th??m Gi?? Tour th???t b???i!");
        }
        jTextMaGia.setText("");
        jTextGiaTour.setText("");
        jDateBatDau.setCalendar(null);
        jDateKetThuc.setCalendar(null);
        jBtnCapPhatMaGia.setEnabled(true);
        jBtnThem.setEnabled(false);
        jBtnSua.setEnabled(false);
        jBtnXoa.setEnabled(false);
        jBtnHuy.setEnabled(false);
        jBtnXacNhan.setEnabled(false);
        jBtnThoat.setEnabled(true);
        jTableGiaTour.clearSelection();
    }//GEN-LAST:event_jBtnThemActionPerformed

    private void jTableGiaTourMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jTableGiaTourMouseClicked
    {//GEN-HEADEREND:event_jTableGiaTourMouseClicked
        // TODO add your handling code here:
        if (evt.getSource() == jTableGiaTour) {
            rowTbl = jTableGiaTour.getSelectedRow();
            if (rowTbl != -1) {
                jTextMaGia.setText((String) jTableGiaTour.getValueAt(rowTbl, 0));
                jTextGiaTour.setText((String) jTableGiaTour.getValueAt(rowTbl, 1));
                try {
                    ngayBatDau = jTableGiaTour.getModel().getValueAt(rowTbl, 2).toString();
                    Date dateBD = new SimpleDateFormat("yyyy-MM-dd").parse(ngayBatDau);
                    jDateBatDau.setDate(dateBD);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(BangGia.this, e);
                    System.out.println("- Load sai ng??y b???t ?????u!");
                }
                try {
                    Date dateBD = new SimpleDateFormat("yyyy-MM-dd").parse(jTableGiaTour.getModel().getValueAt(rowTbl, 3).toString());
                    jDateKetThuc.setDate(dateBD);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(BangGia.this, e);
                    System.out.println("- Load sai ng??y k???t th??c!");
                }
                if (jTableGiaTour.getValueAt(rowTbl, 4).equals("X")) {
                    System.out.println("Hi???n h??nh");
                    hienHanh = 1;
                    jBtnXoa.setEnabled(false);
                    jBtnXacNhan.setEnabled(false);
                } else {
                    hienHanh = 0;
                    jBtnXoa.setEnabled(true);
                    jBtnXacNhan.setEnabled(true);
                }
                jBtnCapPhatMaGia.setEnabled(false);
                jBtnThem.setEnabled(false);
                jBtnSua.setEnabled(true);
                jBtnHuy.setEnabled(true);
                jBtnThoat.setEnabled(true);
            }
        }
    }//GEN-LAST:event_jTableGiaTourMouseClicked

    private void jBtnXoaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnXoaActionPerformed
    {//GEN-HEADEREND:event_jBtnXoaActionPerformed
        // TODO add your handling code here:
        String maGia = (String) jTextMaGia.getText(),
                giaTour = (String) jTextGiaTour.getText(),
                ngayBD = (String) ((JTextField) jDateBatDau.getDateEditor().getUiComponent()).getText(),
                ngayKT = (String) ((JTextField) jDateKetThuc.getDateEditor().getUiComponent()).getText();
        if (giaTourBUS.xoaGiaTour(tourForm.getMaTour(), maGia, giaTour, ngayBD, ngayKT, hienHanh, DashBoard.giaTourDTOs)) {
            if (maGia.equals(tourForm.getMaGia())) {
                tourForm.getjTextGiaTour().setText(giaTourHH.getThanhTien());
                try {
                    Date dateBD = new SimpleDateFormat("yyyy-MM-dd").parse(giaTourHH.getTgBatDau());
                    tourForm.getjDateNgayBD().setDate(dateBD);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(BangGia.this, e);
                }
                try {
                    Date dateKT = new SimpleDateFormat("yyyy-MM-dd").parse(giaTourHH.getTgKetThuc());
                    tourForm.getjDateNgayKT().setDate(dateKT);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(BangGia.this, e);
                }
            }
            initTable();
            JOptionPane.showMessageDialog(this, "X??a Gi?? Tour th??nh c??ng!");
        } else {
            JOptionPane.showMessageDialog(this, "X??a Gi?? Tour th???t b???i!");
        }
        jTextMaGia.setText("");
        jTextGiaTour.setText("");
        jDateBatDau.setCalendar(null);
        jDateKetThuc.setCalendar(null);
        jBtnCapPhatMaGia.setEnabled(true);
        jBtnThem.setEnabled(false);
        jBtnSua.setEnabled(false);
        jBtnXoa.setEnabled(false);
        jBtnHuy.setEnabled(false);
        jBtnXacNhan.setEnabled(false);
        jBtnThoat.setEnabled(true);
        jTableGiaTour.clearSelection();
    }//GEN-LAST:event_jBtnXoaActionPerformed

    private void jBtnHuyActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnHuyActionPerformed
    {//GEN-HEADEREND:event_jBtnHuyActionPerformed
        // TODO add your handling code here:
        jTextMaGia.setText("");
        jTextGiaTour.setText("");
        jDateBatDau.setCalendar(null);
        jDateKetThuc.setCalendar(null);
        jBtnCapPhatMaGia.setEnabled(true);
        jBtnThem.setEnabled(false);
        jBtnSua.setEnabled(false);
        jBtnXoa.setEnabled(false);
        jBtnHuy.setEnabled(false);
        jBtnXacNhan.setEnabled(false);
        jBtnThoat.setEnabled(true);
        jTableGiaTour.clearSelection();
    }//GEN-LAST:event_jBtnHuyActionPerformed

    private void jBtnXacNhanActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnXacNhanActionPerformed
    {//GEN-HEADEREND:event_jBtnXacNhanActionPerformed
        // TODO add your handling code here:
        tourForm.setMaGia(jTextMaGia.getText());
        tourForm.getjTextGiaTour().setText((String) jTextGiaTour.getText());
        tourForm.getjDateNgayBD().setCalendar(jDateBatDau.getCalendar());
        tourForm.getjDateNgayKT().setCalendar(jDateKetThuc.getCalendar());
        dispose();
    }//GEN-LAST:event_jBtnXacNhanActionPerformed

    private void jBtnThoatActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnThoatActionPerformed
    {//GEN-HEADEREND:event_jBtnThoatActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtnThoatActionPerformed

    private void jTextMaGiaHienHanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextMaGiaHienHanhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextMaGiaHienHanhActionPerformed

    private void jBtnCapPhatMaGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCapPhatMaGiaActionPerformed
        // TODO add your handling code here:
        String init = null;
        init = giaTourBUS.CapPhat(init);
        jTextMaGia.setText(init);
        jBtnCapPhatMaGia.setEnabled(false);
        jBtnThem.setEnabled(true);
        jBtnSua.setEnabled(false);
        jBtnXoa.setEnabled(false);
        jBtnHuy.setEnabled(true);
        jBtnXacNhan.setEnabled(false);
        jBtnThoat.setEnabled(true);
        jTableGiaTour.clearSelection();
    }//GEN-LAST:event_jBtnCapPhatMaGiaActionPerformed

    private void jTextTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextTimKiemKeyReleased
        // TODO add your handling code here:
        String query = (String) jTextTimKiem.getText();
        filter(query);
    }//GEN-LAST:event_jTextTimKiemKeyReleased

    private void jBtnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRefreshActionPerformed
        // TODO add your handling code here:
        jTextTimKiem.setText("");
        initTable();
    }//GEN-LAST:event_jBtnRefreshActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BangGia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BangGia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BangGia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BangGia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BangGia().setVisible(true);
            }
        });
    }

    public JButton getjBtnQuayLai() {
        return jBtnSua;
    }

    public void setjBtnQuayLai(JButton jBtnQuayLai) {
        this.jBtnSua = jBtnQuayLai;
    }

    public JButton getjBtnXacNhan() {
        return jBtnThem;
    }

    public void setjBtnXacNhan(JButton jBtnXacNhan) {
        this.jBtnThem = jBtnXacNhan;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnCapPhatMaGia;
    private javax.swing.JButton jBtnHuy;
    private javax.swing.JButton jBtnRefresh;
    private javax.swing.JButton jBtnSua;
    private javax.swing.JButton jBtnThem;
    private javax.swing.JButton jBtnThoat;
    private javax.swing.JButton jBtnXacNhan;
    private javax.swing.JButton jBtnXoa;
    private com.toedter.calendar.JDateChooser jDateBatDau;
    private com.toedter.calendar.JDateChooser jDateKetThuc;
    private javax.swing.JLabel jLbGiaTour;
    private javax.swing.JLabel jLbMaGia;
    private javax.swing.JLabel jLbMaGiaNow;
    private javax.swing.JLabel jLbMaTour;
    private javax.swing.JLabel jLbNgayBD;
    private javax.swing.JLabel jLbNgayKT;
    private javax.swing.JLabel jLbTimKiem;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTableGiaTour;
    private javax.swing.JTextField jTextGiaTour;
    private javax.swing.JTextField jTextMaGia;
    private javax.swing.JTextField jTextMaGiaHienHanh;
    private javax.swing.JTextField jTextMaTour;
    private javax.swing.JTextField jTextTimKiem;
    private keeptoo.KGradientPanel kGradientPanel1;
    // End of variables declaration//GEN-END:variables
}
