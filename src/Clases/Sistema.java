package Clases;

import DB.DataBase;
import Estructuras.Lista;
import Clases.Encrypt;
import Estructuras.Pila;
import UI.MenuRace;

import javax.swing.JOptionPane;

/**
 *
 * @author maurh
 */
public class Sistema {

    private User activeUser;
    private Tournament activeTournament;
    private HorseRace activeHorseRace = new HorseRace();
    private Pila<String> betNames = new Pila<String>();
    private Pila<String> betProfits = new Pila<String>();

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

    public HorseRace getHorseRace(){
        return this.activeHorseRace;
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
        this.activeUser.deposit(mount);
    }

    public void withdrawal(Double mount) {
        this.activeUser.withdrawal(mount);
    }

    public void bet(double mount,boolean bool ,Player guyBet) {
        this.activeUser.bet(mount, bool, guyBet.getName());
        float mountF = (float) mount;
        float mountX = Operations.betResult(guyBet, mountF);
        betNames.push(guyBet.getName());
        if(bool){
            this.activeUser.deposit((double)mountX);    
            betProfits.push(String.valueOf(mountX));
        }else{
            betProfits.push(String.valueOf(String.valueOf("-"+mount)));
        }
    }


    public boolean betJ(double mount,boolean bool ,Jockey guyBet) {
        this.activeUser.bet(mount, bool, guyBet.getName());
        float mountF = (float) mount;
        float mountX = Operations.betResult(guyBet, mountF);
        betNames.push(guyBet.getName());
        if(bool){
            this.activeUser.deposit((double)mountX);
            betNames.push(guyBet.getName());
            betProfits.push(String.valueOf(mountX));
            
            return true;
        }else{
            betProfits.push(String.valueOf(String.valueOf("-"+mount)));
            return false;
        }
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

    public Player[] playRound() {
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

    public void setActiveUser(User activeUser) {
        this.activeUser = activeUser;
    }

    public Player[] winner(int round) {
        Player []arr = activeTournament.getPlayers1();
        Player[] aux;
        int i = 0;
        int j = 0;
        int lenght = 0;
        switch (round) {
            case 1:
                i = 16;
                j = 24;
                lenght=8;
                break;
            case 2:
                i = 24;
                j = 28;
                lenght=4;
                break;
            case 3:
                i = 28;
                j = 30;
                lenght=2;
                break;
            case 4:
                i = 30;
                j = 31;
                lenght=1;
                break;
            default:
                throw new AssertionError();
        }
        aux = new Player[lenght];
        int x = 0;
        for(i=i;i<j; i++){
            aux[x] = arr[i];
            x++;
        }
        //System.out.println("Mostrando arreglo");
        //activeTournament.printArr();
        return aux;
    }

    public Pila<String> getBetNames() {
        return betNames;
    }

    public void setBetNames(Pila<String> betNames) {
        this.betNames = betNames;
    }

    public Pila<String> getBetProfits() {
        return betProfits;
    }

    public void setBetProfits(Pila<String> betProfits) {
        this.betProfits = betProfits;
    }

}
