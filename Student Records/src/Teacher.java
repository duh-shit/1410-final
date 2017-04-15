import java.io.*;
import java.util.ArrayList;

public class Teacher extends Person {

	/**
	 * Fields
	 */
	private int id;

	/**
	 * Constructors
	 */

	public Teacher() {
		super();
	}

	public Teacher(String fName, String lName, String courseTitle, int id) {
		super(fName, lName, courseTitle);
		this.id = id;
	}

	public static ArrayList<Teacher> reader() throws IOException {
		
		FileReader pw = new FileReader("src/record/teacherfile.dat");// sets file to be read
		BufferedReader read = new BufferedReader(pw);// reads file
		
		int id = 0;
		String fName = "";
		String lName = "";
		String coarseTitle = "";
		
		ArrayList<Teacher> list = new ArrayList<Teacher>();
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

	public int getID() {// gets the teacher id from list
		return id;
	}

	@Override
	public String toString() {
		return String.format("%d\n%s %s\n %s\n", getID(), getFirstName(), getLastName(), getCourse());
	}

	
	public static void main(String[] args) {// used to test to make sure working
		try {
			System.out.print(reader());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
