import java.util.Scanner;

class Board {
	public static final String reset = "\u001b[0m";
	// public static final String green = "\u001b[46m";
	public static final String green = "\033[0;102m";
	public static final String lightGreen = "\u001b[42m";
	public static final int valueOfChar = 97;
	public static final String ninja = "🥷";
	public int gold = 30;
	public int kills = 0;

	private String[][] board = {
			{ "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "" },
			{ "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "" },
			{ "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "" },
			{ "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "" },
			{ "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "" },
			{ "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "" },
	};

	// prints Board with a checkered pattern
	public void printBoard() {
		System.out.println("Gold: " + gold + "			Monsters Killed: " + kills);
		for (int i = 0; i < board.length; i++) {
			System.out.print((char) (valueOfChar + i));
			System.out.print(" ");
			for (int j = 0; j < board[0].length; j++) {
				if (i % 2 == 0 && j % 2 == 0 || i % 2 != 0 && j % 2 != 0) {
					System.out.print(green);
				} else {
					System.out.print(lightGreen);
				}
				if (board[i][j].equals("")) {
					System.out.print("     ");
				} else {
					System.out.print(" " + board[i][j] + "  ");
				}
			}
			System.out.print(reset);
			System.out.println("");
		}
		System.out.println("    0    1    2    3    4    5    6    7    8    9   10   11   12   13   14   15   16   ");
		System.out.print(reset);
		Play();
	}

	// ask user where he would like charcater and does basic check that the user
	// gave a actual location
	// or they could skip by typing "s"
	public void Play() {
		Scanner input = new Scanner(System.in);
		System.out.println("Where would you like to place your character? (Please put letter first) or 'S' to skip");
		String loc = input.nextLine();

		if (loc.length() > 3) {
			System.out.println("Please give me a actual Cordinate");
			Play();
		}

		if (loc.equals("S") || loc.equals("s")) {
			gold += 5;
			clear();
			spawnMob();
			printBoard();

		}
		String y = loc.substring(0, 1);
		String x = loc.substring(1);

		int icon = pickChar();

		clear();
		addCharacter(x, y, icon);
		// input.close();
	}

	// gets input of what charcater they want
	public int pickChar() {
		Scanner input = new Scanner(System.in);
		System.out.println("Please Choose Your Chacter:");
		System.out.println("🤖 || 1");
		System.out.println("👮 || 2");
		System.out.println("💂 || 3");
		System.out.println("🧞 || 4");
		System.out.println("💃 || 5");
		int icon = -1;
		try {
			icon = input.nextInt();
		} catch (Exception e) {
			System.out.println("please give me an actual Number");
			pickChar();
		}
		// input.close();
		return icon;
	}

	// finds what character was chosen and shoves into the board array
	// if error ocurs the user did not give a vaild location
	public void addCharacter(String x, String y, int num) {
		try {
			int col = Integer.parseInt(x);
			int row = ((int) (y.charAt(0)) - 97);
			if (col > 16 || (row > 5 || row < 0)) {
				System.out.println("Please give me a actual Cordinate");
				Play();
			}
			String icon = "";
			switch (num) {
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
			if (gold >= 30) {
				board[row][col] = icon;
				gold -= 30;
			} else {
				clear();
				System.out.println("Sorry you don't have enough Gold");
			}
			spawnMob();
			printBoard();
		} catch (Exception e) {
			System.out.println("Please give me a actual Cordinate");
			Play();
		}
	}

	// Spawns a random monster at a random location
	public void spawnMob() {
		moveMob();
		String icon = "";
		int row = (int) (Math.random() * 6) + 0;
		int mobNum = (int) (Math.random() * 3) + 1;

		switch (mobNum) {
			case 1:
				icon = Vampire.ICON;
				break;
			case 2:
				icon = Zombie.ICON;
				break;
			case 3:
				icon = Devil.ICON;
				break;
			default:
				icon = Zombie.ICON;
				break;
		}
		board[row][board[0].length - 1] = icon;

	}

	// Move all monsters one spot to the left and checks if battle occurs
	public void moveMob() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == "🧛" || board[i][j] == "👹" || board[i][j] == "🧟") {
					if (!(board[i][j - 1] == "")) {
						battle(i, j);
					} else {
						if (j == 1) {
							youLost();
							board[i][j - 1] = board[i][j];
							board[i][j] = "";
						} else {
							board[i][j - 1] = board[i][j];
							board[i][j] = "";
						}
					}
				}
			}
		}
	}

	// Takes location of Monster and Character checks characters beats array and
	// does battle
	public void battle(int row, int col) {
		String badChar = board[row][col];
		String goodChar = board[row][col - 1];

		String[] beats = {};

		switch (goodChar) {
			case "🤖":
				beats = Robot.BEATS;
				break;
			case "👮":
				beats = Cop.BEATS;
				break;
			case "💂":
				beats = RoyalGuard.BEATS;
				break;
			case "🧞":
				beats = Genie.BEATS;
				break;
			case "💃":
				beats = Dancer.BEATS;
				break;
		}

		for (int i = 0; i < beats.length; i++) {
			if (badChar.equals(beats[i])) {
				if (beats.length == 2) {
					System.out.println("Both Died");
					board[row][col - 1] = "";
					board[row][col] = "";
					kills++;

				} else {
					System.out.println("Bad Guy died!!!");
					board[row][col] = "";
					gold += 15;
					kills++;
				}
			} else {
				if (beats.length != 2) {
					System.out.println("Good Guy died!!!");
					board[row][col - 1] = "";
				}
			}
		}
	}

	// clear console
	public static void clear() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	// prints a output if you lose
	public void youLost() {
		clear();
		System.out.println("                                                                                     ");
		System.out.println("         █        █             █                █████           ████     ███████████");
		System.out.println("         █        █             █               █     █        ██              █     ");
		System.out.println("         █        █             █              █       █        ██             █     ");
		System.out.println("         █        █             █              █       █           ██          █     ");
		System.out.println("          █      █              █               █     █           ██           █     ");
		System.out.println("            ████                 ███████         █████         ████            █     ");
		System.exit(0);
	}

}