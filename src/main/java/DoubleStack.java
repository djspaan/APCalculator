import java.util.ArrayList;

public class DoubleStack implements DoubleStackInterface {
	private ArrayList<Double> stack = new ArrayList<>();

	void evaluate() {
		System.out.print("stack:");
		for (Double d: stack) {
			System.out.print(d.toString() + "  ");
		}
		System.out.println(' ');
	}

    /**
     * Pushes an element to the DoubleStack.
     *
     * @param element to push
     */
    public void push(Double element) {
        stack.add(0, element);
	}

    /**
     * Gets and removes the first item of the DoubleStack.
     *
     * @return double when stack is not empty, null otherwise
     */
    public Double pop() {
		try{
			Double number = stack.get(0);
			stack.remove(0);
			return number;
		}
		catch (Exception e) {
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
        return stack.get(0);
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
