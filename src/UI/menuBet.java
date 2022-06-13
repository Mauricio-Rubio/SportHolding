package UI;

import Clases.Sistema;
import DB.DataBase;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import Clases.Operations;
import Clases.Player;
import Clases.User;

/**
 *
 * @author maurh
 */
public final class menuBet extends javax.swing.JFrame {

    Sistema sistema;
    private String betGuy = "";
    private int INDEXX;
    private boolean statusReturn = false;
    private Player temp1;
    private Player temp2;

    public Sistema getSistema() {
        return this.sistema;
    }

    public boolean getStatusReturn() {
        return this.statusReturn;
    }

    public menuBet(Sistema sistema, int index) {
        int index2;
        DataBase.showDB("Users.txt");
        initComponents();
        this.setTitle("Sport Holding Login");
        this.closeWindow();
        this.setVisible(true);
        this.sistema = sistema;
        if (index % 2 == 0) {
            index2 = index * 2;
            //jP1.setText(sistema.getActiveTournament().getPlayers1()[index2].getName());
            jP1.setText(sistema.getActiveTournament().getPlayers1()[index2].getName());
            temp1 = sistema.getActiveTournament().getPlayers1()[index2];
            this.jLPC1.setText("quota " + String.valueOf(Operations.betProbability(sistema.getActiveTournament().getPlayers1()[index2])));
            jP2.setText(sistema.getActiveTournament().getPlayers1()[index2 + 1].getName());
            temp2 = sistema.getActiveTournament().getPlayers1()[index2 + 1];
            this.jLPC2.setText("quota " + String.valueOf(Operations.betProbability(sistema.getActiveTournament().getPlayers1()[index2 + 1])));
        } else {
            index2 = index * 2;
            jP1.setText(sistema.getActiveTournament().getPlayers1()[index2].getName());
            temp1 = sistema.getActiveTournament().getPlayers1()[index2];
            this.jLPC1.setText("quota " + String.valueOf(Operations.betProbability(sistema.getActiveTournament().getPlayers1()[index2])));
            jP2.setText(sistema.getActiveTournament().getPlayers1()[index2 + 1].getName());
            temp2 = sistema.getActiveTournament().getPlayers1()[index2 + 1];
            this.jLPC2.setText("quota " + String.valueOf(Operations.betProbability(sistema.getActiveTournament().getPlayers1()[index2 + 1])));
        }
        jP1.setActionCommand(jP1.getText());
        jP2.setActionCommand(jP2.getText());
        jLMount.setText(String.valueOf(sistema.getActiveUser().getMount()));
        this.INDEXX = index;
    }

    public boolean winnerArr(int index) {
        Player[] aux = null;
        if (index >= 0 && index < 8) {
            aux = sistema.winner(1);
            System.out.println("Opcion 1");
        } else if (index >= 8 && index <= 11) {
            aux = sistema.winner(2);
            System.out.println("Opcion 2");
        } else if (index >= 12 && index <= 13) {
            aux = sistema.winner(3);
            System.out.println("Opcion 3");
        } else if (index == 14) {
            aux = sistema.winner(4);
            System.out.println("Opcion 4");
        } else {
            System.out.println("No entro a ningun caso");
        }
        return winner(aux, index);
    }

    public boolean winner(Player[] arr, int index) {
        for (Player u : arr) {
            if (u.getName().equals(betGuy)) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLMount = new javax.swing.JLabel();
        btnLog = new javax.swing.JButton();
        jLPC1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLPC2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jP1 = new javax.swing.JRadioButton();
        jP2 = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Bet");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 50, 38));

        jLMount.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLMount.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jLMount, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, 130, 30));

        btnLog.setBackground(new java.awt.Color(214, 169, 92));
        btnLog.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLog.setForeground(new java.awt.Color(255, 255, 255));
        btnLog.setText("Bet");
        btnLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogActionPerformed(evt);
            }
        });
        jPanel1.add(btnLog, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 410, 75, 30));

        jLPC1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLPC1.setForeground(new java.awt.Color(255, 255, 255));
        jLPC1.setText("1");
        jPanel1.add(jLPC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 200, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("vs");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 200, 30));

        jLPC2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLPC2.setForeground(new java.awt.Color(255, 255, 255));
        jLPC2.setText("1");
        jPanel1.add(jLPC2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 200, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Enter your bet (min. 50)");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 190, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Available money");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 130, 30));

        jTextField1.setBackground(new java.awt.Color(214, 169, 92));
        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 330, 80, 50));

        jP1.setBackground(new java.awt.Color(214, 169, 92));
        buttonGroup1.add(jP1);
        jP1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jP1ActionPerformed(evt);
            }
        });
        jPanel1.add(jP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 69, 160, 30));

        jP2.setBackground(new java.awt.Color(214, 169, 92));
        buttonGroup1.add(jP2);
        jP2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(jP2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 160, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Fondo.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 450));

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

    private void btnLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogActionPerformed
        betGuy = buttonGroup1.getSelection().getActionCommand();
        if (betGuy.equals(temp1.getName())) {
            System.out.println("xxx " + temp1);
        } else {
            System.out.println("xxx " + temp2);
            temp1 = temp2;
        }
        //System.out.println(auxGuy);
        User aux = sistema.getActiveUser();
        try {
            Double mount = Double.valueOf(jTextField1.getText());
            if (mount >= 50 && aux.getMount() >= mount && betGuy != null) {
                int z = JOptionPane.showConfirmDialog(this, "Shure you want to bet?", "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (z == JOptionPane.YES_OPTION) {
                    sistema.bet(mount, winnerArr(INDEXX), temp1);
                    statusReturn = true;
                    this.dispose();
                }
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Verify your data ");
        }
    }//GEN-LAST:event_btnLogActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jP1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jP1ActionPerformed

    public void closeWindow() {
        try {
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    confirmClose();
                }
            });
            this.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void confirmClose() {
        int z = JOptionPane.showConfirmDialog(this, "Do you want to exit?", "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        if (z == JOptionPane.YES_OPTION) {
            this.dispose();
            //sistema.saveUser();
            //System.out.println("Saving sistem");
        }
    }

    public void setNimbusLookAndFeel() {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(menuBet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menuBet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menuBet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menuBet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLog;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLMount;
    private javax.swing.JLabel jLPC1;
    private javax.swing.JLabel jLPC2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JRadioButton jP1;
    private javax.swing.JRadioButton jP2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

}
