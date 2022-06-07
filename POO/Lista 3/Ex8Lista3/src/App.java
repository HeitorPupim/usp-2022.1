import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) throws Exception {
        
        String dir = System.getProperty("user.dir");
        

        //escolhe o arquivo de texto text.txt
        File fileChosen = new File(dir + "/text.txt");
        
        //transforma em arquivo de entrada
        FileInputStream inputStreamFile = new FileInputStream(fileChosen);

        //escolhe o arquivo de leitura
        InputStreamReader inputStreamReader = new InputStreamReader(inputStreamFile);

        //cria o buffer
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        MeuReadLine readLineZika = new MeuReadLine(bufferedReader);

        String line;
        while ((line = readLineZika.readLine()) != null){
            
            System.out.println(line);
        }

    }
}
