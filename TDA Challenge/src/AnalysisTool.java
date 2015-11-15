import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
/*
 * Used to perform different analysis on data
 * 
 * 0218 Joshua Lan
 */
public class AnalysisTool {
	
	public ArrayList<Profile> processStudents(File studentData){
		ArrayList<Profile> studentProfiles = new ArrayList();
		
		StudentDataParser sdp = new StudentDataParser(studentData);
		ArrayList<HashMap<String, Integer>> studentRawDimensions = sdp.parse(studentData);
		
		for (HashMap<String, Integer> student : studentRawDimensions){
			Profile studentProfile = new Profile(student);
			studentProfiles.add(studentProfile);
		}
		return studentProfiles;
	}
	
	public void studentAverage(File studentData){
		ArrayList<Profile> studentProfiles = processStudents(studentData);
		
		int Eng = 0;
		int CS = 0;
		int Business = 0;
		int Science = 0;
		
		for (Profile student : studentProfiles){
			Eng += student.point.eng;
			CS += student.point.cs;
			Business += student.point.business;
			Science += student.point.science;
		}
		Eng = Eng / studentProfiles.size();
		CS = CS / studentProfiles.size();
		Business = Business / studentProfiles.size();
		Science = Science / studentProfiles.size();
		System.out.println("Eng Avg: " + Eng);
		System.out.println("CS Avg: " + CS);
		System.out.println("Business Avg: " + Business);
		System.out.println("Science Avg: " + Science);
	}
	// Find average weaknesses of all student profiles vs. a job profile
	public void studentWeaknesses(File studentData, Profile job){
		// Create student profiles out of studentData
		ArrayList<Profile> studentProfiles = processStudents(studentData);
		
		// Create job profile out of jobData
		
		// Iterate over profiles, keep track of average difference in each dimension
		for (int i = 0; i < studentProfiles.size(); i++){
			Profile student = studentProfiles.get(i);
			
		}
		
		// Print analysis information
	}
	
	// Find all job profiles matching a student profile
	public void matchingJobs(Profile studentData, File jobData){
		// Create student profiles out of studentData
		
		// Create job profile out of jobData
		
		// Iterate over profiles, keep id #'s of jobs where requirements met
		
		// Print all job id's that student satisfied
	}
	
	// Prints out the top student for the job.
	public void matchingStudents(Profile job, File studentData){
		// Create student profiles out of studentData
		System.out.println("These students met your requirements");
		ArrayList<Profile> studentProfiles = processStudents(studentData);
		
		// Iterate over profiles, keep id #'s of students where requirements met
		Profile student = studentProfiles.get(0);
		int bestScore = student.compareTo(job);
		int studentID = 0;
		for (int i = 1; i < studentProfiles.size(); i++) {
			student = studentProfiles.get(i);
			if (bestScore > student.compareTo(job)){
				studentID = i;
				bestScore = student.compareTo(job);
			}
		}
		
		System.out.println("The best student score belonged to " + studentID);
	}
}
