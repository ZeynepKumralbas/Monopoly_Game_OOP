import java.util.Scanner;

public class RailroadSquare extends PropertySquare {
	private int rentWithTwoRailroad,
				rentWithThreeRailroad,
				rentWithFourRailroad;
	
	public RailroadSquare(int numberOfPlayers, int squareNo) {
		super(numberOfPlayers, squareNo);
	}

	@Override
	public void setTitleDeed(Scanner file){
		this.setSquareName(file.next());
		this.setPriceOfProperty(file.nextInt());
		this.setRent(file.nextInt());
		this.setRentWithTwoRailroad(file.nextInt());
		this.setRentWithThreeRailroad(file.nextInt());
		this.setRentWithFourRailroad(file.nextInt());
		this.setMortgageValue(file.nextInt());
	}

	public int getRentWithTwoRailroad() {
		return rentWithTwoRailroad;
	}

	public void setRentWithTwoRailroad(int rentWithTwoRailroad) {
		this.rentWithTwoRailroad = rentWithTwoRailroad;
	}

	public int getRentWithThreeRailroad() {
		return rentWithThreeRailroad;
	}

	public void setRentWithThreeRailroad(int rentWithThreeRailroad) {
		this.rentWithThreeRailroad = rentWithThreeRailroad;
	}

	public int getRentWithFourRailroad() {
		return rentWithFourRailroad;
	}

	public void setRentWithFourRailroad(int rentWithFourRailroad) {
		this.rentWithFourRailroad = rentWithFourRailroad;
	}
	
	@Override
	public void doOperation(Player player, Board board) {
		
		//if this square does not have an owner 
		if(this.getOwner()==null) {
			super.doOperation(player, board);
			
			if(player.equals(this.getOwner())){ //player bought this property square
				board.addOwnerToRailroad(this, player);
			}
			
		}
		
		//if this square has an owner and this owner is not this player
		else if( this.getOwner()!=null && !(this.getOwner().equals(player)) ){
			int rent;
			int count=board.howManyRailroad(this);
			switch (count){
				case 2: rent=this.getRentWithTwoRailroad();
				case 3: rent=this.getRentWithThreeRailroad();
				case 4: rent=this.getRentWithFourRailroad();
				default: rent=this.getRent();
			}
			this.getOwner().addMoney(rent);
			player.subtractMoney(rent);
			this.toStringPayRent(rent,player);		
		}
	}
	
}
