package calc2bonus;

public class Statement {
	public String type, first, second;
	Statement() {
		type = new String();
		first = new String();
		second = new String();
	}
	Statement(String type, String first, String second) {
		this.type = type;
		this.first = first;
		this.second = second;
	}
}
