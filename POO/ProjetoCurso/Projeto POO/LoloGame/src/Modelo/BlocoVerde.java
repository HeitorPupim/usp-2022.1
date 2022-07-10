package Modelo;

import java.io.Serializable;

import Controler.Tela;

public class BlocoVerde extends ElementoEstatico implements Serializable{

   public BlocoVerde(){
      super("blocoVerde.png");
      this.bMovel = true;
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