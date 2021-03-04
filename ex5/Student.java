
package ws78;


public class Student {
	
	private String firstName;
	private String lastName;
	private double grade;
	private String department;
	String ind = "\t";
	
	public Student(String fname, String lname, double grd, String dep) {
		this.firstName = fname;
		this.lastName = lname;
		this.grade = grd;
		this.department = dep;
	}
	
	// First Name
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String fname) {
		this.firstName = fname;
	}
	
	// Last Name
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lname) {
		this.firstName = lname;
	}
	
	// Full Name
	public String getFullName() {
		return this.firstName + " " + this.lastName;
	}
	
	// Grade
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grd) {
		this.grade = grd;
	}
	
	// Department
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String dep) {
		this.department = dep;
	}
	
	
	public String toString() {
		 return getFirstName() + ind + getLastName() + ind + String.format("%.2f", getGrade()) + ind + getDepartment();		
	}

}
