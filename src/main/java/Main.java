import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;	

public class Main implements CalculatorInterface {
	
	static final String OPERATOR_TOKENS = "+-*/^";
	
	boolean nextTokenIsDouble(String token) {
		Scanner in = new Scanner(token);
		return in.hasNextDouble();
	}

    public TokenList readTokens(String input) {
    	
    	Scanner in = new Scanner(input);
    	TokenList result = new TokenList();	
    	
    	while(in.hasNext()){
    		String token = in.next();
        	
        	if (tokenIsDouble(token)) {
        		result.add(parseNumber(token));
        	}
        	else if (tokenIsOperator(token)) {
    			result.add(parseOperator(token));
    		} 
    		else if (tokenIsParenthesis(token)) {
    			result.add(parseParenthesis(token));
    		} 
    		else {
    			System.out.println("Incorrect input token.");
    		}
    	}
    	return result;
    }
    
	private NumberToken parseNumber(String token) {
		Scanner in = new Scanner(token);
		return readNumber(in);
	}

	private NumberToken readNumber(Scanner in) {
    	double number = Double.parseDouble(in.next());
    	NumberToken number_token = new NumberToken(number);
    	return number_token;
    }
	
	private OperatorToken parseOperator(String token) {
		Scanner in = new Scanner(token);
		return readOperator(in);
	}
	
	private OperatorToken readOperator(Scanner in) {
    	String operator = in.next();
    	OperatorToken operator_token = new OperatorToken(operator);
    	return operator_token;
    }
	
	private ParenthesisToken parseParenthesis(String token) {
		Scanner in = new Scanner(token);
		return readParenthesis(in);
	}
	
	private ParenthesisToken readParenthesis(Scanner in) {
    	String parenthesis = in.next();
    	ParenthesisToken parenthesis_token = new ParenthesisToken(parenthesis);
    	return parenthesis_token;
    }
	
	private boolean tokenIsDouble(String token) {
    	  try  
    	  {  
    	    double d = Double.parseDouble(token);  
    	  }  
    	  catch(NumberFormatException nfe)  
    	  {  
    	    return false;  
    	  }  
    	  return true;  
	}

	private boolean tokenIsOperator(String token) {
		for (char ch: OPERATOR_TOKENS.toCharArray()) {
			CharSequence chs = String.valueOf(token);
			if (token.contains(chs)) {
		  		return true;
		  	}
		}
	  	return false;
	  	 
	}
	
	private boolean tokenIsParenthesis(String token) {
		if (token.contains("(")) {
	  		return true;
	  	}
		else if (token.contains(")")) {
			return true;
		}
	  	return false; 
	}
	
    public Double rpn(TokenList tokens) {
    	int i = 0;
    	DoubleStack double_stack = new DoubleStack();
    	TokenStack token_stack = new TokenStack();
        while (i < tokens.size()) {
        	Token token = tokens.get(i);
        	
        	if (token.getType() == 1) {
        		token_stack.push(token);
        		double_stack.push(Double.parseDouble(tokens.get(i).getValue()));
        	}
        	else if (token.getType() == 2) {
        		System.out.println("stack size = " + double_stack.size());
        		System.out.println("operator = " + token.getValue());
        		if (double_stack.size() > 1) {
        			double_stack = performOperation(tokens.get(i), double_stack);
        			token_stack.pop();
        			token_stack.pop();
        		}
        		else {
        			token_stack.push(token);
        		}
        	}
        	i++;
        }
        System.out.println("token stack size = " + double_stack.size());
        System.out.println("value = " + double_stack.top());
        return null;
    }
    
    private DoubleStack performOperation(Token operator, DoubleStack stack) {
    	double a = stack.pop();
		double b = stack.pop();
    	switch (operator.getValue()) {
			case "+": stack.push(a + b); break;
			case "-": stack.push(a - b); break;
			case "*": stack.push(a * b); break;
			case "/": stack.push(a / b); break;
			case "^": stack.push(Math.pow(a, b)); break;
    	}

    	return stack;
	}

    public TokenList shuntingYard(TokenList tokens) {
        // TODO: Implement this
        return null;
    }

    private void start() {
    	Scanner scanner = new Scanner(System.in);
    	
    	while(scanner.hasNextLine()) {
    	    String input = scanner.nextLine();
    	    if(input.equals("exit")) {
    	        break;
    	    }
    	    rpn(readTokens(input));
    	}
    	
    }

    public static void main(String[] argv) {
        new Main().start();
    }
}
