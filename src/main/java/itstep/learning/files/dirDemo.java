package itstep.learning.files;

import itstep.learning.ConsoleColors;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class dirDemo {
    public void run() {
        String path = "./";
       File dir = new File( path );
       if(dir.exists()) {
           System.out.println(path + " exists");
       }
       if(dir.isFile()) {
           System.out.println( path + " is file");
       }
       else if(dir.isFile()) {
           System.out.println( path + " is directory");
       }
       else  {
           System.out.println( path + " is neither file nor directory");
       }
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yy hh:mm:ss");
       for ( File file : dir.listFiles()) {
           System.out.print(ConsoleColors.BLUE +
                   (file.canRead() ? "r" : "-")
                   + (file.canWrite() ? "w" : "-")
                   + (file.canExecute() ? "x" : "-") + "\t"
                   + ConsoleColors.RESET + "\t"
                   + format.format( new Date(file.lastModified())));

           if(file.isFile()) {
               System.out.print(ConsoleColors.PURPLE +
                        "  " + file.length() + "\t"
                       + ConsoleColors.RESET);
           }
           else {
               System.out.print("\t<DIR>\t");
           }
           System.out.println( file.getName());
       }
    }
}
