public class Die {

	private int faceValue;
	private int numberOfFaces; 
	
	public Die(){
		this.numberOfFaces=6;
	}
	
	public int rollDie(){
		this.faceValue=(int)(Math.random()*this.numberOfFaces)+1;
		return this.faceValue;
	}
	
	public int getFaceValue() {
		return this.faceValue;
	}
	
	public String toString(){
		return (""+this.getFaceValue());
	}
	
}
