import javax.swing.*;

public class Map
{
	public JFrame frame = new JFrame("Unknown: The Game");
	public JPanel panel = new JPanel();
	public Object[][] map;

	public Map(Object[][] o)
	{
		map = o;
	}

	public void showMap()
	{
		for (Entity e : map)
		{
			e.showSprite();
		}
	}
}
