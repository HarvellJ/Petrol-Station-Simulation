package petrolStationSimulation.PetrolStation;

public class PetrolStation {

	public PetrolStation() {
		//default values		
	}
	
	public PetrolStation(int numberOfPumps, boolean trucksAllowed, ShoppingArea shop, int probabilityQ, 
			int probabilityP, double pricePerGallon, int simulationDuration) {
		pumps = new Pump[numberOfPumps];
		initializePumps();
		this.shop = shop;
		this.trucksAllowed = trucksAllowed;
		this.simulationDuration = simulationDuration;
		this.probabilityQ = probabilityQ;
		this.probabilityP = probabilityP;
		this.pricePerGallon = pricePerGallon;
	}
	
	private ShoppingArea shop;
	private Pump[] pumps;	
	private boolean trucksAllowed;
	private double probabilityQ;
	private double probabilityP;
	private double pricePerGallon;
	private int simulationDuration;
	
	private void initializePumps() {
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
	

	public double getProbabilityQ() {
		return probabilityQ;
	}

	public void setProbabilityQ(double probabilityQ) {
		this.probabilityQ = probabilityQ;
	}

	public double getProbabilityP() {
		return probabilityP;
	}

	public void setProbabilityP(double probabilityP) {
		this.probabilityP = probabilityP;
	}

	public double getPricePerGallon() {
		return pricePerGallon;
	}

	public void setPricePerGallon(double pricePerGallon) {
		this.pricePerGallon = pricePerGallon;
	}

	public int getSimulationDuration() {
		return simulationDuration;
	}

	public void setSimulationDuration(int simulationDuration) {
		this.simulationDuration = simulationDuration;
	}
	
}
