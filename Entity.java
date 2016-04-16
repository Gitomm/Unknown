import java.awt.*;

public class Entity
{
	private BufferedImage sprite;
	private int x;
	private int y;

	public Entity(BufferedImage i, int xo, int yo)
	{
		sprite = i;
		x = xo;
		y =yo;
	}
	
	public void showSprite()
	{
		Graphics g = panel.getGraphics();
		g.drawImage(sprite, x, y, null);
	}
}