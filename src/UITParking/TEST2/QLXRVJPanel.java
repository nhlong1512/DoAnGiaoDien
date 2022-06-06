/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UITParking.TEST2;
import UITParking.BUS.CTRaVaoBUS;
import UITParking.BUS.KhachHangBUS;
import UITParking.BUS.LoaiVeBUS;
import UITParking.BUS.NguoiDungBUS;
import UITParking.BUS.VeBUS;
import UITParking.BUS.XeBUS;
import UITParking.DTO.CTRaVaoDTO;
import UITParking.DTO.KhachHangDTO;
import UITParking.DTO.LoaiVeDTO;
import UITParking.DTO.NguoiDungDTO;
import UITParking.DTO.VeDTO;
import UITParking.DTO.XeDTO;
import java.awt.Color;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class QLXRVJPanel extends javax.swing.JPanel {

    NguoiDungBUS nguoidungtbl = new NguoiDungBUS();
    ArrayList<NguoiDungDTO> list_ND = nguoidungtbl.getList_ND();
    KhachHangBUS khachhangtbl = new KhachHangBUS();
    ArrayList<KhachHangDTO> list_KH = khachhangtbl.getList_KH();
    LoaiVeBUS loaivetbl = new LoaiVeBUS();
    ArrayList<LoaiVeDTO> list_LV = loaivetbl.getList_LV();
    VeBUS vetbl = new VeBUS();
    ArrayList<VeDTO> list_Ve = vetbl.getList_Ve();
    CTRaVaoBUS ctrvtbl = new CTRaVaoBUS();
    ArrayList<CTRaVaoDTO> list_CTRV = ctrvtbl.getList_CTRV();

    private DefaultTableModel model;
    private String[] columnHeaders = new String[]{"STT", "Mã CT Ra Vào", "Thời Gian Vào",
        "Thời Gian Ra", "Mã Khách Hàng", "Mã Xe", "Mã Thẻ KVL"};

    private TableRowSorter<TableModel> rowSorter = null;
    /**
     * Creates new form QLDTJPanel
     */
    public QLXRVJPanel() throws Exception {
        initComponents();
        initTable();
        hoTroTimKiem();
    }

    public void resetRender() {
        txtMaCTRaVao.setText("");
        txtMaKhachHang.setText("");
        txtMaXe.setText("");
        txtMaTheKVL.setText("");
        jdcThoiGianRa.setDate(null);
        jdcThoiGianVao.setDate(null);

    }

    public void updateRender() {
        //Reset txtMaLoaiVe theo tên loại vé
//        if (cbbTenLoaiVe.getSelectedItem().toString().equals("Vé lượt xe máy")) {
//            txtMaLoaiVe.setText("LVE01");
//            jdcNgayHetHan.setDate(null);
//            jdcNgayKichHoat.setDate(null);
//            txtTrangThai.setText("Chưa kích hoạt");
//
//        }
//        if (cbbTenLoaiVe.getSelectedItem().toString().equals("Vé lượt xe đạp")) {
//            txtMaLoaiVe.setText("LVE02");
//            jdcNgayHetHan.setDate(null);
//            jdcNgayKichHoat.setDate(null);
//            txtTrangThai.setText("Chưa kích hoạt");
//        }
//        if (cbbTenLoaiVe.getSelectedItem().toString().equals("Vé tuần")) {
//            txtMaLoaiVe.setText("LVE03");
//        }
//        if (cbbTenLoaiVe.getSelectedItem().toString().equals("Vé tháng")) {
//            txtMaLoaiVe.setText("LVE04");
//        }
    }

    public void initTable() throws Exception {
        model = new DefaultTableModel();
        model.setColumnIdentifiers(columnHeaders);
        int index = 1;
        for (CTRaVaoDTO ctrv : list_CTRV) {
            //Lấy ra xe và biển số xe của khách hàng

//            LoaiVeDTO lv = loaivetbl.getInfor(ve.getStrMaLoaiVe());
            //Cập nhật bảng
            model.addRow(new Object[]{index, ctrv.getStrMaCTRaVao(), ctrv.getDateThoiGianVao(),
                ctrv.getDateThoiGianRa(), ctrv.getStrMaKH() == null ? "null" : ctrv.getStrMaKH(), ctrv.getStrMaXe(), 
                ctrv.getStrMaTheKVL() == null ? "null" : ctrv.getStrMaTheKVL()});
            index++;
        }

        tblChiTietRaVao.setModel(model);

    }

    public void hoTroTimKiem() {

        rowSorter = new TableRowSorter<>(tblChiTietRaVao.getModel());
        tblChiTietRaVao.setRowSorter(rowSorter);
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
        model.setRowCount(0);
        int index = 1;
        for (CTRaVaoDTO ctrv : list_CTRV) {
            //Lấy ra xe và biển số xe của khách hàng

//            LoaiVeDTO lv = loaivetbl.getInfor(ve.getStrMaLoaiVe());
            //Cập nhật bảng
            model.addRow(new Object[]{index, ctrv.getStrMaCTRaVao(), ctrv.getDateThoiGianVao(),
                ctrv.getDateThoiGianRa(), ctrv.getStrMaKH() == null ? "null" : ctrv.getStrMaKH(), ctrv.getStrMaXe(), 
                ctrv.getStrMaTheKVL() == null ? "null" : ctrv.getStrMaTheKVL()});
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

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtMaCTRaVao = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtMaXe = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtMaTheKVL = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btnNhapMoi = new javax.swing.JButton();
        btnXeVao = new javax.swing.JButton();
        btnXeRa = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnTimKiem = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblChiTietRaVao = new javax.swing.JTable();
        jdcThoiGianVao = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtMaNhanVien = new javax.swing.JTextField();
        jdcThoiGianRa = new com.toedter.calendar.JDateChooser();
        txtMaKhachHang = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtBienSoXe = new javax.swing.JTextField();
        cbbLoaiXe = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Mã CT Ra Vào");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 90, 22));

        txtMaCTRaVao.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtMaCTRaVaoCaretUpdate(evt);
            }
        });
        jPanel1.add(txtMaCTRaVao, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 190, -1));

        jLabel3.setText("Mã Xe");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 90, 20));
        jPanel1.add(txtMaXe, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 190, -1));

        jLabel7.setText("Mã Nhân Viên");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 82, 20));

        jLabel8.setText("Thời Gian Vào");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, 87, 19));

        txtMaTheKVL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaTheKVLActionPerformed(evt);
            }
        });
        jPanel1.add(txtMaTheKVL, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 190, -1));

        jLabel9.setText("Mã Thẻ KVL");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 66, 21));

        btnNhapMoi.setText("Nhập mới");
        btnNhapMoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNhapMoiMouseClicked(evt);
            }
        });
        jPanel1.add(btnNhapMoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 170, -1, -1));

        btnXeVao.setText("Xe Vào");
        btnXeVao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnXeVaoMouseClicked(evt);
            }
        });
        jPanel1.add(btnXeVao, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 80, -1));

        btnXeRa.setText("Xe Ra");
        btnXeRa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnXeRaMouseClicked(evt);
            }
        });
        jPanel1.add(btnXeRa, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 90, -1));

        btnXoa.setText("Xóa");
        btnXoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnXoaMouseClicked(evt);
            }
        });
        jPanel1.add(btnXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 170, -1, -1));

        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTimKiemMouseClicked(evt);
            }
        });
        jPanel1.add(btnTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 170, -1, -1));
        jPanel1.add(txtTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 170, 144, -1));

        tblChiTietRaVao.setModel(new javax.swing.table.DefaultTableModel(
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
        tblChiTietRaVao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblChiTietRaVaoMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblChiTietRaVao);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 926, 247));
        jPanel1.add(jdcThoiGianVao, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 60, 200, -1));

        jLabel11.setText("Thời Gian Ra");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 60, 70, 19));

        jLabel13.setText("Mã Khách Hàng");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(655, 19, 70, 20));
        jPanel1.add(txtMaNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, 180, -1));
        jPanel1.add(jdcThoiGianRa, new org.netbeans.lib.awtextra.AbsoluteConstraints(739, 60, 180, -1));
        jPanel1.add(txtMaKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(737, 20, 180, -1));

        jLabel10.setText("Loại Xe");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, 82, 20));

        jLabel12.setText("Biển Số Xe");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 110, 70, 20));
        jPanel1.add(txtBienSoXe, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 110, 180, -1));

        cbbLoaiXe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Xe máy", "Xe đạp" }));
        jPanel1.add(cbbLoaiXe, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, 180, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtMaCTRaVaoCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtMaCTRaVaoCaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaCTRaVaoCaretUpdate

    private void txtMaTheKVLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaTheKVLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaTheKVLActionPerformed

    private void btnNhapMoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNhapMoiMouseClicked
//        resetRender();
    }//GEN-LAST:event_btnNhapMoiMouseClicked

    private void btnXeVaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXeVaoMouseClicked
