package ws78;

import java.util.*;
import java.util.stream.Collectors; 

public class StudentProcess {

	public static void main(String[] args) {
		Student[] students = {
				 new Student("Jack", "Smith", 50.0, "IT"),
				 new Student("Aaron", "Johnson", 76.0, "IT"),
				 new Student("Maaria", "White", 35.8, "Business"),
				 new Student("John", "White", 47.0, "Media"),
				 new Student("Laney", "White", 62.0, "IT"),
				 new Student("Jack", "Jones", 32.9, "Business"),
				 new Student("Wesley", "Jones", 42.89, "Media")
				 };		
		List<Student> studentList = Arrays.asList(students);	
		
		System.out.println("TASK ONE:\n");
		System.out.println("Complete Student list:");
		studentList.forEach(System.out::println);
		System.out.println("-----------------------------------------------");
	
		System.out.println("TASK TWO:\n");
		System.out.println("Students who got 50.0-100.0 sorted by grade:");
		studentList.stream().filter(st-> st.getGrade() >= 50 && st.getGrade()<= 100).sorted(Comparator.comparing(Student::getGrade)).forEach(System.out::println);
		System.out.println("-----------------------------------------------");
		
		System.out.println("TASK THREE:\n");
		System.out.println("First Student who got 50.0-100.0:");
		Optional<Student> stu = studentList.stream().filter(s-> s.getGrade() >= 50 && s.getGrade()<= 100).findFirst();
		System.out.println(stu.get() + "\n-----------------------------------------------");
		
		System.out.println("TASK FOUR:\n");
		System.out.println("Students in ascending order by last name then first:");
		studentList.stream().sorted(Comparator.comparing(Student::getFirstName)).sorted(Comparator.comparing(Student::getLastName)).forEach(System.out::println);

		System.out.println("\nStudents in descending order by last name then first:");
		studentList.stream().sorted(Comparator.comparing(Student::getFirstName).reversed()).sorted(Comparator.comparing(Student::getLastName).reversed()).forEach(System.out::println);
		System.out.println("-----------------------------------------------");
		
		System.out.println("TASK FIVE:\n");
		System.out.println("Unique Student last names:");
		studentList.stream().sorted(Comparator.comparing(Student::getLastName)).map(Student::getLastName).distinct().forEach(System.out::println);
		System.out.println("-----------------------------------------------");
		
		System.out.println("TASK SIX:\n");
		System.out.println("Student names in order by last name then first name:");
		studentList.stream().sorted(Comparator.comparing(Student::getFirstName)).sorted(Comparator.comparing(Student::getLastName)).map(Student::getFullName).forEach(System.out::println);
		System.out.println("-----------------------------------------------");
		
		System.out.println("TASK SEVEN:\n");
		System.out.println("Students by department:");
		Map<String, List<Student>> t1 = studentList.stream().collect(Collectors.groupingBy(Student::getDepartment));
		t1.forEach((str, val) -> {
			System.out.println(str);
			val.forEach(v -> System.out.println(" " + v));
		});
		System.out.println("-----------------------------------------------");
		
		System.out.println("TASK EIGHT:\n");
		System.out.println("Count of Students by department:");
		Map<String,Long> t2 = studentList.stream().collect(Collectors.groupingBy(Student::getDepartment,Collectors.counting()));
			new TreeMap<String,Long>(t2).forEach((k,v) -> {
				System.out.println(k + " has " + v + " Students");
			});		
		System.out.println("-----------------------------------------------");
		
		System.out.println("TASK NINE:\n");
		System.out.print("Sum of Students' grades: ");
		Double t3 = studentList.stream().collect(Collectors.summingDouble(Student::getGrade));
		System.out.println(String.format("%.2f", t3));
		System.out.println("-----------------------------------------------");
		
		System.out.println("TASK TEN:\n");
		System.out.print("Average of Students' grades: ");
		Double t4 = studentList.stream().collect(Collectors.averagingDouble(Student::getGrade));
		System.out.println(String.format("%.2f", t4) + "%");
		System.out.println("-----------------------------------------------");
	}

}
