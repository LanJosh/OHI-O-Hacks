
/**
 * @author Aaron Pycraft
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class StudentDataParser {
    //--Variables
    private HashMap<String, Integer> studentInfo; //--word data of one student
    protected ArrayList<HashMap<String, Integer>> allStudentData; //--word data of ALL students
    protected File file;

    //--Constructor
    public StudentDataParser(File file) {
        this.studentInfo = new HashMap<String, Integer>();
        this.file = file;
        this.allStudentData = new ArrayList<HashMap<String, Integer>>();
    }//end constructor

    //--Methods 
    public ArrayList<HashMap<String, Integer>> parse(File file) {
        try {

            Scanner fIn = new Scanner(file);
            String[] columnTitles = fIn.nextLine().split(",|^|^^|\"|\"\"");

            //--Print the column titles
//		  for(int i = 0; i < columnTitles.length; i++) {
//			  if(!isWordMeaningless(columnTitles[i])) {
//				  System.out.print(columnTitles[i] + "\t");
//			  }//end if
//		  }//end loop
//		  System.out.println();

            //--Variable to track which row of data we're processing
            int studentEntryNum = 0;

            //--Loop through all lines (all students) in the file
            while (fIn.hasNext()) {

                //--Use a hashmap to hold the keywords and the wordcount for this student
                HashMap<String, Integer> data = new HashMap<String, Integer>();

                //--Pull each line into an array of words
                String[] lineInput = fIn.nextLine().split("\\W");

//--debugging print
//System.out.println("Number of words on this line (row) = " + lineInput.length);

                //--For each word in the line, add the word to our word occurrences count
                for (int i = 0; i < lineInput.length; i++) {
//--debugging print
//System.out.print("i = " + i + "\t");
//if(i == 65)
//	System.out.print("");
                    //--Convert string to lower case
                    lineInput[i] = lineInput[i].toLowerCase();

                    //--Print out all words in the line
//				  for(int j = 0; j < lineInput.length; j++) {
//					  System.out.print(lineInput[i] + "\t");
//				  }//end loop

                    //--Eliminate any 'useless' words, or null characters
                    if (this.isWordMeaningless(lineInput[i])) {
                        continue;
                    } //end if

                    //--If the word is already contained, increment the occurrence count				  //--In
                    if (data.containsKey(lineInput[i])) {
                        String key = lineInput[i];
                        data.put(key, data.get(key) + 1);
                    } //end if

                    //--Otherwise, add the new word to the map
                    else if (lineInput[i] != null) {
                        data.put(lineInput[i], 1);
                    }

//--debugging print
//System.out.println("key: \"" + lineInput[i] + "\" was incremented to " + data.get(lineInput[i]));

                } //end loop (for each word in the line)

                //--Visually Separate each read line
//			  System.out.println("\n");

//--Debug pring
//for (Map.Entry<String,Integer> entry : data.entrySet()) {
//	  String key = entry.getKey();
//	  Integer value = entry.getValue();
//	  System.out.println("Key: \"" + key + "\"\t val: " + value);
                // do stuff
//}//end loop

                //--Add completed hashmap object to the array list to the corresponding
                //  row number
                System.out.println("Done with row: " + studentEntryNum);
                this.allStudentData.add(studentEntryNum++, data);
                //--Trash the hashmap, we've already copied the data to the ArrayList
                data = null;

            } //end loop (end of file)

            fIn.close();
        } //end try 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } //end catch
        catch (NullPointerException e) {
            e.printStackTrace();
        } //end catch
//--debug print
//System.out.println("DONE with parse method");
        return this.allStudentData;
    }//--end method  

    //--Method to determine if a string is numeric
    boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }//end method

    //--Determines whether or not a word is not important to the skill matching of this program
    //  return value possibilities: false = important, true = meaningless
    boolean isWordMeaningless(String word) {

        //--white space characters re not important
        if (word.equals(" ")) {
            return true;
        }
        if (word.equals(null)) {
            return true;
        }
        if (word.length() == 0) {
            return true;
        }
        if (word.equals("")) {
            return true;
        }

        //--Numeric words are important
        if (this.isNumeric(word)) {
            return false;
        }
        //--C Language characters are important
        if (word.contains("c") && (word.length() == 3 || word.length() == 1
                || word.length() == 11)) {
            return false;
        }
        //--The word IT (information technology) is important
        if (word.equals("it")) {
            return false;
        }

        //--Blank words, and one character words other than "C" are not important
        if (word.length() <= 3) {
            return true;
        }

        //--Otherwise, its 'probably' important
        return false;

    }//end method

}//end class
