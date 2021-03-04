package ws4;
import java.util.ArrayList;

public class Student implements java.io.Serializable {
	private int m_stdID;
	private String m_fname;
	private String m_lname;
	private ArrayList<String> m_courses;
	
	// Constructor
	public Student() {
		 m_stdID = 0;
		 m_fname = "";
		 m_lname = "";
		 m_courses = new ArrayList<String>();
	}
	
	// Student ID - Setter and Getter
	public int getstID() {
		return m_stdID;
	}	
	public void setStID(int id) throws Exception {
		if(id > 0) 
			m_stdID = id;
		else
			throw new Exception("Student ID is not Valid!");
	}
	
	// Student name - Setter and Getter
	public void setFirstName(String fname) {
		m_fname = fname;
	}
	
	public void setLastName(String lname) {
		m_lname = lname;
	}
	
	public String getFullName() {
		return m_fname.concat(" ").concat(m_lname);
	}
	
	// Courses - Setter and Getter
	public ArrayList<String> getCourses() {
		return m_courses;
		
	}
	
	public void setCourses(String course) {
		this.m_courses.add(course);
	}

}
