import java.io.File;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;


public class App {
    public static void main(String[] args) throws Exception {
        
        //lê o arquivo de texto "text.txt" do diretório atual.
        Path filePath = Path.of(System.getProperty("user.dir") + "/text.txt");
        // lê o conteúdo e armazena na string content.
        String content = Files.readString(filePath);
        // transforma a string content, substituindo "muito" por "pouco".
        content = content.replaceAll("muito", "pouco");

        //verificiando se deu certo de trocar a string.
        //System.out.println(content);


        //Gerando novo arquivo: 

        //Agora vamos gerar um novo arquivo. -> RandomAcessFile.
        String diretorioSaida = System.getProperty("user.dir") + "/saida.txt";
        //File fTemp = new File(diretorioSaida);

        //modo ler e escrever.
        RandomAccessFile raf = new RandomAccessFile(diretorioSaida, "rw");
        //escrevendo no arquivo a partir do início.
        raf.seek(0); //aponta pro começo
        raf.writeUTF(content); //escreve o conteúdo da string "content"

        //vamos acrescentar um "final" pra verificar a funcionalidade do RandomAcessFile

        raf.seek(raf.length()); //joga ponteiro pro final do texto

        //agora vamos escrever "\n Fim do conteúdo! \n"
        
        raf.writeUTF("\n------------------\nFim do conteúdo! \n--------------------------");


        //vamos pedir pra printar oq tem no arquivo, verificando se deu certo.
        //aponta pro começo dnv: 
        raf.seek(0);
        //começa a printar o conteúdo do começo

        while(raf.getFilePointer() < raf.length()){ // da posição do ponteiro até o final (tamanho do raf.)
             System.out.println(raf.readUTF()); //read.UTF retorna uma String
        }

        //fecha o RandomAcessFile
        raf.close();
    }
}
