public class LoseMoneyCard extends ChanceCard implements CommunityChestCard{
	
	public  int cardNo;
	private int amount;
	public boolean isCardBlocked;
	private String text;
	
	public LoseMoneyCard(int cardNo) {
		super(cardNo);
	}
	
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
	public boolean isCardBlocked() {
		return isCardBlocked;
	}

	@Override
	public void setCardBlocked(boolean isCardBlocked) {
		this.isCardBlocked = isCardBlocked;
	}

	@Override
	public void cardOperations(Player player, Board board) {
		player.subtractMoney(this.amount);
	}
	
}
