package Controler;

import Auxiliar.Desenhador;
import Modelo.*;
import java.util.ArrayList;

/**
 *
 *
 */
public class ControleDeJogo {
    public void desenhaTudo(ArrayList<Elemento> e){
        for(int i = 0; i < e.size(); i++){
            Elemento eTemp1 = e.get(i);
            
            // Caso uma seta esteja na mesma posição que o herói ela é desenhada e, depois, ele
            if(!eTemp1.isbColetavel() && !eTemp1.isbMortal() && !eTemp1.isbMovel() &&
               !eTemp1.isbDestrutivel() && 
                eTemp1.getPosicao().estaNaMesmaPosicao(e.get(0).getPosicao())){
                
                eTemp1.autoDesenho();
                e.get(0).autoDesenho();
            }
            else{e.get(i).autoDesenho();
            }
        }
    }
    
    
    public void processaTudo(ArrayList<Elemento> e){
        Elemento eTemp;
        Elemento eTemp2;
        
        for(int i = 0; i < e.size(); i++){
            eTemp = e.get(i); 
            for(int j = i+1; j < e.size(); j++){
                eTemp2 = e.get(j);
                if((j != i) && eTemp.getPosicao().estaNaMesmaPosicao(eTemp2.getPosicao())){
                    //Heroi x Varias Coisas
                    if(i == 0){
                        Hero heroTemp = (Hero) eTemp;
                        heroTemp.checaColisao(eTemp2);
                        /*Caso o heroi colete todos os itens*/
                        if(heroTemp.getItensColetados() >= 4){
                            Tela.getTela().proximaFase();
                            return;
                        }
                        /*Caso as vidas acabem*/
                        if(Tela.getTela().getVidas() <= 0){
                            Tela.getTela().gameOver();
                            return;
                        }
                    //Inimigos x Varias Coisas
                    }else if(eTemp.isbMortal()){
                        eTemp = (Inimigo) eTemp;
                        eTemp.checaColisao(eTemp2);
                    //Blocos x Varias Coisas
                    } else if(!eTemp.isbTransponivel()){
                        eTemp = (Bloco) eTemp;
                        eTemp.checaColisao(eTemp2);
                    }
                }
            }
        }
    }
}
