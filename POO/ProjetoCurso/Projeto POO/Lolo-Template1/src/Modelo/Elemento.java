package Modelo;

import java.io.Serializable;

public abstract class Elemento extends Personagem implements Serializable{
   
   protected Elemento (String sNomeImagePNG){
      super(sNomeImagePNG);
   }

}
