package petrolStationSimulation.Vehicle;

public abstract class Car extends Vehicle {
	
	public Car(double units, int fuelTankSize) {
		super(units, fuelTankSize);
	}
	
	public String vehicleDescription() {
		return "Car";
	}
	
}
