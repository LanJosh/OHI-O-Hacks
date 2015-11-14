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
	public List<String[]> jobDataSet;
	public List<String[]> studentDataSet;
	
	/**
	 * 
	 * @param dataSet1: jobs ArrayList<String[]> where each string[] is a row and each string is a column
	 * @param dataSet2: students ArrayList<String[]> where each string[] is a row and each string is a column
	 */
	public PointWeigher(List<String[]> dataSet1, List<String[]> dataSet2) {
		jobDataSet = dataSet1;
		studentDataSet = dataSet2;
	}
	
	/**
	 * Creates a list of all words
	 * @param: the data set you want to parse
	 */
	public List<String> parseForWords(List<String[]> data) {
		List<String> words = new ArrayList<>();
		for (String[] row : data) {
			for (String column: row) {
				List<String> items = Arrays.asList(column.split("[ .,?!]+"));
				for (String item : items) {
					words.add(item);
				}
			}
		}
		return words;
	}
	
	/**
	 * Creates a map that has the frequency of every word
	 * @param: A list of strings
	 */
	public Map<String, Integer> getWordFrequency(List<String> words) {
		Map<String, Integer> wordFreq = new HashMap<>();
	    for (String w : words) {
	        Integer n = wordFreq.get(w);
	        n = (n == null) ? 1 : ++n;
	        wordFreq.put(w, n);
	    }
	    return wordFreq;
	}
}
