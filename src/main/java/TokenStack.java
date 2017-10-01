import java.util.ArrayList;


public class TokenStack implements TokenStackInterface {

	private ArrayList<Token> token_stack = new ArrayList<Token>();

	public void push(Token token) {
		token_stack.add(0, token);
	}

	public Token pop() {
		try{
			Token token = token_stack.get(0);
			token_stack.remove(0);
			return token;
		}
		catch (Exception e) {
			System.out.println("TokenStack cannot be empty when popped.");
			return null;
		}
	}

	public Token top() {
		return token_stack.get(0);
	}
	
	public boolean hasTop() {
		if (this.size() > 1) {
			return true;
		}
		return false;
	}

	public int size() {
		return token_stack.size();
	}

}
