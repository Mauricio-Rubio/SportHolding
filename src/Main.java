
//import Clases.User;
import DB.DataBase;
import Estructuras.Lista;
import UI.Login;

import java.util.Iterator;

import Clases.*;
//import Estructuras.Lista;




/**
 *
 * @author maurh
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("Iniciando");
       Login login = new Login();
       login.run();
       DataBase.searchUser("Hist.txt", "Ulises", "0000");
       /*  System.out.println("Prueba");
        Lista<User> list = new Lista();
        Player a = new Player();
        Player b= new Player();*/

       /*TP t = new TP();
       t= DataBase.readObj("Torn.txt", t.getClass());
       if(t==null){
           t = new TP();
       }

       t.printArr();
      // 
       //TP c = DataBase.readObj("Torn.txt", t.getClass());
       System.out.println();
      // c.printArr();
      t.printArr();
      t.playRound();
      t.playRound();
      t.playRound();


       //User ai = new User("Ai", "212", 9979);
      //  User pedroUser = new User("Pedro", "22009", 334.23);
     // User aux= DataBase.searchUser("Hist.txt", "kalib", "0000");
    // System.out.println("User buscado" + aux);
//DataBase.readWrite("Hist.txt", aux);}/* */
    }


}
