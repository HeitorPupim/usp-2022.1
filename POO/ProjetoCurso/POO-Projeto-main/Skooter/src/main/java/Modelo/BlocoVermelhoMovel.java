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
public class BlocoVermelhoMovel extends BlocoVermelho implements Serializable{
    
    public BlocoVermelhoMovel(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.bMovel = true;
    }  
}
