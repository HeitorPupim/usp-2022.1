public class App {
    public static void main(String[] args) throws Exception {
        
        //vetor de uniao
        Vetor vetor = VetorFactory.getCalculo("uniao");
        vetor.fazerCalculo();

        Vetor vetor2 = VetorFactory.getCalculo("interseccao");
        vetor2.fazerCalculo();

        Vetor vetor3 = VetorFactory.getCalculo("diferenca");
        vetor3.fazerCalculo();

        Vetor vetor4 = VetorFactory.getCalculo("kkkkkkkkk");
        vetor4.fazerCalculo();

    }
}
