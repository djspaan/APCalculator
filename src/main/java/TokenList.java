import java.util.ArrayList;


public class TokenList implements TokenListInterface {

	private ArrayList<Token> tokens = new ArrayList<Token>();
	
	public void add(Token token) {
		tokens.add(token);
	}
	
	public void remove(int index) {
		tokens.remove(index);
	}
	
	public void set(int index, Token token) {
		tokens.add(index, token);
	}
	
	public Token get(int index) {
		return tokens.get(index);
	}
	
	public int size() {
		return tokens.size();
	}
	
}
