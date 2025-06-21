import java.rmi.Naming;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Calculator calc = (Calculator) Naming.lookup("rmi://localhost:1099/CalcService");
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter first number: ");
            int a = sc.nextInt();

            System.out.print("Enter second number: ");
            int b = sc.nextInt();

            System.out.println("\nSelect Operation:");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");

            System.out.print("Enter choice (1-4): ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Result: " + calc.add(a, b));
                    break;
                case 2:
                    System.out.println("Result: " + calc.subtract(a, b));
                    break;
                case 3:
                    System.out.println("Result: " + calc.multiply(a, b));
                    break;
                case 4:
                    System.out.println("Result: " + calc.divide(a, b));
                    break;
                default:
                    System.out.println("Invalid Choice.");
            }

            sc.close();
        } catch (Exception e) {
            System.out.println("Client Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
