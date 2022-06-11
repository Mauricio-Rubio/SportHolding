package Clases;
import DB.DataBase;
import Estructuras.Lista;
import Clases.Encrypt;
import javax.swing.JOptionPane;
/**
 *
 * @author maurh
 */
public class Sistema {
    public void login(String username, String password){
        User aux = new User(username, password);
        User auxDB = DataBase.searchUser("Users.txt", username, password);
        System.out.println("auxDB "+auxDB);
        if(auxDB == null){
              JOptionPane.showMessageDialog(null, "Please verify your User and Password");
        }
    }
    
    public void signIn(String username, String password){
        User aux = new User(username, password);
        DataBase.readWrite("Users.txt", aux);
    }
}


