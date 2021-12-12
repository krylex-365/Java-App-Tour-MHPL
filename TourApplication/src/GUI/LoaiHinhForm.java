/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.*;
import DTO.LoaiHinhTourDTO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Vector;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Hyung
 */
public class LoaiHinhForm extends javax.swing.JPanel {

    /**
     * Creates new form jPanel2
     */
    static int flagtkmk = 0;
    //ChiTietTour chiTietTour;
    LoaiHinhTourBUS loaiHinhTourBUS;
    int rowLoaiHinh;
    private String maLoai, maLH;
    Vector tbColLoaiHinh = new Vector();
    DefaultTableModel tbModelLoaiHinh;
    private Utils ult = new Utils();

    public LoaiHinhForm() {
        initComponents();
        //initTableTour();
        jBtnCapPhatMaLH.setEnabled(true);
        jBtnThemLH.setEnabled(false);
        jBtnSuaLH.setEnabled(false);
        jBtnXoaLH.setEnabled(false);
        jBtnHuyLH.setEnabled(false);
//        jTabbedPane1.getTabComponentAt(1).setVisible(false);

    }

    public boolean isNullOrEmpty(String text) {
        if (text == null || text.equals("")) {
            return true;
        }
        return false;
    }

    public void tableModelLoaiHinh(DefaultTableModel model) {
        for (LoaiHinhTourDTO lh : DashBoard.loaiHinhTourDTOs) {
            Vector row = new Vector();
            row.add(lh.getMaLoai());
            row.add(lh.getTenLoai());
            model.addRow(row);
        }
    }

    public void themVectorLoaiHinh(DefaultTableModel model, LoaiHinhTourDTO loaiHinhDTO) {
        Vector newrow = new Vector();
        newrow.add(loaiHinhDTO.getMaLoai());
        newrow.add(loaiHinhDTO.getTenLoai());
        model.addRow(newrow);
    }

    public void suaVectorLoaiHinh(DefaultTableModel model, int row, LoaiHinhTourDTO loaiHinhDTO) {
        model.setValueAt(loaiHinhDTO.getTenLoai(), row, 1);
    }

    public void xoaVectorLoaiHinh(DefaultTableModel model, int row) {
        model.removeRow(row);
    }
    
