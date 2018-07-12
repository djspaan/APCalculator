import java.util.Arrays;

class Collection<T> {
    private static final int INITIAL_CAPACITY = 10;
    private int size = 0;
    private Object elements[] = {};

    Collection() {
        elements = new Object[INITIAL_CAPACITY];
    }

    void add(T element) {
        if (size == elements.length) {
            increaseSize();
        }
        elements[size++] = element;
    }

    void set(int index, T element) {
        if (index < 0 || index >= size + 1) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
        }

        System.arraycopy(elements, index + 1, elements, index + 1 + 1, size + 1 - (index + 1));

        elements[index] = element;

        size++;
    }

    int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
        }
        return (T) elements[index]; // return value on index.
    }

    @SuppressWarnings("unchecked")
    T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size "
                    + index);
        }

        T element = (T) elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - 1 - index);
        size--;

        return element;
    }

    private void increaseSize() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }
}
