package petrolStationSimulation.UI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import petrolStationSimulation.PetrolStation.PetrolStation;
import petrolStationSimulation.PetrolStation.Pump;
import petrolStationSimulation.PetrolStation.ShoppingArea;

public class SimulationView implements ISimulationView{
	
	public SimulationView() {

	}
		
    public void RefreshUI() {
    	// go through the petrol station model and update the simulation ui
    }
		
	/**
	 * Initialize the contents of the frame.
	 */
	public static void RenderCurrentState(PetrolStation petrolStation) {	
		
		// add shopping area
	    PrintShop(petrolStation.GetShop());
		
		// add pumps to form
		for(Pump pump : petrolStation.GetPumps()) {	
			PrintPump(pump);
		}
				
		
	}
	
	public static void PrintPetrolStationConfiguration(PetrolStation petrolStation) {
		System.out.println("Petrol station information:");
		System.out.println("Number of pumps:" + petrolStation.GetPumps().length);
		System.out.println("Number of tills: " + petrolStation.GetShop().getTills().length);
		System.out.println("Trucks allows: " + petrolStation.TrucksAllowed());
		System.out.println("Beginning simulation...");

	}
	
	private static void PrintShop(ShoppingArea shop) {
		System.out.println("================== Shopping Area  ===================");
		System.out.println("Number of Tills: " + shop.getTills().length);
		System.out.println("Current Customers: " + shop.getCustomers().size());
		System.out.println("=====================================================");
	}
	
	private static void PrintPump(Pump pump) {
		// use this method to declare a consistent frame
		System.out.println("");
		System.out.println("============= Pump  =============");
		if(pump.GetCurrentVehicle() != null) {
			System.out.println("Current Vehicle: " + pump.GetCurrentVehicle().VehicleDescription());

		}else {
			System.out.println("Pump is currently empty");

		}
		System.out.println("Queue Size " + pump.GetQueue().size());
		System.out.println("=================================");
	}
	
}
