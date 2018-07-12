import java.util.Arrays;

class Stack<T> {
  private static final int DEFAULT_CAPACITY = 10;
  private T[] store;
  private int size = 0;
  private int capacity;

  @SuppressWarnings("unchecked")
  Stack() {
    this.capacity = DEFAULT_CAPACITY;
    store = (T[]) new Object[DEFAULT_CAPACITY];
  }

  void push(T element) {
    if (this.size >= store.length) {
      int newSize = size + (size >> 1);
      store = Arrays.copyOf(store, newSize);
    }

    store[size++] = element;
  }

  T pop() {
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

  T top() {
    return store[size - 1];
  }

  int size() {
    return size;
  }
}
