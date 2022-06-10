package DB;



import Estructuras.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.File;

public class DataBase{

    public static boolean writeObj(String fileName, Serializable obj) {
        
        boolean sw = false;
        
        try (FileOutputStream fos = new FileOutputStream(fileName);
                ObjectOutputStream sout = new ObjectOutputStream(fos);) {
            sout.writeObject(obj);
            sw = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        return sw;
    }

public static <T extends Serializable> void readWrite(String fileName, T obj){
    File f = new File(fileName);
    
    if(!f.exists()){
        System.out.println("KK");
        Lista<T> list1 = new Lista();
        list1.add(obj);
        System.out.println(list1);
        writeObj(fileName, list1);
    }else{
       
    Lista<T> list = readList(fileName, obj);
    list.add(obj);
    System.out.println(list);
        writeObj(fileName, list);
       // return obNew;
    }
   // return null;
}
    public static <T> T readObj(String fileName, Class<T> objClass) {
        T obj = null;
        try(FileInputStream fis = new FileInputStream(fileName);
                ObjectInputStream door = new ObjectInputStream(fis);){
            obj = (T) door.readObject();
        
        }catch(Exception c){
            System.out.println("Ese archivo no existe");
        }
        return obj;
    }


    public static  <T> Lista<T>  readList(String fileName, T elem) {
        Lista<T> listp = new Lista();
        try(FileInputStream fis = new FileInputStream(fileName);
                ObjectInputStream door = new ObjectInputStream(fis);){
           Lista<T> list = readObj(fileName, listp.getClass());
        return list;
        }catch(Exception c){
            System.out.println("No existe tal archivo");
        }
        return null;
    }

}