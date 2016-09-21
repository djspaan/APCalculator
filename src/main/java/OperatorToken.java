
public class OperatorToken implements Token{
	
	private String value;

	public OperatorToken(String operator) {
		this.value = operator;
	}
	
	public String getValue() {
		return this.value;
	}
	
	public int getType() {
		return OPERATOR_TYPE;
	}
	
	public int getPrecedence() {
		return -1;

	}

}
