public class CommunityChestSquare extends Square {

	private CommunityChestCard cards[];
	private int turnOfCommunityChestCards;	
	
	public CommunityChestSquare(int numberOfPlayers, int squareNo) {
		super(numberOfPlayers, squareNo);
		this.setSquareName("CommunityChestSquare");	
	}

	public CommunityChestCard[] getCards() {
		return cards;
	}

	public void setCards(CommunityChestCard cards[]) {
		this.cards = cards;
		
	}
	
	public CommunityChestCard drawACard() {
		return cards[this.turnOfCommunityChestCards];
	}
	
	public int controlCard() {
		while(cards[this.turnOfCommunityChestCards].isCardBlocked()) {
			this.turnOfCommunityChestCards=(this.turnOfCommunityChestCards+1)%16;;
		}
		return this.turnOfCommunityChestCards;
	}
	
	@Override
	public void doOperation(Player player,Board board) {
		controlCard();
		
		//draw a card
		CommunityChestCard tempCard=drawACard();
		
		String write = (player.getName()+" draws a Community Chest Card."+tempCard.getText());
		new WriteToFile(write,"n");
		System.out.print(player.getName()+" draws a Community Chest Card."+tempCard.getText());
		
		//increase turn of community chest cards by 1
		this.turnOfCommunityChestCards=(this.turnOfCommunityChestCards+1)%16;
		
		tempCard.cardOperations(player, board);
		
	}
	
}
