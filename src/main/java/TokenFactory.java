import java.util.Scanner;

public class TokenFactory {
    private static final String OPERATOR_TOKENS = "+-*/^";

    /**
     * Create a token from a string
     *
     * @param token string containing the token
     * @return Token object
     */
    public Token createFromString(String token) throws IncorrectTokenInput {
        if (tokenIsDouble(token)) {
            return parseNumber(token);
        } else if (tokenIsOperator(token)) {
            return parseOperator(token);
        } else if (tokenIsParenthesis(token)) {
            return parseParenthesis(token);
        }

        throw new IncorrectTokenInput("Incorrect input Token");
    }

    /**
     * Parses a NumberToken from a string.
     *
     * @param token string containing a NumberToken
     * @return NumberToken object with the value of the input string
     */
    private NumberToken parseNumber(String token) {
        Scanner in = new Scanner(token);
        return readNumber(in);
    }

    /**
     * Returns a new NumberToken from a Scanner object.
     *
     * @param in Scanner object containing the token
     * @return NumberToken containing the token as value
     */
    private NumberToken readNumber(Scanner in) {
        double number = Double.parseDouble(in.next());
        return new NumberToken(number);
    }

    /**
     * Parses an OperatorToken from a string.
     *
     * @param token string containing an OperatorToken
     * @return OperatorToken object with the value of the input string
     */
    private OperatorToken parseOperator(String token) {
        Scanner in = new Scanner(token);
        return readOperator(in);
    }

    /**
     * Returns a new OperatorToken from a Scanner object.
     *
     * @param in Scanner object containing the token
     * @return OperatorToken containing the token as value
     */
    private OperatorToken readOperator(Scanner in) {
        String operator = in.next();
        return new OperatorToken(operator);
    }

    /**
     * Parses a ParenthesisToken from a string.
     *
     * @param token string containing a ParenthesisToken
     * @return ParenthesisToken object with the value of the input string
     */
    private ParenthesisToken parseParenthesis(String token) {
        Scanner in = new Scanner(token);
        return readParenthesis(in);
    }

    /**
     * Returns a new ParenthesisToken from a Scanner object.
     *
     * @param in Scanner object containing the token
     * @return ParenthesisToken containing the token as value
     */
    private ParenthesisToken readParenthesis(Scanner in) {
        String parenthesis = in.next();
        return new ParenthesisToken(parenthesis);
    }

    /**
     * Asserts if a token is a double.
     *
     * @param token string containing a token
     * @return boolean whether a string containing a token is a double
     */
    private boolean tokenIsDouble(String token) {
        try {
            Double.parseDouble(token);
        } catch (NumberFormatException nfe) {
            return false;
        }

        return true;
    }

    /**
     * Asserts if a token is an operator.
     *
     * @param token string containing an operator
     * @return boolean whether a string containing a token is an operator
     */
    private boolean tokenIsOperator(String token) {
        for (char ch : OPERATOR_TOKENS.toCharArray()) {
            CharSequence chs = String.valueOf(ch);
            if (token.contains(chs)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Asserts if a token is a parenthesis.
     *
     * @param token string containing a parenthesis
     * @return boolean whether a string containing a token is a parenthesis
     */
    private boolean tokenIsParenthesis(String token) {
        return token.contains("(") || token.contains(")");
    }
}
