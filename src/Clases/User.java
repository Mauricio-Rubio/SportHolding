package Clases;

public class User {
    private String name = "none";
    String id = "0000";
    private String money = "0000";

    public String getName(){
        return this.name;
    }
    public String getId(){
        return this.id;
    }
    public String getMoney(){
        return this.money;
    }
    
    @Override 
    public String toString(){
        return this.name+" "+this.id+" "+this.money;
    }
}
