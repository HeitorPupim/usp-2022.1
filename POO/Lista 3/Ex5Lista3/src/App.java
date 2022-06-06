import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class App {
    public static void main(String[] args) throws Exception {
       
        
        //escrever classe Dados Pessoais e outra Aleatória.
        // usar classe que escreve e lê  as instancias das classes
        // classe ObjectOutputStream
        // classe ObjectInputStream.

        //caminho da entradat
        
        int data1 = 5;
        String data2 = "Heitor Pupim";

        try {
            //gera arquivo para inserção
            FileOutputStream file = new FileOutputStream("object.java");
            //objeto que sairá do arquivo -> passa como parâmetro o arquivo gerado
            ObjectOutputStream output = new ObjectOutputStream(file);

            // escrevendo no arquivo usando o ObjectOutputStream:

            output.writeInt(data1);
            output.writeObject(data2);

            //lê o arquivo gerado
            FileInputStream fileStream = new FileInputStream("object.java");
            //criando o objectInput q será lido
            ObjectInputStream objStream = new ObjectInputStream(fileStream);

            //usando método readInt();
            System.out.println("int data : "+ objStream.readInt());

            //usando o readObject();
            System.out.println("object data: " + objStream.readObject());

            output.close();
            objStream.close();
        } catch (Exception e) {
            //TODO: handle exception
            e.getStackTrace();
        }
      
    }
}