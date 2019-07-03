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
	
	private int[] snakexlength = new int[750];
	private int[] snakeylength = new int[750];
	
	private boolean left = false;
	private boolean right = false;
	private boolean up = false;
	private boolean down = false;
	
	private ImageIcon rightmouth;
	private ImageIcon upmouth;
	private ImageIcon downmouth;
	private ImageIcon leftmouth;
	
	private int lengthOfSnake = 3;
	
	private Timer timer;
	private int delay = 100;
	private ImageIcon snakeimage;
	
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
				snakexlength[2] = 50;
				snakexlength[1] = 75;
				snakexlength[0] = 100;
				
				snakeylength[2] = 100;
				snakeylength[1] = 100;
				snakeylength[0] = 100;
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
			
			rightmouth = new ImageIcon("rightmouth.png");
			rightmouth.paintIcon(this, g, snakexlength[0], snakeylength[0]);
			
			for(int a = 0; a < lengthOfSnake; a++)
			{
				if(a==0 && right)
				{
					rightmouth = new ImageIcon("rightmouth.png");
					rightmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);
				}
				if(a==0 && left)
				{
					leftmouth = new ImageIcon("leftmouth.png");
					leftmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);
				}
				if(a==0 && down)
				{
					downmouth = new ImageIcon("downmouth.png");
					downmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);
				}
				if(a==0 && up)
				{
					upmouth = new ImageIcon("upmouth.png");
					upmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);
				}
				if(a != 0)
				{
					snakeimage = new ImageIcon("snakeimage.png");
					snakeimage.paintIcon(this, g, snakexlength[a], snakeylength[a]);
				}
			}
			
			g.dispose();
		} // paint & graphics

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
}
