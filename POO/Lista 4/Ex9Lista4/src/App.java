public class App {
    public static void main(String[] args) throws Exception {
        int mult2 = 4;
        int mult3 = 9;
        int random = 11;

        Numero numero = new Mult2(new Mult3(new MultRandom(null)));

        numero.CalculaNumero(new Calcula(mult2));
        numero.CalculaNumero(new Calcula(mult3));
        numero.CalculaNumero(new Calcula(random));
        
    }
}
