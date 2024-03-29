package javamysql.ui;

import javamysql.model.User;
import javamysql.model.UserInteractionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author t@z
 */
public class SignupForm extends javax.swing.JDialog {

    private final UserInteractionListener listener;

    /**
     * Creates new form SignupForm
     *
     * @param parent
     * @param modal
     * @param listener
     */
    public SignupForm(java.awt.Frame parent, boolean modal, UserInteractionListener listener) {
        super(parent, modal);
        this.listener = listener;
        initComponents();
        setLocationRelativeTo(parent);
        setTitle("Signup Form");
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        userName = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        password = new javax.swing.JTextField();
        signup = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("E-mail :");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(500, 330, 80, 16);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("User Name :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(500, 360, 80, 16);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Name :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(500, 390, 80, 20);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Password:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(500, 420, 80, 20);

        name.setBackground(new java.awt.Color(204, 204, 204));
        getContentPane().add(name);
        name.setBounds(590, 330, 155, 20);

        userName.setBackground(new java.awt.Color(204, 204, 204));
        userName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userNameActionPerformed(evt);
            }
        });
        getContentPane().add(userName);
        userName.setBounds(590, 360, 155, 20);

        email.setBackground(new java.awt.Color(204, 204, 204));
        getContentPane().add(email);
        email.setBounds(590, 390, 155, 20);

        password.setBackground(new java.awt.Color(204, 204, 204));
        getContentPane().add(password);
        password.setBounds(590, 420, 155, 20);

        signup.setText("Signup");
        signup.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));
        signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupActionPerformed(evt);
            }
        });
        getContentPane().add(signup);
        signup.setBounds(670, 453, 70, 30);

        clear.setText("Clear");
        clear.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        getContentPane().add(clear);
        clear.setBounds(590, 453, 70, 30);

        jButton1.setText("<Back");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(510, 453, 70, 30);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/register.jpg"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 0, 770, 510);

        setSize(new java.awt.Dimension(781, 543));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        resetAllFields();
    }//GEN-LAST:event_clearActionPerformed

    private void signupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupActionPerformed
        if (signupIsValid()) {
            User user = new User();
            user.setName(this.name.getText());
            user.setLastName(this.userName.getText());
            user.setUserName(this.email.getText());
            user.setPassword(this.password.getText());
            JOptionPane.showMessageDialog(null,"REGISSTRATION COMPLETE","SUCCESSFULL!!",JOptionPane.WARNING_MESSAGE);
            Login ob = new Login();
            ob.setVisible(true);
            if(this.listener.signup(user)) {
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Sorry, cannot signup user with the specified form values", "Please Check your form Again", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Username must not be empty!", "Please Check your form Again", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_signupActionPerformed

    private void userNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userNameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        Login obj = new Login();
        obj.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clear;
    private javax.swing.JTextField email;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField name;
    private javax.swing.JTextField password;
    private javax.swing.JButton signup;
    private javax.swing.JTextField userName;
    // End of variables declaration//GEN-END:variables

    private void resetAllFields() {
        this.name.setText(null);
        this.userName.setText(null);
        this.email.setText(null);
        this.password.setText(null);
    }

    private boolean signupIsValid() {
        return !this.email.getText().isEmpty();
    }
}
