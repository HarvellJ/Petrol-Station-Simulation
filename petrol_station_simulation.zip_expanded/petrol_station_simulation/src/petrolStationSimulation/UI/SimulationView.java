package petrolStationSimulation.UI;

import petrolStationSimulation.PetrolStation.PetrolStation;
import petrolStationSimulation.PetrolStation.Pump;
import petrolStationSimulation.PetrolStation.ShoppingArea;
import petrolStationSimulation.PetrolStation.Till;

public class SimulationView {
	
	public SimulationView() {

	}
		
    public void RefreshUI() {
    	// go through the petrol station model and update the simulation ui
    }
		
	/**
	 * Initialize the contents of the frame.
	 */
	public static String renderCurrentState(PetrolStation petrolStation) {	
		String retVal = "";
		// add shopping area
		retVal += "========================================================= " + System.getProperty("line.separator");
	    retVal += printShop(petrolStation.GetShop());
		
		// add pumps to form
		for(Pump pump : petrolStation.GetPumps()) {	
			retVal += printPump(pump);
		}
		
		retVal += "========================================================= " + System.getProperty("line.separator");
		return retVal;
	}
	
	public static String printPetrolStationConfiguration(PetrolStation petrolStation) {
		String retVal = "";
		retVal += "Petrol station information: " + System.getProperty("line.separator");
		retVal += "Number of pumps:" + petrolStation.GetPumps().length + System.getProperty("line.separator");
		retVal += "Number of tills: " + petrolStation.GetShop().getTills().length + System.getProperty("line.separator");
		retVal += "Trucks allows: " + petrolStation.TrucksAllowed() + System.getProperty("line.separator");
		return retVal;
	}
	
	private static String printShop(ShoppingArea shop) {
		String retVal = "" + System.getProperty("line.separator");
		retVal += "================== Shopping Area  ===================" +System.getProperty("line.separator");
		retVal += "Number of Tills: " + shop.getTills().length + System.getProperty("line.separator");
		int i = 1;
		for(Till till : shop.getTills()) {
			retVal += "till " + i + " queue size: " + till.getQueue().size() +System.getProperty("line.separator");
			i++;
		}
		retVal += "Current Customers in Shop: " + shop.getCustomers().size() +System.getProperty("line.separator");
		retVal += "====================================================="+System.getProperty("line.separator");
		return retVal;
	}
	
	private static String printPump(Pump pump) {
		String retVal = "";
		retVal += System.getProperty("line.separator");
		retVal += "============= Pump  =============" + System.getProperty("line.separator");
		if(pump.getCurrentActiveVehicle() != null) {
			retVal += "Current Vehicle: " + pump.getCurrentActiveVehicle().vehicleDescription() + System.getProperty("line.separator");

		}else {
			retVal += "Pump is currently empty" + System.getProperty("line.separator");

		}
		retVal += "Number of vehicles in queue: " + pump.getQueue().size() + System.getProperty("line.separator");
		retVal += "=================================" + System.getProperty("line.separator");
		return retVal;
	} 
	
}
