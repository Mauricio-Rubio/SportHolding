
import UI.Login;

import java.util.Iterator;

import Clases.*;
import Estructuras.*;



/**
 *
 * @author maurh
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Prueba");
        Lista<User> list = new Lista();
        User pedroUser = new User("Pedro", "22009", 334.23);
       DataBase.readWrite("Hist.txt", pedroUser);
   list = DataBase.readObj("Hist.txt", list.getClass());
   
    }
}
