package petrolStationSimulation.Vehicle;

import petrolStationSimulation.Person.Person;

public abstract class Vehicle implements IVehicle {

	public Vehicle() {
		driver = new Person();
	}
	
	protected Person driver;
	
	protected double units;
	
	
	public abstract String VehicleDescription();
}
