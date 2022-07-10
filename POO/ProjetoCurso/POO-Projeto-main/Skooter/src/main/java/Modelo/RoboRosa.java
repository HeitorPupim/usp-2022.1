package Modelo;

import java.io.Serializable;

/**
 *
 * @author Junio
 */
public class RoboRosa extends Inimigo implements Serializable{
    int direcoesTentadas  = 0;

    public RoboRosa(String sNomeImagePNG, Hero imagemHero) {
        super(sNomeImagePNG);
        this.imagemHero = imagemHero;
    }
    
    //Tenta um movimento valido que deixa ele mais perto do heroi
    public boolean movimenta(){
        if (imagemHero.pPosicao.getLinha() > pPosicao.getLinha() && direcoesTentadas < 1) {
            if(!moveDown()){
                direcoesTentadas = 1;
                this.movimenta();
            }
        } else if (imagemHero.pPosicao.getLinha() < pPosicao.getLinha() && direcoesTentadas < 2) {
            if(!moveUp()){
                direcoesTentadas = 2;
                this.movimenta();
            }
        } else if (imagemHero.pPosicao.getColuna() > pPosicao.getColuna() && direcoesTentadas < 3) {
            if(!moveRight()){
                direcoesTentadas = 3;
                this.movimenta();
            }
        } else if (imagemHero.pPosicao.getColuna() < pPosicao.getColuna() && direcoesTentadas < 4) {
            if(!moveLeft()){
                direcoesTentadas = 4;
                this.movimenta();
            }
        }
        direcoesTentadas = 0;
        return true;
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