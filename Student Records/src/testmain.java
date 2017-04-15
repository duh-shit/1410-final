import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class testmain {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("C:\\Users\\gnogu\\Desktop.teacherfile.dat");
		file.getParentFile().mkdirs();
		

			PrintWriter pw = new PrintWriter(file);
			
			


	}

}
