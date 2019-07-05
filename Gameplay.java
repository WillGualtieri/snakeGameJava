import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Gameplay extends JPanel implements KeyListener, ActionListener
{
	
	private int[] snakeXLength = new int[750];
	private int[] snakeYLength = new int[750];
	
	private boolean left = false;
	private boolean right = false;
	private boolean up = false;
	private boolean down = false;
	
	private ImageIcon rightMouth;
	private ImageIcon upMouth;
	private ImageIcon downMouth;
	private ImageIcon leftMouth;
	
	private int lengthOfSnake = 3;
	
	private Timer timer;
	private int delay = 100;
	private ImageIcon snakeImage;
	
	// enemy position
	private int [] enemyXPos = (25, 50, 75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350, 375,
			400, 425, 450, 475, 500, 525, 550, 575, 600, 625, 650, 
			675, 700, 725, 750, 775, 800, 825, 850);
	private int [] enemyYPos = (25, 50, 75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350, 375,
			400, 425, 450, 475, 500, 525, 550, 575, 600, 625);
	
	private int moves = 0;
	
	private ImageIcon titleImage;
	
		public Gameplay()
		{
			addKeyListener(this);
			setFocusable(true);
			setFocusTraversalKeysEnabled(false);
			timer = new Timer(delay, this);
			timer.start();
		}

		public void paint(Graphics g)
		{
			// Sets default position
			if(moves == 0)
			{
				snakeXLength[2] = 50;
				snakeXLength[1] = 75;
				snakeXLength[0] = 100;
				
				snakeYLength[2] = 100;
				snakeYLength[1] = 100;
				snakeYLength[0] = 100;
			}
			
			// draw title image border
			g.setColor(Color.white);
			g.drawRect(24,  10,  851,  55);
			
			// draw the title image
			titleImage = new ImageIcon("snaketitle.jpg");
			titleImage.paintIcon(this, g, 25, 11);
			
			// draw border for gameplay
			g.setColor(Color.white);
			g.drawRect(24, 74, 851, 577);
			 
			// draw background for the gameplay
			g.setColor(Color.black);
			g.fillRect(25, 75, 850, 575);
			
			rightMouth = new ImageIcon("rightmouth.png");
			rightMouth.paintIcon(this, g, snakeXLength[0], snakeYLength[0]);
			
			for(int a = 0; a < lengthOfSnake; a++)
			{
				if(a==0 && right)
				{
					rightMouth = new ImageIcon("rightmouth.png");
					rightMouth.paintIcon(this, g, snakeXLength[a], snakeYLength[a]);
				}
				if(a==0 && left)
				{
					leftMouth = new ImageIcon("leftmouth.png");
					leftMouth.paintIcon(this, g, snakeXLength[a], snakeYLength[a]);
				}
				if(a==0 && down)
				{
					downMouth = new ImageIcon("downmouth.png");
					downMouth.paintIcon(this, g, snakeXLength[a], snakeYLength[a]);
				}
				if(a==0 && up)
				{
					upMouth = new ImageIcon("upmouth.png");
					upMouth.paintIcon(this, g, snakeXLength[a], snakeYLength[a]);
				}
				if(a != 0)
				{
					snakeImage = new ImageIcon("snakeimage.png");
					snakeImage.paintIcon(this, g, snakeXLength[a], snakeYLength[a]);
				}
			}
			
			g.dispose();
		} // paint & graphics

			@Override
			public void actionPerformed(ActionEvent e) { // movement control
				timer.start();
				if(right) // right movement
				{
					for(int r = lengthOfSnake - 1; r >= 0; r--)
					{
						snakeYLength[r + 1] = snakeYLength[r];
					}
					for(int r = lengthOfSnake; r >= 0; r--)
					{
						if(r == 0)
						{
							snakeXLength[r] = snakeXLength[r] + 25;							
						}
						else
						{
							snakeXLength[r] = snakeXLength[r - 1];
						} // Deals with when the snake hits the border and makes it relocate to the other side.
						if(snakeXLength[r] > 850)
						{
							snakeXLength[r] = 25;
						}
						
						repaint();
					}
				}
				
				if(left) // left movement
				{
					for(int r = lengthOfSnake - 1; r >= 0; r--)
					{
						snakeYLength[r + 1] = snakeYLength[r];
					}
					for(int r = lengthOfSnake; r >= 0; r--)
					{
						if(r == 0)
						{
							snakeXLength[r] = snakeXLength[r] - 25;							
						}
						else
						{
							snakeXLength[r] = snakeXLength[r - 1];
						} // Deals with when the snake hits the border and makes it relocate to the other side.
						if(snakeXLength[r] < 25)
						{
							snakeXLength[r] = 850;
						}
						
						repaint();
					}
				}
				
				if(up) // up movement
				{
					for(int r = lengthOfSnake - 1; r >= 0; r--)
					{
						snakeXLength[r + 1] = snakeXLength[r];
					}
					for(int r = lengthOfSnake; r >= 0; r--)
					{
						if(r == 0)
						{
							snakeYLength[r] = snakeYLength[r] - 25;							
						}
						else
						{
							snakeYLength[r] = snakeYLength[r - 1];
						} // Deals with when the snake hits the border and makes it relocate to the other side.
						if(snakeYLength[r] < 75)
						{
							snakeYLength[r] = 625;
						}
						
						repaint();
					}	
				}
				
				if(down) // down movement
				{
					for(int r = lengthOfSnake - 1; r >= 0; r--)
					{
						snakeXLength[r + 1] = snakeXLength[r];
					}
					for(int r = lengthOfSnake; r >= 0; r--)
					{
						if(r == 0)
						{
							snakeYLength[r] = snakeYLength[r] + 25;							
						}
						else
						{
							snakeYLength[r] = snakeYLength[r - 1];
						} // Deals with when the snake hits the border and makes it relocate to the other side.
						if(snakeYLength[r] > 625)
						{
							snakeYLength[r] = 75;
						}
						
						repaint();
					}	
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_RIGHT)
				{
					moves++;
					right = true;
					if(!left)
					{
						right = true;
					}
					else
					{
						right = false;
						left = true;
					}
					
					left = false;
					up = false;
					down = false;
				}
				if(e.getKeyCode() == KeyEvent.VK_LEFT)
				{
					moves++;
					left = true;
					if(!right)
					{
						left = true;
					}
					else
					{
						left = false;
						right = true;
					}
					
					up = false;
					down = false;
				}
				if(e.getKeyCode() == KeyEvent.VK_UP)
				{
					moves++;
					up = true;
					if(!down)
					{
						up = true;
					}
					else
					{
						up = false;
						down = true;
					}
					
					left = false;
					right = false;
				}
				
				if(e.getKeyCode() == KeyEvent.VK_DOWN)
				{
					moves++;
					down = true;
					if(!up)
					{
						down = true;
					}
					else
					{
						down = false;
						up = true;
					}
					
					left = false;
					right = false;
				}
					
				
			}

			@Override
			public void keyTyped(KeyEvent e) {
				
				
			}
			
}
