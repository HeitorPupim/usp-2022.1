public class App {
    public static void main(String[] args) throws Exception {
        
        DividaSimples divida = new DividaSimples(100);
        
        System.out.println(divida.getDescricao());
        System.out.println("Valor da divida: " +divida.getValor());

        Juros dividaComJuros = new Juros(divida, 0.2);

        System.out.println(dividaComJuros.getDescricao());	
        System.out.println("Valor da divida: " +dividaComJuros.getValor());

        Desconto dividaComDesconto = new Desconto(dividaComJuros, 0.1);

        System.out.println(dividaComDesconto.getDescricao());

        System.out.println("Valor da divida: " +dividaComDesconto.getValor());

        Taxa dividaComTaxa = new Taxa(dividaComDesconto, 10.50);

        System.out.println(dividaComTaxa.getDescricao());


        System.out.println("Valor total da Divida: " + dividaComTaxa.getValor());
    }
}
