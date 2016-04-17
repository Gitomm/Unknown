import java.awt.*;
import java.applet.*;
import java.util.ArrayList;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

public class GoblinKing extends Chara
{
	private Attack basic = new Attack ("Weapon", 3);
	private Attack heavy = new Attack ("Weapon", 5);

	public GoblinKing(BufferedImage i, int xo, int yo, int h, Map m)
	{
		super(i, xo, yo, h, 4, 4, m);
	}

	public int basic(Chara player)
	{
		return this.attack(player, basic);
	}

	public int heavy(Chara player)
	{
		return this.attack(player, heavy);
	}

	public void summonGoblin(Map m)
	{

	}

	public int hit(Chara player)
	{
		if (Math.random() < 0.4)
			heavy(player);
		else
			basic(player);
		return 0;
	}
}
