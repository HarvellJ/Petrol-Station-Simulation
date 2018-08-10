package simulator;

public interface ISimulationObject {

	/**
	 * This method represents the action that will be taken each time the simulator loops around
	 * @param tickTime An int used to age items in simulation
	 */
	void tick(int tickTime);
		
}
