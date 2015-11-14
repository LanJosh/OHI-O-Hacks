import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

/*
 * Parses ^ delimited file containing job information
 * 
 * 1459 Joshua Lan
 */
public class JobsParser implements IParser  {

	public ArrayList <String[]> allJobInfo;
	public File data;
	
	public JobsParser(File data){
		allJobInfo = new ArrayList<String[]>();
		this.data = data;
	}
	
    public ArrayList<String[]> parse(File data) {
        try (Scanner sc = new Scanner(data)){
            sc.useDelimiter("^");

            // Data contains 5 columns
            while (sc.hasNext()){
                for (int i = 0; i < 5; i++) {
                String[] jobInfo = new String[5];
                String descriptionData = sc.next(); 
                System.out.print(descriptionData + "|");
                jobInfo[i] = descriptionData;
                allJobInfo.add(jobInfo);
                System.out.println();
                }
            }
        } catch (Exception e) {
            System.out.println("File Not Found");
        }
        
    return allJobInfo;
    }

}
