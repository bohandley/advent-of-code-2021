import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import java.util.ArrayList;  
import java.util.Arrays;  

public class ReadFileTwo {  
  public static void main(String[] args) {  
    // create an array
    Integer arr[] = {};
 
 		// create an array list from the array using Array.asList()
    ArrayList<Integer> nums = new ArrayList<Integer>(Arrays.asList(arr));

    try {
      File myObj = new File("nums.txt");
      Scanner myReader = new Scanner(myObj);

      // populate the arrayList with the text  
      while (myReader.hasNextInt()) 
        nums.add(myReader.nextInt());

      int total = 0;
      int idx = 0;
      int cur = 0;
      int next = 0;

      // iterate up until we get to the last sliding sum of 3 vals
      while (nums.size() > idx + 3) {
      	cur = nums.get(idx) + nums.get(idx+1) + nums.get(idx+2);
      	next = nums.get(idx+1) + nums.get(idx+2) + nums.get(idx+3);

      	if(cur < next)
      		total++;

      	idx++;
      }

      System.out.println(total);
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    } 
  }  
}