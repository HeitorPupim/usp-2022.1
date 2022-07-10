package Modelo;

import Controler.Tela;
import java.io.Serializable;
import java.util.ArrayList;
/**
 *
 * @author Junio
 */
public class Hero extends Animado implements Serializable{
    private int itensColetados = 0;
    
    public Hero(String sNomeImagePNG) {
        super(sNomeImagePNG);
    }
    
    //Colisao Heroi x Varias Coisas
    public void checaColisao(Elemento eTemp) {
        if (eTemp.isbColetavel()) {             /*Item*/               
            Tela.getTela().tocaEfeito("get_item.wav");
            Tela.getTela().removeElemento(eTemp);
            this.itensColetados++;
        } else if (eTemp.isbMortal()) {         /*Inimigo*/
            //Morte do Heroi
            this.itensColetados = 0;
            Tela.getTela().tiraVida();
            if(Tela.getTela().getVidas() > 0){
                Tela.getTela().reiniciaFase();
            }
        } else if (eTemp.isbMovel()) {          /*BlocoMovel*/
            Bloco blocoTemp = (Bloco) eTemp;
            //Se o blocoMovel nao se mover, o heroi volta a ultima posicao
            if(!blocoTemp.movimenta(this.apontaUltimaPos())){
                this.voltaAUltimaPosicao();
            }
        } else if (eTemp.isbTransponivel()) {   /*Seta*/
            Seta setaTemp = (Seta) eTemp;
            //Se a seta apontar pro lado oposto, o heroi volta a ultima posicao
            if(setaTemp.apontaOposto(this)){
                this.voltaAUltimaPosicao();
            } else{
                eTemp.checaColisao(this);
            }
        } else if (!eTemp.isbTransponivel()) {  /*BlocoImovel*/
            this.voltaAUltimaPosicao();
        }
    }

    public int getItensColetados() {
        return itensColetados;
    }
    
    //Tenta destruir um bloco na direcao do olhar do heroi
    public void destroiElemento(ArrayList<Elemento> e){
        if (this.direcaoOlhar == 'U') {
            destroiAux(e, this.pPosicao.getColuna(), this.pPosicao.getLinha() - 1);
        } else if (this.direcaoOlhar == 'D') {
            destroiAux(e, this.pPosicao.getColuna(), this.pPosicao.getLinha() + 1);
        } else if (this.direcaoOlhar == 'L') {
            destroiAux(e, this.pPosicao.getColuna() - 1, this.pPosicao.getLinha());
        } else if (this.direcaoOlhar == 'R') {
            destroiAux(e, this.pPosicao.getColuna() + 1, this.pPosicao.getLinha());
        }
    }
    
    private void destroiAux(ArrayList<Elemento> e, int xPos, int yPos){
        for(int i = 0; i < e.size(); i++){
            if(e.get(i).pPosicao.getColuna() == xPos){
                if(e.get(i).pPosicao.getLinha() == yPos){
                    if(e.get(i).isbDestrutivel()){
                        Tela.getTela().tocaEfeito("break_block.wav");
                        e.remove(i);
                    }
                }
            }
        }
    }
}
