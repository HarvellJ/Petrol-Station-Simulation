package petrolStationSimulation.Vehicle;

import petrolStationSimulation.Person.Person;

/**
 * 
 * This class defines the operations and properties common to all vehicle types
 */
public abstract class Vehicle implements IVehicle {

	protected Person driver; // the driver of the vehicle
	protected double units;	// the vehicle's size
	protected int existedFor; // can be used to store the time the vehicle has existed for
	protected int fuelTankSize; // the size of the fuel tank
	
	/**
	 * Constructor method that allows the specification of vehicle size
	 * @param units The size of this vehicle in units
	 */
	public Vehicle(double units, int fuelTankSize) {
		this.units = units;
		driver = new Person();
		this.fuelTankSize = fuelTankSize;
	}

	
	public int getFuelTankSize() {
		return fuelTankSize;
	}

	/**
	 * gets the driver of this vehicle
	 * @return the driver
	 */
	public Person getDriver() {
		return driver;
	}

	/**
	 * sets the driver object
	 * @param driver the driver istance to set
	 */
	public void setDriver(Person driver) {
		this.driver = driver;
	}
	
	/**
	 * gets the size of this vehicle
	 * @return The units
	 */
	public double getUnits() {
		return units;
	}
	
	/**
	 * @return An int representing the time this vehicle object has existed for
	 */
	public int getExistedFor() {
		return existedFor;
	}

	/**
	 * gets the existedFor value
	 * @param existedFor the time this vehicle has existed for
	 */
	public void setExistedFor(int existedFor) {
		this.existedFor = existedFor;
	}
	
	/* (non-Javadoc)
	 * @see petrolStationSimulation.Vehicle.IVehicle#VehicleDescription()
	 */
	public abstract String vehicleDescription();
	
	/* (non-Javadoc)
	 * @see petrolStationSimulation.Vehicle.IVehicle#VehicleDescription()
	 */
	public abstract void setDriverMood();
}
