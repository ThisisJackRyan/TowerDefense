import java.util.Scanner;

class Menu {
	public static void intro() {
		Scanner input = new Scanner(System.in);
		System.out.println("Hello And Welcome to my game!!!");
		System.out.println("Please Select an option using the character on the left");
		System.out.println("R || Rules");
		System.out.println("C || Characters");
		System.out.println("P || Play");
		System.out.println("Q || Quit");

		String awnser = input.nextLine();
		CheckAwnser(awnser);
		input.close();
	}

	public static void CheckAwnser(String awnser) {
		Board.clear();
		switch (awnser) {
			case "M":
				System.out.print("No Worky");
				break;
			case "R":
				Rule();
				break;
			case "C":
				Characters();
				break;
			case "P":
			case "p":
				startGame();
				break;
			case "Q":
				System.exit(0);
				break;
			default:
				intro();
				break;
		}
	}

	public static void startGame() {
		Board b = new Board();
		b.printBoard();
	}

	public static void Rule() {
		System.out.println("The rules for the game is as follow: ");
		System.out.println(" -- You start the Game with 30 Gold each character cost 30 gold.");
		System.out.println(" -- Every Kill gives you fifteen Gold. ");
		System.out.println(" -- You also get 5 for skipping a round.");
		System.out.println(" -- But be carful if the Monsters get to the end of the yard you LOSE!!!!");
	}

	public static void Characters() {
		System.out.println("These are the Characters");
		System.out.println("🤖 -- The Robot kills Zombie");
		System.out.println("👮-- The Cop kills Vampire");
		System.out.println("💂 -- The Royal Guard kills both Zombie and Devil But dies trying");
		System.out.println("🧞 -- The Genie kills both Vampire and Devil but dies trying");
		System.out.println("💃 -- The Dancer Kills Devil");

	}
}