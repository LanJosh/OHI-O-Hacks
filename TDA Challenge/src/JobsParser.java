import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

/*
 * Parses tab delimited file containing job information
 * 
 * 1459 Joshua Lan
 */

public class JobsParser implements IParser  {

	public ArrayList <String[]> employerProfiles;
	public File data;
	
	public JobsParser(File data){
		employerProfiles = new ArrayList<String[]>();
		this.data = data;
	}
	
    public ArrayList<String[]> parse(File data) {
        try (Scanner sc = new Scanner(data)){
            // Data contains 5 columns
            while (sc.hasNext()) {
            	sc.useDelimiter("///");
            	String[] employerProfile = new String[5];
        		String line = "";
            	for (int i = 0; i < 5; i++) {
            		if (sc.hasNext()) {
            			 line = sc.next();
            		}
            		line.replaceAll("[^a-zA-Z0-9]+","");
            		employerProfile[i] = line;
            	}
            	// sc.nextLine();
            	
            	employerProfiles.add(employerProfile);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    return employerProfiles;
    }

}
