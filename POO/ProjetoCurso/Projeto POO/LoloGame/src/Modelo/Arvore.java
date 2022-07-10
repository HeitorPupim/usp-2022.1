package Modelo;

import java.io.Serializable;

import Controler.Tela;

public class Arvore extends ElementoEstatico implements Serializable {
   
   public Arvore(){
      super("arvore.png");
      this.bDestrutivel = false;
      this.bEhArvore = true;
   }

   @Override
   public void checaColisao(Elemento e){

      if (e instanceof Fantasma)
         return;
      if (this.isMovel()){
         // elemento e outras coisas:
         if (!e.isTransponivel() || e.isColetavel()){
            //Bloco transponivel ou item:
            this.voltaAUltimaPosicao();
         } else if (e.isMortal()){
            // se for um inimigo mortal:
            e.voltaAUltimaPosicao();
         }
      }else {
         // Bloco imovel x qualquer coisa:
         e.voltaAUltimaPosicao();
      }
   }
  
}
 