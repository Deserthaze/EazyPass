package assignment4;
/*

 * EZ Pass Project
 */
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {

	private DecimalFormat dec = new DecimalFormat("#0.00");
	Scanner input = new Scanner(System.in);
	ArrayList<EZPassAccount> accounts;
	Expressway eBooth;
	BridgeAndTunnel bBooth;
	BridgeAndTunnel tBooth;

	/**
	 * Create a Driver to test program
	 */
	public Driver(){
		accounts = new ArrayList<EZPassAccount>();
		eBooth = new Expressway(true);
		bBooth = new BridgeAndTunnel(false);
		tBooth = new BridgeAndTunnel(false);
	}
	
	/**
	 * Calls Main Menu and passes Selection
	 */
	public void selectMenu(){
		int option=0;
		
		while(option!=5) 
		{
			mainMenu(); 

			try{
			option=Integer.parseInt(input.next());
			}
			catch(Exception e){
				option=0;
			}
			
			selection(option);
		}
	}
	
	/**
	 * Main Menu
	 */
	public void mainMenu(){
		System.out.println("Main Menu");
		System.out.println("1. Add New Account");
		System.out.println("2. Edit Account");
		System.out.println("3. Select Account");
		System.out.println("4. Print Accounts");
		System.out.println("5. Quit");
	}
	
	/**
	 * Selection from MainMenu
	 * @param option Selection
	 */
	public void selection(int option){
		switch(option){
			case 1: add(); break;
			case 2: edit(); break;
			case 3: select(); break;
			case 4: printUsers(); break;
			case 5: System.out.println("Program Has Ended"); break; //Ends Program
			default: System.out.println("Not an available option\n");
			break;
		}
	}
	
	/**
	 * Adds New Account
	 */
	public void add(){
		CreditCard card = new CreditCard();
		EZPassAccount account = new EZPassAccount(card);
		
		accounts.add(account);
		Vehicle vehicle = addVehicle();
		
		accounts.get(accounts.size()-1).setVehicle(vehicle);
		
		System.out.println();
	}
	
	/**
	 * Adds New Vehicle
	 * @return created vehicle
	 */
	public Vehicle addVehicle(){
		Vehicle vehicle;
		
		if(selectVehicle().equals("car"))
			vehicle = new Car();
		else
			vehicle = new Truck();
		
		return vehicle;
	}
	
	/**
	 * Edits Account
	 */
	public void edit(){
		int hold = selectAccount();
		if(hold != -1){
			EZPassAccount account = accounts.get(hold);
			editMenuPick(account);
		}
		else
			System.out.println("User Does Not Have An EZPass Account \n");
	}
	
	/**
	 * Select Account
	 */
	public void select(){
		int hold = selectAccount();
		if(hold != -1){
			EZPassAccount account = accounts.get(hold);
			Vehicle vehicle = vehiclePick(account);
			simulate(account, vehicle);
		}
		else
			System.out.println("User Does Not Have An EZPass Account \n");
	}

	/**
	 * Pick Vehicle
	 * @param account Selected Account
	 * @return Selected Vehicle
	 */
	public Vehicle vehiclePick(EZPassAccount account){
		return account.getVehicle(account.getVehicleSerial()); 
	}
	
	/**
	 * Get type of Vehicle
	 * @return type of Vehicle
	 */
	public String selectVehicle(){
		int choice = 0;
		boolean test = false;
		
		while(!test){
			
			System.out.println("\nSelect Vehicle:");
			System.out.println("1. Car");
			System.out.println("2. Truck");
			
			try{
				choice = Integer.parseInt(input.next());
				test = true;
			}
			catch(Exception e){
				System.out.println("Please Enter A Number");
				test = false;
			}
			if(choice < 1 || choice > 2){
				System.out.println("Not A Valid Option");
				test = false;
			}
		}
		
		return getTypeName(choice);
	}
	
	/**
	 * Return the name of Vehicle
	 * @param choice
	 * @return car if Vehicle is Car, truck if Vehicle is Truck
	 */
	public String getTypeName(int choice){
		String type = "";
		
		if(choice == 1)
			type = "car";
		if(choice == 2)
			type = "truck";
		
		return type;
	}
	
	/**
	 * Selects Account
	 * @return
	 */
	public int selectAccount(){
		int hold = -1;
		String name = EZPassAccount.askName();
		
		for(int x = 0; x < accounts.size(); x++)
			if(accounts.get(x).getName().equals(name))
				hold = x;
		
		return hold;
	}
	
	/**
	 * Prints all Accounts
	 */
	public void printUsers(){
		if(accounts.size()>0){
			System.out.println("\nAll EZPass Account Holders");
			for(EZPassAccount x : accounts)
				System.out.println(x.getName() + ": Balance: $" + dec.format(x.getBalance()));
		}
		else{
			System.out.println("\nNo Accounts Have Been Made");
		}
		System.out.println();
	}
	
	/**
	 * Prints Edit Menu and passes selection
	 * @param account
	 */
	public void editMenuPick(EZPassAccount account){
		int option=0;
		
		while(option!=3) 
		{
			editMenu(); 

			try{
			option=Integer.parseInt(input.next());
			}
			catch(Exception e){
				option=0;
			}
			
			editSelect(option, account);
		}
	}
	
	/**
	 * Edit Menu
	 */
	public void editMenu(){
		System.out.println("\nEdit Menu");
		System.out.println("1. Add Money");
		System.out.println("2. Add Vehicles");
		System.out.println("3. Return");
	}
	
	/**
	 * EditMenu Selection
	 * @param option
	 * @param account
	 */
	public void editSelect(int option, EZPassAccount account){
		switch(option){
			case 1: account.addBalance(); break;
			case 2: Vehicle moving = addVehicle(); account.setVehicle(moving); break;
			case 3: break;
			default: System.out.println("Not an available option\n");
			break;
		}
	}
	
	/**
	 * Prints Simulation Menu and passes selection
	 * @param account
	 * @param movingThing
	 */
	public void simulate(EZPassAccount account, Vehicle movingThing){
		int option=0;
		
		while(option!=4) 
		{
			simulateMenu();

			try{
			option=Integer.parseInt(input.next());
			}
			catch(Exception e){
				option=0;
			}
			
			simulateChoice(option, account, movingThing);
		}
		
	}
	
	/**
	 * Simulation Menu
	 */
	public void simulateMenu(){
		System.out.println("\nSelect Path:");
		System.out.println("1. Expressway");
		System.out.println("2. Bridge");
		System.out.println("3. Tunnel");
		System.out.println("4. Return");
	}
	
	/**
	 * Simulation option
	 * @param option Selected option
	 * @param account Selected Account
	 * @param movingThing Selected Vehicle
	 */
	public void simulateChoice(int option, EZPassAccount account, Vehicle movingThing){
		int currHour = createHour();
		
		switch(option){
			case 1: express(account, movingThing, currHour); break;
			case 2: bridge(account, movingThing, currHour); break;
			case 3: tunnel(account, movingThing, currHour); break;
			case 4: break; //Ends Program
			default: System.out.println("Not an available option\n");
			break;
		}
	}
	
	/**
	 * Expressway Path
	 * @param option Selected option
	 * @param account Selected Account
	 * @param movingThing Selected Vehicle
	 */
	public void express(EZPassAccount account, Vehicle movingThing, int hour){
		if(account.canSubBalance(eBooth.getToll(hour, movingThing))){
			account.subBalance(eBooth.getToll(hour, movingThing));
			System.out.println("You have drove on the Expressway.");
			System.out.println("Current Balance: $" + dec.format(account.getBalance()));
			System.out.println("Toll Amount: $" + dec.format(eBooth.getToll()));
		}
		else{
			System.out.println("Unable to drive on Expressway.");
			System.out.println("Current Balance: $" + dec.format(account.getBalance()));
			System.out.println("Toll Amount: $" + dec.format(eBooth.getToll()));
		}
	}
	
	/**
	 * Bridge Path
	 * @param option Selected option
	 * @param account Selected Account
	 * @param movingThing Selected Vehicle
	 */
	public void bridge(EZPassAccount account, Vehicle movingThing, int hour){
		if(account.canSubBalance(bBooth.getToll(hour, movingThing))){
			account.subBalance(bBooth.getToll(hour, movingThing));
			System.out.println("You have drove on the Bridge.");
			System.out.println("Current Balance: $" + dec.format(account.getBalance()));
			System.out.println("Toll Amount: $" + dec.format(bBooth.getToll()));
		}
		else{
			System.out.println("Unable to drive on Bridge.");
			System.out.println("Current Balance: $" + dec.format(account.getBalance()));
			System.out.println("Toll Amount: $" + dec.format(bBooth.getToll()));
		}
	}
	
	/**
	 * Tunnel Path
	 * @param option Selected option
	 * @param account Selected Account
	 * @param movingThing Selected Vehicle
	 */
	public void tunnel(EZPassAccount account, Vehicle movingThing, int hour){
		if(account.canSubBalance(tBooth.getToll(hour, movingThing))){
			account.subBalance(tBooth.getToll(hour, movingThing));
			System.out.println("You have drove in the Tunnel.");
			System.out.println("Current Balance: $" + dec.format(account.getBalance()));
			System.out.println("Toll Amount: $" + dec.format(tBooth.getToll()));
		}
		else{
			System.out.println("Unable to drive in Tunnel.");
			System.out.println("Current Balance: $" + dec.format(account.getBalance()));
			System.out.println("Toll Amount: $" + dec.format(tBooth.getToll()));
		}
	}
	
	/**
	 * Create current Hour
	 * @return current hour
	 */
	public int createHour(){
		return (int)Math.random()*24;
	}
	
	public String toString(){
		return getClass() + "\nCreated Accounts: \t accounts \nExpressway TollBooth: \t eBooth \nBridge TollBooth: \t bBooth \nTunnel TollBooth \t tBooth";
	}
	
	public static void main(String[] args) {
		Driver testRun = new Driver();
		testRun.selectMenu();
	}
}
