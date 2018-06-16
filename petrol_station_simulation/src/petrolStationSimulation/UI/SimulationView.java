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
	
	public SimulationView(PetrolStation petrolStation) {
		this.petrolStation = petrolStation;
		initializeForm();
	}
	
		private PetrolStation petrolStation;
	
	    // petrol station page
		private JFrame framePetrolStation;
	
		private JTextField txt_totalT;
		private JTextField txt_fuelLosses;
		private JTextField txt_shopLosses;
	
    public void RefreshUI() {
    	// go through the petrol station model and update the simulation ui
    }
		
	/**
	 * Initialize the contents of the frame.
	 */
	private void initializeForm() {
		framePetrolStation = UIHelper.initializeStandardFrame();
		
		// add shopping area
		framePetrolStation.getContentPane().add(petrolStation.Shop().panel_shopping_area);

	
		
		JPanel panel_fueling_area = new JPanel();
		panel_fueling_area.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_fueling_area.setBounds(10, 329, 607, 311);
		framePetrolStation.getContentPane().add(panel_fueling_area);
		panel_fueling_area.setLayout(null);
		
		// add pumps to form
		for(Pump pump : petrolStation.Pumps()) {	
			panel_fueling_area.add(pump.panel_pump);
		}
				
		
		// build up remainder of form - simulation information labels etc...		
		JPanel panel_total = new JPanel();
		panel_total.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_total.setBounds(329, 92, 288, 228);
		framePetrolStation.getContentPane().add(panel_total);
		panel_total.setLayout(null);
		
		txt_totalT = new JTextField();
		txt_totalT.setEditable(false);
		txt_totalT.setColumns(10);
		txt_totalT.setBounds(25, 61, 222, 20);
		panel_total.add(txt_totalT);
		
		txt_fuelLosses = new JTextField();
		txt_fuelLosses.setEditable(false);
		txt_fuelLosses.setColumns(10);
		txt_fuelLosses.setBounds(25, 123, 222, 20);
		panel_total.add(txt_fuelLosses);
		
		txt_shopLosses = new JTextField();
		txt_shopLosses.setEditable(false);
		txt_shopLosses.setColumns(10);
		txt_shopLosses.setBounds(25, 186, 222, 20);
		panel_total.add(txt_shopLosses);
		
		JLabel lblTotalTake_1 = new JLabel("Total Take:");
		lblTotalTake_1.setBounds(25, 45, 97, 14);
		panel_total.add(lblTotalTake_1);
		
		JLabel lblFuelSaleLosses = new JLabel("Fuel Sale Losses:");
		lblFuelSaleLosses.setBounds(25, 106, 97, 14);
		panel_total.add(lblFuelSaleLosses);
		
		JLabel lblShopSaleLosses = new JLabel("Shop Sale Losses:");
		lblShopSaleLosses.setBounds(25, 172, 97, 14);
		panel_total.add(lblShopSaleLosses);
		
		JLabel lblTotal = new JLabel("Totals");
		lblTotal.setBounds(113, 11, 50, 14);
		panel_total.add(lblTotal);
		
		JPanel panel_config = new JPanel();
		panel_config.setBounds(26, 11, 580, 70);
		framePetrolStation.getContentPane().add(panel_config);
		panel_config.setLayout(null);
		
		JRadioButton rdo_enableTruck = new JRadioButton("< Enable Trucks");
		rdo_enableTruck.setBounds(73, 7, 192, 23);
		panel_config.add(rdo_enableTruck);
		
		JRadioButton rdo_simulsettings = new JRadioButton("< Simulation Settings");
		rdo_simulsettings.setBounds(73, 36, 249, 23);
		panel_config.add(rdo_simulsettings);
		
		JButton btn_Play = new JButton("Play");
		btn_Play.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btn_Play.setBounds(271, 7, 89, 23);
		panel_config.add(btn_Play);
		
		JButton btn_Pause = new JButton("Pause");
		btn_Pause.setBounds(370, 7, 89, 23);
		panel_config.add(btn_Pause);
		
		JButton btn_Stop = new JButton("Stop");
		btn_Stop.setBounds(469, 7, 89, 23);
		panel_config.add(btn_Stop);		
		
	}
	
	public JFrame GetForm(){
		return framePetrolStation;
	}	
}
