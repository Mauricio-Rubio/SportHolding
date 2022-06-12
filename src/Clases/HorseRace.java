package Clases;

import Estructuras.Lista;
import java.io.Serializable;
import java.util.Iterator;

public class HorseRace implements Serializable{
    private Lista<Jockey> jockeys = new Lista();

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

    public Jockey playRace(Jockey j){
        int pos=1;
        Lista<Jockey> copy = this.jockeys.clone();
        Iterator<Jockey> iteCopy = copy.iterator();
        while(iteCopy.hasNext()){
            Jockey aux= iteCopy.next();
            aux.calculateProbability(this.jockeys.size());
            System.out.println(aux.toString());
        }
        System.out.println();
        System.out.println("Running");
        try{
            Thread.sleep(5000); //wait 7 seconds
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        Lista<Jockey> results = Camp.jockeysPos(this);
       Iterator<Jockey> ite = results.iterator();
       while(ite.hasNext()){
           Jockey auxi = ite.next();
           auxi.addPos(pos);
           pos++;
       }
        return results.peek();
    }

    public Lista<Jockey> getJockeys() {
        return jockeys;
    }


}