import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public class Chara extends Entity
{
	private int health;
	private int armor;
	private int resistance;
	public Chara(BufferedImage i, int xo, int yo, int h, int arm, int res)
	{
		super(i, xo, yo);
		health = h;
		armor = arm;
		resistance = res;
	}

	public boolean canMove(Map m, int nx, int ny)
	{
		return (!(m.map[nx][ny] instanceof Terrain) && (nx < m.map.length && nx >= 0) && (m.map[nx].length > ny && ny >= 0));
	}

	public void move(Map m, int nx, int ny)
	{
		if (canMove(m, nx, ny))
			m.map[nx][ny] = this;
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