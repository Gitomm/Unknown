import javax.swing.*;
import java.awt.*;
import java.awt.image.*;

public class Knight extends Chara
{
	private Attack slash = new Attack("Weapon", 3);
	private Attack stab = new Attack("Weapon", 5);

	public Knight(BufferedImage i, int xo, int yo, int h, int arm, int res)
	{
		super(i, xo, yo, h, 8, 2);
	}

	public int slash(Chara e1, Chara e2, Chara e3)
	{
		int ret = 0;
		ret += this.attack(e1, slash);
		ret += this.attack(e2, slash);
		ret += this.attack(e3, slash);
		return ret;
	}

	public int stab(Chara e)
	{
		return this.attack(e, stab);
	}
}