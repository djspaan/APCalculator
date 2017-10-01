import java.util.ArrayList;

public class DoubleStack implements DoubleStackInterface {

	private ArrayList<Double> double_array = new ArrayList<Double>();
	
	public void push(Double element) {
		double_array.add(element);
	}

	public Double pop() {
		try{
			Double number = double_array.get(0);
			double_array.remove(0);
			return number;
		}
		catch (Exception e) {
			System.out.println("DoubleStack cannot be empty when popped.");
			return null;
		}
	}

	public Double top() {
        return double_array.get(0);
	}

	public int size() {
		return double_array.size();
	}

}
