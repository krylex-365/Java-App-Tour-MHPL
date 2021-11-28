/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.*;
import DTO.DiaDiemDTO;
import DTO.DiaDiemThamQuanDTO;
import DTO.DoanDuLichDTO;
import DTO.GiaTourDTO;
import DTO.LoaiHinhTourDTO;
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
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hyung
 */
public class LoaiHinhForm extends javax.swing.JPanel
{

    /**
     * Creates new form jPanel2
     */
    static int flagtkmk = 0;
    TourBUS tourBUS;
    GiaTourBUS giaTourBUS;
    //ChiTietTour chiTietTour;
    LoaiHinhTourBUS loaiHinhTourBUS;
    public BufferedImage i = null;
    public String imgName = null;
    int rowTour, rowDiaDiemThamQuan, flagThemDiaDiem, rowLoaiHinh;
    private String maTour, tenTour, maLoai, maLoaiHienHanh, maGia, maGiaHienHanh,
            maTourChiTiet, tenTourChiTiet, maLH;
    private String maDiaDiem, tenDiaDiem, thuTu;
    private ArrayList<DiaDiemThamQuanDTO> diaDiemThamQuanTempArr;
    int countNoti;
    Vector tbColTour = new Vector();//Vector chứa các dòng dữ liệu của bảng.
    Vector tbColDiadiem = new Vector();//Vector chứa các tiêu đề của bảng.
    Vector tbColDoan = new Vector();
    Vector tbColLoaiHinh = new Vector();
    DefaultTableModel tbModelLoaiHinh;
    private Utils ult = new Utils();

    DoanDuLichBUS doanDuLichBUS;
    DiaDiemThamQuanBUS diaDiemThamQuanBUS;
    DiaDiemBUS diaDiemBUS;
    ChiTietDoanBUS chiTietDoanBUS;

    public LoaiHinhForm()
    {
        initComponents();
        //initTableTour();
        jBtnCapPhatMaLH.setEnabled(true);
        jBtnThemLH.setEnabled(false);
        jBtnSuaLH.setEnabled(false);
        jBtnXoaLH.setEnabled(false);
        jBtnHuyLH.setEnabled(false);
//        jTabbedPane1.getTabComponentAt(1).setVisible(false);

    }

    public void tbModelDiaDiemThamQuan(DefaultTableModel model, String maTour)
    {
        Vector row;
        for (DiaDiemThamQuanDTO a : diaDiemThamQuanTempArr)
        {
            row = new Vector();
            row.add(a.getMaDiaDiem());
            row.add(diaDiemBUS.searchTenDiaDiemByMaDiaDiem(a.getMaDiaDiem(), DashBoard.diaDiemDTOs));
            row.add(a.getThuTu());
            model.addRow(row);
        }
    }

    public void tbModelDoanDuLich(DefaultTableModel model, String maTour)
    {
        Vector row;
        //System.out.println("ChiTietTour");
        for (DoanDuLichDTO a : doanDuLichBUS.searchDoanDuLichByMaTour(maTour, DashBoard.doanDuLichDTOs))
        {
            row = new Vector();
            row.add(a.getMaDoan());
            row.add(a.getTenDoan());
            row.add(a.getGiaTour());
            row.add(a.getNgayKhoiHanh());
            row.add(a.getNgayKetThuc());
            System.out.println(a);
//            row.add(chiTietDoanBUS.peopleCount(a.getMaDoan()));
            row.add(chiTietDoanBUS.peopleCountByMaDoan(a.getMaDoan(), DashBoard.chiTietDoanDTOs));
            model.addRow(row);
        }
    }

