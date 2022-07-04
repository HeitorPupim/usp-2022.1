import java.util.Arrays;

public class TwoDimension implements Chain {

   private Chain nextInChain;
   
   public void setNext(Chain c) {
      this.nextInChain = c;
   }

   
   public void process(Dimension request) {
      if (request.getCoordinate().length == 2){
         System.out.println("2 dimension coordinate" + Arrays.toString(request.getCoordinate()));
      }
      else{
         nextInChain.process(request);
      }
   }
   
}
