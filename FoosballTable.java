import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;	
import javax.swing.*;

/**
 * 
 * @author teeron
 *
 */

public class FoosballTable extends JFrame 
implements ActionListener, KeyListener
{
	// DATA:

	private static Ball foosball ;							// Our moving ball
	private static Goal topGoal = new Goal(110, 0, 80, 33, Color.BLACK);
	private static Goal bottomGoal = new Goal(110, 588, 80, 12, Color.BLACK);

	private static int whiteXMin1 = 140;
	private static int whiteXMax1 = 160;
	private static int whiteYMin1 = 347;
	private static int whiteYMax1 = 367;
	private static Player whitePlayer1 = new Player(whiteXMin1, whiteXMax1, whiteYMin1, whiteYMax1, Color.WHITE);	

	private static int whiteXMin2 = 80;
	private static int whiteXMax2 = 100;
	private static int whiteYMin2 = 347;
	private static int whiteYMax2 = 367;
	private static Player whitePlayer2 = new Player(whiteXMin2, whiteXMax2, whiteYMin2, whiteYMax2, Color.WHITE);

	private static int whiteXMin3 = 200;
	private static int whiteXMax3 = 220;
	private static int whiteYMin3 = 347;
	private static int whiteYMax3 = 367;
	private static Player whitePlayer3 = new Player(whiteXMin3, whiteXMax3, whiteYMin3, whiteYMax3, Color.WHITE);

	private static int whiteXMin4 = 40;
	private static int whiteXMax4 = 60;
	private static int whiteYMin4 = 417;
	private static int whiteYMax4 = 437;
	private static Player whitePlayer4 = new Player(whiteXMin4, whiteXMax4, whiteYMin4, whiteYMax4, Color.WHITE);	

	private static int whiteXMin5 = 110;
	private static int whiteXMax5 = 130;
	private static int whiteYMin5 = 417;
	private static int whiteYMax5 = 437;
	private static Player whitePlayer5 = new Player(whiteXMin5, whiteXMax5, whiteYMin5, whiteYMax5, Color.WHITE);

	private static int whiteXMin6 = 170;
	private static int whiteXMax6 = 190;
	private static int whiteYMin6 = 417;
	private static int whiteYMax6 = 437;
	private static Player whitePlayer6 = new Player(whiteXMin6, whiteXMax6, whiteYMin6, whiteYMax6, Color.WHITE);

	private static int whiteXMin7 = 240;
	private static int whiteXMax7 = 260;
	private static int whiteYMin7 = 417;
	private static int whiteYMax7 = 437;
	private static Player whitePlayer7 = new Player(whiteXMin7, whiteXMax7, whiteYMin7, whiteYMax7, Color.WHITE);




	private static int blackXMin1 = 140;
	private static int blackXMax1 = 160;
	private static int blackYMin1 = 253;
	private static int blackYMax1 = 273;
	private static Player blackPlayer1 = new Player(blackXMin1, blackXMax1, blackYMin1, blackYMax1, Color.BLACK);

	private static int blackXMin2 = 80;
	private static int blackXMax2 = 100;
	private static int blackYMin2 = 253;
	private static int blackYMax2 = 273;
	private static Player blackPlayer2 = new Player(blackXMin2, blackXMax2, blackYMin2, blackYMax2, Color.BLACK);

	private static int blackXMin3 = 200;
	private static int blackXMax3 = 220;
	private static int blackYMin3 = 253;
	private static int blackYMax3 = 273;
	private static Player blackPlayer3 = new Player(blackXMin3, blackXMax3, blackYMin3, blackYMax3, Color.BLACK);

	private static int blackXMin4 = 40;
	private static int blackXMax4 = 60;
	private static int blackYMin4 = 183;
	private static int blackYMax4 = 203;
	private static Player blackPlayer4 = new Player(blackXMin4, blackXMax4, blackYMin4, blackYMax4, Color.BLACK);	

	private static int blackXMin5 = 110;
	private static int blackXMax5 = 130;
	private static int blackYMin5 = 183;
	private static int blackYMax5 = 203;
	private static Player blackPlayer5 = new Player(blackXMin5, blackXMax5, blackYMin5, blackYMax5, Color.BLACK);

	private static int blackXMin6 = 170;
	private static int blackXMax6 = 190;
	private static int blackYMin6 = 183;
	private static int blackYMax6 = 203;
	private static Player blackPlayer6 = new Player(blackXMin6, blackXMax6, blackYMin6, blackYMax6, Color.BLACK);

	private static int blackXMin7 = 240;
	private static int blackXMax7 = 260;
	private static int blackYMin7 = 183;
	private static int blackYMax7 = 203;
	private static Player blackPlayer7 = new Player(blackXMin7, blackXMax7, blackYMin7, blackYMax7, Color.BLACK);




	private static final int MAX_WIDTH = 400;		// Window size
	private static final int MAX_HEIGHT = 700;		// Window size

	private static final int GRASS_X = 10;
	private static final int GRASS_Y = 32;
	private static final int GRASS_WIDTH = 280;
	private static final int GRASS_HEIGHT = 556;


	private static final int RADIUS = 10;

	private static int dX = 5;
	private static int dY = -5;

	//	private static final int COLOR_RANGE = 256;

	private static final Color COLOR = (Color.WHITE);
	private static final Color GRASS_COLOR = new Color(0,164,0);
	private static final Color LINING_COLOR = new Color(102,51,0);
	private static final Color GOLD_LINING = new Color(255,204,51);
	private static final int WELCOME = 1;
	private static final int PLAYING = 4;
	private static final int GAME_OVER = 7;
	private static int screenSelect = WELCOME;

	private static final int DELAY_IN_MILLISEC = 20;

	// METHODS:

	/**
	 * main -- Start up the window.
	 * 
	 * @param	args
	 */
	public static void main(String args[])
	{
		// Create the window.
		foosballTable window = new foosballTable();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setTitle("foosball Game");

		window.addKeyListener(window);
	}

	/**
	 * ManyBalls constructor: create the one Ball and simulate the "clock"
	 */
	public foosballTable()
	{

		foosball = new Ball(GRASS_X, ((GRASS_HEIGHT + GRASS_Y)/2) + GRASS_Y, dX, dY, RADIUS, COLOR);

		// Show the window with the ball in its initial position.
		//	Note that these are called without the window. in front.  
		//	We'll discuss why in class.
		setSize(MAX_WIDTH, MAX_HEIGHT);
		setVisible(true);

		createBufferStrategy(2);

		Timer clock= new Timer(DELAY_IN_MILLISEC, this);	
		clock.start();	
	}

	/**
	 * actionPerformed -- Move the ball every time the "timer" goes off.
	 * Note that all of the action that we want to happen every time the timer
	 * goes off goes in this method.
	 */
	public void actionPerformed(ActionEvent e)
	{
		// Move the ball.

		if (screenSelect == PLAYING)
		{
			foosball.move();
			foosball.bounce(GRASS_X, GRASS_WIDTH + GRASS_X, GRASS_Y, GRASS_HEIGHT + GRASS_Y, topGoal);
			foosball.bounceOffBox(whitePlayer1);
			foosball.bounceOffBox(whitePlayer2);
			foosball.bounceOffBox(whitePlayer3);
			foosball.bounceOffBox(whitePlayer4);
			foosball.bounceOffBox(whitePlayer5);
			foosball.bounceOffBox(whitePlayer6);
			foosball.bounceOffBox(whitePlayer7);

			foosball.bounceOffBox(blackPlayer1);
			foosball.bounceOffBox(blackPlayer2);
			foosball.bounceOffBox(blackPlayer3);
			foosball.bounceOffBox(blackPlayer4);
			foosball.bounceOffBox(blackPlayer5);
			foosball.bounceOffBox(blackPlayer6);
			foosball.bounceOffBox(blackPlayer7);
		}

		// Update the window.
		repaint();

	}

	/**
	 * paint 		draw the window
	 * 
	 * @param g		Graphics object to draw on
	 */
	public void paint(Graphics g)
	{
		BufferStrategy bf = this.getBufferStrategy();
		if (bf == null)
			return;

		Graphics g2 = null;
		try 
		{
			g2 = bf.getDrawGraphics();

			// myPaint does the actual drawing
			myPaint(g2);
		} 
		finally 
		{
			// It is best to dispose() a Graphics object when done with it.
			g2.dispose();
		}
		bf.show();

		Toolkit.getDefaultToolkit().sync();
	}
	/**
	 * paint 		draw the window						// New D - rename your paint method myPaint()
	 * 
	 * @param g		Graphics object to draw on
	 */
	public void myPaint(Graphics g)
	{
		// Clear the window.
		if (screenSelect == WELCOME)
		{
			g.setColor(Color.GREEN);
			g.fillRect(0, 0, MAX_WIDTH, MAX_HEIGHT);

			g.setColor(Color.BLACK);
			g.setFont(new Font("Comic Sans" , Font.BOLD, 50));	
			g.drawString("START GAME", MAX_WIDTH/2 - 180, GRASS_HEIGHT/2);

			g.setColor(Color.BLACK);
			g.setFont(new Font("Comic Sans" , Font.BOLD, 50));	
			g.drawString("CLICK \"SPACE\" TO START", MAX_WIDTH/2 - 190, GRASS_HEIGHT/2 + 100);

		}

		else if (screenSelect == PLAYING)
		{
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, MAX_WIDTH, MAX_HEIGHT);

			g.setColor(LINING_COLOR);
			g.fillRect(0, 0, MAX_WIDTH - 100, MAX_HEIGHT - 100);

			g.setColor(GRASS_COLOR);
			g.fillRect(GRASS_X, GRASS_Y, GRASS_WIDTH, GRASS_HEIGHT);

			g.setColor(GOLD_LINING);
			g.drawRect(GRASS_X, GRASS_Y, GRASS_WIDTH, GRASS_HEIGHT);

			g.setColor(Color.WHITE);
			g.drawLine(GRASS_X, (GRASS_HEIGHT/2) + GRASS_Y, GRASS_X + GRASS_WIDTH, (GRASS_HEIGHT/2) + GRASS_Y);

			g.setColor(Color.WHITE);
			g.drawOval(((GRASS_WIDTH/2) -  3 *GRASS_X), ((GRASS_HEIGHT/2) + GRASS_Y - 4 * GRASS_X), (8 * GRASS_X), (8 * GRASS_X));

			g.setColor(Color.GRAY);
			g.fillRect(0, whiteYMin1 + 8, MAX_WIDTH - 90, 4);

			g.setColor(Color.GRAY);
			g.fillRect(0, blackYMin1 + 8, MAX_WIDTH - 90, 4);

			g.setColor(Color.GRAY);
			g.fillRect(0, whiteYMin7 + 8, MAX_WIDTH - 90, 4);

			g.setColor(Color.GRAY);
			g.fillRect(0, blackYMin7 + 8, MAX_WIDTH - 90, 4);

			Color scoreBoardColor = new Color(102, 51, 0);
			g.setColor(scoreBoardColor);
			g.fillRect(MAX_WIDTH - 100, (GRASS_HEIGHT/2) , 100, GRASS_Y * 2);

			int topGoalScore = foosball.getTopScore();
			int bottomGoalScore = foosball.getBottomScore();

			g.setColor(Color.WHITE);
			g.fillRect(MAX_WIDTH - 90, (GRASS_HEIGHT/2) + GRASS_Y - 15, 35, 30);	

			g.setColor(Color.WHITE);
			g.fillRect(MAX_WIDTH - 40, (GRASS_HEIGHT/2) + GRASS_Y - 15, 35, 30);

			g.setColor(Color.BLACK);
			g.setFont(new Font("Comic Sans" , Font.BOLD, 20));	
			g.drawString("" + topGoalScore + "", MAX_WIDTH - 30, (GRASS_HEIGHT/2) + GRASS_Y + 5);

			g.setColor(Color.BLACK);
			g.setFont(new Font("Comic Sans" , Font.BOLD, 20));	
			g.drawString("" + bottomGoalScore + "", MAX_WIDTH - 80, (GRASS_HEIGHT/2) + GRASS_Y + 5);



			foosball.draw(g);
			whitePlayer1.draw(g);
			whitePlayer2.draw(g);
			whitePlayer3.draw(g);
			whitePlayer4.draw(g);
			whitePlayer5.draw(g);
			whitePlayer6.draw(g);
			whitePlayer7.draw(g);

			blackPlayer1.draw(g);
			blackPlayer2.draw(g);
			blackPlayer3.draw(g);
			blackPlayer4.draw(g);
			blackPlayer5.draw(g);
			blackPlayer6.draw(g);
			blackPlayer7.draw(g);

			topGoal.draw(g);
			bottomGoal.draw(g);

			if (bottomGoalScore == 10 || topGoalScore== 10)
			{
				screenSelect = GAME_OVER;
			}
		}

		else if (screenSelect == GAME_OVER)
		{
			g.setColor(Color.GREEN);
			g.fillRect(0, 0, MAX_WIDTH, MAX_HEIGHT);

			g.setColor(Color.BLACK);
			g.setFont(new Font("Comic Sans" , Font.BOLD, 50));	
			g.drawString("GAME OVER", MAX_WIDTH/2 - 160, GRASS_HEIGHT/2);

			g.setColor(Color.BLACK);
			g.setFont(new Font("Comic Sans" , Font.BOLD, 20));	
			g.drawString("CLICK \"SPACE\" TO PLAY AGAIN", MAX_WIDTH/2 - 160, GRASS_HEIGHT/2 + 100);
		}

	}

	@Override
	public void keyTyped(KeyEvent e) 
	{

	}

	@Override
	public void keyPressed(KeyEvent e) 
	{
		int keyCode = e.getKeyCode();
		if (screenSelect == WELCOME && keyCode == KeyEvent.VK_SPACE)
		{
			screenSelect = PLAYING;
		}

		if (screenSelect == GAME_OVER && keyCode == KeyEvent.VK_SPACE)
		{
			screenSelect = PLAYING;
			foosball.resetScore();
		}

		if (keyCode == KeyEvent.VK_COMMA)
		{
			whitePlayer2.moveLeft(GRASS_X, whitePlayer1, whitePlayer3);
		}
		else if (keyCode == KeyEvent.VK_PERIOD)
		{
			whitePlayer3.moveRight(GRASS_X, GRASS_WIDTH, whitePlayer1, whitePlayer2);
		}
		else if (keyCode == KeyEvent.VK_Z)
		{
			blackPlayer2.moveLeft(GRASS_X, blackPlayer1, blackPlayer3);
		}
		else if (keyCode == KeyEvent.VK_X)
		{
			blackPlayer3.moveRight(GRASS_X, GRASS_WIDTH, blackPlayer1, blackPlayer2);
		}
		else if (keyCode == KeyEvent.VK_RIGHT)
		{
			whitePlayer7.moveRightBig(GRASS_X, GRASS_WIDTH, whitePlayer4, whitePlayer5, whitePlayer6);
		}
		else if (keyCode == KeyEvent.VK_LEFT)
		{
			whitePlayer4.moveLeftBig(GRASS_X, whitePlayer5, whitePlayer6, whitePlayer7);
		}
		else if (keyCode == KeyEvent.VK_A)
		{
			blackPlayer4.moveLeftBig(GRASS_X, blackPlayer5, blackPlayer6, blackPlayer7);
		}
		else if (keyCode == KeyEvent.VK_S)
		{
			blackPlayer7.moveRightBig(GRASS_X, GRASS_WIDTH, blackPlayer4, blackPlayer5, blackPlayer6);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) 
	{

	}

}