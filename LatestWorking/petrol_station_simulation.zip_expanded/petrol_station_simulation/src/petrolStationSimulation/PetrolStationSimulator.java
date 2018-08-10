package petrolStationSimulation;

import java.util.Random;

import petrolStationSimulation.PetrolStation.PetrolStation;
import petrolStationSimulation.PetrolStation.Pump;
import petrolStationSimulation.PetrolStation.Till;
import petrolStationSimulation.UI.SimulationView;
import petrolStationSimulation.Vehicle.FamilySedan;
import petrolStationSimulation.Vehicle.Motorbike;
import petrolStationSimulation.Vehicle.SmallCar;
import petrolStationSimulation.Vehicle.Truck;
import petrolStationSimulation.Vehicle.Vehicle;
import simulator.ISimulationObject;

public class PetrolStationSimulator implements ISimulationObject{

	private PetrolStation petrolStation;
	
	//configurables
	private double probabilityFamilySedan;
	private double probabilitySmallCarsAndBikes;
	private double probabilityTruck = 0.02;
	private double pricePerGalon = 1.20;
	//financials
	private double moneyMade;
	private double moneyLost;
	
	/**
	 * sets up the variables of the simulation
	 * @param petrolStation The PetrolStation object on which the simulation will be ran
	 * @param probabilityQ the probability of small cars and motorbikes arriving at the station
	 * @param probabilityP the probability of family sedans arriving
	 */
	public PetrolStationSimulator(PetrolStation petrolStation, double probabilitySmallCarsAndBikes, double probabilityFamilySedan) {
		this.petrolStation = petrolStation;
		this.probabilityFamilySedan = probabilityFamilySedan;
		this.probabilitySmallCarsAndBikes = probabilitySmallCarsAndBikes;
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
				 // check time fueling, fueltank size * time per galon - time vehicle at pump 
				  if(vehicle.getFuelTankSize() * pump.getTimePerGalon() - pump.getQueue().getTimeActiveVehicleAtPump() <= 0) {
					  // vehicle has fueled, send driver to shop
					  vehicle.getDriver().setInVehicle(false);
						//	    shop.add(vehicle.driver)
					  this.petrolStation.GetShop().getShortestQueuedTill().getQueue().enqueue(vehicle.getDriver());
				  }else {
					  // vehicle has not fueled, leave it
				  }
			  }else {
				    //foreach active person at each till in shop
				    for(Till till : this.petrolStation.GetShop().getTills()) {
				    	if(till.getActivePerson() != null) {
				    	if(till.getActivePerson().equals(vehicle.getDriver())){
				    		// if they've finished at till -
				    		// when time their vehicle in simulation + time active at pump = time their vehicle in simulation + till wait time 
				    		if(till.getTimePersonAtTill() >= 120) {
				    			// remove person from till, remove person from petrol pump
				    			till.removePerson();	
				    			pump.getQueue().removeVehicle();
						        //        based on type of vehicle, add full tank price to money made
				    			this.moneyMade += vehicle.getFuelTankSize() * pricePerGalon;
				    		}
				    	}    
				    	// age active member at till before moving on
				    	till.setTimePersonAtTill(till.getTimePersonAtTill() + tickTime);
				    	}
				    }		     
			  }
			  		  
			  //2. age pump queue
			  //  - add tick time to every vehicle in queue 
			  pump.getQueue().IncrementTimeOnQueuedVehicles(tickTime);	
			
			  // update each vehicle's driver's mood accordingly vehicle.setDriverMood();	
			  pump.getQueue().updateDriversMoods();
			  
			  }	
			  // 3.
			  // handle vehicles entering queues				  
			  Random r = new Random();
			  double vehicleGeneration = r.nextDouble();
			  // add small car
			  if(vehicleGeneration <= probabilitySmallCarsAndBikes) {
				  SmallCar smallCar = new SmallCar(1, 7);
				  boolean vehicleSuccesfullyAdded = pump.getQueue().addVehicle(smallCar);
				  if(!vehicleSuccesfullyAdded) {
					  //account for losses of vehicle leaving due to full queue
					  moneyLost += smallCar.getFuelTankSize() * pricePerGalon;
				  }
			  }
			  // add family sedan
			  else if(vehicleGeneration > probabilitySmallCarsAndBikes*2 && vehicleGeneration < probabilitySmallCarsAndBikes*2 + probabilityFamilySedan) {
				  FamilySedan familySedan = new FamilySedan(1, 12);
				  boolean vehicleSuccesfullyAdded = pump.getQueue().addVehicle(familySedan);
				  if(!vehicleSuccesfullyAdded) {
					  //account for losses of vehicle leaving due to full queue
					  moneyLost += familySedan.getFuelTankSize() * pricePerGalon;
				  }
			  }
			  // add bike
			  else if(vehicleGeneration < probabilitySmallCarsAndBikes && vehicleGeneration < probabilitySmallCarsAndBikes*2) {
				  Motorbike motorbike = new Motorbike(1, 7);
				  boolean vehicleSuccesfullyAdded = pump.getQueue().addVehicle(motorbike);
				  if(!vehicleSuccesfullyAdded) {
					  //account for losses of vehicle leaving due to full queue
					  moneyLost += motorbike.getFuelTankSize() * pricePerGalon;
				  }
			  }
			  // add truck
			  else if(vehicleGeneration > probabilitySmallCarsAndBikes*2 + probabilityFamilySedan && vehicleGeneration <  probabilitySmallCarsAndBikes*2 + probabilityFamilySedan + probabilityTruck) {
				  Truck truck = new Truck(1, 7);
				  boolean vehicleSuccesfullyAdded = pump.getQueue().addVehicle(truck);
				  if(!vehicleSuccesfullyAdded) {
					  //account for losses of vehicle leaving due to full queue
					  moneyLost += truck.getFuelTankSize() * pricePerGalon;
				  }
			  }
			  // else no car arrives
		    
		  }
		  for(Till till : this.petrolStation.GetShop().getTills()) {
		    	till.setTimePersonAtTill(till.getTimePersonAtTill() + tickTime);
		  }
		  
			SimulationView.RenderCurrentState(this.petrolStation);
			System.out.println(moneyMade);
			System.out.println(moneyLost);

	}

	/**
	 * @return an instance of the PetrolStation object that is the subject of this simulation
	 */
	public PetrolStation getResult() {
		// TODO Auto-generated method stub
		return petrolStation;
	}

}
