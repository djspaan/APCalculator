
public class NumberToken implements Token {

	private double value;

	public NumberToken(double number) {
		this.value = number;
	}
	
	public String getValue() {
		return String.valueOf(this.value);
	}
	
	public int getType() {
		return NUMBER_TYPE;
	}
	
	public int getPrecedence() {
		return -1;
	}

}
