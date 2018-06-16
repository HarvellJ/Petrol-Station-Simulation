package petrolStationSimulation.PetrolStation;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import petrolStationSimulation.Vehicle.Vehicle;

public class Pump implements IPump{

	public Pump(int posY, int posX) {
		queue = new ArrayList<Vehicle>();
		initialize(posY, posX);
	}
	
	private JTextField txt_pump;
	private JTextField txt_customer;
	private JTextField txt_queue;
	public JPanel panel_pump;
	
	private ArrayList<Vehicle> queue;
	
	public void Enqueue(Vehicle vehicle) {
		queue.add(vehicle);
	}
	
	public void Dequeue(Vehicle vehicle) {
		queue.remove(0);
	}
	
	public void initialize(int positionY, int positionX) {
		panel_pump = new JPanel();
		panel_pump.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_pump.setBounds(positionX, positionY, 50, 50);
		panel_pump.setLayout(null);			
		
	}
	
}
