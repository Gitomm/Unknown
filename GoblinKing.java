public class GoblinKing extends Chara
{
	private Attack basic = new Attack ("Weapon", 3);
	private Attack heavy = new Attack ("Weapon", 5);

	public GoblinKing(BufferedImage i, int xo, int yo, int h, int arm, int res, Map m)
	{
		super(i, xo, yo, h, 4, 4, m);
	}

	public int basic(Chara player)
	{
		return this.attack(player, basic);
	}

	public int heavy(Chara player)
	{
		return this.attack(playe, heavy);
	}

	public void summonGoblin(Map m)
	{

	}
}
