
import Clases.TP;
import Clases.User;
import DB.DataBase;
import Estructuras.Lista;
import UI.Login;


/**
 *
 * @author maurh
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Iniciando");
        TP t = new TP();
        t=DataBase.readObj("Torn.txt", t.getClass());
        if(t==null){
            t=new TP();
        }
        t.printArr();
        t.playRound();
       //Login login = new Login();
    }
}
