package petrolStationSimulation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import petrolStationSimulation.PetrolStation.PetrolStation;
import petrolStationSimulation.PetrolStation.ShoppingArea;
import petrolStationSimulation.UI.SimulationView;
import petrolStationSimulation.Vehicle.Car;
import petrolStationSimulation.Vehicle.Motorbike;
import petrolStationSimulation.Vehicle.SmallCar;

import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;

import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import simulator.Simulator;
public class PetrolStationSimulation {	
	
	PetrolStation petrolStation;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {		
					
					PetrolStationSimulation simulation = new PetrolStationSimulation();
					
					Scanner sc = new Scanner(System.in);
					System.out.print("Please enter a desired number of pumps:");
					int numOfPumps = sc.nextInt();
					System.out.print("Please enter a desired number of tills:");
					int numOfTills = sc.nextInt();
					System.out.print("Trucks allowed (true/false)?:");
					boolean trucksAllowed = sc.nextBoolean();
					System.out.print("Please enter a probability for cares and bikes (percentage):");
					double probabilitySmallCarsAndBikes = sc.nextDouble();
					System.out.print("Please enter a probability for family sedans (percentage):");
					double probabilityFamilySedan = sc.nextDouble();
					System.out.print("Please enter a desired simulation duration:");
					int duration = sc.nextInt();		
					System.out.print("Please enter a desired tick duration i.e. how often the simulation will tick:");
					int tickTime = sc.nextInt();
					System.out.print("Please enter a price per gallon (double):");
					double pricePerGallon = sc.nextDouble();	
					System.out.print("Please enter a random seed (number):");
					long randSeed = sc.nextLong();	
					
					ShoppingArea shop = new ShoppingArea(numOfTills);
				    simulation.petrolStation = new PetrolStation(numOfPumps, trucksAllowed, shop,
							pricePerGallon);
					
				    PetrolStationSimulator petrolStationSimulator = new PetrolStationSimulator(simulation.petrolStation, probabilitySmallCarsAndBikes, probabilityFamilySedan, trucksAllowed, randSeed);				    				    
				    
				    Simulator simulator = new Simulator(duration, tickTime, petrolStationSimulator);
					
				 	simulator.startSimulation();			   				    
				    
					// run the simulation
					//simulator.runSimulation();
										
					// output the updated petrol station
					SimulationView.PrintPetrolStationConfiguration(petrolStationSimulator.getResult());
					//SimulationView.RenderCurrentState(petrolStationSimulator.getResult());
					
					
					
					System.out.print("Press any key to exit simulation...");
					sc.nextLine();
					sc.close();

					//window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

//	public void InitializePetrolStation(PetrolStation petrolStation) {
//		Random r = new Random();
//		for(int i = 0; i < petrolStation.GetPumps().length; i++) {
//			//to start, just add one car to each pump
//			petrolStation.GetPumps()[i].Enqueue(new SmallCar());
//			int rand = r.nextInt(2);
//			if(rand > 0) {
//				petrolStation.GetPumps()[i].Enqueue(new Motorbike());
//			}
//			
//		};
//	}	
}
