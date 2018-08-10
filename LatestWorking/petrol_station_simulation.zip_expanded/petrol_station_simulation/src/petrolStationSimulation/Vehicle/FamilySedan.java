package petrolStationSimulation.Vehicle;

import java.util.Random;

public class FamilySedan extends Car {
	
	public FamilySedan(double units, int fuelTankSize) {
	    super(units, fuelTankSize);		
	}
	
	public String vehicleDescription() {
		return "Family Sedan";
	}
	
	public void setDriverMood() {
		if(super.getExistedFor() > 300) {
			Random r = new Random();
			if(r.nextDouble() <= 0.4) {
				super.getDriver().setHappy(true);
			}else {
				super.getDriver().setHappy(false);
			}
		}
	}
}
