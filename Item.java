public class Item
{
	private String name;

	public Item (String name)
	{
		name = name;
	}

	public int use(Chara c)
	{
		int hp = c.health;
		if (name.equals("Elixer"))
		{
			c.health = 2000;
			return (c.health - hp);
		}
		else if (name.equals("Heart"))
		{
			c.health += 100;
			return 100;
		}
		return 0;
	}
}