
import java.io.*;
import java.util.Scanner;

public class StudentDataParser {
  //--Variables
  //--Methods
  void parse() {
    //--Establish communication with file
    File currDir = new File(".");
    File parentDir = currDir.getParentFile();
    File file = new File(parentDir,"/Documents/TDA Students Test.csv");
    
    //--Create object to read file
    try {
      Scanner reader = new Scanner(file);
      reader.useDelimiter("^ \"");
    
      if(reader.hasNext()) 
        System.out.println("Next word:\t" + reader.next());
      
      reader.close();
    }//end try 
    catch(FileNotFoundException e) {
      e.printStackTrace();
      System.out.println("FILE NOT FOUND");
    }//end catch

  }//--end method


}
