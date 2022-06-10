public class App {
    public static void main(String[] args) throws Exception {
        
        //implementar um Design Pattern do tipo Bridge
        int v1[] = {1, 2, 3};
        int v2[] = {4, 5, 6};

        Vetores vetores = new Vetores(v1, v2);

        vetores.CalculeAlgo(new VetorFunctionAdicao());
        vetores.CalculeAlgo(new VetorFunctionProdutoEscalar());
        vetores.CalculeAlgo(new VetorFunctionProdutoVetorial());
        
    }
}
