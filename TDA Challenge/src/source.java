
import java.io.*;
import java.net.URL;
import java.util.ArrayList;

public class source {

	public static void main(String[] args) {
		System.out.println("Running!\n");
	/*	try {
		// TODO Read data from files
			//--Read student resume data
			String cwd =  new File("src/Files/TDA Students Test.csv").getAbsolutePath();
//System.out.println(cwd);
			File studentData = new File(cwd);
			StudentDataParser sdp = new StudentDataParser(studentData);
        	sdp.parse(studentData);
        	
        	//--Read job postings data
        	//TODO add file input code here
//        	String jobsDataPath =  new File("src/Files/TDA Jobs Data Test.csv").getAbsolutePath();
//			System.out.println(jobsDataPath );
//			File jobData = new File(jobsDataPath);
//			JobsParser jp = new JobsParser(jobData);
//        	jp.parse(jobData);
        	
		// TODO Parse data & return weights
		
		// TODO Parse weights & make profiles
		
		// TODO Print results
		} catch(Exception e) {
			e.printStackTrace();
		}//end catch
		*/
		ArrayList<String[]> test = new ArrayList<String[]>();
		ArrayList<String[]> test2 = new ArrayList<String[]>();
		
		try {
			String jobsDataFile = new File("src/Files/test").getAbsolutePath();
			File jobsData = new File(jobsDataFile);
			JobsParser jp = new JobsParser(jobsData);
			test = jp.parse(jobsData);
			test2 = jp.employerProfiles;
			System.out.println(test.size());
			System.out.println(test2.size());

		} catch(Exception e) {
			e.printStackTrace();
		}
	}//end main

}//end class
