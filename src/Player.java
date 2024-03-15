public class Player {

	private String name;
	private Token token;
	private Square location;
	private int money;
	private int sumOfDice;
	
	private boolean inJail;
	private int numberOfRoundsOnJail;
	
	private boolean hasJailFreeCard;
	private CommunityChestCard ownedCCCard;
	private ChanceCard ownedCCard;
	
	public Player(String name,int orderOfPlaying){
		this.name=name;
		this.money=600;
	}
	
	public void rollDice(Die die0,Die die1){
		this.sumOfDice=die0.rollDie()+die1.rollDie();
	}
	
	public void whereWillBeTokenLocated(Board board,String direction){			
			
			Square oldLoc=this.token.getCurrentSquare(); //get the current square the player is at
			Square newLoc=board.findNewLocation(oldLoc,this.sumOfDice,direction); //get the new location information from board
			
			//if player passes Go Square, not comes on to it
			if( (newLoc.getSquareNo() < oldLoc.getSquareNo()) && newLoc.getSquareNo()!=0 ) {
				this.addMoney(50);
				this.toStringGoSquare(this);	
			}
		
			this.token.setCurrentSquare(newLoc); //update the location of token
			this.location=newLoc; //update the location of the player
			this.location.doOperation(this, board);  
					
	} 
	
	public void addMoney(int amount){
		this.setMoney(this.money+amount);
	}
	
	public void subtractMoney(int amount){
		this.setMoney(this.money-amount);
	}

	public String toString(){
		return (this.getName()+" is in "+this.getLocation().getSquareNo()+".square ("+this.getLocation().getSquareName()+") and has $"+this.getMoney()+".");
	}
	
	//get name
	public String getName() {
		return this.name;
	}
	
	//get token
	public Token getToken() {
		return this.token;
	}
	
	//set token
	public void setToken(int noOfToken) {
		this.token=new Token(this.location,noOfToken);
	}
	
	//get location
	public Square getLocation() {
		return this.location;
	}
	
	//set location
	public void setLocation(Square square) {
		this.location=square;
	}
	
	//get money
	public int getMoney() {
		return this.money;
	}
	
	//set money
	public void setMoney(int money){
		this.money = money;
	}
	
	public void setSumOfDice(int noOfSteps){
		this.sumOfDice=noOfSteps;
	}
	
	public int getSumOfDice(){
		return this.sumOfDice;
	}
		
	public boolean isInJail() {
		return inJail;
	}

	public void setInJail(boolean inJail) {
		this.inJail = inJail;
	}
	
	public int getNumberOfRoundsOnJail() {
		return numberOfRoundsOnJail;
	}
	
	public void setNumberOfRoundsOnJail(int numberOfRoundsOnJail) {
		this.numberOfRoundsOnJail = numberOfRoundsOnJail;
	}

	public boolean isHasJailFreeCard() {
		return hasJailFreeCard;
	}

	public void setHasJailFreeCard(boolean hasJailFreeCard) {
		this.hasJailFreeCard = hasJailFreeCard;
	}
	
	public CommunityChestCard getOwnedCCCard() {
		return ownedCCCard;
	}

	public void setOwnedCCCard(CommunityChestCard ownedCCCard) {
		this.ownedCCCard = ownedCCCard;
	}

	public ChanceCard getOwnedCCard() {
		return ownedCCard;
	}

	public void setOwnedCCard(ChanceCard ownedCCard) {
		this.ownedCCard = ownedCCard;
	}
	
	private void toStringGoSquare(Player player){
		String write = ("Passes Go Square. "+player.getName()+ " has $"+player.getMoney()+". ");
		new WriteToFile(write,"n");
		System.out.print("Passes Go Square. "+player.getName()+ " has $"+player.getMoney()+". ");
	}
	
}
