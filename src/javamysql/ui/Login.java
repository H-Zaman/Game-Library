/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamysql.ui;

import javamysql.helper.Controller;
import javamysql.model.User;
import javamysql.model.UserInteractionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author t@z
 */
public class Login extends javax.swing.JFrame implements UserInteractionListener {

    
    private final Controller controller;
    
    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        setLocationRelativeTo(null);
        this.controller = Controller.getController();
        setTitle("Login");
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
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        login = new javax.swing.JButton();
        signup = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("UserName : ");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(470, 340, 70, 40);

        username.setBackground(new java.awt.Color(153, 153, 153));
        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });
        getContentPane().add(username);
        username.setBounds(540, 345, 206, 30);

        password.setBackground(new java.awt.Color(153, 153, 153));
        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });
        getContentPane().add(password);
        password.setBounds(540, 395, 206, 30);

        login.setText("Login");
        login.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        getContentPane().add(login);
        login.setBounds(647, 440, 100, 40);

        signup.setText("Signup");
        signup.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));
        signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupActionPerformed(evt);
            }
        });
        getContentPane().add(signup);
        signup.setBounds(540, 440, 90, 40);

        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Password :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(470, 390, 64, 28);

        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Not Registered? SIgnup NOW!!!");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(340, 440, 190, 41);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/login.jpg"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, -20, 770, 540);

        setSize(new java.awt.Dimension(781, 543));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void signupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupActionPerformed
        this.dispose();
        SignupForm signupForm = new SignupForm(this, true, this);
        signupForm.setVisible(true);
    }//GEN-LAST:event_signupActionPerformed

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        
        String m,n;
        m=this.username.getText();
        n=this.password.getText();
               try{
           String uname = username.getText();
           char[] pwd = password.getPassword();
           String passs=new String(pwd);
                       User user = this.controller.login(this.username.getText(), this.password.getText());
           if(uname.equals("admin") && passs.equals("admin")){
               JOptionPane.showMessageDialog(null, "Going To Adminstrative Panel!", "Successfull", JOptionPane.WARNING_MESSAGE);
               this.dispose();
               admin nx = new admin();
               admin.as.setText(this.username.getText());
               nx.setVisible(true);
           }
            else if(user != null) {
            this.dispose();
            userpanel a = new userpanel();
            userpanel.cu.setText(this.username.getText());
            a.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Wrong User name or Password!", "INVALID", JOptionPane.WARNING_MESSAGE);
        }

       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Wrong Admin info!", "INVALID", JOptionPane.ERROR_MESSAGE);
       }
        
    }//GEN-LAST:event_loginActionPerformed

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordActionPerformed

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton login;
    private javax.swing.JPasswordField password;
    private javax.swing.JButton signup;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables

    @Override
    public boolean signup(User user) {
        return this.controller.signup(user);
    }
}
