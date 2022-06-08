import java.io.File;
import java.util.ArrayList;
import java.util.Collections;


public class App {
    public static void main(String[] args) throws Exception {
        
        /* OBS: se estiver usando Windows, tem q alterar a "/" para "\"
         * na linha 19 da classe ScanFiles.
        */

        /* 
         * Escreva um programa que recebe um caminho de diretório e que, apenas para os 
            arquivos .mp3 encontrados, renomeie os arquivos da seguinte maneira:
            - se houver algarismos ou hifens no nome do arquivo, eles serão removidos;
            - ordene os arquivos encontrados por tamanho dos arquivos;\watch
            - coloque no início do arquivo um contador formado por quatro algarismos de acordo com a 
            ordenação.
            Exemplo: musica_do_ano278.mp3 (5ª. música, após ordenação) 
            0005.musica_do_ano.mp3
             para ordenação pesquise e use a classe comparator -
            http://www.tutorialspoint.com/java/java_using_comparator.htm
         */
        
        //pega o diretório atual do projeto:
        String diretorio = System.getProperty("user.dir");

        //cria um arraylist de arquivos que receberá todos os .mp3.
        ArrayList<File> arquivosMP3 = new ArrayList<File>();

        //ScanFiles retorna um ArrayList<File> dos arquivos encontrados que terminam com ".mp3"
        ScanFileByKind scanfile = new ScanFileByKind();
        arquivosMP3 = scanfile.getFileNameList(diretorio, ".mp3");
        

        System.out.println("Arquivo antes de serem removidos: ");
        for (File item : arquivosMP3){
            System.out.println(item.getName());
        }
        System.out.println("\n------------------------\n");

        System.out.println("Removendo arquivos que contém  - : ");
        //remove do ArrayList e do diretório os arquivos q contém "-"
        RemoveSelectedFiles filterNameFiles = new RemoveSelectedFiles();
        filterNameFiles.removeFilesByName(arquivosMP3, "-");
        
        System.out.println("\n------------------------\n");
        System.out.println("Arquivos resultantes após a remoção: ");
        for (File item : arquivosMP3){
            System.out.println(item.getName());
        }

        System.out.println("\n------------------------\n");
        System.out.println("Ordenando arquivos pelo tamanho.");
        
         
        //ordena os arquivos conforme o tamanho. SortFileBySize implements Comparator<File>
        Collections.sort(arquivosMP3, new SortFileBySize());
        System.out.println("\n------------------------\n");

        System.out.println("Arquivos Ordenados pelo tamanho: ");
        //printa o nome dos arquivos c/ tamanho.
        for (File arquivo : arquivosMP3){
            System.out.println(arquivo.getName() + " ---length =  " +arquivo.length());
        }

        //fazendo um teste dos arquivos criados.
        String[] counter=new String[10000];
        for (int i = 0; i < arquivosMP3.size(); i++) {
            counter[i] = String.format("%04d", i + 1); 
            // --------------------------------> "/" pq tá no linux!
            arquivosMP3.get(i).renameTo(new File(diretorio + "/" + counter[i] + "." + arquivosMP3.get(i).getName() + ".mp3"));
        }
    }
}
