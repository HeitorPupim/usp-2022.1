import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        



        ObjetoObservavel obj1 = new ObjetoObservavel();

        ObservadorMaiuscula oMaiusc = new ObservadorMaiuscula();

        obj1.addObserver(oMaiusc);

        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("Insira uma string:");
            obj1.setFrase(sc.nextLine());

            obj1.notifyObservers(obj1);
            break;
        }
    }
}