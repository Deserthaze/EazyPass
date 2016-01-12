package assignment4;
/*
 * EZ Pass Project
 */
import java.util.ArrayList;
import java.util.Scanner;

public class EZPassAccount {

	static Scanner input = new Scanner(System.in);
	private String name;
	private CreditCard creditCard;
	private double balance;
	private ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
	
	/**
	 * Sets the name, credit card, and balance
	 * @param cardNumber Credit Card
	 */
	public EZPassAccount(CreditCard cardNumber){
		this.name = askName();
		this.creditCard = cardNumber;
		setBalance(askBalance());
	}
	
	/**
	 * 
	 * @return Name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * @return creditcard
	 */
	public CreditCard getCreditCard() {
		return creditCard;
	}
	
	/**
	 * Sets Balance
	 * @param balance
	 */
	public void setBalance(double balance){
		this.balance = balance;
	}
	
	/**
	 * 
	 * @return Balance
	 */
	public double getBalance() {
		return balance;
	}
	
	/**
	 * Tests if Balance can subtract Toll
	 * @param amount Toll Amount
	 * @return true if can, false if can't
	 */
	public boolean canSubBalance(double amount){
		if( (getBalance()-amount) < 0){
			System.out.println("Insufficient Funds");
			return false;
		}
		else{
			return true;
		}
	}
	
	/**
	 * Subtracts Balance
	 * @param amount Toll Amount
	 */
	public void subBalance(double amount){
		setBalance(getBalance()-amount);
	}
	
	/**
	 * Adds to Balance
	 */
	public void addBalance(){
		setBalance(getBalance()-askBalance());
	}

	/**
	 * Add vehicle to account
	 * @param moving
	 */
	public void setVehicle(Vehicle moving) {
		vehicles.add(moving);
	}

	/**
	 * Get Vehicle
	 * @param serial vehicle's serial number
	 * @return Vehicle
	 */
	public Vehicle getVehicle(int serial) {
		Vehicle vehicle = null;
	
		for(Vehicle x : vehicles)
			if(x.getSerialNum() == serial)
					 vehicle = x;
		
		return vehicle;
	}
	
	/**
	 * Find Vehicle
	 * @return Vehicle's serial number
	 */
	public int getVehicleSerial(){
		int picked = 0;
		boolean test = false;
		
		System.out.println("\nRegistered Vehicles: ");
		for(int x = 0; x < vehicles.size(); x++){
			System.out.println((x+1) + ". "+vehicles.get(x).getType());
		}
		System.out.println("Select Vehicle: Choose Number:");
		
		while(!test){
			try{
				picked = Integer.parseInt(input.next());
				test = true;
			}
			catch(Exception e){
				System.out.println("Please Enter A Number");
				test = false;
			}
			if(picked < 1 || picked > vehicles.size()){
				test = false;
				System.out.println("Please Enter An Appropriate Choice");
			}
		}
		
		return vehicles.get(picked-1).getSerialNum();
	}
	
	/**
	 * 
	 * @return Entered Name
	 */
	public static String askName(){
		System.out.println("\nEnter Name:");
		return input.next();
	}
	
	/**
	 * 
	 * @return Entered Amount
	 */
	public double askBalance(){
		double hold = 0;
		boolean test = false;
		
		while(!test){
			System.out.print("\nAdd Amount to Account:\n$");
			try{
				hold = Double.parseDouble(input.next());
				test = true;
			}
			catch(Exception e){
				System.out.println("Not a Number");
				test = false;
			}
			if(hold < 0){
				System.out.println("Remember to add more than $0");
				test = false;
			}
		}
		
		return hold;
	}
	
	public String toString(){
		return getClass() + "\nAccount Name:\tname \nCredit Card:\tcreditCard \nAccount Balance:\tbalance \nAccount Vehicles:\tvehicles";
	}
	
}