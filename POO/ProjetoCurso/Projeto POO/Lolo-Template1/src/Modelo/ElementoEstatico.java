package Modelo;

import java.io.Serializable;

public class ElementoEstatico extends Elemento implements Serializable { 

   public ElementoEstatico(String sNomeImagePNG) {
      super(sNomeImagePNG);
      this.bTransponivel = false;
   }
   
   @Override
   public void autoDesenho(){
      super.autoDesenho();
   }
}  
