/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import Auxiliar.Consts;
import Auxiliar.Desenhador;
import Controler.Tela;
import java.io.Serializable;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author daniel
 */
public abstract class Inimigo extends Animado implements Serializable {
    Hero imagemHero;
    int contadorRandom = 0;
    int timerMovimento;
    long framesContados = -10;  //Inimigo tem um delay inicial maior
    
    public Inimigo(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.bMortal = true;
        this.timerMovimento = 10;
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
    
    public void checaColisao(Elemento eTemp) {
        if(eTemp instanceof Fantasma)
            return;
        if (eTemp != Tela.getTela().getHeroi()) {
            this.voltaAUltimaPosicao();                /*Blocos ou Itens ou Inimigos*/
        }
    }
    
    public boolean checaPosicao(int linha, int coluna) {
        for (Elemento eTemp : Tela.getTela().getArrayElementos()){
            if(eTemp != this){
                if (eTemp.pPosicao.getLinha() == linha) {
                    if (eTemp.pPosicao.getColuna() == coluna) {
                        if(eTemp == Tela.getTela().getHeroi()){
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
    
    public abstract boolean movimenta();
}
