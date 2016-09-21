
public class ParenthesisToken implements Token {

	private String value;

	public ParenthesisToken(String parenthesis) {
		this.value = parenthesis;
	}
	
	public String getValue() {
		return this.value;
	}
	
	public int getType() {
		return PARENTHESIS_TYPE;
	}
	
	public int getPrecedence() {
		return -1;

	}

}
