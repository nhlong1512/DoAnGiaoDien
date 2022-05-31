import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ThongTinVe extends javax.swing.JFrame{
    private javax.swing.JComboBox[] combo1; //array of JComboBoxes
    private javax.swing.JComboBox[] combo2; //array of JComboBoxes
    private javax.swing.JTextField[] text1; //array of JTextFields
    private int count = -1; 
    private int max_row = 10;
    private int empty_count = 0;    
    public ThongTinVe() {
        initComponents(); // Netbeans defined function non-editable    
        setTitle("Adding and Removing Components Dynamically From a JPanel in Java");
        combo1_combo2_text1_array(); // declaring array for new row addition
    }

    private void combo1_combo2_text1_array(){
        combo1 = new JComboBox[10];
        combo2 = new JComboBox[10];
        text1 = new JTextField[10];        
    }
    

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {   // Cancel Button Action                                     
        System.exit(0);
    }

    private void resetActionPerformed(java.awt.event.ActionEvent evt) { //Reset Button Action                                     
        jTextField1.setText("");
        for(int i=count;i>-1;i--){
            jPanel2.remove(combo1[i]);
            jPanel2.remove(combo2[i]);
            jPanel2.remove(text1[i]);
            jPanel2.revalidate();
            jPanel2.repaint();
        }
        count = -1;
    }                                   

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {                                       
        if(jTextField1.getText().length()==0)  // Submit button for the register form
            JOptionPane.showMessageDialog(null, "Empty fields detected ! Please fill up all fields","Failed!!",JOptionPane.ERROR_MESSAGE);      
        else if(count > -1){            
            for(int i=0;i<=count;i++){
                if(text1[count].getText().length()==0)  
                    empty_count++;                
            }
            if(empty_count > 0){
                JOptionPane.showMessageDialog(null, "Empty fields detected ! Please fill up all fields","Failed!!",JOptionPane.ERROR_MESSAGE); 
                empty_count = 0; // resetting the count
            }
            else
                JOptionPane.showMessageDialog(null, "No database connection for this application","Failed!!",JOptionPane.ERROR_MESSAGE);
        }
        else
            JOptionPane.showMessageDialog(null, "No database connection for this application","Failed!!",JOptionPane.ERROR_MESSAGE);        
    }
                                      
    public static void main(String args[]) {
      java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThongTinVe().setVisible(true);
            }
        });
    }
     // Variables declaration - do not modify                     
    // End of variables declaration                   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        addrow = new javax.swing.JButton();
        removerow = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 480, 340));

        addrow.setText("AddRow");
        addrow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addrowActionPerformed(evt);
            }
        });
        jPanel1.add(addrow, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 40, 140, -1));

        removerow.setText("RemoveRow");
        removerow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerowActionPerformed(evt);
            }
        });
        jPanel1.add(removerow, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 40, 150, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addrowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addrowActionPerformed
        // TODO add your handling code here:
         if(count == max_row-1){
            JOptionPane.showMessageDialog(null, "Maximum of 10 rows can be added","Failed!!",JOptionPane.ERROR_MESSAGE);
            return;
        }
        count++;        
        combo1[count] = new javax.swing.JComboBox(); 
        for(int i=1;i<=5;i++){
            combo1[count].addItem("Item " + i);
        }       
        combo2[count] = new javax.swing.JComboBox(); 
        for(int i=1;i<=5;i++){
            combo2[count].addItem("Item " + i);
        }   
        text1[count] = new javax.swing.JTextField();        
        jPanel2.setLayout(new GridLayout(0,3,20,20));
        jPanel2.add(combo1[count]);
        jPanel2.add(combo2[count]);
        jPanel2.add(text1[count]);
        jPanel2.revalidate();
        jPanel2.repaint();
    }//GEN-LAST:event_addrowActionPerformed

    private void removerowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerowActionPerformed
        // TODO add your handling code here:
        if(count > -1){ // Deleting one row at a time
            jPanel2.remove(combo1[count]);
            jPanel2.remove(combo2[count]);
            jPanel2.remove(text1[count]);
            count--;
            jPanel2.revalidate();
            jPanel2.repaint();
        }
    }//GEN-LAST:event_removerowActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addrow;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton removerow;
    // End of variables declaration//GEN-END:variables
}
