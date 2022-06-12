
import Clases.TP;
import Clases.User;
import Clases.Camp;
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
       Jockey a = new Jockey("Alonso");
       Jockey b = new Jockey("Juan");
       Jockey c= new Jockey("Pedro");
       Jockey d = new Jockey("GIancarlo");
       Jockey e = new Jockey("Kevin");
       Jockey f = new Jockey("Jabba");
       Lista<Jockey> list = new Lista<Jockey>();
      list.add(a);
       list.add(b);
       list.add(c);
       list.add(d);
       list.add(e);
       list.add(f); 

       
System.out.println(list);
System.out.println(Camp.jockeysPos(f,list));

System.out.println(list);
      /* System.out.println(a.getHist());
       a.calculateProbability(6);
       System.out.println(a.getProbability());
       System.out.println(Camp.betJockey(a));
       System.out.println(Camp.betResult(a, 250));*/
       //Login login = new Login();
    }

}
