package Guru99_Ecom.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static final Properties prop;
    static{
        try{
            FileInputStream fis = new FileInputStream("src/test/java/Guru99_Ecom/resources/config.properties");
            prop = new Properties();
            prop.load(fis);
        } catch(IOException e) {
            throw new RuntimeException("Failed to load config file");
        }
    }
    public static String get(String key){
        return prop.getProperty(key);
    }
}
