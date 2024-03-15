import java.util.Scanner;

public class UtilitySquare extends PropertySquare {

	private int rentWithTwoUtility;
	
	public UtilitySquare(int numberOfPlayers, int squareNo) {
		super(numberOfPlayers, squareNo);
	}

	@Override
	public void doOperation(Player player, Board board) {
		
		//if this square does not have an owner 
		if(this.getOwner()==null) {
			super.doOperation(player, board);
			
			if(player.equals(this.getOwner())){ //player bought this property square
				board.addOwnerToUtilityGroup(player);
			}			
			
		}
		
		//if this square has an owner and this owner is not this player
		else if( this.getOwner()!=null && !(this.getOwner().equals(player)) ){
			int rent;
			if(board.isOwnerHasAllUtility(this)){
				rent=this.getRentWithTwoUtility()*player.getSumOfDice();
				this.getOwner().addMoney(rent);
				player.subtractMoney(rent);
			}
			else{
				rent=((PropertySquare) player.getLocation()).getRent()*player.getSumOfDice();
				this.getOwner().addMoney(rent);
				player.subtractMoney(rent);
			}
			this.toStringPayRent(rent,player);
			
		}
	}

	@Override
	public void setTitleDeed(Scanner file){
		this.setSquareName(file.next());
		this.setPriceOfProperty(file.nextInt());
		this.setRent(file.nextInt());
		this.setRentWithTwoUtility(file.nextInt());
		this.setMortgageValue(file.nextInt());
	}
	
	public int getRentWithTwoUtility() {
		return rentWithTwoUtility;
	}

	public void setRentWithTwoUtility(int rentWithTwoUtility) {
		this.rentWithTwoUtility = rentWithTwoUtility;
	}
	
}