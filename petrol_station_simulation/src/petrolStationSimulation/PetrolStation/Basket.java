package petrolStationSimulation.PetrolStation;

import java.util.ArrayList;
import java.util.List;

import petrolStationSimulation.Person.Customer;

public class Basket {

	public Basket(Customer customer) {
		this.setCustomer(customer);
	}
	
	public ArrayList<Item> getContents() {
		return contents;
	}

	public void setContents(ArrayList<Item> items) {
		this.contents = items;		
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	private ArrayList<Item> contents;
	private Customer customer;
	
	
	public void AddToBasket(Item item) {
		contents.add(item);
	}

}
