
import com.mysql.cj.protocol.Resultset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Asus
 */
public class Assignments extends javax.swing.JFrame {

    //this will be used to save the selected data from both tables into another table
    private static final String username = "root";
    private static final String password = "MySqLserver@0630";
    private static final String dataConn = "jdbc:mysql://localhost:3306/assignments";
    
    Connection sqlConn = null; 
    PreparedStatement pst = null;
    ResultSet rs = null;
    int q, i, id, deleteItem;
    
    
    Connection con;
    Connection con2;
    
    public Assignments() {
        initComponents();
        //this is the first connection, used for retrieving data from the request_table and displaying it the first table on netbeans
        String url1 = "jdbc:mysql://localhost:3306/requests";
        String user1 = "root";
        String pass1 = "MySqLserver@0630";
        try{
            con = DriverManager.getConnection(url1,user1,pass1);
        }catch(Exception ex){
            System.out.println("Error : " + ex.getMessage());
        }
        //this is the second connection, used for retrieving data from the volunteer_table and displaying it on the second table on netbeans
        String url2 = "jdbc:mysql://localhost:3306/volunteer";
        String user2 = "root";
        String pass2 = "MySqLserver@0630";
        try{
            con2 = DriverManager.getConnection(url2,user2,pass2);
        }catch(Exception ex){
            System.out.println("Error : " + ex.getMessage());
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Requests_Display = new javax.swing.JTable();
        AT_Name = new javax.swing.JTextField();
        AT_Surname = new javax.swing.JTextField();
        AT_Contact = new javax.swing.JTextField();
        AT_Issue = new javax.swing.JTextField();
        AT_UnitNo = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        Volunteers_Display = new javax.swing.JTable();
        AV_Surname = new javax.swing.JTextField();
        AV_Name = new javax.swing.JTextField();
        AV_Contact = new javax.swing.JTextField();
        AT_Profession = new javax.swing.JTextField();
        Assign = new javax.swing.JButton();
        jbtRequests = new javax.swing.JButton();
        jbtVolunteers = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        jLabel1.setText("Assingnments");

        Requests_Display.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        Requests_Display.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Surname", "Contact", "Unit Number", "Issue"
            }
        ));
        Requests_Display.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Requests_DisplayMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Requests_Display);

        AT_Name.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        AT_Name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AT_NameActionPerformed(evt);
            }
        });

        AT_Surname.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        AT_Surname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AT_SurnameActionPerformed(evt);
            }
        });

        AT_Contact.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        AT_Contact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AT_ContactActionPerformed(evt);
            }
        });

        AT_Issue.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        AT_Issue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AT_IssueActionPerformed(evt);
            }
        });

        AT_UnitNo.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        AT_UnitNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AT_UnitNoActionPerformed(evt);
            }
        });

        Volunteers_Display.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        Volunteers_Display.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Surname", "Contact Details", "Profession"
            }
        ));
        Volunteers_Display.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Volunteers_DisplayMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Volunteers_Display);

        AV_Surname.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        AV_Surname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AV_SurnameActionPerformed(evt);
            }
        });

        AV_Name.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        AV_Name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AV_NameActionPerformed(evt);
            }
        });

        AV_Contact.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        AV_Contact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AV_ContactActionPerformed(evt);
            }
        });

        AT_Profession.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        AT_Profession.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AT_ProfessionActionPerformed(evt);
            }
        });

        Assign.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        Assign.setText("Assign");
        Assign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AssignActionPerformed(evt);
            }
        });

        jbtRequests.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jbtRequests.setText("Requests");
        jbtRequests.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtRequestsActionPerformed(evt);
            }
        });

        jbtVolunteers.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jbtVolunteers.setText("Volunteers");
        jbtVolunteers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtVolunteersActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(338, 338, 338)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Assign, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(AT_UnitNo, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                    .addComponent(AT_Issue)
                    .addComponent(AT_Contact)
                    .addComponent(AT_Surname)
                    .addComponent(AT_Name, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(AV_Name)
                    .addComponent(AV_Surname)
                    .addComponent(AV_Contact)
                    .addComponent(AT_Profession))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(230, 230, 230)
                                .addComponent(jbtVolunteers)
                                .addGap(207, 308, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbtRequests)
                .addGap(324, 324, 324))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addComponent(jbtRequests)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(AT_Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(AT_Surname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(AT_Contact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(AT_UnitNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(AT_Issue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(AV_Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(AV_Surname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(AV_Contact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(AT_Profession, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jbtVolunteers)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(52, 52, 52)
                .addComponent(Assign)
                .addContainerGap(73, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AT_NameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AT_NameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AT_NameActionPerformed

    private void AT_SurnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AT_SurnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AT_SurnameActionPerformed

    private void AT_ContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AT_ContactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AT_ContactActionPerformed

    private void AT_IssueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AT_IssueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AT_IssueActionPerformed

    private void AT_UnitNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AT_UnitNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AT_UnitNoActionPerformed

    private void AV_SurnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AV_SurnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AV_SurnameActionPerformed

    private void AV_NameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AV_NameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AV_NameActionPerformed

    private void AV_ContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AV_ContactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AV_ContactActionPerformed

    private void AT_ProfessionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AT_ProfessionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AT_ProfessionActionPerformed

    private void jbtRequestsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtRequestsActionPerformed
        // this is using the first connection to retrieve the data
        String sql = "SELECT * FROM request_table";
        try{
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            DefaultTableModel model = (DefaultTableModel)Requests_Display.getModel();
            while(rs.next()){
            model.addRow(new String[] {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)});
        }
        }catch(Exception ex){
            System.out.println("Error : " +ex.getMessage());
        }
        
    }//GEN-LAST:event_jbtRequestsActionPerformed

    private void jbtVolunteersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtVolunteersActionPerformed
        // this is using the second connection to retrieve the data
        String sql = "SELECT * FROM volunteers_table";
        try{
            PreparedStatement pst = con2.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            DefaultTableModel model = (DefaultTableModel)Volunteers_Display.getModel();
            while(rs.next()){
            model.addRow(new String[] {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)});
        }
        }catch(Exception ex){
            System.out.println("Error : " +ex.getMessage());
        }
        
    }//GEN-LAST:event_jbtVolunteersActionPerformed

    private void Requests_DisplayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Requests_DisplayMouseClicked
        
        int i = Requests_Display.getSelectedRow();
        TableModel model = Requests_Display.getModel();
        AT_Name.setText(model.getValueAt(i,0).toString());
        AT_Surname.setText(model.getValueAt(i,1).toString());
        AT_Contact.setText(model.getValueAt(i,2).toString());
        AT_UnitNo.setText(model.getValueAt(i,3).toString());
        AT_Issue.setText(model.getValueAt(i,4).toString());
        
    }//GEN-LAST:event_Requests_DisplayMouseClicked

    private void Volunteers_DisplayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Volunteers_DisplayMouseClicked
        
        int i = Volunteers_Display.getSelectedRow();
        TableModel model = Volunteers_Display.getModel();
        AV_Name.setText(model.getValueAt(i,0).toString());
        AV_Surname.setText(model.getValueAt(i,1).toString());
        AV_Contact.setText(model.getValueAt(i,2).toString());
        AT_Profession.setText(model.getValueAt(i,3).toString());
        
        
    }//GEN-LAST:event_Volunteers_DisplayMouseClicked

    private void AssignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AssignActionPerformed
        
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            sqlConn = DriverManager.getConnection(dataConn,username,password);
            pst = sqlConn.prepareStatement("insert into assigned_jobs(Requester_Name,Requester_Surname,Requester_Contact,Unit_Number,Issue,Volunteer_Name,Volunteer_Surname,Volunteer_Contact,Profession)"
                    + "values(?, ?, ?, ?, ?, ?, ?, ?, ?)");

            
            pst.setString(1, AT_Name.getText());
            pst.setString(2, AT_Surname.getText());
            pst.setString(3, AT_Contact.getText());
            pst.setString(4, AT_UnitNo.getText());
            pst.setString(5, AT_Issue.getText());
            pst.setString(6, AV_Name.getText());
            pst.setString(7, AV_Surname.getText());
            pst.setString(8, AV_Contact.getText());
            pst.setString(9, AT_Profession.getText());
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Record Added");
            
            
        }
        
        catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tenants_register.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Tenants_register.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }
        
    }//GEN-LAST:event_AssignActionPerformed

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
            java.util.logging.Logger.getLogger(Assignments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Assignments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Assignments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Assignments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Assignments().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AT_Contact;
    private javax.swing.JTextField AT_Issue;
    private javax.swing.JTextField AT_Name;
    private javax.swing.JTextField AT_Profession;
    private javax.swing.JTextField AT_Surname;
    private javax.swing.JTextField AT_UnitNo;
    private javax.swing.JTextField AV_Contact;
    private javax.swing.JTextField AV_Name;
    private javax.swing.JTextField AV_Surname;
    private javax.swing.JButton Assign;
    private javax.swing.JTable Requests_Display;
    private javax.swing.JTable Volunteers_Display;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbtRequests;
    private javax.swing.JButton jbtVolunteers;
    // End of variables declaration//GEN-END:variables
}