package petrolStationSimulation.PetrolStation;

public class ShoppingArea {

	public ShoppingArea() {
		
	}
	
	public ShoppingArea(int amountOfStock, int amountOfTills) {
		setStock(new Item[amountOfStock]);
		setTills(new Till[amountOfTills]);
		
	}
	
	public Item[] getStock() {
		return stock;
	}

	public void setStock(Item[] stock) {
		this.stock = stock;
	}

	public Till[] getTills() {
		return tills;
	}

	public void setTills(Till[] tills) {
		this.tills = tills;
	}

	private Item[] stock;
	private Till[] tills;
	
}
