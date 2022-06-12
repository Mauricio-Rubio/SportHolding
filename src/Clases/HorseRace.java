package Clases;

import Estructuras.Lista;
import java.io.Serializable;
import java.util.Iterator;
import DB.DataBase;

/**
 * Class that simulate a jockeys race
 */
public class HorseRace implements Serializable{
    //Atributes of the class
    private Lista<Jockey> jockeys = new Lista();

    /**
     * Constructor without parameters of the class
     * @author Alcantara Estrada Kevin Isaac
     * @author Rubio Haro Mauricio
     */
    public HorseRace(){
        Jockey j1 = new Jockey ("Anakin");
        Jockey j2 = new Jockey ("Jabba");
        Jockey j3 = new Jockey ("Obi-wan");
        Jockey j4 = new Jockey ("Grievous");
        Jockey j5 = new Jockey ("Dooku");
        Jockey j6 = new Jockey ("Padme");

        jockeys.add(j1);
        jockeys.add(j2);
        jockeys.add(j3);
        jockeys.add(j4);
        jockeys.add(j5);
        jockeys.add(j6);
    }

    /**
     * Method to get the value of the jockeys atribute
     * @return
     */
    public Lista<Jockey> getJockeys(){
        return this.jockeys;
    }

    /**
     * Method to make a race between the jockeys, return the posicion of the Jockey that you bet on
     * @param j Jockey you bet on
     * @return int
     */
    public int playRace(Jockey j){
        int pos=1;
        Lista<Jockey> copy = this.jockeys.clone();
        Iterator<Jockey> iteCopy = copy.iterator();
        while(iteCopy.hasNext()){
            Jockey aux= iteCopy.next();
            aux.calculateProbability(this.jockeys.size());//calculate the probability of winning for each jockey
            System.out.println(aux.toString());//show info to the user
        }
        System.out.println();
        System.out.println("Running");//show info to the user
        try{
            Thread.sleep(5000); //wait 5 seconds
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        Lista<Jockey> results = Operations.jockeysPos(this);//determinate the posicion for each jockey
     
       Iterator<Jockey> ite = results.iterator();
       while(ite.hasNext()){
           Jockey auxi = ite.next();
           auxi.addPos(pos);//add the position of each jockey to his historial
           pos++;
       }

       DataBase.writeObj("Race.txt", this);//to serialize the class
       System.out.println("Resultados");//show info to the user
     printListJockeys(results);//show the results of the race to the user
        return j.getHist().get(j.getHist().size()-1);// return the position of the Jockey that was given as parameter
    }

    /**
     * Methot to print on the screen a list of Jockeys
     * @param l list of Jockeys
     */
    public void printListJockeys(Lista<Jockey> l){
        String r="";
        for (Jockey i : l) {
            r+= i+"\n";
        }
        System.out.println(r);
    }
   
    /**
     * Method to represent the class as an String
     */
    public void toShow(){
        printListJockeys(this.getJockeys());
    }


}