/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Auxiliar.Consts;
import Auxiliar.Desenhador;
import Controler.Tela;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author daniel
 */

public class Seta extends Elemento implements Serializable{
    private char direcao;

    public Seta(String sNomeImagePNG, char direcao) {
        super(sNomeImagePNG);
        this.direcao = direcao;
    }
    
    @Override
    public void checaColisao(Elemento eTemp) {
        Tela.getTela().tocaEfeito("seta_move.wav");
        Robot robot;
        try {
            robot = new Robot();
            //Chama metodo pra movimentar o outro elemento na direcao certa
            if (this.direcao == 'U') {
                robot.keyPress(KeyEvent.VK_UP);
            } else if (this.direcao == 'D') {
                robot.keyPress(KeyEvent.VK_DOWN);
            } else if (this.direcao == 'R') {
                robot.keyPress(KeyEvent.VK_RIGHT);
            } else if (this.direcao == 'L') {
                robot.keyPress(KeyEvent.VK_LEFT);
            }
        } catch (AWTException ex) {
            ex.printStackTrace();
        }
    }
    
    //Retorna true se eTemp esta olhando para a direcao oposta da seta
    public boolean apontaOposto(Elemento eTemp){
        if(this.direcao == 'U' && eTemp.getDirecaoOlhar() == 'D'){
            return true;
        } else if(this.direcao == 'D' && eTemp.getDirecaoOlhar() == 'U'){
            return true;
        } else if(this.direcao == 'L' && eTemp.getDirecaoOlhar() == 'R'){
            return true;
        } else if(this.direcao == 'R' && eTemp.getDirecaoOlhar() == 'L'){
            return true;
        }
        return false;
    }
}

