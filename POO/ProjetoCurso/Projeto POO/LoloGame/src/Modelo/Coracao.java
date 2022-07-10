package Modelo;

import java.io.Serializable;
import Controler.Tela;


public class Coracao extends ElementoEstatico implements Serializable {
   
   public Coracao() {
      super("heart.png");
      this.bTransponivel = false;
      this.bColetavel = true;
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
