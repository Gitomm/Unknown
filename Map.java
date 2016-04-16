public class Map
{
	public Object[][] map;

	public Map(Object[][] o)
	{
		map = o;
	}

	public void showMap()
	{
		for (Object o : map)
		{
			o.showSprite();
		}
	}
}