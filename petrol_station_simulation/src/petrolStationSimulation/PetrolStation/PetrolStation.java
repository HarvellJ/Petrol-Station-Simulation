package petrolStationSimulation.PetrolStation;

public class PetrolStation {

	public PetrolStation() {
		//default values		
	}
	
	public PetrolStation(int numberOfPumps, ShoppingArea shop) {
		pumps = new Pump[numberOfPumps];
		this.shop = shop;
	}
	
	protected Pump[] pumps;	
	protected ShoppingArea shop;
}
