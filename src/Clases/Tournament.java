package Clases;
import java.io.Serializable;

import DB.DataBase;

/**
 * Class that simulates a boxing tournament
 * @author Alcantara Estrada Kevin Isaac
 * @author Rubio Haro Mauricio
 */
public class Tournament implements Serializable{
    //Atributes of the class
  private  Player[] players1 = new Player[31];
   private int round=1;
   private boolean init=false;
   private int pair=1;
   private int play=0;
   private int pos=0;

   /**
    * Constructor of the class without parameters
    */
    public Tournament(){
        for(int i=0; i<16; i++){
            players1[i]= new Player();
        }
    }

    
/**
 * Method to print the competitors of the tournament
 */
    public void printArr(){
            printRound1(this.players1);
    }

    /**
     * Method to print the competitors based on the value of the atribute round
     */
public void printCompetitors(){
    switch (this.round){
        case 1:
        printRound1(this.players1);
        break;

        case 2:
        printRound2(this.players1);
        break;

        case 3:
        printRound3(this.players1);
        break;

        case 4:
        printRound4(this.players1);
        break;

        case 5:
        printWinner(this.players1);
        break;
    }
}

 /**
     * Method to print the first round of competitors
     * @param players
     */
    public void printRound1(Player[] players){
        for(int i =0; i<16;i++){
            System.out.print(players[i]+", ");
        }
        System.out.println();
    }

     /**
     * Method to print the second round of competitors
     * @param players
     */
    public void printRound2(Player[] players){
        for(int i =16; i<24;i++){
            System.out.print(players[i]+", ");
        }
        System.out.println();
    }

     /**
     * Method to print the third round of competitors
     * @param players
     */
    public void printRound3(Player[] players){
        for(int i =24; i<28;i++){
            System.out.print(players[i]+", ");
        }
        System.out.println();
    }

     /**
     * Method to print the fourth round of competitors
     * @param players
     */
    public void printRound4(Player[] players){
        for(int i =28; i<30;i++){
            System.out.println(players[i]);
        }
    }

    /**
     * Method to print the winner
     * @param players
     */
    public void printWinner(Player[] players){
            System.out.println("El ganador del torneo es: " +players[30]);
    }

    /**
     * Method for shuffling tournament competitors
     * @param players Array of Player class instances
     */
    public void mix(Player[] players) {
        int azar = 0;
        for (int i = 0; i <16; i++) {
          azar = (int) (Math.random() * (16 -1));
          Player aux = players[i];
          players[i] = players[azar];
          players[azar] = aux;
        }
      }

     
  
   /**
    * Recursive method that starts a round and continues until it reaches the final round
    */
     
public void playRound(){
    printCompetitors();
    if(round>=5){//base case
        System.out.println("Se acabó el torneo");
        return;

    }

    if(round==1 && init==false){
    mix(players1);//shuffle the competitors
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

    int u=j-h;
    if(this.init){
        u=play;
    }
   
   this.init=true;

    for(int i=u; i< auxi; i+=2){ //start the combats
        Operations.calculateP(players1[i], players1[i+1]); //calculate probabilities
        System.out.println(players1[i]+ " P:"+players1[i].getProbability() +" vs "+players1[i+1]+" p:"+ players1[i+1].getProbability()); //show info to the user

         try{
        Thread.sleep(70); //wait 7 seconds
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        Player aux =Operations.winner(players1[i], players1[i+1]); //determinate the winner
        players1[j] = aux; //the winner goes to the next round
         play=i+2;
         j++;
          pos=j;
        System.out.println("Ganador: "+aux); //show the winner to the user
        DataBase.writeObj("Torn.txt", this); //serialize this tournament
        
    }

    
    this.init=false;
    pair=pair+pair;
   System.out.println();
   System.out.println("Acabo la ronda "+round);
   this.round++; //increment the round number
    DataBase.writeObj("Torn.txt", this); //serialize this tournament
    playRound(); // recursive call
}


/**
 * Method to get the round number of the tournament
 * @return int
 */

    public int getRound(){
        return this.round;
    }

    public Player[] getPlayers1() {
        return players1;
    }

    public void setPlayers1(Player[] players1) {
        this.players1 = players1;
    }

    public boolean isInit() {
        return init;
    }

    public void setInit(boolean init) {
        this.init = init;
    }

    public int getPair() {
        return pair;
    }

    public void setPair(int pair) {
        this.pair = pair;
    }

    public int getPlay() {
        return play;
    }

    public void setPlay(int play) {
        this.play = play;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }
    
    
}