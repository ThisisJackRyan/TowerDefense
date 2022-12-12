import java.util.Scanner;
class Board {
	public static final String reset = "\u001b[0m";
	public static final String green = "\u001b[46m";
	public static final String lightGreen = "\u001b[42m";
	public static final int valueOfChar = 97;
	public static final String ninja = "🥷";
	public int gold = 30;

	private String[][] board = {
		{"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
		{"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
		{"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
		{"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
		{"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
		{"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
	};


	//do work on line 61
	//do work on line 61
	//do work on line 61
	//do work on line 61
	//do work on line 61
	//do work on line 61
	//do work on line 61
	//do work on line 61
	public Board(){
		
	}

	
	public void printBoard() {
		System.out.println("Gold: " + gold);
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
		System.out.println("    0    1    2    3    4    5    6    7    8    9   10   11   12   13   14   15   16   ");
		System.out.print(reset);
		Play();
	}

	public void Play(){
		Scanner input = new Scanner(System.in);
		System.out.println("Where would you like to place your character? (Please put letter first) or 'S' to skip");
		String loc = input.nextLine();

		if(loc.length() > 3){
			System.out.println("Please give me a actual Cordinate");
			Play();
		}

		if(loc.equals("S") ||loc.equals("s")){
			gold += 5;
			clear();
			spawnMob();
			printBoard();
			
		}
		String y = loc.substring(0, 1);
		String x = loc.substring(1);

		
		System.out.println("Please Choose Your Chacter:");
		System.out.println("🤖 || 1");
		System.out.println("👮 || 2");
		System.out.println("💂 || 3");
		System.out.println("🧞 || 4");
		System.out.println("💃 || 5");
		int icon = input.nextInt();

		clear();
		addCharacter(x,y,icon);
	}


	
	public void addCharacter(String x, String y, int num){
		try{
			int col =  Integer.parseInt(x);
			int row = ((int)(y.charAt(0))-97);
			if(col > 16 || (row > 5 || row < 0)){
				System.out.println("Please give me a actual Cordinate");
				Play();
			}
		

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
			if(gold >= 30){
				board[row][col] = icon;
				gold -=30;
			}
			else{
				System.out.println("Sorry you don't have enough Gold");
			}
			spawnMob();
			printBoard();
		}catch(Exception e){
			System.out.println("Please give me a actual Cordinate");
			Play();
		}
	}


	public void spawnMob(){
		moveMob();
		String icon = "";
		int row = (int)(Math.random() * 6) + 0;
		int mobNum = (int)(Math.random() * 3) + 1;
		
		switch(mobNum){
			case 1: icon = Vampire.ICON; break;
			case 2: icon = Zombie.ICON; break;
			case 3: icon = Devil.ICON; break;
			default:  icon = Zombie.ICON; break;
		}
		board[row][board[0].length-1] = icon;
		
	}

	public void moveMob(){
		for(int i = 0; i < board.length; i++){
			for(int j =0; j<board[0].length; j++){
				if(board[i][j] == "🧛" ||board[i][j] == "👹" || board[i][j] == "🧟"){
					if(!(board[i][j-1] == "")){
						battle(i,j);
					}else{
						if(j == 1){
							youLost();
							board[i][j-1] = board[i][j];
							board[i][j] = "";
						}
						else{
							board[i][j-1] = board[i][j];
							board[i][j] = "";
						}
					}
				}
			}
		}
	}


	public void battle(int row,int col){
		String badChar = board[row][col];
		String goodChar = board[row][col-1];

		int attackBad = 0;
		int healthBad = 0;
		
		int attackGood = 0;
		int healthGood = 0;
		switch(badChar){
			case "🧛":
				attackBad = Vampire.ATTACK;
				healthBad = Vampire.HEALTH;
				break;
			case "🧟":
				attackBad = Zombie.ATTACK;
				healthBad = Zombie.HEALTH;
				break;
			case "👹":
				attackBad = Devil.ATTACK;
				healthBad = Devil.HEALTH;
				break;
			
		}
		switch(goodChar){
			case "🤖":
				attackGood = Robot.ATTACK;
				healthGood = Robot.HEALTH;
				break;
			case "👮":
				attackGood = Cop.ATTACK;
				healthGood = Cop.HEALTH;
				break;
			case "💂":
				attackGood = Cop.ATTACK;
				healthGood = Cop.HEALTH;
				break;
			case "🧞":
				attackGood = Cop.ATTACK;
				healthGood = Cop.HEALTH;
				break;
			case "💃":
				attackGood = Cop.ATTACK;
				healthGood = Cop.HEALTH;
				break;	
		}
		/*System.out.println("attackGood: " + attackGood);
		System.out.println("healthGood: " + healthGood);

		System.out.println("attackBad: " + attackBad);
		System.out.println("healthBad: " + healthBad);*/
			healthGood -= attackBad;
			healthBad -= attackGood;
		
		if(healthGood <= 0){
			System.out.println("Good Guy died!!!");
			board[row][col-1] = "";
			
		}
		if(healthBad <= 0){
			System.out.println("Bad Guy died!!!");
			board[row][col] = "";
			gold += 15;
		}
	}

	public static void clear() {
 	 System.out.print("\033[H\033[2J");
	  System.out.flush();
	}




	public void youWIN(){
		System.out.println("");
	}

	public void youLost(){
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