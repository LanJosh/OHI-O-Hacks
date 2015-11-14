import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 
 * 
 * @author Ethan Wolfe
 *
 */
public class PointWeigher {
	List<String[]> dataSet;
	List<String> words;
	Map<String, Integer> wordFrequency;
	
	/**
	 * @param: an ArrayList<String[]> where each string[] is a row and each string is a column
	 */
	public PointWeigher(ArrayList<String[]> dataSet) {
		this.dataSet = dataSet;
		words = new ArrayList<>();
		wordFrequency = new HashMap<>();
	}
	
	/**
	 * Creates a list of all words
	 */
	public void parseForWords() {
		for (String[] row : dataSet) {
			for (String column: row) {
				List<String> items = Arrays.asList(column.split("[ .,?!]+"));
				for (String item : items) {
					words.add(item);
				}
			}
		}
	}
	
	/**
	 * Creates a map that has the frequency of every word
	 */
	public void wordFrequency() {
	    for (String w : words) {
	        Integer n = wordFrequency.get(w);
	        n = (n == null) ? 1 : ++n;
	        wordFrequency.put(w, n);
	    }
	}
}
