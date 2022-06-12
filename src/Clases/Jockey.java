package Clases;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Iterator;
import Estructuras.Lista;

/**
 * Class that represents a Jockey
 * @author Alcantara Estrada Kevin Isaac
 * @author Rubio Haro Mauricio
 */
public class Jockey implements Serializable{
    //Atributes of the class
private Lista<Integer> hist = new Lista();
private String name;
private float probability;

/**
 * Constructor of the class
 * @param name name oh the jockey
 */
public Jockey(String name){
    makeHist(6);//make a random history
    this.name= name;
}

/**
 * Method to get the value of the atribute hist
 * @return Lista<Inteher>
 */
public Lista<Integer> getHist(){
    return this.hist;
}

/**
 * Method to get the value of the atribute name
 * @return String
 */
public String getName(){
    return this.name;
}

/**
 * Method to get the value of the atribute probability
 * @return float
 */
public float getProbability(){
    return this.probability;
}

/**
 * Method to set the value of the atribute probability
 * @param probability new value of the atribute
 */
public void setProbability(float probability){
    this.probability = probability;
}

/**
 * Method to make a random history
 * @param n number of jockeys that compite in the race
 */
public void makeHist(int n){
    if(this.hist.isEmpty()){
        for(int i=0; i<5;i++){
        int k= (int)(Math.random()*(n-1)) + 1;
        this.hist.add(k);
        }
    }
}

/**
 * Method to add a position to the history of the instance
 * @param pos position to add
 */
public void addPos(int pos){
    this.hist.add(pos);
    this.hist.delete(this.hist.peek());
}

/**
 * Method to calculate the proboability of winning the race
 * @param n number of competitors in the race
 */
public void calculateProbability(int n){
    float sigma=0;
    Iterator<Integer> ite = this.hist.iterator();
    while(ite.hasNext()){
       
        sigma+=ite.next();
    }       
    
    float m= n;
    float l = this.hist.size();
float pw=  ( (l*(m+1) -sigma)/(l*((m*(m+1))/2))  );
BigDecimal bd = new BigDecimal(pw).setScale(2, RoundingMode.HALF_UP);
pw = bd.floatValue();
setProbability(pw);
}

/**
 * Method to represente a instance of the class as an String
 * @return String
 */
public String toString(){
    String g="[";
    for (Integer i : this.hist) {
        g+= i+"|";
    }
    g+="]";
    if(this.probability==0.20){
        return this.name +" Probability: "+this.probability+"0%\n"+g;
    }
    return this.name +" Probability: "+this.probability+"%\n"+g;
}

}