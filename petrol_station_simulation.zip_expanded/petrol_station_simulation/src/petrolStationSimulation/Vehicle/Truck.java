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
		if(super.getExistedFor() > 640) {
			Random r = new Random();
			if(r.nextDouble() <= 0.3) {
				super.getDriver().setHappy(true);
			}else {
				super.getDriver().setHappy(false);
			}
		}
	}
}
