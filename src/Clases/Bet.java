/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.Serializable;

/**
 *
 * @author maurh
 */
public class Bet implements Serializable{
    public String [] players;
    public String winner;
    public String mount;
    public String profit;

    public Bet(String[] players, String winner, String mount, String profit) {
        this.players = players;
        this.winner = winner;
        this.mount = mount;
        this.profit = profit;
    }
 
    public String[] getPlayers() {
        return players;
    }

    public void setPlayers(String[] players) {
        this.players = players;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getMount() {
        return mount;
    }

    public void setMount(String mount) {
        this.mount = mount;
    }

    public String getProfit() {
        return profit;
    }

    public void setProfit(String profit) {
        this.profit = profit;
    }

    @Override
    public String toString() {
        return "Bet{" + "players=" + players + ", winner=" + winner + ", mount=" + mount + ", profit=" + profit + '}';
    }   
}
