package simulator;

/**
 * Defines the interface for a simulation object
 */
public interface ISimulationObject {

	/**
	 * This method represents the action that will be taken each time the simulator loops around
	 * @param tickTime An int used to age items in simulation
	 */
	void tick(int tickTime);
		
	/**
	 * This method writes the results of the simulationObject to a file
	 */
	void writeResultToFile();
}
