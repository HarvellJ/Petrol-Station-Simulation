package petrolStationSimulation.Vehicle;

import java.util.Random;

/**
 * This class models a vehicle factory, following the standard factory pattern
 * It uses a random number generated, that can either be seeded or un-seeded to determine the type of vehicle to spawn
 */
public class VehicleFactory {

	// Fuel tank sizes for vehicles
	private final int SMALL_CAR_MIN_TANK_SIZE = 7;
	private final int SMALL_CAR_MAX_TANK_SIZE = 9;
	private final int MOTORBIKE_TANK_SIZE = 5;
	private final int FAMILY_SEDAN_MIN_TANK_SIZE = 12;
	private final int FAMILY_SEDAN_MAX_TANK_SIZE = 18;
	private final int TRUCK_MIN_TANK_SIZE = 30;
	private final int TRUCK_MAX_TANK_SIZE = 40;
	
	private double probabilitySmallCarsAndBikes; // The probability of spawning a small car or motorbike
	private double probabilityFamilySedan; // The probability of spawning a family sedan
	private double probabilityTruck = 0.02; // The probability of spawning a truck - defaults to 0.02
	private boolean generateTrucks; // Stores whether or not this factory can generate trucks
	Random randomGenerator; // The random object used to determine the type of vehicle to spawn
	
	/**
	 * Constructor method 
	 * @param probabilitySmallCarsAndBikes The probability of small cars and bikes being spawned in this factory
	 * @param probabilityFamilySedan The probability of family sedans being spawned in this factory
	 * @param boolean indicating whether or not to generate trucks
	 */
	public VehicleFactory(double probabilitySmallCarsAndBikes, double probabilityFamilySedan, boolean generateTrucks) {
		this.probabilitySmallCarsAndBikes = probabilitySmallCarsAndBikes;
		this.probabilityFamilySedan = probabilityFamilySedan;
		this.randomGenerator = new Random();
		this.generateTrucks = generateTrucks;
	}
	
	/**
	 * Constructor method that also seeds the random generator
	 * @param probabilitySmallCarsAndBikes The probability of small cars and bikes being spawned in this factory
	 * @param probabilityFamilySedan The probability of family sedans being spawned in this factory
	 * @param seed The seed for the random number generator
	 * @param boolean indicating whether or not to generate trucks
	 */
	public VehicleFactory(double probabilitySmallCarsAndBikes, double probabilityFamilySedan, boolean generateTrucks, long seed) {
		this.probabilitySmallCarsAndBikes = probabilitySmallCarsAndBikes;
		this.probabilityFamilySedan = probabilityFamilySedan;
		this.randomGenerator = new Random();
		this.randomGenerator.setSeed(seed);
		this.generateTrucks = generateTrucks;
	}

	/**
	 * gets the probability of a truck being spawned
	 * @return probabilityTruck
	 */
	public double getProbabilityTruck() {
		return probabilityTruck;
	}

	/**
	 * sets the probability of a truck being spawned
	 * @param probabilityTruck The probability of a truck being spawned
	 */
	public void setProbabilityTruck(double probabilityTruck) {
		this.probabilityTruck = probabilityTruck;
	}
	
	/**
	 * This method generates a vehicle of a specific type based on a random number generation
	 * @return a Vehicle object, this is either a SmallCar, FamilySedan, Motorbike, truck, or null
	 */
	public Vehicle getVehicle() {
		  double vehicleGenerationNumber = randomGenerator.nextDouble();
		
		  if(vehicleGenerationNumber <= probabilitySmallCarsAndBikes) {		  
			  return new SmallCar(1, chooseTankSize(SMALL_CAR_MIN_TANK_SIZE, SMALL_CAR_MAX_TANK_SIZE));			 			  
		  }
		  // add bike
		  else if(vehicleGenerationNumber < probabilitySmallCarsAndBikes*2) {
			  return new Motorbike(1, MOTORBIKE_TANK_SIZE);		 
		  }
		  // add family sedan
		  else if(vehicleGenerationNumber < probabilitySmallCarsAndBikes*2 + probabilityFamilySedan) {
			  return new FamilySedan(1, chooseTankSize(FAMILY_SEDAN_MIN_TANK_SIZE, FAMILY_SEDAN_MAX_TANK_SIZE));			 
		  }
		  // add truck
		  else if(generateTrucks && vehicleGenerationNumber <  probabilitySmallCarsAndBikes*2 + probabilityFamilySedan + probabilityTruck) {
			  return new Truck(1, chooseTankSize(TRUCK_MIN_TANK_SIZE, TRUCK_MAX_TANK_SIZE));
		  }
		  else {
			  return null;
		  }
	}
	
	private int chooseTankSize(int min, int max) {
		return randomGenerator.nextInt(max-min) + min;
	}
	
}
