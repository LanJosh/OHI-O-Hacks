import java.util.*;
/* Job dimensions
 * 
 * 0120 Joshua Lan
 * 
 */
public class Profile  {
	
	public coordinates point;
	
	public Profile(HashMap<String, Integer> keywords){
		// Read words to determine coordinates of job
		for (Map.Entry<String, Integer> word : keywords.entrySet()){
			// If word is in a keyword set, increase that dimension
			
		}
	}

	public int compareTo(Profile profile) {
		return this.point.compareTo(profile);
	}
	
}
