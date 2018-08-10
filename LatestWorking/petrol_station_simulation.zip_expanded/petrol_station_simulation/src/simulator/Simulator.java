package simulator;

import java.util.Timer;
import java.util.TimerTask;

import petrolStationSimulation.UI.SimulationView;

public class Simulator {

	private int duration;
	private int tickTime;
	private ISimulationObject simulationObject;
	
	private int secondsPassed = 0;
	
    Timer timer = new Timer();
    TimerTask task = new TimerTask() {				    	
    	public void run() { 	
    		if(secondsPassed<duration) {
    		secondsPassed++;
    		System.out.println("Seconds passed: " + secondsPassed);
    		if(secondsPassed%tickTime==0) {
        		simulationObject.tick(tickTime);
    			System.out.println(" tick activated");
    		}
    		}
    		else {
    			System.out.println("Simulation timer finished, ending simulation...");
    			   timer.cancel();
    		       timer.purge();
    		}
    	}
    };
	
	public Simulator(int duration, int tickTime, ISimulationObject simulationObject) {
		this.duration = duration;
		this.tickTime = tickTime;
		this.simulationObject = simulationObject;
	}
	
	public void startSimulation() {
		//this.timer.scheduleAtFixedRate(task, 1000, 1000);
		for(int i = 0; i < duration; i++) {
			if(secondsPassed<duration) {
				secondsPassed++;
				System.out.println("Seconds passed: " + secondsPassed);
				if(secondsPassed%tickTime==0) {
					simulationObject.tick(tickTime);
					System.out.println(" tick activated");
				}
			}
			else {
				System.out.println("Simulation timer finished, ending simulation...");	    
			}
		}
	}
	
	
}
