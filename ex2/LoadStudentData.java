package WS;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

public class LoadStudentData {
  public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException, EOFException {
	  
    JFileChooser choosefile = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
    choosefile.setAcceptAllFileFilterUsed(false);
    FileNameExtensionFilter filter = new FileNameExtensionFilter(".ser & .txt only", "ser", "txt");
    choosefile.addChoosableFileFilter(filter);
    int value = choosefile.showOpenDialog(null);
    
      if (value == JFileChooser.APPROVE_OPTION) {
        File file = choosefile.getSelectedFile();
        try {
        	FileInputStream is = new FileInputStream(file);
			ObjectInputStream obj_is = new ObjectInputStream(is);
			boolean flag = true;
			int counter = 0;
			do {
				//Student st = (Student) obj_is.readObject();
				
				List<Student> st = (List<Student>)obj_is.readObject();
				
				if(st.isEmpty())
					flag = false;
				else {
					counter++;
					System.out.println("Student " + "0" + counter + " -->");
					System.out.println(st.get(0));
				}				
			}while(flag);
			is.close();			
        }catch (EOFException endOfFileException) {
			System.out.println("\nEnd of file...");
		}catch (FileNotFoundException e) {
			System.out.println(e);} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
      } else {
        System.out.println("CANCELLED");
      }

  }
}
