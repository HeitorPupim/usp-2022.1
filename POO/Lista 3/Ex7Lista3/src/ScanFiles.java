import java.io.File;
import java.util.ArrayList;

public class ScanFiles {
   
   public ArrayList<File> getFileNameList(String filePath, String fileKind){

      File fonte = new File(filePath);
      
      File[] files = fonte.listFiles();

      ArrayList<File> requiredFiles =  new ArrayList<File>();

      for (File file : files){
         
         String name = file.getName();
         try {
            if(name.endsWith(fileKind) == true){
               requiredFiles.add(new File(filePath + "/" + name));
            }
         } catch (Exception e) {
            //TODO: handle exception
            System.out.println("Arquivos indexistentes");
         }
      }

      return requiredFiles;
   }
}
