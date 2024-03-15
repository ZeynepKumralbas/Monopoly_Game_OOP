import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class WriteToFile {

	BufferedWriter writer;
	
	public WriteToFile(String write, String newLine){
		
      try {
      	//creates a file
          File myFile = new File("out.txt");
	       
          //Writes to the file
          writer = new BufferedWriter(new FileWriter(myFile, true)); 
          writer.write(write);
          
          if(newLine.equals("y")){
        	  writer.newLine();
          }
                  
      } 
      
      catch (Exception e) {
          e.printStackTrace();
      } 
      
      finally {
      	
      	try {         
              writer.close();
          } 
      	
      	catch (Exception e2) {
      		System.out.println("Writer cannot be closed");
          }
      	
      }
      
	}	
}

