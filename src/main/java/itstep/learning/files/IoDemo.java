package itstep.learning.files;

import itstep.learning.ConsoleColors;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IoDemo {
    public void run() {
        String name = "results.txt";
        Path path = Paths.get(name);
        if(Files.exists(path)){
            try( InputStream inputStream = Files.newInputStream(path)) {
                StringBuilder str = new StringBuilder();
                int code;
                while((code = inputStream.read()) != -1) {
                    str.append((char) code);
                }
                System.out.println(ConsoleColors.YELLOW + "File content: " + ConsoleColors.RESET);
                System.out.println(ConsoleColors.CYAN +  str.toString() + ConsoleColors.RESET);
            }
            catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        }
        else {
            try(FileWriter writer = new FileWriter(name)) {
                writer.write("unicorns for life \n more unicorns requested");
                writer.flush();
            }
            catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }
}
