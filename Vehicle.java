package assignment4;
/*
 * EZ Pass Project
 */
import java.util.Scanner;

public abstract class Vehicle {

	Scanner input = new Scanner(System.in);
	private String type;
	private int numPass;
	private int serialNum;
	
	public Vehicle(String type){
		setType(type);
		setNumPass(askNumPass());
		setSerialNum(askSerial());
	}

	/**
	 * Vehicle Type
	 * @param type
	 */
	private void setType(String type) {
		this.type = type;
	}

	/**
	 * 
	 * @return Type of Vehicle
	 */
	public String getType() {
		return type;
	}	
	
	/**
	 * Sets Number of Passengers
	 * @param numPass Number of Passengers
	 */
	private void setNumPass(int numPass){
		this.numPass = numPass;
	}
	
	/**
	 * 
	 * @return Number of Passengers
	 */
	public int getNumPass() {
		return numPass;
	}

	/**
	 * Set Serial Number
	 * @param serialNum Serial Number
	 */
	private void setSerialNum(int serialNum) {
		this.serialNum = serialNum;
	}

	/**
	 * 
	 * @return Serial Number
	 */
	public int getSerialNum() {
		return serialNum;
	}
	
	/**
	 * 
	 * @return Entered Number of Passengers
	 */
	public int askNumPass(){
		boolean test = false;
		int numPass = 0;
	
		while(!test){
			System.out.println("\nEnter Number of Passengers:");
			try{
				numPass = Integer.parseInt(input.next());
				test = true;
			}
			catch(Exception e){
				test = false;
				System.out.println("Please Enter A Number");
			}
			if(numPass<1){
				test = false;
				System.out.println("Please Enter More than 0");
			}
		}
		
		return numPass;
	}
	
	/**
	 * 
	 * @return Entered Serial Number
	 */
	public int askSerial(){
		boolean test = false;
		int serial = 0;
	
		while(!test){
			System.out.println("\nEnter 6 Digit Serial Number:");
			try{
				serial = Integer.parseInt(input.next());
				test = true;
			}
			catch(Exception e){
				test = false;
				System.out.println("Please Enter A Number");
			}
			if(! (Integer.toString(serial).length() == 6) ){
				test = false;
				System.out.println("Please Enter A 6 Digit Serial Number");
			}
		}
		
		return serial;
	}
	
	public String toString(){
		return getClass() + "\nVehicle Type: \t type \nNumber of Passengers: \t numPass \nSerial Number: \t serialNum";
	}
	
}
