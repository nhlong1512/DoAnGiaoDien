/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UITParking.GUI;

import UITParking.BUS.NguoiDungBUS;
import UITParking.DTO.NguoiDungDTO;
import static UITParking.GUI.login.pHoTen;
import static UITParking.GUI.login.pMaND;
import java.awt.Color;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class AccountCustomer extends javax.swing.JFrame {

    /**
     * Creates new form AccountCustomer
     */
    NguoiDungBUS nguoidungtbl = new NguoiDungBUS();
    NguoiDungDTO nd = nguoidungtbl.getInfor(pMaND);

    public AccountCustomer() throws Exception {
        initComponents();
        setIconImage();
        NguoiDungBUS nguoidungtbl = new NguoiDungBUS();
        NguoiDungDTO nd = nguoidungtbl.getInfor(pMaND);
        txtHoTenAccount.setText(nd.getStrHoTen());
        tfdHoTenAccount.setText(nd.getStrHoTen());
        tfdEmailAccount.setText(nd.getStrEmail());
        tfdDiachiAccount.setText(nd.getStrDiaChi());
        tfdQueQuanAccount.setText(nd.getStrQueQuan());
        tfdSDTAccount.setText(nd.getStrSDT());
        cbbGioiTinh.setSelectedItem(nd.getStrGioiTinh().equals("Nu") ? "Nữ" : "Nam");
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
        jLabel1 = new javax.swing.JLabel();
        txtHoTenAccount = new javax.swing.JLabel();
        btnThoatAccount = new javax.swing.JButton();
        btnHomeAccount = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfdQueQuanAccount = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfdHoTenAccount = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tfdEmailAccount = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfdSDTAccount = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tfdDiachiAccount = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cbbGioiTinh = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jdcNgaySinh = new com.toedter.calendar.JDateChooser();
        btnHuyAccount = new javax.swing.JButton();
        btnCapNhatAccount = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("UIT Parking");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 51, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_male_user_120px.png"))); // NOI18N

        txtHoTenAccount.setFont(new java.awt.Font("Cooper", 0, 18)); // NOI18N
        txtHoTenAccount.setForeground(new java.awt.Color(255, 255, 255));
        txtHoTenAccount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtHoTenAccount.setText("Name");

        btnThoatAccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logout.png"))); // NOI18N
        btnThoatAccount.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThoatAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThoatAccountMouseClicked(evt);
            }
        });
        btnThoatAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatAccountActionPerformed(evt);
            }
        });

        btnHomeAccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/home.png"))); // NOI18N
        btnHomeAccount.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHomeAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHomeAccountMouseClicked(evt);
            }
        });
        btnHomeAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeAccountActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtHoTenAccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(64, 64, 64))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(btnThoatAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnHomeAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtHoTenAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 239, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnHomeAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThoatAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 500));

        jLabel3.setFont(new java.awt.Font("Cooper", 1, 36)); // NOI18N
        jLabel3.setText("ACCOUNT");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 210, 70));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Quê quán");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 170, 70, -1));

        tfdQueQuanAccount.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        tfdQueQuanAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdQueQuanAccountActionPerformed(evt);
            }
        });
        jPanel1.add(tfdQueQuanAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 200, 240, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Họ tên");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, 50, -1));

        tfdHoTenAccount.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        tfdHoTenAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdHoTenAccountActionPerformed(evt);
            }
        });
        jPanel1.add(tfdHoTenAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, 240, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Email");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 100, 50, -1));

        tfdEmailAccount.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        tfdEmailAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdEmailAccountActionPerformed(evt);
            }
        });
        jPanel1.add(tfdEmailAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 130, 240, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Ngày sinh");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 310, 90, -1));

        tfdSDTAccount.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        tfdSDTAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdSDTAccountActionPerformed(evt);
            }
        });
        jPanel1.add(tfdSDTAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 270, 240, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Địa chỉ");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 170, 60, -1));

        tfdDiachiAccount.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        tfdDiachiAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdDiachiAccountActionPerformed(evt);
            }
        });
        jPanel1.add(tfdDiachiAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 200, 240, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Giới tính");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 240, 90, -1));

        cbbGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));
        cbbGioiTinh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cbbGioiTinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbGioiTinhActionPerformed(evt);
            }
        });
        jPanel1.add(cbbGioiTinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 270, 240, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Số điện thoại");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 240, 90, -1));
        jPanel1.add(jdcNgaySinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 340, 240, 30));

        btnHuyAccount.setBackground(new java.awt.Color(51, 51, 255));
        btnHuyAccount.setFont(new java.awt.Font("Cooper", 0, 14)); // NOI18N
        btnHuyAccount.setForeground(new java.awt.Color(255, 255, 255));
        btnHuyAccount.setText("Hủy");
        btnHuyAccount.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHuyAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHuyAccountMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHuyAccountMouseExited(evt);
            }
        });
        btnHuyAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyAccountActionPerformed(evt);
            }
        });
        jPanel1.add(btnHuyAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 430, 110, 40));

        btnCapNhatAccount.setBackground(new java.awt.Color(51, 51, 255));
        btnCapNhatAccount.setFont(new java.awt.Font("Cooper", 0, 14)); // NOI18N
        btnCapNhatAccount.setForeground(new java.awt.Color(255, 255, 255));
        btnCapNhatAccount.setText("Cập nhật");
        btnCapNhatAccount.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCapNhatAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCapNhatAccountMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCapNhatAccountMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCapNhatAccountMouseExited(evt);
            }
        });
        btnCapNhatAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatAccountActionPerformed(evt);
            }
        });
        jPanel1.add(btnCapNhatAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 430, 110, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnThoatAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatAccountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThoatAccountActionPerformed

    private void tfdQueQuanAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdQueQuanAccountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfdQueQuanAccountActionPerformed

    private void tfdHoTenAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdHoTenAccountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfdHoTenAccountActionPerformed

    private void tfdEmailAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdEmailAccountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfdEmailAccountActionPerformed

    private void tfdSDTAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdSDTAccountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfdSDTAccountActionPerformed

    private void tfdDiachiAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdDiachiAccountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfdDiachiAccountActionPerformed

    private void cbbGioiTinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbGioiTinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbGioiTinhActionPerformed

    private void btnHomeAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeAccountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHomeAccountActionPerformed

    private void btnHuyAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyAccountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHuyAccountActionPerformed

    private void btnCapNhatAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatAccountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCapNhatAccountActionPerformed

    private void btnCapNhatAccountMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCapNhatAccountMouseEntered
        btnCapNhatAccount.setBackground(new Color(80, 60, 244));

    }//GEN-LAST:event_btnCapNhatAccountMouseEntered

    private void btnCapNhatAccountMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCapNhatAccountMouseExited
        btnCapNhatAccount.setBackground(new Color(12, 33, 250));

    }//GEN-LAST:event_btnCapNhatAccountMouseExited

    private void btnHuyAccountMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHuyAccountMouseEntered
        btnHuyAccount.setBackground(new Color(80, 60, 244));
    }//GEN-LAST:event_btnHuyAccountMouseEntered

    private void btnHuyAccountMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHuyAccountMouseExited
        btnHuyAccount.setBackground(new Color(12, 33, 250));
    }//GEN-LAST:event_btnHuyAccountMouseExited

    private void btnThoatAccountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThoatAccountMouseClicked
        // TODO add your handling code here:
        login _login = new login();
        _login.show();
        dispose();
    }//GEN-LAST:event_btnThoatAccountMouseClicked

    //event click button home
    private void btnHomeAccountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeAccountMouseClicked
        // TODO add your handling code here:
        Homepage _homepage = null;
        try {
            _homepage = new Homepage();
        } catch (Exception ex) {
            Logger.getLogger(AccountCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        _homepage.show();
        dispose();
    }//GEN-LAST:event_btnHomeAccountMouseClicked

    //event click CapNhatAccount
    private void btnCapNhatAccountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCapNhatAccountMouseClicked
        // TODO add your handling code here:
        System.out.println(txtHoTenAccount.getText());
        System.out.println(tfdEmailAccount.getText());
        System.out.println(tfdDiachiAccount.getText());
        System.out.println(tfdQueQuanAccount.getText());
        System.out.println(tfdSDTAccount.getText());
        System.out.println(cbbGioiTinh.getSelectedItem().toString());

        nd.setStrHoTen(tfdHoTenAccount.getText());
        nd.setStrEmail(tfdEmailAccount.getText());
        nd.setStrDiaChi(tfdDiachiAccount.getText());
        nd.setStrQueQuan(tfdQueQuanAccount.getText());
        nd.setStrSDT(tfdSDTAccount.getText());
        if (cbbGioiTinh.getSelectedItem().toString().equals("Nữ")) {
            nd.setStrGioiTinh("Nu");
        }else{
            nd.setStrGioiTinh("Nam");
        }

        System.out.println(nd);

        try {
            nguoidungtbl.sua(nd);
            JOptionPane.showMessageDialog(null, "Cập nhật thành công");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Cập nhật thất bại");
        }


    }//GEN-LAST:event_btnCapNhatAccountMouseClicked

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
            java.util.logging.Logger.getLogger(AccountCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AccountCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AccountCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AccountCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new AccountCustomer().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(AccountCustomer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhatAccount;
    private javax.swing.JButton btnHomeAccount;
    private javax.swing.JButton btnHuyAccount;
    private javax.swing.JButton btnThoatAccount;
    private javax.swing.JComboBox<String> cbbGioiTinh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private com.toedter.calendar.JDateChooser jdcNgaySinh;
    private javax.swing.JTextField tfdDiachiAccount;
    private javax.swing.JTextField tfdEmailAccount;
    private javax.swing.JTextField tfdHoTenAccount;
    private javax.swing.JTextField tfdQueQuanAccount;
    private javax.swing.JTextField tfdSDTAccount;
    private javax.swing.JLabel txtHoTenAccount;
    // End of variables declaration//GEN-END:variables

    private void setIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icon/parking.png")));

    }
}
