public class JailSquare extends Square {

	public JailSquare(int numberOfPlayers, int squareNo) {
		super(numberOfPlayers, squareNo);
		this.setSquareName("JailSquare");
	}

	@Override
	public void doOperation(Player player,Board board) {
		double choice;
		
		String write = (player.getName()+" comes to the Jail Square."); new WriteToFile(write,"y");
		System.out.println(player.getName()+" comes to the Jail Square.");
		player.setLocation(board.getSquares()[10]);
		
		player.setInJail(true);
		player.setNumberOfRoundsOnJail(0);
		
		if(player.isHasJailFreeCard()){
			if(player.getOwnedCCard()!=null) {
				if(player.getOwnedCCCard()==null) {
					player.setHasJailFreeCard(false);
				}
				player.setOwnedCCard(null);
			}
			else if(player.getOwnedCCCard()!=null) {
				if(player.getOwnedCCard()==null) {
					player.setHasJailFreeCard(false);
				}
				player.setOwnedCCCard(null);
			}
			
			//if the player has jail free card, uses it and continues to play
			player.setInJail(false);
			player.setLocation(board.getSquares()[30]);
			write = (" Has Jail Free card and gets out of Jail."); new WriteToFile(write,"n");
			System.out.print(" Has Jail Free card and gets out of Jail.");
		}
		
		else{
			choice= Math.random();
			if(player.getMoney()>2000 && choice>0.5){
				player.subtractMoney(200);
				
				//if the player pays money to get out of jail, continues to play
				player.setInJail(false);
				player.setLocation(board.getSquares()[30]);
				write = ("Pays $200 and gets out of jail."); new WriteToFile(write,"n");
				System.out.print("Pays $200 and gets out of jail.");
			}

		}
	}
	
	public void toStringJailSquare(){
		String write = ("Goes to Jail Square. ");	new WriteToFile(write,"n");
		System.out.print("Goes to Jail Square. ");
	}	
	
}
