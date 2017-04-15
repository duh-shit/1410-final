import java.io.*;

public class Teacher extends Person {
	
	/**
	 * Fields
	 */
	private String courseTitle;
	
	/**
	 * Constructors
	 */
	public Teacher() {
		super();
	}

	public void reader() {
		File path = new File("C:\\Users\\gnogu\\Desktop.teacherfile.dat");
		
		
	}
	
	
	/**
	 * Methods
	 */
	
	@Override
	public String toString() {
		return "Teacher [courseTitle=" + courseTitle + " "  + super.toString() + "]";
	}

}
