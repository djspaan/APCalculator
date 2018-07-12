public class TokenList implements TokenListInterface {
    private Collection<Token> collection = new Collection<>();

    public void add(Token token) {
        collection.add(token);
    }

    public void remove(int index) {
        collection.remove(index);
    }

    public void set(int index, Token token) {
        collection.set(index, token);
    }

    public Token get(int index) {
        return collection.get(index);
    }

    public int size() {
        return collection.size();
    }
}
