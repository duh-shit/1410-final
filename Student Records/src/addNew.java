import java.util.*;
import java.io.FileWriter;
import java.io.*;

public class addNew extends Person{
	Scanner input = new Scanner(System.in);
	
	public String fName;
	public String lName;
	public String gpa;
	
	ArrayList<Person> students = new ArrayList<Person>();
	
	
	public void addStudent(ArrayList<Person> array){
		System.out.print("First Name: ");
		input.nextLine();
		fName = input.nextLine();
		System.out.print("Last Name: ");
		lName = input.nextLine();
		System.out.print("GPA:");
		gpa = input.nextLine();
		Double.parseDouble(gpa);
		System.out.println();
		students.add(new Person(fName, lName, gpa));
		
	}
	
	public void createFile(String file, ArrayList<Person> arrData)
        throws IOException {
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
    }
	

	@Override
	public String toString(){
		return "Student " + fName + " " + lName +
				" has been added.";
	}
}



 