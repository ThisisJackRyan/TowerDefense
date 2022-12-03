
import java.util.Scanner;

class Menu {
	public static void intro() {
		Scanner input = new Scanner(System.in);
		System.out.println("Hello And Welcome to my game!!!");
		System.out.println("Please Select an option using the character on the left");
		System.out.println("M || Menu");
		System.out.println("R || Rules");
		System.out.println("C || Characters");
		System.out.println("P || Play");
		System.out.println("Q || Quit");

		String awnser = input.nextLine();
		CheckAwnser(awnser);
	}

	public static void CheckAwnser(String awnser) {
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
		System.out.print("The rules for the game is as follow");
	}

	public static void Characters() {
		System.out.println("These are the Characters");
		System.out.println("🥷 -- The Ninja Throws Cards At Zombies in Same Lane Ninja is placed");
		System.out.println("👮‍♂️ -- Cop Uses flashlight to Kill Vanpires");
		System.out.println("💂 -- One use only but marchs on all monsters in the row");
		System.out.println("🧞‍♂️ -- takes away devil's ability ot explode ");
		System.out.println("👨‍🎤 -- cheap but very weak attack");

		
		System.out.println("👹 -- devil explodes after eating good guys");
		System.out.println("🧟‍♂️ -- Zombie is trying to get you bites hard but is very weak");
		System.out.println("🧛🏻‍♂️ -- Vampire is trying to get you but is scared of light");
	}
}