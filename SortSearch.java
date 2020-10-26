// import
import java.util.Random;
import java.io.*;
import java.util.Scanner;


/**
 * Class Sort Search.
* @author  John Junior Omage
* @version 1.0
* @since   2020-10-21
*/


public class SortSearch {
  
  /**
   * * Required javadoc.
  */
  
  public static int binarySearch(int arrayNum[], int leftHalf, int rightHalf, int userNumSearch) {
    
    if (rightHalf >= leftHalf) {
      
      // find position of middle of the array
      int mid = leftHalf + (rightHalf - leftHalf) / 2;
      
      // if user number asked for is the same
      if (arrayNum[mid] == userNumSearch) {
        // return mid as the mid number
        return mid;
      // if user number asked for is larger than
      // the mid of array located,
      } else if (arrayNum[mid] > userNumSearch) {
        // return and look at the left half side of the array 
        return binarySearch(arrayNum, leftHalf, mid - 1, userNumSearch);
      } else {
        // return and look at the right half side of the array from middle
        return binarySearch(arrayNum, mid + 1, rightHalf, userNumSearch);
      }
    } else {
      // return -1
      return -1;
    }
  }
  
  /**
   * * Required javadoc.
  */
  
  public static void main(String[] args) {
    
    // declare var
    boolean runLine = true;
    int userSizeList = 0;
    
    try { 
      
      // create to write files
      FileWriter myWriter = new FileWriter("INPUT.txt");
      
      // run while line is true, else escape...
      while (runLine) {
        
        // create scanner
        Scanner userInput = new Scanner(System.in);
        
        // ask user to enter size of list
        System.out.println("Enter size of list:");
        
        if (userInput.hasNextInt()) {
          // set size to input
          userSizeList = userInput.nextInt();
          runLine = false;
        }  else {
          
          // display error
          System.out.println("Enter an integer number.");
          
        }
        
        // write to input.txt
        myWriter.write("List size: " + userSizeList + "\n\r");
      }
      
      // create random
      Random randomNumberGenerator = new Random();
      
      // print "unsorted numbers" text
      System.out.print("Unsorted Numbers: ");
      System.out.println();
      
      // declare var
      int range = 999;
      
      // create to write files
      FileWriter myWriter2 = new FileWriter("OUTPUT.txt");
      
      // write to output.txt
      myWriter2.write("The unsorted list is: ");
      
      myWriter.write("Range of list: 0 to " + range);
      
      // create an array
      int[] arrayNum = new int[userSizeList];
      
      // generate a new number everytime
      for (int i = 0; i < arrayNum.length; i++) {
        // generate random number between 0 and 999
        int randomNumber = randomNumberGenerator.nextInt(range + 1);
        
        // random number is assigned to the cell at position i
        arrayNum[i] = randomNumber;
        
        // print array with nums
        System.out.print(arrayNum[i] + " ");
        
        // write to input.txt
        myWriter2.write(arrayNum[i] + " ");
      }
      
      // reference:
      // https://www.geeksforgeeks.org/bubble-sort/
      // sort the array with bubblesort
      for (int i = 0; i < arrayNum.length - 1; i++) {
        // goes through until length is less than swap
        for (int swap = 0; swap < arrayNum.length - i - 1; swap++) {
          if (arrayNum[swap] > arrayNum[swap + 1]) {
            // assign temp to arrayNum of position
            int temp = arrayNum[swap];
            // swaps the two numbers in the array
            arrayNum[swap] = arrayNum[swap + 1];
            // increase position in array, assign to temp
            arrayNum[swap + 1] = temp;
          }
        }
      }
      
      // print sorted
      System.out.println();
      System.out.print("Sorted Numbers: ");
      System.out.println();
      
      // write to output.txt
      myWriter2.write("\n\r" + "The sorted list is: ");
      
      for (int index = 0; index < arrayNum.length; index++) {
        // print the sorted array
        System.out.print(arrayNum[index] + " ");
        
        // write to input.txt
        myWriter2.write(arrayNum[index] + " ");
      }
      
      // Delay time for 1.5s
      try {
        Thread.sleep(1500);
      }   catch (InterruptedException ex) {
        Thread.currentThread().interrupt();
      }
      
      // create second scanner
      Scanner userInput2 = new Scanner(System.in);
      
      // ask user which number
      System.out.println();
      System.out.println("What number are you looking for?");
      
      // set user search to input of user
      int userNumSearch = userInput2.nextInt();
      
      // write to input txt
      myWriter.write("\n\r" + userNumSearch + " <-- This would be a random number in");
      
      // write to input 
      myWriter.write(" the above range to search for. ");
      
      // call function for binary search
      int result = binarySearch(arrayNum, 0, arrayNum.length - 1, userNumSearch);
      
      // if result is returned as -1, 
      if (result == -1) {
        // print to user number does not exist
        System.out.println("Number does not exist in the array.");
        
        myWriter2.write("\n\r" + "Number does not exist in list.");
      } else {
        // print to user number at the index position.
        System.out.println("The number is found at index: " + result);
        
        // write to output.txt
        myWriter2.write("\n\r" + userNumSearch + " is at index " + result + " in the list.");
        
      }
      
      // close the write 
      myWriter.close();
      myWriter2.close();
      
    } catch (IOException e) {
      // print error
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}