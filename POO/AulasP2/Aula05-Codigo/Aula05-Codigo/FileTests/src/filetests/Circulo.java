
package filetests;

import java.io.Serializable;

public class Circulo implements Serializable{
    float fRaio;
    float fArea;
    String sNome;
    Circulo(float fARaio, float fAArea, String sANome){
        fRaio = fARaio;
        fArea = fAArea;
        sNome = sANome;
    }

    public String toString() {
        return "Circulo{" + "fRaio=" + fRaio + "fArea=" + fArea + "sNome=" + sNome + '}';
    }
}
