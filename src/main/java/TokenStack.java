import java.util.ArrayList;


public class TokenStack implements TokenStackInterface {
	private ArrayList<Token> stack = new ArrayList<>();

	/**
	 * Adds an element to the TokenStack.
	 *
	 * @param token to add
	 */
	public void push(Token token) {
		stack.add(0, token);
	}

    /**
     * Gets and removes the first item of the TokenStack.
     *
     * @return Token when stack is not empty, null otherwise
     */
	public Token pop() {
		try{
			Token token = stack.get(0);
			stack.remove(0);
			return token;
		}
		catch (Exception e) {
			System.out.println("TokenStack cannot be empty when popped.");
			return null;
		}
	}

    /**
     * Gets the first item of the TokenStack.
     *
     * @return double, the first item of the TokenStack
     */
	public Token top() {
		return stack.get(0);
	}


    /**
     * Checks if the TokenStack is not empty.
     *
     * @return boolean whether empty
     */
    boolean hasTop() {
		return this.size() > 1;
	}

    /**
     * Gets the number of elements in the TokenStack.
     *
     * @return int containing the size
     */
	public int size() {
		return stack.size();
	}

}
