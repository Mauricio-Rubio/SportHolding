package Clases; 


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

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


    public static <T> T readObj(String fileName, Class<T> objClass) {
        T obj = null;
        try (FileInputStream fis = new FileInputStream(fileName);
                ObjectInputStream door = new ObjectInputStream(fis);) {
            obj = (T) door.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }


}