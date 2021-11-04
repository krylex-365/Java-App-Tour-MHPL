/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

//import BUS.CongViecBUS;
import BUS.LoaiHinhTourBUS;
import DTO.LoaiHinhTourDTO;
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
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Hyung
 */
public class BangNhanVien extends javax.swing.JFrame {

    /**
     * Creates new form DSNV
     */
    int rowTbl;
    public DoanForm doanForm;
    public LoaiHinhTourBUS loaiHinhTourBUS;
    Vector tbCol = new Vector();
    DefaultTableModel tbModel;

    public BangNhanVien() {
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
        jBtnXacNhan.setEnabled(false);
        jBtnQuayLai.setEnabled(true);
        initTable();
    }

    public void reloadData() {
        loaiHinhTourBUS = new LoaiHinhTourBUS();
    }

    public void initTable() {
        reloadData();
        tbModel.setRowCount(0);
        tableModel(tbModel);
        jTableKhach.setModel(tbModel);
        jBtnXacNhan.setEnabled(false);
        jBtnQuayLai.setEnabled(true);
    }

    public void tableModel(DefaultTableModel model) {
        for (LoaiHinhTourDTO loaiHinh : loaiHinhTourBUS.getLoaiHinhTourDTOs()) {
            Vector row = new Vector();
            row.add(loaiHinh.getMaLoai());
            row.add(loaiHinh.getTenLoai());
            model.addRow(row);
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

        kGradientPanel1 = new keeptoo.KGradientPanel();
        jPanel4 = new javax.swing.JPanel();
        jLbManv = new javax.swing.JLabel();
        jTextMaNV = new javax.swing.JTextField();
        jLbHonv = new javax.swing.JLabel();
        jTextTenNV = new javax.swing.JTextField();
        jBtnQuayLai = new javax.swing.JButton();
        jBtnXacNhan = new javax.swing.JButton();
        jLbHonv1 = new javax.swing.JLabel();
        jTextSDTNV = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableKhach = new javax.swing.JTable();
        jTextTimKiemNV = new javax.swing.JTextField();
        jBtnTimKiemNV = new javax.swing.JButton();
        jBtnRefresh = new javax.swing.JButton();

        setBackground(new java.awt.Color(236, 245, 252));
        setMinimumSize(new java.awt.Dimension(1000, 500));
        setSize(new java.awt.Dimension(1000, 500));
        setType(java.awt.Window.Type.POPUP);

        kGradientPanel1.setkEndColor(new java.awt.Color(236, 245, 252));
        kGradientPanel1.setkStartColor(new java.awt.Color(236, 245, 252));
        kGradientPanel1.setPreferredSize(new java.awt.Dimension(1000, 500));

        jPanel4.setBackground(new java.awt.Color(236, 245, 252));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chi Tiết Nhân Viên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(0, 51, 102)));
        jPanel4.setPreferredSize(new java.awt.Dimension(1000, 550));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLbManv.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLbManv.setText("<html> <body> Mã Nhân Viên<span style=\"color:rgb(234, 21, 21)\"> *</span> </body> </html>");
        jPanel4.add(jLbManv, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, 30));

        jTextMaNV.setEditable(false);
        jTextMaNV.setForeground(new java.awt.Color(51, 51, 51));
        jTextMaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextMaNVActionPerformed(evt);
            }
        });
        jPanel4.add(jTextMaNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 32, 204, 30));

        jLbHonv.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLbHonv.setText("<html><body>Tên Nhân Viên<span style=\"color:rgb(234, 21, 21)\"> *</span> </body> </html>");
        jPanel4.add(jLbHonv, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 110, 30));

        jTextTenNV.setEditable(false);
        jTextTenNV.setForeground(new java.awt.Color(51, 51, 51));
        jTextTenNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextTenNVActionPerformed(evt);
            }
        });
        jPanel4.add(jTextTenNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 204, 30));

        jBtnQuayLai.setBackground(new java.awt.Color(136, 193, 184));
        jBtnQuayLai.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnQuayLai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_back1_16.png"))); // NOI18N
        jBtnQuayLai.setText("Thoát");
        jBtnQuayLai.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnQuayLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnQuayLaiActionPerformed(evt);
            }
        });
        jPanel4.add(jBtnQuayLai, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 140, 40));

        jBtnXacNhan.setBackground(new java.awt.Color(136, 193, 184));
        jBtnXacNhan.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnXacNhan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_ok_16.png"))); // NOI18N
        jBtnXacNhan.setText("Xác nhận");
        jBtnXacNhan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnXacNhanActionPerformed(evt);
            }
        });
        jPanel4.add(jBtnXacNhan, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 140, 40));

        jLbHonv1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLbHonv1.setText("<html><body>SÐT<span style=\"color:rgb(234, 21, 21)\"> *</span> </body> </html>");
        jPanel4.add(jLbHonv1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 60, 30));

        jTextSDTNV.setEditable(false);
        jTextSDTNV.setForeground(new java.awt.Color(51, 51, 51));
        jTextSDTNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextSDTNVActionPerformed(evt);
            }
        });
        jPanel4.add(jTextSDTNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 204, 30));

        jTableKhach.setAutoCreateRowSorter(true);
        jTableKhach.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTableKhach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbCol.add("Mă Nhân Viên");
        tbCol.add("Tên Nhân Viên");
        tbCol.add("SÐT");
        tbModel= new DefaultTableModel(tbCol,5);
        jTableKhach.setModel (tbModel);
        jTableKhach.setShowGrid(true);
        jTableKhach.setFocusable(false);
        jTableKhach.setIntercellSpacing(new Dimension(0,0));
        jTableKhach.setRowHeight(25);
        jTableKhach.getTableHeader().setOpaque(false);
        jTableKhach.setFillsViewportHeight(true);
        jTableKhach.getTableHeader().setBackground(new Color(232,57,99));
        jTableKhach.getTableHeader().setForeground(new Color(141, 22, 22));
        jTableKhach.getTableHeader().setFont (new Font("Dialog", Font.BOLD, 13));
        jTableKhach.setSelectionBackground(new Color(52,152,219));
        jTableKhach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableKhachMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableKhach);

        jBtnTimKiemNV.setText("Tìm kiếm");
        jBtnTimKiemNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnTimKiemNVActionPerformed(evt);
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
                        .addGap(8, 8, 8))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(jTextTimKiemNV, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtnTimKiemNV, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextTimKiemNV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnTimKiemNV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.getAccessibleContext().setAccessibleName("");

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

    private void jBtnQuayLaiActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnQuayLaiActionPerformed
    {//GEN-HEADEREND:event_jBtnQuayLaiActionPerformed
        jTextMaNV.setText("");
        jTextTenNV.setText("");
        dispose();
//        jTextTennv.setText("");
//        jTextPban.setText("");
//        jTextCviec.setText("");
    }//GEN-LAST:event_jBtnQuayLaiActionPerformed

    private void jTextTenNVActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jTextTenNVActionPerformed
    {//GEN-HEADEREND:event_jTextTenNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextTenNVActionPerformed

    private void jTextMaNVActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jTextMaNVActionPerformed
    {//GEN-HEADEREND:event_jTextMaNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextMaNVActionPerformed
    public String ktra() {
        String temp = "";
        if (jTextMaNV.getText().equals("")) {
            temp += "- Vui lòng chọn loại hình!";
        }
        return temp;
    }
    private void jBtnXacNhanActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnXacNhanActionPerformed
    {//GEN-HEADEREND:event_jBtnXacNhanActionPerformed
//        if (!jBtnXacNhan.isEnabled()) {
//            System.out.println("Disabled");
//        } else {
//            if (ktra().equals("")) {
//                String maLoai = jTextMaLH.getText(), tenLoai = jTextTenLH.getText();
//                if (tourForm != null) {
//                    tourForm.getjTextLoaiHinh().setText(tenLoai);
//                    tourForm.setMaLoai(maLoai);
//                }
//                dispose();
//            } else {
//                JOptionPane.showMessageDialog(null, ktra());
//            }
//        }
    }//GEN-LAST:event_jBtnXacNhanActionPerformed

    private void jTableKhachMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jTableKhachMouseClicked
    {//GEN-HEADEREND:event_jTableKhachMouseClicked
        // TODO add your handling code here:
        if (evt.getSource() == jTableKhach) {
            rowTbl = jTableKhach.getSelectedRow();
            if (rowTbl != -1) {
                jTextMaNV.setText((String) jTableKhach.getValueAt(rowTbl, 0));
                jTextTenNV.setText((String) jTableKhach.getValueAt(rowTbl, 1));
                jBtnXacNhan.setEnabled(true);
                jBtnQuayLai.setEnabled(true);
            }
        }
    }//GEN-LAST:event_jTableKhachMouseClicked

    private void jBtnTimKiemNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnTimKiemNVActionPerformed
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
    }//GEN-LAST:event_jBtnTimKiemNVActionPerformed

    private void jBtnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRefreshActionPerformed
        // TODO add your handling code here:
        jTextTimKiemNV.setText("");
        initTable();
        jBtnXacNhan.setEnabled(false);
        jBtnRefresh.setEnabled(true);
        jBtnQuayLai.setEnabled(false);
    }//GEN-LAST:event_jBtnRefreshActionPerformed

    private void jTextSDTNVActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jTextSDTNVActionPerformed
    {//GEN-HEADEREND:event_jTextSDTNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextSDTNVActionPerformed

//    public void searchlistSP(ArrayList<NhanVienDTO> nv)
//    {
//        tbModel.setRowCount(0);
//        outModel(tbModel, nv);
//    }
//    public String getTextFieldContent()
//    {
//        return bccForm.getjTextManv().getText();
//    }
//    public String getTextFieldContentLuong()
//    {
//        return luongForm.getjTextManv().getText();
//    }
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
            java.util.logging.Logger.getLogger(BangNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BangNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BangNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BangNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new BangNhanVien().setVisible(true);
            }
        });
    }

    public JButton getjBtnQuayLai() {
        return jBtnQuayLai;
    }

    public void setjBtnQuayLai(JButton jBtnQuayLai) {
        this.jBtnQuayLai = jBtnQuayLai;
    }

    public JButton getjBtnRefresh() {
        return jBtnRefresh;
    }

    public void setjBtnRefresh(JButton jBtnRefresh) {
        this.jBtnRefresh = jBtnRefresh;
    }

    public JButton getjBtnTimKiemNV() {
        return jBtnTimKiemNV;
    }

    public void setjBtnTimKiemNV(JButton jBtnTimKiemNV) {
        this.jBtnTimKiemNV = jBtnTimKiemNV;
    }

    public JButton getjBtnXacNhan() {
        return jBtnXacNhan;
    }

    public void setjBtnXacNhan(JButton jBtnXacNhan) {
        this.jBtnXacNhan = jBtnXacNhan;
    }

    public JTable getjTableDsnv() {
        return jTableKhach;
    }

    public void setjTableDsnv(JTable jTableDsnv) {
        this.jTableKhach = jTableDsnv;
    }

    public JTextField getjTextTimKiemNV() {
        return jTextTimKiemNV;
    }

    public void setjTextTimKiemNV(JTextField jTextTimKiemNV) {
        this.jTextTimKiemNV = jTextTimKiemNV;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnQuayLai;
    private javax.swing.JButton jBtnRefresh;
    private javax.swing.JButton jBtnTimKiemNV;
    private javax.swing.JButton jBtnXacNhan;
    private javax.swing.JLabel jLbHonv;
    private javax.swing.JLabel jLbHonv1;
    private javax.swing.JLabel jLbManv;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableKhach;
    private javax.swing.JTextField jTextMaNV;
    private javax.swing.JTextField jTextSDTNV;
    private javax.swing.JTextField jTextTenNV;
    private javax.swing.JTextField jTextTimKiemNV;
    private keeptoo.KGradientPanel kGradientPanel1;
    // End of variables declaration//GEN-END:variables
}
