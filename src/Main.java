import java.io.File;
import java.io.IOException;
import java.util.Scanner; 

public class Main { 
	static Scanner number_input, name_input; 
	static int numberOfPlayers; 
	static String nameOfPlayers[]; 
	static int roundNo;
 	
	public static void main(String[] args) { 
		
		number_input = new Scanner(System.in); 
		name_input = new Scanner(System.in); 
		
		System.out.print("Give the number of players:"); 
		
		numberOfPlayers = number_input.nextInt(); 
		//number of players should be between 2 and 8
    	while(!(numberOfPlayers<9) || !(numberOfPlayers>1)){
    		System.out.println("Min. 2 players! Max. 8 players!");
    		System.out.print("Give the number of players:"); 
    		numberOfPlayers = number_input.nextInt();
    	}
    
   		nameOfPlayers = new String[numberOfPlayers]; 

   		for(int i=0; i<numberOfPlayers; i++){ 
				System.out.print("Player"+i+"name:"); 
				nameOfPlayers[i] = name_input.nextLine(); 
		} 
   		
   		File f = new File("out.txt");
   		if(f.exists()){
   			f.delete();
   			try {
   				f.createNewFile();
   			} catch (IOException e) {
   				e.printStackTrace();
   			}
   		}
   		   		
   		Game game=new Game(nameOfPlayers,numberOfPlayers); 
	   	game.startGame();

	} 
}
 