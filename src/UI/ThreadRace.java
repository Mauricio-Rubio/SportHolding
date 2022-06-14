package UI;

import Clases.*;
import Estructuras.*;
import java.lang.Runnable;

public class ThreadRace implements Runnable{

    public Sistema sistema;

    public ThreadRace(Sistema sistema){
        this.sistema=sistema;

    }

    public void run(){
        try {
            Thread.sleep(7000);
        } catch (Exception e) {
        }
        sistema.getHorseRace().playRace(sistema.getHorseRace().getJockeys().elemInd(0));
    }
}