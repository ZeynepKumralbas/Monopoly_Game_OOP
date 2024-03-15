public class Token {
	
	private int tokenId;
	private Square currentSquare;
	
	public Token(Square square,int tokenId){
		this.tokenId=tokenId;
		
		this.currentSquare=square;
		this.currentSquare.addToken(this);
	}
	
	public int getTokenId() {
		return this.tokenId;
	}
	
	public Square getCurrentSquare() {
		return this.currentSquare;
	}
	
	public void setCurrentSquare(Square square) {
		//remove this token from current square
		this.currentSquare.removeToken(this); 
		
		//set new loc to current square
		this.currentSquare=square;
	
		//add this token to updated current square
		this.currentSquare.addToken(this);
	}
	 
	public void toStringGoSquare(){
		String write = ("Passes Go Square. ");
		new WriteToFile(write,"n");
		System.out.print("Passes Go Square. ");
	}
	
}