import java.awt.Color;
import java.awt.Graphics;

public class Player 
{

	private int xMax, yMax, xMin, yMin;
	private Color color;
	private static final int INTERVAL = 8;
	private static final int PLAYER_WIDTH = 20;

	public Player (int xMinIn, int xMaxIn, int yMinIn, int yMaxIn, Color colorIn)
	{
		xMax = xMaxIn;
		yMax = yMaxIn;
		yMin = yMinIn;
		xMin = xMinIn;
		color = colorIn;
	}

	public int getXMin() 
	{
		return xMin;
	}

	public int getXMax() 
	{
		return xMax;
	}

	public int getYMin() 
	{
		return yMin;
	}

	public int getYMax() 
	{
		return yMax;
	}

	public void setXMin(int newMinX) 
	{
		xMin = newMinX;
	}

	public void setXMax(int newMaxX) 
	{
		xMax = newMaxX;
	}

	public void moveRight(int grassX, int grassWidth, Player player1, Player player2) 
	{
		int player1XMax = player1.getXMax();
		int player2XMax = player2.getXMax();

		int player1XMin = player1.getXMin();
		int player2XMin = player2.getXMin();

		//If the player hits the edge
		if(xMax + INTERVAL >= grassWidth + grassX)
		{
			xMax = grassWidth + grassX;
			xMin = xMax - PLAYER_WIDTH;

			player1XMax = xMax - (3 * PLAYER_WIDTH);
			player2XMax = xMax - (6 * PLAYER_WIDTH);

			player1.setXMax(player1XMax);
			player2.setXMax(player2XMax);

			player1XMin = player1XMax - PLAYER_WIDTH;
			player2XMin = player2XMax - PLAYER_WIDTH;

			player1.setXMin(player1XMin);
			player2.setXMin(player2XMin);
		}
		else //If the player doesn't hit the wall
		{
			player1XMax = player1XMax + INTERVAL;
			player2XMax = player2XMax + INTERVAL;

			player1.setXMax(player1XMax);
			player2.setXMax(player2XMax);

			player1XMin = player1XMin + INTERVAL;
			player2XMin = player2XMin + INTERVAL;

			player1.setXMin(player1XMin);
			player2.setXMin(player2XMin);

			xMin = xMin + INTERVAL;
			xMax = xMax + INTERVAL;
		}
	}

	public void moveLeft(int grassX, Player player1, Player player2) 
	{
		int player1XMax = player1.getXMax();
		int player2XMax = player2.getXMax();

		int player1XMin = player1.getXMin();
		int player2XMin = player2.getXMin();

		if (xMin - INTERVAL <= grassX)
		{
			xMin = grassX;
			xMax = grassX + PLAYER_WIDTH;

			player1XMax = xMax + (3 * PLAYER_WIDTH);
			player2XMax = xMax + (6 * PLAYER_WIDTH);

			player1.setXMax(player1XMax);
			player2.setXMax(player2XMax);

			player1XMin = player1XMax - PLAYER_WIDTH;
			player2XMin = player2XMax - PLAYER_WIDTH;

			player1.setXMin(player1XMin);
			player2.setXMin(player2XMin);
		}
		else
		{
			player1XMax = player1XMax - INTERVAL;
			player2XMax = player2XMax - INTERVAL;

			player1.setXMax(player1XMax);
			player2.setXMax(player2XMax);

			player1XMin = player1XMin - INTERVAL;
			player2XMin = player2XMin - INTERVAL;

			player1.setXMin(player1XMin);
			player2.setXMin(player2XMin);

			xMin = xMin - INTERVAL;
			xMax = xMax - INTERVAL;
		}
	}
	
	public void moveRightBig(int grassX, int grassWidth, Player player1, Player player2, Player player3)
	{
		int player1XMax = player1.getXMax();
		int player2XMax = player2.getXMax();
		int player3XMax = player3.getXMax();

		int player1XMin = player1.getXMin();
		int player2XMin = player2.getXMin();
		int player3XMin = player3.getXMin();
		

		if (xMax + INTERVAL >= grassX + grassWidth)
		{
			xMax = grassX + grassWidth ;
			xMin = xMax - PLAYER_WIDTH;

			player1XMax = xMax - (PLAYER_WIDTH * 10);
			player2XMax = xMax - 130;
			player3XMax = xMax - 70 ;

			player1.setXMax(player1XMax);
			player2.setXMax(player2XMax);
			player3.setXMax(player3XMax);

			player1XMin = player1XMax - PLAYER_WIDTH;
			player2XMin = player2XMax - PLAYER_WIDTH;
			player3XMin = player3XMax - PLAYER_WIDTH;

			player1.setXMin(player1XMin);
			player2.setXMin(player2XMin);
			player3.setXMin(player3XMin);
		}
		else
		{
			xMin = xMin + INTERVAL;
			xMax = xMax + INTERVAL;
			
			player1XMax = player1XMax + INTERVAL;
			player2XMax = player2XMax + INTERVAL;
			player3XMax = player3XMax + INTERVAL;

			player1.setXMax(player1XMax);
			player2.setXMax(player2XMax);
			player3.setXMax(player3XMax);

			player1XMin = player1XMin + INTERVAL;
			player2XMin = player2XMin + INTERVAL;
			player3XMin = player3XMin + INTERVAL;

			player1.setXMin(player1XMin);
			player2.setXMin(player2XMin);
			player3.setXMin(player3XMin);
		}
	}
	
	public void moveLeftBig(int grassX, Player player1, Player player2, Player player3)
	{
		int player1XMax = player1.getXMax();
		int player2XMax = player2.getXMax();
		int player3XMax = player3.getXMax();

		int player1XMin = player1.getXMin();
		int player2XMin = player2.getXMin();
		int player3XMin = player3.getXMin();

		if (xMin - INTERVAL <= grassX)
		{
			xMin = grassX;
			xMax = grassX + PLAYER_WIDTH;

			player1XMax = xMax + 70;
			player2XMax = xMax + 130;
			player3XMax = xMax + 200;

			player1.setXMax(player1XMax);
			player2.setXMax(player2XMax);
			player3.setXMax(player3XMax);

			player1XMin = player1XMax - PLAYER_WIDTH;
			player2XMin = player2XMax - PLAYER_WIDTH;
			player3XMin = player3XMax - PLAYER_WIDTH;

			player1.setXMin(player1XMin);
			player2.setXMin(player2XMin);
			player3.setXMin(player3XMin);
		}
		else
		{
			player1XMax = player1XMax - INTERVAL;
			player2XMax = player2XMax - INTERVAL;
			player3XMax = player3XMax - INTERVAL;

			player1.setXMax(player1XMax);
			player2.setXMax(player2XMax);
			player3.setXMax(player3XMax);

			player1XMin = player1XMin - INTERVAL;
			player2XMin = player2XMin - INTERVAL;
			player3XMin = player3XMin - INTERVAL;

			player1.setXMin(player1XMin);
			player2.setXMin(player2XMin);
			player3.setXMin(player3XMin);

			xMin = xMin - INTERVAL;
			xMax = xMax - INTERVAL;
		}
	}

	public void draw(Graphics g)
	{
		g.setColor(color);
		g.fillRect(xMin, yMin, xMax - xMin, yMax - yMin);
	}

}