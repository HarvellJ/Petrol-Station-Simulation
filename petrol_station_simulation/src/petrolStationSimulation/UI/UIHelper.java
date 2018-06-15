package petrolStationSimulation.UI;

import javax.swing.JButton;
import javax.swing.JFrame;

public class UIHelper {

	public static JButton createStandardButton(String text) {
		JButton button = new JButton(text);
		button.setBounds(130, 100, 100, 40);
		return button;
	}
	
	public static JFrame initializeStandardFrame() {
		// use this method to declare a consistent frame
		JFrame frame = new JFrame();
		frame.setBounds(100, 100, 643, 690);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		return frame;
	}
	
}
