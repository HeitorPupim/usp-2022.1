
package Modelo;

//import Auxiliar.Consts;
//import Auxiliar.Desenho;
//import java.awt.Graphics;
//import java.awt.Graphics2D;
//import java.io.IOException;
import java.io.Serializable;
//import javax.swing.ImageIcon;
//import javax.swing.JFrame;
//import javax.swing.JPanel;

public class Lolo extends Personagem implements Serializable{
    public Lolo(String sNomeImagePNG) {
        super(sNomeImagePNG);
    }

    public void voltaAUltimaPosicao(){
        this.pPosicao.volta();
    }
}
