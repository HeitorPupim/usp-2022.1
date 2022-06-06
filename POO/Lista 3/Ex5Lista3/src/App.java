import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class App {
    public static void main(String[] args) throws Exception {

        //acessa o diretório atual do pc da pessoa: System.getProperty:

        System.out.println("Diretorio:  " + System.getProperty("user.dir"));
        //Caminho do arquivo compactado: (saída / output/)
        File dados = new File(System.getProperty("user.dir")+ "/DadosPessoais.gz");
        
        /*
            Cria um novo arquivo, se já existir, diz que o arquivo já existe e não faz nada 
        */
        if (dados.createNewFile()){
            System.out.println("Arquivo criado!");
        }else System.out.println("Arquivo já existente.");

        //"Cria um arquivo, dado o arquivo q foi passado no parâmetro."
        FileOutputStream fout = new FileOutputStream(dados);
        //comprime arquivo:
        GZIPOutputStream compactador = new GZIPOutputStream(fout);
        //serializador:
        ObjectOutputStream oOutStream = new ObjectOutputStream(compactador);

        
        /*  Escrevendo um objeto do tipo "DadosPessoais", onde atribuimos alguns 
            valores às instâncias!
        */
        oOutStream.writeObject(new DadosPessoais("3103131", "Heitor", "Pupim", "2913129", new Endereco("Rua 12", "Jd Luftfalla", "Sanca", "123-132")));
        oOutStream.writeObject(new DadosPessoais("2131123", "Pedro", "Zambrozi", "123123", new Endereco("Rua 3", "Jd Macarengo", "Sanca", "123-312")));
        oOutStream.flush(); //envia a escrita pro arquivo.

        oOutStream.close(); //fecha a serialização.
        compactador.close(); //fecha o compactador.
        
        //Lendo o arquivo gerado!

        /*  Acessa o arquvio, pasando como parâmetro o local onde ele está,
         * nesse caso é em "dados", que tem o diretório!
         */
        FileInputStream fin = new FileInputStream(dados);
        /*  Como acessamos um arquivo compactado, precisamos descompactar! */
        GZIPInputStream descompactador = new GZIPInputStream(fin);
        /*  Depois de descompactado, vamos deserializar este arquivo! */
        ObjectInputStream oInStream = new ObjectInputStream(descompactador);

        /*Aqui vamos criar classes genéricas do Java, 
        ou seja, uma Object Class! */
        Object dadosPessoais1 = new Object();
        Object dadosPessoais2 = new Object();

        /*Agora, estamos atribuindo a característica da classe que está sendo lida
         * na classe genérica que acabou de ser criada.
         * Como lemos esse objeto, ele passa a ser um classe do tipo "DadosPessoais"
         * e não mais um "Object"! :)
         */
        dadosPessoais1 = oInStream.readObject();
        dadosPessoais2 = oInStream.readObject();

        /*Aqui vamos printar o conteúdo de cada classe e verificar se deu certo! */
        System.out.println(dadosPessoais1.toString());
        System.out.println("------------------------");
        System.out.println(dadosPessoais2.toString());

        /*Fechando os recursos: */
        oInStream.close();
        descompactador.close();
    }
}