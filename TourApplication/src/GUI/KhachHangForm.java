/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.*;
import DTO.KhachHangDTO;
//import DAO.XuatExcel;
//import DTO.ChucVuDTO;
//import DTO.CongViecDTO;
//import DTO.PhongBanDTO;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
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
import javax.swing.RowFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Hyung
 */
public class KhachHangForm extends javax.swing.JPanel {

    /**
     * Creates new form jPanel2
     */
    static int flagtkmk = 0;
    DefaultTableModel tbModelKH;
    public BufferedImage i = null;
    public String imgName = null;
    private int flagAcc;
    private String manv;
    private String mapb;
    private int selectedRow;
    private Vector addRow;
    private Utils ult = new Utils();
    private KhachHangBUS khachHangBUS;

    public KhachHangForm() {
        initComponents();
        jBtnCapPhatMaKH.setEnabled(true);
        jBtnThemKH.setEnabled(false);
        jBtnHuyKH.setEnabled(false);
        jBtnSuaKH.setEnabled(false);
        jBtnXoaKH.setEnabled(false);
    }

    public void initTableKH() {
        khachHangBUS = new KhachHangBUS();
        tbModelKH.setRowCount(0);
        tbModelKhachHang(tbModelKH);
        jTableKH.setRowSorter(null);
        jTableKH.setAutoCreateRowSorter(true);
        jTableKH.setModel(tbModelKH);
        jTableKH.clearSelection();
    }

    public void tbModelKhachHang(DefaultTableModel model) {
        Vector row;
        for (KhachHangDTO a : DashBoard.khachHangDTOs) {
            row = new Vector();
            row.add(a.getMaKhachHang());
            row.add(a.getTenKhachHang());
            row.add(a.getNgaySinh());
            row.add(a.getSDT());
            row.add(a.getMail());
            row.add(a.getCMND());
            if (a.getGioiTinh().equals("1")) {
                row.add("Nam");
            } else {
                row.add("N???");
            }

            row.add(a.getDiaChi());
            row.add(a.getQuocTich());
            model.addRow(row);
        }
    }

    public boolean add(String maKhachHang, String tenKhachHang, String gioiTinh, String ngaySinh, String cmnd, String sdt, String mail, String diaChi, String quocTich) {
        return khachHangBUS.addKhachHang(new KhachHangDTO(maKhachHang, tenKhachHang, gioiTinh, ngaySinh, cmnd, sdt, mail, diaChi, quocTich), DashBoard.khachHangDTOs);
    }

    public boolean update(String maKhachHang, String tenKhachHang, String gioiTinh, String ngaySinh, String cmnd, String sdt, String mail, String diaChi, String quocTich) {
        return khachHangBUS.updateKhachHang(new KhachHangDTO(maKhachHang, tenKhachHang, gioiTinh, ngaySinh, cmnd, sdt, mail, diaChi, quocTich), DashBoard.khachHangDTOs);
    }

    public boolean delete(String maKhachHang) {
        return khachHangBUS.deleteKhachHang(maKhachHang, DashBoard.khachHangDTOs);
    }

