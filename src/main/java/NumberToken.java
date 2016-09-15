
public class NumberToken implements Token {

	private double value;

	public NumberToken(double getal) {
		// TODO Auto-generated constructor stub
		double value = getal;
	}

	/**
	 * @param args
	 */
	void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	public String getValue() {
		// TODO Auto-generated method stub
		return String.valueOf(value);
	}
	
	public int getType() {
		// TODO Auto-generated method stub
		return NUMBER_TYPE;
	}
	
	public int getPrecedence() {
		// TODO Auto-generated method stub
		return -1;

	}

}
