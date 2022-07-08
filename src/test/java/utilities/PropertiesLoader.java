package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesLoader {

    private static String getProperty(File propertiesFile, String key){

        FileInputStream fileInput = null;

        try{
            fileInput = new FileInputStream(propertiesFile);
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

        Properties properties = new Properties();

        try{
            properties.load(fileInput);
        } catch (IOException e){
            e.printStackTrace();
        }

        return properties.getProperty(key);
    }

    public static String getProperty(String key){
        File file = new File ("src/test/resources/config.properties");
        return getProperty(file, key);
    }
}
