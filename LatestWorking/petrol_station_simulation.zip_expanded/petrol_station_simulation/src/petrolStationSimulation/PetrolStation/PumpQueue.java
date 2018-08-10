package petrolStationSimulation.PetrolStation;

import common.data_type.ArrayListQueue;
import petrolStationSimulation.Vehicle.Vehicle;

/**
 * 
 * An extension of the arrayListQueue that implements a queue for a petrol pump that can hold x units
 */
public class PumpQueue extends ArrayListQueue<Vehicle> {

	protected double unitsInQueue; // the current queue size, protected for use in testing
	private double maxUnitSize; // max size of queue
	private int timeActiveVehicleAtPump; // the tick count at which a vehicle arrived at the actual pump (not time queued)
	
	/**
	 * Constructor that allows defaults the maxUnitSize to be 3
	 */
	public PumpQueue() {
		// default pump unit size to 3 if none other specified
		this(3);
	}
	
	/**
	 * Constructor that allows size of maxUnitSize to be configured
	 * @param maxUnitSize The maximum unit size that can be contained within this pump queue
	 */
	public PumpQueue(int maxUnitSize) {
		this.unitsInQueue = 0;
		this.maxUnitSize = maxUnitSize;
	}
	
	/**
	 * gets the timeEnteredPump
	 * @return an int value representing the time the last vehicle entered the pump
	 */
	public int getTimeActiveVehicleAtPump() {
		return timeActiveVehicleAtPump;
	}

	/**
	 * sets the time that the currently active vehicle entered the pump
	 * @param timeEnteredPump the time value to set
	 */
	public void setTimeActiveVehicleAtPump(int timeEnteredPump) {
		this.timeActiveVehicleAtPump = timeEnteredPump;
	}

	/**
	 * gets the current number of units in the queue
	 * @return unitsInQueue
	 */
	public double getUnitsInQueue() {
		return unitsInQueue;
	}

	/**
	 * Allows the setting of the unitsInQueue variable
	 * @param unitsInQueue The units to set the queue to
	 */
	public void setUnitsInQueue(double unitsInQueue) {
		this.unitsInQueue = unitsInQueue;
	}
	
	/**
	 * This method calls the dequeue of base class, returns the vehicle being removed
	 * Reduces unitsInQueue in the process
	 * @return The vehicle being removed from the queue
	 */
	public Vehicle removeVehicle() {	
		try {
			Vehicle vehicle = this.dequeue();
			unitsInQueue -= vehicle.getUnits();
			this.setTimeActiveVehicleAtPump(0);
			return vehicle;
		} catch(IllegalStateException e) {
			throw e;
		}
	}
	
	/**
	 * This method checks the space in the queue
	 * If there is space, this methods adds a given vehicle to the queue 
	 * @param vehicle the vehicle to add to queue
	 * @return boolean indicating whether or not the vehicle was added to the queue
	 */
	public boolean addVehicle(Vehicle vehicle) {
		// set the vehicles time to 0, this will increase relative to the time it spends in the queue
		vehicle.setExistedFor(0);
		
		if(this.hasSpaceFor(vehicle)) {
			this.enqueue(vehicle);
			unitsInQueue += vehicle.getUnits();
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * Increments the time stored on each vehicle in the queue
	 * Represents the time the vehicle has been in the queue
	 * @param tickTime The time to add to each vehicle in the queue
	 */
	public void IncrementTimeOnQueuedVehicles(int tickTime) {
		if(!this.queue.isEmpty()) {
			for(Vehicle vehicle : this.queue) {
				vehicle.setExistedFor(vehicle.getExistedFor()+tickTime);
			}	
		}
		
		// also increment the time the active vehicle has spent at the pump
		this.timeActiveVehicleAtPump += tickTime;
	}
	
	public void updateDriversMoods() {
		for(Vehicle vehicle : this.queue) {
			vehicle.setDriverMood();
		}
	}
	
	/**
	 * This method checks that there is space available in the pump queue for a given vehicle
	 * @param vehicle The vehicle to check we have space for
	 * @return A boolean indicating whether or not there is space available for the given vehicle
	 */
	private boolean hasSpaceFor(Vehicle vehicle) {		
		return ((this.unitsInQueue + vehicle.getUnits()) <= this.maxUnitSize);	
	}
}
