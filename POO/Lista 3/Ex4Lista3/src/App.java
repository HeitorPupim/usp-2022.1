import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        //escrever meu nome em string, pegar os bytes, escrever em byte

        String myName = "Heitor Pupim / Pedro Zambrozi";
        
        byte array[] = myName.getBytes();


        //ByteArrayInputStream byteArray = new ByteArrayInputStream(array);

        try {
            FileOutputStream fout = new FileOutputStream("/home/heitor/workspace/usp-2022.1/POO/Lista 3/Ex4Lista3/test.txt");
            
            fout.write(array);
            fout.close();
        } catch (Exception e) { //printa o exception
            System.out.println(e);
        }
    }
}
