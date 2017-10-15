
public class ParenthesisToken implements Token {
	private String value;

	/**
	 * Constructor for the ParenthesisToken.
	 *
	 * @param parenthesis to add
	 */
	ParenthesisToken(String parenthesis) {
		this.value = parenthesis;
	}

    /**
     * Gets the value of the ParenthesisToken.
     *
     * @return string containing the value
     */
	public String getValue() {
		return this.value;
	}

    /**
     * Gets the type of the ParenthesisToken.
     *
     * @return string containing the type
     */
	public int getType() {
		return 3;
	}

    /**
     * Gets the value of the precedence.
     *
     * @return string containing the precedence value
     */
	public int getPrecedence() {
		return -1;
	}

}
