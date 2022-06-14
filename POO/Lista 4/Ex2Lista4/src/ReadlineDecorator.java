import java.io.FilterInputStream;
import java.io.InputStream;

public abstract class ReadlineDecorator extends FilterInputStream {
   public ReadlineDecorator(InputStream in) {
      super(in);
   }
    
}