package Modelo;

import java.io.Serializable;
import java.util.concurrent.ThreadLocalRandom;

public class TatuCinza extends Inimigo implements Serializable{

   public TatuCinza(){
      super("tatu.png");
   }

   public boolean movimenta() {
      int randomNum = ThreadLocalRandom.current().nextInt(1, 5);
      if(randomNum == 1){
         return moveUp();
      } else if(randomNum == 2){
         return moveDown();
      } else if(randomNum == 3){
         return moveRight();
      } else if(randomNum == 4){
         return moveLeft();
      } else { 
         return false;
      }
  }
   
}
