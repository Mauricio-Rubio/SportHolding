package Clases;

import java.io.Serializable;

public class User implements Serializable{
    private String name = "none";
    String id = "0000";
    private double mount = 0000;
    private String password;

    public User(String name, String password){
    this.name = name;
    this.password = password;
    }

    public User(String name, String id, double d) {
        this.name = name;
        this.id = id;
        this.mount = d;
    }
    
    public String getName(){
        return this.name;
    }
    public String getId(){
        return this.id;
    }
    public double getMount(){
        return this.mount;
    }
    
    @Override 
    public String toString(){
        return this.name+" "+this.id+" "+this.mount;
    }
}
