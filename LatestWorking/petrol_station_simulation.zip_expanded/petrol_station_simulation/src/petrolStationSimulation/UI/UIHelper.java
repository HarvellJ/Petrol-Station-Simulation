package petrolStationSimulation.UI;

import javax.swing.JButton;
import javax.swing.JFrame;

import petrolStationSimulation.PetrolStation.Pump;
import petrolStationSimulation.PetrolStation.ShoppingArea;

public class UIHelper {

	public static JButton createStandardButton(String text) {
		JButton button = new JButton(text);
		button.setBounds(130, 100, 100, 40);
		return button;
	}
	
	
	
	
	
}
