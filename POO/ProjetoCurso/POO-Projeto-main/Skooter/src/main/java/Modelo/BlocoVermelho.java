package Modelo;

import java.io.Serializable;

public class BlocoVermelho extends Bloco implements Serializable{
    
    public BlocoVermelho(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.bDestrutivel = false;
    }
}
