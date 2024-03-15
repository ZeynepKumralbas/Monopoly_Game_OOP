public class LuxuryTaxSquare extends Square {

	private int luxuryTax;
	
	public LuxuryTaxSquare(int numberOfPlayers, int squareNo) {
		super(numberOfPlayers, squareNo);
		setLuxuryTax(100);
		this.setSquareName("LuxuryTaxSquare");
	}

	public int getLuxuryTax() {
		return luxuryTax;
	}

	public void setLuxuryTax(int luxuryTax) {
		this.luxuryTax = luxuryTax;
	}
	
	@Override
	public void doOperation(Player player,Board board) {
		player.subtractMoney(this.luxuryTax);
		this.toStringPayLuxuryTax(player);
	}
	
	private void toStringPayLuxuryTax(Player player){
		String write = (player.getName()+" pays $"+this.getLuxuryTax()+" for luxury tax. ");
		new WriteToFile(write,"y");
		System.out.println(player.getName()+" pays $"+this.getLuxuryTax()+" for luxury tax. ");
	}

}