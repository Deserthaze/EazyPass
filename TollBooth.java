package assignment4;
/*
 * EZ Pass Project
 */
public abstract class TollBooth {

	private double toll;
	private int carpool;
	private int currentHour;
	private int offPeakHour;
	private boolean oneWayCharge;
	
	public TollBooth(boolean oneWayCharge){
		setToll(5.00);
		setCarpool(4);
		offPeakHour = createOffHour();
		this.oneWayCharge = oneWayCharge;
	}
	
	/**
	 * Sets Toll
	 * @param toll Toll Amount
	 */
	public void setToll(double toll){
		this.toll = toll;
	}
	
	/**
	 * 
	 * @return Toll Amount
	 */
	public double getToll(){
		return toll;
	}
	
	/**
	 * Sets Carpool
	 * @param carpool
	 */
	public void setCarpool(int carpool){
		this.carpool = carpool;
	}
	
	/**
	 * 
	 * @return carpool amount
	 */
	public int getCarpool(){
		return carpool;
	}
	
	/**
	 * 
	 * @return true if Charge is only One Way, false if charge is both ways
	 */
	public boolean getOneWayCharge(){
		return oneWayCharge;
	}
	
	/**
	 * Sets Current Hour
	 * @param currentHour 
	 */
	public void setCurrentHour(int currentHour) {
		this.currentHour = currentHour;
	}
	
	/**
	 * 
	 * @return current hour
	 */
	public int getCurrentHour() {
		return currentHour;
	}
	
	/**
	 * 
	 * @return offPeakHour
	 */
	public int getOffPeakHour(){
		return offPeakHour;
	}
	
	public abstract void vehicleType(Vehicle moving);
	
	/**
	 * Creates Off Peak Hour
	 * @return
	 */
	public int createOffHour(){
		return (int)Math.random()*24;
	}
	
	public String toString(){
		return getClass()+"\nToll Amount from Booth: \t toll \nCarpool Amount: \t carpool \nCurrent Hour: \t currentHour \nOff Peak Hour: \t offPeakHour \nIf Booth Charges One Way: \t oneWayCharge";
	}
	
}
