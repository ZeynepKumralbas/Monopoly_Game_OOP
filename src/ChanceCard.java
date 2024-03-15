public abstract class ChanceCard {
	
	private int cardNo;
	/*kalsýn mý silelim mi
	private String operation;
	private int squareToGo;
	private int amount;
	private int goBackSquareNo;
	private String text;
	private boolean isCardBlocked;*/
	
	
	//Constructor method, reads from file
	public ChanceCard(int cardNo){
		this.cardNo=cardNo;
	}
	
	public abstract int getCardNo();
	
	public abstract void cardOperations(Player player, Board board) ;

	public abstract String getText(); 

	public abstract void setText(String text); 
	
	public abstract boolean isCardBlocked(); 

	public abstract void setCardBlocked(boolean isCardBlocked); 
	
}
