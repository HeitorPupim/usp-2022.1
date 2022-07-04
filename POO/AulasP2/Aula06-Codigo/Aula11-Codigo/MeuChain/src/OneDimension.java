import java.util.Arrays;

public class OneDimension implements Chain {

   private Chain nextInChain;
   
   public void setNext(Chain c) {
      this.nextInChain = c;
   }

   
   public void process(Dimension request) {
      if (request.getCoordinate().length == 1){
         System.out.println("1 dimension coordinate" + Arrays.toString(request.getCoordinate()));
      }
      else{
         nextInChain.process(request);
      }
   }
   
}
