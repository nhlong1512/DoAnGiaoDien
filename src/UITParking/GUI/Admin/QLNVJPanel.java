/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UITParking.GUI.Admin;

import UITParking.BUS.KhachHangBUS;
import UITParking.BUS.NguoiDungBUS;
import UITParking.BUS.NhanVienBUS;
import UITParking.BUS.XeBUS;
import UITParking.DTO.KhachHangDTO;
import UITParking.DTO.NguoiDungDTO;
import UITParking.DTO.NhanVienDTO;
import UITParking.DTO.XeDTO;
import static UITParking.GUI.InitPublic.formatDate;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
/**
 *
 * @author ADMIN
 */
public class QLNVJPanel extends javax.swing.JPanel {

    /**
     * Creates new form QLNVJPanel
     */
    NguoiDungBUS nguoidungtbl = new NguoiDungBUS();
    ArrayList<NguoiDungDTO> list_ND = nguoidungtbl.getList_ND();
    KhachHangBUS khachhangtbl = new KhachHangBUS();
    ArrayList<KhachHangDTO> list_KH = khachhangtbl.getList_KH();
    NhanVienBUS nhanvientbl = new NhanVienBUS();
    ArrayList<NhanVienDTO> list_NV = nhanvientbl.getlist_NV();

    private DefaultTableModel model;
    private String[] columnHeaders = new String[]{"STT", "Mã KH", "Họ Tên", "Email", "Ngày Sinh",
        "Giới Tính", "Địa Chỉ", "Quê Quán", "Số Điện Thoại"};

    private TableRowSorter<TableModel> rowSorter = null;

    public QLNVJPanel() throws Exception {
        initComponents();
        initTable();
        hoTroTimKiem();
        txtMaNV.setEnabled(false);
        txtEmail.setEnabled(false);
        disablePassword();
    }
    
    public class EmailExample {

        private Pattern pattern, pattern1, pattern2;
        private Matcher matcher, matcher1, matcher2;

