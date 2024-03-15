public class JailFreeCard extends ChanceCard implements CommunityChestCard {
	
	public  int cardNo;
	private boolean isCardBlocked;
	private String text;
	
	public JailFreeCard(int cardNo) {
		super(cardNo);
	}
	
	public boolean isCardBlocked() {
		return isCardBlocked;
	}

	public void setCardBlocked(boolean isCardBlocked) {
		this.isCardBlocked = isCardBlocked;
	}
	
	@Override
	public int getCardNo() {
		return cardNo;
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
		player.setHasJailFreeCard(true);
		player.setOwnedCCCard(this);
		this.setCardBlocked(true);
	}
	
}
