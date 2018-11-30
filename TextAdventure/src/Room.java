import java.util.Random;

public class Room {
	private String name;
	private String description;
	private Room north;
	private Room south;
	private Room east;
	private Room west;
	
	
	public Room(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	public void setNorth(Room room) {
		this.north = room;
	}
	
	public void setSouth(Room room) {
		this.south = room;
	}
	
	public void setEast(Room room) {
		this.east = room;
	}
	
	public void setWest(Room room) {
		this.west = room;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public Room getNorth() {
		return this.north;
	}
	
	public Room getSouth() {
		return this.south;
	}
	
	public Room getEast() {
		return this.east;
	}
	
	public Room getWest() {
		return this.west;
	}
	
	public boolean hasPoisonGas() {
		int random;
		boolean hasPoisonGas;
		
		Random randNum = new Random();
		random = randNum.nextInt(12) + 1;
		if(random == 6) {
			hasPoisonGas = true; 
			System.out.println("Oh no poison gas!");
		} else {
			hasPoisonGas = false;
		}
		return hasPoisonGas;
	}
	
	public boolean hasDollar() {
		int random;
		boolean hasDollar;
		Random randNum = new Random();
		random = randNum.nextInt(5)+1;
		if(random == 3) {
			hasDollar = true;
			System.out.println("You found a dollar on the floor!");
		} else {
			hasDollar = false;
		}
		return hasDollar;
	}
}
