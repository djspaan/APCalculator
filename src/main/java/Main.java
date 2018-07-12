import java.util.Scanner;

public class Main {
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

    public static void main(String[] argv) {
        new Main().start();
    }
}
