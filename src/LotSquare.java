import java.util.Scanner;

public class LotSquare extends PropertySquare {

	private String colorGroup;
	private int rentWithOneHouse, 
				rentWithTwoHouse, 
				rentWithThreeHouse, 
				rentWithFourHouse,
				rentWithHotel, 
				eachHouseCost, 
				eachHotelCost;
	
	public LotSquare(int numberOfPlayers, int squareNo) {
		super(numberOfPlayers, squareNo);
	}
	
	@Override
	public void setTitleDeed(Scanner file){
		this.setSquareName(file.next());
		this.setColorGroup(file.next());
		this.setPriceOfProperty(file.nextInt());
		this.setRent(file.nextInt());
		this.setRentWithOneHouse(file.nextInt());
		this.setRentWithTwoHouse(file.nextInt());
		this.setRentWithThreeHouse(file.nextInt());
		this.setRentWithFourHouse(file.nextInt());
		this.setRentWithHotel(file.nextInt());
		this.setEachHouseCost(file.nextInt());
		this.setEachHotelCost(file.nextInt());
		this.setMortgageValue(file.nextInt());
	}

	@Override
	public void doOperation(Player player, Board board) {

		//if this square does not have an owner 
		if(this.getOwner()==null) {
			super.doOperation(player, board);
			
			if(player.equals(this.getOwner())){ //player bought this property square
				board.addOwnerToColorGroups(this, player);
			}
						
		}
		
		//if this square has an owner and this owner is not this player
		if( this.getOwner()!=null && !(this.getOwner().equals(player)) ) {
			int rent;
			//if the owner has the all squares in the same group, take two times of rent  
			if(board.isOwnerHasAllSquareInTheSameGroup(this,player)) {
				rent=(this.getRent())*2;
			}	
			else {
				rent=this.getRent();
				
			}
			this.getOwner().addMoney(rent);
			player.subtractMoney(rent);
			this.toStringPayRent(rent,player);	
		}
		
	}
	
	public String getColorGroup() {
		return colorGroup;
	}

	public void setColorGroup(String colorGroup) {
		this.colorGroup = colorGroup;
	}
	
	public int getRentWithOneHouse() {
		return rentWithOneHouse;
	}

	public void setRentWithOneHouse(int rentWithOneHouse) {
		this.rentWithOneHouse = rentWithOneHouse;
	}

	public int getRentWithTwoHouse() {
		return rentWithTwoHouse;
	}

	public void setRentWithTwoHouse(int rentWithTwoHouse) {
		this.rentWithTwoHouse = rentWithTwoHouse;
	}

	public int getRentWithThreeHouse() {
		return rentWithThreeHouse;
	}

	public void setRentWithThreeHouse(int rentWithThreeHouse) {
		this.rentWithThreeHouse = rentWithThreeHouse;
	}

	public int getRentWithFourHouse() {
		return rentWithFourHouse;
	}

	public void setRentWithFourHouse(int rentWithFourHouse) {
		this.rentWithFourHouse = rentWithFourHouse;
	}

	public int getRentWithHotel() {
		return rentWithHotel;
	}

	public void setRentWithHotel(int rentWithHotel) {
		this.rentWithHotel = rentWithHotel;
	}

	public int getEachHouseCost() {
		return eachHouseCost;
	}

	public void setEachHouseCost(int eachHouseCost) {
		this.eachHouseCost = eachHouseCost;
	}

	public int getEachHotelCost() {
		return eachHotelCost;
	}

	public void setEachHotelCost(int eachHotelCost) {
		this.eachHotelCost = eachHotelCost;
	}
	
}
