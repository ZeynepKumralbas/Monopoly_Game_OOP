import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Board {

	private Square [] squares;
	private CommunityChestCard [] ccCards;
	private ChanceCard [] cCards;

	private Player [] ownersOfBrown;
	private Player [] ownersOfBlue;
	private Player [] ownersOfPink;
	private Player [] ownersOfOrange;	
	private Player [] ownersOfRed;
	private Player [] ownersOfYellow;	
	private Player [] ownersOfGreen;
	private Player [] ownersOfDarkblue;
	private Player [] ownersOfUtility;
	private Player [] ownersOfRailroad;
	
	Scanner fileTitleDeeds, fileCommunityChestCards,fileChanceCards;
	
	public Board(int numberOfPlayers){
		int i;
		//initialize squares 
		this.squares = new Square[40];
		
		//create squares
		for(i=0; i<40; i++){
			switch (i){
				case 0:
					this.squares[i] = new GoSquare(numberOfPlayers,i);
					break;
				case 2:
				case 17:
				case 33:
					this.squares[i] = new CommunityChestSquare(numberOfPlayers,i);
					break;
				case 4:
					this.squares[i] = new IncomeTaxSquare(numberOfPlayers,i);
					break;
				case 5:
				case 15:
				case 25:
				case 35:	
					this.squares[i] = new RailroadSquare(numberOfPlayers,i);
					break;
				case 7:
				case 22:
				case 36:
					this.squares[i] = new ChanceSquare(numberOfPlayers,i);
					break;
				case 10:
				case 20:
					this.squares[i] = new RegularSquare(numberOfPlayers,i);
					break;
				case 12:
				case 28:
					this.squares[i] = new UtilitySquare(numberOfPlayers,i);
					break;
				case 30:
					this.squares[i] = new JailSquare(numberOfPlayers,i);
					break;
				case 38:
					this.squares[i] = new LuxuryTaxSquare(numberOfPlayers,i);
					break;	
				default:
					this.squares[i] = new LotSquare(numberOfPlayers,i);
					break;
			}		
		}
		
		//set squares attributes with information from file
		setSquaresWithInfoFromFile();
		
		//initialize dimension of ownersOfColors, ownersOfUtility arrays
		this.ownersOfBrown=new Player[2];
		this.ownersOfBlue=new Player[3];
		this.ownersOfPink=new Player[3];
		this.ownersOfOrange=new Player[3];		
		this.ownersOfRed=new Player[3];
		this.ownersOfYellow=new Player[3];	
		this.ownersOfGreen=new Player[3];
		this.ownersOfDarkblue=new Player[2];
		this.ownersOfUtility=new Player[2];
		this.ownersOfRailroad=new Player[4];
		
	}
		
	private void setSquaresWithInfoFromFile() {
		int i;
		
        java.io.File propertySquareFile = new java.io.File("PropertySquareInformation.txt");
        java.io.File communityChestFile = new java.io.File("CommunityChestCards.txt");
        java.io.File chanceFile = new java.io.File("ChanceCards.txt");
        
        //read title deed, community chest card and chance card information from the file
        try {
			fileTitleDeeds = new Scanner(propertySquareFile);
			fileCommunityChestCards = new Scanner(communityChestFile);
			fileChanceCards = new Scanner(chanceFile);
			
			//initialize cards
			this.ccCards = new CommunityChestCard[16];
			this.cCards = new ChanceCard[16];
			String operation,text;
			int temp;
			//create CommunityChestCards and ChanceCards, read from file
			for(i=0; i<16; i++){
				operation=fileChanceCards.next();				
				
				if(operation.equals("gainMoney") ){
					this.cCards[i] = new GainMoneyCard(i);
					temp=fileChanceCards.nextInt();					
					((GainMoneyCard)this.cCards[i]).setAmount(temp); 
				}
				else if(operation.equals("loseMoney")) {
					this.cCards[i] = new LoseMoneyCard(i);
					temp=fileChanceCards.nextInt();	
					((LoseMoneyCard)this.cCards[i]).setAmount(temp); 
				}
				else if(operation.equals("move")){
					this.cCards[i] = new MoveForwardCard(i);
					temp=fileChanceCards.nextInt();	
					((MoveForwardCard)this.cCards[i]).setSquareToGo(temp);	
				}
				else if(operation.equals("moveBack")){
					this.cCards[i] = new MoveBackwardCard(i);
					temp=fileChanceCards.nextInt();	
					((MoveBackwardCard)this.cCards[i]).setSquareToGo(temp);
				}
				else if(operation.equals("jailFree")) {
					this.cCards[i] = new JailFreeCard(i);
				}
				
				text=fileChanceCards.nextLine();
				this.cCards[i].setText(text);
			}	
			for(i=0; i<16; i++){
				operation=fileCommunityChestCards.next();
				
				if(operation.equals("gainMoney") ){
					this.ccCards[i] = new GainMoneyCard(i);
					temp=fileCommunityChestCards.nextInt();	
					((GainMoneyCard)this.ccCards[i]).setAmount(temp);  
				}
				else if(operation.equals("loseMoney")) {
					this.ccCards[i] = new LoseMoneyCard(i);
					temp=fileCommunityChestCards.nextInt();	
					((LoseMoneyCard)this.ccCards[i]).setAmount(temp);
				}
				else if(operation.equals("move")){
					this.ccCards[i] = new MoveForwardCard(i);
					temp=fileCommunityChestCards.nextInt();	
					((MoveForwardCard)this.ccCards[i]).setSquareToGo(temp);	
				}
				else if(operation.equals("moveBack")){
					this.ccCards[i] = new MoveBackwardCard(i);
					temp=fileCommunityChestCards.nextInt();	
					((MoveBackwardCard)this.ccCards[i]).setSquareToGo(temp);
				}
				else if(operation.equals("jailFree")) {
					this.ccCards[i] = new JailFreeCard(i);
				}
				text=fileCommunityChestCards.nextLine();
				this.ccCards[i].setText(text);			
				
		}
			CommunityChestCard tempCC;
			ChanceCard tempC;
			int r;
			
			Random rand = new Random(); 
			//Shuffling cards
			for (i = 0; i < 16 ;  i++){ 
			   	// Random for remaining positions. 
			    r = i + rand.nextInt(16 - i); 
			              
			    //swapping the elements 
			    tempCC = this.ccCards[r]; 
			    this.ccCards[r] = this.ccCards[i]; 
			    this.ccCards[i] = tempCC; 
			               
			} 
						
			//Shuffling cards         
			for (i = 0; i < 16 ;  i++){ 
			   	// Random for remaining positions. 
			    r = i + rand.nextInt(16 - i); 
			              
			    //swapping the elements 
			    tempC = this.cCards[r]; 
			    this.cCards[r] = this.cCards[i]; 
			    this.cCards[i] = tempC; 
			               
			}
						
			for(i=0; i<40; i++){
				if(this.squares[i] instanceof PropertySquare){
					((PropertySquare)this.squares[i]).setTitleDeed(fileTitleDeeds);
				}
				else if(this.squares[i] instanceof CommunityChestSquare){
					((CommunityChestSquare) this.squares[i]).setCards(this.ccCards);
				}
				else if(this.squares[i] instanceof ChanceSquare){
					((ChanceSquare) this.squares[i]).setCards(this.cCards);
				}
			}	
		
        } 
        catch (FileNotFoundException e) {
			System.out.println(e);
		}
	}

	
		
	public void addOwnerToColorGroups(LotSquare location,Player player) {
		String color=location.getColorGroup();
		Player [] colorGroup=findGroup(location); 
		
		int i,numberOfOwners;
		
		//how many squares are there for this color 
		if(color.equals("brown")  || color.equals("darkblue"))    
			numberOfOwners=2;
		else
			numberOfOwners=3;
		
		
		for(i=0 ; i<numberOfOwners ; i++) {
			if(colorGroup[i]==null) {
				colorGroup[i]=player;
				break;
			}
		}
	}
	
	private Player[] findGroup(LotSquare square) {
		switch (square.getColorGroup()) {
			case "brown":  			
				return ownersOfBrown;
				
			case "blue":   		
				return ownersOfBlue;	
				
			case "pink":  		
				return ownersOfPink;		
				
			case "orange":	  	
				return ownersOfOrange;	
				
			case "red":  		
				return ownersOfRed;		
				
			case "yellow":		
				return ownersOfYellow;	
				
			case "green":   	
				return ownersOfGreen;	
				
			case "darkblue":  	
				return ownersOfDarkblue;	
				
			default: 									
				return null;
		}
	}
	
	public boolean isOwnerHasAllSquareInTheSameGroup(LotSquare square,Player player) {
		int i,numberOfOwners;
		String color=square.getColorGroup() ;
		Player [] colorGroup=findGroup(square); 
			
		//how many squares are there for this color 
		if((color.equals("brown")) || (color.equals("darkblue"))){   
			numberOfOwners=2;
		}
		else{
			numberOfOwners=3;
		}
		for(i=0 ; i<numberOfOwners ; i++) {
			if( !(square.getOwner().equals(colorGroup[i]) ) )  {
				return false;
			}
		}
		return true;
	}

	public boolean isOwnerHasAllUtility(UtilitySquare square){
		int i, numberOfOwners=2;
		for(i=0; i<numberOfOwners; i++){
			if( !( square.getOwner().equals(ownersOfUtility[i]) ) ){
				return false;
			}
		}
		return true;
	}
	
	public void addOwnerToUtilityGroup(Player player){
		int i, numberOfOwners=2;
		
		for(i=0 ; i<numberOfOwners; i++) {
			if(ownersOfUtility[i]==null) {
				ownersOfUtility[i]=player;
				break;
			}
		}
	}
	
	public int howManyRailroad(RailroadSquare square){
		int i, count=0, numberOfOwners=4;
		for(i=0; i<numberOfOwners; i++){
		if(square.getOwner()==ownersOfRailroad[i]){
				count++;
			}
		}
		return count;		
	}
	
	public void addOwnerToRailroad(RailroadSquare square,Player player){
		int i, numberOfOwners=4;
		for(i=0 ; i<numberOfOwners ; i++){
			if(ownersOfRailroad[i]==null){
				ownersOfRailroad[i]=player;
				break;
			}
		}
	}

	public Square[] getSquares() {
		return squares;
	}

	public Square findNewLocation(Square oldLoc, int sumOfDice, String direction) {
		int newLocNo;
		if(direction.equals("forward")) {
			newLocNo=(oldLoc.getSquareNo()+sumOfDice)%40;
			return this.squares[newLocNo];
		}
		else {
			newLocNo=(oldLoc.getSquareNo()-sumOfDice)%40;
			return this.squares[newLocNo];
		}
	}

} 
	