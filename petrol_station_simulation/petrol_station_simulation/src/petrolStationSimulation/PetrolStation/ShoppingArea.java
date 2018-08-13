package petrolStationSimulation.PetrolStation;

import java.util.ArrayList;

import petrolStationSimulation.Person.Person;

public class ShoppingArea {
	
	private Till[] tills;
	private ArrayList<Person> customers;
	
	public ShoppingArea(int amountOfTills) {
		setTills(new Till[amountOfTills]);
		this.initializeTills();
		customers = new ArrayList<Person>();
	}
	
	public Till[] getTills() {
		return tills;
	}

	public void setTills(Till[] tills) {
		this.tills = tills;
	}

	public ArrayList<Person> getCustomers() {
		return customers;
	}

	public void initializeTills() {
		for(int i = 0; i < tills.length; i++) {
			tills[i] = new Till();
		}
	}
	
	public void AddCustomer(Person customer) {
		this.customers.add(customer);
	}
	
	/**
	 * gets the till that has the shortest queue within the shop
	 * @return The till with the shortest queue
	 */
	public Till getShortestQueuedTill() {
		//start at first till
		Till shortestQueuedTill = tills[0];
		for(Till till : tills) {
			if(till.getQueue().size() < shortestQueuedTill.getQueue().size()) {
				shortestQueuedTill = till;
			}
		}
		return shortestQueuedTill;
	}
}
