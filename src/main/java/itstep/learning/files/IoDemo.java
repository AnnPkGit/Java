package itstep.learning.files;

import itstep.learning.ConsoleColors;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

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

        String nameOfRandomFile = "random.txt";
        Path pathOfRandomFile = Paths.get( nameOfRandomFile);

        if(Files.exists(pathOfRandomFile)){
            try( InputStream inputStream = Files.newInputStream(pathOfRandomFile)) {
                Random rand = new Random();
                int randomNumber = rand.nextInt(100 + 1);

                try(FileWriter writer = new FileWriter(nameOfRandomFile)) {
                    for (int i = 0; i <= randomNumber; i++) {
                        StringBuilder strToWrite = new StringBuilder();

                        int secondRandom = rand.nextInt(10 + 1);
                        for (int b = 0;b <= secondRandom; b++) {
                            strToWrite.append("unicorns for life ");
                        }
                        writer.write(strToWrite +"\n");
                    }
                    writer.flush();

                    char spaceChar = '\n';
                    StringBuilder str = new StringBuilder();
                    String longestStr = new String();
                    int code;
                    int strNumber = 1;

                    while((code = inputStream.read()) != -1) {
                        str.append((char) code);
                        char charCode = (char)code;

                        if(Character.compare(charCode, spaceChar) == 0){
                            strNumber++;
                            if(longestStr.length() < str.length()) {
                                longestStr = str.toString();
                            }
                            str.setLength(0);
                        }
                    }

                    longestStr = longestStr.replaceAll("\n", " ");
                    System.err.println("LONGEST number " +  strNumber);
                    System.err.println("LONGEST length " + longestStr.length());
                    System.err.println("LONGEST " + longestStr);
                }
                catch (IOException ex) {
                    System.err.println(ex.getMessage());
                }
            }
            catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        }
        else {
            try(FileWriter writer = new FileWriter(nameOfRandomFile)) {
                writer.write("unicorns for life \n more unicorns requested");
                writer.flush();
            }
            catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }
}
