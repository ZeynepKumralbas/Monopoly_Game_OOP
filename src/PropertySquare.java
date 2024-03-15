import java.util.Scanner;

public abstract class PropertySquare extends Square {
	
	private Player owner;
	private int priceOfProperty,
	 			rent,
				mortgageValue;
	
	public PropertySquare(int numberOfPlayers, int squareNo) {
		super(numberOfPlayers, squareNo);
		this.owner = null;
			
	}
	
    public Player getOwner() {
    	return this.owner;
    }

	public void buyProperty(Player buyer) {
    	this.owner = buyer;
		buyer.subtractMoney(this.priceOfProperty);
	}
    		
	public abstract void setTitleDeed(Scanner file);
	
	public int getPriceOfProperty(){
		return priceOfProperty;
	}
	
	public void setPriceOfProperty(int priceOfProperty){
		this.priceOfProperty = priceOfProperty;
	}

	public int getRent() {
		return rent;
	}

	public void setRent(int rent) {
		this.rent = rent;
	}

	public int getMortgageValue() {
		return mortgageValue;
	}

	public void setMortgageValue(int mortgageValue) {
		this.mortgageValue = mortgageValue;
	}

	@Override
	public void doOperation(Player player,Board board) {				
		double choice;
		choice=Math.random();
		
		if(player.getMoney()>=(4*priceOfProperty) && choice>0.2) {
			buyProperty(player);
			this.toStringBuyProperty();
		}
		
		else if(player.getMoney()>=2*(priceOfProperty) && choice>0.5) {
			buyProperty(player);
			this.toStringBuyProperty();	
		}
	}	
	
	public void toStringBuyProperty(){
		String write = ("Buys "+this.getSquareNo()+".square ("+this.getSquareName()+")  for $"+ this.priceOfProperty+". ");
		new WriteToFile(write,"n");
		System.out.print("Buys "+this.getSquareNo()+".square ("+this.getSquareName()+")  for $"+ this.priceOfProperty+". ");
	}
	
	public void toStringPayRent(int rent,Player player){
		String write = (this.owner.getName()+" has "+player.getLocation().getSquareNo()+".square ("+player.getLocation().getSquareName()+"). "+player.getName()+" pays $"+rent+" to "+this.owner.getName()+". "); 
		new WriteToFile(write,"n");
		System.out.print(this.owner.getName()+" has "+player.getLocation().getSquareNo()+".square ("+player.getLocation().getSquareName()+"). "+player.getName()+" pays $"+rent+" to "+this.owner.getName()+". "); 
	}

}
