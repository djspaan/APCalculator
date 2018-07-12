public class TokenStack implements TokenStackInterface {
    private Stack<Token> stack = new Stack<>();

    public void push(Token token) {
        stack.push(token);
    }

    public Token pop() {
        return stack.pop();
    }

    public Token top() {
        return stack.top();
    }

    boolean hasTop() {
        return this.size() > 0;
    }

    public int size() {
        return stack.size();
    }
}
