
import Clases.Tournament;
import Clases.User;
import Clases.Operations;
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

        HorseRace h = new HorseRace();
        h.playRace(h.getJockeys().peek());
       
       //Login login = new Login();
    }

}
