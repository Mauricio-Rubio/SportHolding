package Clases;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Iterator;
import Estructuras.Lista;


public class Jockey implements Serializable{
private Lista<Integer> hist = new Lista();
private String name;
private float probability;

public Jockey(String name){
    makeHist(6);
    this.name= name;
}

public Lista<Integer> getHist(){
    return this.hist;
}

public String getName(){
    return this.name;
}

public float getProbability(){
    return this.probability;
}

public void setProbability(float probability){
    this.probability = probability;
}

public void makeHist(int n){
    if(this.hist.isEmpty()){
        for(int i=0; i<5;i++){
        int k= (int)(Math.random()*(n-1)) + 1;
        this.hist.add(k);
        }
    }
}

public void addPos(int pos){
    this.hist.add(pos);
}

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

public String toString(){
    return this.name;
}

}