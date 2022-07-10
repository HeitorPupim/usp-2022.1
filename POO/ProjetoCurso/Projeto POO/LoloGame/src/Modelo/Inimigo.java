package Modelo;
import Controler.Tela;
import java.io.Serializable;



public abstract class Inimigo extends ElementoAnimado implements Serializable{
   Lolo imagemLolo;
   int contadorRandom = 0;
   int timerMovimento;
   long framesContados = 5; //velocidade de movimento


   public Inimigo (String sNomeImagePNG){
      super(sNomeImagePNG);
      this.bMortal = true;
      this.timerMovimento = 10;
   }

   public void checaColisao(Elemento e) {
      if(e instanceof Fantasma)
          return;
      if (e != Tela.getTela().getLolo()) {
          this.voltaAUltimaPosicao();                /*Blocos ou Itens ou Inimigos*/
      }
  }

   public boolean checaPosicao(int linha, int coluna){
      for (Elemento e : Tela.getTela().getArrayElementos()){
         if (e != this){
            if (e.pPosicao.getLinha() == linha) {
               if (e.pPosicao.getColuna() == coluna) {
                  if(e == Tela.getTela().getLolo()){
                     return true;
                  } else{
                     return false;
                  }
               }
            }
         }
      }
      return true;
   }

   @Override
   public void autoDesenho(){
      super.autoDesenho();
      if(!Tela.getTela().getLoading()){
         if(framesContados >= timerMovimento){
               /*Padrão de design Command:
               O contador de frames não sabe qual método movimenta()
               será chamado, como todos os tipos de robôs possuem ele e
               é um método abstrato dentro de Inimigo, será decidido com
               base na classe em que o contador estiver durante a execução*/
               movimenta();
               framesContados = 0;
         } else{
               framesContados++;
         }
      }
   }

   public abstract boolean movimenta();
}