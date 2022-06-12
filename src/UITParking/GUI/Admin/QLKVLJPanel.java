/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UITParking.GUI.Admin;

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
        btnXoa.setEnabled(false);
        txtMaTheKVL.setEnabled(false);
        txtMaXe.setEnabled(false);
        txtBienSoXe.setEnabled(false);
    }

    public void resetRender() {
        txtMaXe.setText("");
        txtBienSoXe.setText("");
        txtMaTheKVL.setText("");
        cbbLoaiXe.setSelectedItem("Xe đạp");
        txtBienSoXe.setEnabled(false);
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
        cbbLoaiXe = new javax.swing.JComboBox<>();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel62.setText("Mã thẻ KVL");

        txtMaTheKVL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaTheKVLActionPerformed(evt);
            }
        });

        jLabel63.setText("Mã xe");

        jLabel64.setText("Tên lại xe");

        btnNhapMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_available_updates_24px.png"))); // NOI18N
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
        tblKhachVangLai.setFillsViewportHeight(true);
        tblKhachVangLai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblKhachVangLaitblNhanVienMousePressed(evt);
            }
        });
        jScrollPane7.setViewportView(tblKhachVangLai);

        jLabel1.setText("Biển số xe");

        cbbLoaiXe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Xe đạp", "Xe máy" }));
        cbbLoaiXe.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbLoaiXeItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(txtMaTheKVL, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(txtMaXe, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(cbbLoaiXe, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 1180, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnNhapMoi)
                        .addGap(30, 30, 30)
                        .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnCapNhat)
                        .addGap(30, 30, 30)
                        .addComponent(btnXoa)
                        .addGap(95, 95, 95)
                        .addComponent(btnTimKiem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(txtBienSoXe, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaTheKVL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaXe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cbbLoaiXe, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBienSoXe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnNhapMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            String maKVLTemp = kvltbl.getMaxMaKVL();
            String maXeTemp = xetbl.getMaxMaXe();
            kvl.setStrMaTheKVL(maKVLTemp);
            kvl.setStrMaXe(maXeTemp);
            xe.setStrMaXe(maXeTemp);
            if (cbbLoaiXe.getSelectedItem().toString().equals("Xe đạp")) {
                xe.setStrTenLoaiXe("Xe dap");
                xe.setStrBienSoXe(null);
            } else {
                xe.setStrTenLoaiXe("Xe may");
                xe.setStrBienSoXe(txtBienSoXe.getText());
            }
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

    private void btnXoabtnXoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoabtnXoaMouseClicked
        // TODO add your handling code here:
//        StringBuilder sb = new StringBuilder();
//        if (txtMaTheKVL.getText().equals("")) {
//            sb.append("Mã khách vãng lai không được để trống.");
//            txtMaTheKVL.setBackground(Color.red);
//        } else {
//            txtMaTheKVL.setBackground(Color.white);
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
//            KhachVangLaiDTO kvl = kvltbl.getInfor(txtMaTheKVL.getText());
//            XeDTO xe = xetbl.getInfor(txtMaXe.getText());
//            
//            kvltbl.xoa(kvl);
//            xetbl.xoa(xe);
//            
//
//            JOptionPane.showMessageDialog(this, "Khách vãng lai đã xóa khỏi CSDL");
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
            if (xe.getStrTenLoaiXe().equals("Xe dap")) {
                cbbLoaiXe.setSelectedItem("Xe đạp");
            }
            if (xe.getStrTenLoaiXe().equals("Xe may")) {
                cbbLoaiXe.setSelectedItem("Xe máy");
            }
            txtBienSoXe.setText(xe.getStrBienSoXe());

        }
    }//GEN-LAST:event_tblKhachVangLaitblNhanVienMousePressed

    private void btnNhapMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhapMoiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNhapMoiActionPerformed

    private void txtMaTheKVLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaTheKVLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaTheKVLActionPerformed

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

    private void cbbLoaiXeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbLoaiXeItemStateChanged
        // TODO add your handling code here:
        if (cbbLoaiXe.getSelectedItem().toString().equals("Xe đạp")) {
            txtBienSoXe.setEnabled(false);
        } else {
            txtBienSoXe.setEnabled(true);
        }
    }//GEN-LAST:event_cbbLoaiXeItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnNhapMoi;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbbLoaiXe;
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
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
