package ws10;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CarServer {
	private static int port = 8080;
	public CarServer() {
		try {
			CarInterface obj = new CarImpl();
			Registry registry = LocateRegistry.createRegistry(port);
			registry.rebind("CarServer", obj);
					
		}catch(Exception err) {
			err.getMessage();
		}
	}
	public static void main(String[] args) {
		new CarServer();
		System.out.println("Server is running on localhost: " + port);	
	}
}
