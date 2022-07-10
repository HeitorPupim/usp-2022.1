package Modelo;
import java.util.ArrayList;
import Controler.Tela;

public class FacadeLevel1 {



   public void desenhaLevel1(ArrayList<Personagem> e, Tela tela){
      ElementoEstatico ee0 = new ElementoEstatico("tree.png");
        ee0.setPosicao(0, 0);
        tela.addPersonagem(ee0);
        ElementoEstatico ee1 = new ElementoEstatico("tree.png");
        ee1.setPosicao(2, 0);
        tela.addPersonagem(ee1);
        ElementoEstatico ee2 = new ElementoEstatico("tree.png");
        ee2.setPosicao(3, 0);
        tela.addPersonagem(ee2);
        ElementoEstatico ee3 = new ElementoEstatico("tree.png");
        ee3.setPosicao(6, 0);
        tela.addPersonagem(ee3);
        ElementoEstatico ee4 = new ElementoEstatico("tree.png");
        ee4.setPosicao(7, 0);
        tela.addPersonagem(ee4);
        ElementoEstatico ee5 = new ElementoEstatico("tree.png");
        ee5.setPosicao(8, 0);
        tela.addPersonagem(ee5);
        ElementoEstatico ee6 = new ElementoEstatico("tree.png");
        ee6.setPosicao(9, 0);
        tela.addPersonagem(ee6);
        ElementoEstatico ee7 = new ElementoEstatico("tree.png");
        ee7.setPosicao(10, 0);
        tela.addPersonagem(ee7);
   }
}
