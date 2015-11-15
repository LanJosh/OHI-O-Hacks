
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
		  
          //--Loop through the entire file
		  while (fIn.hasNext()) {
			  //--Pull each line into an array
			  String[] lineInput = fIn.nextLine().split("\\W");
			 
			  for(int i = 0; i < lineInput.length; i++) {
				  
				  //--Eliminate any one letter words, except the language 'C'
				  if( isWordMeaningless(lineInput[i])) {
					  continue;
				  }//end if
				  
				  //--Process the word 
				  processWord(lineInput[i]);
				  
System.out.print(lineInput[i] + " ");
			  }//end loop
			  
			  //--Visually Separate each read line
			  System.out.println("\n");
        	  
              
          }//end loop
		  fIn.close();
      }//end try 
	  catch (FileNotFoundException e) {
          System.out.println("FILE NOT FOUND");
          e.printStackTrace();
      }//end catch
      
    return studentInfo;
    }//--end method
  
  private void processWord(String word) {
	  StringBuffer sb = new StringBuffer();
	  
  }//end method
  
  //--Method to determine if a string is numeric
  boolean isNumeric(String str) { 
  	return str.matches("-?\\d+(\\.\\d+)?");
  }//end method
  
  //--Determines whether or not a word is not important to the skill matching of this program
  boolean isWordMeaningless(String word) {
	  String[] commonWords = {"the", "how", "because", "why", "have", "with", "that"}; //etc
	  for (String s : commonWords) {
		  if (word.equals(s)) return true;
	  }
	  if(!word.equals("C") && word.length() <= 2) return true;

	  return false;
  }//end method
		  

}//end class



