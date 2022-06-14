public class Juros extends DividaDecorator{

   double fJurosSimples = 1;


   public Juros(Divida divida, double fJurosSimples) {
      super(divida);
      this.fJurosSimples += fJurosSimples;
   }

   @Override
   public double getValor() {
      return novaDivida.getValor() * (fJurosSimples);
   }

   @Override
   public String getDescricao() {
      return novaDivida.getDescricao() + " + juros simples de "  + fJurosSimples;
   }
   
}


