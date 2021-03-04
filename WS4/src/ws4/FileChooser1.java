package ws4;

import java.awt.BorderLayout;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

public class FileChooser1 {
  public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException, EOFException {
	  
    JFileChooser choosefile = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
    choosefile.setAcceptAllFileFilterUsed(false);
    FileNameExtensionFilter filter = new FileNameExtensionFilter(".ser & .txt only", "ser", "txt");
    choosefile.addChoosableFileFilter(filter);
    

      int returnVal = choosefile.showOpenDialog(null);
      if (returnVal == JFileChooser.APPROVE_OPTION) {
        File file = choosefile.getSelectedFile();
        try {
        	FileInputStream is = new FileInputStream(file);
			ObjectInputStream obj_is = new ObjectInputStream(is);
			boolean flag = true;
			int counter = 0;
			do {
				Student st = (Student) obj_is.readObject();
				if(st == null)
					flag = false;
				else {
					counter++;
					System.out.println("Student " + "0" + counter + " -->");
					System.out.println("---------");
					System.out.println("Student ID: " + st.getstID());
					System.out.println("Student Full Name: " + st.getFullName());
					System.out.println("Student Course(s): " + st.getCourses());
					System.out.println("--------------------------------------------------");
				}				
			}while(flag);
			is.close();			
        }catch (EOFException endOfFileException) {
			System.out.println("\nEnd of file...");
		}catch (FileNotFoundException e) {
			System.out.println(e);} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
      } else {
        System.out.println("Operation is CANCELLED :(");
      }

  }
}
