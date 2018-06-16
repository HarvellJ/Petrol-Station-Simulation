package petrolStationSimulation.PetrolStation;

import java.util.ArrayList;

import petrolStationSimulation.Vehicle.Vehicle;

public class Pump implements IPump{

	public Pump() {
		queue = new ArrayList<Vehicle>();
	}
	
	private ArrayList<Vehicle> queue;
	
	public void Enqueue(Vehicle vehicle) {
		queue.add(vehicle);
	}
	
	public void Dequeue(Vehicle vehicle) {
		queue.remove(0);
	}
}
