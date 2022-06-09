package Clases;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class Pruebas{

   static User juan = new User("Jorge", "22009", 334.23);
public static void main(String[] args){
    DataBase.writeObj("Hist.txt", juan);
}


}