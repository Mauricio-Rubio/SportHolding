
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
       // DataBase.writeObj("Hist.txt", list);
	//juan.hist.add("100 peso");
    //juan.hist.add("Deposito");
  // DataBase.writeObj("Hist.txt", list);
    
        Lista<User> lista = DataBase.readObj("Hist.txt", list.getClass());
       //lista.empty();
    
    //list = DataBase.readObj("Hist.txt", list.getClass());
    User aux= new User("","", 0000);
    System.out.println(lista.toString());
   // System.out.println(lista.peek().hist.toString());
    Iterator ite = lista.iterator();
   // User aux2 = new User("j", "jh", 1000);
    while(ite.hasNext()){
        @SuppressWarnings("unchecked")
      User aux2= (User) ite.next();
    
       //  System.out.println(aux2.getName());
        if(aux2.getName().compareTo("Beto")==0){
          //  System.out.println("AAAAA");
           
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
