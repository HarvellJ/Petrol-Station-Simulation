package petrolStationSimulation.Vehicle;

import java.util.Random;

public class Truck extends Vehicle {
	
	public Truck(double units, int fuelTankSize) {
	    super(units, fuelTankSize);		
	}
	
	public String vehicleDescription() {
		return "Truck";
	}
	
	public void setDriverMood() {
		super.getDriver().setHappy(true);
	}
}
