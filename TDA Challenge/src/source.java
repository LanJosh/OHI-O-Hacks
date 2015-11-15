
import java.io.*;
import java.net.URL;
import java.util.ArrayList;import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class source {
	
	public static void main(String[] args) {
		System.out.println("Running!\n");
		AnalysisTool analyzer = new AnalysisTool();
		String cwd = new File("src/files/TDA Students Test.csv").getAbsolutePath();
		File studentData = new File(cwd);
	//	analyzer.studentAverage(studentData);
		
		
		
		
		
		
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
		
	}//end main

}//end class
