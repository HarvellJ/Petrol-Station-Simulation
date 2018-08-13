package petrolStationSimulation.PetrolStation;

import petrolStationSimulation.Vehicle.Vehicle;

/**
 * This class models a pump object
 */
public class Pump{

	private int timePerGalon; // The time it takes for the pump to distribute one galon of fuel
	private PumpQueue queue; // The queue for the petrol pump
	
	/**
	 * Constructor method
	 * @param timePerGalon An int representing the number of seconds it takes to recieve one galon of fuel from this pump
	 */
	public Pump(int timePerGalon) {
		queue = new PumpQueue();
		this.timePerGalon = timePerGalon;
	}
	
	/**
	 * Constructor method with default value for timePerGalon
	 */
	public Pump() {
		this(10);
	}
	
	/**
	 * gets the timePerGalon value
	 * @return the timePerGalon value
	 */
	public int getTimePerGalon() {
		return timePerGalon;
	}	
	
	/**
	 * the method that gets the queue 
	 * @return The pump's queue
	 */
	public PumpQueue getQueue() {
		return queue;
	}

	/**
	 * This method gets the vehicle currently at the pump
	 * @return The vehicle from the front of the pump's queue
	 */
	public Vehicle getCurrentActiveVehicle() {
		return queue.getFirstElement();
	}

}
