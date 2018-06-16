package petrolStationSimulation.PetrolStation;

import java.util.ArrayList;


import petrolStationSimulation.Vehicle.Vehicle;

public class Pump{

	public Pump() {
		queue = new ArrayList<Vehicle>();
	}
	
	private ArrayList<Vehicle> queue;
	
	public ArrayList<Vehicle> GetQueue(){
		return queue;
	}
	
	public void Enqueue(Vehicle vehicle) {
		queue.add(vehicle);
	}
	
	public void Dequeue(Vehicle vehicle) {
		queue.remove(0);
	}
	
	public Vehicle GetCurrentActiveVehicle() {
		if (queue.size() > 0) {
			return queue.get(0);
		}else {
			return null;
		}
	}
	
}
