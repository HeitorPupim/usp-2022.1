import java.util.Observable;

public class ObjetoObservavel extends Observable{
    String frase;

    //construtor com parametro vazio
    public ObjetoObservavel(){
    }

    void setFrase(String frase){
        this.frase = frase;
        this.setChanged();
    }

    String getFrase(){
        return this.frase;
    }
    
}
