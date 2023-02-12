package itstep.learning.ioc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader implements IConfigReader {
    private  String fileName = "..\\Basics\\src\\main\\java\\itstep\\learning\\config.ini";
    private Properties prop = new Properties();

    public String getParam(String param){
        try (FileInputStream fis = new FileInputStream(fileName)) {
            prop.load(fis);
            return prop.getProperty(param);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
