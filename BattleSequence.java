import java.awt.*;
import java.applet.*;
import java.util.ArrayList;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.awt.Graphics2D;

import javax.imageio.*;
import javax.swing.*;

class MenuPosition {
	int count;
	int index;
	BufferedImage bs = new BufferedImage(1,1,1); 
}
public class BattleSequence implements KeyListener{
 	public void init() {
		this.addKeyListener(this);
		try {
			bs = ImageIO.read("BackgroundTester.jpg")
		}
	}
	 	public void paint(Graphics g) {

	 		Graphics2D g2 = (Graphics2D)g;
	 		
	 	}
		MenuPosition menuPos = new MenuPosition();
		String[] menuArray = new String[3];
		menuArray[0] = "Attack";
		menuArray[1] = "Magic";
		//Doesn't Work
		menuArray[2] = "Flee";
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			index--;
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			index++;
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
			if (menuArray[] = menuArray[1])
				//Put in Attack Function Here!
			if (menuArray[] = menuArray[2])
				//Put in Magic Function Here!
			if (menuArray[] = menuArray[3])
				//Put in Flee Function Here!

	}
	

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