    private void filter(String query) {
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(tbModelLoaiHinh);
        jTableLH.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(query));
    }

    public void initTableLH() {
        loaiHinhTourBUS = new LoaiHinhTourBUS();
        tbModelLoaiHinh.setRowCount(0);
        tableModelLoaiHinh(tbModelLoaiHinh);
        jTableLH.setRowSorter(null);
        jTableLH.setAutoCreateRowSorter(true);
        jTableLH.setModel(tbModelLoaiHinh);
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
        jPanelLHTour = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLbMaLH = new javax.swing.JLabel();
        jTextMaLoaiHinh = new javax.swing.JTextField();
        jLbTenLH = new javax.swing.JLabel();
        jBtnThemLH = new javax.swing.JButton();
        jBtnSuaLH = new javax.swing.JButton();
        jBtnHuyLH = new javax.swing.JButton();
        jTextTenLH = new javax.swing.JTextField();
        jBtnXoaLH = new javax.swing.JButton();
        jBtnCapPhatMaLH = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableLH = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextTimKiem = new javax.swing.JTextField();
        jLbTimKiem = new javax.swing.JLabel();
        jBtnRefresh = new javax.swing.JButton();

        setBackground(new java.awt.Color(233, 242, 249));
        setPreferredSize(new java.awt.Dimension(990, 650));

        jTabbedPane1.setBackground(new java.awt.Color(233, 242, 249));
        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jPanelLHTour.setBackground(new java.awt.Color(233, 242, 249));
        jPanelLHTour.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelLHTour.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(233, 242, 249));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin Loại Hình", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(0, 51, 102))); // NOI18N
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLbMaLH.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLbMaLH.setText("<html> <body> Mã Loại Hình <span style=\"color:rgb(234, 21, 21)\"> *</span> </body> </html>");
        jPanel6.add(jLbMaLH, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, 30));

        jTextMaLoaiHinh.setEditable(false);
        jTextMaLoaiHinh.setBackground(new java.awt.Color(214, 217, 223));
        jTextMaLoaiHinh.setForeground(new java.awt.Color(51, 51, 51));
        jTextMaLoaiHinh.setRequestFocusEnabled(false);
        jPanel6.add(jTextMaLoaiHinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 180, 30));

        jLbTenLH.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLbTenLH.setText("<html><body> Tên Loại Hình<span style=\"color:rgb(234, 21, 21)\"> *</span> </body> </html>");
        jPanel6.add(jLbTenLH, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 110, 30));

        jBtnThemLH.setBackground(new java.awt.Color(136, 193, 184));
        jBtnThemLH.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnThemLH.setText("Thêm");
        jBtnThemLH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnThemLH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnThemLHActionPerformed(evt);
            }
        });
        jPanel6.add(jBtnThemLH, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 110, 40));

        jBtnSuaLH.setBackground(new java.awt.Color(136, 193, 184));
        jBtnSuaLH.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnSuaLH.setText("Sửa");
        jBtnSuaLH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnSuaLH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSuaLHActionPerformed(evt);
            }
        });
        jPanel6.add(jBtnSuaLH, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 110, 40));

        jBtnHuyLH.setBackground(new java.awt.Color(136, 193, 184));
        jBtnHuyLH.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnHuyLH.setText("Hủy");
        jBtnHuyLH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnHuyLH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnHuyLHActionPerformed(evt);
            }
        });
        jPanel6.add(jBtnHuyLH, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 150, 110, 40));
        jPanel6.add(jTextTenLH, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 180, 30));

        jBtnXoaLH.setBackground(new java.awt.Color(136, 193, 184));
        jBtnXoaLH.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnXoaLH.setText("Xóa");
        jBtnXoaLH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnXoaLH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnXoaLHActionPerformed(evt);
            }
        });
        jPanel6.add(jBtnXoaLH, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, 110, 40));

        jBtnCapPhatMaLH.setBackground(new java.awt.Color(81, 113, 131));
        jBtnCapPhatMaLH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_add_32.png"))); // NOI18N
        jBtnCapPhatMaLH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnCapPhatMaLH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCapPhatMaLHActionPerformed(evt);
            }
        });
        jPanel6.add(jBtnCapPhatMaLH, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, 30, 30));

        jPanelLHTour.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 590, 210));

        jTableLH.setAutoCreateRowSorter(true);
        jTableLH.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTableLH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableLH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableLHMouseClicked(evt);
            }
        });
        tbColLoaiHinh.add("Mă Loại Hình");
        tbColLoaiHinh.add("Tên Loại Hình");

        tbModelLoaiHinh= new DefaultTableModel(tbColLoaiHinh,5){
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex){
                return false;
            }
        };
        jTableLH.setModel (tbModelLoaiHinh);
        jTableLH.setShowGrid(true);
        jTableLH.setFocusable(false);
        jTableLH.setIntercellSpacing(new Dimension(0,0));
        jTableLH.setRowHeight(25);
        jTableLH.getTableHeader().setOpaque(false);
        jTableLH.setFillsViewportHeight(true);
        jTableLH.getTableHeader().setBackground(new Color(232,57,99));
        jTableLH.getTableHeader().setForeground(new Color(141, 22, 22));
        jTableLH.getTableHeader().setFont (new Font("Dialog", Font.BOLD, 13));
        jTableLH.setSelectionBackground(new Color(52,152,219));
        jTableLH.setAutoResizeMode (javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane5.setViewportView(jTableLH);

        jPanelLHTour.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 300, 590, 300));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Loại Hình Tour");
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(83, 86, 88)));
        jPanelLHTour.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 190, 30));

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 51, 102));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Danh Sách Loại Hình");
        jLabel7.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanelLHTour.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 180, 30));

        jTextTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextTimKiemKeyReleased(evt);
            }
        });
        jPanelLHTour.add(jTextTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 260, 140, 30));

        jLbTimKiem.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLbTimKiem.setText("<html><body>Tìm Kiếm<span style=\"color:rgb(234, 21, 21)\"> *</span> </body></html>");
        jPanelLHTour.add(jLbTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 260, -1, 30));

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
        jPanelLHTour.add(jBtnRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 260, 40, 30));

        jTabbedPane1.addTab("Quản Lý Loại Hình Tour", jPanelLHTour);

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

    private void jTableLHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableLHMouseClicked
        // TODO add your handling code here:
        System.out.println("1");
        if (evt.getSource() == jTableLH) {
            System.out.println("2");
            rowLoaiHinh = jTableLH.getSelectedRow();
            if (rowLoaiHinh != -1) {
                System.out.println("3");
                maLH = (String) jTableLH.getModel().getValueAt(rowLoaiHinh, 0);
                String tenLH = (String) jTableLH.getModel().getValueAt(rowLoaiHinh, 1);
                if (!maLH.equals("null")) {
                    jTextMaLoaiHinh.setText(maLH);
                    jTextTenLH.setText(tenLH);
                }
            }
        }
        System.out.println("4");
        jBtnCapPhatMaLH.setEnabled(false);
        jBtnThemLH.setEnabled(false);
        jBtnSuaLH.setEnabled(true);
        jBtnXoaLH.setEnabled(true);
        jBtnHuyLH.setEnabled(true);
    }//GEN-LAST:event_jTableLHMouseClicked

    private void jBtnCapPhatMaLHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCapPhatMaLHActionPerformed
        // TODO add your handling code here:
        jBtnCapPhatMaLH.setEnabled(false);
        jBtnThemLH.setEnabled(true);
        jBtnSuaLH.setEnabled(false);
        jBtnXoaLH.setEnabled(false);
        jBtnHuyLH.setEnabled(true);
        jTextMaLoaiHinh.setText(ult.initMaLoai());
        jTextTenLH.setText("");
    }//GEN-LAST:event_jBtnCapPhatMaLHActionPerformed

    private void jBtnThemLHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnThemLHActionPerformed
        // TODO add your handling code here:
        String maLoai = (String) jTextMaLoaiHinh.getText(),
                tenLoai = (String) jTextTenLH.getText();

        //Validation
        StringBuilder message = new StringBuilder();
        Validation.notNullOrEmpty(message, "Tên loại hình", tenLoai);
        if (!message.toString().equals("")) {
            JOptionPane.showMessageDialog(this, message.toString());
            return;
        }

        if (!isNullOrEmpty(tenLoai)) {
            if (loaiHinhTourBUS.themLoaiHinhTour(maLoai, tenLoai, DashBoard.loaiHinhTourDTOs)) {
                LoaiHinhTourDTO loaiHinhDTO = new LoaiHinhTourDTO(maLoai, tenLoai);
                themVectorLoaiHinh(tbModelLoaiHinh, loaiHinhDTO);
                JOptionPane.showMessageDialog(this, "Thêm Loại hình tour thành công!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Thêm Loại hình tour thất bại!");
        }
        jBtnCapPhatMaLH.setEnabled(true);
        jBtnThemLH.setEnabled(false);
        jBtnSuaLH.setEnabled(false);
        jBtnXoaLH.setEnabled(false);
        jBtnHuyLH.setEnabled(false);
        jTextMaLoaiHinh.setText("");
        jTextTenLH.setText("");
        jTableLH.clearSelection();
    }//GEN-LAST:event_jBtnThemLHActionPerformed

    private void jBtnSuaLHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSuaLHActionPerformed
        // TODO add your handling code here:
        String tenLoai = (String) jTextTenLH.getText();

        //Validation
        StringBuilder message = new StringBuilder();
        Validation.notNullOrEmpty(message, "Tên loại hình", tenLoai);
        if (!message.toString().equals("")) {
            JOptionPane.showMessageDialog(this, message.toString());
            return;
        }

        if (!isNullOrEmpty(tenLoai) && loaiHinhTourBUS.suaLoaiHinhTour(maLH, tenLoai, DashBoard.loaiHinhTourDTOs)) {
            LoaiHinhTourDTO loaiHinhDTO = new LoaiHinhTourDTO(maLH, tenLoai);
            suaVectorLoaiHinh(tbModelLoaiHinh, rowLoaiHinh, loaiHinhDTO);
            JOptionPane.showMessageDialog(this, "Sửa Loại hình tour thành công!");
        } else {
            JOptionPane.showMessageDialog(this, "Sửa Loại hình tour thất bại!");
        }
        jBtnCapPhatMaLH.setEnabled(true);
        jBtnThemLH.setEnabled(false);
        jBtnSuaLH.setEnabled(false);
        jBtnXoaLH.setEnabled(false);
        jBtnHuyLH.setEnabled(false);
        jTextMaLoaiHinh.setText("");
        jTextTenLH.setText("");
        jTableLH.clearSelection();
    }//GEN-LAST:event_jBtnSuaLHActionPerformed

    private void jBtnXoaLHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnXoaLHActionPerformed
        // TODO add your handling code here:
        if (loaiHinhTourBUS.xoaLoaiHinhTour(maLH, DashBoard.loaiHinhTourDTOs)) {
            xoaVectorLoaiHinh(tbModelLoaiHinh, rowLoaiHinh);
            JOptionPane.showMessageDialog(this, "Xóa Loại hình tour thành công!");
        } else {
            JOptionPane.showMessageDialog(this, "Xóa Loại hình tour thất bại!");
        }
        jBtnCapPhatMaLH.setEnabled(true);
        jBtnThemLH.setEnabled(false);
        jBtnSuaLH.setEnabled(false);
        jBtnXoaLH.setEnabled(false);
        jBtnHuyLH.setEnabled(false);
        jTextMaLoaiHinh.setText("");
        jTextTenLH.setText("");
        jTableLH.clearSelection();
    }//GEN-LAST:event_jBtnXoaLHActionPerformed

    private void jBtnHuyLHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnHuyLHActionPerformed
        // TODO add your handling code here:
        jBtnCapPhatMaLH.setEnabled(true);
        jBtnThemLH.setEnabled(false);
        jBtnSuaLH.setEnabled(false);
        jBtnXoaLH.setEnabled(false);
        jBtnHuyLH.setEnabled(false);
        jTextMaLoaiHinh.setText("");
        jTextTenLH.setText("");
        jTableLH.clearSelection();
    }//GEN-LAST:event_jBtnHuyLHActionPerformed

    private void jTextTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextTimKiemKeyReleased
        // TODO add your handling code here:
        String query = (String) jTextTimKiem.getText();
        filter(query);
    }//GEN-LAST:event_jTextTimKiemKeyReleased

    private void jBtnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRefreshActionPerformed
        // TODO add your handling code here:
        jTextTimKiem.setText("");
        initTableLH();
    }//GEN-LAST:event_jBtnRefreshActionPerformed

    public JButton getjBtnCapPhatMaLH() {
        return jBtnCapPhatMaLH;
    }

    public JTabbedPane getjTabbedPane1() {
        return jTabbedPane1;
    }

    public void setjTabbedPane1(JTabbedPane jTabbedPane1) {
        this.jTabbedPane1 = jTabbedPane1;
    }

    public String getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnCapPhatMaLH;
    private javax.swing.JButton jBtnHuyLH;
    private javax.swing.JButton jBtnRefresh;
    private javax.swing.JButton jBtnSuaLH;
    private javax.swing.JButton jBtnThemLH;
    private javax.swing.JButton jBtnXoaLH;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLbMaLH;
    private javax.swing.JLabel jLbTenLH;
    private javax.swing.JLabel jLbTimKiem;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanelLHTour;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableLH;
    private javax.swing.JTextField jTextMaLoaiHinh;
    private javax.swing.JTextField jTextTenLH;
    private javax.swing.JTextField jTextTimKiem;
    // End of variables declaration//GEN-END:variables
}
