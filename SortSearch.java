import java.io.*;
import java.util.Random;
import java.util.Scanner;
/**
 * Class SortSearch
 */
 /**
*
* class PlanetEnumeration
*
* @author  Andrew Kuekam
* @version 1.0
* @since   2020-18-09
*/
public class SortSearch {
  public static void main(String[] args) {
    
    // Random generate
    Random RandomNumber = new Random();
    
    int [] RandomNumberArray = new int[10];
    for (int index = 0; index < 10; index++){
      
      // Number 1 to 99
      int computerNumber = RandomNumber.nextInt(100);
      
      RandomNumberArray[index] = computerNumber;
      System.out.println(RandomNumberArray[index]);
    }
  }
  
  public static void filetxt(String output) {
    
    // create a file name
    String data = "Input.txt";
    
    try {
      // create file
      File myObj = new File(data);
     
      //create the filewriter
      FileWriter fileWriter = new FileWriter(myObj);
        
      // create buffered writter
      BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
     
      // write to txt file
      bufferedWriter.write(output);
     
      // close buffered writer
      bufferedWriter.close();
      
    } catch (Exception e) {
    }
  }
  
}