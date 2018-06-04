import java.util.Scanner;

public class Main {
    /**
     * Starts the program.
     */
    private void start() {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            if (input.equals("exit")) {
                break;
            }
            if (input.equals("")) {
                continue;
            }

            Double result = calculator.evaluate(input);

            if (result != null) {
                System.out.println(result);
            }
        }
    }

    /**
     * Runs the APCalculator.
     *
     * @param argv list of strings
     */
    public static void main(String[] argv) {
        new Main().start();
    }
}
