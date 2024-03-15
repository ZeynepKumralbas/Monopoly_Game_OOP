public class Game {

	private Board board;
	private int numberOfPlayers;
	private Player players[];
	private int roundCount;
	private int turn; 
	private Die [] dice;
	
	//constructor method
	public Game(String playerName[],int numberOfPlayers) {
		int i;
		this.numberOfPlayers=numberOfPlayers;
				
		board = new Board(numberOfPlayers);
		
		this.players=new Player[numberOfPlayers];
		
		for(i=0; i<numberOfPlayers; i++){
			this.players[i] = new Player(playerName[i],i);
		}
		
		for(i=0; i<numberOfPlayers; i++){
			this.players[i].setLocation(board.getSquares()[0]);			
		}
		 
	    for(i=0; i<numberOfPlayers; i++){
			this.players[i].setToken(i);
		}
		
		//initialize dice
		this.dice = new Die[2];
		
		//create dice
		for(i=0; i<2; i++){
			this.dice[i] = new Die();						
		}
		//start to game from first ordered player
		this.turn=0;
	}
	
	private void checkBankruptcy() {
		int i,j;
		for(i=0 ; i<numberOfPlayers ; i++) {
			if(this.players[i].getMoney()<=0) {
				
				String write = (""); new WriteToFile(write,"y");
				System.out.println("");
				write = (players[i].getName()+" went bankrupt!");
				new WriteToFile(write,"y");
				
				System.out.println(players[i].getName()+" went bankrupt!");
				//delete the player, shift other player in array
				for(j=i ; j<numberOfPlayers-1 ; j++) {
					this.players[j]=this.players[j+1];
				}
				//decrease number of players
				numberOfPlayers=numberOfPlayers-1;
				break;
			}
		}
	}
	
	public void startGame(){
		this.roundCount=1;
		
		String write = ("\nROUND : "+this.roundCount);
		new WriteToFile(write,"y");

		System.out.println("\nROUND : "+this.roundCount);

		while(numberOfPlayers!=1 ) {
			makePlayCurrentPlayer();
		}
		
		write = ("\nWinner:"+players[0].getName()+" Money: "+players[0].getMoney());
		new WriteToFile(write,"n");
		
		System.out.print("\nWinner:"+players[0].getName()+" Money: "+players[0].getMoney());
			
	}
	
	private void roundCheck(int i){
		if((i)%this.numberOfPlayers==0) {
			//after each round, check whether any player go bankruptcy
			checkBankruptcy();
			this.roundCount++;
			
			String write = ("\nROUND : "+this.roundCount);
			new WriteToFile(write,"y");

			System.out.println("\nROUND : "+this.roundCount);
			
		}
	}
	
	private void makePlayCurrentPlayer(){
		//player rolls the dice
		this.players[turn].rollDice(this.dice[0],this.dice[1]);
			
		//print current player and its information
		String write = (this.players[turn].toString()+" ");
		new WriteToFile(write,"n");
		System.out.print(this.players[turn].toString()+" ");
		
		write = (this.players[turn].getName()+" rolls the dice. Die1:"+this.dice[0].toString()+" and die2:"+this.dice[1].toString()+" sum:"+this.players[turn].getSumOfDice()+". ");
		new WriteToFile(write,"n");
		System.out.print(this.players[turn].getName()+" rolls the dice. Die1:"+this.dice[0].toString()+" and die2:"+this.dice[1].toString()+" sum:"+this.players[turn].getSumOfDice()+". ");

		//where will be token after rolling the dice 
		this.players[turn].whereWillBeTokenLocated(this.board,"forward");

		write = ("Now "+this.players[turn].getName()+" is in "+this.players[turn].getLocation().getSquareNo()+".square and has $"+this.players[turn].getMoney()+". ");
		new WriteToFile(write,"y");
		System.out.println("Now "+this.players[turn].getName()+" is in "+this.players[turn].getLocation().getSquareNo()+".square and has $"+this.players[turn].getMoney()+". ");
		
		nextPlayerTurn();
	}
	
	private void nextPlayerTurn() {
		
		//set next player turn
		this.turn++;
		this.turn=(this.turn)%this.numberOfPlayers;
		
		if((this.turn)%numberOfPlayers==0) roundCheck(this.turn);
		
		String write = "";  new WriteToFile(write,"y");
		System.out.println("");
		
		write = ("Turn: "+players[turn]); new WriteToFile(write,"y");
		System.out.println("Turn: "+players[turn]);
		
		write = "";  new WriteToFile(write,"y");
		System.out.println("");
		
		
		//control 'is player in jail'
		if(players[this.turn].isInJail() && players[this.turn].getNumberOfRoundsOnJail()<3 ) {
			players[this.turn].setNumberOfRoundsOnJail(players[this.turn].getNumberOfRoundsOnJail()+1);
			
			//next round the player will play
			if(players[this.turn].getNumberOfRoundsOnJail()==2) {
				players[this.turn].setInJail(false);
				players[this.turn].setNumberOfRoundsOnJail(0);
			}
			
			
			//set next player turn
			nextPlayerTurn();
		}
	}

}
