package petrolStationSimulation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import petrolStationSimulation.UI.IntroductionUI;
import petrolStationSimulation.UI.PetrolStationUI;

import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class PetrolStationSimulation {

	public int numberOfPumps;
	public int numberOfTills;
	public boolean trucksAllowed;
	public IntroductionUI introductionForm;
	public PetrolStationUI petrolStationForm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PetrolStationSimulation simulation = new PetrolStationSimulation();
					
				    
					//simulation.introductionForm.setVisible(true);
					

					//window.frame.setVisible(true);
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
		introductionForm = new IntroductionUI();
	    introductionForm.btn_startButton.addActionListener(new StartClick());
	}
	
	private class StartClick extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
        	// check for presence of form values - if none present, just use default constructor
        	introductionForm.GetForm().setVisible(false);
        	petrolStationForm = introductionForm.IsValid() ?
        			new PetrolStationUI(Integer.parseInt(introductionForm.txt_numOfPumps.getText()), 
        					            Integer.parseInt(introductionForm.txt_numOfTills.getText()), 
        					            introductionForm.chk_trucksEnabled.isSelected()) : new PetrolStationUI();
    	
        }
    }
}