    private void filter(String query) {
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(tbModelKH);
        jTableKH.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(query));
    }

    public String validation() {
        String validate = "";
        String ngaysinh = ((JTextField) jDateNgaySinh.getDateEditor().getUiComponent()).getText();
        if (jTextMaKhachHang.getText().equals("") || jTextTen.getText().equals("")
                || ngaysinh.equals("") || jTextCmnd.getText().equals("")
                || jTextSDT.getText().equals("") || jTextMail.getText().equals("")
                || jTextDiaChi.getText().equals("") || jTextQuocTich.getText().equals("")) {
            validate += "C??c tr?????ng th??ng tin kh??ng ???????c b??? tr???ng!\n";
            return validate;
        } else {
            String hotenPattern = "^[^-\\s][a-zA-Z ????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????]+$";
            String sdtPattern = "(84|0[3|5|7|8|9])+([0-9]{8})\\b";
            String diachi = "^[(A??????????????????????????????????????????????E??????????????????????????????I????????????O??????????????????????????????????????????????U?????????????????????????????Y????????????????a??????????????????????????????????????????????e??????????????????????????????i????????????o??????????????????????????????????????????????u?????????????????????????????y????????????????|a-z|A-Z|\\s|/-|0-9]{3,100}$";

            if (!Pattern.matches(hotenPattern, jTextTen.getText())) {
                validate += "H??? t??n kh??ng h???p l???!\n";
            }
            String cmnd = "^\\d{12}$|^\\d{9}$";
            if (!Pattern.matches(cmnd, jTextCmnd.getText())) {
                validate += "CMND kh??ng h???p l???!\n";
            }
            if (!Pattern.matches(sdtPattern, jTextSDT.getText())) {
                validate += "S??? ??i???n tho???i kh??ng h???p l???!\n";
            }
            String gmail = "^[a-zA-z]+[a-zA-z0-9]+@+[azA-z0-9]+.+com$";
            if (!Pattern.matches(gmail, jTextMail.getText())) {
                validate += "Email kh??ng h???p l???!\n";
            }
            if (!Pattern.matches(diachi, jTextDiaChi.getText())) {
                validate += "?????a ch??? kh??ng h???p l???!\n";
            }
        }
        return validate;
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
        jBtnThemKH = new javax.swing.JButton();
        jBtnSuaKH = new javax.swing.JButton();
        jBtnXoaKH = new javax.swing.JButton();
        jBtnHuyKH = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextMaKhachHang = new javax.swing.JTextField();
        jBtnCapPhatMaKH = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jTextTen = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTextSDT = new javax.swing.JTextField();
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
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableKH = new javax.swing.JTable();
        jLbTimKiem = new javax.swing.JLabel();
        jTextTimKiem = new javax.swing.JTextField();
        jBtnRefresh = new javax.swing.JButton();

        setBackground(new java.awt.Color(233, 242, 249));
        setPreferredSize(new java.awt.Dimension(990, 650));

        jTabbedPane1.setBackground(new java.awt.Color(233, 242, 249));
        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jPanelNV.setBackground(new java.awt.Color(233, 242, 249));
        jPanelNV.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelNV.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(233, 242, 249));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "H??? S?? Kh??ch H??ng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(0, 51, 102))); // NOI18N

        jBtnThemKH.setBackground(new java.awt.Color(136, 193, 184));
        jBtnThemKH.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnThemKH.setText("Th??m");
        jBtnThemKH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnThemKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnThemKHActionPerformed(evt);
            }
        });

        jBtnSuaKH.setBackground(new java.awt.Color(136, 193, 184));
        jBtnSuaKH.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnSuaKH.setText("S???a");
        jBtnSuaKH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnSuaKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSuaKHActionPerformed(evt);
            }
        });

        jBtnXoaKH.setBackground(new java.awt.Color(136, 193, 184));
        jBtnXoaKH.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnXoaKH.setText("X??a");
        jBtnXoaKH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnXoaKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnXoaKHActionPerformed(evt);
            }
        });

        jBtnHuyKH.setBackground(new java.awt.Color(136, 193, 184));
        jBtnHuyKH.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnHuyKH.setText("H???y");
        jBtnHuyKH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnHuyKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnHuyKHActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("<html> <body> M?? Kh??ch H??ng <span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");

        jTextMaKhachHang.setBackground(new java.awt.Color(214, 217, 223));
        jTextMaKhachHang.setEditable(false);

        jBtnCapPhatMaKH.setBackground(new java.awt.Color(81, 113, 131));
        jBtnCapPhatMaKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_edit_account_16.png"))); // NOI18N
        jBtnCapPhatMaKH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnCapPhatMaKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCapPhatMaKHActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setText("<html> <body>H??? T??n Kh??ch H??ng <span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel16.setText("<html> <body>S??T <span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setText("<html> <body> Gi???i T??nh <span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");

        jCbGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "N???" }));

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel15.setText("<html> <body>?????a Ch??? <span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel14.setText("<html> <body>Mail <span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel17.setText("<html> <body>Qu???c T???ch <span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");

        jLabel25.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel25.setText("<html> <body>Ng??y Sinh<span style=\"color:rgb(216, 74, 67);\"> *</span> </body> </html> ");

        jDateNgaySinh.setBackground(new java.awt.Color(214, 217, 223));
        JTextFieldDateEditor editor1 = (JTextFieldDateEditor) jDateNgaySinh.getDateEditor();
        editor1.setEditable(false);
        jDateNgaySinh.setDateFormatString("yyyy-MM-dd");

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel13.setText("<html> <body>CMND <span style=\"color:rgb(216, 74, 67);\">*</span> </body> </html> ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextMail, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextMaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(10, 10, 10)
                                    .addComponent(jBtnCapPhatMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                    .addComponent(jTextTen, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextQuocTich, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(72, 72, 72)
                                .addComponent(jDateNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(90, 90, 90)
                                .addComponent(jTextCmnd, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBtnXoaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jBtnThemKH, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jBtnSuaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jBtnHuyKH, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextMaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnCapPhatMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(jBtnThemKH, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnSuaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnHuyKH, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnXoaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanelNV.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 380, 530));

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setAutoscrolls(true);

        jTableKH.setAutoCreateRowSorter(true);
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
        tableCol.add ("M?? Kh??ch H??ng");
        tableCol.add ("T??n Kh??ch H??ng");
        tableCol.add ("Ng??y Sinh");
        tableCol.add ("S??? ??T");
        tableCol.add ("Mail");
        tableCol.add ("CMND");
        tableCol.add ("Gi???i T??nh");
        tableCol.add ("?????a Ch???");
        tableCol.add ("Qu???c T???ch");
        tbModelKH = new DefaultTableModel(tableCol, 5){
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex){
                return false;
            }
        };
        jTableKH.setModel(tbModelKH);
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

        jTableKH.setSelectionBackground(new Color(52,152,219));

        jTableKH.getColumn (tableCol.elementAt (0)).setPreferredWidth (130);
        jTableKH.getColumn (tableCol.elementAt (1)).setPreferredWidth (150);
        jTableKH.getColumn (tableCol.elementAt (2)).setPreferredWidth (150);
        jTableKH.getColumn (tableCol.elementAt (3)).setPreferredWidth (150);
        jTableKH.getColumn (tableCol.elementAt (4)).setPreferredWidth (180);
        jTableKH.getColumn (tableCol.elementAt (5)).setPreferredWidth (150);
        jTableKH.getColumn (tableCol.elementAt (6)).setPreferredWidth (120);
        jTableKH.getColumn (tableCol.elementAt (7)).setPreferredWidth (160);
        jTableKH.getColumn (tableCol.elementAt (8)).setPreferredWidth (160);
        jScrollPane2.setViewportView(jTableKH);
        jTableKH.setAutoResizeMode (javax.swing.JTable.AUTO_RESIZE_OFF);

        jPanelNV.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, 560, 520));

        jLbTimKiem.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLbTimKiem.setText("<html><body>T??m Ki???m<span style=\"color:rgb(234, 21, 21)\"> *</span> </body></html>");
        jPanelNV.add(jLbTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 30, -1, 30));

        jTextTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextTimKiemKeyReleased(evt);
            }
        });
        jPanelNV.add(jTextTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 30, 140, 30));

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

        jTabbedPane1.addTab("Qu???n L?? Kh??ch H??ng", jPanelNV);

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

    private void jBtnCapPhatMaKHActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnCapPhatMaKHActionPerformed
    {//GEN-HEADEREND:event_jBtnCapPhatMaKHActionPerformed

        // TODO add your handling code here:
        jBtnCapPhatMaKH.setEnabled(false);
        jBtnThemKH.setEnabled(true);
        jBtnHuyKH.setEnabled(true);
        jBtnSuaKH.setEnabled(false);
        jBtnXoaKH.setEnabled(false);
        jTextMaKhachHang.setText(ult.initMaKhachHang());
        jTextTen.setText("");
        jTextCmnd.setText("");
        jTextSDT.setText("");
        jTextMail.setText("");
        jTextDiaChi.setText("");
        jTextQuocTich.setText("");
        jDateNgaySinh.setCalendar(null);
    }//GEN-LAST:event_jBtnCapPhatMaKHActionPerformed

    private void jTableKHMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jTableKHMouseClicked
    {//GEN-HEADEREND:event_jTableKHMouseClicked
        // TODO add your handling code here:
        if (evt.getSource() == jTableKH) {
            selectedRow = jTableKH.getSelectedRow();
            if (selectedRow != -1) {
                jTextMaKhachHang.setText((String) tbModelKH.getValueAt(selectedRow, 0));
                jTextTen.setText((String) tbModelKH.getValueAt(selectedRow, 1));
                if (tbModelKH.getValueAt(selectedRow, 6).equals("Nam")) {
                    jCbGioiTinh.setSelectedIndex(0);
                } else {
                    jCbGioiTinh.setSelectedIndex(1);
                }
                Date ngaySinh;
                try {
                    ngaySinh = new SimpleDateFormat("yyyy-MM-dd").parse(tbModelKH.getValueAt(selectedRow, 2).toString());
                    jDateNgaySinh.setDate(ngaySinh);
                } catch (ParseException ex) {
                    Logger.getLogger(KhachHangForm.class.getName()).log(Level.SEVERE, null, ex);
                }
                jTextCmnd.setText((String) tbModelKH.getValueAt(selectedRow, 5));
                jTextSDT.setText((String) tbModelKH.getValueAt(selectedRow, 3));
                jTextMail.setText((String) tbModelKH.getValueAt(selectedRow, 4));
                jTextDiaChi.setText((String) tbModelKH.getValueAt(selectedRow, 7));
                jTextQuocTich.setText((String) tbModelKH.getValueAt(selectedRow, 8));
            }
        }
        jBtnCapPhatMaKH.setEnabled(false);
        jBtnThemKH.setEnabled(false);
        jBtnHuyKH.setEnabled(true);
        jBtnSuaKH.setEnabled(true);
        jBtnXoaKH.setEnabled(true);
    }//GEN-LAST:event_jTableKHMouseClicked

    private void jBtnThemKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnThemKHActionPerformed
        // TODO add your handling code here:
        //System.out.println((String) ((JTextField) jDateNgaySinh.getDateEditor().getUiComponent()).getText());
        String check = validation();
        if (check.equals("")) {
            String ngaySinh = (String) ((JTextField) jDateNgaySinh.getDateEditor().getUiComponent()).getText();
            String gioiTinh;
            if (jCbGioiTinh.getSelectedItem().equals("Nam")) {
                gioiTinh = "1";
            } else {
                gioiTinh = "0";
            }
            if (add(
                    jTextMaKhachHang.getText(),
                    jTextTen.getText(),
                    gioiTinh,
                    ngaySinh,
                    jTextCmnd.getText(),
                    jTextSDT.getText(),
                    jTextMail.getText(),
                    jTextDiaChi.getText(),
                    jTextQuocTich.getText())) {
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
                tbModelKH.addRow(addRow);
                JOptionPane.showMessageDialog(this, "Th??m kh??ch h??ng th??nh c??ng!");
            } else {
                JOptionPane.showMessageDialog(this, "Th??m kh??ch h??ng th???t b???i!");
            }
            jBtnCapPhatMaKH.setEnabled(true);
            jBtnThemKH.setEnabled(false);
            jBtnHuyKH.setEnabled(false);
            jBtnSuaKH.setEnabled(false);
            jBtnXoaKH.setEnabled(false);
            jTextMaKhachHang.setText("");
            jTextTen.setText("");
            jTextCmnd.setText("");
            jTextSDT.setText("");
            jTextMail.setText("");
            jTextDiaChi.setText("");
            jTextQuocTich.setText("");
            jDateNgaySinh.setCalendar(null);
            jTableKH.clearSelection();
        } else {
            JOptionPane.showMessageDialog(this, check);
        }
    }//GEN-LAST:event_jBtnThemKHActionPerformed

    private void jBtnSuaKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSuaKHActionPerformed
        // TODO add your handling code here:
        String check = validation();
        if (check.equals("")) {
            String ngaySinh = (String) ((JTextField) jDateNgaySinh.getDateEditor().getUiComponent()).getText();
            String gioiTinh;
            if (jCbGioiTinh.getSelectedItem().equals("Nam")) {
                gioiTinh = "1";
            } else {
                gioiTinh = "0";
            }
            if (update(
                    jTextMaKhachHang.getText(),
                    jTextTen.getText(),
                    gioiTinh,
                    ngaySinh,
                    jTextCmnd.getText(),
                    jTextSDT.getText(),
                    jTextMail.getText(),
                    jTextDiaChi.getText(),
                    jTextQuocTich.getText())) {
                tbModelKH.setValueAt(jTextMaKhachHang.getText(), selectedRow, 0);
                tbModelKH.setValueAt(jTextTen.getText(), selectedRow, 1);
                tbModelKH.setValueAt(ngaySinh, selectedRow, 2);
                tbModelKH.setValueAt(jTextSDT.getText(), selectedRow, 3);
                tbModelKH.setValueAt(jTextMail.getText(), selectedRow, 4);
                tbModelKH.setValueAt(jTextCmnd.getText(), selectedRow, 5);
                tbModelKH.setValueAt(jCbGioiTinh.getSelectedItem(), selectedRow, 6);
                tbModelKH.setValueAt(jTextDiaChi.getText(), selectedRow, 7);
                tbModelKH.setValueAt(jTextQuocTich.getText(), selectedRow, 8);
                JOptionPane.showMessageDialog(this, "S???a kh??ch h??ng th??nh c??ng!");
            } else {
                JOptionPane.showMessageDialog(this, "S???a kh??ch h??ng th???t b???i!");
            }
            jBtnCapPhatMaKH.setEnabled(true);
            jBtnThemKH.setEnabled(false);
            jBtnHuyKH.setEnabled(false);
            jBtnSuaKH.setEnabled(false);
            jBtnXoaKH.setEnabled(false);
            jTextMaKhachHang.setText("");
            jTextTen.setText("");
            jTextCmnd.setText("");
            jTextSDT.setText("");
            jTextMail.setText("");
            jTextDiaChi.setText("");
            jTextQuocTich.setText("");
            jDateNgaySinh.setCalendar(null);
            jTableKH.clearSelection();
        } else {
            JOptionPane.showMessageDialog(this, check);
        }
    }//GEN-LAST:event_jBtnSuaKHActionPerformed

    private void jBtnXoaKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnXoaKHActionPerformed
        if (delete(tbModelKH.getValueAt(selectedRow, 0).toString())) {
            tbModelKH.removeRow(selectedRow);
            JOptionPane.showMessageDialog(this, "X??a kh??ch h??ng th??nh c??ng!");
        } else {
            JOptionPane.showMessageDialog(this, "X??a kh??ch h??ng th???t b???i!");
        }
        jBtnCapPhatMaKH.setEnabled(true);
        jBtnThemKH.setEnabled(false);
        jBtnHuyKH.setEnabled(false);
        jBtnSuaKH.setEnabled(false);
        jBtnXoaKH.setEnabled(false);
        jTextMaKhachHang.setText("");
        jTextTen.setText("");
        jTextCmnd.setText("");
        jTextSDT.setText("");
        jTextMail.setText("");
        jTextDiaChi.setText("");
        jTextQuocTich.setText("");
        jDateNgaySinh.setCalendar(null);
        jTableKH.clearSelection();
    }//GEN-LAST:event_jBtnXoaKHActionPerformed

    private void jTableKHAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTableKHAncestorAdded

    }//GEN-LAST:event_jTableKHAncestorAdded

    private void jBtnHuyKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnHuyKHActionPerformed
        // TODO add your handling code here:
        jBtnCapPhatMaKH.setEnabled(true);
        jBtnThemKH.setEnabled(false);
        jBtnHuyKH.setEnabled(false);
        jBtnSuaKH.setEnabled(false);
        jBtnXoaKH.setEnabled(false);
        jTextMaKhachHang.setText("");
        jTextTen.setText("");
        jTextCmnd.setText("");
        jTextSDT.setText("");
        jTextMail.setText("");
        jTextDiaChi.setText("");
        jTextQuocTich.setText("");
        jDateNgaySinh.setCalendar(null);
        jTableKH.clearSelection();
    }//GEN-LAST:event_jBtnHuyKHActionPerformed

    private void jTextTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextTimKiemKeyReleased
        // TODO add your handling code here:
        String query = (String) jTextTimKiem.getText();
        filter(query);
    }//GEN-LAST:event_jTextTimKiemKeyReleased

    private void jBtnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRefreshActionPerformed
        // TODO add your handling code here:
        jTextTimKiem.setText("");
        initTableKH();
    }//GEN-LAST:event_jBtnRefreshActionPerformed

