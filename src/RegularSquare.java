public class RegularSquare extends Square {

	public RegularSquare(int numberOfPlayers, int squareNo) {
		super(numberOfPlayers, squareNo);
		if(squareNo==10)	this.setSquareName("KodesZiyaret�i");
		else if(squareNo==20)	this.setSquareName("�cretsizOtopark");
	}

	@Override
	public void doOperation(Player player, Board board) {
		
	}

}
