import Estructuras.*;
import UI.Login;
public class Main {
    public static void main(String[] args) {
        //User usr = new User();
        Lista<Integer> miLista = new Lista<>();
        //miLista.add(usr);
        for (int i = 0; i < 5; i++) {
            miLista.add(i);
        }
        System.out.println("Lista\n "+miLista);
        Login login = new Login();
        login.run();
        //ArbolBinarioBusqueda<Integer> arbolito = new ArbolBinarioBusqueda<>();
        //arbolito.buildSorted(miLista);
        //System.out.println("Arbol\n "+arbolito);
        
    }
}