//    Vector tableRow = new Vector ();//Vector ch???a c??c d??ng d??? li???u c???a b???ng.
    Vector tableCol = new Vector();//Vector ch???a c??c ti??u ????? c???a b???ng.

    public void addCombo(JComboBox cmb, ArrayList list) {
        for (Object a : list) {
            cmb.addItem(a);
        }
    }

//    public JComboBox<String> getjComboBox3()
//    {
//        return jCbPhongBan;
//    }
    public JPanel getjPanel1() {
        return jPanelNV;
    }

    public JTextField getjTextHonv() {
        return jTextTen;
    }

    public JTextField getjTextManv() {
        return jTextMaKhachHang;
    }

    public DefaultTableModel getModelnv() {
        return tbModelKH;
    }

    public JButton getjBtnCapPhatMaNV() {
        return jBtnCapPhatMaKH;
    }

    public int getFlagAcc() {
        return flagAcc;
    }

    public void setFlagAcc(int flagAcc) {
        this.flagAcc = flagAcc;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getMapb() {
        return mapb;
    }

    public void setMapb(String mapb) {
        this.mapb = mapb;
    }

    public JButton getjBtnRefresh() {
        return jBtnRefresh;
    }

    public void setjBtnRefresh(JButton jBtnRefresh) {
        this.jBtnRefresh = jBtnRefresh;
    }

    public JTabbedPane getjTabbedPane1() {
        return jTabbedPane1;
    }

    public void setjTabbedPane1(JTabbedPane jTabbedPane1) {
        this.jTabbedPane1 = jTabbedPane1;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnCapPhatMaKH;
    private javax.swing.JButton jBtnHuyKH;
    private javax.swing.JButton jBtnRefresh;
    private javax.swing.JButton jBtnSuaKH;
    private javax.swing.JButton jBtnThemKH;
    private javax.swing.JButton jBtnXoaKH;
    private javax.swing.JComboBox<String> jCbGioiTinh;
    private com.toedter.calendar.JDateChooser jDateNgaySinh;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLbTimKiem;
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
    private javax.swing.JTextField jTextTimKiem;
    // End of variables declaration//GEN-END:variables
}
