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
    	
    	//System.out.println(input);
    	
    	// Loop...
    	
    	String token = in.next();
    	if (tokenIsDouble(token)) {
    		
    		result.add(parseNumber(token));
    	} 
//    	else if (tokenIsOperator(token)) {
//    		result.add(parseOperator(token));
//    	} 
//    	else if () {
//    		
//    	} 
//    	else {
//    		// Error
//    	}
    	
    	System.out.println(result.size());
    	return null;
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

	
	
	
	
	
	
	
    public Double rpn(TokenList tokens) {
        // TODO: Implement this
        return null;
    }

    public TokenList shuntingYard(TokenList tokens) {
        // TODO: Implement this
        return null;
    }

    private void start() {
        // Create a scanner on System.in
    	Scanner scanner = new Scanner(System.in);
        
        // While there is input, read line and parse it.
    	
    	while(scanner.hasNext()) {
    	    String input = scanner.next();
    	    if(input.equals("exit")) {
    	        break;
    	    }
    	    readTokens(input);
    	}
    	
    }

    public static void main(String[] argv) {
        new Main().start();
    }
}
