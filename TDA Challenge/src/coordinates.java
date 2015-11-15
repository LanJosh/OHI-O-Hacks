import java.lang.Math;
/*
 * Coordinate point of profile
 * 
 * 0218 Joshua Lan
 */
public class coordinates {
	// Dimensions
	int science;
	int business;
	int eng;
	int cs;
	
	public coordinates(){
		science = 0;
		business = 0;
		eng = 0;
		cs = 0;
	}
	
	/* 
	 * Returns a score corresponding to how close the participate was to fulfilling expected requirements. 
	 * Closer to zero the better
	 */
	public int compareTo(Profile profile){		
		coordinates compare = profile.point;

		int scienceDiff = Math.abs(compare.science - science);
		int businessDiff = Math.abs(compare.business - business);
		int engDiff = Math.abs(compare.eng - eng);
		int csDiff = Math.abs(compare.cs - cs);
		
		
		return scienceDiff + businessDiff + engDiff + csDiff;
	}
}
