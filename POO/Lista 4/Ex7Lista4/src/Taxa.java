public class Taxa extends DividaDecorator{

   double fTaxa;

   protected Taxa(Divida divida, double fTaxa) {
      super(divida);
      this.fTaxa = fTaxa;
      
   }

   @Override
   public String getDescricao() {
      return novaDivida.getDescricao() + " + acréscimo (taxa) de " + fTaxa;
   }

   @Override
   public double getValor() {
      return novaDivida.getValor() + fTaxa;
   }
   
}