//        StringBuilder sb = new StringBuilder();
//        if (txtMaVe.getText().equals("")) {
//            sb.append("Mã vé không được để trống.");
//            txtMaVe.setBackground(Color.red);
//        } else {
//            txtMaVe.setBackground(Color.white);
//        }
//        if (vetbl.getInfor(txtMaVe.getText()) != null) {
//            sb.append("Mã vé đã tồn tại.");
//        }
//
//        if (sb.length() > 0) {
//            JOptionPane.showMessageDialog(this, sb);
//            return;
//        }
//        try {
//            VeDTO ve = new VeDTO();
//            LoaiVeDTO lv = new LoaiVeDTO();
//            ve.setStrMaVe(txtMaVe.getText());
//            ve.setStrMaKH(txtMaKH.getText());
//            updateRender();
//            ve.setStrMaLoaiVe(txtMaLoaiVe.getText());
//            ve.setStrTrangThai(txtTrangThai.getText());
//
//            if (jdcNgayKichHoat.getDate() != null) {
//                ve.setDateNgayKichHoat(new java.sql.Date(jdcNgayKichHoat.getDate().getTime()));
//            } else {
//                ve.setDateNgayKichHoat(null);
//            }
//
//            if (jdcNgayHetHan.getDate() != null) {
//                ve.setDateNgayHetHan(new java.sql.Date(jdcNgayHetHan.getDate().getTime()));
//            } else {
//                ve.setDateNgayHetHan(null);
//            }
//
//            vetbl.them(ve);
//
//            //Cập nhật lại Table
//            capNhatLaiTable();
//            JOptionPane.showMessageDialog(this, "Khách hàng mới đã được thêm vào CSDL");
//
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(this, "Error" + e.getMessage());
//            e.printStackTrace();
//        }
    }//GEN-LAST:event_btnXeVaoMouseClicked

    private void btnXeRaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXeRaMouseClicked
        // TODO add your handling code here:
