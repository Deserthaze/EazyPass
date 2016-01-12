package assignment4;
/*

 * EZ Pass Project
 */
public class Truck extends Vehicle{

	public Truck() {
		super("truck");
	}

	public String toString(){
		return getClass() + "\nVehicle Type: \t type \nNumber of Passengers: \t numPass \nSerial Number: \t serialNum";
	}
	
}
