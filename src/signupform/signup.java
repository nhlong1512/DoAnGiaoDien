/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package signupform;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class signup extends javax.swing.JFrame {

    Connection conn = null;
    PreparedStatement ps = null, ps1 = null, ps2 = null;
    ResultSet rs = null, rs1 = null, rs2 = null;

    /**
     * Creates new form signup
     */
    public signup() {
        initComponents();
        txtusername.setBackground(new java.awt.Color(0, 0, 0, 1));
        txtfirstname.setBackground(new java.awt.Color(0, 0, 0, 1));
        txtlastname.setBackground(new java.awt.Color(0, 0, 0, 1));
        txtpassword.setBackground(new java.awt.Color(0, 0, 0, 1));
        txtconfirmpassword.setBackground(new java.awt.Color(0, 0, 0, 1));

    }

    //Code kiểm tra tính hợp lệ của email
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        button1 = new java.awt.Button();
        txtusername = new javax.swing.JTextField();
        txtfirstname = new javax.swing.JTextField();
        txtlastname = new javax.swing.JTextField();
        txtconfirmpassword = new javax.swing.JPasswordField();
        txtpassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(871, 440));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Mobile login-rafiki (3).jpg"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 420, 450));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 520));

        jPanel2.setBackground(new java.awt.Color(25, 118, 211));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("X");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(384, 0, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Hello!");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 31, 403, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(199, 226, 255));
        jLabel4.setText("Username");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 270, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(199, 226, 255));
        jLabel5.setText("Password");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, 270, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(199, 226, 255));
        jLabel8.setText("Firts Name");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 270, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(199, 226, 255));
        jLabel10.setText("Last Name");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 270, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(199, 226, 255));
        jLabel12.setText("Confirm Password");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, 270, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Please sign up to continue!");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 69, 420, -1));

        button1.setBackground(new java.awt.Color(255, 255, 255));
        button1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        button1.setForeground(new java.awt.Color(25, 118, 211));
        button1.setLabel("SIGN UP");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        jPanel2.add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 450, 300, 38));

        txtusername.setBackground(new java.awt.Color(25, 118, 211));
        txtusername.setFont(txtusername.getFont());
        txtusername.setForeground(new java.awt.Color(255, 255, 255));
        txtusername.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        txtusername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusernameActionPerformed(evt);
            }
        });
        jPanel2.add(txtusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 240, 30));

        txtfirstname.setBackground(new java.awt.Color(25, 118, 211));
        txtfirstname.setFont(txtfirstname.getFont());
        txtfirstname.setForeground(new java.awt.Color(255, 255, 255));
        txtfirstname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        txtfirstname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfirstnameActionPerformed(evt);
            }
        });
        jPanel2.add(txtfirstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 240, 30));

        txtlastname.setBackground(new java.awt.Color(25, 118, 211));
        txtlastname.setFont(txtlastname.getFont());
        txtlastname.setForeground(new java.awt.Color(255, 255, 255));
        txtlastname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        txtlastname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtlastnameActionPerformed(evt);
            }
        });
        jPanel2.add(txtlastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 240, 30));

        txtconfirmpassword.setBackground(new java.awt.Color(25, 118, 211));
        txtconfirmpassword.setFont(txtconfirmpassword.getFont());
        txtconfirmpassword.setForeground(new java.awt.Color(255, 255, 255));
        txtconfirmpassword.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        txtconfirmpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtconfirmpasswordActionPerformed(evt);
            }
        });
        jPanel2.add(txtconfirmpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, 240, 30));

        txtpassword.setBackground(new java.awt.Color(25, 118, 211));
        txtpassword.setFont(txtpassword.getFont());
        txtpassword.setForeground(new java.awt.Color(255, 255, 255));
        txtpassword.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        txtpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpasswordActionPerformed(evt);
            }
        });
        jPanel2.add(txtpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, 240, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, 420, 520));

        setSize(new java.awt.Dimension(863, 513));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel1MouseClicked

    //Event click button Sign Up
    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        // TODO add your handling code here:
        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "hr", "hr");
            String sql = "INSERT INTO NGUOIDUNG (MaND, Email, MatKhau, HoTen) VALUES (?, ?, ?, ?)";
            String countMaND = "Select count(MaND) as countND from NguoiDung";
            String checkEmailExist = "Select count(MaND) as countEmail from NguoiDung where Email = ?";
            ps = conn.prepareStatement(sql);
            ps1 = conn.prepareStatement(countMaND);
            rs1 = ps1.executeQuery();
            ps2 = conn.prepareStatement(checkEmailExist);
            
            //Thực thi checkEmailExist - Kiểm tra email đã tồn tại trong database hay chưa.
            ps2.setString(1, txtusername.getText());
            rs2 = ps2.executeQuery();
            
            StringBuilder sb = new StringBuilder();
            //Kiểm tra tính hợp lệ của email khi đăng ký
            EmailExample emailExample = new EmailExample();
            boolean isvalid = emailExample.validate(txtusername.getText());
            //Kiểm tra thông tin không được bỏ trống.
            if(txtusername.getText().equals("")){
                sb.append("Please Enter Your User Name!");
            }
            else if(txtfirstname.getText().equals("")){
                sb.append("Please Enter Your FirstName!");
            }
            else if(txtlastname.getText().equals("")){
                sb.append("Please Enter Your LastName!");
            }
            else if(new String(txtpassword.getPassword()).equals("")){
                sb.append("Please Enter Your Password!");
            }
            //Kiểm tra nếu mật khẩu bé hơn 8 kí tự thì thông báo 
            //Mật khẩu phải ít nhất 8 kí tự
            else if(new String(txtpassword.getPassword()).length()<8){
                sb.append("Password must be at least 8 characters.");
            }
            else if(new String(txtconfirmpassword.getPassword()).equals("")){
                sb.append("Please Enter Your Confirm Password!");
            }
            //Kiểm tra xem mật khẩu confirm có trùng khớp với mật khẩu ban đầu.
            //Nếu mật khẩu không trùng khớp, thông báo ra người dùng.
            else if (!new String(txtpassword.getPassword()).equals(new String(txtconfirmpassword.getPassword()))) {
                sb.append("Invalid Confirm Password");
            }
            //Nếu email không hợp lệ thông báo ra người dùng.
            else if(!isvalid){
                sb.append("Invalid Email");
            }
            else if(rs2.next()){
                if(rs2.getInt("countEmail") > 0){
                    sb.append("Email Already Exists");
                }
            }
            
            //Nếu độ dài sb lớn hơn 0 - có lỗi thì hiện ra thông báo lỗi
            if (sb.length() > 0) {
                JOptionPane.showMessageDialog(this, sb);
                return;
            }
            
            
            
