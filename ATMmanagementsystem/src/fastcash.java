
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author meaya
 */
public class fastcash extends javax.swing.JFrame {

    /**
     * Creates new for
     */
    public fastcash() {
        initComponents();
    }

    fastcash(String user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    static  String username;

      public static  void setUserName(String u)
          {
                        username=u;
    } public void widthdraw(String amount){
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
        fivethousand = new javax.swing.JButton();
        onethousand = new javax.swing.JButton();
        fivehundred = new javax.swing.JButton();
        twothousand = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("fast cash");

        fivethousand.setText("5000");
        fivethousand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fivethousandActionPerformed(evt);
            }
        });

        onethousand.setText("1000");
        onethousand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onethousandActionPerformed(evt);
            }
        });

        fivehundred.setText("500");
        fivehundred.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fivehundredActionPerformed(evt);
            }
        });

        twothousand.setText("2000");
        twothousand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                twothousandActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(onethousand, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                    .addComponent(fivethousand, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(fivehundred, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(twothousand, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE))
                .addGap(79, 79, 79))
            .addGroup(layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(jLabel1)
                .addContainerGap(162, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fivethousand, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(twothousand, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fivehundred, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(onethousand, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void onethousandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onethousandActionPerformed
               int i=1000;
               String amount= String.valueOf(pamount()-i);
            
            
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
    }//GEN-LAST:event_onethousandActionPerformed

    private void fivethousandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fivethousandActionPerformed
               int i=5000;
               String amount= String.valueOf(pamount()-i);
            
            
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
            } // TODO add your handling code here:
    }//GEN-LAST:event_fivethousandActionPerformed

    private void twothousandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_twothousandActionPerformed
               int i=2000;
               String amount= String.valueOf(pamount()-i);
            
            
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
            } // TODO add your handling code here:
    }//GEN-LAST:event_twothousandActionPerformed

    private void fivehundredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fivehundredActionPerformed
               int i=500;
               String amount= String.valueOf(pamount()-i);
            
            
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
            }  // TODO add your handling code here:
    }//GEN-LAST:event_fivehundredActionPerformed

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
            java.util.logging.Logger.getLogger(fastcash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fastcash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fastcash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fastcash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fastcash().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton fivehundred;
    private javax.swing.JButton fivethousand;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton onethousand;
    private javax.swing.JButton twothousand;
    // End of variables declaration//GEN-END:variables
}
