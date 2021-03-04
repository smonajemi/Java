package brickBreaker;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class Bricks {
	
	//Variables
		public int map[][]; //second[map]
		public int brickWidth;
		public int brickHeight;
	
	//Constructor
		public Bricks(int r,int c) {
			map = new int[r][c];
			for(int i = 0;i< map.length;i++) {
				for(int j=0; j<map[0].length; j++) {
					map[i][j] = 1;
				}
			}
			brickWidth = 540/c;
			brickHeight = 150/r;
		}
	//Functions
		public void draw(Graphics2D g) {
			for(int i = 0;i< map.length;i++) {
				for(int j=0; j<map[0].length; j++) {
					if(map[i][j] > 0) {
						g.setColor(Color.white);
						g.fillRect(j* brickWidth + 80, i * brickHeight + 50, brickWidth,brickHeight);
						g.setStroke(new BasicStroke(3));
						g.setColor(Color.black);
						g.drawRect(j* brickWidth + 80, i * brickHeight + 50, brickWidth,brickHeight);
					
					}
				}
			}
		}
		public void setBrickValue(int v,int r,int c) {
			map[r][c] = v;
		}
}
