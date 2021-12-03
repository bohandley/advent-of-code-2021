import movement.GetDirections;

import java.util.ArrayList; 

public class SubMarineOne {

	public static void main (String[] args) {
		GetDirections d = new GetDirections();

		ArrayList<String> directions = d.listOfDirections();

		int horizontal = 0;
		int depth = 0;
		int mult = 0;

		int idx = 0;

		while (directions.size() > idx) {
			// get the next direction
			String dir = directions.get(idx);

			// trim the string for extra white space, split on space
			String[] splitStr = dir.trim().split("\\s+");
			
			// get the direction
			String mv = splitStr[0];

			// get the amount moved, parse into int
			int amt = Integer.parseInt(splitStr[1]);

			// string == string checks for reference
			// string.equals(string) checks for content
			if(mv.equals("forward"))
				horizontal += amt;

			if(mv.equals("up"))
				depth -= amt;

			if(mv.equals("down"))
				depth += amt;

			idx++;
		}
		System.out.println(horizontal*depth);
	}

}