//        StringBuilder sb = new StringBuilder();
//        if (txtMaVe.getText().equals("")) {
//            sb.append("Mã vé không được để trống.");
//            txtMaVe.setBackground(Color.red);
//        } else {
//            txtMaVe.setBackground(Color.white);
//        }
//        if (vetbl.getInfor(txtMaVe.getText()) == null) {
//            sb.append("Mã vé không tồn tại.");
//        }
//        if (khachhangtbl.getInfor(txtMaKH.getText()) == null) {
//            sb.append("Mã khách hàng không tồn tại.");
//        }
//        if (loaivetbl.getInfor(txtMaLoaiVe.getText()) == null) {
//            sb.append("Mã loại vé không tồn tại.");
//        }
//        if (sb.length() > 0) {
//            JOptionPane.showMessageDialog(this, sb);
//            return;
//        }
//        try {
//            VeDTO ve = new VeDTO();
//            LoaiVeDTO lv = new LoaiVeDTO();
//            ve.setStrMaVe(txtMaVe.getText());
//            ve.setStrMaKH(txtMaKH.getText());
//
//            ve.setStrTrangThai(txtTrangThai.getText());
//            lv.setStrTenLoaiVe(cbbTenLoaiVe.getSelectedItem().toString());
//
//            updateRender();
//
//            System.out.println(jdcNgayKichHoat.getDate());
//            System.out.println(jdcNgayHetHan.getDate());
//            ve.setStrMaLoaiVe(txtMaLoaiVe.getText());
//            lv.setStrMaLoaiVe(txtMaLoaiVe.getText());
//
//            if (jdcNgayKichHoat.getDate() != null) {
//                ve.setDateNgayKichHoat(new java.sql.Date(jdcNgayKichHoat.getDate().getTime()));
//            } else {
//                ve.setDateNgayKichHoat(null);
//            }
//
//            if (jdcNgayHetHan.getDate() != null) {
//                ve.setDateNgayHetHan(new java.sql.Date(jdcNgayHetHan.getDate().getTime()));
//            } else {
//                ve.setDateNgayHetHan(null);
//            }
//            vetbl.sua(ve);
//
//            //Cập nhật lại Table
//            capNhatLaiTable();
//
//            JOptionPane.showMessageDialog(this, "Vé đã được cập nhật vào CSDL");
//
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(this, "Error" + e.getMessage());
//            e.printStackTrace();
//        }
    }//GEN-LAST:event_btnXeRaMouseClicked

    private void btnXoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaMouseClicked
        // TODO add your handling code here:
