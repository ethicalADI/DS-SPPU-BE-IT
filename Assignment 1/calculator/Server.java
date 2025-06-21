import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            CalculatorImpl calc = new CalculatorImpl();
            Naming.rebind("rmi://localhost:1099/CalcService", calc);
            System.out.println("Calculator Server is ready.");
        } catch (Exception e) {
            System.out.println("Server Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