//            ps.setString(1, new String(txtpassword.getPassword()));
            if (rs1.next()) {
                ps.setString(1, "ND" + String.valueOf(rs1.getInt("countND") + 1));
            }
            
            ps.setString(2, txtusername.getText());

            ps.setString(3, new String(txtpassword.getPassword()));

            ps.setString(4, (txtlastname.getText() + " " + txtfirstname.getText()));

            rs = ps.executeQuery();
            JOptionPane.showMessageDialog(this, "Sign Up Successfully");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_button1ActionPerformed

    private void txtusernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtusernameActionPerformed

    private void txtfirstnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfirstnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfirstnameActionPerformed

    private void txtlastnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtlastnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtlastnameActionPerformed

    private void txtconfirmpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtconfirmpasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtconfirmpasswordActionPerformed

    private void txtpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpasswordActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        for (double i = 0.0; i <= 1.0; i = i + 0.1) {
            String val = i + "";
            float f = Float.valueOf(val);
            this.setOpacity(f);
            try {
                Thread.sleep(50);
            } catch (Exception e) {

            }
        }
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new signup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField txtconfirmpassword;
    private javax.swing.JTextField txtfirstname;
    private javax.swing.JTextField txtlastname;
    private javax.swing.JPasswordField txtpassword;
    private javax.swing.JTextField txtusername;
    // End of variables declaration//GEN-END:variables
}
