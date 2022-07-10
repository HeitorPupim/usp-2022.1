/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;

/**
 *
 * @author Augusto
 */
public abstract class Bloco extends Elemento implements Serializable {

    protected Bloco(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.bTransponivel = false;
    }

    public void checaColisao(Elemento eTemp) {
        if(eTemp instanceof Fantasma)
            return;
        if (this.isbMovel()) {
            /*Bloco Movel x Varias Coisas*/
            if (!eTemp.isbTransponivel() || eTemp.isbColetavel()) {
                /*Blocos ou Itens*/
                this.voltaAUltimaPosicao();
            } else if (eTemp.isbMortal()) {
                /*Inimigo*/
                eTemp.voltaAUltimaPosicao();
            }
        } else {
            /*BlocoImovel x Qualquer Coisa*/
            eTemp.voltaAUltimaPosicao();
        }
    }

    public boolean movimenta(char UltimaDirecaoHeroi) {
        if (UltimaDirecaoHeroi == 'R') {
            return this.moveLeft();
        } else if (UltimaDirecaoHeroi == 'L') {
            return this.moveRight();
        } else if (UltimaDirecaoHeroi == 'U') {
            return this.moveDown();
        } else if (UltimaDirecaoHeroi == 'D') {
            return this.moveUp();
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