    public void tbModelSearchDoanDuLich(DefaultTableModel model, String maDoan)
    {
        Vector row = new Vector();
        for (DoanDuLichDTO a : doanDuLichBUS.searchDoanDuLichByMaDoan(maDoan, DashBoard.doanDuLichDTOs))
        {
            row.add(a.getMaDoan());
            row.add(a.getTenDoan());
            row.add(a.getGiaTour());
            row.add(a.getNgayKhoiHanh());
            row.add(a.getNgayKetThuc());
//            row.add(chiTietDoanBUS.peopleCount(a.getMaDoan()));
            row.add(chiTietDoanBUS.peopleCountByMaDoan(a.getMaDoan(), DashBoard.chiTietDoanDTOs));
            model.addRow(row);
        }
    }

    public void tableModelTour(DefaultTableModel model)
    {
        for (TourDTO tour : DashBoard.tourDTOs)
        {
            Vector row = new Vector();
            row.add(tour.getMaTour());
            row.add(tour.getTenTour());
            for (LoaiHinhTourDTO loaiHinhTour : DashBoard.loaiHinhTourDTOs)
            {
                if (loaiHinhTour.getMaLoai().equals(tour.getMaLoai()))
                {
                    row.add(loaiHinhTour.getTenLoai());
                    break;
                }
            }
            for (GiaTourDTO giaTour : DashBoard.giaTourDTOs)
            {
                if (giaTour.getMaTour().equals(tour.getMaTour()) && giaTour.getHienHanh() == 1)
                {
                    row.add(giaTour.getThanhTien());
                    row.add(giaTour.getTgBatDau());
                    row.add(giaTour.getTgKetThuc());
                    break;
                }
            }
            model.addRow(row);
        }
    }

    public void themVectorTour(DefaultTableModel model, String maTour, String tenTour,
            String tenLoai, String giaTour, String ngayBD, String ngayKT)
    {
        Vector newrow = new Vector();
        newrow.add(maTour);
        newrow.add(tenTour);
        newrow.add(tenLoai);
        newrow.add(giaTour);
        newrow.add(ngayBD);
        newrow.add(ngayKT);
        model.addRow(newrow);
    }

    public void suaVectorTour(DefaultTableModel model, int row, String tenTour,
            String tenLoai, String giaTour, String ngayBD, String ngayKT)
    {
        model.setValueAt(tenTour, row, 1);
        model.setValueAt(tenLoai, row, 2);
        model.setValueAt(giaTour, row, 3);
        model.setValueAt(ngayBD, row, 4);
        model.setValueAt(ngayKT, row, 5);
    }

    public void xoaVectorTour(DefaultTableModel model, int row)
    {
        model.removeRow(row);
    }

    public void timKiem(DefaultTableModel model, String value)
    {
        model.setRowCount(0);
        for (TourDTO tourDTO : DashBoard.tourDTOs)
        {
            if (tourDTO.getMaTour().equals(value) || tourDTO.getTenTour().indexOf(value) != -1)
            {
                Vector row = new Vector();
                row.add(tourDTO.getMaTour());
                row.add(tourDTO.getTenTour());
                for (LoaiHinhTourDTO loaiHinhTour : DashBoard.loaiHinhTourDTOs)
                {
                    if (loaiHinhTour.getMaLoai().equals(tourDTO.getMaLoai()))
                    {
                        row.add(loaiHinhTour.getTenLoai());
                        break;
                    }
                }
                for (GiaTourDTO giaTour : DashBoard.giaTourDTOs)
                {
                    if (giaTour.getMaTour().equals(tourDTO.getMaTour()) && giaTour.getHienHanh() == 1)
                    {
                        row.add(giaTour.getThanhTien());
                        row.add(giaTour.getTgBatDau());
                        row.add(giaTour.getTgKetThuc());
                        break;
                    }
                }
                model.addRow(row);
                break;
            }
        }
    }

    public boolean isNullOrEmpty(String text)
    {
        if (text == null || text.equals(""))
        {
            return true;
        }
        return false;
    }

