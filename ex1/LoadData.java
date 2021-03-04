package ws4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.EOFException;
import java.io.File;

public class LoadData {

	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
		
		File file = new File ("st.txt");
		try {
			if(!file.exists()) {
				throw new FileNotFoundException(file + " does not exist!");
			}
			else
			{				
			FileInputStream is = new FileInputStream(file);	
			ObjectInputStream obj_is = new ObjectInputStream(is);
			boolean flag = true;
			int counter = 0;			
			while(flag) {			
				Student st = (Student) obj_is.readObject();
				if(st == null) 
					flag = false;
				else		
				{
					counter++;
					System.out.println("Student " + "0" + counter + " -->");
					System.out.println("---------");
					System.out.println("Student ID: " + st.getstID());
					System.out.println("Student Full Name: " + st.getFullName());
					System.out.println("Student Course(s): " + st.getCourses());
					System.out.println("--------------------------------------------------");
				}}
			is.close();
		}}catch (EOFException endOfFileException) {
			System.out.println("\nEnd of file...");
		}catch (FileNotFoundException e) {
			System.out.println(e);}
	}


}
