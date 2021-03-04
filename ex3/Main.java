package w6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

public static void main(String[] args) throws FileNotFoundException, IOException {
		System.out.println("------->JAC 444 Workshop 6<-------");
		System.out.println("------->LAMBDA EXPRESSION<-------\n");
			
	int counter = 0;
	String str;
	File file = new File("./src/w6/shapes.txt"); // creating file
	try {
	if(!file.exists())
		throw new FileNotFoundException(file + " does not exist!");
	else {
		String fileName = file.toString(); // converting file to string
			Path path = Paths.get(fileName); // creating a pathname for string
				long lineCount = Files.lines(path).count(); // counting the number of lines in the file
	if(lineCount <= 0)
		System.out.println(fileName + " is empty!");
	else {
		ShapePerimeter[] shapes = new ShapePerimeter[(int) lineCount]; // creating new object of type shape casting the length of the file
		
	try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {			
		while ((str = br.readLine()) != null) {
			String[] tokens = str.split(",");	
				int lineLength = tokens.length;
	for(int i = 0; i < lineLength; i++)
	{			
		if(tokens[i].equals("Circle") && lineLength == 2) {	
			try {
				i++;
				shapes[counter] = new Circle(Double.parseDouble(tokens[i]));
				counter++;
			} catch(IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}						
	} else if(tokens[i].equals("Square") && lineLength == 2) {	
			try {
				i++;
				shapes[counter] = new Square(Double.parseDouble(tokens[i]));
				counter++;
			} catch(RectangleException e) {
				System.out.println(e.getMessage());
			}
	} else if(tokens[i].equals("Rectangle") && lineLength == 3) {
			try {
				i++;
				shapes[counter] = new Rectangle(Double.parseDouble(tokens[i]),Double.parseDouble(tokens[i+1]));
				counter++;
			} catch(RectangleException e) {
				System.out.println(e.getMessage());
			}
		} else if(tokens[i].equals("Parallelogram") && lineLength == 3) {
			try {
				i++;
				shapes[counter] = new Parallelogram(Double.parseDouble(tokens[i]),Double.parseDouble(tokens[i+1]));
				counter++;
			} catch(RectangleException e) {
				System.out.println(e.getMessage());
			}
		} else if(tokens[i].equals("Triangle") && lineLength == 4) {
					try {
						i++;
						shapes[counter] = new Triangle(Double.parseDouble(tokens[i]),Double.parseDouble(tokens[i+1]), Double.parseDouble(tokens[i+2]));
						counter++;
					} catch(TriangleException e) {
						System.out.println(e.getMessage());
					}
				}	
	}	
			}
				System.out.println("\n" + counter + " shapes were created:");
			for(ShapePerimeter shape : shapes) {
				if(shape != null)
					System.out.println("\n" + shape);
				}
			}
		}
				}
	}catch(FileNotFoundException e) {
	System.out.println(e.getMessage());
}
}
}
