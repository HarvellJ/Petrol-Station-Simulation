package petrolStationSimulation.PetrolStation;

import common.data_type.ArrayListQueue;
import petrolStationSimulation.Person.Person;

/**
 * Models a till object
 */
public class Till {

	private int timePersonAtTill;
	private ArrayListQueue<Person> queue; // The queue of people at the till

	/**
	 * The constructor method for Till
	 */
	public Till() {
		this.queue = new ArrayListQueue<Person>();
	}
	
	/**
	 * gets the time the current person has been at the till
	 * @return
	 */
	public int getTimePersonAtTill() {
		return timePersonAtTill;
	}

	/**
	 * set the time the current person has been at the till
	 * @param timePersonAtTill
	 */
	public void setTimePersonAtTill(int timePersonAtTill) {
		this.timePersonAtTill = timePersonAtTill;
	}

	/**
	 * gets the queue
	 * @return the instance of ArrayListQueue contained within this class
	 */
	public ArrayListQueue<Person> getQueue() {
		return queue;
	}

	/**
	 * sets the queue obejct
	 * @param queue The instance of ArrayListQueue to set
	 */
	public void setQueue(ArrayListQueue<Person> queue) {
		this.queue = queue;
	}
	
	/**
	 * This method gets the current person using the till
	 * @return The vehicle from the front of the pump's queue
	 */
	public Person getActivePerson() {
		return queue.getFirstElement();
	}
	
	/**
	 * calls the queue instance and adds a given person
	 * @param person the person to add
	 */
	public void addPersonToQueue(Person person) {
		this.queue.enqueue(person);
	}
	
	public Person removePerson() {
		// reset time active person at till
		timePersonAtTill = 0;
		return this.queue.dequeue();
	}
	
}
