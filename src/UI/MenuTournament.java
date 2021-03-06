package UI;

import Clases.Player;
import Clases.Sistema;
import Clases.Tournament;
import Clases.User;
import static DB.DataBase.readObj;
import Estructuras.Pila;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author maurh
 */
public final class MenuTournament extends javax.swing.JFrame {

    public Sistema sistema;
    private int optionStart = -1;

    /**
     * Creates new form Login
     */
    public MenuTournament(Sistema sistema) {
        initComponents();
        this.setTitle("Sport Holding");
        this.closeWindow();
        this.sistema = sistema;
        this.jLabelMount.setText("Money available " + String.valueOf(sistema.getActiveUser().getMount()));
        this.setVisible(true);
        //initTable();
    }

    /**
     * Creates new form Login
     */
    public MenuTournament(Sistema sistema, int lastSeen) {
        initComponents();
        this.setTitle("Sport Holding");
        this.closeWindow();
        this.sistema = sistema;
        this.jLabelMount.setText("Money available " + String.valueOf(sistema.getActiveUser().getMount()));
        this.setVisible(true);
        optionStart = -2;
        //optionStart = sistema.getActiveUser().getLastRoundSeen();
        Tournament t = new Tournament();
        t = readObj("Torn.txt", t.getClass());
        if (t == null) {
            JOptionPane.showMessageDialog(
                    this,
                    "Theres not saved tournament");
        } else {

            this.sistema.setActiveTournament(t);
            int j = sistema.getActiveUser().getLastRoundSeen();
            /*initTable(this.sistema.getActiveTournament().getPlayers1());
            System.out.println("Entro aqui");
            System.out.println("##### " + j);*/
            if (j == -2) {
                j = 1;
            } else if (j == 0) {
                j = 2;
            } else if (j == 1) {
                j = 3;
            } else if (j == 2) {
                j = 4;
            } else if (j == 3) {
                j = 5;
            } else {
                JOptionPane.showMessageDialog(
                        this,
                        "The tournament has been ended ");
                return;
            }
            for (int i = 0; i < j; i++) {
                //System.out.println("Do click " + i);
                jButton3.doClick();
                //System.out.println("##### " + j);
            }
        }

    }

    private void initTable(Player[] arr) {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        String[] row = new String[5];
        for (int i = 0; i < 16; i += 2) {
            row[0] = "1";
            row[1] = arr[i].getName();
            row[2] = arr[i + 1].getName();
            Player favorite = sistema.favorite(arr[i], arr[i + 1]);
            row[3] = favorite.getName();
            Player underDog = sistema.underdog(arr[i], arr[i + 1]);
            row[4] = underDog.getName();
            modelo.addRow(row);
        }

    }

    public void winner1() {
        Player[] arr = sistema.getActiveTournament().getPlayers1();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        String[] row = new String[6];
        String[] rowWinner = new String[8];
        //Player [] aux = sistema.playRound();
        int x = 0;
        for (int i = 16; i < 24; i++) {
            rowWinner[x] = arr[i].getName();
            x++;
        }
        x = 0;
        for (int i = 0; i < 16; i += 2) {
            row[0] = "1";
            row[1] = arr[i].getName();
            row[2] = arr[i + 1].getName();
            Player favorite = sistema.favorite(arr[i], arr[i + 1]);
            row[3] = favorite.getName();
            Player underDog = sistema.underdog(arr[i], arr[i + 1]);
            row[4] = underDog.getName();
            row[5] = rowWinner[x];
            model.addRow(row);
            x++;
        }
        showNextRound(1);
    }

    public void showNextRound(int round) {
        int i = 0;
        int b = 0;
        String a = "0";
        switch (round) {
            case 1:
                i = 16;
                b = 24;
                a = "2";
                break;
            case 2:
                i = 24;
                b = 28;
                a = "3";
                break;
            case 3:
                i = 28;
                b = 30;
                a = "4";
                break;
            default:
                throw new AssertionError();
        }
        sistema.sleepThread(2000);
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        Player[] arr = sistema.getActiveTournament().getPlayers1();
        String[] row = new String[5];
        for (i = i; i < b; i += 2) {
            row[0] = a;
            row[1] = arr[i].getName();
            row[2] = arr[i + 1].getName();
            Player favorite = sistema.favorite(arr[i], arr[i + 1]);
            row[3] = favorite.getName();
            Player underDog = sistema.underdog(arr[i], arr[i + 1]);
            row[4] = underDog.getName();
            model.addRow(row);
        }
    }

