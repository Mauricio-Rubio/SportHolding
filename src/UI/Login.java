package UI;

import java.awt.Toolkit;
import Clases.Sistema;
import Clases.Encrypt;
import DB.DataBase;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author maurh
 */
public final class Login extends javax.swing.JFrame {

    Sistema sistema = new Sistema();

    public Login() {
        DataBase.showDB("Users.txt");
        initComponents();
        this.setTitle("Sport Holding Login");
        this.closeWindow();
        this.setVisible(true);
        //this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Images/Logo.png")));
        //this.run();
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
        jLabel1 = new javax.swing.JLabel();
        tFUsername = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        btnLog = new javax.swing.JButton();
        btnSign = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Login");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 50, 38));

        tFUsername.setBackground(new java.awt.Color(204, 204, 204));
        tFUsername.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tFUsername.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tFUsernameFocusGained(evt);
            }
        });
        tFUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tFUsernameActionPerformed(evt);
            }
        });
        jPanel1.add(tFUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 116, 246, 35));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Username");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 94, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Password");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 185, -1, -1));

        jPasswordField1.setBackground(new java.awt.Color(204, 204, 204));
        jPasswordField1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel1.add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 219, 246, 38));

        btnLog.setBackground(new java.awt.Color(214, 169, 92));
        btnLog.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLog.setForeground(new java.awt.Color(255, 255, 255));
        btnLog.setText("Login");
        btnLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogActionPerformed(evt);
            }
        });
        jPanel1.add(btnLog, new org.netbeans.lib.awtextra.AbsoluteConstraints(227, 293, 75, 35));

        btnSign.setBackground(new java.awt.Color(214, 169, 92));
        btnSign.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSign.setForeground(new java.awt.Color(255, 255, 255));
        btnSign.setText("Sign In");
        btnSign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignActionPerformed(evt);
            }
        });
        jPanel1.add(btnSign, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 293, -1, 35));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Fondo.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 337, 350));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tFUsernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tFUsernameFocusGained
        this.tFUsername.setText("");
    }//GEN-LAST:event_tFUsernameFocusGained

    private void btnLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogActionPerformed
        
        System.out.println("User "+tFUsername.getText());
        System.out.println("password "+jPasswordField1.getText());
        if (sistema.login(tFUsername.getText(), Encrypt.encrypt(jPasswordField1.getText()))) {
            dispose();
            Menu menu = new Menu(sistema);
        }


    }//GEN-LAST:event_btnLogActionPerformed

    public void closeWindow(){
        try {
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter(){
                public void windowClosing(WindowEvent e){
                    confirmClose();
                }
            });
            this.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void confirmClose(){
        int z = JOptionPane.showConfirmDialog(this, "Do you want to exit?", "Warning", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
        if(z == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }
    
    private void btnSignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignActionPerformed
        dispose();
        SignIn signin = new SignIn(sistema);
        //signin.run();
        //this.setVisible(false);
    }//GEN-LAST:event_btnSignActionPerformed

    private void tFUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tFUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tFUsernameActionPerformed

    public void setNimbusLookAndFeel() {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLog;
    private javax.swing.JButton btnSign;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField tFUsername;
    // End of variables declaration//GEN-END:variables

}