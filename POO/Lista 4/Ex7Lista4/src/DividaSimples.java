public class DividaSimples extends Divida{


   public DividaSimples(double valorDivida){
      super();
      this.valor = valorDivida;
   }


   @Override
   public String getDescricao() {

      return "Dívida Símples, com valor de " + valor;
   }

   @Override
   public double getValor() {
      return this.valor;
   }
   
}
