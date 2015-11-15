/** 
 * @author Aaron Pycraft
 */
import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class StudentDataParser {
  //--Variables
  protected HashMap <String, Integer> studentInfo;
  protected File file;
  
  //--Constructor
  public StudentDataParser(File file) {
		this.studentInfo = new HashMap<String,Integer>();
		this.file = file;
	}//end constructor
  
  //--Methods 
  public void parse(File file) {
	  try {
		  HashMap<String,Integer> data = new HashMap<String,Integer>();
		  Scanner fIn = new Scanner(file);
		  String[] columnTitles = fIn.nextLine().split(",|^|^^|\"|\"\"");

		  //--Print the column titles
		  for(int i = 0; i < columnTitles.length; i++) {
			  if(!isWordMeaningless(columnTitles[i])) {
				  System.out.print(columnTitles[i] + "\t");
			  }//end if
		  }//end loop
		  System.out.println();
		  
		  //--Loop through the entire file
		  while (fIn.hasNext()) {
			  //--Pull each line into an array
			  String[] lineInput = fIn.nextLine().split("\\W");  
//--debugging print			  
System.out.println("lineInput.length = " + lineInput.length);

			  //--For each word in the line, add it to our word occurrences count
			  for(int i = 0; i < lineInput.length; i++) {
//--debugging print
System.out.print("i = " + i + "\t");
//if(i == 65)
//	System.out.print("");

				  //--Convert string to lower case
				  lineInput[i] = lineInput[i].toLowerCase();

				  //--Eliminate any 'useless' words, or null characters
				  if( isWordMeaningless(lineInput[i])) {
					  continue;
				  }//end if
				  
				  if(lineInput[i] != null)
				  if(data.containsKey(lineInput[i])) {
					  int currVal = data.get(lineInput[i]);
					  //--If the word is already contained, increment the occurrence count
					  data.put(lineInput[i], currVal+1);
				  
				  }//end if
				  //--Otherwise, add the new word to the map, Unless it's null and hasn't been caught
				  if(lineInput[i] != null) data.put(lineInput[i], 1);

//--debugging print
System.out.println("key: \"" + lineInput[i] + "\" was incremented to " + data.get(lineInput[i]));
				  				  
			  }//end loop
			  
			  //--Visually Separate each read line
			  System.out.println("\n");
        	  
          }//end loop
		  fIn.close();
      }//end try 
	  catch (FileNotFoundException e) {
          e.printStackTrace();
      }//end catch
	  catch (NullPointerException e) {
		  e.printStackTrace();
	  }//end catch
      
    }//--end method  
  
  //--Method to determine if a string is numeric
  boolean isNumeric(String str) { 
  	return str.matches("-?\\d+(\\.\\d+)?");
  }//end method
  
  //--Determines whether or not a word is not important to the skill matching of this program
  //  return value possibilities: false = important, true = meaningless
  boolean isWordMeaningless(String word) {
	  
	  //--white space characters re not important
	  if(word.equals(" "))	
		  return true;
	  if(word.equals(null)) 
		  return true;
	  if(word.length() == 0)
		  return true;
	  if(word.equals("")) 	
		  return true;
	  
	  //--Numeric words are important
	  if (isNumeric(word)) 		
		  return false;
	  //--C Language characters are important
	  if (word.contains("c") && (word.length() == 3 || word.length() == 1 || word.length() == 11) ) 	
		  return false;
	  //--The word IT (information technology) is important
	  if (word.equals("it")) 	
		  return false;
	  
	  //--Blank words, and one character words other than "C" are not important
	  if(word.length() <= 3) return true;
	  
	  //--Otherwise, its 'probably' important
	  return false;
	  
  }//end method
		  

}//end class



