import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFileOne {  
  public static void main(String[] args) {  
    int total = -1;
    int prev = 0;
    try {
      File myObj = new File("nums.txt");
      Scanner myReader = new Scanner(myObj);  
      while (myReader.hasNextInt()) {
        int cur = myReader.nextInt();

        if(prev < cur)
          total = total + 1;

        prev = cur;
      }

      System.out.println(total);
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    } 
  }  
}