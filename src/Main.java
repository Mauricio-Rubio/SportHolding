import Estructuras.*;
public class Main {
    public static void main(String[] args) {
        //User usr = new User();
        Lista<Integer> miLista = new Lista<>();
        //miLista.add(usr);
        for (int i = 0; i < 5; i++) {
            miLista.add(i);
        }
        ArbolBinarioBusqueda<Integer> arbolito = new ArbolBinarioBusqueda<>();
        arbolito.buildSorted(miLista);
        System.out.println("Arbol\n "+arbolito);
    }
}
