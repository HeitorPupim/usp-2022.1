package observator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ObjetoObservavel oObservado = new ObjetoObservavel();
        ObjetoObservavel oObservado2 = new ObjetoObservavel();


        ObservadorSoma osSoma = new ObservadorSoma();
        ObservadorProduto osProduto = new ObservadorProduto();

        oObservado.addObserver(osSoma);
        oObservado.addObserver(osProduto);

        Scanner scan = new Scanner (System.in);
        while(true){
            System.out.println("Entre com um novo X:");
            oObservado.setX(scan.nextInt());
            System.out.println("Entre com um novo Y:");
            oObservado.setY(scan.nextInt());
            
            oObservado.notifyObservers(oObservado);
            
        } 
    }

}
