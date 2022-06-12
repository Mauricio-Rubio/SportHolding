package Clases;
import java.io.Serializable;

import DB.DataBase;

public class TP implements Serializable{
  private  Player[] players1 = new Player[31];
  private  Player[] players2 = new Player[8];
private Player[] players3 = new Player[4];
  private Player[] players4 = new Player[2];
  private Player[] players5 = new Player[1];
   private int round=1;
   private boolean init=false;
   private int pair=1;
   private int play=0;
   private int pos=0;

    public TP(){
        for(int i=0; i<16; i++){
            players1[i]= new Player();
        }
    }

    

    public void printArr(){
       
            print(this.players1);
    
        


    }

    public void mix(Player[] players ) {
        int azar = 0;
        for (int i = 0; i <16; i++) {
          azar = (int) (Math.random() * (16 - 1));
          Player aux = players[i];
          players[i] = players[azar];
          players[azar] = aux;
        }
      }

    public void print(Player[] players){
        int h= 16/this.round;
        for(int i=0; i<h;i++){
            System.out.print(players[i]+", ");
        }
    }
    
    public Player[] getArr(int i){
        switch (i){
            case 1:
            return players1;

            case 2:
            return players2;

            case 3:
            return players3;

            case 4:
            return players4;

            case 5:
            return players5;

            default:
            return null;

        }
    }

public void playRound(){
    if(round>=5){
        System.out.println("Se acabó el torneo");
        return;

    }

    if(this.init==false){
    mix(players1);
    }
  
   
    int h= 16/pair;
   
    
    int j=32-h;
    int p =j;
    if(this.init){
        j=pos;
    }
    int auxi=j;
    if(init){
        auxi=j-(j-p);
    }
   // int k=0;
    int u=j-h;
    if(this.init){
        u=play;
    }
   
   this.init=true;

    for(int i=u; i< auxi; i+=2){
        System.out.println("u"+u);
        System.out.println("j"+j);
        System.out.println("i"+i);
        System.out.println("auxi"+auxi);
        Camp.calculateP(players1[i], players1[i+1]);
        System.out.println(players1[i]+ " P:"+players1[i].getProbability() +" vs "+players1[i+1]+" p:"+ players1[i+1].getProbability());
       /*   try{
        Thread.sleep(7000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }*/
        Player aux =Camp.winner(players1[i], players1[i+1]);
        players1[j] = aux;
       // players1[i].fought=true;
        // players1[i+1].fought=true;
         play=i+2;
         j++;
          pos=j;
        System.out.println("Ganador: "+aux);
        DataBase.writeObj("Torn.txt", this);
        
    }

    
    this.init=false;
    pair=pair+pair;
   System.out.println();
   System.out.println("Acabo la ronda "+round);
   this.round++;
    DataBase.writeObj("Torn.txt", this);
    playRound();
}

    public int getRound(){
        return this.round;
    }

    
}