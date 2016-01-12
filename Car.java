package assignment4;
/*
 * EZ Pass Project
 */
public class Car extends Vehicle{

	public Car() {
		super("car");
	}

	public String toString(){
		return getClass() + "\nVehicle Type: \t type \nNumber of Passengers: \t numPass \nSerial Number: \t serialNum";
	}
	
}
