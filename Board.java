import java.util.Scanner;
class Board {
	public static final String reset = "\u001b[0m";
	public static final String green = "\u001b[46m";
	public static final String lightGreen = "\u001b[42m";
	public static final int valueOfChar = 97;
	public static final String ninja = "🥷";

	private String[][] board = {
		{"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
		{"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
		{"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
		{"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
		{"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
		{"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
	};
	
	public Board(){
	}

	
	public void printBoard() {

		for (int i = 0; i < board.length; i++) {
			System.out.print((char)(valueOfChar + i));
			System.out.print(" ");
			for (int j = 0; j < board[0].length; j++) {
				if(i % 2 == 0 && j % 2 == 0 || i % 2 != 0 && j % 2 != 0) {
					System.out.print(green);
				}else{
					System.out.print(lightGreen);
				}
				if(board[i][j].equals("")){
					System.out.print("     ");
				}
				else{
					System.out.print(" " + board[i][j] + "  ");
				}
			}
			System.out.print(reset);
			System.out.println("");
		}
		System.out.println("    0    1    2    3    4    5    6    7    8    9   10   11   12   13   14   15   16   17");
		System.out.print(reset);
		Play();
	}

	public void Play(){
		Scanner input = new Scanner(System.in);
		System.out.println("Where would you like to place your character? (Please put number first");
		String loc = input.nextLine();

		
		System.out.println("Please Choose Your Chacter:");
		System.out.println("🤖 || 1");
		System.out.println("👮 || 2");
		System.out.println("💂 || 3");
		System.out.println("🧞 || 4");
		System.out.println("💃 || 5");
		int icon = input.nextInt();

		
		if(loc.length() > 2){
			System.out.println("Please give me a actual Cordinate");
			Play();
		}
		String y = loc.substring(0, 1);
		String x = loc.substring(1);
		System.out.println("Y: " + y);
		System.out.println("X: " + x);
		addCharacter(x,y,icon);
		
	}


	
	public void addCharacter(String x, String y, int num){
		int col =  Integer.parseInt(x);
		int row = ((int)(y.charAt(0))-97);
		String icon = "";
		//see if ther is a better way to do this other than declaring a new object every time
		switch(num){
			case 1: 
				icon = Robot.ICON;
				break;
			case 2: 
				icon = Cop.ICON;
				break;
			case 3: 
				 icon = RoyalGuard.ICON;
				break;
			case 4:
				icon = Genie.ICON; 
				break;
			case 5: 
				icon = Dancer.ICON;
				break;
			default: 
				icon = Robot.ICON;
				break;
		}
		board[row][col] = icon;
		printBoard();
	}
	
}