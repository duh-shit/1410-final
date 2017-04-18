
public class Student extends Person {
	/****************************************************************************************
	 * Fields
	 *
	 ****************************************************************************************/
	private double gpa;
	
	
	/****************************************************************************************
	 * Constructors
	 * 
	 ****************************************************************************************/
	/**
	 * Empty Constructor
	 * 
	 */
	public Student() {
	super();
	}
	
	/**
	 * Overloaded constructor
	 * 
	 * @param fName
	 * @param lName
	 * @param courseTitle
	 * @param gpa
	 */
	public Student(String fName, String lName, String courseTitle, double gpa) {
		super(fName, lName, courseTitle);
		this.gpa = gpa;
		count++;
		idNumber += count;
		//idNumber += count; Change to protected? 
	}
	
	/*****************************************************************************************
	 * Methods
	 * 
	 *****************************************************************************************/
	
	/**
	 * @return the gpa
	 */
	public double getGpa() {
		return gpa;
	}
	
	/**
	 * @param the new gpa
	 */
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	/*
	 * (non-Javadoc)
	 * @see Person#toString()
	 */
	@Override
	public String toString() {
		return String.format("%s Gpa: %.2f", super.toString(), getGpa());
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////
	//test
	//////////////////////////////////////////////////////////////////////////////////////////////
	public static void main (String[] args) {
		Student s = new Student("Trevor","Martin", "CSIS1410", 3.0);
		System.out.print(s.toString());
	}


}

