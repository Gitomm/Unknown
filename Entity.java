import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import javax.imageio.*;
import java.awt.event.*;

public class Entity
{
	private BufferedImage sprite;
	public int x;
	public int y;

	public Entity(BufferedImage i, int xo, int yo, Map m)
	{
		sprite = i;
		x = xo;
		y = yo;
		m.map[y][x] = this;
	}

	public void showSprite(Map m)
	{
		Graphics g = m.panel.getGraphics();
		g.drawImage(sprite, x, y, null);
	}
}
