import java.io.File;
import java.util.Comparator;

public class SortFileBySize implements Comparator<File>{

   @Override
   public int compare(File musica1, File musica2) {
      
      if (musica1.length() > musica2.length()){ 
         return 1;
      }
      else if (musica1.length() < musica2.length()){
         return -1;
      }
      else return 0; //msm tamanho.......
   }
   

}
