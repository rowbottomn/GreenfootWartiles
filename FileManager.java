import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
//import java.nio.file.Path;
//import java.nio.file.Paths;
/**
 * Write a description of class FileManager here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FileManager
{
    // instance variables - replace the example below with your own
    File input;
    File output;
    FileWriter writer;
    FileReader reader;
//    Path location;
    /**
     * Constructor for objects of class FileManager
     */
    public FileManager()
    {
        
    }
    
    String getPath(){
        //get a reference for the current directory
        try{
            File tempFile = new File("temp.txt");
            String tempPath = tempFile.getAbsolutePath();
            return tempPath.split("temp.txt")[0];
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    void writeOver(String fileName, String msg){
        try{
            //open the file 
            output = new File(fileName);
            //write the info
            writer = new FileWriter(output, false);
            //close the file
            writer.close();
        }
        //catch the exception
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    void write(String fileName, String msg){
        writeAll(fileName, msg+"\n");
    }
    
    void writeAll(String fileName, String msg){
        //in a try catch 
        try{
            //open the file 
            output = new File(fileName);
            //write the info
            writer = new FileWriter(output, true);
            //close the file
            writer.close();
        }
        //catch the exception
        catch(Exception e){
            e.printStackTrace();
        }
            
    }
    
    String read(String fileName){
        String lines = "";
        try{
            input = new File(fileName);
            reader = new FileReader(input);
            BufferedReader br = new BufferedReader(reader);
            String line;
            while ((line = br.readLine()) != null) {
                lines += line;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return lines;
    }
    
}
