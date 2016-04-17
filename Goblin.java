public class Goblin extends Chara
{
	private Attack spear = new Attack("Weapon", 3);

	public Goblin(BufferedImage i, int xo, int yo, int h, int arm, int res, Map m)
	{
		super(i, xo, yo, h, 3, 1, m);
	}

	public int spear(Chara player)
	{
		return this.attack(player, spear);
	}
}
