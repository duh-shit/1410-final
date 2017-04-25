import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @authors Gabriel, Ryan Wheeler, Aidan Hubert, Daniel Silva, Jose??
 *
 */
public class Person 
{
	///////////////////////////////////////////////////////////////////////////////////
	//Attributes
	///////////////////////////////////////////////////////////////////////////////////
    private String fName;
    private String lName;
    private String courseTitle;
    protected int idNumber;   
    protected static int count = 1234567;
    
	///////////////////////////////////////////////////////////////////////////////////
	//Constructors
	///////////////////////////////////////////////////////////////////////////////////
    
    /**
     * Empty constructor for person object. Assigns idNumber to counter and increments
     * by 1 after execution.
     */
    public Person()
    {
       idNumber = count++;
    }
    
    /**
     * Constructor for Person that passes the following parameter and assigns them to
     * their corresponding fields.
     * @param fName
     * @param lName
     * @param courseTitle
     */
    public Person(String fName, String lName, String courseTitle) 
    {
       this.fName = fName;
       this.lName = lName;
       this.courseTitle = courseTitle;
       idNumber = count++;
    }
    
    /**
     * 
     * @return First Name 
     */
   public String getFirstName()
   {
	   return fName;
   }
    
   	/**
   	 * 
   	 * @return last name 
   	 */
   public String getLastName()
   {
	   return lName;
   }
   
   /**
    * 
    * @return Course title
    */
   public String getCourse() 
   {
	   return courseTitle;
   }
   
   /**
    * 
    * @return ID Number
    */
   public Integer getIDNumber() 
   {    
	   return idNumber;
   }
   
   /**
    * This method reads in a database file in .txt or .dat format and adds each
    * object to an arraylist of Person()s.
    * @return ArrayList of type Person()
    * @throws IOException
    */
   public static ArrayList<Person> reader() throws IOException 
   {
			
		FileReader pw = new FileReader(MainGUI.openFileChooser());// sets file to be read
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
	
				Person t = new Person(fName, lName, coarseTitle);
				list.add(t);// adds to Teacher Array
				
			} else
				break;
		}
		return list;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
   @Override
   public String toString() {  
       return getFirstName() +" " +getLastName() + " " +
             + getIDNumber() + "(Course(s): " + getCourse();
    }
   
	public String[] toStringArray()
	{
		return new String[]{getIDNumber().toString(), getFirstName(), getLastName(), getCourse()};
	}

}
	
