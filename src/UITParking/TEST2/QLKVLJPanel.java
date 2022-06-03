/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UITParking.TEST2;

import UITParking.BUS.KhachHangBUS;
import UITParking.BUS.KhachVangLaiBUS;
import UITParking.BUS.NguoiDungBUS;
import UITParking.BUS.NhanVienBUS;
import UITParking.BUS.XeBUS;
import UITParking.DTO.KhachHangDTO;
import UITParking.DTO.KhachVangLaiDTO;
import UITParking.DTO.NguoiDungDTO;
import UITParking.DTO.NhanVienDTO;
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
public class QLKVLJPanel extends javax.swing.JPanel {

    /**
     * Creates new form QLKVLJPanel
     */
    
    KhachVangLaiBUS kvltbl = new KhachVangLaiBUS();
    ArrayList<KhachVangLaiDTO> list_KVL = kvltbl.getlist_KVL();
    XeBUS xetbl = new XeBUS();
    ArrayList<XeDTO> list_XE = xetbl.getlist_XE();
    
    private DefaultTableModel model;
    private String[] columnHeaders = new String[]{"STT","Mã Khách Vãng Lai", "Mã Xe", "Tên Loại Xe", "Biển Số Xe"};

    private TableRowSorter<TableModel> rowSorter = null;

    public QLKVLJPanel() throws Exception {
        initComponents();
        initTable();
        hoTroTimKiem();
        btnCapNhat.setEnabled(false);
//        btnCapNhat.setEnabled(false);
//        btnXoa.setEnabled(false);
//        btnLuu.setEnabled(false);
    }

    public void resetRender() {
        txtMaXe.setText("");
        txtBienSoXe.setText("");
        txtTenLoaiXe.setText("");
        txtMaTheKVL.setText("");
    }

    public void initTable() throws Exception {
        model = new DefaultTableModel();
        model.setColumnIdentifiers(columnHeaders);
        int index = 1;
        for (KhachVangLaiDTO kvl : list_KVL) {
            XeDTO xe = xetbl.getInfor(kvl.getStrMaXe());
            //Cập nhật bảng
            model.addRow(new Object[]{index, kvl.getStrMaTheKVL(), xe.getStrMaXe(),
                xe.getStrTenLoaiXe(),  xe.getStrBienSoXe()});
            index++;
        }

        tblKhachVangLai.setModel(model);

    }

    public void hoTroTimKiem() {

        rowSorter = new TableRowSorter<>(tblKhachVangLai.getModel());
        tblKhachVangLai.setRowSorter(rowSorter);
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
        for (KhachVangLaiDTO kvl : list_KVL) {
            XeDTO xe = xetbl.getInfor(kvl.getStrMaXe());
            //Cập nhật bảng
            model.addRow(new Object[]{index, kvl.getStrMaTheKVL(), xe.getStrMaXe(),
                xe.getStrTenLoaiXe(),  xe.getStrBienSoXe()});
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
        jPanel2 = new javax.swing.JPanel();
        jLabel62 = new javax.swing.JLabel();
        txtMaTheKVL = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        txtMaXe = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        txtTenLoaiXe = new javax.swing.JTextField();
        btnNhapMoi = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnTimKiem = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblKhachVangLai = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtBienSoXe = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel62.setText("Mã thẻ KVL");
        jPanel2.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 74, 20));

