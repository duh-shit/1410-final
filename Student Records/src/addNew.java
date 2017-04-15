import java.util.*;
public class addNew extends Person{
	Scanner input = new Scanner(System.in);
	
	public String fName;
	public String lName;
	public double gpa;
	
	ArrayList<Person> students = new ArrayList<Person>();
	
	public void addStudent(ArrayList<Person> array){
		System.out.print("First Name: ");
		input.nextLine();
		fName = input.nextLine();
		System.out.print("Last Name: ");
		lName = input.nextLine();
		System.out.print("GPA:");
		gpa = input.nextDouble();
		System.out.println();
		//students.add(new Person(fName, lName, gpa));
	}
	
	@Override
	public String toString(){
		return "Student " + fName + " " + lName +
				" has been added.";
	}
}


//students.add(new Student(fName, lName, major, gpa));

 