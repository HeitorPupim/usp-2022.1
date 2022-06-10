public class Vetores {
    
   int v1[], v2[];

   public Vetores(int[] v1, int[] v2) {
      this.v1 = v1;
      this.v2 = v2;
   }


   public int[] getV1() {
      return v1;
   }

   public int[] getV2() {
      return v2;
   }

   public void CalculeAlgo(VetorFunction vf) {
      vf.PerformOperation(this);
   }
}