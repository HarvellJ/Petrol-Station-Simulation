package petrolStationSimulation.PetrolStation;

public class PetrolStation {

	public PetrolStation() {
		//default values		
	}
	
	public PetrolStation(int numberOfPumps, boolean trucksAllowed, ShoppingArea shop) {
		pumps = new Pump[numberOfPumps];
		this.shop = shop;
		SetupPumps();
	}
	
	protected Pump[] pumps;	
	protected ShoppingArea shop;
	protected boolean trucksAllowed;
	
	public ShoppingArea Shop() {
		return shop;
	}
	
	public Pump[] Pumps() {
		return pumps;
	}
	
	public void SetupPumps() {
		// positions to space pumps apart
		int currentX = 0;
		int currentY = 10;
		for(int i = 0; i < pumps.length; i++) {
			pumps[i] = new Pump(currentX, currentY);
			currentX =+ 50;
			if(currentX - 200 == 0) {
				currentX = 0;
				currentY += 60;
			}
		}
	}
}
