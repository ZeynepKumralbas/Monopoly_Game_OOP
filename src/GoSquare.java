public class GoSquare extends Square {

	public GoSquare(int numberOfPlayers, int squareNo) {
		super(numberOfPlayers, squareNo);
		this.setSquareName("GoSquare");
	}

	@Override
	public void doOperation(Player player,Board board) {
		player.addMoney(50);
		this.toStringGoSquare(player);
				
	}
	
	public void toStringGoSquare(Player player){
		String write = ("Passes Go Square. "+player.getName()+ " has $"+player.getMoney()+". ");
		new WriteToFile(write,"n");
		System.out.print("Passes Go Square. "+player.getName()+ " has $"+player.getMoney()+". ");
	}

}
