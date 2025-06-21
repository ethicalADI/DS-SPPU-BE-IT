import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            Concat stub = (Concat) registry.lookup("ConcatService");

            for (int i = 0; i < 3; i++) {
                Thread t = new Thread(() -> {
                    try (Scanner sc = new Scanner(System.in)) {
                        System.out.print("Enter first string: ");
                        String str1 = sc.nextLine();
                        System.out.print("Enter second string: ");
                        String str2 = sc.nextLine();
                        String result = stub.concatenate(str1, str2);
                        System.out.println("Concatenated: " + result);
                    } catch (Exception e) {
                        System.out.println("Client thread error: " + e.getMessage());
                    }
                });
                t.start();
                t.join(); // wait for each thread to finish (for demo simplicity)
            }

        } catch (Exception e) {
            System.out.println("Client Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
