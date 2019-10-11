package javamysql.ui;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
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
 * @author Taz
 */
public class admin extends javax.swing.JFrame {

    /**
     * Creates new form admin
     */
    public admin() {
        initComponents();
        showTable();
        setTitle("Admin Panel");
    }
        public Connection getConnection()
   {
       Connection con;

       try {
           con = DriverManager.getConnection("jdbc:mysql://localhost/java_db", "root","");
           return con;
       } 
      catch (Exception e) {
           e.printStackTrace();
           return null;
       }
   }
        public ArrayList<User> getUsersList()
   {
       ArrayList<User> usersList = new ArrayList<User>();
       Connection connection = getConnection();
       
       String query = "SELECT * FROM  `users` ";
       Statement st;
       ResultSet rs;
       
       try {
           st = connection.createStatement();
           rs = st.executeQuery(query);

           User user;

           while(rs.next())
           {
        user = new User(rs.getString("name"),rs.getString("lastname"),rs.getString("username"),rs.getString("password"));
               usersList.add(user);
           }

       } 
      catch (Exception e) {
           e.printStackTrace();
       }
       return usersList;
   }
public void showTable()
   {
       ArrayList<User> list = getUsersList();
       DefaultTableModel model = (DefaultTableModel)table.getModel();
       Object[] row = new Object[4];
       for(int i = 0; i < list.size(); i++)
       {
           row[0] = list.get(i).getfnn();
           row[1] = list.get(i).getlnn();
           row[2] = list.get(i).getunn();
           row[3] = list.get(i).getpsw();
           
           model.addRow(row);
       }
    }
   public void executeSQlQuery(String query, String message)
   {
       Connection con = getConnection();
       Statement st;
       try{
           st = con.createStatement();
           if((st.executeUpdate(query)) == 1)
           {
               DefaultTableModel model = (DefaultTableModel)table.getModel();
               model.setRowCount(0);
               showTable();
               
               JOptionPane.showMessageDialog(null, "Data "+message+" Succefully");
           }else{
               JOptionPane.showMessageDialog(null, "Data Not "+message);
           }
       }catch(Exception ex){
           ex.printStackTrace();
       }
   }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        fname = new javax.swing.JTextField();
        lname = new javax.swing.JTextField();
        uname = new javax.swing.JTextField();
        passw = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        add = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        remove = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        as = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Name :");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 270, 114, 19);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Email :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 320, 114, 19);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("User Name :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 350, 114, 20);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Password");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 390, 114, 20);

        fname.setForeground(new java.awt.Color(255, 0, 51));
        fname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fnameActionPerformed(evt);
            }
        });
        getContentPane().add(fname);
        fname.setBounds(150, 270, 150, 30);

        lname.setForeground(new java.awt.Color(255, 0, 51));
        lname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnameActionPerformed(evt);
            }
        });
        getContentPane().add(lname);
        lname.setBounds(150, 310, 150, 30);

        uname.setForeground(new java.awt.Color(255, 0, 51));
        uname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unameActionPerformed(evt);
            }
        });
        getContentPane().add(uname);
        uname.setBounds(150, 350, 150, 30);

        passw.setForeground(new java.awt.Color(255, 0, 51));
        getContentPane().add(passw);
        passw.setBounds(150, 390, 150, 30);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Email", "User Name", "Password"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setResizable(false);
            table.getColumnModel().getColumn(0).setPreferredWidth(15);
            table.getColumnModel().getColumn(1).setResizable(false);
            table.getColumnModel().getColumn(1).setPreferredWidth(40);
            table.getColumnModel().getColumn(2).setResizable(false);
            table.getColumnModel().getColumn(2).setPreferredWidth(20);
            table.getColumnModel().getColumn(3).setResizable(false);
            table.getColumnModel().getColumn(3).setPreferredWidth(10);
        }

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(310, 270, 452, 210);

        add.setFont(new java.awt.Font("Yu Gothic Light", 1, 17)); // NOI18N
        add.setText("Add");
        add.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        getContentPane().add(add);
        add.setBounds(10, 430, 85, 52);

        edit.setFont(new java.awt.Font("Yu Gothic Light", 1, 17)); // NOI18N
        edit.setText("Edit");
        edit.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
        getContentPane().add(edit);
        edit.setBounds(110, 430, 85, 52);

        remove.setFont(new java.awt.Font("Yu Gothic Light", 1, 17)); // NOI18N
        remove.setText("Remove");
        remove.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });
        getContentPane().add(remove);
        remove.setBounds(220, 430, 85, 52);

        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Logout");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(633, 40, 130, 30);

        as.setBackground(new java.awt.Color(255, 255, 255));
        as.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        as.setForeground(new java.awt.Color(255, 255, 255));
        as.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(as);
        as.setBounds(660, 10, 100, 30);

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Logged In as:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(550, 10, 80, 30);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/1 (453).jpg"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, -10, 770, 510);

        setSize(new java.awt.Dimension(781, 529));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
       //table row   data selected
        int i = table.getSelectedRow();
        TableModel model = table.getModel();        
        fname.setText(model.getValueAt(i,0).toString());
        lname.setText(model.getValueAt(i,1).toString());
        uname.setText(model.getValueAt(i,2).toString());
        passw.setText(model.getValueAt(i,3).toString());       
    }//GEN-LAST:event_tableMouseClicked

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        String query = "INSERT INTO `users`(`name`, `lastname`, `username`,`password`) VALUES ('"+fname.getText()+"','"+lname.getText()+"','"+uname.getText()+"','"+passw.getText()+"')";        
        executeSQlQuery(query, "Inserted");
    }//GEN-LAST:event_addActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
      String query = "UPDATE `users` SET `name` = '"+fname.getText()+"' , `lastname` = '"+lname.getText()+"' , `username` = '"+uname.getText()+"' , `password` = '"+passw.getText()+"' LIMIT 1;" ;
      executeSQlQuery(query, "Updated");     
    }//GEN-LAST:event_editActionPerformed

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
       String query = "DELETE FROM `java_db`.`users` WHERE `users`.`name` = '"+fname.getText()+"' AND `users`.`lastname` = '"+lname.getText()+"' AND `users`.`username` = '"+uname.getText()+"' AND `users`.`password` = '"+passw.getText()+"' LIMIT 1;";
       executeSQlQuery(query, "Deleted");
       
    }//GEN-LAST:event_removeActionPerformed

    private void lnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lnameActionPerformed

    private void fnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fnameActionPerformed

    private void unameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_unameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       this.dispose();
       Login a = new Login();
       a.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    public static javax.swing.JLabel as;
    private javax.swing.JButton edit;
    private javax.swing.JTextField fname;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lname;
    private javax.swing.JTextField passw;
    private javax.swing.JButton remove;
    private javax.swing.JTable table;
    private javax.swing.JTextField uname;
    // End of variables declaration//GEN-END:variables
}
