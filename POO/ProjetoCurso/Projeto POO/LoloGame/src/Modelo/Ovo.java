package Modelo;

import java.io.Serializable;

import Controler.Tela;

public class Ovo extends ElementoEstatico implements Serializable{
   
   public Ovo() {
      super("egg.png");
      this.bDestrutivel = false;
      this.bMovel = true;
      this.bEhOvo = true;
   }
   
   @Override
   public void checaColisao(Elemento e){
      if(e instanceof Fantasma)
         return;
      if(e != Tela.getTela().getLolo()){
         e.voltaAUltimaPosicao();
      }
   }

}
