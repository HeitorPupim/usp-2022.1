public class Dimension {
   private int[] coordinate;

   public Dimension(int x){
      this.coordinate = new int[]{x};
   }

   public Dimension(int x, int y){
      this.coordinate = new int[]{x,y};
   }

   public Dimension(int x, int y, int z){
      this.coordinate = new int[]{x,y,z};
   }

   public int[] getCoordinate(){
      return this.coordinate;
   }
}
