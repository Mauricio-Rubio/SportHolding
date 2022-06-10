
import Clases.User;
import DB.DataBase;
import Estructuras.Lista;
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

        System.out.println("Iniciando");
       Login login = new Login();
       login.run();
        System.out.println("Prueba");
        Lista<User> list = new Lista();
       User ai = new User("Ai", "212", 9979);
        User pedroUser = new User("Pedro", "22009", 334.23);
      User aux= DataBase.searchUser("Hist.txt", "kalib", "0000");
     System.out.println("User buscado" + aux);
DataBase.readWrite("Hist.txt", aux);}

}
