public class VetorFunctionProdutoVetorial implements VetorFunction {

   public void PerformOperation(Vetores vetores) {

      int[] v = new int[3];
      for (int i = 0; i < 3; i++) {
         v[i] = vetores.getV1()[i] * vetores.getV2()[i];
      }
      System.out.println("Produto vetorial: {" + v[0] + " , " + v[1] + " , " + v[2] + "}");	
   }



}