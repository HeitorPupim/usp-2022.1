public class Quadrado extends AbstractForma{
   
   double lado;

   public Quadrado(double lado){
      this.lado = lado;
   }
   
   public void draw(){
      System.out.println("This is a square!");
   }

   public double QuadradoCalcular(QuadradoCalcular function){
      return function.Calculate(this);
   }
}
