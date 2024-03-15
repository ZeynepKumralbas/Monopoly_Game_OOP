public class MoveForwardCard extends ChanceCard implements CommunityChestCard{
	
	public  int cardNo;
	private int squareToGo;	
	private String text;
	private boolean isCardBlocked;
	
	public MoveForwardCard(int cardNo) {
		super(cardNo);	
	}
	
	@Override
	public int getCardNo() {
		return cardNo;
	}
	
	public  int getSquareToGo() {
		return squareToGo;
	}
	
	public  void setSquareToGo(int squareToGo) {
		this.squareToGo = squareToGo;
	}
		
	@Override
	public String getText() {
		return text;
	}

	@Override
	public void setText(String text) {
		this.text = text;
	}

	@Override
	public boolean isCardBlocked() {
		return isCardBlocked;
	}
	
	@Override
	public void setCardBlocked(boolean isCardBlocked) {
		this.isCardBlocked=isCardBlocked;
	}
	
	@Override
	public void cardOperations(Player player, Board board) {
		int noOfSteps;
		noOfSteps=(this.getSquareToGo()-player.getLocation().getSquareNo())%40;
		
		player.setSumOfDice(noOfSteps);
		player.whereWillBeTokenLocated(board,"forward");
	}

}
