public class DoubleStack implements DoubleStackInterface {
    private Stack<Double> stack = new Stack<>();

    public void push(Double element) {
        stack.push(element);
    }

    public Double pop() {
        return stack.pop();
    }

    public Double top() {
        return stack.top();
    }

    public int size() {
        return stack.size();
    }
}
