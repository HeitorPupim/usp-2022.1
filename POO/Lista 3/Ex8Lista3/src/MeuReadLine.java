import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class MeuReadLine extends BufferedReader{
   int iLineNumber;

   public MeuReadLine(Reader in) {
      super(in);
      this.iLineNumber = 0;
   }

   public String readLine() throws IOException{

      String sLine = super.readLine();

      if(sLine != null){
         iLineNumber++;
         sLine = "linha "+ iLineNumber + ":" + sLine;
      }
      return sLine;
   }
}