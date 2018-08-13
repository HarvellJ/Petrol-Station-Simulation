package petrolStationSimulation.Person;

public class Person {

	private boolean isHappy; // used to determine the user's actions
	private boolean isInVehicle; // used to determine if the person is in a vehicle
	
	public Person() {
		this.isInVehicle = true;
	}

	public boolean isHappy() {
		return isHappy;
	}

	public void setHappy(boolean isHappy) {
		this.isHappy = isHappy;
	}

	public boolean isInVehicle() {
		return isInVehicle;
	}

	public void setInVehicle(boolean isInVehicle) {
		this.isInVehicle = isInVehicle;
	}
	
	
}
