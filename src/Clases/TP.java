package Clases;
import java.io.Serializable;

public class TP implements Serializable{
  private  Player[] players1 = new Player[16];
  private  Player[] players2 = new Player[8];
   private Player[] players3 = new Player[4];
   private Player[] players4 = new Player[2];
   private Player[] players5 = new Player[0];
   private int round=1;

    public TP(){
        for(int i=0; i<players1.length; i++){
            players1[i]= new Player();
        }
    }

    

    public void printArr(){
        switch(round){
            case 1:
            print(this.players1);
            break;

            case 2:
            print(this.players2);
            break;

            case 3:
            print(this.players3);
            break;

            case 4:
            print(this.players4);
            break;

            case 5:
            print(this.players5);
            break;
        }


    }

    public void mix(Player[] players ) {
        int azar = 0;
        for (int i = 0; i <players.length; i++) {
          azar = (int) (Math.random() * (players.length - 1));
          Player aux = players[i];
          players[i] = players[azar];
          players[azar] = aux;
        }
      }

    public void print(Player[] players){
        for(int i=0; i<players.length;i++){
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
    mix(getArr(round));
    int j=0;
    for(int i=0; i< getArr(this.round).length; i+=2){
        Camp.calculateP(getArr(round)[i], getArr(round)[i+1]);
        System.out.println(getArr(round)[i]+" vs "+ getArr(round)[i+1]);
        try{
        Thread.sleep(10000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        Player aux =Camp.winner(getArr(round)[i], getArr(round)[i]);
        System.out.println("Ganador: "+aux);
        getArr(round+1)[j] = aux;
        j++;
    }

    this.round++;

}

    public int getRound(){
        return this.round;
    }

    
}