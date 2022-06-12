package Clases;
import java.math.BigDecimal;
import java.math.RoundingMode;
/**
 * Class to do mathematical operations and some probability calculations
 * @author Alcantara Estrada Kevin Isaac
 * @author Rubio Haro Mauricio
 */
public class Camp{

    /**
     * Method to calculate the probability of winning the combat of two players based on their skill
     * @param p1 First instance of the Player class
     * @param p2 Second instance of the Player class
     */
    public static void calculateP(Player p1, Player p2){
        float ph1= p1.getH();
        float ph2= p2.getH();
        
        float win1;
        float win2;

        win1 =(float) (ph1)/(ph1+ph2);
        win2= (float) (ph2)/(ph1+ph2);
        win1 = (float) Math.round(win1 * 100) ;
        win2 = (float) Math.round(win2 * 100) ;

        p1.setProbability(win1);
        p2.setProbability(win2);
    }


    /**
     * Method that determine the winner of a combat between two competitors
     * @param p1 First instance of the Player class
     * @param p2 Second instance of the Player class
     * @return Player
     */
    public static Player winner(Player p1, Player p2){
        int prob =(int) p1.getProbability();
        int j = (int) (Math.random()*(100-1)) + 1;

        if(j<=prob){

        return p1;
        }else{

            return p2;
        }
    }

    /**
     * Method to calculate the percentage of profit when betting on a competitor
     * @param p Competitor you want to bet on
     * @return float
     */
    public static float betProbability(Player p){
        float c = p.getProbability()/100;
        float bp = 1/c ;
        BigDecimal bd = new BigDecimal(bp).setScale(2, RoundingMode.HALF_UP);
        bp = bd.floatValue();
        return bp;
    }

    /**
     * Method to calculate the profits of your bet
     * @param p Competitor you bet on
     * @param bet The amount of your bet
     * @return float
     */
    public static float betResult(Player p, float bet){
         float r= (float) bet* betProbability(p);
                  return r;
    }
}