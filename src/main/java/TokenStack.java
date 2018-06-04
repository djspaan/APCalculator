public class TokenStack implements TokenStackInterface {
    private Stack<Token> stack = new Stack<>();

    /**
     * Adds an element to the TokenStack.
     *
     * @param token to add
     */
    public void push(Token token) {
        stack.push(token);
    }

    /**
     * Gets and removes the first item of the TokenStack.
     *
     * @return Token when stack is not empty, null otherwise
     */
    public Token pop() {
        try {
            return stack.pop();
        } catch (Exception e) {
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
        return stack.top();
    }


    /**
     * Checks if the TokenStack is not empty.
     *
     * @return boolean whether empty
     */
    boolean hasTop() {
        return this.size() > 0;
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