    public void tbModelSearchLoaiHinh(DefaultTableModel model, String value)
    {
        Vector row = new Vector();
        model.setRowCount(0);
        for (LoaiHinhTourDTO a : DashBoard.loaiHinhTourDTOs)
        {
            if (a.getMaLoai().equals(value) || a.getTenLoai().indexOf(value) != -1)
            {
                System.out.println(a);
                row.add(a.getMaLoai());
                row.add(a.getTenLoai());
                model.addRow(row);
                break;
            }
        }
    }

    public void tableModelLoaiHinh(DefaultTableModel model)
    {
        for (LoaiHinhTourDTO lh : DashBoard.loaiHinhTourDTOs)
        {
            Vector row = new Vector();
            row.add(lh.getMaLoai());
            row.add(lh.getTenLoai());
            model.addRow(row);
        }
    }

    public void themVectorLoaiHinh(DefaultTableModel model, LoaiHinhTourDTO loaiHinhDTO)
    {
        Vector newrow = new Vector();
        newrow.add(loaiHinhDTO.getMaLoai());
        newrow.add(loaiHinhDTO.getTenLoai());
        model.addRow(newrow);
    }

    public void suaVectorLoaiHinh(DefaultTableModel model, int row, LoaiHinhTourDTO loaiHinhDTO)
    {
        model.setValueAt(loaiHinhDTO.getTenLoai(), row, 1);
    }

    public void xoaVectorLoaiHinh(DefaultTableModel model, int row)
    {
        model.removeRow(row);
    }

    public void loadDataTour()
    {
        tourBUS = new TourBUS();
        giaTourBUS = new GiaTourBUS();
        //chiTietTour = new ChiTietTour();
        loaiHinhTourBUS = new LoaiHinhTourBUS();
        doanDuLichBUS = new DoanDuLichBUS();
        diaDiemThamQuanBUS = new DiaDiemThamQuanBUS();
        diaDiemBUS = new DiaDiemBUS();
        chiTietDoanBUS = new ChiTietDoanBUS();

//        tbModelTour.setRowCount(0);
//        tableModelTour(tbModelTour);
//        jTableTour.setModel(tbModelTour);
    }

    public void initTableTour()
    {
        loadDataTour();
    }

    public void loadDataLH()
    {
        loaiHinhTourBUS = new LoaiHinhTourBUS();
        tbModelLoaiHinh.setRowCount(0);
        tableModelLoaiHinh(tbModelLoaiHinh);
        jTableLH.setModel(tbModelLoaiHinh);
    }

    public void initTableLH()
    {
        loadDataLH();
    }

