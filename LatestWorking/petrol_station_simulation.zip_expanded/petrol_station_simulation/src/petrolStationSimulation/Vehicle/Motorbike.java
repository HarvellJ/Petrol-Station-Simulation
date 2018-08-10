package petrolStationSimulation.Vehicle;

public class Motorbike extends Bike {
	
	public Motorbike(double units, int fuelTankSize) {
		super(units, fuelTankSize);
	}
	
	public String vehicleDescription() {
		return "Motorbike";
	}
	
}
