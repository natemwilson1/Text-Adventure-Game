import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		boolean gameLoop = true;
		Scanner keyboard = new Scanner(System.in);
		char command;
		String playerName;
		
		// create rooms 
		Room library = new Room("library", "That's alot of books.");
		Room kitchen = new Room("kitchen", "Why is no one cooking in here?");
		Room livingRoom = new Room("living room", "There's only one chair in the center of the room...");
		Room diningRoom = new Room("dining room", "There's no one at the dinner table...");
		
		// set rooms relation to each other
		library.setEast(kitchen);
		library.setSouth(livingRoom);
		library.setNorth(null);
		library.setWest(null);
		
		kitchen.setEast(null);
		kitchen.setNorth(null);
		kitchen.setWest(library);
		kitchen.setSouth(diningRoom);
		
		livingRoom.setEast(diningRoom);
		livingRoom.setNorth(library);
		livingRoom.setWest(null);
		livingRoom.setSouth(null);
		
		diningRoom.setEast(null);
		diningRoom.setNorth(kitchen);
		diningRoom.setWest(livingRoom);
		diningRoom.setSouth(null);
		
		// get player name
		System.out.print("What is your name? ");
		playerName = keyboard.nextLine();
		Player player1 = new Player(playerName , diningRoom);
		
		System.out.println("Welcome to this house " + player1.getName() + " feel free to wander around...");
		System.out.println("You are currently in the "+ player1.getLocation().getName()+".");
		System.out.println("Enter a direction (N)orth, (S)outh, (E)ast, (W)est, or (R) to read the description of the room your are in.");
		System.out.println("Enter (D) to end the game...");
		System.out.print(">> ");
				
		while (gameLoop == true) {
			
			command = getCommand(keyboard);
			while (command != 'n' && command != 's' && command !='w' && command != 'e' && command != 'r' && command != 'd' ) {
				printDirections();
				command = getCommand(keyboard);
			}
			
			player1.playerAction(command);
			
			if (player1.isLiving() == false) {
				System.out.println();
				System.out.println("RIP " + player1.getName()+"...");
				System.out.println(" ___ ");
				System.out.println("/ + \\");
				System.out.println("| "  + player1.getName().charAt(0)+ " |");
				System.out.println("-----");
				gameLoop = false;
			
			} else if (player1.getMoney() == 5) {
					System.out.println();
					System.out.println("Well you found $5 you might as well go home.");
					System.out.println("Goodbye " + player1.getName()+ "!");
					gameLoop = false;
				} else {
				System.out.print(">> ");
			}
		}	
	}
	
	public static char getCommand(Scanner keyboard) {
		char command;
		String input;
		
		input = keyboard.nextLine();
		while (input.isEmpty()) {
			printDirections();
			input = keyboard.nextLine();
		} 
		
		command = input.charAt(0);
		command = Character.toLowerCase(command);
		return command;
	}
	
	public static void printDirections() {
		System.out.println("Enter a direction (N)orth, (S)outh, (E)ast, (W)est, or (R) to read the description of the room your are in.");
		System.out.print(">> ");
	}
}