        txtMaTheKVL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaTheKVLActionPerformed(evt);
            }
        });
        jPanel2.add(txtMaTheKVL, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 250, -1));

        jLabel63.setText("Mã xe");
        jPanel2.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 74, -1));
        jPanel2.add(txtMaXe, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, 250, -1));

        jLabel64.setText("Tên lại xe");
        jPanel2.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 74, -1));

        txtTenLoaiXe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenLoaiXeActionPerformed(evt);
            }
        });
        jPanel2.add(txtTenLoaiXe, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, 250, -1));

        btnNhapMoi.setText("Nhập mới");
        btnNhapMoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNhapMoibtnNhapMoiMouseClicked(evt);
            }
        });
        btnNhapMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhapMoiActionPerformed(evt);
            }
        });
        jPanel2.add(btnNhapMoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, -1, -1));

        btnLuu.setText("Lưu");
        btnLuu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLuubtnLuuMouseClicked(evt);
            }
        });
        jPanel2.add(btnLuu, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 57, -1));

        btnCapNhat.setText("Cập nhật");
        btnCapNhat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCapNhatbtnCapNhatMouseClicked(evt);
            }
        });
        jPanel2.add(btnCapNhat, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, -1, -1));

        btnXoa.setText("Xóa");
        btnXoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnXoabtnXoaMouseClicked(evt);
            }
        });
        jPanel2.add(btnXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 160, -1, -1));

        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTimKiembtnTimKiemMouseClicked(evt);
            }
        });
        jPanel2.add(btnTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 160, -1, -1));
        jPanel2.add(txtTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 160, 144, -1));

        tblKhachVangLai.setModel(new javax.swing.table.DefaultTableModel(
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
        tblKhachVangLai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblKhachVangLaitblNhanVienMousePressed(evt);
            }
        });
        jScrollPane7.setViewportView(tblKhachVangLai);

        jPanel2.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 881, 250));

        jLabel1.setText("Biển số xe");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 74, -1));
        jPanel2.add(txtBienSoXe, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, 250, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 913, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
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

    private void btnNhapMoibtnNhapMoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNhapMoibtnNhapMoiMouseClicked
        resetRender();
    }//GEN-LAST:event_btnNhapMoibtnNhapMoiMouseClicked

    private void btnLuubtnLuuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLuubtnLuuMouseClicked
        StringBuilder sb = new StringBuilder();
        if (txtMaTheKVL.getText().equals("")) {
            sb.append("Mã thẻ khách vãng lai không được để trống.");
            txtMaTheKVL.setBackground(Color.red);
        }
        if(txtMaXe.getText().equals("")){
            sb.append("Mã xe không được để trống");
        }
        if (xetbl.getInfor(txtMaTheKVL.getText()) != null) {
            sb.append("Mã thẻ khách vãng lai đã tồn tại.");
        }
        if(xetbl.getInfor(txtMaXe.getText()) != null){
            sb.append("Mã xe đã tồn tại.");
        }

        if (sb.length() > 0) {
            JOptionPane.showMessageDialog(this, sb);
            return;
        }
        try {
            KhachVangLaiDTO kvl = new KhachVangLaiDTO();
            XeDTO xe = new XeDTO();
            kvl.setStrMaTheKVL(txtMaTheKVL.getText());
            kvl.setStrMaXe(txtMaXe.getText());
            xe.setStrMaXe(txtMaXe.getText());
            xe.setStrTenLoaiXe(txtTenLoaiXe.getText());
            xe.setStrBienSoXe(txtBienSoXe.getText());
            xetbl.them(xe);
            kvltbl.them(kvl);
            
            

            //Cập nhật lại Table
            capNhatLaiTable();
            JOptionPane.showMessageDialog(this, "Khách vãng lai mới đã được thêm vào CSDL");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error" + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnLuubtnLuuMouseClicked

    private void btnCapNhatbtnCapNhatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCapNhatbtnCapNhatMouseClicked
        // TODO add your handling code here:
//        StringBuilder sb = new StringBuilder();
//        if (txtMaTheKVL.getText().equals("")) {
//            sb.append("Mã thẻ khách vãng lai không được để trống.");
//            txtMaTheKVL.setBackground(Color.red);
//        } else {
//            txtMaTheKVL.setBackground(Color.white);
//        }
//        if (kvltbl.getInfor(txtMaTheKVL.getText()) == null) {
//            sb.append("Mã thẻ khách vãng lai không tồn tại.");
//        }
//        if (sb.length() > 0) {
//            JOptionPane.showMessageDialog(this, sb);
//            return;
//        }
//        try {
//            KhachHangDTO kvl = new KhachHangDTO();
//            XeDTO xe = xetbl.getInfor(txtMaTheKVL.getText());
//            xe.setStrMaXe(txtMaTheKVL.getText());
//            xe.setStrTenLoaiXe(txtMaXe.getText());
//            xe.setStrBienSoXe(txtTenLoaiXe.getText());
//            xetbl.sua(xe);
//            //Cập nhật lại Table
//            capNhatLaiTable();
//
//            JOptionPane.showMessageDialog(this, "Xe đã được cập nhật vào CSDL");
//
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(this, "Error" + e.getMessage());
//            e.printStackTrace();
//        }
    }//GEN-LAST:event_btnCapNhatbtnCapNhatMouseClicked

    private void btnXoabtnXoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoabtnXoaMouseClicked
        // TODO add your handling code here:
        StringBuilder sb = new StringBuilder();
        if (txtMaTheKVL.getText().equals("")) {
            sb.append("Mã khách vãng lai không được để trống.");
            txtMaTheKVL.setBackground(Color.red);
        } else {
            txtMaTheKVL.setBackground(Color.white);
        }
        if (sb.length() > 0) {
            JOptionPane.showMessageDialog(this, sb);
            return;
        }

        if (JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không?") == JOptionPane.NO_OPTION) {
            return;
        }
        try {
            KhachVangLaiDTO kvl = kvltbl.getInfor(txtMaTheKVL.getText());
            XeDTO xe = xetbl.getInfor(txtMaXe.getText());
            
            kvltbl.xoa(kvl);
            xetbl.xoa(xe);
            

            JOptionPane.showMessageDialog(this, "Khách vãng lai đã xóa khỏi CSDL");

            //Reset lại render
            resetRender();

            //Cập nhật lại bảng
            capNhatLaiTable();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error" + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnXoabtnXoaMouseClicked

    private void btnTimKiembtnTimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTimKiembtnTimKiemMouseClicked
       
    }//GEN-LAST:event_btnTimKiembtnTimKiemMouseClicked

    private void tblKhachVangLaitblNhanVienMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhachVangLaitblNhanVienMousePressed
        // TODO add your handling code here:
        resetRender();
        int selectedRow = tblKhachVangLai.getSelectedRow();
        if (selectedRow >= 0) {

            KhachVangLaiDTO kvl = list_KVL.get(selectedRow);
            XeDTO xe = xetbl.getInfor(kvl.getStrMaXe());

            txtMaTheKVL.setText(kvl.getStrMaTheKVL());
            txtMaXe.setText(kvl.getStrMaXe());
            txtTenLoaiXe.setText(xe.getStrTenLoaiXe());
            txtBienSoXe.setText(xe.getStrBienSoXe());

        }
    }//GEN-LAST:event_tblKhachVangLaitblNhanVienMousePressed

    private void btnNhapMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhapMoiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNhapMoiActionPerformed

    private void txtTenLoaiXeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenLoaiXeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenLoaiXeActionPerformed

    private void txtMaTheKVLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaTheKVLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaTheKVLActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnNhapMoi;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable tblKhachVangLai;
    private javax.swing.JTextField txtBienSoXe;
    private javax.swing.JTextField txtMaTheKVL;
    private javax.swing.JTextField txtMaXe;
    private javax.swing.JTextField txtTenLoaiXe;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
