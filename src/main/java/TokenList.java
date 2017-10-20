public class TokenList implements TokenListInterface {
	private Collection<Token> collection = new Collection<>();

	/**
	 * Adds an element to the TokenList.
	 *
	 * @param token to add
	 */
	public void add(Token token) {
		collection.add(token);
	}

    /**
     * Removes an item at the given index of the TokenList.
     *
     * @param index containing the index of the item to be removed
     */
	public void remove(int index) {
		collection.remove(index);
	}

    /**
     * Adds an item at the given index to the TokenList.
     *
     * @param index of the item to add
     * @param token that needs to be added
     */
	public void set(int index, Token token) {
		collection.set(index, token);
	}

    /**
     * Gets an item at the given index of the TokenList.
     *
     * @param index of the item to get
     */
	public Token get(int index) {
		return (Token) collection.get(index);
	}

    /**
     * Gets the number of elements in the TokenList.
     *
     * @return int containing the size
     */
	public int size() {
		return collection.size();
	}


}
