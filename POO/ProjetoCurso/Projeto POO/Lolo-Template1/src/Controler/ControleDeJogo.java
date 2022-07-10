package Controler;

import Modelo.Personagem;
import Modelo.Lolo;
import Auxiliar.Posicao;
import java.util.ArrayList;


public class ControleDeJogo {
    public void desenhaTudo(ArrayList<Personagem> e){
        for(int i = 0; i < e.size(); i++){
            e.get(i).autoDesenho();
        }
    }

    public void processaTudo(ArrayList<Personagem> e){
        Lolo bBomberman = (Lolo)e.get(0);
        Personagem pTemp;
        for(int i = 1; i < e.size(); i++){
            pTemp = e.get(i);
            if(bBomberman.getPosicao().igual(pTemp.getPosicao()))
                if(pTemp.isbTransponivel())
                    e.remove(pTemp);
        }        
    }
    
    /*Retorna true se a posicao p é válida para Lolo com relacao a todos os personagens no array*/
    public boolean ehPosicaoValida(ArrayList<Personagem> e, Posicao p){
        Personagem pTemp;
        for(int i = 1; i < e.size(); i++){
            pTemp = e.get(i);            
            if(!pTemp.isbTransponivel())
                if(pTemp.getPosicao().igual(p))
                    return false;
        }        
        return true;
    }
}