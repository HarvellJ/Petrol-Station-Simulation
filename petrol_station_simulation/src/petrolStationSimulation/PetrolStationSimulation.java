package petrolStationSimulation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class PetrolStationSimulation {

	private JFrame frame;
	private JTextField txt_totalSA;
	private JTextField txt_purchaseSA;
	private JTextField txt_customerSA;
	private JTextField txt_totalT;
	private JTextField txt_fuelLosses;
	private JTextField txt_shopLosses;
	private JTextField txt_fuelP1;
	private JTextField txt_customerP1;
	private JTextField txt_queueP1;
	private JTextField txt_fuelP2;
	private JTextField txt_customerP2;
	private JTextField txt_queueP2;
	private JTextField txt_fuelP3;
	private JTextField txt_customerP3;
	private JTextField txt_queueP3;
	private JTextField txt_fuelP4;
	private JTextField txt_customerP4;
	private JTextField txt_queueP4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PetrolStationSimulation window = new PetrolStationSimulation();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PetrolStationSimulation() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 643, 690);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel_shopping_area = new JPanel();
		panel_shopping_area.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_shopping_area.setBounds(10, 92, 288, 228);
		frame.getContentPane().add(panel_shopping_area);
		panel_shopping_area.setLayout(null);
		
		txt_totalSA = new JTextField();
		txt_totalSA.setEditable(false);
		txt_totalSA.setBounds(25, 59, 222, 20);
		panel_shopping_area.add(txt_totalSA);
		txt_totalSA.setColumns(10);
		
		txt_purchaseSA = new JTextField();
		txt_purchaseSA.setEditable(false);
		txt_purchaseSA.setColumns(10);
		txt_purchaseSA.setBounds(25, 120, 222, 20);
		panel_shopping_area.add(txt_purchaseSA);
		
		txt_customerSA = new JTextField();
		txt_customerSA.setEditable(false);
		txt_customerSA.setColumns(10);
		txt_customerSA.setBounds(25, 186, 222, 20);
		panel_shopping_area.add(txt_customerSA);
		
		JLabel lblTotalTake = new JLabel("Total Take:");
		lblTotalTake.setBounds(25, 42, 91, 14);
		panel_shopping_area.add(lblTotalTake);
		
		JLabel lblPurchase = new JLabel("Purchase:");
		lblPurchase.setBounds(25, 103, 91, 14);
		panel_shopping_area.add(lblPurchase);
		
		JLabel lblCustomer = new JLabel("Customer:");
		lblCustomer.setBounds(25, 170, 91, 14);
		panel_shopping_area.add(lblCustomer);
		
		JLabel lblShoppingArea = new JLabel("Shopping Area");
		lblShoppingArea.setBounds(98, 11, 70, 14);
		panel_shopping_area.add(lblShoppingArea);
		
		JPanel panel_total = new JPanel();
		panel_total.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_total.setBounds(329, 92, 288, 228);
		frame.getContentPane().add(panel_total);
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
		
		JPanel panel_fueling_area = new JPanel();
		panel_fueling_area.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_fueling_area.setBounds(10, 329, 607, 311);
		frame.getContentPane().add(panel_fueling_area);
		panel_fueling_area.setLayout(null);
		
		JPanel panel_pump1 = new JPanel();
		panel_pump1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_pump1.setBounds(25, 27, 262, 131);
		panel_fueling_area.add(panel_pump1);
		panel_pump1.setLayout(null);
		
		txt_fuelP1 = new JTextField();
		txt_fuelP1.setEditable(false);
		txt_fuelP1.setBounds(89, 38, 149, 20);
		panel_pump1.add(txt_fuelP1);
		txt_fuelP1.setColumns(10);
		
		txt_customerP1 = new JTextField();
		txt_customerP1.setEditable(false);
		txt_customerP1.setBounds(89, 69, 149, 20);
		panel_pump1.add(txt_customerP1);
		txt_customerP1.setColumns(10);
		
		txt_queueP1 = new JTextField();
		txt_queueP1.setEditable(false);
		txt_queueP1.setBounds(89, 100, 149, 20);
		panel_pump1.add(txt_queueP1);
		txt_queueP1.setColumns(10);
		
		JLabel lblFuelTaken = new JLabel("Fuel Taken:");
		lblFuelTaken.setBounds(10, 41, 69, 14);
		panel_pump1.add(lblFuelTaken);
		
		JLabel lblCustomer_1 = new JLabel("Customer:");
		lblCustomer_1.setBounds(10, 72, 69, 14);
		panel_pump1.add(lblCustomer_1);
		
		JLabel lblQueue = new JLabel("Queue:");
		lblQueue.setBounds(10, 103, 69, 14);
		panel_pump1.add(lblQueue);
		
		JLabel lblPump = new JLabel("Pump 1");
		lblPump.setBounds(93, 11, 46, 14);
		panel_pump1.add(lblPump);
		
		JPanel panel_pump2 = new JPanel();
		panel_pump2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_pump2.setLayout(null);
		panel_pump2.setBounds(323, 27, 262, 131);
		panel_fueling_area.add(panel_pump2);
		
		txt_fuelP2 = new JTextField();
		txt_fuelP2.setEditable(false);
		txt_fuelP2.setColumns(10);
		txt_fuelP2.setBounds(89, 38, 149, 20);
		panel_pump2.add(txt_fuelP2);
		
		txt_customerP2 = new JTextField();
		txt_customerP2.setEditable(false);
		txt_customerP2.setColumns(10);
		txt_customerP2.setBounds(89, 69, 149, 20);
		panel_pump2.add(txt_customerP2);
		
		txt_queueP2 = new JTextField();
		txt_queueP2.setEditable(false);
		txt_queueP2.setColumns(10);
		txt_queueP2.setBounds(89, 100, 149, 20);
		panel_pump2.add(txt_queueP2);
		
		JLabel label = new JLabel("Fuel Taken:");
		label.setBounds(10, 41, 69, 14);
		panel_pump2.add(label);
		
		JLabel label_1 = new JLabel("Customer:");
		label_1.setBounds(10, 72, 69, 14);
		panel_pump2.add(label_1);
		
		JLabel label_2 = new JLabel("Queue:");
		label_2.setBounds(10, 103, 69, 14);
		panel_pump2.add(label_2);
		
		JLabel lblPump_1 = new JLabel("Pump 2");
		lblPump_1.setBounds(93, 11, 46, 14);
		panel_pump2.add(lblPump_1);
		
		JPanel panel_pump3 = new JPanel();
		panel_pump3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_pump3.setLayout(null);
		panel_pump3.setBounds(25, 169, 262, 131);
		panel_fueling_area.add(panel_pump3);
		
		txt_fuelP3 = new JTextField();
		txt_fuelP3.setEditable(false);
		txt_fuelP3.setColumns(10);
		txt_fuelP3.setBounds(89, 38, 149, 20);
		panel_pump3.add(txt_fuelP3);
		
		txt_customerP3 = new JTextField();
		txt_customerP3.setEditable(false);
		txt_customerP3.setColumns(10);
		txt_customerP3.setBounds(89, 69, 149, 20);
		panel_pump3.add(txt_customerP3);
		
		txt_queueP3 = new JTextField();
		txt_queueP3.setEditable(false);
		txt_queueP3.setColumns(10);
		txt_queueP3.setBounds(89, 100, 149, 20);
		panel_pump3.add(txt_queueP3);
		
		JLabel label_3 = new JLabel("Fuel Taken:");
		label_3.setBounds(10, 41, 69, 14);
		panel_pump3.add(label_3);
		
		JLabel label_4 = new JLabel("Customer:");
		label_4.setBounds(10, 72, 69, 14);
		panel_pump3.add(label_4);
		
		JLabel label_5 = new JLabel("Queue:");
		label_5.setBounds(10, 103, 69, 14);
		panel_pump3.add(label_5);
		
		JLabel lblPump_2 = new JLabel("Pump 3");
		lblPump_2.setBounds(93, 11, 46, 14);
		panel_pump3.add(lblPump_2);
		
		JPanel panel_pump4 = new JPanel();
		panel_pump4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_pump4.setLayout(null);
		panel_pump4.setBounds(323, 169, 262, 131);
		panel_fueling_area.add(panel_pump4);
		
		txt_fuelP4 = new JTextField();
		txt_fuelP4.setEditable(false);
		txt_fuelP4.setColumns(10);
		txt_fuelP4.setBounds(89, 38, 149, 20);
		panel_pump4.add(txt_fuelP4);
		
		txt_customerP4 = new JTextField();
		txt_customerP4.setEditable(false);
		txt_customerP4.setColumns(10);
		txt_customerP4.setBounds(89, 69, 149, 20);
		panel_pump4.add(txt_customerP4);
		
		txt_queueP4 = new JTextField();
		txt_queueP4.setEditable(false);
		txt_queueP4.setColumns(10);
		txt_queueP4.setBounds(89, 100, 149, 20);
		panel_pump4.add(txt_queueP4);
		
		JLabel label_6 = new JLabel("Fuel Taken:");
		label_6.setBounds(10, 41, 69, 14);
		panel_pump4.add(label_6);
		
		JLabel label_7 = new JLabel("Customer:");
		label_7.setBounds(10, 72, 69, 14);
		panel_pump4.add(label_7);
		
		JLabel label_8 = new JLabel("Queue:");
		label_8.setBounds(10, 103, 69, 14);
		panel_pump4.add(label_8);
		
		JLabel lblPump_3 = new JLabel("Pump 4");
		lblPump_3.setBounds(93, 11, 46, 14);
		panel_pump4.add(lblPump_3);
		
		JPanel panel_config = new JPanel();
		panel_config.setBounds(26, 11, 580, 70);
		frame.getContentPane().add(panel_config);
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
}
