class Gold{
	private int value;
	


	Gold(){
		value = 30;
	}

	public int getValue(){return value;}

	public void skipRound(){
		value += 10;
	}

	public void wonBattle(){
		value += 30;
	}
}