public interface CommunityChestCard {
	
	public abstract int getCardNo();
	
	public abstract void cardOperations(Player player, Board board) ;
	
	public abstract String getText() ;	

	public abstract void setText(String text) ;
	
	public abstract boolean isCardBlocked() ;
	
	public abstract void setCardBlocked(boolean isCardBlocked) ;
	
}
