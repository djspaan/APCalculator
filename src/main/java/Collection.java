import java.util.Arrays;

class Collection<T> {
    private static final int INITIAL_CAPACITY = 10;
    private int size = 0;
    private Object elements[] = {};

    /**
     * Constructor of the collection.
     */
    Collection() {
        elements = new Object[INITIAL_CAPACITY];
    }

    /**
     * Add an element to the collection.
     *
     * @param element T to add
     */
    public void add(T element) {
        if (size == elements.length) {
            increaseSize();
        }
        elements[size++] = element;
    }

    /**
     * Set an element at the given index.
     *
     * @param index   to set the element at
     * @param element T to set
     */
    public void set(int index, T element) {
        if (index < 0 || index >= size + 1) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
        }

        System.arraycopy(elements, index + 1, elements, index + 1 + 1, size + 1 - (index + 1));

        elements[index] = element;

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
     * Method returns element on specific index.
     *
     * @param index int of the element to return
     */
    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
        }
        return (T) elements[index]; // return value on index.
    }

    /**
     * Remove an element at the given index.
     *
     * @param index int of the element to remove
     */
    @SuppressWarnings("unchecked")
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size "
                    + index);
        }

        T element = (T) elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - 1 - index);
        size--;

        return element;
    }

    /**
     * Increase the size of the collection.
     */
    private void increaseSize() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }
}