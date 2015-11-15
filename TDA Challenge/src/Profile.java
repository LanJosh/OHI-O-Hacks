import java.io.File;
import java.util.*;
/* Job dimensions
 * 
 * 0120 Joshua Lan
 * 
 */
public class Profile  {
	
	public coordinates point;
	
	public Profile(HashMap<String, Integer> keywords){
		File file = new File("src/Files/dictionary.txt");
		KeywordDictionary dict = new KeywordDictionary();
        
		// Read words to determine coordinates of job
		for (Map.Entry<String, Integer> word : keywords.entrySet()){
			for (Map.Entry<String, Set<String>> dimensions : dict.DimensionDict.entrySet()){
				if (dimensions.getValue().contains(word.getKey())){
					int weight = word.getValue();
					switch (word.getKey()) {
					case "Business":
						point.business += weight;
						break;
					case "Science":
						point.science += weight;
						break;
					case "Eng":
						point.eng += weight;
						break;
					case "cs":
						point.cs += weight;
						break;
					default:
							break;
					}
				}
			}
		}
	}

	public int compareTo(Profile profile) {
		return this.point.compareTo(profile);
	}
	
}
