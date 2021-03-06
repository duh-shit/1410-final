import java.util.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.io.FileWriter;
import java.io.*;

/**
 * @authors Gabriel, Ryan Wheeler, Aidan Hubert, Daniel Silva, Jose Zizumbo
 *
 */
public class LookupEdit extends Person
{
	
	///////////////////////////////////////////////////////////////////////////////////
	//Attributes
	///////////////////////////////////////////////////////////////////////////////////
	Scanner input = new Scanner(System.in);
	public static String fName;
	public static String lName;
	public static String gpa;
	public static ArrayList<Person> students = new ArrayList<Person>();
	
	/**
	 *This is an empty default method of no parameters are specified in the method call.
	 * @return true or false
	 */
	public static boolean addStudent()
	{
		return addStudent(students);
	}
	
	/**
	 * This method writes a file by reading in an ArrayList of Student objects
	 * from the addStudent() method.
	 * 
	 * @param file
	 * @param arrData
	 * @return
	 * @throws IOException
	 * @see addStudent
	 */
	public static boolean addStudent(ArrayList<Person> array){
		try
		{
			fName = MainGUI.openInputField("Please Enter First Name");
			lName = MainGUI.openInputField("Please Enter Last Name");
			gpa = MainGUI.openInputField("Please Enter GPA");
			array.add(new Person(fName, lName, gpa));
			return true;
		}catch(Exception e)
		{
			return false;
		}
	}
	
	/**
	 * 
	 * @param file
	 * @param arrData
	 * @return
	 * @throws IOException
	 */
	public static boolean createFile(String file, ArrayList<Person> arrData)
        throws IOException 
	{
		try
		{
	        FileWriter writer = new FileWriter(file);
	        int size = arrData.size();
	        for (int i=0;i<size;i++) 
	        {

	        	for(String s: arrData.get(i).toStringArray())
	        	{
	        		writer.write(s + "\n");
	        	}
	        }
	        writer.close();
	            	return true;
	        }catch(Exception e){return false;}
	    }
	
	/**
	 * This method searches the current database by the firstName field of each object. It utilizes .contains()
	 * to include partial entries. 
	 * @param fullList
	 * @param lName
	 * @return
	 */
	public static ArrayList<Person> searchFirstName(ArrayList<Person> fullList, String fName)
	{
		ArrayList<Person> searched = new ArrayList<Person>();
		for(Person p : fullList)
		{
			if(p.getFirstName().toLowerCase().contains(fName.toLowerCase())){
				searched.add(p);
			}
		}
		if(searched.size() <= 0)
		{
			JOptionPane.showMessageDialog(new JFrame(), "No Entry Matches The Search Terms");
			searched.add(new Person("","",""));
		}
		return searched;
	}

	/**
	 * This method searches the current database by the lastName field of each object. It utilizes .contains()
	 * to include partial entries. 
	 * @param fullList
	 * @param lName
	 * @return
	 */
	public static ArrayList<Person> searchLastName(ArrayList<Person> fullList, String lName)
	{
		ArrayList<Person> searched = new ArrayList<Person>();
		for(Person p : fullList)
		{
			if(p.getLastName().toLowerCase().contains(lName.toLowerCase()))
			{
				searched.add(p);
			}
		}
		if(searched.size() <= 0)
		{
			JOptionPane.showMessageDialog(new JFrame(), "No Entry Matches The Search Terms");
			searched.add(new Person("","",""));
		}
		return searched;
	}
	
	/**
	 * This method searches the current database by the sNumber lastName field of each object. It utilizes .contains()
	 * to include partial entries. 
	 * @param fullList
	 * @param lName
	 * @return
	 */
	public static ArrayList<Person> searchSNumber(ArrayList<Person> fullList, String sNumber)
	{
		ArrayList<Person> searched = new ArrayList<Person>();
		for(Person p : fullList)
		{
			if(p.getIDNumber().toString().contains(sNumber))
			{
				searched.add(p);
			}
			if(searched.size() <= 0)
			{
				JOptionPane.showMessageDialog(new JFrame(), "No Entry Matches The Search Terms");
				searched.add(new Person("","",""));
			}
		}
		return searched;
	}
    
	

	@Override
	public String toString()
	{
		return "Student " + fName + " " + lName +
				" has been added.";
	}
}



 