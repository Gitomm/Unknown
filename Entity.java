import java.awt.*;
import javax.swing.*;

public class Entity
{
	private BufferedImage sprite;
	public int x;
	public int y;

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