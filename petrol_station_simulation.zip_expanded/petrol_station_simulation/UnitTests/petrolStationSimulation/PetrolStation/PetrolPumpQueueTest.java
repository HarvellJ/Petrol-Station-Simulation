package petrolStationSimulation.PetrolStation;

import static org.junit.Assert.*;

import org.junit.Test;

import petrolStationSimulation.Vehicle.FamilySedan;
import petrolStationSimulation.Vehicle.SmallCar;
import petrolStationSimulation.Vehicle.Truck;

/**
 * 
 * This class tests the PetrolPumpQueue class
 */
public class PetrolPumpQueueTest {

	/**
	 * test adding/removing a single vehicle
	 */
	@Test
	public void testRemoveVehicle() {
		// create a pump size of 3
		PumpQueue petrolPumpQueue = new PumpQueue(3);

		// add vehicle of size 1, should work...
		SmallCar smallCar = new SmallCar(1, 10);
		assertEquals(true, petrolPumpQueue.addVehicle(smallCar));		
		assertEquals(1, petrolPumpQueue.unitsInQueue, 0);
		
		// remove a vehicle and check pump queue is empty
		petrolPumpQueue.removeVehicle();
		assertEquals(0, petrolPumpQueue.unitsInQueue, 0);

	}
	
	/**
	 * attempt to remove a vehicle from an empty queue, exception should be thrown
	 */
	@Test(expected = IllegalStateException.class)
	public void testRemoveVehicleQueueEmpty() {
		// create a pump size of 3
		PumpQueue petrolPumpQueue = new PumpQueue(3);
		
		// remove a vehicle - queue is empty
		petrolPumpQueue.removeVehicle();
	}
	
	/**
	 * test adding/removing multiple vehicles
	 */
	@Test
	public void testRemoveVehicles() {
		// create a pump size of 3
		PumpQueue petrolPumpQueue = new PumpQueue(3);

		// add vehicle of size 1, should work...
		SmallCar smallCar = new SmallCar(1, 10);
		assertEquals(true, petrolPumpQueue.addVehicle(smallCar));		
		assertEquals(1, petrolPumpQueue.unitsInQueue, 0);
		
		// add vehicle of size 1, should work...
		FamilySedan familySedan = new FamilySedan(1.5, 10);
		assertEquals(true, petrolPumpQueue.addVehicle(familySedan));		
		assertEquals(2.5, petrolPumpQueue.unitsInQueue, 0);
		
		// remove a vehicle (removes from front so queue should be size of second vehicle added)
		petrolPumpQueue.removeVehicle();
		assertEquals(1.5, petrolPumpQueue.unitsInQueue, 0);
	}
	
	/**
	 * test adding vehicles up and over the limit of a defined pump queue
	 */
	@Test
	public void testAddVehicle() {
		// create a pump size of 3
		PumpQueue petrolPumpQueue = new PumpQueue(3);
		
		// add vehicle of size 1, should work...
		SmallCar smallCar = new SmallCar(1, 10);
		assertEquals(true, petrolPumpQueue.addVehicle(smallCar));
		
		// add a vehicle of size 1.5, should still work...
		FamilySedan familySedan = new FamilySedan(1.5, 12);
		assertEquals(true, petrolPumpQueue.addVehicle(familySedan));

		// add a vehicle of size 2, should fail... (greater than the allowed pump queue size)
		Truck truck = new Truck(2, 15);
		assertEquals(false, petrolPumpQueue.addVehicle(truck));	
		
		// a final test - the time on the vehicles should be set to 0
		assertEquals(0, smallCar.getExistedFor());
		assertEquals(0, familySedan.getExistedFor());
		assertEquals(0, truck.getExistedFor());
	}
	
	
	/**
	 * test adding time to vehicles in queue
	 */
	@Test
	public void testIncrementTimeOnQueuedVehicles() {
		// create a pump size of 3
		PumpQueue petrolPumpQueue = new PumpQueue(3);
		
		// add vehicle of size 1
		SmallCar smallCar = new SmallCar(1, 7);
		assertEquals(true, petrolPumpQueue.addVehicle(smallCar));	
		assertEquals(0, smallCar.getExistedFor());
		
		//increment time
		petrolPumpQueue.IncrementTimeOnQueuedVehicles(10);
		assertEquals(10, smallCar.getExistedFor());
		
		// add a vehicle of size 1.5.
		FamilySedan familySedan = new FamilySedan(1.5, 12);
		assertEquals(true, petrolPumpQueue.addVehicle(familySedan));
		assertEquals(0, familySedan.getExistedFor());
		
		//increment time
		petrolPumpQueue.IncrementTimeOnQueuedVehicles(10);
		assertEquals(10, familySedan.getExistedFor());
		assertEquals(20, smallCar.getExistedFor());

	}


}
