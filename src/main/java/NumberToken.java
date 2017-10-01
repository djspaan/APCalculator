
public class NumberToken implements Token {
	private double value;

    /**
     * Constructor for the NumberToken.
     *
     * @param number to add
     */
    NumberToken(double number) {
		this.value = number;
	}

    /**
     * Gets the value of the NumberToken.
     *
     * @return string containing the value
     */
    public String getValue() {
	    return String.valueOf(this.value);
	}

    /**
     * Gets the type of the NumberToken.
     *
     * @return string containing the type
     */
    public int getType() {
	    return NUMBER_TYPE;
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
