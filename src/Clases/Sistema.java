package Clases;

import DB.DataBase;
import Estructuras.Lista;
import Clases.Encrypt;
import javax.swing.JOptionPane;

/**
 *
 * @author maurh
 */
public class Sistema {

    private User activeUser;
    private Tournament activeTournament;

    public boolean login(String username, String password) {
        DataBase.showDB("Users.txt");
        System.out.println("Contraseña que llega login " + password);
        User aux = new User(username, password);
        User auxDB = DataBase.searchUser("Users.txt", username, password);
        //User auxDB = null;
        activeUser = auxDB;
        System.out.println("auxDB " + auxDB);
        if (auxDB == null) {
            JOptionPane.showMessageDialog(null, "Please verify your User and Password");
            return false;
        }
        return true;

    }

    public User getActiveUser() {
        return activeUser;
    }

    public Tournament getActiveTournament() {
        return activeTournament;
    }

    public void setActiveTournament(Tournament activeTournament) {
        this.activeTournament = activeTournament;
    }

    public boolean changePassword(String password) {
        DataBase.showDB("Users.txt");
        this.activeUser.setPassword(password);
        System.out.println("-->" + activeUser);
        return true;
    }

    public void deposit(Double mount) {
        this.activeUser.setMount(mount);
    }

    public void withdrawal(Double mount) {
        this.activeUser.setMount(activeUser.getMount() - mount);
    }

    public boolean signIn(String username, String password) {
        System.out.println("Contraseña que llega Sign In" + password);
        User aux = new User(username, password);
        User auxDB = DataBase.searchUser("Users.txt", username, password);
        if (auxDB != null) {
            DataBase.readWrite("Users.txt", aux);
            return false;
        } else {
            System.out.println("registering");
            DataBase.readWrite("Users.txt", aux);
            return true;
        }
    }

    public void saveUser() {
        DataBase.readWrite("Users.txt", activeUser);
        System.out.println("Saving " + activeUser);
    }

    public Player[] chargeTournament() {
        this.activeTournament = new Tournament();
        this.activeTournament.playRound();
        Player[] aux = this.activeTournament.getPlayers1();
        return aux;
    }

    public Player favorite(Player player1, Player player2) {
        if (player1.getH() > player2.getH()) {
            return player1;
        } else {
            return player2;
        }
    }

    public Player underdog(Player player1, Player player2) {
        if (player1.getH() < player2.getH()) {
            return player1;
        } else {
            return player2;
        }
    }
    
    public Player [] playRound(){
        this.activeTournament.playRound();
        sleepThread(1000);
        return this.activeTournament.getPlayers1();
    }

    public void sleepThread(int n) {
        try {
            Thread.sleep(2 * n);
        } catch (Exception e) {
        }
    }
}
