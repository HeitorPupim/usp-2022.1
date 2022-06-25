import java.util.Observer;
import java.util.Date;
import java.util.Observable;

public class ObservadorMaiuscula implements Observer{

    Date dt = new Date();
    int year =dt.getYear() + 1900;

    private String novaString;

    public void update(Observable o, Object arg){
        ObjetoObservavel OOTemp = (ObjetoObservavel)o;

        this.novaString = OOTemp.getFrase().toUpperCase() + this.year;

        System.out.println("String formatada:\n" + this.novaString);
    }
    
}
