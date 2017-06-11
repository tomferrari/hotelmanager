/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagerGUI;

import hotelmanagerBO.Client;
import hotelmanagerDAO.ClientDAO;
import hotelmanagerDAO.DatabaseOperation;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Faysal Ahmed
 */
public class ClientGUI extends javax.swing.JFrame {

    Client user = new Client();
    ClientDAO db = new ClientDAO();
    ResultSet result = null;
    
    //int choice = ADD;
    public ClientGUI() {
        
          //  UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            initComponents();
            this.getContentPane().setBackground(new Color(241,241,242));
            setTitle("Tous les clients");
            populateWithCustomerData();
         
    }
    
    private void populateWithCustomerData()
    {
        result = db.getAllCustomer();
        table_customer.setModel(DbUtils.resultSetToTableModel(result));
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table_customer = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tf_address = new javax.swing.JTextField();
        tf_phone = new javax.swing.JTextField();
        tf_name = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tf_id = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btn_addCustomer = new javax.swing.JButton();
        btn_editCustomer = new javax.swing.JButton();
        btn_deleteCustomer = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        tf_surname = new javax.swing.JTextField();
        btn_reset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        table_customer.setModel(new javax.swing.table.DefaultTableModel(
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
        table_customer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_customerMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_customer);

        jPanel3.setBackground(new java.awt.Color(230, 231, 232));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Client Info", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Californian FB", 0, 18), new java.awt.Color(0, 153, 204))); // NOI18N

        jLabel3.setText("Telephone");

        jLabel1.setText("Nom");

        tf_phone.setToolTipText("Digits Only");
        tf_phone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_phoneKeyTyped(evt);
            }
        });

        jLabel2.setText("Adresse");

        tf_id.setEditable(false);

        jLabel5.setText("ID");

        btn_addCustomer.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_addCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/DefaultButton.png"))); // NOI18N
        btn_addCustomer.setBorderPainted(false);
        btn_addCustomer.setFocusPainted(false);
        btn_addCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addCustomerActionPerformed(evt);
            }
        });

        btn_editCustomer.setForeground(new java.awt.Color(255, 255, 255));
        btn_editCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/EditButton.png"))); // NOI18N
        btn_editCustomer.setToolTipText("");
        btn_editCustomer.setBorderPainted(false);
        btn_editCustomer.setEnabled(false);
        btn_editCustomer.setFocusPainted(false);
        btn_editCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editCustomerActionPerformed(evt);
            }
        });

        btn_deleteCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/DeleteButton.png"))); // NOI18N
        btn_deleteCustomer.setEnabled(false);
        btn_deleteCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteCustomerActionPerformed(evt);
            }
        });

        jLabel4.setText("Prenom");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btn_deleteCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(btn_editCustomer, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tf_id, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(tf_address)
                                        .addComponent(tf_phone)
                                        .addComponent(tf_name, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                                        .addComponent(tf_surname))))
                            .addComponent(btn_addCustomer, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(164, 164, 164))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tf_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tf_surname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tf_address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tf_phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_addCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_editCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_deleteCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        btn_reset.setBackground(new java.awt.Color(204, 204, 255));
        btn_reset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/reset.png"))); // NOI18N
        btn_reset.setToolTipText("Reset everything");
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addComponent(btn_reset)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_addCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addCustomerActionPerformed
        ObjectCreation();
        db.insertCustomer(user);
        populateWithCustomerData();
        emptyField();
      
    }//GEN-LAST:event_btn_addCustomerActionPerformed

    private void ObjectCreation()
    {
        user = new Client();
        
        user.setName(tf_name.getText());
        user.setSurname(tf_surname.getText());
        user.setAddress(tf_address.getText());
        user.setPhone_no(tf_phone.getText());
        try{
            user.setCustomer_id(Integer.parseInt(tf_id.getText()));
        }
        catch(Exception ex)
        {
            user.setCustomer_id(0);
        }
        
    }
    
    private void table_customerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_customerMouseClicked
       
        user = new Client();
        int row = table_customer.getSelectedRow();
        displayToTextField(row);
        //ObjectCreation();
        btn_editCustomer.setEnabled(true);
        btn_deleteCustomer.setEnabled(true);
        btn_addCustomer.setEnabled(false);
        
    }//GEN-LAST:event_table_customerMouseClicked

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
       
        emptyField();
        
    }//GEN-LAST:event_btn_resetActionPerformed

 
    
    private void btn_editCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editCustomerActionPerformed
        ObjectCreation();
        db.updateCustomer(user);
        populateWithCustomerData();
        emptyField();
    }//GEN-LAST:event_btn_editCustomerActionPerformed

    private void btn_deleteCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteCustomerActionPerformed
        int row  = table_customer.getSelectedRow();
        int selectedUserId = (int) table_customer.getModel().getValueAt(row, 0);
        try {
            db.deleteCustomer(selectedUserId);
            
        } catch (SQLException ex) {
            Logger.getLogger(ClientGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        populateWithCustomerData();
        emptyField();
        
    }//GEN-LAST:event_btn_deleteCustomerActionPerformed

    private void tf_phoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_phoneKeyTyped
         char c = evt.getKeyChar();
        
        if(!(Character.isDigit(c) || c== KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE ))
        {
            evt.consume();
        }
    }//GEN-LAST:event_tf_phoneKeyTyped

    
    private void emptyField()
    {
         btn_addCustomer.setEnabled(true);
        btn_editCustomer.setEnabled(false);
        btn_deleteCustomer.setEnabled(false);
        
        user = new Client();
        
        tf_address.setText("");
        tf_id.setText("");
        tf_name.setText("");
        tf_surname.setText("");
        tf_phone.setText("");
        table_customer.clearSelection();
    }
    
    private void displayToTextField(int row)
{
    //System.out.println(table_customer.getModel().getValueAt(row, 0)+ " >>>>>>>>> ");
    tf_id.setText(table_customer.getModel().getValueAt(row, 0)+"");
    tf_name.setText((String) table_customer.getModel().getValueAt(row, 1));
    tf_surname.setText((String) table_customer.getModel().getValueAt(row, 2));
    tf_address.setText((String) table_customer.getModel().getValueAt(row, 3));
    tf_phone.setText((String) table_customer.getModel().getValueAt(row, 4));
}
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
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_addCustomer;
    private javax.swing.JButton btn_deleteCustomer;
    private javax.swing.JButton btn_editCustomer;
    private javax.swing.JButton btn_reset;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_customer;
    private javax.swing.JTextField tf_address;
    private javax.swing.JTextField tf_id;
    private javax.swing.JTextField tf_name;
    private javax.swing.JTextField tf_phone;
    private javax.swing.JTextField tf_surname;
    // End of variables declaration//GEN-END:variables
}
