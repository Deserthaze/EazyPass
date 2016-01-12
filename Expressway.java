package assignment4;
/*
 
 * EZ Pass Project
 */
public class Expressway extends TollBooth {

	public Expressway(boolean oneWayCharge) {
		super(oneWayCharge);
	}

	/**
	 * Sets Toll depending on Vehicle Type
	 */
	public void vehicleType(Vehicle moving){
		if(moving.getType().equals("car"))
			setToll(getToll() + 3);
		else if(moving.getType().equals("truck"))
			setToll(getToll() + 10);
	}

	/**
	 * Sets Toll depending on certain factors
	 * @param hour
	 * @param moving
	 * @return
	 */
	public double getToll(int hour, Vehicle moving){
		if(hour == getOffPeakHour()){
			setToll(2);
			vehicleType(moving);
			if(moving.getNumPass() >= getCarpool())
				setToll(getToll()-2);
			if(!getOneWayCharge())
				setToll(getToll()*2);
		}
		else{
			setToll(3);
			vehicleType(moving);
			if(moving.getNumPass() >= getCarpool())
				setToll(getToll()-2);
			if(!getOneWayCharge())
				setToll(getToll()*2);
		}
		
		return getToll();
	}
	
	public String toString(){
		return getClass()+"\nToll Amount from Booth: \t toll \nCarpool Amount: \t carpool \nCurrent Hour: \t currentHour \nOff Peak Hour: \t offPeakHour \nIf Booth Charges One Way: \t oneWayCharge";
	}
	
}
