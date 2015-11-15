/*
 * Coordinate point of profile
 * 
 * 0218 Joshua Lan
 */
public class coordinates {
	// Dimensions
	int engineering;
	int math;
	int science;
	int business;
	
	public coordinates(){
		engineering = 0;
		math = 0;
		science = 0;
		business = 0;
	}
	
	/* 
	 * Returns a score corresponding to how close the participate was to fulfilling expected requirements. 
	 * Closer to zero the better
	 */
	public int compareTo(Profile profile){
		coordinates comparePoint = profile.point;
		
		comparePoint.engineering = comparePoint.engineering - this.engineering;
		comparePoint.math = comparePoint.math - this.math;
		comparePoint.science = comparePoint.science - this.science;
		comparePoint.business = comparePoint.business - this.business;
		
		return comparePoint.engineering + comparePoint.math + comparePoint.science + comparePoint.business;
	}
}
