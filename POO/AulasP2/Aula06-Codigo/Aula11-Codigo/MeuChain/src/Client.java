public class Client {
   public static void main(String[] args) {
      
      Chain c1 = new OneDimension();
      
      Chain c2 = new TwoDimension();

      Chain c3 = new ThreeDimension();

      c1.process(c2.process(c3.process(new Dimension(5))));   


   }
}
