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
        User auxDB = DataBase.searchUser("Users.txt", username, password);
        System.out.println("auxDB "+auxDB);
    }
    
    public void signIn(String username, String password){
        User aux = new User(username, password);
        DataBase.readWrite("Users.txt", aux);
    }
}


