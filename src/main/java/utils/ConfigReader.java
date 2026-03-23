package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static final Properties prop;
    static{
        try{
            InputStream is = ConfigReader.class
                    .getClassLoader()
                    .getResourceAsStream("config.properties");
            if (is == null) {
                throw new RuntimeException("config.properties not found in classpath");
            }
            prop = new Properties();
            prop.load(is);
        } catch(IOException e) {
            throw new RuntimeException("Failed to load config file");
        }
    }
    public static String get(String key){
        return prop.getProperty(key);
    }
}
