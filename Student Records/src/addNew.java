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
	
	public static boolean createFile(String file, ArrayList<Person> arrData)
        throws IOException {
		try{
	        FileWriter writer = new FileWriter(file + ".txt");
	        int size = arrData.size();
	        for (int i=0;i<size;i++) {
	            String str = arrData.get(i).toString();
	            writer.write(str);
	            	if(i < size-1)
	            		//This prevent creating a blank like at the end of the file**
	            		writer.write("\n");
	        }
	        writer.close();
	            	return true;
	        }catch(Exception e){return false;}
	    }
	    
    
	

	@Override
	public String toString(){
		return "Student " + fName + " " + lName +
				" has been added.";
	}
}



 