package Modelo;
import java.io.Serializable;
import Controler.Tela;

public class Minhoca extends ElementoEstatico implements Serializable{
   public Minhoca() {
      super("cat.png");
      this.bMovel = true;
      this.bViraOvo = true;
   }

   @Override
   public void checaColisao(Elemento e){
      if(e instanceof Link)
         return;
      if(e != Tela.getTela().getLolo()){
         e.voltaAUltimaPosicao();
      }
   }
}
