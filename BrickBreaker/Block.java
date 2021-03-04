package brickBreaker;
import java.awt.Component;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Block extends Rectangle {
	Image image;
	boolean des;
	int posX,posY;
	int width,height;
	
	Block(int a,int b, int w, int h, String str){
		this.posX = x;
		this.posY = y;
		this.width = w;
		this.height = h;
		
		try {
			image = ImageIO.read(new File(str));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics2D g, Component c) {
		if(!des) {
			g.drawImage(image,posX,posY,width,height,c);
		}
	}
}
