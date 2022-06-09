package Clases;
import java.io.Serializable;
import Estructuras.*;
public class User implements Serializable{

	public User(String name, String id, double money){
		this.name = name;
		this.id=id;
		this.money=money;
        
	}
    private String name = "none";
    String id = "0000";
    private double money = 0;
    public Lista<String> hist = new Lista();
    public String getName(){
        return this.name;
    }
    public String getId(){
        return this.id;
    }
    public double getMoney(){
        return this.money;
    }
    
    public void setMoney(double money){
        this.money=money;
    }
    @Override 
    public String toString(){
        return this.name+" "+this.id+" "+this.money;
    }
}
