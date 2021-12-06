import movement.GetBits;

import java.util.ArrayList; 

public class LifeSupport {

	public static void main (String[] args) {
		ArrayList<String> bits = twoBits();

		System.out.println(bits.get(0));
		System.out.println(bits.get(1));

		ArrayList<String> lsr = findLifeSupportRating();

		System.out.println(lsr.get(0));
		System.out.println(lsr.get(1));
	}

	public static ArrayList<String> twoBits() {
		GetBits d = new GetBits();

		ArrayList<int[]> nestedArrayOfBits = d.nestedArrayOfBits("bits.txt");

		String gamma = "";
		String epsilon = "";

		int idx = 0;

		while (nestedArrayOfBits.size() > idx) {

			int[] nums = nestedArrayOfBits.get(idx);

			if (nums[0] > nums[1]){
				gamma += "0";
				epsilon += "1";
			} else {
				gamma += "1";
				epsilon += "0";
			}

			idx++;
		}

		ArrayList<String> bits = new ArrayList<String>();

		bits.add(gamma);
		bits.add(epsilon);

		return(bits);
	}

	public static ArrayList<String> findLifeSupportRating(){
		GetBits d = new GetBits();

		// full colection
		ArrayList<String> arrayOfBits = d.arrayOfBits("bits.txt");

		// collection for oxygen
		ArrayList<String> oxygen = findLifeSupportVal(arrayOfBits, "oxygen");
		
		// colllection for carbon
		ArrayList<String> carbon = findLifeSupportVal(arrayOfBits, "carbon");

		ArrayList<String> lsr = new ArrayList<String>();
		// display the ratings
    lsr.add(oxygen.get(0));
    lsr.add(carbon.get(0));

    return(lsr);
	}

	public static ArrayList<String> findLifeSupportVal(ArrayList<String> bits, String chk) {
		// iterate through the full collection
		int idx = 0;
		// iterate through the string
		int lineIdx = 0;

		// default for oxygen
		int chkA = chk.equals("oxygen") ? 1 : 0;
		int chkB = chk.equals("oxygen") ? 0 : 1;;
		
		// loop through the full list of bits 
		// declare the first idx position of the string
		// count the ones and zeros at the first position
		// make a two collections of bits
			// one collections has lines greater of the two(the 0 or 1) in the first position
				// if both are equal, use 1
			// the second collection has lines with the lesser amount of 0 or 1 in the first position
				// if both are equal, use one

		// move to the next idx position for a line
		// declare the two collections as what to search through

		// break when oxygen is a collection of one
		while (bits.size() != 1) {
			// reset the collection of counts
			int[] nums = new int[]{0,0};
			
			// iterate through the list
			while (bits.size() > idx) {
        String line = bits.get(idx);

        int val = Character.getNumericValue(line.charAt(lineIdx));

        // add array and increment val at 0 or 1 position for bit count
        nums[Character.getNumericValue(line.charAt(lineIdx))] += 1;
        
        idx++;
      }

      // reset idx for the next loop
      idx = 0;

      // temporary collection
      ArrayList<String> tempBits = new ArrayList<String>();

      while (bits.size() > idx) {
      	String line = bits.get(idx);

      	int firstChar = Character.getNumericValue(line.charAt(lineIdx));
      	
	      if ( (nums[1] > nums[0] || nums[1] == nums[0]) && firstChar == chkA ) { 
					tempBits.add(line);
				} else if ( nums[0] > nums[1] && firstChar == chkB) {
					tempBits.add(line);
				}

				idx++;
			}
			// increment the line idx to get the next char
			lineIdx++;

			//reset idx
			idx = 0;

			// reset bits to be the current collection
			bits = tempBits;
    }

    return(bits);
	}

}