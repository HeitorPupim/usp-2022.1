package Modelo;

import Auxiliar.Desenhador;
import Controler.Tela;
import java.io.Serializable;

public class Item extends Elemento implements Serializable{
    
    public Item(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.bTransponivel = true;
        this.bColetavel = true;
    }
    
    @Override
    public void checaColisao(Elemento eTemp){
        if(eTemp instanceof Fantasma)
            return;
        if(eTemp != Tela.getTela().getHeroi()){
            eTemp.voltaAUltimaPosicao();
        }
    }
}
