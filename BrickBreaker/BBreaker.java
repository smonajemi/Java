package brickBreaker;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.Timer;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

public class BBreaker extends JPanel implements KeyListener, ActionListener {
	
	//Variables
		private Timer timer;
		private Bricks map; // first[map] 2D
		private Component c;
		private BufferedImage image;
		private JButton b1,b2;
		private JPanel jp;
		private boolean play = false;
		private int score = 0;
		
		private int delay = 5;
		private int playerX = 310;		
		private int totalBricks = 10;	
		
		private int ballposX = 10;
		private int ballposY = 350;
		private int balldirX = -4;
		private int balldirY = -2;
		static boolean exit = true;

		
	//Constructor	
		public BBreaker() {
			
			map = new  Bricks(3,7);
			addKeyListener(this);
			setFocusable(true);
			setFocusTraversalKeysEnabled(false);
			timer = new Timer(delay,this);
			timer.start();			
		}
	
	//Functions
		public void paint(Graphics g) {
			//background
				g.setColor(Color.gray);
				g.fillRect(1, 1, 692, 592);
				
			//drawing map
				map.draw((Graphics2D)g);
			
			//borders
				g.setColor(Color.white);
				g.fillRect(0, 0, 3, 600);
				g.fillRect(0, 0, 692, 3);
				g.fillRect(680, 0, 3, 632);
			
			//scores
				g.setColor(Color.red);
				g.setFont(new Font("serif",Font.BOLD,25));
				g.drawString(""+score, 590,30);
							
			//paddle
				g.setColor(Color.black);
				g.fillRect(playerX,550,100,5);			
				
				  
			//ball
				try {
					image = ImageIO.read(new File("ball.png"));
					g.drawImage(image, ballposX,ballposY,20,20, c);
				} catch (IOException e){
					e.printStackTrace();
				}			
				
							
				if(totalBricks <= 0) {
					play = false;
					balldirX = 0;
					balldirY = 0;
					g.setColor(Color.RED);
					g.setFont(new Font("serif",Font.BOLD,30));
					g.drawString("Easy...!",200,270);
					
					g.setFont(new Font("serif",Font.BOLD,30));
					g.drawString("Press enter to play again!", 200,300);
				}
								
				if(ballposY > 570) {
					play = false;
					balldirX = 0;
					balldirY = 0;
					g.setColor(Color.RED);
					g.setFont(new Font("serif",Font.BOLD,30));
					g.drawString("GAME OVER! ", 200,270);
					
					g.setFont(new Font("serif",Font.BOLD,30));
					g.drawString("Press enter to play again!", 200,300);
				}
				g.dispose();
		}			
			
		@Override
		public void actionPerformed(ActionEvent e) {
			timer.start();
	 
			if(play) {				
				//detecting the paddle
				if(new Rectangle(ballposX,ballposY,20,20).intersects(new Rectangle(playerX,550,100,8))) {
					balldirY = -balldirY;
				}
				B: for(int i = 0; i < map.map.length;i++) {
					for(int j = 0; j <map.map[0].length;j++) {
						if(map.map[i][j] > 0) {
							int brkX = j* map.brickWidth + 80;
							int brkY = i* map.brickHeight + 50;
							int brkW = map.brickWidth;
							int brkH = map.brickHeight;
							
							
							Rectangle rect = new Rectangle(brkX,brkY,brkW,brkH);
							Rectangle ballR = new Rectangle(ballposX,ballposY,20,20);
							Rectangle brickR = rect;
							
							if(ballR.intersects(brickR)) {
								map.setBrickValue(0, i, j);
								totalBricks--;
								score += 1;
								
								if(ballposX + 15 <= brickR.x || ballposX + 1 >= brickR.x + brickR.width) {
									balldirX = -balldirX;

								} else {
									balldirY = -balldirY;
								}
								break B;
								
							}
						}
					}
				}
				ballposX += balldirX;
				ballposY += balldirY;
				//left
				if(ballposX < 0) {
					balldirX = -balldirX;					
				}
				//top
				if(ballposY < 0) {
					balldirY = -balldirY;					
				}
				//right
				if(ballposX > 670) {
					balldirX = -balldirX;					
				}
			}		
			repaint();
		}	
		
		@Override
		public void keyTyped(KeyEvent e) {}
		@Override
		public void keyReleased(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			if(play) {
			play = false;
			balldirX = 0;
			balldirY = 0;	
			} else
			if(!play) {
				play = true;
				balldirX = -4;
				balldirY = -2;
				
			}
		}

		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if(playerX >=600) {
				playerX = 600;
			} else {
				moveRight();
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			if(playerX < 10) {
				playerX = 10;
			} else {
				moveLeft();
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			if(!play) {
				play = true;
				ballposX = 120;
				ballposY = 350;
				balldirX = -1;
				balldirY = -5;
				playerX = 310;
				score = 0;
				totalBricks = 10;
				map = new Bricks(3,7);
				repaint();				
			}
		}
		}
		
		@Override
		public void keyPressed(KeyEvent e) {	
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if(playerX >=600) {
				playerX = 600;
			} else {
				moveRight();
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			if(playerX < 10) {
				playerX = 10;
			} else {
				moveLeft();
			}
		}
	
}
		private void moveRight() {
			play = true;
			playerX+=50;			
		}

		private void moveLeft() {
			play = true;
			playerX-=50;			
		}
		

}
