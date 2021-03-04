package brickBreaker;

import java.io.IOException;
import javax.swing.JFrame;

public class Main{

	public static void main(String[] args) throws IOException {
		// JFRAME
			JFrame obj = new JFrame();
			BBreaker gPlay = new BBreaker();
		// Properties
			obj.setBounds(10,10,700,600);
			obj.setTitle("Brick Breaker");
			obj.setResizable(false);
			obj.setVisible(true);
			obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			obj.add(gPlay);
			
	}

}
