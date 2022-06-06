import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) throws Exception {
        
        Path filePath = Path.of("/home/heitor/workspace/usp-2022.1/POO/Lista 3/Ex6Lista3/text.txt");
        
        String content = Files.readString(filePath);


        
        content.replaceAll("muito", "pouco");

        try {
            
            String outputPathString = "/home/heitor/workspace/usp-2022.1/POO/Lista 3/Ex6Lista3/text2.txt";
            Path outputPath = new Path.of(outputPathString);
            //Files.writeString(outputPath, content, StandardCharsets.UTF_8);
            
            Files.writeString(outputPath, content, StandardCharsets.UTF_8);

        } catch (Exception e) {
            //TODO: handle exception
            System.out.println("invalid path, bruh.");
        }
    }
}
