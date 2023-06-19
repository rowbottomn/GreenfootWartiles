/**
 * Write a description of class ArrayManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ArrayManager  
{
    FileManager fm;
    
   int[][] fillArrayWithData(String fileName){
        fm = new FileManager();
        //load map file
        String input = fm.read(fileName);
        //System.out.println(input);
        String[] lines = input.split(";");
        int[][] arr = new int[8][8];
        
        for(int i = 0; i < lines.length;i++){
            
            String[] tileStrings = lines[i].split(",");

            for(int j = 0; j < tileStrings.length; j++){
                arr[i][j] = Integer.parseInt(tileStrings[j]);
                System.out.print(arr[i][j]);
            }    
            
        }   
        return arr;
    }
    
    int[][] fillArrayWithZeroes(int w, int h){
        int [][] arr = new int[w][h];
        for(int i = 0; i < w; i++){
            for(int j = 0; j < h; j++){
                arr[i][j] = 0;
            }
        }
        return arr;
    }
    
    String arrayToString(int[][] arr){
        String output = "";
        for (int i = 0; i < arr.length-1; i++){
            for(int j = 0; j < arr[0].length-1; j++){
                output+=""+arr[i][j]+",";
            }
            output += arr[i][arr[0].length-1]+";";
        }
        return output;
    }
    
}
