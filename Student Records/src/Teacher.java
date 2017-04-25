import java.io.*;
import java.util.ArrayList;


/**
 * @authors Gabriel, Ryan Wheeler, Aidan Hubert, Daniel Silva, Jose??
 *
 */
public class Teacher extends Person 
{
	///////////////////////////////////////////////////////////////////////////////////
	//Constructors
	///////////////////////////////////////////////////////////////////////////////////

	/**
	 * Empty constructor for teacher object
	 */
	public Teacher() 
	{
		super();
	}
	
	/**
	 * Constructor 
	 * @param fName
	 * @param lName
	 * @param courseTitle
	 * @param id
	 */
	public Teacher(String fName, String lName, String courseTitle, int id) 
	{
		super(fName, lName, courseTitle);
		this.idNumber = id;
	}
	
	///////////////////////////////////////////////////////////////////////////////////
	//Methods
	///////////////////////////////////////////////////////////////////////////////////

	/**
	 * This method reads in a .dat file that has all of our teacher information recorded on it
	 * Once the rows are read in the method creates a Teacher object and adds it to the returning
	 * ArrayList.
	 * 
	 * @return ArrayList<Person>
	 * @throws IOException
	 */
	public static ArrayList<Person> reader() throws IOException 
	{
		
		FileReader pw = new FileReader("src/record/teacherfile.dat");// sets file to be read
		BufferedReader read = new BufferedReader(pw);// reads file
		
		int id = 0;
		String fName = "";
		String lName = "";
		String coarseTitle = "";
		
		ArrayList<Person> list = new ArrayList<Person>();
		while (true) {// loops threw and reads in each line of the file
			String line = read.readLine();
			if (line != null) {
				id = Integer.parseInt(line);
				fName = read.readLine();
				lName = read.readLine();
				coarseTitle = read.readLine();

				Teacher t = new Teacher(fName, lName, coarseTitle, id);
				list.add(t);// adds to Teacher Array
				
			} else
				break;
		}
		return list;
	}
	
	/**
	 * Getter for teacher's ID
	 * @return id
	 */
	public Integer getID() 
	{
		return idNumber;
	}
	
	/*
	 * (non-Javadoc)
	 * @see Person#toString()
	 */
	@Override
	public String toString() 
	{
		return String.format("%d\n%s %s\n %s\n", getID(), getFirstName(), getLastName(), getCourse());	
	}
	
	/*
	 * (non-Javadoc)
	 * @see Person#toStringArray()
	 */
	@Override
	public String[] toStringArray()
	{
		return new String[]{getID().toString(), getFirstName(), getLastName(), getCourse()};
	}
	

	


}
