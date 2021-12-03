import movement.GetDirections;
// import the directions from the package

import java.util.ArrayList; 

public class SubMarineTwo {

	public static void main (String[] args) {
		GetDirections d = new GetDirections();

		ArrayList<String> directions = d.listOfDirections();

		int horizontal = 0;
		int depth = 0;
		int aim = 0;
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

			// forward X does two things:
				// It increases your horizontal position by X units.
				// It increases your depth by your aim multiplied by X.
			if(mv.equals("forward")){
				horizontal += amt;
				depth += (aim * amt);
			}

			// up X decreases your aim by X units.
			if(mv.equals("up")){
				aim -= amt;
			}

			// down X increases your aim by X units.
			if(mv.equals("down")){
				aim += amt;
			}

			idx++;
		}
		System.out.println(horizontal*depth);
	}

}