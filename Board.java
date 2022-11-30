import java.util.Scanner;
class Board {
	public static final String reset = "\u001b[0m";
	public static final String green = "\u001b[46m";
	public static final String lightGreen = "\u001b[42m";
	


	
	public static void printBoard() {
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 9; j++) {
				if(i % 2 == 0) {
					System.out.print(green);
					System.out.print("   ");
					System.out.print(lightGreen);
					System.out.print("   ");
				} else {
					System.out.print(lightGreen);
					System.out.print("   ");
					System.out.print(green);
					System.out.print("   ");
				}
			}
			System.out.println("");
		}
		System.out.println(reset);
	}
}