package Clases;
import java.io.Serializable;
import Estructuras.*;
import java.io.Serializable;

/**
 * Class that represents a user of the SportHolding system
 * @author Alcantara Estrada Kevin Isaac
 * @author Rubio Haro Mauricio
 */
public class User implements Serializable{
    //Atributes of the class
    private String name = "none";
    String id = "0000";
    private double mount = 0000;
    private String password;

    /**
     * COnstructor of the class
     * @param name name of the user
     * @param password password of the user
     */
    public User(String name, String password){
    this.name = name;
    this.password = password;
    }

    /**
     * Method to set the atribute name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method to set the atribute id
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Method to set the atribute mount
     * @param mount
     */
    public void setMount(double mount) {
        this.mount = mount;
    }

    /**
     * Constructor of the class
     * @param name
     * @param id
     * @param d
     */
    public User(String name, String id, double d) {
        this.name = name;
        this.id = id;
        this.mount = d;
    }
    

    /**
     * Method to get the value of the atribute name
     * @return String
     */
    public String getName(){
        return this.name;
    }
    /**
     * Method to get the value of the atribute id
     * @return String
     */
    public String getId(){
        return this.id;
    }

    public double getMount(){
        return this.mount;

    }

/**
 * Method to get the value of the atribute password
 * @return String
 */
    public String getPassword() {
        return password;
    }

    /**
     * Method to set the value of the atribute password
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }


    @Override 
    /**
     * Method to represent a instance of the class as an String
     * @return String
     */
    public String toString(){
        return this.name+" "+this.mount+" "+this.password;
    }
}
