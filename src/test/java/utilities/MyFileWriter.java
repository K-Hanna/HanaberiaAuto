package utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MyFileWriter {

    public void writeToFile(String content){
        try{
            File file = new File("results.json");
            if(!file.exists())
                file.createNewFile();
            FileWriter fileWriter = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(content);
            bufferedWriter.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void clearContent(){
        try{
            File file = new File("results.json");
            new FileWriter(file.getAbsoluteFile(), false).close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
