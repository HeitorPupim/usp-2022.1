public class Desconto extends DividaDecorator{

   double fDesconto;

   protected Desconto(Divida divida, double fDesconto) {
      super(divida);
      this.fDesconto = fDesconto;
   }

   public String getDescricao() {
      return novaDivida.getDescricao() + " + desconto de " + fDesconto;
   }

   public double getValor() {
      return novaDivida.getValor() - (novaDivida.getValor() * (fDesconto));
   }


}
