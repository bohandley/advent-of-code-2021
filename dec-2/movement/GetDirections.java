package movement;
// define the package

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;  
import java.util.Arrays;  

// make a method in the GetDirections class to read a file
public class GetDirections {  
  public ArrayList<String> listOfDirections() {  
 
 		// create an array list 
    ArrayList<String> directions = new ArrayList<String>();

    try {
      File myObj = new File("directions.txt");
      Scanner myReader = new Scanner(myObj);

      // populate the arrayList with the text  
      while (myReader.hasNextLine()) 
        directions.add(myReader.nextLine());

      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }

    return(directions);
  }  
}
