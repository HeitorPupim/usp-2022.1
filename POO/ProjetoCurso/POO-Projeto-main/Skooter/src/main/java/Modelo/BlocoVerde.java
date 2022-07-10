package Modelo;

import java.io.Serializable;

public class BlocoVerde extends Bloco implements Serializable{
    
    public BlocoVerde(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.bDestrutivel = true;
    }
}
