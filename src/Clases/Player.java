
package Clases;
import java.io.Serializable;
import Estructuras.*;
/**
 * Class that representes a competitor of the tournament
 * @author Alcantara Estrada Kevin Isaac
 * @author Rubio Haro Mauricio
 */
public class Player implements Serializable{
//Atributes of the class
    private String name;
    private int h;
    private float probability;
    public boolean fought=false;

/**
 * Constructor of the class without parameters
 */
    public Player(){
        this.name= NameMaker.nameRandom();
        this.h= (int) (Math.random()*(400-50)) + 50;
        this.probability=0;
    }

    /**
     * Method to get the atribute name
     * @return String
     */
    public String getName(){
        return this.name;
    }

    /**
     * Method to get the hability of the competitor (atribute h)
     * @return int
     */
    public int getH(){
        return this.h;
    }

    /**
     * Method to get the probability of win the combat
     * @return float
     */
    public float getProbability(){
        return this.probability;

    }

    /**
     * Method to set the probability of win the combat
     * @param probability
     */
    public void setProbability(float probability){
        this.probability= probability;
    }

    /**
     * Method to represent an instance of the class as an String
     * @return String
     */
    public String toString(){
        return this.name+" h:" +this.h;
    }

    /**
     * Method to show the atribute probability with porcentage
     * @return
     */
    public String winP(){

        return this.probability+"%";
    }

}