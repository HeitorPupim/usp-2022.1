package Modelo;

import Controler.Tela;
import java.io.Serializable;

/**
 *
 * @author Junio
 */
public class RoboAzul extends Inimigo implements Serializable{

    public RoboAzul(String sNomeImagePNG, Hero imagemHero) {
        super(sNomeImagePNG);
        this.imagemHero = imagemHero;
    }
    
    //Prioriza ficar na mesma coluna do heroi, para entao ir ate a linha dele
    public boolean movimenta(){
        if(contadorRandom != 3){
            contadorRandom++;
            if (imagemHero.pPosicao.getColuna() > pPosicao.getColuna()) {
                return moveRight();
            } else if(imagemHero.pPosicao.getColuna() < pPosicao.getColuna()){
                return moveLeft();
            } else if(imagemHero.pPosicao.getLinha() > pPosicao.getLinha()){
                return moveDown();
            } else if(imagemHero.pPosicao.getLinha() < pPosicao.getLinha()){
                return moveUp();
            }
        }else{
            contadorRandom = 0;
            if(imagemHero.pPosicao.getLinha() > pPosicao.getLinha()){
                return moveDown();
            } else if(imagemHero.pPosicao.getLinha() < pPosicao.getLinha()){
                return moveUp();
            }
        }
        return false;
    }   
}
