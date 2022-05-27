import java.awt.Color;
import java.awt.Graphics;

public class Goal 
{

	private int x, y, height, width;
	private Color color;

	public Goal (int xIn, int yIn, int widthIn, int heightIn, Color colorIn )
	{
		x = xIn;
		y = yIn;
		height = heightIn;
		width = widthIn;
		color = colorIn;
	}

	public int getRightX()
	{
		return x + width;
	}

	public int getLeftX()
	{
		return x;
	}

	public void draw (Graphics g)
	{
		g.setColor(color);
		g.fillRect(x, y, width, height);
	}

}