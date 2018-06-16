package petrolStationSimulation.PetrolStation;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class ShoppingArea {

	public ShoppingArea() {
		
	}
	
	public ShoppingArea(int amountOfTills) {
		setTills(new Till[amountOfTills]);
		initialize();
	}
	
	public Item[] getStock() {
		return stock;
	}

	public void setStock(Item[] stock) {
		this.stock = stock;
	}

	public Till[] getTills() {
		return tills;
	}

	public void setTills(Till[] tills) {
		this.tills = tills;
	}

	private Item[] stock;
	private Till[] tills; // dont really need to be shown unless simulation is running
	private JTextField txt_tillNum;
	private JTextField txt_totalSA;
	private JTextField txt_purchaseSA;
	private JTextField txt_customerSA;
	public JPanel panel_shopping_area;
	
	public void initialize() {
		panel_shopping_area = new JPanel();
		panel_shopping_area.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_shopping_area.setBounds(10, 92, 288, 228);
		panel_shopping_area.setLayout(null);		
		
		txt_tillNum = new JTextField();
		txt_tillNum.setEditable(false);
		txt_tillNum.setBounds(25, 59, 222, 20);
		panel_shopping_area.add(txt_tillNum);
		txt_tillNum.setColumns(10);
		txt_tillNum.setText(String.valueOf(tills.length));
		
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
	}
	
	
}
