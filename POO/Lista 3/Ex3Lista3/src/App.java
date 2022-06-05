
public class App {

    public static void main(String[] args) {
        //FileScanner fileScan = new FileScanner();
        //String filePath = "/home/heitor/workspace/usp-2022.1/POO/Lista 3/Ex3Lista3";
        //EXEFileScanner.scanFiles(filePath);
        System.out.println("\n\n\n ---------------------");

        String fileName = "/home/heitor/workspace/usp-2022.1/POO/Lista 3/Ex3Lista3/text.txt";
        
        LineReaderClass lineReader = new LineReaderClass(fileName);

        lineReader.verifyLines();
       

    }
}