        private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
        private static final String EMAIL_REGEX1 = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)+(\\.[A-Za-z0-9]+)$";
        private static final String EMAIL_REGEX2 = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)+(\\.[A-Za-z0-9]+)+(\\.[A-Za-z0-9]+)$";

        public EmailExample() {
            pattern = Pattern.compile(EMAIL_REGEX);
            pattern1 = Pattern.compile(EMAIL_REGEX1);
            pattern2 = Pattern.compile(EMAIL_REGEX2);
        }

        public boolean validate(String regex) {
            matcher = pattern.matcher(regex);
            matcher1 = pattern1.matcher(regex);
            matcher2 = pattern2.matcher(regex);
            return matcher.matches() || matcher1.matches() || matcher2.matches();
        }
    }
    
    public void disablePassword() {
        txtMatKhau.setVisible(false);
        lblMatKhau.setVisible(false);
    }
    
    public void enablePassword() {
        txtMatKhau.setVisible(true);
        lblMatKhau.setVisible(true);
    }

    public void resetRender() {
        txtMaNV.setText("");
        txtHoTen.setText("");
        txtEmail.setText("");
        txtDiaChi.setText("");
        txtQueQuan.setText("");
        txtSDT.setText("");
        txtMaNV.setText("");
        txtMatKhau.setText("");
        //clear Selection Group
        btnGroupGioiTinh.clearSelection();
        jdcNgaySinh.setDate(null);

    }

    public void initTable() throws Exception {
        model = new DefaultTableModel();
        model.setColumnIdentifiers(columnHeaders);
        int index = 1;
        for (NhanVienDTO nv : list_NV) {
            //Lấy ra xe và biển số xe của khách hàng

            NguoiDungDTO nd = nguoidungtbl.getInfor(nv.getStrMaNV());
            //Cập nhật bảng
            model.addRow(new Object[]{index, nd.getStrMaND(), nd.getStrHoTen(), nd.getStrEmail(),
                (nd.getDateNgSinh() != null ? formatDate(nd.getDateNgSinh()) : nd.getDateNgSinh()), 
                nd.getStrGioiTinh(), nd.getStrDiaChi(),
                nd.getStrQueQuan(), nd.getStrSDT()});
            index++;
        }

        tblNhanVien.setModel(model);

    }

    public void hoTroTimKiem() {

        rowSorter = new TableRowSorter<>(tblNhanVien.getModel());
        tblNhanVien.setRowSorter(rowSorter);
        txtTimKiem.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = txtTimKiem.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = txtTimKiem.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
    }

    //Hàm cập nhật lại bảng sau khi thêm xóa sửa
    public void capNhatLaiTable() {
        list_ND = nguoidungtbl.getList_ND();
        model.setRowCount(0);
        int index = 1;
        for (NhanVienDTO nv : list_NV) {
            //Lấy ra xe và biển số xe của khách hàng

            NguoiDungDTO nd = nguoidungtbl.getInfor(nv.getStrMaNV());
            //Cập nhật bảng
            model.addRow(new Object[]{index, nd.getStrMaND(), nd.getStrHoTen(), nd.getStrEmail(),
                (nd.getDateNgSinh() != null ? formatDate(nd.getDateNgSinh()) : nd.getDateNgSinh()), 
                nd.getStrGioiTinh(), nd.getStrDiaChi(),
                nd.getStrQueQuan(), nd.getStrSDT()});
            index++;
        }
        model.fireTableDataChanged();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupGioiTinh = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel62 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
        txtQueQuan = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        rdbNam = new javax.swing.JRadioButton();
        rdbNu = new javax.swing.JRadioButton();
        jLabel67 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        jLabel68 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        jLabel69 = new javax.swing.JLabel();
        btnNhapMoi = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnTimKiem = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblNhanVien = new javax.swing.JTable();
        jdcNgaySinh = new com.toedter.calendar.JDateChooser();
        lblMatKhau = new javax.swing.JLabel();
        txtMatKhau = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel62.setText("Mã nhân viên");

        jLabel63.setText("Email");

        jLabel64.setText("Địa chỉ");

        jLabel65.setText("Quê quán");

        jLabel66.setText("Giới tính");

        btnGroupGioiTinh.add(rdbNam);
        rdbNam.setText("Nam");

        btnGroupGioiTinh.add(rdbNu);
        rdbNu.setText("Nữ");

        jLabel67.setText("Họ tên");

        jLabel68.setText("Ngày sinh");

        jLabel69.setText("Số điện thoại");

        btnNhapMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_available_updates_24px.png"))); // NOI18N
        btnNhapMoi.setText("Nhập mới");
        btnNhapMoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNhapMoibtnNhapMoiMouseClicked(evt);
            }
        });

        btnLuu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_new_copy_24px.png"))); // NOI18N
        btnLuu.setText("Lưu");
        btnLuu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLuubtnLuuMouseClicked(evt);
            }
        });

        btnCapNhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_installing_updates_24px.png"))); // NOI18N
        btnCapNhat.setText("Cập nhật");
        btnCapNhat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCapNhatbtnCapNhatMouseClicked(evt);
            }
        });

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_waste_24px.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnXoabtnXoaMouseClicked(evt);
            }
        });

        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_search_24px.png"))); // NOI18N
        btnTimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTimKiembtnTimKiemMouseClicked(evt);
            }
        });

        tblNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblNhanVien.setFillsViewportHeight(true);
        tblNhanVien.setShowGrid(false);
        tblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblNhanVientblNhanVienMousePressed(evt);
            }
        });
        jScrollPane7.setViewportView(tblNhanVien);

        lblMatKhau.setText("Mật khẩu");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(192, 192, 192)
                        .addComponent(btnNhapMoi)
                        .addGap(30, 30, 30)
                        .addComponent(btnLuu)
                        .addGap(30, 30, 30)
                        .addComponent(btnCapNhat)
                        .addGap(30, 30, 30)
                        .addComponent(btnXoa)
                        .addGap(0, 0, 0)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(rdbNam)
                        .addGap(10, 10, 10)
                        .addComponent(rdbNu))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jdcNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jLabel69)
                        .addGap(10, 10, 10)
                        .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(txtQueQuan, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(lblMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnTimKiem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)))
                .addContainerGap(207, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(rdbNam))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(rdbNu)))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel63)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jdcNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel69)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel64)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtQueQuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnNhapMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblNhanVientblNhanVienMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanVientblNhanVienMousePressed
        // TODO add your handling code here:
        btnLuu.setEnabled(false);
        resetRender();
        int selectedRow = tblNhanVien.getSelectedRow();
        if (selectedRow >= 0) {

            NhanVienDTO nv = list_NV.get(selectedRow);
            NguoiDungDTO nd = nguoidungtbl.getInfor(nv.getStrMaNV());

            txtMaNV.setText(nd.getStrMaND());
            txtEmail.setText(nd.getStrEmail());
            txtHoTen.setText(nd.getStrHoTen());
            txtDiaChi.setText(nd.getStrDiaChi());
            txtQueQuan.setText(nd.getStrQueQuan());
            txtSDT.setText(nd.getStrSDT());
            rdbNam.setSelected(nd.getStrGioiTinh().equals("Nam"));
            rdbNu.setSelected(nd.getStrGioiTinh().equals("Nu"));

            txtMatKhau.setText(nd.getStrMatKhau());

            if (nd.getDateNgSinh() != null) {
                jdcNgaySinh.setDate(nd.getDateNgSinh());
            }
            txtEmail.setEnabled(false);
            disablePassword();
        }
    }//GEN-LAST:event_tblNhanVientblNhanVienMousePressed

    private void btnTimKiembtnTimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTimKiembtnTimKiemMouseClicked
        // TODO add your handling code here:
        if (txtMaNV.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Mã nhân viên phải được nhập để tìm kiếm");
            return;
        }

        try {
            NguoiDungBUS nguoidungtbl = new NguoiDungBUS();
            NguoiDungDTO nd = nguoidungtbl.getInfor(txtMaNV.getText());

            if (nd != null) {
                txtMaNV.setText(nd.getStrMaND());
                txtEmail.setText(nd.getStrEmail());
                txtHoTen.setText(nd.getStrHoTen());
                txtDiaChi.setText(nd.getStrDiaChi());
                txtQueQuan.setText(nd.getStrQueQuan());
                txtSDT.setText(nd.getStrSDT());
                rdbNam.setSelected(nd.getStrGioiTinh().equals("Nam"));
                rdbNu.setSelected(nd.getStrGioiTinh().equals("Nu"));
            } else {
                JOptionPane.showMessageDialog(this, "Nhân viên không tìm thấy");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnTimKiembtnTimKiemMouseClicked

    private void btnXoabtnXoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoabtnXoaMouseClicked
        // TODO add your handling code here:
        StringBuilder sb = new StringBuilder();
        
        if (sb.length() > 0) {
            JOptionPane.showMessageDialog(this, sb);
            return;
        }

        if (JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không?") == JOptionPane.NO_OPTION) {
            return;
        }
        try {
            System.out.println(txtMaNV.getText());
            NguoiDungDTO nd = nguoidungtbl.getInfor(txtMaNV.getText());
            NhanVienDTO nv = nhanvientbl.getInfor(txtMaNV.getText());
            nhanvientbl.xoa(nv);
            nguoidungtbl.xoa(nd);
            

            JOptionPane.showMessageDialog(this, "Nhân viên đã xóa khỏi CSDL");

            //Reset lại render
            resetRender();

            //Cập nhật lại bảng
            capNhatLaiTable();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error" + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnXoabtnXoaMouseClicked

    private void btnCapNhatbtnCapNhatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCapNhatbtnCapNhatMouseClicked
        // TODO add your handling code here:
        StringBuilder sb = new StringBuilder();
        if (nguoidungtbl.getInfor(txtMaNV.getText()) == null) {
            sb.append("Mã nhân viên không tồn tại.");
        }
        if (nhanvientbl.getInfor(txtMaNV.getText()) == null) {
            sb.append("Mã nhân viên không tồn tại.");
        }

        if (sb.length() > 0) {
            JOptionPane.showMessageDialog(this, sb);
            return;
        }
        if (JOptionPane.showConfirmDialog(this, "Bạn có muốn cập nhật không?") == JOptionPane.NO_OPTION) {
            return;
        }
        try {
            NguoiDungDTO nd = new NguoiDungDTO();
            NhanVienDTO nv = new NhanVienDTO();
            nd.setStrMaND(txtMaNV.getText());
            nd.setStrEmail(txtEmail.getText());
            nd.setStrHoTen(txtHoTen.getText());
            nd.setStrDiaChi(txtDiaChi.getText());
            nd.setStrQueQuan(txtQueQuan.getText());
            nd.setStrSDT(txtSDT.getText());
            nd.setStrGioiTinh(rdbNam.isSelected() ? "Nam" : "Nu");
            nv.setStrMaNV(txtMaNV.getText());
            nd.setStrMatKhau("long2002");
            if (jdcNgaySinh.getDate() != null) {
                nd.setDateNgSinh(new java.sql.Date(jdcNgaySinh.getDate().getTime()));
            }
            nd.setStrVaiTro("Nhan vien");
            nv.setStrViTriNhanVien("Quan ly");
            nguoidungtbl.sua(nd);
            nhanvientbl.sua(nv);
            //Cập nhật lại Table
            capNhatLaiTable();

            JOptionPane.showMessageDialog(this, "Nhân viên đã được cập nhật vào CSDL");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error" + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnCapNhatbtnCapNhatMouseClicked

    private void btnLuubtnLuuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLuubtnLuuMouseClicked

        StringBuilder sb = new StringBuilder();
        if (nguoidungtbl.getInfor(txtMaNV.getText()) != null) {
            sb.append("Mã nhân viên đã tồn tại.");
        }
        if (nhanvientbl.getInfor(txtMaNV.getText()) != null) {
            sb.append("Mã nhân viên đã tồn tại.");
        }
        
        Calendar c1 = Calendar.getInstance();
        c1.set(Calendar.MONTH, 5);

        // set Date
        c1.set(Calendar.DATE, 26);

        // set Year
        c1.set(Calendar.YEAR, 2005);

        Date dateToday = c1.getTime();
        if (jdcNgaySinh.getDate().getTime() - dateToday.getTime() > 17*17*31536000) {
            sb.append("Người dùng chưa đủ 17 tuổi");
        }
        
        try {
            if (Integer.parseInt(txtSDT.getText()) < 0) {
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ");
            return;
        }

        if (txtMatKhau.getText().length() < 6) {
            JOptionPane.showMessageDialog(this, "Mật khẩu phải lớn hơn 6 kí tự");
            return;
        }

        EmailExample emailExample = new EmailExample();
        boolean isvalidEmail = emailExample.validate(txtEmail.getText());
        if (!isvalidEmail) {
            JOptionPane.showMessageDialog(this, "Email không hợp lệ");
            return;
        }

        if (sb.length() > 0) {
            JOptionPane.showMessageDialog(this, sb);
            return;
        }
        try {
            String maNVTemp = nguoidungtbl.getMaxMaND();
            NguoiDungDTO nd = new NguoiDungDTO();
            NhanVienDTO nv = new NhanVienDTO();
            nd.setStrMaND(maNVTemp);
            nd.setStrEmail(txtEmail.getText());
            nd.setStrHoTen(txtHoTen.getText());
            nd.setStrDiaChi(txtDiaChi.getText());
            nd.setStrQueQuan(txtQueQuan.getText());
            nd.setStrSDT(txtSDT.getText());
            nd.setStrGioiTinh(rdbNam.isSelected() ? "Nam" : "Nu");
            nv.setStrMaNV(maNVTemp);
            nd.setStrMatKhau(txtMatKhau.getText());
            if (jdcNgaySinh.getDate() != null) {
                nd.setDateNgSinh(new java.sql.Date(jdcNgaySinh.getDate().getTime()));
            }
            nd.setStrVaiTro("Nhan vien");
            nv.setStrViTriNhanVien("Quan ly");
            nguoidungtbl.them(nd);
            nhanvientbl.them(nv);

            //Cập nhật lại Table
            capNhatLaiTable();
            JOptionPane.showMessageDialog(this, "Nhân viên mới đã được thêm vào CSDL");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error" + e.getMessage());
            e.printStackTrace();
        }
        disablePassword();
    }//GEN-LAST:event_btnLuubtnLuuMouseClicked

    private void btnNhapMoibtnNhapMoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNhapMoibtnNhapMoiMouseClicked
        resetRender();
        txtEmail.setEnabled(true);
        enablePassword();
        btnLuu.setEnabled(true);
    }//GEN-LAST:event_btnNhapMoibtnNhapMoiMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.ButtonGroup btnGroupGioiTinh;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnNhapMoi;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane7;
    private com.toedter.calendar.JDateChooser jdcNgaySinh;
    private javax.swing.JLabel lblMatKhau;
    private javax.swing.JRadioButton rdbNam;
    private javax.swing.JRadioButton rdbNu;
    private javax.swing.JTable tblNhanVien;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtMatKhau;
    private javax.swing.JTextField txtQueQuan;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
