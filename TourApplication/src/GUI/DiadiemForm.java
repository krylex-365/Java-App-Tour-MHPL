/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.*;
import DTO.DiaDiemDTO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Vector;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;
//import static ui.DashBoard.loadagain;

/**
 *
 * @author Hyung
 */
public class DiadiemForm extends javax.swing.JPanel {

    DefaultTableModel tbModelDiaDiem;
    private Utils ult = new Utils();
    int rowTbl;
    private int rowDiaDiem;
    private String maDiaDiem;
    private String tenDiaDiem;
    private DiaDiemBUS diaDiemBUS;

    /**
     * Creates new form jPanel2
     */
    public DiadiemForm() {
        initComponents();
        diaDiemBUS = new DiaDiemBUS();
        jBtnCapPhatMaDD.setEnabled(true);
        jBtnThemDD.setEnabled(false);
        jBtnSuaDD.setEnabled(false);
        jBtnXoaDD.setEnabled(false);
        jBtnHuy.setEnabled(false);
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
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextMaDD = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextTenDD = new javax.swing.JTextField();
        jBtnCapPhatMaDD = new javax.swing.JButton();
        jBtnThemDD = new javax.swing.JButton();
        jBtnSuaDD = new javax.swing.JButton();
        jBtnXoaDD = new javax.swing.JButton();
        jBtnHuy = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDiaDiem = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLbTimKiem = new javax.swing.JLabel();
        jTextTimKiem = new javax.swing.JTextField();
        jBtnRefresh = new javax.swing.JButton();

        setBackground(new java.awt.Color(233, 242, 249));
        setPreferredSize(new java.awt.Dimension(990, 650));

        jTabbedPane1.setBackground(new java.awt.Color(233, 242, 249));

        jPanel1.setBackground(new java.awt.Color(233, 242, 249));
        jPanel1.setPreferredSize(new java.awt.Dimension(960, 580));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("?????a ??i???m");
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(83, 86, 88)));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 190, 30));

        jPanel3.setBackground(new java.awt.Color(233, 242, 249));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Th??ng Tin ?????a ??i???m", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(0, 51, 102)));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("<html> <body> M?? ?????a ??i???m <span style=\"color:rgb(234, 21, 21)\"> *</span> </body> </html>");

        jTextMaDD.setEditable(false);//[214,217,223]
        jTextMaDD.setBackground(new java.awt.Color(214, 217, 223));
        jTextMaDD.setForeground(new java.awt.Color(51, 51, 51));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("<html> <body> T??n ?????a ??i???m <span style=\"color:rgb(234, 21, 21)\"> *</span> </body> </html>");

        jTextTenDD.setForeground(new java.awt.Color(51, 51, 51));

        jBtnCapPhatMaDD.setEnabled(true);
        jBtnCapPhatMaDD.setBackground(new java.awt.Color(81, 113, 131));
        jBtnCapPhatMaDD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_add_32.png"))); // NOI18N
        jBtnCapPhatMaDD.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnCapPhatMaDD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCapPhatMaDDActionPerformed(evt);
            }
        });

        jBtnThemDD.setBackground(new java.awt.Color(136, 193, 184));
        jBtnThemDD.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnThemDD.setText("Th??m");
        jBtnThemDD.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnThemDD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnThemDDActionPerformed(evt);
            }
        });

        jBtnSuaDD.setBackground(new java.awt.Color(136, 193, 184));
        jBtnSuaDD.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnSuaDD.setText("S???a");
        jBtnSuaDD.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnSuaDD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSuaDDActionPerformed(evt);
            }
        });

        jBtnXoaDD.setBackground(new java.awt.Color(136, 193, 184));
        jBtnXoaDD.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnXoaDD.setText("X??a");
        jBtnXoaDD.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnXoaDD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnXoaDDActionPerformed(evt);
            }
        });

        jBtnHuy.setBackground(new java.awt.Color(136, 193, 184));
        jBtnHuy.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnHuy.setText("H???y");
        jBtnHuy.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnHuyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextMaDD, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                            .addComponent(jTextTenDD))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtnCapPhatMaDD, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jBtnThemDD, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jBtnSuaDD, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jBtnXoaDD, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addComponent(jBtnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextMaDD, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jBtnCapPhatMaDD, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextTenDD, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtnThemDD, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnSuaDD, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBtnXoaDD, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBtnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 570, 220));
        jPanel3.getAccessibleContext().setAccessibleName("");

        Vector tableCol=new Vector();
        tableCol.add("M?? ?????a ??i???m");
        tableCol.add("T??n ?????a ??i???m");

        tbModelDiaDiem = new DefaultTableModel (tableCol,5){
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex){
                return false;
            }
        };
        jTableDiaDiem.setModel (tbModelDiaDiem);
        jTableDiaDiem.setShowGrid(true);
        jTableDiaDiem.setFocusable(false);
        jTableDiaDiem.setIntercellSpacing(new Dimension(0,0));
        jTableDiaDiem.setRowHeight(25);
        jTableDiaDiem.getTableHeader().setOpaque(false);
        jTableDiaDiem.setFillsViewportHeight(true);
        jTableDiaDiem.getTableHeader().setBackground(new Color(232,57,99));
        jTableDiaDiem.getTableHeader().setForeground(new Color(141, 22, 22));
        jTableDiaDiem.getTableHeader().setFont (new Font("Dialog", Font.BOLD, 13));
        jTableDiaDiem.setSelectionBackground(new Color(52,152,219));
        jTableDiaDiem.setAutoCreateRowSorter(true);
        jTableDiaDiem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTableDiaDiem.setGridColor(new java.awt.Color(83, 86, 88));
        jTableDiaDiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableDiaDiemMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableDiaDiem);
        jTableDiaDiem.setAutoResizeMode (javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 310, 590, 290));

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 102));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Danh S??ch ?????a ??i???m");
        jLabel6.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 180, 30));

        jLbTimKiem.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLbTimKiem.setText("<html><body>T??m Ki???m<span style=\"color:rgb(234, 21, 21)\"> *</span> </body></html>");
        jPanel1.add(jLbTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 270, -1, 30));

        jTextTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextTimKiemKeyReleased(evt);
            }
        });
        jPanel1.add(jTextTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 270, 140, 30));

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
        jPanel1.add(jBtnRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 270, 40, 30));

        jTabbedPane1.addTab("Qu???n L?? ?????a ??i???m", jPanel1);

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

    private void jBtnCapPhatMaDDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCapPhatMaDDActionPerformed
        // TODO add your handling code here:
        jBtnCapPhatMaDD.setEnabled(false);
        jBtnThemDD.setEnabled(true);
        jBtnSuaDD.setEnabled(false);
        jBtnXoaDD.setEnabled(false);
        jBtnHuy.setEnabled(true);
        jTextMaDD.setText(ult.initMaDiaDiem());
        jTextTenDD.setText("");
    }//GEN-LAST:event_jBtnCapPhatMaDDActionPerformed

    private void jBtnThemDDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnThemDDActionPerformed
        // TODO add your handling code here:
        maDiaDiem = jTextMaDD.getText();
        tenDiaDiem = jTextTenDD.getText();

        //Validation
        StringBuilder message = new StringBuilder();
        Validation.notNullOrEmpty(message, "T??n ?????a ??i???m", tenDiaDiem);
        if (!message.toString().equals("")) {
            JOptionPane.showMessageDialog(this, message.toString());
            return;
        }

        if (diaDiemBUS.themDiaDiem(maDiaDiem, tenDiaDiem, DashBoard.diaDiemDTOs)) {
            themDiaDiem(tbModelDiaDiem, new DiaDiemDTO(maDiaDiem, tenDiaDiem));
            JOptionPane.showMessageDialog(this, "Th??m ?????a ??i???m th??nh c??ng!");
        } else {
            JOptionPane.showMessageDialog(this, "Th??m ?????a ??i???m th???t b???i!");
        }
        jBtnCapPhatMaDD.setEnabled(true);
        jBtnThemDD.setEnabled(false);
        jBtnSuaDD.setEnabled(false);
        jBtnXoaDD.setEnabled(false);
        jBtnHuy.setEnabled(false);
        jTextMaDD.setText("");
        jTextTenDD.setText("");
        jTableDiaDiem.clearSelection();
    }//GEN-LAST:event_jBtnThemDDActionPerformed

    public void initTableDiaDiem() {
        tbModelDiaDiem.setRowCount(0);
        tableModelDiaDiem(tbModelDiaDiem);
        jTableDiaDiem.setRowSorter(null);
        jTableDiaDiem.setAutoCreateRowSorter(true);
        jTableDiaDiem.setModel(tbModelDiaDiem);
        jTableDiaDiem.clearSelection();
    }

    private void jBtnSuaDDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSuaDDActionPerformed
        // TODO add your handling code here:
        maDiaDiem = jTextMaDD.getText();
        tenDiaDiem = jTextTenDD.getText();

        //Validation
        StringBuilder message = new StringBuilder();
        Validation.notNullOrEmpty(message, "T??n ?????a ??i???m", tenDiaDiem);
        if (!message.toString().equals("")) {
            JOptionPane.showMessageDialog(this, message.toString());
            return;
        }

        if (diaDiemBUS.suaDiaDiem(maDiaDiem, tenDiaDiem, DashBoard.diaDiemDTOs)) {
            suaDiaDiem(tbModelDiaDiem, rowDiaDiem, new DiaDiemDTO(maDiaDiem, tenDiaDiem));
            JOptionPane.showMessageDialog(this, "S???a ?????a ??i???m th??nh c??ng!");
        } else {
            JOptionPane.showMessageDialog(this, "S???a ?????a ??i???m th???t b???i!");
        }
        jBtnCapPhatMaDD.setEnabled(true);
        jBtnThemDD.setEnabled(false);
        jBtnSuaDD.setEnabled(false);
        jBtnXoaDD.setEnabled(false);
        jBtnHuy.setEnabled(false);
        jTextMaDD.setText("");
        jTextTenDD.setText("");
        jTableDiaDiem.clearSelection();
    }//GEN-LAST:event_jBtnSuaDDActionPerformed

    private void jBtnXoaDDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnXoaDDActionPerformed
        // TODO add your handling code here:
        maDiaDiem = jTextMaDD.getText();
        if (!isNullOrEmpty(maDiaDiem)) {
            if (diaDiemBUS.xoaDiaDiem(maDiaDiem, DashBoard.diaDiemThamQuanDTOs, DashBoard.diaDiemDTOs)) {
                xoaDiaDiem(tbModelDiaDiem, rowDiaDiem);
                JOptionPane.showMessageDialog(this, "X??a ?????a ??i???m th??nh c??ng!");
            } else {
                JOptionPane.showMessageDialog(this, "X??a ?????a ??i???m th???t b???i!");
            }
        }
        jBtnCapPhatMaDD.setEnabled(true);
        jBtnThemDD.setEnabled(false);
        jBtnSuaDD.setEnabled(false);
        jBtnXoaDD.setEnabled(false);
        jBtnHuy.setEnabled(false);
        jTextMaDD.setText("");
        jTextTenDD.setText("");
        jTableDiaDiem.clearSelection();
    }//GEN-LAST:event_jBtnXoaDDActionPerformed

    private boolean isNullOrEmpty(String text) {
        if (text == null || text.equals("")) {
            return true;
        }
        return false;
    }

    private void jBtnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnHuyActionPerformed
        // TODO add your handling code here:
        jBtnCapPhatMaDD.setEnabled(true);
        jBtnThemDD.setEnabled(false);
        jBtnSuaDD.setEnabled(false);
        jBtnXoaDD.setEnabled(false);
        jBtnHuy.setEnabled(false);
        jTextMaDD.setText("");
        jTextTenDD.setText("");
        jTableDiaDiem.clearSelection();
    }//GEN-LAST:event_jBtnHuyActionPerformed

    private void jTableDiaDiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDiaDiemMouseClicked
        // TODO add your handling code here:
        rowDiaDiem = jTableDiaDiem.getSelectedRow();
        if (rowDiaDiem != -1) {
            maDiaDiem = (String) jTableDiaDiem.getModel().getValueAt(rowDiaDiem, 0);
            tenDiaDiem = (String) jTableDiaDiem.getModel().getValueAt(rowDiaDiem, 1);
            if (!maDiaDiem.equals("null")) {
                jTextMaDD.setText(maDiaDiem);
                jTextTenDD.setText(tenDiaDiem);
            }
        }
        jBtnCapPhatMaDD.setEnabled(false);
        jBtnThemDD.setEnabled(false);
        jBtnSuaDD.setEnabled(true);
        jBtnXoaDD.setEnabled(true);
        jBtnHuy.setEnabled(true);
    }//GEN-LAST:event_jTableDiaDiemMouseClicked

    private void jTextTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextTimKiemKeyReleased
        // TODO add your handling code here:
        String query = (String) jTextTimKiem.getText();
        filter(query);
    }//GEN-LAST:event_jTextTimKiemKeyReleased

    private void jBtnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRefreshActionPerformed
        // TODO add your handling code here:
        jTextTimKiem.setText("");
        initTableDiaDiem();
    }//GEN-LAST:event_jBtnRefreshActionPerformed

    public void tableModelDiaDiem(DefaultTableModel model) {
        for (DiaDiemDTO diaDiemDTO : DashBoard.diaDiemDTOs) {
            Vector row = new Vector();
            row.add(diaDiemDTO.getMaDiaDiem());
            row.add(diaDiemDTO.getTenDiaDiem());
            model.addRow(row);
        }
    }

    public void suaDiaDiem(DefaultTableModel model, int row, DiaDiemDTO diaDiemDTO) {
        model.setValueAt(diaDiemDTO.getMaDiaDiem(), row, 0);
        model.setValueAt(diaDiemDTO.getTenDiaDiem(), row, 1);
    }

    public void themDiaDiem(DefaultTableModel model, DiaDiemDTO diaDiemDTO) {
        Vector row = new Vector();
        row.add(diaDiemDTO.getMaDiaDiem());
        row.add(diaDiemDTO.getTenDiaDiem());
        model.addRow(row);
    }

    public void xoaDiaDiem(DefaultTableModel model, int row) {
        model.removeRow(row);
    }

    private void filter(String query) {
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(tbModelDiaDiem);
        jTableDiaDiem.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(query));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnCapPhatMaDD;
    private javax.swing.JButton jBtnHuy;
    private javax.swing.JButton jBtnRefresh;
    private javax.swing.JButton jBtnSuaDD;
    private javax.swing.JButton jBtnThemDD;
    private javax.swing.JButton jBtnXoaDD;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLbTimKiem;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableDiaDiem;
    private javax.swing.JTextField jTextMaDD;
    private javax.swing.JTextField jTextTenDD;
    private javax.swing.JTextField jTextTimKiem;
    // End of variables declaration//GEN-END:variables
}
