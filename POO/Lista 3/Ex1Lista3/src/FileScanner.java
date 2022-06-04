import java.io.File;
import java.io.IOException;

public class FileScanner {
    

    public static void scanFiles(String filePath){
       
        File fonte = new File(filePath);

        File [] files = fonte.listFiles();
        for (File file : files) { /*for(int i=0; i<files.size;i++)*/
            
            try {
                if (new File(file.getCanonicalPath()).isDirectory()){
                    System.out.println("Directory: " + file.getCanonicalPath()+ "\n");
                    //recursão:
                    scanFiles(file.getCanonicalPath());
                }else{
                    System.out.println("Filename:" + file.getName());
                    //System.out.println(file.getName());
                }
            } catch (IOException ex) {
                //TODO: handle exception
                System.out.println("Erro!");
            }
        }
    }
}