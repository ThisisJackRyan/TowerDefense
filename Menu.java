import java.util.Scanner;

class Menu {
	public static void intro(){
		Scanner input = new Scanner(System.in);
		System.out.println("Hello And Welcome to my game!!!");
		System.out.println("Please Select an option using the character on the rigth");
		System.out.println("Menu: M");
		System.out.println("Rules: R");
		System.out.println("Characters: C");
		System.out.println("Play: P");

		String awnser = input.nextLine();
		CheckAwnser(awnser);
	}

	public static void CheckAwnser(String awnser){
		switch(awnser){
			case "M": System.out.print("No Worky");break;
			case "R": Rule(); break;
			case "C": Characters(); break;
			case "P": startGame();break;
		}
	}

	public static void startGame(){
		Board.printBoard();
	}

	public static void Rule(){
		System.out.print("The rules for the game is as follow");
	}

	public static void Characters(){
		System.out.println("These are the Characters");
	}
}