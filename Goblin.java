import java.awt.*;
import java.applet.*;
import java.util.ArrayList;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

public class Goblin extends Chara
{
	private Attack spear = new Attack("Weapon", 3);

	public Goblin(BufferedImage i, int xo, int yo, int h, Map m)
	{
		super(i, xo, yo, h, 3, 1, m);
	}

	public int spear(Chara player)
	{
		return this.attack(player, spear);
	}

	public int hit(Chara player)
	{
		spear(player);
		return 0;
	}
}
