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
    private User activeUser;
    public boolean login(String username, String password){
        System.out.println("Contraseña que llega "+password);
        User aux = new User(username, password);
        User auxDB = DataBase.searchUser("Users.txt", username, password);
        activeUser = auxDB;
        System.out.println("auxDB "+auxDB);
        if(auxDB == null){
              JOptionPane.showMessageDialog(null, "Please verify your User and Password");
              return false;
        }
        return true;
    }
    
    public void signIn(String username, String password){
        System.out.println("Contraseña que llega "+password);
        User aux = new User(username, password);
        DataBase.readWrite("Users.txt", aux);
    }
    
    public void saveUser(){
        DataBase.readWrite("Users.txt", activeUser);
        System.out.println("Salvando "+activeUser);
    }
}


