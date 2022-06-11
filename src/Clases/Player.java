
package Clases;
import java.io.Serializable;
import Estructuras.*;
public class Player implements Serializable{

    private String name;
    private int h;
    private float probability;
    public boolean fought=false;

    public Player(){
        this.name= NameMaker.nameRamdom();
        this.h= (int) (Math.random()*(400-50)) + 50;
        this.probability=0;
    }

    public String getName(){
        return this.name;
    }

    public int getH(){
        return this.h;
    }

    public float getProbability(){
        return this.probability;

    }

    public void setProbability(float probability){
        this.probability= probability;
    }

    public String toString(){
        return this.name+" h:" +this.h;
    }

    public String winP(){

        return this.probability+"%";
    }

}