    public void initAllTable()
    {
        loadDataTour();
        loadDataLH();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

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
        jTextTimKiemLH = new javax.swing.JTextField();
        jBtnTimKiemLH = new javax.swing.JButton();
        jBtnRefreshLH = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

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
        jBtnThemLH.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jBtnThemLHActionPerformed(evt);
            }
        });
        jPanel6.add(jBtnThemLH, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 110, 40));

        jBtnSuaLH.setBackground(new java.awt.Color(136, 193, 184));
        jBtnSuaLH.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnSuaLH.setText("Sửa");
        jBtnSuaLH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnSuaLH.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jBtnSuaLHActionPerformed(evt);
            }
        });
        jPanel6.add(jBtnSuaLH, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 110, 40));

        jBtnHuyLH.setBackground(new java.awt.Color(136, 193, 184));
        jBtnHuyLH.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnHuyLH.setText("Hủy");
        jBtnHuyLH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnHuyLH.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jBtnHuyLHActionPerformed(evt);
            }
        });
        jPanel6.add(jBtnHuyLH, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 150, 110, 40));
        jPanel6.add(jTextTenLH, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 180, 30));

        jBtnXoaLH.setBackground(new java.awt.Color(136, 193, 184));
        jBtnXoaLH.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jBtnXoaLH.setText("Xóa");
        jBtnXoaLH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnXoaLH.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jBtnXoaLHActionPerformed(evt);
            }
        });
        jPanel6.add(jBtnXoaLH, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, 110, 40));

        jBtnCapPhatMaLH.setBackground(new java.awt.Color(81, 113, 131));
        jBtnCapPhatMaLH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_add_32.png"))); // NOI18N
        jBtnCapPhatMaLH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnCapPhatMaLH.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jBtnCapPhatMaLHActionPerformed(evt);
            }
        });
        jPanel6.add(jBtnCapPhatMaLH, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, 30, 30));

        jPanelLHTour.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 590, 210));

        jTableLH.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTableLH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {},
                {},
                {},
                {}
            },
            new String []
            {

            }
        ));
        jTableLH.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jTableLHMouseClicked(evt);
            }
        });
        tbColLoaiHinh.add("Mă Loại Hình");
        tbColLoaiHinh.add("Tên Loại Hình");

        tbModelLoaiHinh= new DefaultTableModel(tbColLoaiHinh,5)
        {
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
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

        jTextTimKiemLH.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jTextTimKiemLHActionPerformed(evt);
            }
        });
        jPanelLHTour.add(jTextTimKiemLH, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 260, 230, 30));

        jBtnTimKiemLH.setText("Tìm kiếm");
        jBtnTimKiemLH.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jBtnTimKiemLHActionPerformed(evt);
            }
        });
        jPanelLHTour.add(jBtnTimKiemLH, new org.netbeans.lib.awtextra.AbsoluteConstraints(683, 260, -1, 30));

        jBtnRefreshLH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/refresh_25px.png"))); // NOI18N
        jBtnRefreshLH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnRefreshLH.setMaximumSize(new java.awt.Dimension(50, 50));
        jBtnRefreshLH.setMinimumSize(new java.awt.Dimension(50, 50));
        jBtnRefreshLH.setPreferredSize(new java.awt.Dimension(50, 50));
        jBtnRefreshLH.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jBtnRefreshLHActionPerformed(evt);
            }
        });
        jPanelLHTour.add(jBtnRefreshLH, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 260, 40, 30));

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

    public String ktra()
    {
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
        if (evt.getSource() == jTableLH)
        {
            System.out.println("2");
            rowLoaiHinh = jTableLH.getSelectedRow();
            if (rowLoaiHinh != -1)
            {
                System.out.println("3");
                maLH = (String) jTableLH.getModel().getValueAt(rowLoaiHinh, 0);
                String tenLH = (String) jTableLH.getModel().getValueAt(rowLoaiHinh, 1);
                if (!maLH.equals("null"))
                {
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

    private void jTextTimKiemLHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextTimKiemLHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextTimKiemLHActionPerformed

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
        if (!message.toString().equals(""))
        {
            JOptionPane.showMessageDialog(this, message.toString());
            return;
        }

        if (!isNullOrEmpty(tenLoai))
        {
            if (loaiHinhTourBUS.themLoaiHinhTour(maLoai, tenLoai, DashBoard.loaiHinhTourDTOs))
            {
                LoaiHinhTourDTO loaiHinhDTO = new LoaiHinhTourDTO(maLoai, tenLoai);
                themVectorLoaiHinh(tbModelLoaiHinh, loaiHinhDTO);
                JOptionPane.showMessageDialog(this, "Thêm Loại hình tour thành công!");
            }
        } else
        {
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
        if (!message.toString().equals(""))
        {
            JOptionPane.showMessageDialog(this, message.toString());
            return;
        }

        if (!isNullOrEmpty(tenLoai) && loaiHinhTourBUS.suaLoaiHinhTour(maLH, tenLoai, DashBoard.loaiHinhTourDTOs))
        {
            LoaiHinhTourDTO loaiHinhDTO = new LoaiHinhTourDTO(maLH, tenLoai);
            suaVectorLoaiHinh(tbModelLoaiHinh, rowLoaiHinh, loaiHinhDTO);
            JOptionPane.showMessageDialog(this, "Sửa Loại hình tour thành công!");
        } else
        {
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
        if (loaiHinhTourBUS.xoaLoaiHinhTour(maLH, DashBoard.loaiHinhTourDTOs))
        {
            xoaVectorLoaiHinh(tbModelLoaiHinh, rowLoaiHinh);
            JOptionPane.showMessageDialog(this, "Xóa Loại hình tour thành công!");
        } else
        {
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

    private void jBtnTimKiemLHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnTimKiemLHActionPerformed
        // TODO add your handling code here:
        tbModelSearchLoaiHinh(tbModelLoaiHinh, (String) jTextTimKiemLH.getText());
//        System.out.println(jTextMaLoaiHinh.getText().toString());
    }//GEN-LAST:event_jBtnTimKiemLHActionPerformed

    private void jBtnRefreshLHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRefreshLHActionPerformed
        // TODO add your handling code here:
        jTextTimKiemLH.setText("");
        loadDataLH();
    }//GEN-LAST:event_jBtnRefreshLHActionPerformed

    public int getRowTour()
    {
        return rowTour;
    }

    public void setRowTour(int rowTour)
    {
        this.rowTour = rowTour;
    }

    public JButton getjBtnCapPhatMaNV()
    {
        return jBtnCapPhatMaLH;
    }

    public JTabbedPane getjTabbedPane1()
    {
        return jTabbedPane1;
    }

    public void setjTabbedPane1(JTabbedPane jTabbedPane1)
    {
        this.jTabbedPane1 = jTabbedPane1;
    }

    public String getMaDiaDiem()
    {
        return maDiaDiem;
    }

    public void setMaDiaDiem(String maDiaDiem)
    {
        this.maDiaDiem = maDiaDiem;
    }

    public String getTenDiaDiem()
    {
        return tenDiaDiem;
    }

    public void setTenDiaDiem(String TenDiaDiem)
    {
        this.tenDiaDiem = TenDiaDiem;
    }

    public String getMaTour()
    {
        return maTour;
    }

    public void setMaTour(String maTour)
    {
        this.maTour = maTour;
    }

    public String getMaLoai()
    {
        return maLoai;
    }

    public void setMaLoai(String maLoai)
    {
        this.maLoai = maLoai;
    }

    public String getMaGia()
    {
        return maGia;
    }

    public void setMaGia(String maGia)
    {
        this.maGia = maGia;
    }

    public String getMaGiaHienHanh()
    {
        return maGiaHienHanh;
    }

    public void setMaGiaHienHanh(String maGiaHienHanh)
    {
        this.maGiaHienHanh = maGiaHienHanh;
    }

    public String getMaLoaiHienHanh()
    {
        return maLoaiHienHanh;
    }

    public void setMaLoaiHienHanh(String maLoaiHienHanh)
    {
        this.maLoaiHienHanh = maLoaiHienHanh;
    }

    public String getTenTour()
    {
        return tenTour;
    }

    public void setTenTour(String tenTour)
    {
        this.tenTour = tenTour;
    }

    public ArrayList<DiaDiemThamQuanDTO> getDiaDiemThamQuanTempArr()
    {
        return diaDiemThamQuanTempArr;
    }

    public void setDiaDiemThamQuanTempArr(ArrayList<DiaDiemThamQuanDTO> diaDiemThamQuanTempArr)
    {
        this.diaDiemThamQuanTempArr = diaDiemThamQuanTempArr;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnCapPhatMaLH;
    private javax.swing.JButton jBtnHuyLH;
    private javax.swing.JButton jBtnRefreshLH;
    private javax.swing.JButton jBtnSuaLH;
    private javax.swing.JButton jBtnThemLH;
    private javax.swing.JButton jBtnTimKiemLH;
    private javax.swing.JButton jBtnXoaLH;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLbMaLH;
    private javax.swing.JLabel jLbTenLH;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanelLHTour;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableLH;
    private javax.swing.JTextField jTextMaLoaiHinh;
    private javax.swing.JTextField jTextTenLH;
    private javax.swing.JTextField jTextTimKiemLH;
    // End of variables declaration//GEN-END:variables
}
