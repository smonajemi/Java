package WS;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

@SuppressWarnings("serial")
class AddStudent extends Student implements ActionListener{
	private JFrame frame = new JFrame();
	private Container container;
	private JLabel title,fname,lname,studentid,courses,save;
	private JTextField txtfname,txtlname,txtid,txtcourses;
	private JButton subButton,saveButton,exitButton;
	int c = 0;
	boolean flag = true;
	ArrayList<Student> students = new ArrayList<Student>();
	String temp = "";
	AddStudent(){
		frame.setTitle("Student Registry"); 
		frame.setBounds(300, 90, 500, 500); 
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); 
        frame.setResizable(false);
        
        container = frame.getContentPane(); 
        container.setLayout(null); 
  
        title = new JLabel("Student Form"); 
        title.setFont(new Font("Arial", Font.PLAIN, 30)); 
        title.setSize(300, 30); 
        title.setLocation(100, 30); 
        container.add(title); 
        
        // Student ID
        studentid = new JLabel("Student ID");
        studentid.setFont(new Font("Arial", Font.PLAIN, 20)); 
        studentid.setSize(100, 20); 
        studentid.setLocation(100, 100); 
        container.add(studentid); 
        
        txtid = new JTextField(); 
        txtid.setFont(new Font("Arial", Font.PLAIN, 15)); 
        txtid.setSize(190, 20); 
        txtid.setLocation(200, 100); 
        container.add(txtid);         
        
        // First Name  
        fname = new JLabel("First Name"); 
        fname.setFont(new Font("Arial", Font.PLAIN, 20)); 
        fname.setSize(100, 20); 
        fname.setLocation(100, 150); 
        container.add(fname); 
  
        txtfname = new JTextField(); 
        txtfname.setFont(new Font("Arial", Font.PLAIN, 15)); 
        txtfname.setSize(190, 20); 
        txtfname.setLocation(200, 150); 
        container.add(txtfname); 
  		
        // Last Name        
        lname = new JLabel("Last Name"); 
        lname.setFont(new Font("Arial", Font.PLAIN, 20)); 
        lname.setSize(100, 20); 
        lname.setLocation(100, 200); 
        container.add(lname); 
        
        txtlname = new JTextField(); 
        txtlname.setFont(new Font("Arial", Font.PLAIN, 15)); 
        txtlname.setSize(190, 20); 
        txtlname.setLocation(200, 200); 
        container.add(txtlname); 
		
        // Course Selection
        courses = new JLabel("Courses");
        courses.setFont(new Font("Arial", Font.PLAIN, 20)); 
        courses.setSize(100, 20); 
        courses.setLocation(100, 250); 
        container.add(courses); 
        
        txtcourses = new JTextField(); 
        txtcourses.setFont(new Font("Arial", Font.PLAIN, 15)); 
        txtcourses.setSize(190, 20); 
        txtcourses.setLocation(200, 250); 
        container.add(txtcourses); 
        
		// Submit Button
		subButton = new JButton("Submit");
		subButton.setFont(new Font("Arial",Font.PLAIN,15));
		subButton.setSize(100,20);
		subButton.setLocation(75,350);
		subButton.addActionListener(this);
		container.add(subButton);
        
        // Clear
        saveButton = new JButton("Save");
        saveButton.setFont(new Font("Arial",Font.PLAIN,15));
        saveButton.setSize(100,20);
        saveButton.setLocation(200,350);
        saveButton.addActionListener(this);
		container.add(saveButton);
		
		// Exit
		exitButton = new JButton("Exit");
		exitButton.setFont(new Font("Arial",Font.PLAIN,15));
		exitButton.setSize(100,20);
		exitButton.setLocation(325,350);
		exitButton.addActionListener(this);
		container.add(exitButton);
				
		// Clear Txt Area
        save = new JLabel("");
        save.setFont(new Font("Arial", Font.PLAIN, 20)); 
        save.setSize(100, 20); 
        save.setLocation(200, 400); 
        container.add(save);        
        frame.setVisible(true); 
	}

@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource() == subButton) {
		if(c == 1) {
			System.out.println( c + " student Added!");
			
	}else {
			System.out.println( c + " students Added!");
			}
		temp = "";
		temp = e.getActionCommand();
	} if(e.getSource() == exitButton) {
		temp = "";
		temp = e.getActionCommand();
		System.out.println("Saving the file...!");
		System.exit(0);
	} else if (e.getSource() == saveButton) {
		temp = "";
		temp = e.getActionCommand();
	}
	try {
		main();
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	

	
	
}
public void main() throws Exception {
	File file = new File ("StudentDatas.txt");
	System.out.println(temp);
	Student student = null;

	do {
		student = new Student();
		c++;
		setStudent(student);
		if(temp == "Save") {
			System.out.println("Added");
			students.add(student);
			if(students.isEmpty())
				System.out.println("NOO");
			setEmpty();
		} else if(temp == "Submit"){
			students.add(student);
			try {
				FileOutputStream fos = new FileOutputStream(file);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
					oos.writeObject(students);
					oos.flush();
					oos.close();
					fos.close();
					setEmpty();
					flag = false;
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}while(flag);
	if(students.isEmpty())
		System.out.println("Hello NO");

	FileInputStream is = new FileInputStream(file);
	ObjectInputStream obj_is = new ObjectInputStream(is);
	boolean flag = true;
	int counter = 0;
	do {
		//Student st = (Student) obj_is.readObject();
		
		students = (ArrayList<Student>)obj_is.readObject();
		
		
			counter++;
			System.out.println("Student " + "0" + counter + " -->");
			System.out.println(students.get(0));
		
	}while(flag);
	is.close();			
	
	
}

private void setEmpty() {
	txtid.setText(null);
	txtfname.setText(null);
	txtlname.setText(null);
	txtcourses.setText(null);	
}	
private void setStudent(Student src) throws Exception {
	ArrayList<Student> st = new ArrayList<Student>();
		src.setStID(Integer.parseInt(txtid.getText().toString()));	
		src.setFirstName(txtfname.getText().toString());		
		src.setLastName(txtlname.getText().toString().toUpperCase());		
		String array[] = (txtcourses.getText().toString().toUpperCase()).split(",");
		for(int i1 = 0; i1 < array.length; i1++) {
			src.setCourses(array[i1]);
			} st.add(src);
		
		if(!st.isEmpty())
			flag = false;
}
}


