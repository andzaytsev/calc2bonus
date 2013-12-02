package calc2bonus;

import java.util.Map;

public class Statement {
	public String type, first, second, third;
	Statement() {
		type = new String();
		first = new String();
		second = new String();
		third = new String();
	}
	Statement(String type, String first) {
		this.type = type;
		this.first = first;
		this.second = null;
		this.third = null;
	}
	Statement(String type, String first, String second) {
		this.type = type;
		this.first = first;
		this.second = second;
		this.third = null;
	}
	Statement(String type, String first, String second, String third) {
		this.type = type;
		this.first = first;
		this.second = second;
		this.third = third;
	}
	public boolean match(Map <String, Boolean> position) {
		if (type == "isp") {
			return position.get(first);
		} else if (type == "ist") {
			return !position.get(first);
		} else if (type == "eq") {
			return position.get(first) == position.get(second);
		} else if (type == "neq") {
			return position.get(first) != position.get(second);
		} else if (type == "at1") {
			int cnt = 0;
			if (position.get(first))
				cnt++;
			if (position.get(second))
				cnt++;
			if (position.get(third))
				cnt++;
			return cnt <= 1;
		} else { // Not possible
			return false;
		}
	}
}
