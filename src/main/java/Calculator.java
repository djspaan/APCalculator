import java.util.Objects;
import java.util.Scanner;

public class Calculator implements CalculatorInterface {
  /**
   * Evaluate an expression.
   *
   * @param input String
   * @return Double|null
   */
  Double evaluate(String input) {
    try {
      return rpn(shuntingYard(readTokens(input)));
    } catch (IncorrectTokenInput incorrectTokenInput) {
      System.out.println(incorrectTokenInput.getMessage());
    }
    return null;
  }

  /**
   * Reads tokens from an input string and returns a TokenList.
   *
   * @param input string containing tokens
   * @return TokenList containing the tokens from the input string
   */
  public TokenList readTokens(String input) throws IncorrectTokenInput {
    Scanner in = new Scanner(input);
    TokenList tokenList = new TokenList();
    TokenFactory tokenFactory = new TokenFactory();

    while (in.hasNext()) {
      Token token = tokenFactory.createFromString(in.next());
      tokenList.add(token);
    }

    return tokenList;
  }

  /**
   * Evaluates a postfix(rpn) expression.
   *
   * @param tokens TokenList containing a postfix expression
   * @return a double containing the outcome of the evaluated expression
   */
  public Double rpn(TokenList tokens) {
    DoubleStack stack = new DoubleStack();

    for (int i = 0; i < tokens.size(); i++) {
      Token token = tokens.get(i);

      if (token.getType() == Token.NUMBER_TYPE) {
        stack.push(Double.parseDouble(tokens.get(i).getValue()));
      } else if (token.getType() == Token.OPERATOR_TYPE) {
        if (stack.size() > 1) {
          stack = performOperation(tokens.get(i), stack);
        }
      }
    }

    return stack.top();
  }

  /**
   * Evaluates an expression of 2 doubles and an operator.
   *
   * @param operator a token of type operator
   * @param stack    a stack of doubles
   * @return DoubleStack with the evaluated expression
   */
  private DoubleStack performOperation(Token operator, DoubleStack stack) {
    double a = stack.pop();
    double b = stack.pop();

    switch (operator.getValue()) {
      case "+":
        stack.push(b + a);
        break;
      case "-":
        stack.push(b - a);
        break;
      case "*":
        stack.push(b * a);
        break;
      case "/":
        stack.push(b / a);
        break;
      case "^":
        stack.push(Math.pow(b, a));
        break;
    }

    return stack;
  }

  /**
   * Converts infix expressions into postfix expressions.
   *
   * @param tokens TokenList containing an infix expression
   * @return TokenList containing a postfix(rpn) expression
   */
  public TokenList shuntingYard(TokenList tokens) {
    TokenStack stack = new TokenStack();
    TokenList output = new TokenList();

    for (int i = 0; i < tokens.size(); i++) {
      Token token = tokens.get(i);

      if (token.getType() == Token.NUMBER_TYPE) {
        output.add(token);
      } else if (token.getType() == Token.OPERATOR_TYPE) {
        while (stack.hasTop() && stack.top().getType() == Token.OPERATOR_TYPE
          && stack.top().getPrecedence() >= token.getPrecedence()) {
          output.add(stack.pop());
        }
        stack.push(token);
      }
      if (Objects.equals(token.getValue(), "(")) {
        stack.push(token);
      }
      if (Objects.equals(token.getValue(), ")")) {
        while (stack.hasTop() && !Objects.equals(stack.top().getValue(), "(")) {
          output.add(stack.pop());
        }
        stack.pop();
      }
    }

    while (stack.size() > 0) {
      output.add(stack.pop());
    }

    return output;
  }
}
