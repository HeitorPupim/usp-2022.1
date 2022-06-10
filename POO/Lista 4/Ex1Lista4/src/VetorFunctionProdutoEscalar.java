public class VetorFunctionProdutoEscalar implements VetorFunction{

   public void PerformOperation(Vetores vetores){
      int produtoEscalar = 0;
      for (int i = 0; i < 3; i++){
         produtoEscalar += vetores.getV1()[i] * vetores.getV2()[i];  
      }
      System.out.println("Produto escalar: " + produtoEscalar);
   }
    
}