import java.util.*;
import java.io.FileWriter;
import java.io.*;

public class addNew extends Person{
	Scanner input = new Scanner(System.in);
	
	public static String fName;
	public static String lName;
	public static String gpa;
	
	public static ArrayList<Person> students = new ArrayList<Person>();
	
	public static boolean addStudent()
	{
		return addStudent(students);
	}
	public static boolean addStudent(ArrayList<Person> array){
//		System.out.print("First Name: ");
//		input.nextLine();
//		fName = input.nextLine();
//		System.out.print("Last Name: ");
//		lName = input.nextLine();
//		System.out.print("GPA:");
//		gpa = input.nextLine();
//		Double.parseDouble(gpa);
//		System.out.println();
//		
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
        throws IOException {
		try{
	        FileWriter writer = new FileWriter(file);
	        int size = arrData.size();
	        for (int i=0;i<size;i++) {
//	            String str = arrData.get(i).toString();
//	            writer.write(str);
//	            	if(i < size-1)
//	            		writer.write("\n");
            		//This prevent creating a blank like at the end of the file**
	        	for(String s: arrData.get(i).toStringArray())
	        	{
	        		writer.write(s + "\n");
	        	}
	        }
	        writer.close();
	            	return true;
	        }catch(Exception e){return false;}
	    }
	    
	public ArrayList<Person> searchFirstName(ArrayList<Person> fullList, String fName){
		ArrayList<Person> searched = new ArrayList<Person>();
		for(Person p : fullList){
			if(p.getFirstName().contains(fName)){
				searched.add(p);
			}
		}
		return searched;
	}
	
	public ArrayList<Person> searchLastName(ArrayList<Person> fullList, String lName){
		ArrayList<Person> searched = new ArrayList<Person>();
		for(Person p : fullList){
			if(p.getLastName().contains(lName)){
				searched.add(p);
			}
		}
		return searched;
	}
	
	public ArrayList<Person> searchSNumber(ArrayList<Person> fullList, Integer sNumber){
		ArrayList<Person> searched = new ArrayList<Person>();
		for(Person p : fullList){
			if(p.getIDNumber() == sNumber){
				searched.add(p);
			}
		}
		return searched;
	}
    
	

	@Override
	public String toString(){
		return "Student " + fName + " " + lName +
				" has been added.";
	}
}



 