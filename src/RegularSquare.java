public class RegularSquare extends Square {

	public RegularSquare(int numberOfPlayers, int squareNo) {
		super(numberOfPlayers, squareNo);
		if(squareNo==10)	this.setSquareName("KodesZiyaretçi");
		else if(squareNo==20)	this.setSquareName("ÜcretsizOtopark");
	}

	@Override
	public void doOperation(Player player, Board board) {
		
	}

}
