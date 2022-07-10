/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Augusto
 */
public class BlocoFactory {
    /*Padrão de design Abstract Factory:
    O método criaBloco recebe uma string com o tipo e retorna
    a classe de bloco correspondente à string*/
    public static Bloco criaBloco(String tipo){
        if(tipo.equalsIgnoreCase("verde")){
            return new BlocoVerde("blocoVerde.png");
        } else if(tipo.equals("verdeMovel")){
            return new BlocoVerdeMovel("blocoVerdeMovel.png");
        } else if(tipo.equals("vermelho")){
            return new BlocoVermelho("blocoVermelho.png");
        } else if(tipo.equals("vermelhoMovel")){
            return new BlocoVermelhoMovel("blocoVermelhoMovel.png");
        } else{
            return null;
        }
    }
}
