import java.util.Scanner;
class Board {
	public static final String reset = "\u001b[0m";
	public static final String green = "\u001b[46m";
	public static final String lightGreen = "\u001b[42m";
	public static final int valueOfChar = 97;
	public static final String ninja = "🥷";
	
	
	public Board(){
	}

	
	public void printBoard(String x, String y) {

		for (int i = 0; i < 7; i++) {
			System.out.print((char)(valueOfChar + i));
			System.out.print(" ");
			for (int j = 0; j < 18; j++) {
				if(i % 2 == 0) {
					if(j % 2 == 0){
						System.out.print(green);
						System.out.print("   ");
					}else{
						System.out.print(lightGreen);
						System.out.print("   ");
					}
				} else {
					if(j % 2 == 0){
						System.out.print(lightGreen);
						System.out.print("   ");
					} else{
						System.out.print(green);
						System.out.print("   ");
					}
				}
				System.out.print(Integer.toString(i+97));
				if(y.equals(Integer.toString(i+97)) && x.equals(Integer.toString(j))){
					System.out.print("Y: "+ i +" X: " + j);
				}
			}
			System.out.print(reset);
			System.out.println("");
		}
		System.out.print(reset);
		System.out.println("   1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18");
		Play();
	}

	public void Play(){
		Scanner input = new Scanner(System.in);
		System.out.println("Where would you like to place your character? (Please put number first");
		String loc = input.nextLine();
		if(loc.length() > 2){
			System.out.println("Please give me a actual Cordinate");
			Play();
		}
		String y = loc.substring(0, 1);
		String x = loc.substring(1);
		System.out.println("Y: " + y);
		System.out.println("X: " + x);
		printBoard(x,y);
		
	}
	
}