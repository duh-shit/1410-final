
/**
 * @authors Gabriel, Ryan Wheeler, Aidan, Daniel Silva, Jose??
 *
 */
public class Student extends Person 
	{
	///////////////////////////////////////////////////////////////////////////////////
	//Attributes
	///////////////////////////////////////////////////////////////////////////////////
	private double gpa;
	
	///////////////////////////////////////////////////////////////////////////////////
	//Constructors
	///////////////////////////////////////////////////////////////////////////////////
	/**
	 * Empty Constructor
	 * 
	 */
	public Student() 
	{
	super();
	}
	
	/**
	 * Overloaded constructor that takes the following parameters and assigns them
	 * to their corresponding attribute.
	 * 
	 * @param fName
	 * @param lName
	 * @param courseTitle
	 * @param gpa
	 */
	public Student(String fName, String lName, String courseTitle, double gpa) 
	{
		super(fName, lName, courseTitle);
		this.gpa = gpa;
		count++;
		idNumber += count;
 
	}
	
	///////////////////////////////////////////////////////////////////////////////////
	//Methods
	///////////////////////////////////////////////////////////////////////////////////
	/**
	 * @return the gpa
	 */
	public double getGpa() 
	{
		return gpa;
	}
	
	/**
	 * @param the new gpa
	 */
	public void setGpa(double gpa) 
	{
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
}

