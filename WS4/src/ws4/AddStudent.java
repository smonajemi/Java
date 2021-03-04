package ws4;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
class AddStudent extends Student implements ActionListener{
	private JFrame frame = new JFrame();
	private Container container;
	private JLabel title,fname,lname,studentid,courses,reset;
	private JTextField txtfname,txtlname,txtid,txtcourses;
	private JButton subButton,resButton,exitButton;
	int c = 0;
	boolean flag = true;
	AddStudent(){
		frame.setTitle("Student Registry"); 
		frame.setBounds(300, 90, 500, 500); 
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE); 
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
        resButton = new JButton("Clear");
        resButton.setFont(new Font("Arial",Font.PLAIN,15));
        resButton.setSize(100,20);
        resButton.setLocation(200,350);
        resButton.addActionListener(this);
		container.add(resButton);
		
		// Exit
		exitButton = new JButton("Exit");
		exitButton.setFont(new Font("Arial",Font.PLAIN,15));
		exitButton.setSize(100,20);
		exitButton.setLocation(325,350);
		exitButton.addActionListener(this);
		container.add(exitButton);
				
		// Clear Txt Area
        reset = new JLabel("");
        reset.setFont(new Font("Arial", Font.PLAIN, 20)); 
        reset.setSize(100, 20); 
        reset.setLocation(200, 400); 
        container.add(reset);
        
        frame.setVisible(true); 
	}

@Override
public void actionPerformed(ActionEvent e) {
	main();
	if(e.getSource() == subButton) {
		if(c == 1)
			System.out.println( c + " student Added!");
		else
			System.out.println( c + " students Added!");
	} if(e.getSource() == exitButton) {
		System.out.println("Saving the file...!");
		System.exit(0);
	} else if (e.getSource() == resButton) {
		System.out.println("Cleared!");
		setEmpty();
	}
}

public void main() {
	File file = new File ("st.txt");
	try {
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		do {
			Student student = new Student();
			c++;
			setStudent(student);		
			oos.writeObject(student);
			oos.flush();
		}while(flag);
			setEmpty();
			oos.flush();
			oos.close();
	} catch (Exception e) {
		System.out.println(e);

	}
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
		src.setLastName(txtlname.getText().toString());		
		String array[] = (txtcourses.getText().toString()).split(",");
		for(int i1 = 0; i1 < array.length; i1++) {
			src.setCourses(array[i1]); }
		st.add(src);
		
		if(!st.isEmpty())
			flag = false;
}
}


