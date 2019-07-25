
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author meaya
 */
public class withdrawal extends javax.swing.JFrame {

    /**
     * Creates new form withdrawal
     */static  String username;

public static  void setUserName(String u)
{
    username=u;
}
    public withdrawal() {
        initComponents();
    }

    withdrawal(String user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   public void widthdraw(String amount){
       try{
                        Date date = new Date();  
                        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
                        String strDate= formatter.format(date);
                       
                        Connection con=config.getconnection();
                        if(con.isValid(1)){
                        String sql= "insert into transaction values (?,?,?)";
                        PreparedStatement ps=con.prepareStatement(sql); 
                        ps.setString(1, strDate);
                        ps.setString(2, amount);
                        ps.setString(3, username);
                        int res=ps.executeUpdate();
                        if(res>0){
                            JOptionPane.showMessageDialog(rootPane, "sucessfull");
                            
                            
                        }else{
                            JOptionPane.showMessageDialog(rootPane, "not sucessfull");
                        }
                    }else{
                        JOptionPane.showMessageDialog(rootPane, "not connected");
                    }con.close();
                }
                     
                  catch (Exception e) {
                       JOptionPane.showMessageDialog(rootPane, e);
                    }
    }
   public int pamount(){
        
         try{
         
                    Connection con= config.getconnection();
                    if(con.isValid(1))
                    {
                        String sql= "select principleamount from register where username=? ";
                        PreparedStatement ps=con.prepareStatement(sql);
                        ps.setString(1, username);
                        ResultSet resultSet=ps.executeQuery();
                        return Integer.parseInt(resultSet.getString("principleamount"));
                        
                        
                  }
            }catch(Exception e){
                        JOptionPane.showMessageDialog(rootPane, e);
                          }
         return 0;
         
       
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        width = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("withdrawal");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("enter amount in the multiple of 100's     :");

        width.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                widthActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("withdraw");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(width)))))
                .addContainerGap(96, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(width, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jButton1)
                .addContainerGap(95, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         
                  String amount= String.valueOf(pamount()-Integer.parseInt( width.getText()));
            
            
                try{
                if(amount.isEmpty()){
                    JOptionPane.showMessageDialog(rootPane, "enter the info");
                }else{
                    Connection con=config.getconnection();
                    if(con.isValid(1)){
                        String sql= "UPDATE register set principleamount=? where username=?";
                        PreparedStatement ps=con.prepareStatement(sql);
                        ps.setString(1, amount);
                        ps.setString(2, username);
                        int res=ps.executeUpdate();
                        if(res>0){
                            JOptionPane.showMessageDialog(rootPane, "sucessfull");
                            width.setText("");
                            widthdraw(amount);    
                            
                        }else{
                            JOptionPane.showMessageDialog(rootPane, "not sucessfull");
                        }
                    }else{
                        JOptionPane.showMessageDialog(rootPane, "not connected");
                    } con.close();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, e);
            }
                 
               
                 
                     
    }//GEN-LAST:event_jButton1ActionPerformed

    private void widthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_widthActionPerformed
                                   // TODO add your handling code here:
    }//GEN-LAST:event_widthActionPerformed

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
            java.util.logging.Logger.getLogger(withdrawal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(withdrawal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(withdrawal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(withdrawal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new withdrawal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField width;
    // End of variables declaration//GEN-END:variables
}
