package Modelo;

import java.io.Serializable;

/**
 *
 * @author Junio
 */
public class RoboAmarelo extends Inimigo implements Serializable{

    public RoboAmarelo(String sNomeImagePNG, Hero imagemHero) {
        super(sNomeImagePNG);
        this.imagemHero = imagemHero;
    }
    
    //Prioriza ficar na mesma linha do heroi, para entao ir ate a coluna dele
    public boolean movimenta(){
        if(contadorRandom != 3){
            contadorRandom++;
            if(imagemHero.pPosicao.getLinha() > pPosicao.getLinha()){
                return moveDown();
            } else if(imagemHero.pPosicao.getLinha() < pPosicao.getLinha()){
                return moveUp();
            } else if (imagemHero.pPosicao.getColuna() > pPosicao.getColuna()) {
                return moveRight();
            } else if (imagemHero.pPosicao.getColuna() < pPosicao.getColuna()) {
                return moveLeft();
            }
        }else{
            contadorRandom = 0;
            if (imagemHero.pPosicao.getColuna() > pPosicao.getColuna()) {
                return moveRight();
            } else if (imagemHero.pPosicao.getColuna() < pPosicao.getColuna()) {
                return moveLeft();
            }
        }
        return false;
    }   
}
