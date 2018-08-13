package petrolStationSimulation.Vehicle;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class VehicleFactoryTest {

	/**
	 * Tests that the vehicle factory method behaves as expected when generating masses of vehicles
	 * uses a seed to predict the outcome
	 * With trucks enabled
	 */
	@Test
	public void testGetVehicleTrucksEnabled() {
		double probabilitySmallCarMotorbike = 0.2;
		double probabilityFamilySedan = 0.4;
		double probabilityTruck = 0.02;
		
		// test with multiple different seeds
		for(int i = 0; i < 10000; i++) {
			VehicleFactory vehicleFactory = new VehicleFactory(probabilitySmallCarMotorbike, probabilityFamilySedan, true, i);
			Random r = new Random(i);
			double vehicleGenerationNumber = r.nextDouble();
			
			Vehicle vehicle = vehicleFactory.getVehicle();
			if(vehicleGenerationNumber <= probabilitySmallCarMotorbike) {
				assertTrue(vehicle instanceof SmallCar);
			}
			else if(vehicleGenerationNumber < probabilitySmallCarMotorbike*2) {
				assertTrue(vehicle instanceof Motorbike);
			}
			else if(vehicleGenerationNumber < probabilitySmallCarMotorbike*2+probabilityFamilySedan) {
				assertTrue(vehicle instanceof FamilySedan);
			}
			else if(vehicleGenerationNumber < probabilitySmallCarMotorbike*2+probabilityFamilySedan+probabilityTruck) {
				assertTrue(vehicle instanceof Truck);
			}
			else {
				assertEquals(null, vehicle);
			}
		}		
	}

	/**
	 * Tests that the vehicle factory method behaves as expected when generating masses of vehicles
	 * uses a seed to predict the outcome
	 * With trucks disabled
	 */
	@Test
	public void testGetVehicleTrucksDisabled() {
		double probabilitySmallCarMotorbike = 0.2;
		double probabilityFamilySedan = 0.4;
		double probabilityTruck = 0.02;
		
		// test with multiple different seeds
		for(int i = 0; i < 10000; i++) {
			VehicleFactory vehicleFactory = new VehicleFactory(probabilitySmallCarMotorbike, probabilityFamilySedan, false, i);
			Random r = new Random(i);
			double vehicleGenerationNumber = r.nextDouble();
			
			Vehicle vehicle = vehicleFactory.getVehicle();
			if(vehicleGenerationNumber <= probabilitySmallCarMotorbike) {
				assertTrue(vehicle instanceof SmallCar);
			}
			else if(vehicleGenerationNumber < probabilitySmallCarMotorbike*2) {
				assertTrue(vehicle instanceof Motorbike);
			}
			else if(vehicleGenerationNumber < probabilitySmallCarMotorbike*2+probabilityFamilySedan) {
				assertTrue(vehicle instanceof FamilySedan);
			}
			else if(vehicleGenerationNumber < probabilitySmallCarMotorbike*2+probabilityFamilySedan+probabilityTruck) {
				assertTrue(vehicle instanceof Truck);
			}
			else {
				assertEquals(null, vehicle);
			}
		}		
	}
	
}
