package petrolStationSimulation.Vehicle;

import java.util.Random;

public class SmallCar extends Car{
	
	public SmallCar(double units, int fuelTankSize) {
	    super(units, fuelTankSize);		
	}
	
	public String vehicleDescription() {
		return "Small car";
	}
	
	public void setDriverMood() {
		if(super.getExistedFor() > 300) {
			Random r = new Random();
			if(r.nextDouble() <= 0.3) {
				super.getDriver().setHappy(true);
			}else {
				super.getDriver().setHappy(false);
			}
		}
	}
}
