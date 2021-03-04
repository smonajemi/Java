package ws10;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Scanner;

public class CarClient {
	private static int port = 8080;
	private static String address = "rmi://localhost:" + port + "/CarServer";

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String reg;
		String model,color;
		double mileage;
		boolean flag = true;
		boolean exit = true;
		try {		
		CarInterface obj = (CarInterface) Naming.lookup(address);
		System.out.println("Connecting to client on localhost: " + port + "\n");
		
		ArrayList<Car>Carlist = new ArrayList<Car>();
		Carlist.add(new Car("VW", "White", 100));
		Carlist.add(new Car("Tesla", "Grey", 150));
		Carlist.add(new Car("Volvo", "Black", 550));
		Carlist.add(new Car("Ferrari", "Red", 1000));
		
		System.out.print("Would you like to register a new vehicle: y/n? Exit with '0': ");	
		while(flag) {	
		
		reg = input.nextLine();
		switch(reg.toUpperCase()) {
		case "Y":
			System.out.print("\nEnter the model: ");
				model = input.nextLine();
			System.out.print("\nEnter the color: ");
				color = input.nextLine();
			System.out.print("\nEnter the mileage: ");
				mileage = input.nextDouble();			
			Carlist.add(new Car(model,color,mileage));
			flag = false;
			break;
			
		case "N":
			reg = "";
			System.out.print("Would you like to see the registered vehicles: y/n?");		
			reg = input.nextLine();
			while(exit) {
				switch(reg.toUpperCase()) {
				case "Y":		
					System.out.println("OK");
					exit = false;
					flag = true;
					break;
				case "N":
					System.out.println("GoodBye");
					exit = false;
					flag = false;
					System.exit(0);
					break;
				}
			}
		default:
			System.out.print("Wrong entry, please enter y/n: ");	
		
		}
		}
		
		for(int i = 0; i < Carlist.size(); i++) {
			System.out.println(Carlist.get(i) + "\n");
			Carlist.get(i).setPlate(obj.register(Carlist.get(i)));
			System.out.println("Assigning plate number -->\n");
			System.out.println(Carlist.get(i) + "\n-----------------------------");
		}	
		System.out.println("\nFollowing models have been successfully registered:\n---------");
		for(Car c: Carlist) {
			System.out.println(c.getModel() + " is registered with plate#" + c.getPlate() + '\n');
		}		
		
		}catch (MalformedURLException e) {
			System.out.println("MalformedURLException");
			e.getMessage();
		} catch (RemoteException e) {
			System.out.println("RemoteException - Please connect to the server first!");
			e.getMessage();
		} catch (NotBoundException e) {
			System.out.println("NotBoundException");
			e.getMessage();
		} catch (ArithmeticException e) {
			System.out.println("ArithmeticException");
			e.getMessage();
		}
	}
		

}
