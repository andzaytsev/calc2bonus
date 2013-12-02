package calc2bonus;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {
	public static void main(String[] args) {
		// List of peoples names
		List <String> people = new LinkedList <String>();
		// Map person's name -> statement
		Map <String, Statement> st = new HashMap <String, Statement>();
		// True statement that is given
		Statement trueS;
		
		// Initialize all the peoples' names and statements
		people.add("Argen");
		st.put("Argen", new Statement("isp", "Ben"));
		people.add("Ben");
		st.put("Ben", new Statement("ist", "Jared"));
		people.add("Jared");
		st.put("Jared", new Statement("isp", "Argen"));
		people.add("Erin");
		st.put("Erin", new Statement("isp", "Ben"));
		people.add("Jan");
		st.put("Jan", new Statement("eq", "Erin", "Laolu"));
		people.add("Laolu");
		st.put("Laolu", new Statement("neq", "Lee", "Laolu"));
		people.add("Lee");
		st.put("Lee", new Statement("neq", "Jan", "Erin"));
		people.add("Sean");
		st.put("Sean", new Statement("at1", "Lee", "Matt", "Jared"));
		people.add("Li Gao");
		st.put("Li Gao", new Statement("neq", "Li Gao", "Sean"));
		people.add("Matt");
		st.put("Matt", new Statement("neq", "Lee", "Sepideh"));
		people.add("Sepideh");
		st.put("Sepideh", new Statement("neq", "Euijin", "Sepideh"));
		people.add("Euijin");
		st.put("Euijin", new Statement("neq", "Lee", "Matt"));
		people.add("Glenn");
		st.put("Glenn", new Statement("eq", "Laolu", "Lechao"));
		people.add("Lechao");
		st.put("Lechao", new Statement("isp", "Lee"));
		people.add("Jon");
		st.put("Jon", new Statement("neq", "Lee", "Lechao"));
		
		trueS = new Statement("neq", "Ligao", "Lee");
		
		// Generate all possibilities
		// Check each one of them
		String combination;
		// Position = if a person is a Professor
		Map <String, Boolean> position;
		boolean isAns = false;
		for (int i = 0; i < (1<<15); ++i) {
			isAns = true;
			combination = Integer.toBinaryString(i);
			position = getPosition(combination, people);
			
			if (!trueS.match(position)) {
				isAns = false;
				continue;
			}
			for (String person : people) {
				if (!position.get(person)) { //TA
					if (!st.get(person).match(position)) {
						isAns = false;
						break;
					}
				} else { //Prof
					if (st.get(person).match(position)) {
						isAns = false;
						break;
					}
				}
			}
			if (isAns) {
				System.out.println("Answer:");
				printAns(position, people);
				return;
			}
		}
		
	}

	private static void printAns(Map<String, Boolean> position, List<String> people) {
		for (String person : people) {
			System.out.print(person);
			System.out.print(" : ");
			if (position.get(person))
				System.out.println("Prof");
			else
				System.out.println("TA");
		}
	}

	public static Map<String, Boolean> getPosition(String combination,
			List<String> people) {
		// Positions in string and in list
		int cPos = combination.length() - 1;
		Map <String, Boolean> position = new HashMap <String, Boolean>();
		for (String pPos : people) {
			if (cPos >= 0) {
				if (combination.charAt(cPos) == '0')
					position.put(pPos, false);
				else
					position.put(pPos, true);
				cPos--;
			} else {
				position.put(pPos, false);
			}
		}
		return position;
	}
}
