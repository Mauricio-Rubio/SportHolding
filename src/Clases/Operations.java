package Clases;

import Estructuras.*;
import Clases.Jockey;
import Clases.HorseRace;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Iterator;

/**
 * Class to do mathematical operations and some probability calculations
 *
 * @author Alcantara Estrada Kevin Isaac
 * @author Rubio Haro Mauricio
 */
public class Operations {

    /**
     * Method to calculate the probability of winning the combat of two players
     * based on their skill
     *
     * @param p1 First instance of the Player class
     * @param p2 Second instance of the Player class
     */
    public static void calculateP(Player p1, Player p2) {
        float ph1 = p1.getH();
        float ph2 = p2.getH();

        float win1;
        float win2;

        win1 = (float) (ph1) / (ph1 + ph2);
        win2 = (float) (ph2) / (ph1 + ph2);
        win1 = (float) Math.round(win1 * 100);
        win2 = (float) Math.round(win2 * 100);

        p1.setProbability(win1);
        p2.setProbability(win2);
    }

    /**
     * Method that determine the winner of a combat between two competitors
     *
     * @param p1 First instance of the Player class
     * @param p2 Second instance of the Player class
     * @return Player
     */
    public static Player winner(Player p1, Player p2) {
        int prob = (int) p1.getProbability();
        int j = (int) (Math.random() * (100 - 1)) + 1;

        if (j <= prob) {

            return p1;
        } else {

            return p2;
        }
    }

    /**
     * Method to calculate the percentage of profit when betting on a competitor
     *
     * @param p Competitor you want to bet on
     * @return float
     */
    public static float betProbability(Player p) {
        float c = p.getProbability() / 100;
        float bp = 1 / c;
        BigDecimal bd = new BigDecimal(bp).setScale(2, RoundingMode.HALF_UP);
        bp = bd.floatValue();
        return bp;
    }

    /**
     * Method to calculate the profits of your bet
     *
     * @param p Competitor you bet on
     * @param bet The amount of your bet
     * @return float
     */
    public static float betResult(Player p, float bet) {
        float r = (float) bet * betProbability(p);
        return r;
    }

    /**
     * Method to calculate the percentage of profit when betting on a jockey
     *
     * @param j Jockey you want to bet on
     * @return float
     */
    public static float betJockey(Jockey j) {
        float bj = 1 / j.getProbability();
        BigDecimal bd = new BigDecimal(bj).setScale(2, RoundingMode.HALF_UP);
        bj = bd.floatValue();
        return bj;
    }

    /**
     * Method to calculate the profits of your bet
     *
     * @param j Jockey you bet on
     * @param bet The amount of your bet
     * @return float
     */
    public static float betResult(Jockey j, float bet) {
        float r = (float) bet * betJockey(j);
        return r;
    }

    /**
     * Method that determine the winner of a combat between the competitors of
     * the race
     *
     * @param h instance of the HorseRace class
     * @return Lista<Jockey>
     */
    public static Lista<Jockey> jockeysPos(HorseRace h) {
        int p = 0;
        int rand = 0;
        Lista<Jockey> copy = h.getJockeys();//we copy the jockeys of the HorseRace instance
        Lista<Jockey> yaquisPos = new Lista();
        Iterator<Jockey> iteCopy = copy.iterator();
        Jockey[] yaquis = new Jockey[copy.size()];
        while (iteCopy.hasNext()) {
            Jockey aux = iteCopy.next();
            aux.calculateProbability(h.getJockeys().size());//calculate the probability of winning
            yaquis[p] = aux;//we inser each jockey in to the array
            p++;
        }

        int ran = 0;

        int i = 0;
        int n = yaquis.length;
        Jockey temp = null;
        for (i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (yaquis[j - 1].getProbability() < yaquis[j].getProbability()) {  //Use of the bubble sort algorithm to order the competitors according to their probability of winning
                    temp = yaquis[j - 1];
                    yaquis[j - 1] = yaquis[j];
                    yaquis[j] = temp;
                }

            }
        }

        for (i = 0; i < yaquis.length; i++) {
            float k = (float) Math.random();
            if (k <= yaquis[i].getProbability()) {//We check if a jockey wins the race according to his probability of winning
                // if he wins, he is placed at the top of the list and the rest of the jockeys are randomly distributed
                Jockey winner = yaquis[i];

                for (i = 0; i < yaquis.length; i++) {
                    ran = (int) (Math.random() * (yaquis.length - 1));
                    Jockey a = yaquis[i];
                    yaquis[i] = yaquis[ran];
                    yaquis[ran] = a;
                }

                for (Jockey e : yaquis) {
                    yaquisPos.add(e);
                }
                yaquisPos.delete(winner);
                yaquisPos.agregaInicio(winner);
                return yaquisPos;
            }
        }

        //if neither jockey wins, the positions are given randomly
        for (i = 0; i < yaquis.length; i++) {
            ran = (int) (Math.random() * (yaquis.length - 1));
            Jockey a = yaquis[i];
            yaquis[i] = yaquis[ran];
            yaquis[ran] = a;
        }

        for (Jockey e : yaquis) {
            yaquisPos.add(e);
        }
        return yaquisPos;
    }

    public static Lista<String> listToString(Lista<Double> lista) {
        Lista<String> aux = new Lista<>();
        Iterator iterador = lista.iterator();
        while (iterador.hasNext()) {
            aux.add(String.valueOf(iterador.next()));
        }
        return aux;
    }
}
