import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) {
        try {
            ConcatImpl obj = new ConcatImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("ConcatService", obj);
            System.out.println("Server is ready...");
        } catch (Exception e) {
            System.out.println("Server Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
