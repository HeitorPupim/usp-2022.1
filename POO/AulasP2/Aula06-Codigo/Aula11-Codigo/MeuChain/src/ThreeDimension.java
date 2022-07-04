import java.util.Arrays;

public class ThreeDimension implements Chain {

   private Chain nextInChain;
   
   public void setNext(Chain c) {
      this.nextInChain = c;
   }

   
   public void process(Dimension request) {
      if (request.getCoordinate().length == 3){
         System.out.println("3 dimension coordinate" + Arrays.toString(request.getCoordinate()));
      }
      else{
         //nextInChain.process(request);
         System.out.println("Foda-se!!!!!!!!");
      }
   }
   
}
