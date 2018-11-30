public class Player {
	private String name;
	private Room location;
	private boolean alive = true;
	private int money;
	
	public Player(String name, Room location ) {
		this.name = name;
		this.location = location;
	}

	public String getName() {
		return this.name;
	}
	
	public Room getLocation() {
		return this.location;
	}
	
	public int getMoney() {
		return this.money;
	}
	
	public void playerAction(char command) {
		
		if (command == 'n'){ 
			if (location.getNorth() == null)
				System.out.println("You cant go that direction... Try a different direction: ");
			else {
				location = location.getNorth();
				System.out.println("You moved north into the " + location.getName()+ ".");
				if(!this.isPoisoned())
					this.foundMoney();
			}
		}
		
		if (command == 's'){ 
			if (location.getSouth() == null)
				System.out.println("You cant go that direction...Try a different direction: ");
			else {
				location = location.getSouth();
				System.out.println("You moved south into the " + location.getName()+ ".");
				if(!this.isPoisoned())
					this.foundMoney();
			}
		}
		
		if (command == 'e'){ 
			if (location.getEast() == null)
				System.out.println("You cant go that direction...Try a different direction: ");
			else {
				location = location.getEast();
				System.out.println("You moved east into the " + location.getName()+ ".");
				if(!this.isPoisoned())
					this.foundMoney();
			}
		}
		
		if (command == 'w'){ 
			if (location.getWest() == null)
				System.out.println("You cant go that direction...Try a different direction: ");
			else {
				location = location.getWest();
				System.out.println("You moved west into the " + location.getName()+ ".");
				if(!this.isPoisoned())
					this.foundMoney();
			}
		}
		
		if (command == 'r') {
			System.out.println(this.location.getDescription());
		}
		
		if (command == 'd') {
			System.out.println("You died of boredom...GAME OVER...");
			this.alive = false;
		}
	}
	
	public  boolean isLiving() {
		return this.alive; 
	}
	
	public boolean isPoisoned() {
		boolean isPoisoned = false;
		
		if(this.location.hasPoisonGas()) {
			System.out.println("You died from the gas...");
			this.alive = false;
			isPoisoned = true;
		}
		return isPoisoned;
	}
	
	public void foundMoney() {
		if(this.location.hasDollar()) {
			money++;
			System.out.println("You have $" + this.getMoney()+"!" );
		}
	}
}

