import java.util.Scanner;

class TokenFactory {
    private static final String OPERATOR_TOKENS = "+-*/^";

    Token createFromString(String token) throws IncorrectTokenInput {
        if (tokenIsDouble(token)) {
            return parseNumber(token);
        } else if (tokenIsOperator(token)) {
            return parseOperator(token);
        } else if (tokenIsParenthesis(token)) {
            return parseParenthesis(token);
        }

        throw new IncorrectTokenInput("Incorrect input token: " + token);
    }

    private NumberToken parseNumber(String token) {
        Scanner in = new Scanner(token);
        return readNumber(in);
    }

    private NumberToken readNumber(Scanner in) {
        double number = Double.parseDouble(in.next());
        return new NumberToken(number);
    }

    private OperatorToken parseOperator(String token) {
        Scanner in = new Scanner(token);
        return readOperator(in);
    }

    private OperatorToken readOperator(Scanner in) {
        String operator = in.next();
        return new OperatorToken(operator);
    }

    private ParenthesisToken parseParenthesis(String token) {
        Scanner in = new Scanner(token);
        return readParenthesis(in);
    }

    private ParenthesisToken readParenthesis(Scanner in) {
        String parenthesis = in.next();
        return new ParenthesisToken(parenthesis);
    }

    private boolean tokenIsDouble(String token) {
        try {
            Double.parseDouble(token);
        } catch (NumberFormatException nfe) {
            return false;
        }

        return true;
    }

    private boolean tokenIsOperator(String token) {
        for (char ch : OPERATOR_TOKENS.toCharArray()) {
            CharSequence chs = String.valueOf(ch);
            if (token.contains(chs)) {
                return true;
            }
        }

        return false;
    }

    private boolean tokenIsParenthesis(String token) {
        return token.contains("(") || token.contains(")");
    }
}
