import java.util.Arrays;

class Stack<T> {
  private static final int DEFAULT_CAPACITY = 10;
  private T[] store;
  private int size = 0;
  private int capacity;

  /**
   * Stack constructor.
   */
  @SuppressWarnings("unchecked")
  Stack() {
    this.capacity = DEFAULT_CAPACITY;
    store = (T[]) new Object[DEFAULT_CAPACITY];
  }

  /**
   * Push an element to the stack.
   *
   * @param element T
   */
  public void push(T element) {
    if (this.size >= store.length) {
      int newSize = size + (size >> 1);
      store = Arrays.copyOf(store, newSize);
    }

    store[size++] = element;
  }

  /**
   * Pop the first item from the stack.
   *
   * @return element T
   */
  public T pop() {
    if (size <= 0) {
      return null;
    }

    T value = store[--size];

    store[size] = null;

    int reducedSize = size;
    if (size >= capacity && size < (reducedSize + (reducedSize << 1))) {
      System.arraycopy(store, 0, store, 0, size);
    }
    return value;
  }

  /**
   * Return the first element from the stack.
   *
   * @return element T
   */
  public T top() {
    return store[size - 1];
  }

  /**
   * Return the size of the stack.
   *
   * @return element T
   */
  public int size() {
    return size;
  }
}
