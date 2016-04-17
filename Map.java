import javax.swing.*;

public class Map
{
	public JFrame frame = new JFrame("Unknown: The Game");
	public JPanel panel = new JPanel();
	public Entity[][] map;

	public Map(Entity[][] o)
	{
		map = o;
	}

	public void showMap()
	{
		for (Entity[] o : map)
		{

			for (Entity e : o)
			{
				e.showSprite(this);
			}
		}
	}
}
