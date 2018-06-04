public class DoubleStack implements DoubleStackInterface {
    private Stack<Double> stack = new Stack<>();

    /**
     * Pushes an element to the DoubleStack.
     *
     * @param element to push
     */
    public void push(Double element) {
        stack.push(element);
    }

    /**
     * Gets and removes the first item of the DoubleStack.
     *
     * @return double when stack is not empty, null otherwise
     */
    public Double pop() {
        try {
            return stack.pop();
        } catch (Exception e) {
            System.out.println("DoubleStack cannot be empty when popped.");
            return null;
        }
    }

    /**
     * Gets the first item of the DoubleStack.
     *
     * @return double, the first item of the DoubleStack
     */
    public Double top() {
        return stack.top();
    }

    /**
     * Gets the number of elements in the DoubleStack.
     *
     * @return int containing the size
     */
    public int size() {
        return stack.size();
    }
}
