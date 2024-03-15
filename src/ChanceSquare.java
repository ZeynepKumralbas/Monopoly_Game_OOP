public class ChanceSquare extends Square {
	
	private ChanceCard cards[];
	private int turnOfChanceCards;
	
	public ChanceSquare(int numberOfPlayers, int squareNo) {
		super(numberOfPlayers, squareNo);
		this.setSquareName("ChanceSquare");
	}

	public ChanceCard[] getCards() {
		return cards;
	}
	
	public void setCards(ChanceCard cards[]) {
		this.cards = cards;	
	}
	
	public ChanceCard drawACard() {
		return cards[this.turnOfChanceCards];
	}	
	
	public void controlCard() {
		while(cards[this.turnOfChanceCards].isCardBlocked()) {
			this.turnOfChanceCards=(this.turnOfChanceCards+1)%16;
		}
	}
	
	@Override
	public void doOperation(Player player,Board board)  {
		controlCard();
		
		ChanceCard tempCard=drawACard();
		
		String write = (player.getName()+" draws a Chance Card."+tempCard.getText());    
		new WriteToFile(write,"n");
		System.out.print(player.getName()+" draws a Chance Card."+tempCard.getText());    
		
		//increase turn of chance cards by 1
		this.turnOfChanceCards=(this.turnOfChanceCards+1)%16;
		
		tempCard.cardOperations(player, board);
		
	}
	
}
