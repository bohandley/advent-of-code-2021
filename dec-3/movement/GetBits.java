package movement;
// define the package

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;  
import java.util.Arrays;
import java.util.HashMap;  

// make a method in the GetDirections class to read a file
public class GetBits {  
  public ArrayList<int[]> nestedArrayOfBits(String fileName) {  
 
 		// create an array list with array elements
    ArrayList<int[]> bits = new ArrayList<int[]>();

    try {
      File myObj = new File(fileName);
      Scanner myReader = new Scanner(myObj);

      // populate the arrayList with the text  
      while (myReader.hasNextLine()) {
        String line = myReader.nextLine();

        int idx = 0;
        
        while (line.length() > idx) {
          
          if(idx >= bits.size()){
            // add array and increment val at 0 or 1 position for bit count
            int[] nums = new int[]{0,0};
            bits.add(nums);
            bits.get(idx)[Character.getNumericValue(line.charAt(idx))] += 1;
          } else {
            // increment val at 0 or 1 position for bit count
            bits.get(idx)[Character.getNumericValue(line.charAt(idx))] += 1;
          }
                    
          idx++;
        }

      }

      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }

    return(bits);
  } 

  public ArrayList<String> arrayOfBits(String fileName) {  
 
    // create an array list with array elements
    ArrayList<String> bits = new ArrayList<String>();

    try {
      File myObj = new File(fileName);
      Scanner myReader = new Scanner(myObj);

      // populate the arrayList with the text  
      while (myReader.hasNextLine()) {
        String line = myReader.nextLine();

        bits.add(line);
      }

      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }

    return(bits);
  } 
}
