public abstract class DividaDecorator extends Divida {
   
   //único parâmetro
   Divida novaDivida;

   //construtor dos decorators
   protected DividaDecorator(Divida divida){

      this.novaDivida = divida;
   }
   
}
