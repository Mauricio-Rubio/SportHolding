package DB;

import Estructuras.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import Clases.User;
import java.io.File;

/**
 * Class to read and serialize objects
 * @author Alcantara Estrada Kevin Isaac
 * @author Rubio Haro Mauricio
 */
public class DataBase {

    /**
     * Method that takes an object that implements the Serializable interface and serializes it to save it in a .txt file
     * @param fileName the name of the file with extension .txt
     * @param obj the object to serialize
     * @return boolean
     */
    public static boolean writeObj(String fileName, Serializable obj) {

        boolean sw = false;

        try ( FileOutputStream fos = new FileOutputStream(fileName);  ObjectOutputStream sout = new ObjectOutputStream(fos);) {
            sout.writeObject(obj);
            sw = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sw;
    }

/**
 * Method to display the content of the .txt file on the screen
 * @param filename the name of the file .txt
 */
    public static void showDB(String filename) {
        Lista<User> list = new Lista();
        list = readObj(filename, list.getClass());
        System.out.println("list ->" + list);
    }
    
    
    /**
     * Method that searches for an object of the User class in the history of users saved in a .txt file
     * @param fileName name of the .txt file
     * @param name name of the User that we are going to search
     * @param password password of the User that we are going to search
     * @return User
     */
    public static User searchUser(String fileName, String name, String password) {
        System.out.println("DBP -> "+name+" "+password);
        Lista<User> list = new Lista();
        User aux2 = null;
        int k = 1;
        boolean finded = false;
        list = readObj(fileName, list.getClass());
        if (list == null) {
            return null;
        }
        System.out.println("list ->" + list);
        if (list.isEmpty()) {
            System.out.println("No hay jugadores registrados");
            return null;
        }
        Iterator ite = list.iterator();
        while (ite.hasNext() && finded == false) {
            finded = false;
            User aux = (User) ite.next();
            if (name.equals(aux.getName()) && password.equals(aux.getPassword())) {
                aux2 = (User) list.eliminarIndice(k);
                finded = true;
                writeObj(fileName, list);
                System.out.println("encontrado");
                return aux2;
            }
            k++;
        }
        if (aux2 == null) {
            System.out.println("Ese usuario no esta registrado");
        }
        return null;

    }

    /**
     * Method that takes an object as a parameter to serialize it and insert it into the .txt file without losing the contents of that file
     * @param <T> identifier of the type of object
     * @param fileName name of the .txt file
     * @param obj object to serialize
     */
    public static <T extends Serializable> void readWrite(String fileName, T obj) {
        File f = new File(fileName);

        if (!f.exists()) {
            Lista<T> list1 = new Lista();
            list1.add(obj);
            System.out.println(list1);
            writeObj(fileName, list1);
        } else {

            Lista<T> list = readList(fileName, obj);
            list.add(obj);
            System.out.println(list);
            writeObj(fileName, list);
        }
    }

    /**
     * Method to read the content of a .txt file and returns the type of object given as a parameter that is contained in the .txt
     * @param <T> type of the object 
     * @param fileName fname of the file .txt
     * @param objClass class of the object to read
     * @return
     */
    public static <T> T readObj(String fileName, Class<T> objClass) {
        File f = new File(fileName);
        if (!f.exists()) {
            System.out.println("Este archivo no existe, debes registrar al menos un usuario");
            return null;

        }
        T obj = null;
        try ( FileInputStream fis = new FileInputStream(fileName);  ObjectInputStream door = new ObjectInputStream(fis);) {
            obj = (T) door.readObject();

        } catch (Exception c) {
            c.printStackTrace();
        }
        return obj;
    }

    /**
     * Method that returns a list when reading a .txt file and according to the type of element given as a parameter
     * @param <T> type of the element
     * @param fileName name of the file .txt
     * @param elem elem
     * @return
     */
    public static <T> Lista<T> readList(String fileName, T elem) {
        Lista<T> listp = new Lista();
        try ( FileInputStream fis = new FileInputStream(fileName);  ObjectInputStream door = new ObjectInputStream(fis);) {
            Lista<T> list = readObj(fileName, listp.getClass());
            return list;
        } catch (Exception c) {
            System.out.println("No existe tal archivo");
        }
        return null;
    }

}
