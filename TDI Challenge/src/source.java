

import java.io.*;
import java.net.URL;

public class source {

	public static void main(String[] args) {
		System.out.println("Running!\n");
		try {
		// TODO Read data from files
			//--Read student resume data
			String cwd =  new File("src/Files/TDA Students Test.csv").getAbsolutePath();
			System.out.println(cwd);
			File studentData = new File(cwd);
			StudentDataParser sdp = new StudentDataParser(studentData);
        	sdp.parse(studentData);
        	
        	//--Read job postings data
        	//TODO add file input code here
        	
        	
		// TODO Parse data & return weights
		
		// TODO Parse weights & make profiles
		
		// TODO Print results
		} catch(Exception e) {
			e.printStackTrace();
		}//end catch
		
	}//end main

}//end class
