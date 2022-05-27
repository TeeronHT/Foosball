import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.*;
import javax.swing.ImageIcon;

/**
 * 
 * @author teeron
 *
 */
public class Ball extends JFrame
{
	// DATA:
	private static Image soccerBall = new ImageIcon("SOCCERBALL.png").getImage();
	private int x, y;		// Center of the ball
	private double dx, dy;		// Velocity - how much to move the ball in one time unit
	private int radius;		// Radius of the ball
	private Color color;	// Color of the ball
	private static final double INCREASE = 1.05;
	public static int topScore = 0;
	public static int bottomScore = 0;


	// METHODS:

	/**
	 * Ball constructor initializes the Ball object
	 * 
	 * @param xIn		x coordinate of center
	 * @param yIn		y coordinate of center
	 * @param dxIn		x velocity
	 * @param dyIn		y velocity
	 * @param radiusIn	radius
	 * @param colorIn	color
	 */
	public Ball (int xIn, int yIn, double dxIn, double dyIn, int radiusIn, Color colorIn)
	{
		// Nothing to do but save the data in the object's data fields.
		x = xIn;
		y = yIn;
		dx = dxIn;
		dy = dyIn;
		radius = radiusIn;
		color = colorIn;
	}

	// bounceOffBox -- Check for bouncing off the box.
	//  This assumes we've already moved the ball but have not yet done
	//  the wall bounce check.
	public void bounceOffBox(Player player)
	{
		// We need the old position before the current move
		double xOld = x - dx;
		double yOld = y - dy;

		// Next we need the edges of the box
		double xMinBox = player.getXMin();
		double xMaxBox = player.getXMax();
		double yMinBox = player.getYMin();
		double yMaxBox = player.getYMax();

		// Now see if we've hit or crossed into the box.  If so, bounce.
		if (xOld + radius < xMinBox && x + radius >= xMinBox)
		{
			// The ball crossed xMinBox moving right.
			// See if it crossed between yMinBox and yMaxBox.
			double yIntercept = y + (xMinBox - x) * dy / dx;
			if (yIntercept > yMinBox - radius && yIntercept < yMaxBox + radius)
			{
				
				dx = - dx;
				dx = dx * INCREASE;
				
			}
		}
		else if (x - radius < xMaxBox && xOld - radius >= xMaxBox)
		{ 
			// The ball crossed xMaxBox moving left.
			// See if it crossed between yMinBox and yMaxBox.
			double yIntercept = y + (xMaxBox - x) * dy / dx;
			if (yIntercept > yMinBox - radius && yIntercept < yMaxBox + radius)
			{
				
				dx = - dx;
				dx = dx * INCREASE;
				
			}
		}

		if (yOld + radius < yMinBox && y + radius >= yMinBox)
		{
			// The ball crossed yMinBox moving down.
			// See if it crossed between xMinBox and xMaxBox.
			double xIntercept = x + (yMinBox - y) * dx / dy;
			if (xIntercept > xMinBox - radius && xIntercept < xMaxBox + radius)
			{
				
				dy = - dy;
				dy = dy * INCREASE;
				
			}
		}
		else if (y - radius < yMaxBox && yOld - radius >= yMaxBox)
		{
			// The ball crossed yMaxBox moving up.
			// See if it crossed between xMinBox and xMaxBox.
			double xIntercept = x + (yMaxBox - y) * dx / dy;
			if (xIntercept > xMinBox - radius && xIntercept < xMaxBox + radius)
			{
				
				dy = - dy;
				dy = dy * INCREASE;
				
			}
		}
	}

	public int getTopScore()
	{
		
		return topScore;
		
	}

	public int getBottomScore()
	{
		
		return bottomScore;
		
	}

	/**
	 * Move the ball.  
	 */
	public void move()
	{
		
		x = (int)(x + dx);
		y = (int)(y + dy);

		dx = dx / 1.0006;
		dy = dy / 1.0006;
		
	}
	
	public void resetScore()
	{
		
		topScore = 0;
		bottomScore = 0;
		
	}

	/**
	 * Check if the ball should bounce off any of the walls.  It will only
	 * bounce if it was heading toward the wall and went a bit past it.  If
	 * so just change the sign of the corresponding velocity.  Not a very
	 * accurate way to handle this, but it is simple and it mostly works.
	 * 
	 * @param xLow		x coord of left wall
	 * @param xHigh		x coord of right wall
	 * @param yLow		y coord of top wall
	 * @param yHigh		y coord of bottom wall
	 */
	public void bounce(int xLow, int xHigh, int yLow, int yHigh, Goal goal)
	{
		// Check for an x bounce.  Note that we bounce if the x is too
		//  low or too high AND IS HEADING IN THE WRONG DIRECTION.

		if ((x - radius <= xLow && dx < 0 ) || (x + radius >= xHigh && dx > 0))
		{

			dx = -dx;
			dx = dx / 1.0006;

		}

		// Now check for a y bounce.
		if ((y - radius <= yLow && dy < 0) || (y + radius >= yHigh && dy > 0))
		{
			if (((x - radius >= goal.getLeftX()) && (x + radius <= goal.getRightX())))
			{
				if (y > 400)
				{
					bottomScore ++;
					dx = 5;
					dy = 5;
				}
				else
				{
					topScore ++;
					dx = 5;
					dy = -5;
				}

				x = xLow;
				y = (yHigh/2) + yLow;

			}
			else
			{
				dy = -dy;
				dy = dy / 1.0006;
			}
		}
	}

	/**
	 * Draw the ball.
	 * 
	 * @param g			Graphics object in which to draw
	 */
	public void draw(Graphics g)
	{
		g.drawImage(soccerBall,x - radius, y - radius, 2 * radius, 2 * radius, this);
		//g.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);
	}
}