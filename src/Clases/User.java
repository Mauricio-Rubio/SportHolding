package Clases;

import java.io.Serializable;
import Estructuras.*;
import java.io.Serializable;

/**
 * Class that represents a user of the SportHolding system
 * @author Alcantara Estrada Kevin Isaac
 * @author Rubio Haro Mauricio
 */
public class User implements Serializable{
    //Atributes of the class
    private String name = "none";
    String id = "0000";
    private double mount = 0000;
    private String password;
    private Lista<Double> withdrawals = new Lista<Double>();
    private Lista<Double> deposits = new Lista<Double>();
    private Lista<String> BetsLoses = new Lista<String>();
    private Lista<String> BetsWon = new Lista<String>();
    private int lastRoundSeen;

    /**
     * COnstructor of the class
     * @param name name of the user
     * @param password password of the user
     */
    public User(String name, String password){
    this.name = name;
    this.password = password;
    }

    /**
     * Method to set the atribute name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

        public void deposit(Double mount) {
        //this.activeUser.setMount(activeUser.getMount() + mount);
        this.mount = this.mount + mount;
        deposits.add(mount);
    }

    public Lista<Double> getWithdrawals() {
        return withdrawals;
    }

    public void setWithdrawals(Lista<Double> withdrawals) {
        this.withdrawals = withdrawals;
    }

    public Lista<Double> getDeposits() {
        return deposits;
    }

    public void setDeposits(Lista<Double> deposits) {
        this.deposits = deposits;
    }

    public Lista<String> getBetsLoses() {
        return BetsLoses;
    }

    public int getLastRoundSeen() {
        return lastRoundSeen;
    }

    public void setLastRoundSeen(int lastRoundSeen) {
        this.lastRoundSeen = lastRoundSeen;
    }

    public void setBetsLoses(Lista<String> BetsLoses) {
        this.BetsLoses = BetsLoses;
    }

    public Lista<String> getBetsWon() {
        return BetsWon;
    }

    public void setBetsWon(Lista<String> BetsWon) {
        this.BetsWon = BetsWon;
    }

    public void withdrawal(Double mount) {
        this.mount = this.mount - mount;
        withdrawals.add(mount);
    }

    public void bet(Double mount, boolean won, String guyBet) {
        withdrawal(mount);
        if(won){
            BetsWon.add(guyBet);
        }else{
            BetsLoses.add(guyBet);
        }
    }
    
    /**
     * Method to set the atribute id
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Method to set the atribute mount
     * @param mount
     */
    public void setMount(double mount) {
        this.mount = mount;
    }

    /**
     * Constructor of the class
     * @param name
     * @param id
     * @param d
     */
    public User(String name, String id, double d) {
        this.name = name;
        this.id = id;
        this.mount = d;
    }

    /**
     * Method to get the value of the atribute name
     * @return String
     */
    public String getName(){
        return this.name;
    }
    /**
     * Method to get the value of the atribute id
     * @return String
     */
    public String getId(){
        return this.id;
    }

    public double getMount() {
        return this.mount;

    }

/**
 * Method to get the value of the atribute password
 * @return String
 */
    public String getPassword() {
        return this.password;
    }

    /**
     * Method to set the value of the atribute password
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }


    @Override 
    /**
     * Method to represent a instance of the class as an String
     * @return String
     */
    public String toString(){
        return this.name+" "+this.mount+" "+this.password;
    }
}
