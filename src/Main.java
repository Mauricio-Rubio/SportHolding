
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
        Lista<User> list = new Lista<User>();
        User pedroUser = new User("Pedro", "22009", 334.23);
        User al = new User("Al", "200009", 0.23);
       User beto = new User("Beto", "09", 33400.23);
       list.add(al);
     list.add(pedroUser);
        list.add(beto);
       
        Lista<User> lista = DataBase.readObj("Hist.txt", list.getClass());
       
    
  
    User aux= new User("","", 0000);
    System.out.println(lista.toString());
 
    Iterator ite = lista.iterator();
 
    while(ite.hasNext()){
        @SuppressWarnings("unchecked")
      User aux2= (User) ite.next();
    
     
        if(aux2.getName().compareTo("Beto")==0){
            aux=aux2;
            lista.delete(aux2);
            System.out.println(aux.toString());
            aux.setMoney(585);
        }
    }

   lista.add(aux);
   DataBase.writeObj("Hist.txt", lista);
   
    }
}
