public class GainMoneyCard extends ChanceCard implements CommunityChestCard{
	
	private int amount;
	public  int cardNo;
	public boolean isCardBlocked;
	private String text;
	
	public GainMoneyCard(int cardNo) {
		super(cardNo);
	}
	
	@Override
	public int getCardNo() {
		return cardNo;
	}
	
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount=amount;
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
	public void cardOperations(Player player, Board board) {
		player.addMoney(this.getAmount());
	}

	@Override
	public boolean isCardBlocked() {
		return false;
	}

	@Override
	public void setCardBlocked(boolean isCardBlocked) {
		
	}
	
}
