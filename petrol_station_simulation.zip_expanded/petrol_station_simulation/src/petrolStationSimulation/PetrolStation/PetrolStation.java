package petrolStationSimulation.PetrolStation;

public class PetrolStation {

	public PetrolStation() {
		//default values		
	}
	
	public PetrolStation(int numberOfPumps, boolean trucksAllowed, ShoppingArea shop,
			double pricePerGallon) {
		pumps = new Pump[numberOfPumps];
		InitializePumps();
		this.shop = shop;
		this.trucksAllowed = trucksAllowed;
		this.pricePerGallon = pricePerGallon;
	}
	
	private ShoppingArea shop;
	private Pump[] pumps;	
	private boolean trucksAllowed;
	private double pricePerGallon;
	
	private void InitializePumps() {
		for(int i = 0; i < pumps.length; i++) {
			pumps[i] = new Pump();
		}
	}
	
	public ShoppingArea GetShop() {
		return shop;
	}
	
	public Pump[] GetPumps() {
		return pumps;
	}
	
	public boolean TrucksAllowed() {
		return trucksAllowed;
	}
	

	public double getPricePerGallon() {
		return pricePerGallon;
	}

	public void setPricePerGallon(double pricePerGallon) {
		this.pricePerGallon = pricePerGallon;
	}
	
	public Pump getPumpWithShortestQueue() {
		Pump shortestQueuedPump = pumps[0]; //Default to first pump 
		for(Pump pump : pumps) {
			if(shortestQueuedPump.getQueue().size() > pump.getQueue().size()) {
				shortestQueuedPump = pump;
			}
		}
		return shortestQueuedPump;
	}
	
}
