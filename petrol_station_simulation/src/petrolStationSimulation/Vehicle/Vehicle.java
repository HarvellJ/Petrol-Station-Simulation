package petrolStationSimulation.Vehicle;

import petrolStationSimulation.Person.Person;

public class Vehicle implements IVehicle {

	public Vehicle() {
		driver = new Person();
	}
	
	protected Person driver;
	
}
