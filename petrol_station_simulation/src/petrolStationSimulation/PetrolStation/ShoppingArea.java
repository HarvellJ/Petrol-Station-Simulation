package petrolStationSimulation.PetrolStation;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import petrolStationSimulation.Person.Customer;

public class ShoppingArea {
	
	public ShoppingArea(int amountOfTills) {
		setTills(new Till[amountOfTills]);
		customers = new ArrayList<Customer>();
	}
	
	public Item[] getStock() {
		return stock;
	}

	public void setStock(Item[] stock) {
		this.stock = stock;
	}

	public Till[] getTills() {
		return tills;
	}

	public void setTills(Till[] tills) {
		this.tills = tills;
	}

	public ArrayList<Customer> getCustomers() {
		return customers;
	}

	private Item[] stock;
	private Till[] tills;
	private ArrayList<Customer> customers;
		
	public void AddCustomer(Customer customer) {
		this.customers.add(customer);
	}
}
