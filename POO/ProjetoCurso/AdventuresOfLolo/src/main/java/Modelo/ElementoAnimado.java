package Modelo;

import Auxiliar.Consts;
import Auxiliar.Desenho;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.ImageIcon;

public abstract class ElementoAnimado extends Elemento {
   
   protected ImageIcon[] iImages;

   //Precisa ter as imagens de direção!
   public ElementoAnimado(String sNomeImagePNG) {
      super(sNomeImagePNG);
      this.bAnimado = true;

      //Entra em loop e pega as imagens de olhar do elemento.
      // *** falta colocar as imagens de direção, por enquanto coloca a msm.

      try{
         iImages = new ImageIcon[4];
         char direcao = 'M';
         for (int i = 0; i < 4; i++) {
             switch (i) {
                 case 0:
                     direcao = 'U';
                     break;
                 case 1:
                     direcao = 'D';
                     break;
                 case 2:
                     direcao = 'L';
                     break;
                 case 3:
                     direcao = 'R';
                     break;
                 default:
                     break;
             }
            //Substitui a letra no nome da imagem para a imagem de direção coreta..
            iImages[i] = new ImageIcon(new java.io.File(".").getCanonicalPath() + Consts.PATH + sNomeImagePNG.replace(".", direcao + "."));
            Image img = iImages[i].getImage();
            BufferedImage bi = new BufferedImage(Consts.CELL_SIDE, Consts.CELL_SIDE, BufferedImage.TYPE_INT_ARGB);
            Graphics g = bi.createGraphics();
            g.drawImage(img, 0, 0, Consts.CELL_SIDE, Consts.CELL_SIDE, null);
            iImages[i] = new ImageIcon(bi);
         }
      } catch (IOException ex){
         System.out.println(ex.getMessage());
      }
   }


   @Override
   public void autoDesenho(){
       switch (this.getDirecaoOlhar()) {
           case 'U':
               Desenho.desenhar(this.iImages[0], pPosicao.getColuna(), pPosicao.getLinha());
               break;
           case 'D':
               Desenho.desenhar(this.iImages[1], pPosicao.getColuna(), pPosicao.getLinha());
               break;
           case 'L':
               Desenho.desenhar(this.iImages[2], pPosicao.getColuna(), pPosicao.getLinha());   
               break;
           case 'R':
               Desenho.desenhar(this.iImages[3], pPosicao.getColuna(), pPosicao.getLinha());
               break;
           default:
               break;
       }
   }
}
