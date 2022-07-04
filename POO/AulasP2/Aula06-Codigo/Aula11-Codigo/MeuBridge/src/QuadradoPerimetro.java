public class QuadradoPerimetro implements QuadradoCalcular {
   
   public double Calculate(Quadrado umQuadrado) {
      System.out.println("Calculando perimetro do quadrado");
      return umQuadrado.lado * 4; 
   }
}
