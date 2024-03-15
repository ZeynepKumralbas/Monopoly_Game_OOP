public abstract class Square {
	
	private String squareName;
	private int squareNo;
	private int totalTokenNumber;
	private Token tokens[];
	
	public Square(int numberOfPlayers,int squareNo){
		totalTokenNumber = numberOfPlayers;
		this.squareNo = squareNo;
		tokens = new Token [totalTokenNumber];
	}
	
	public String getSquareName() {
		return this.squareName;
	}
	
	public void setSquareName(String squareName){
		this.squareName = squareName;
	}
	
	public int getSquareNo() {
		return this.squareNo;
	}
		
	public void addToken(Token token){
		int i;
		for(i=0; i<totalTokenNumber; i++){
			if(tokens[i]==null) {
				tokens[i] = token;
				break;
			}
		}
	}
	
	public void removeToken(Token token){
		int i;
		for(i=0; i<totalTokenNumber; i++){
			if(tokens[i]!=null) {
				if(tokens[i].getTokenId()==token.getTokenId()) {
					tokens[i] = null;
					break;
				}
			}
		}
	}
		
	public abstract void doOperation(Player player,Board board );
		
}
