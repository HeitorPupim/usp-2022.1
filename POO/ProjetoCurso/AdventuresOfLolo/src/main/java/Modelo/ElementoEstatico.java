package Modelo;

import java.io.Serializable;


public abstract class ElementoEstatico extends Elemento implements Serializable{

   protected ElementoEstatico(String sNomeImagePNG){
      super(sNomeImagePNG);
      this.bTransponivel = false;
   }

   @Override
   public void checaColisao(Elemento e){
      if (e instanceof Link)
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
         // Boloco imovel x qualquer coisa:
         e.voltaAUltimaPosicao();
      }
   }
   
   public boolean movimenta(char UltimaDirecaoHeroi){
       switch (UltimaDirecaoHeroi) {
           case 'R':
               return this.moveLeft();
           case 'L':
               return this.moveRight();
           case 'U':
               return this.moveDown();
           case 'D':
               return this.moveUp();
           default:
               break;
       }
     return false;
   }

   @Override
   public boolean moveUp() {
      if (this.checaPosicao(this.pPosicao.getLinha() - 1, this.pPosicao.getColuna())) {
         return super.moveUp();
      } else {
         return false;
      }
   }

   @Override
   public boolean moveDown() {
      if (this.checaPosicao(this.pPosicao.getLinha() + 1, this.pPosicao.getColuna())) {
         return super.moveDown();
      } else {
         return false;
      }
   }

   @Override
   public boolean moveRight() {
      if (this.checaPosicao(this.pPosicao.getLinha(), this.pPosicao.getColuna() + 1)) {
         return super.moveRight();
      } else {
         return false;
      }
   }

   @Override
   public boolean moveLeft() {
      if (this.checaPosicao(this.pPosicao.getLinha(), this.pPosicao.getColuna() - 1)) {
         return super.moveLeft();
      } else {
         return false;
      }
   }
}
