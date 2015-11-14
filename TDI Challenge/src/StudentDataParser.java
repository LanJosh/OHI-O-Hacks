
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentDataParser implements IParser{
  //--Variables
  private ArrayList <String[]> studentInfo;
  private File file;
  
  //--Constructor
  public StudentDataParser(File file) {
		studentInfo = new ArrayList<String[]>();
		this.file = file;
	}//end constructor
  
  //--Methods
  public ArrayList<String[]> parse(File file) {
	  try {
		  
		  Scanner fIn = new Scanner(file);
		  fIn.useDelimiter("^");
		  
		  
          //--Loop through the entire file
		  while (fIn.hasNext()) {
			  System.out.println(fIn.next());
        	  
              
          }//end loop
		  fIn.close();
      }//end try 
	  catch (FileNotFoundException e) {
          System.out.println("FILE NOT FOUND");
          e.printStackTrace();
      }//end catch
      
    return studentInfo;
    }//--end method

}//end class



