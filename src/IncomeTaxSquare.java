public class IncomeTaxSquare extends Square{

	private int incomeTax;
	
	public IncomeTaxSquare(int numberOfPlayers, int squareNo) {
		super(numberOfPlayers, squareNo);
		this.setIncomeTax(200);
		this.setSquareName("IncomeTaxSquare");
	}

	public int getIncomeTax() {
		return incomeTax;
	}

	public void setIncomeTax(int incomeTax) {
		this.incomeTax = incomeTax;
	}
	
	@Override
	public void doOperation(Player player,Board board) {
		player.subtractMoney(this.incomeTax);
		this.toStringPayIncomeTax(player);
	}
	
	private void toStringPayIncomeTax(Player player){
		String write = (player.getName()+" pays $"+this.getIncomeTax()+" for income tax. ");
		new WriteToFile(write,"y");
		System.out.println(player.getName()+" pays $"+this.getIncomeTax()+" for income tax. ");
	}

}
