package Clases;
import DB.DataBase;
import Estructuras.Lista;
/**
 *
 * @author maurh
 */
public class Sistema {
    public void login(String username, String password){
        User aux = new User(username, password);
        Lista<User> auxDB = new Lista<User>();
        auxDB.add(aux);
        auxDB = DataBase.readObj("Hist.txt", auxDB.getClass());
        System.out.println("auxDB "+auxDB);
    }
    
    public void signIn(String username, String password){
        User aux = new User(username, password);
        DataBase.readWrite("Hist.txt", aux);
    }
}


