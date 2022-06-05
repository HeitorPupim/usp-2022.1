import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;


public class EXEFileScanner {
    

    public static void scanFiles(String filePath){
       
        File fonte = new File(filePath);
        FilenameFilter filtro = new FilenameFilter(){
            public boolean accept (File dir, String name){
                String lowercaseName = name.toLowerCase();
                if (lowercaseName.endsWith(".exe")) {
                    return true;
                }else return false;
            }
        };

        File [] files = fonte.listFiles(filtro);
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