    public void winner2() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.removeRow(12 - 1);
        model.removeRow(12 - 2);
        model.removeRow(12 - 3);
        model.removeRow(12 - 4);
        Player[] arr = sistema.getActiveTournament().getPlayers1();
        String[] row = new String[6];
        int x = 24;
        for (int i = 16; i < 24; i += 2) {
            row[0] = "2";
            row[1] = arr[i].getName();
            row[2] = arr[i + 1].getName();
            Player favorite = sistema.favorite(arr[i], arr[i + 1]);
            row[3] = favorite.getName();
            Player underDog = sistema.underdog(arr[i], arr[i + 1]);
            row[4] = underDog.getName();
            row[5] = arr[x].getName();
            model.addRow(row);
            x++;
        }
        showNextRound(2);
    }

    public void winner3() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.removeRow(14 - 1);
        model.removeRow(14 - 2);
        Player[] arr = sistema.getActiveTournament().getPlayers1();
        String[] row = new String[6];
        int x = 28;
        for (int i = 24; i < 28; i += 2) {
            row[0] = "3";
            row[1] = arr[i].getName();
            row[2] = arr[i + 1].getName();
            Player favorite = sistema.favorite(arr[i], arr[i + 1]);
            row[3] = favorite.getName();
            Player underDog = sistema.underdog(arr[i], arr[i + 1]);
            row[4] = underDog.getName();
            row[5] = arr[x].getName();
            model.addRow(row);
            x++;
        }
        showNextRound(3);
    }

    public void winner4() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.removeRow(15 - 1);
        Player[] arr = sistema.getActiveTournament().getPlayers1();
        String[] row = new String[6];
        int x = 30;
        this.sistema.sleepThread(1200);
        for (int i = 28; i < 30; i += 2) {
            row[0] = "4";
            row[1] = arr[i].getName();
            row[2] = arr[i + 1].getName();
            Player favorite = sistema.favorite(arr[i], arr[i + 1]);
            row[3] = favorite.getName();
            Player underDog = sistema.underdog(arr[i], arr[i + 1]);
            row[4] = underDog.getName();
            row[5] = arr[x].getName();
            model.addRow(row);
            x++;
        }
    }

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
        int seleccion = JOptionPane.showOptionDialog(
                this,
                "Do you want to exit?",
                "Warning",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, // null para icono por defecto.
                new Object[]{"Exit", "Sign Out", "Cancel"}, // null para YES, NO y CANCEL
                "opcion 1");

        if (seleccion == 0) {
            System.out.println("0");
            sistema.saveUser();
            System.out.println("Saving sistem");
            System.exit(0);
        }
        if (seleccion == 1) {
            System.out.println("1");
            Login login = new Login();
            sistema.saveUser();
            System.out.println("Saving sistem");
            dispose();
        }
        if (seleccion == 2) {
            System.out.println("seleccionada opcion 2");
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

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabelMount = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Sport Holding");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 170, 80));

        jButton4.setBackground(new java.awt.Color(214, 169, 108));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setText("Back");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 450, 120, 40));

        jButton3.setBackground(new java.awt.Color(214, 169, 108));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("Start");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 440, 120, 40));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Round", "Fighter", "Fighter", "Favorite", "Underdog", "Winner"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 840, 250));

        jLabelMount.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelMount.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jLabelMount, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 230, 40));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setForeground(new java.awt.Color(255, 102, 102));
        jLabel1.setOpaque(true);
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, 510));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        User currentUser = sistema.getActiveUser();
        Pila<String> aux = sistema.getBetNames();
        Pila<String> aux2 = sistema.getBetProfits();
        if (optionStart == -2) {
            
            initTable(this.sistema.getActiveTournament().getPlayers1());
            currentUser.setLastRoundSeen(-2);
            optionStart = 0;
        } else if (optionStart == -1) {
            
            initTable(this.sistema.chargeTournament());
            currentUser.setLastRoundSeen(-2);
            optionStart++;
        } else if (optionStart == 0) {
            
            currentUser.setLastRoundSeen(0);
            this.winner1();
            optionStart++;
        } else if (optionStart == 1) {
            
            currentUser.setLastRoundSeen(1);
            this.winner2();
            optionStart++;
        } else if (optionStart == 2) {
            currentUser.setLastRoundSeen(2);
            this.winner3();
            optionStart++;
        } else if (optionStart == 3) {
            currentUser.setLastRoundSeen(3);
            this.winner4();
            optionStart++;
        }
        if (optionStart >= 4) {
            JOptionPane.showMessageDialog(
                    this,
                    "The tournament has been ended ");
            sistema.setActiveTournament(null);
        }
        this.jLabelMount.setText("Money available " + String.valueOf(sistema.getActiveUser().getMount()));
        System.out.println("Pilas lenght -->" + aux.size());
        int lenght = aux.size();
        for (int i = 0; i < lenght; i++) {
            JOptionPane.showMessageDialog(
                    this,
                    "You have bet on " + aux.pop() + " you have obteined " + aux2.pop());
        }
        sistema.setBetNames(aux);
        sistema.setBetProfits(aux2);
        sistema.setActiveUser(currentUser);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int index = this.jTable1.getSelectedRow();
        TableModel model = jTable1.getModel();
        if (model.getValueAt(index, 5) == null) {
            menuBet bet = new menuBet(sistema, index);
            //System.out.println("Este es el usuario que llega "+sistema.getActiveUser());
        }
        this.jLabelMount.setText("Money available " + String.valueOf(sistema.getActiveUser().getMount()));
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        System.out.println("Tournament " + sistema.getActiveTournament());
        if (sistema.getActiveTournament() == null) {
            Menu menu = new Menu(sistema);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "You have already started a tournament");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    /* public void run(){
     new Menu().setVisible(true);
    }*/
    public void setNimbusLookAndFeel() {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuTournament.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuTournament.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuTournament.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuTournament.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelMount;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}
