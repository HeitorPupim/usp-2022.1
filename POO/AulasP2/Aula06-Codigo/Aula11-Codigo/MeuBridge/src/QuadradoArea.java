public class QuadradoArea implements QuadradoCalcular {

   @Override
   public double Calculate(Quadrado umQuadrado) {
      System.out.println("Calculando area do quadrado");
      return umQuadrado.lado * umQuadrado.lado;
   }
   
}
