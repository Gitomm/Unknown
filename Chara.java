import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public class Chara extends Entity
{
	private int health;
	private int armor;
	private int resistance;
	public Chara(BufferedImage i, int xo, int yo, int h, int arm, int res, Map m)
	{
		super(i, xo, yo, m);
		health = h;
		armor = arm;
		resistance = res;
		m.map[yo][xo] = this;
	}

	public boolean canMove(Map m, int nx, int ny)
	{
		if (nx > m.map[0].length || nx < 0 || ny > m.map.length || ny < 0 || nx > m.map[0].length)
			return false;
		return (!(m.map[ny][nx] instanceof Terrain || m.map[ny][nx] instanceof Chara) && (nx < m.map[0].length && nx >= 0) && (m.map.length > ny && ny >= 0));
	}

	public void move(Map m, int nx, int ny)
	{
		if (canMove(m, nx, ny))
		{
			m.map[ny][nx] = this;
			m.map[ny][nx] = null;
			this.x = nx;
			this.y = ny;
		}
	}

	public int getHealth()
	{
		return health;
	}

	public int damage(Attack att)
	{
		health = health-att.dmgValue(resistance, armor);
		return att.dmgValue(this.resistance, this.armor);
	}

	public int attack(Chara enm, Attack att)
	{
		int bef = enm.getHealth();
		enm.damage(att);
		return (bef - enm.getHealth());
	}
}
