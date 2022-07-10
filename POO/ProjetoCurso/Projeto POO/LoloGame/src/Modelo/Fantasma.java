package Modelo;

import java.io.Serializable;
import Controler.Tela;

public class Fantasma extends Inimigo implements Serializable{
   int tipoMov = 0;

   public Fantasma(String sNomeImagePNG){
      super(sNomeImagePNG);
      this.timerMovimento = 5;
   }


   public void resetaImagem(){
      this.imagemLolo = Tela.getTela().getLolo();
   }

   public boolean movimenta(){
      if(tipoMov == 0){
         tipoMov = 1;
         if (imagemLolo.pPosicao.getColuna() > pPosicao.getColuna()) {
             return moveRight();
         } else if(imagemLolo.pPosicao.getColuna() < pPosicao.getColuna()){
             return moveLeft();
         } else if(imagemLolo.pPosicao.getLinha() > pPosicao.getLinha()){
             return moveDown();
         } else if(imagemLolo.pPosicao.getLinha() < pPosicao.getLinha()){
             return moveUp();
         }
     } else {
         tipoMov = 0;
         if(imagemLolo.pPosicao.getLinha() > pPosicao.getLinha()){
             return moveDown();
         } else if(imagemLolo.pPosicao.getLinha() < pPosicao.getLinha()){
             return moveUp();
         } else if (imagemLolo.pPosicao.getColuna() > pPosicao.getColuna()) {
             return moveRight();
         } else if (imagemLolo.pPosicao.getColuna() < pPosicao.getColuna()) {
             return moveLeft();
         }
     }
     return false;
   }
   
}
