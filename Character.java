public class Character extends Entity
{
	private int health;

	public Character(BufferedImage i, int xo, int yo, int h)
	{
		super(i, xo, yo);
		health = h;
	}

	public boolean canMove(Map m, int nx, int ny)
	{
		return (!(m.map[nx][ny] instanceof terrain) && (nx < m.map.length && nx >= 0) && (m.map[nx].length > ny && ny >= 0));
	}

	public void move(int nx, int ny)
	{
		if (canMove(nx, ny))
			m.map[nx][ny] = this;
	}

	public int getHealth()
	{
		return health;
	}

	public int damage(Attack att)
	{
		health = health-att.dmgValue();
		return att.dmgValue();
	}

	public int attack(Character enm, Attack att)
	{
		int bef = enm.getHealth();
		enm.damage(att);
		return (bef - enm.getHealth());
	}
}