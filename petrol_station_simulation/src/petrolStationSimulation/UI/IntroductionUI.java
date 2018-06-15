package petrolStationSimulation.UI;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

//Factory class - sets up an introducton form instance
public class IntroductionUI {
	
	public IntroductionUI() {
		InitializeForm();
	}
	
		private JFrame frameIntroduction;
	    public JLabel lbl_numOfPumps;
		public JTextField txt_numOfPumps;
		public JLabel lbl_numOfTills;
		public JTextField txt_numOfTills;
		public JLabel lbl_trucksEnabled;
		public JCheckBoxMenuItem chk_trucksEnabled;
		public JButton btn_startButton;
		

		private void InitializeForm() {
	       frameIntroduction = UIHelper.initializeStandardFrame();
	        
		   btn_startButton = UIHelper.createStandardButton("Start");
		   frameIntroduction.add(btn_startButton);
	        
	       txt_numOfPumps.setEditable(true);
	       txt_numOfTills.setEditable(true);
	       lbl_numOfPumps.setText("Number of Pumps:");
	       lbl_numOfTills.setText("Number of Tills:");    
	       lbl_trucksEnabled.setText("Enable Trucks?");
		}


		public JFrame getForm() {
			return frameIntroduction;
		}
	
}
