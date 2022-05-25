/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UITParking.GUI;

import UITParking.DTO.DanhMucBean;
import UITParking.DTO.NguoiDungDTO;
import java.awt.List;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author ADMIN
 */
public class AdminMainFrame extends javax.swing.JFrame {

    /**
     * Creates new form AdminMainFrame
     */
    public AdminMainFrame() throws Exception {
        initComponents();
        setTitle("UIT Parking");
        
        ChuyenManHinhController controller = new ChuyenManHinhController(jpnView);
        controller.setView(jpnQLKH, jlbQLKH);
        
        ArrayList<DanhMucBean> listItem = new ArrayList<>();
        listItem.add (new DanhMucBean("QLKH", jpnQLKH, jlbQLKH));
        listItem.add (new DanhMucBean("QLX", jpnQLX, jlbQLX));
        listItem.add (new DanhMucBean("QLV", jpnQLV, jlbQLV));
        listItem.add (new DanhMucBean("QLHD", jpnQLHD, jlbQLHD));
        listItem.add (new DanhMucBean("QLDT", jpnQLDT, jlbQLDT));
        listItem.add (new DanhMucBean("BCTK", jpnBCTK, jlbBCTK));
        
        controller.setEvent(listItem);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnRoot = new javax.swing.JPanel();
        jpnMenu = new javax.swing.JPanel();
        jpnQLKH = new javax.swing.JPanel();
        jlbQLKH = new javax.swing.JLabel();
        jpnQLX = new javax.swing.JPanel();
        jlbQLX = new javax.swing.JLabel();
        jpnQLV = new javax.swing.JPanel();
        jlbQLV = new javax.swing.JLabel();
        jpnQLHD = new javax.swing.JPanel();
        jlbQLHD = new javax.swing.JLabel();
        jpnQLDT = new javax.swing.JPanel();
        jlbQLDT = new javax.swing.JLabel();
        jpnBCTK = new javax.swing.JPanel();
        jlbBCTK = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jpnView = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpnRoot.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpnMenu.setBackground(new java.awt.Color(204, 204, 204));
        jpnMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jpnQLKH.setBackground(new java.awt.Color(0, 153, 102));

        jlbQLKH.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlbQLKH.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbQLKH.setText("QLKH");

        javax.swing.GroupLayout jpnQLKHLayout = new javax.swing.GroupLayout(jpnQLKH);
        jpnQLKH.setLayout(jpnQLKHLayout);
        jpnQLKHLayout.setHorizontalGroup(
            jpnQLKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbQLKH, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );
        jpnQLKHLayout.setVerticalGroup(
            jpnQLKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnQLKHLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jlbQLKH, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpnQLX.setBackground(new java.awt.Color(0, 153, 102));

        jlbQLX.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlbQLX.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbQLX.setText("QLX");

        javax.swing.GroupLayout jpnQLXLayout = new javax.swing.GroupLayout(jpnQLX);
        jpnQLX.setLayout(jpnQLXLayout);
        jpnQLXLayout.setHorizontalGroup(
            jpnQLXLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbQLX, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );
        jpnQLXLayout.setVerticalGroup(
            jpnQLXLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnQLXLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jlbQLX, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        jpnQLV.setBackground(new java.awt.Color(0, 153, 102));

        jlbQLV.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlbQLV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbQLV.setText("QLV");

        javax.swing.GroupLayout jpnQLVLayout = new javax.swing.GroupLayout(jpnQLV);
        jpnQLV.setLayout(jpnQLVLayout);
        jpnQLVLayout.setHorizontalGroup(
            jpnQLVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbQLV, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );
        jpnQLVLayout.setVerticalGroup(
            jpnQLVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnQLVLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jlbQLV, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        jpnQLHD.setBackground(new java.awt.Color(0, 153, 102));

        jlbQLHD.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlbQLHD.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbQLHD.setText("QLHD");

        javax.swing.GroupLayout jpnQLHDLayout = new javax.swing.GroupLayout(jpnQLHD);
        jpnQLHD.setLayout(jpnQLHDLayout);
        jpnQLHDLayout.setHorizontalGroup(
            jpnQLHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbQLHD, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );
        jpnQLHDLayout.setVerticalGroup(
            jpnQLHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnQLHDLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jlbQLHD, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        jpnQLDT.setBackground(new java.awt.Color(0, 153, 102));

        jlbQLDT.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlbQLDT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbQLDT.setText("QLDT");

        javax.swing.GroupLayout jpnQLDTLayout = new javax.swing.GroupLayout(jpnQLDT);
        jpnQLDT.setLayout(jpnQLDTLayout);
        jpnQLDTLayout.setHorizontalGroup(
            jpnQLDTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbQLDT, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );
        jpnQLDTLayout.setVerticalGroup(
            jpnQLDTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnQLDTLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jlbQLDT, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        jpnBCTK.setBackground(new java.awt.Color(0, 153, 102));

        jlbBCTK.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlbBCTK.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbBCTK.setText("BC & TK");

        javax.swing.GroupLayout jpnBCTKLayout = new javax.swing.GroupLayout(jpnBCTK);
        jpnBCTK.setLayout(jpnBCTKLayout);
        jpnBCTKLayout.setHorizontalGroup(
            jpnBCTKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbBCTK, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );
        jpnBCTKLayout.setVerticalGroup(
            jpnBCTKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnBCTKLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jlbBCTK, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        jButton1.setBackground(new java.awt.Color(0, 51, 255));
        jButton1.setText("BACK");

        javax.swing.GroupLayout jpnMenuLayout = new javax.swing.GroupLayout(jpnMenu);
        jpnMenu.setLayout(jpnMenuLayout);
        jpnMenuLayout.setHorizontalGroup(
            jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnMenuLayout.createSequentialGroup()
                .addComponent(jpnQLKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnQLX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnQLV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnQLHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnQLDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnBCTK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );
        jpnMenuLayout.setVerticalGroup(
            jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnQLKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpnQLX, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpnQLV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpnQLHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpnQLDT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpnBCTK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jpnMenuLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpnRoot.add(jpnMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 110));

        jpnView.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jpnViewLayout = new javax.swing.GroupLayout(jpnView);
        jpnView.setLayout(jpnViewLayout);
        jpnViewLayout.setHorizontalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1008, Short.MAX_VALUE)
        );
        jpnViewLayout.setVerticalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 628, Short.MAX_VALUE)
        );

        jpnRoot.add(jpnView, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 1010, 630));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnRoot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnRoot, javax.swing.GroupLayout.PREFERRED_SIZE, 736, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jlbBCTK;
    private javax.swing.JLabel jlbQLDT;
    private javax.swing.JLabel jlbQLHD;
    private javax.swing.JLabel jlbQLKH;
    private javax.swing.JLabel jlbQLV;
    private javax.swing.JLabel jlbQLX;
    private javax.swing.JPanel jpnBCTK;
    private javax.swing.JPanel jpnMenu;
    private javax.swing.JPanel jpnQLDT;
    private javax.swing.JPanel jpnQLHD;
    private javax.swing.JPanel jpnQLKH;
    private javax.swing.JPanel jpnQLV;
    private javax.swing.JPanel jpnQLX;
    private javax.swing.JPanel jpnRoot;
    private javax.swing.JPanel jpnView;
    // End of variables declaration//GEN-END:variables
}