//        StringBuilder sb = new StringBuilder();
//        if (txtMaVe.getText().equals("")) {
//            sb.append("Mã vé không được để trống.");
//            txtMaVe.setBackground(Color.red);
//        } else {
//            txtMaVe.setBackground(Color.white);
//        }
//        if (sb.length() > 0) {
//            JOptionPane.showMessageDialog(this, sb);
//            return;
//        }
//
//        if (JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không?") == JOptionPane.NO_OPTION) {
//            return;
//        }
//        try {
//            VeDTO ve = vetbl.getInfor(txtMaVe.getText());
//            vetbl.xoa(ve);
//
//            JOptionPane.showMessageDialog(this, "Vé đã xóa khỏi CSDL");
//
//            //Reset lại render
//            resetRender();
//
//            //Cập nhật lại bảng
//            capNhatLaiTable();
//
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(this, "Error" + e.getMessage());
//            e.printStackTrace();
//        }
    }//GEN-LAST:event_btnXoaMouseClicked

    private void btnTimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTimKiemMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTimKiemMouseClicked

    private void tblChiTietRaVaoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblChiTietRaVaoMousePressed
        // TODO add your handling code here:
//        resetRender();
//        int selectedRow = tblVe.getSelectedRow();
//        if (selectedRow >= 0) {
//
//            VeDTO ve = list_Ve.get(selectedRow);
//            LoaiVeDTO lv = loaivetbl.getInfor(ve.getStrMaLoaiVe());
//
//            txtMaVe.setText(ve.getStrMaVe());
//            txtMaKH.setText(ve.getStrMaKH());
//            txtMaLoaiVe.setText(ve.getStrMaLoaiVe());
//            txtTrangThai.setText(ve.getStrTrangThai());
//            cbbTenLoaiVe.setSelectedItem(lv.getStrTenLoaiVe());
//
//            if (ve.getDateNgayKichHoat() != null) {
//                jdcNgayKichHoat.setDate(ve.getDateNgayKichHoat());
//            }
//            if (ve.getDateNgayHetHan() != null) {
//                jdcNgayHetHan.setDate(ve.getDateNgayHetHan());
//            }
//        }
    }//GEN-LAST:event_tblChiTietRaVaoMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNhapMoi;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXeRa;
    private javax.swing.JButton btnXeVao;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbbLoaiXe;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdcThoiGianRa;
    private com.toedter.calendar.JDateChooser jdcThoiGianVao;
    private javax.swing.JTable tblChiTietRaVao;
    private javax.swing.JTextField txtBienSoXe;
    private javax.swing.JTextField txtMaCTRaVao;
    private javax.swing.JTextField txtMaKhachHang;
    private javax.swing.JTextField txtMaNhanVien;
    private javax.swing.JTextField txtMaTheKVL;
    private javax.swing.JTextField txtMaXe;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
