import java.io.File;
import java.util.ArrayList;

public class RemoveSelectedFiles {

   public void removeFilesByName(ArrayList<File> files,String flag){

      
      for (int i = 0; i < files.size(); i++) {
         
         File fileToBeRemoved = new File(files.get(i).getAbsolutePath());
         if (fileToBeRemoved.getName().contains(flag)){
            
            
            String filename = fileToBeRemoved.getName();
            
            //remove o arquivo
            boolean removed = fileToBeRemoved.delete();
            if (removed == true){ //se foi removido do diretório, printa o nome
               System.out.println("Arquivo deletado: " + filename);
            }
            //remove do ArrayList.
            files.remove(files.get(i));
            i--; //como o tamanho do arquivo muda, temos que decrementar uma interação.
         }
      }
   }
}
