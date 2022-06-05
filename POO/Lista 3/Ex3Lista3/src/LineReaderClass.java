import java.io.FileReader;
import java.io.LineNumberReader;

public class LineReaderClass {

     String fileName;

     boolean line10WasRead = false;

     public LineReaderClass(String fileName) {
          this.fileName = fileName;
     }
     
     public void verifyLines(){ //função que vai pegar as linhas...
          try(LineNumberReader lineNumberReader = new LineNumberReader( new FileReader(this.fileName))) {
               //Print initial line number
              System.out.println("Line " + lineNumberReader.getLineNumber());
     
               //Setting initial line number
               //lineNumberReader.setLineNumber(5);
     
               //Get current line number
               //System.out.println("Line " + lineNumberReader.getLineNumber());
     
               //Read all lines now; Every read increase the line number by 1
               String line = null;
               while ((line = lineNumberReader.readLine()) != null){
                    System.out.println("Line " + lineNumberReader.getLineNumber() + ": " + line);
                    if (lineNumberReader.getLineNumber() == 10) {
                         System.out.println("\n ---- \nLINHA 10 FOI LIDA!!!!!\n");
                         this.line10WasRead = true;
                    }
               }
          }catch (Exception ex)
          {
               ex.printStackTrace();
          }

          if (!line10WasRead){
               System.out.println(" \n ---- \nNAO TEM 10 LINHAS NESSE TEXTO!!!!!!\n");
          }
     }
     
}
     
