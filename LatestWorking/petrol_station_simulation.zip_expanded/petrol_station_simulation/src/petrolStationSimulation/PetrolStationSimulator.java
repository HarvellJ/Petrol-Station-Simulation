package petrolStationSimulation;

import petrolStationSimulation.PetrolStation.PetrolStation;
import petrolStationSimulation.PetrolStation.Pump;
import petrolStationSimulation.PetrolStation.Till;
import petrolStationSimulation.UI.SimulationView;
import petrolStationSimulation.Vehicle.Truck;
import petrolStationSimulation.Vehicle.Vehicle;
import petrolStationSimulation.Vehicle.VehicleFactory;
import simulator.ISimulationObject;

public class PetrolStationSimulator implements ISimulationObject{

	private PetrolStation petrolStation; // The petrol station object used throughout the simulation
	private VehicleFactory vehicleFactory; // The class that creates vehicles
	
	//financials
	private double moneyMade;
	private double moneyLost;
	
	/**
	 * sets up the variables of the simulation
	 * @param petrolStation The PetrolStation object on which the simulation will be ran
	 * @param probabilityQ The probability of small cars and motorbikes arriving at the station
	 * @param probabilityP The probability of family sedans arriving
	 * @param randomSeed The seed for the random number generator
	 * @param generateTrucks The setting to determine whether or not to include trucks in this simulation
	 */
	public PetrolStationSimulator(PetrolStation petrolStation, double probabilitySmallCarsAndBikes, double probabilityFamilySedan,
			boolean generateTrucks, long randomSeed) {
		this.petrolStation = petrolStation;
		this.vehicleFactory = new VehicleFactory(probabilitySmallCarsAndBikes, probabilityFamilySedan, generateTrucks, randomSeed);
	}
	
	/* (non-Javadoc)
	 * @see simulator.ISimulationObject#tick()
	 */
	public void tick(int tickTime) {

		//foreach pump
		for(Pump pump : petrolStation.GetPumps()) {
			//1. handle the vehicles in the pump queues
			Vehicle vehicle = pump.getCurrentActiveVehicle();
			if(vehicle!=null) {
				if(vehicle.getDriver().isInVehicle()) {
					// check if driver finished fueling - handle accordingly
					this.handleDriverFueling(vehicle, pump);
				}else {
					// check if driver done at till	- handle accordingly  
					this.handleDriverAtTill(vehicle, pump);
				}			
			}	

			//2. age pump queue
			this.agePumpQueue(pump, tickTime);		  			  		    
		}

		// 3.
		// handle vehicles entering queues	
		this.handleVehicleEntry();	
		
		// age till queue
		this.ageTillQueues(tickTime);

		// print results
		SimulationView.RenderCurrentState(this.petrolStation);
		System.out.println(moneyMade);
		System.out.println(moneyLost);

	}

	
	
	private void handleDriverFueling(Vehicle vehicle, Pump pump) {
		if(vehicle.getFuelTankSize() * pump.getTimePerGalon() - pump.getQueue().getTimeActiveVehicleAtPump() <= 0) {
			// vehicle has fueled, send driver to shop
			vehicle.getDriver().setInVehicle(false);
			//	    shop.add(vehicle.driver)
			this.petrolStation.GetShop().getShortestQueuedTill().getQueue().enqueue(vehicle.getDriver());
		}else {
			// vehicle has not fueled, leave it
		}
	}
	
	/**
	 * Spawns a car of random type based on configured values
	 * @return a Vehicle object
	 */
	private Vehicle spawnCar() {
		return this.vehicleFactory.getVehicle();
	}	
	
	
	private void handleVehicleEntry() {
		// get pump with shortest queue
		Pump pump = this.petrolStation.getPumpWithShortestQueue();
		 Vehicle spawnedVehicle = this.spawnCar();
		  if (spawnedVehicle != null) {
			  boolean vehicleSuccesfullyAdded = pump.getQueue().addVehicle(spawnedVehicle);
			  // calculate losses
			  if(!vehicleSuccesfullyAdded) {
				  moneyLost += spawnedVehicle.getFuelTankSize() * petrolStation.getPricePerGallon();
			  }
		  }	
	}
	
	private void agePumpQueue(Pump pump, int tickTime) {
		  //  - add tick time to every vehicle in queue 
		  pump.getQueue().IncrementTimeOnQueuedVehicles(tickTime);	
		
		  // update each vehicle's driver's mood accordingly vehicle.setDriverMood();	
		  pump.getQueue().updateDriversMoods();	
		  		  	
	}
	
	private void ageTillQueues(int tickTime) {		 
		  for(Till till : this.petrolStation.GetShop().getTills()) {
		    	till.setTimePersonAtTill(till.getTimePersonAtTill() + tickTime);
		  }
	}
	
	private void handleDriverAtTill(Vehicle driversVehicle, Pump pumpParkedAt) {
		//foreach active person at each till in shop
		for(Till till : this.petrolStation.GetShop().getTills()) {
			if(till.getActivePerson() != null) {
				if(till.getActivePerson().equals(driversVehicle.getDriver())){
					// if they've finished at till -
					// when time their vehicle in simulation + time active at pump = time their vehicle in simulation + till wait time 
					if(till.getTimePersonAtTill() >= 120) {
						// person finished, remove them from petrol station
						this.removeDriverFromPetrolStation(till, pumpParkedAt);
						
						// handle truck drivers moods
						if(driversVehicle instanceof Truck) {
							this.handleTruckProbability((Truck)driversVehicle);
						}
						
						//        based on type of vehicle, add full tank price to money made
						this.moneyMade += driversVehicle.getFuelTankSize() * petrolStation.getPricePerGallon();
					}
				}    
			}
		}	
	}
	
	private void handleTruckProbability(Truck vehicle) {
		if(vehicle.getDriver().isHappy()) {
			// increase probability that trucks will return in future
			this.vehicleFactory.setProbabilityTruck(this.vehicleFactory.getProbabilityTruck() + this.vehicleFactory.getProbabilityTruck() * 0.05);
		}
		else {
			// decrease probability that trucks will return in future
			this.vehicleFactory.setProbabilityTruck(this.vehicleFactory.getProbabilityTruck() - this.vehicleFactory.getProbabilityTruck() * 0.2);
		}
	}
	
	private void removeDriverFromPetrolStation(Till till, Pump pumpParkedAt) {
		till.removePerson();	
		pumpParkedAt.getQueue().removeVehicle();
	}
	
	/**
	 * @return an instance of the PetrolStation object that is the subject of this simulation
	 */
	public PetrolStation getResult() {
		// TODO Auto-generated method stub
		return petrolStation;
	}

}
