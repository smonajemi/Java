package ws4;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class DataEntry {
	public static void main(String[] args) throws Exception{
		try {
            FileOutputStream os = new FileOutputStream("studentinfo.ser");
            ObjectOutputStream obj_os = new ObjectOutputStream(os);
            Scanner reader = new Scanner(System.in);
            boolean flag = true;         
            
            do {            	
            	boolean exit = true;
          
                Student std = new Student();
                System.out.print("Enter student number: ");
                	std.setStID(reader.nextInt()); 
                	reader.nextLine();
                System.out.print("Enter student's first name: ");
                	std.setFirstName(reader.nextLine().toUpperCase());
                System.out.print("Enter student's last name: ");
                	std.setLastName(reader.nextLine().toUpperCase());                     
            	System.out.print("Add the number of courses: ");
            		int num = reader.nextInt();
					if(num <= 0) {
						std.setCourses("No Courses are taken.");
						reader.nextLine();
					} else {
            			String[] course = new String[num];
            				for(int i = 0; i < num; ++i) {
            					System.out.print("Course 0" + (i+1) + ": ");
            					course[i] = reader.next();
            					std.setCourses(course[i].toUpperCase());
            					reader.nextLine();
            					}          			
							}
            	obj_os.writeObject(std);
            	obj_os.flush();
           
                while(exit){
                    System.out.print("Would you like to enter another student? (y or n): ");
                    String input = reader.nextLine();                    
                    switch(input.toUpperCase()) {
                    case "Y":
                    	exit = false;
                    	break;
                    case "N":
                    	System.out.println("\nExit..."); 
                        System.exit(1); 
                    default:
                        System.out.println(input + " is invalid!");             
                    }
                }

            }while(flag);

            obj_os.flush();
            os.close();
            reader.close();
        } catch (Throwable e) {
            System.err.println(e);
        } 
    }
}