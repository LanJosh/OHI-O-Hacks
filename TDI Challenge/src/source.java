

import java.io.*;
import java.net.URL;

public class source {

	public static void main(String[] args) {
		System.out.println("Running!\n");
		try {
		// TODO Read data from files
			String cwd = new File("src/Files/TDA Students Test.csv").getAbsolutePath();
			System.out.println(cwd);
			File studentData = new File(cwd);
			StudentDataParser sdp = new StudentDataParser(studentData);
        	sdp.parse(studentData);
        	
		// TODO Parse data & return weights
		
		// TODO Parse weights & make profiles
		
		// TODO Print results
		} catch(Exception e) {
			e.printStackTrace();
		}//end catch
		
	}//end main

}//end class
