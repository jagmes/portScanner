import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler  {
    public void fileHandler(String outfile, String results) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outfile))) {
            writer.write(results);
            System.out.println("Результаты сохранены в файл " + outfile);
        }
    }
}
