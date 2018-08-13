package petrolStationSimulation.Vehicle;

public class Bike extends Vehicle {

	public Bike(double units, int fuelTankSize) {
	    super(units, fuelTankSize);		
	}
	
	public String vehicleDescription() {
		return "Bike";
	}
	
	public void setDriverMood() {
	  super.getDriver().setHappy(false);
	}
}
