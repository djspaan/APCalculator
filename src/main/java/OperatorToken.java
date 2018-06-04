
public class OperatorToken implements Token {
    private String value;

    /**
     * Constructor for the OperatorToken.
     *
     * @param operator to add
     */
    OperatorToken(String operator) {
        this.value = operator;
    }

    /**
     * Gets the value of the OperatorToken.
     *
     * @return string containing the value
     */
    public String getValue() {
        return this.value;
    }

    /**
     * Gets the type of the OperatorToken.
     *
     * @return string containing the type
     */
    public int getType() {
        return OPERATOR_TYPE;
    }

    /**
     * Gets the value of the precedence.
     *
     * @return string containing the precedence value
     */
    public int getPrecedence() {
        switch (value) {
            case "-":
                return 1;
            case "+":
                return 1;
            case "*":
                return 2;
            case "/":
                return 2;
            case "^":
                return 3;
        }
        return -1;
    }
}
