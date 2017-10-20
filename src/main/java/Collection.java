import java.util.Arrays;

class Collection<E> {
    private static final int INITIAL_CAPACITY = 10;
    private int size = 0;
    private Object elements[] = {};

    /**
     * Constructor of the collection.
     */
    public Collection() {
        elements = new Object[INITIAL_CAPACITY];
    }

    /**
     * Add an element to the collection.
     *
     * @param token Token to add
     */
    public void add(Token token) {
        if (size == elements.length) {
            increaseSize();
        }
        elements[size++] = token;
    }

    /**
     * Set an element at the given index.
     *
     * @param index to set the element at
     * @param token Token to set
     */
    public void set(int index, Token token) {
        if (index < 0 || index >= size + 1) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
        }

        for (int i = index + 1; i <= size; i++) {
            elements[i+1] = elements[i];
        }

        elements[index] = token;

        size++;
    }

    /**
     * Get the size of the array.
     *
     * @return size int number of items
     */
    public int size() {
        return size;
    }

    /**
     * Return the top element of the collection.
     *
     * @return Token to return
     */
    public Token top() {
        return (Token) elements[0];
    }

    /**
     * Remove the first item of the collection and return it.
     *
     * @return Token popped
     */
    public Token pop() {
        Token token = (Token) elements[0];
        remove(0);
        return token;
    }

    /**
     * Set an element to the first index of the collection.
     *
     * @param token Token to push
     */
    public void push(Token token) {
        set(0, token);
    }

    /**
     * Method returns element on specific index.
     *
     * @param index int of the element to return
     */
    public Token get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
        }
        return (Token) elements[index]; // return value on index.
    }

    /**
     * Remove an element at the given index.
     *
     * @param index int of the element to remove
     */
    public Token remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size "
                    + index);
        }

        Token token = (Token) elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        size--;

        return token;
    }

    /**
     * Increase the size of the collection.
     */
    private void increaseSize() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }
}