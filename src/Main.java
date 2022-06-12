
import Clases.TP;
import Clases.User;
import Clases.Camp;
import Clases.HorseRace;
import Clases.Jockey;
import DB.DataBase;
import Estructuras.*;
import UI.Login;


import java.util.Iterator;

//import Estructuras.Lista;



/**
 *
 * @author maurh
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("Iniciando");
      HorseRace h = new HorseRace();
      System.out.println(h.getJockeys());
      h.playRace(h.getJockeys().peek());
      //System.out.println(h.getJockeys());
      /* System.out.printn(a.getHist());
       a.calculateProbability(6);
       System.out.println(a.getProbability());
       System.out.println(Camp.betJockey(a));
       System.out.println(Camp.betResult(a, 250));*/
       //Login login = new Login();
    }

}
