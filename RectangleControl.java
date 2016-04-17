import java.applet.Applet;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class RectangleControl extends Applet implements KeyListener{
	private Rectangle rect;
	
	
	private ArrayList<Integer> keysDown;
	
 	public void init() {
		this.addKeyListener(this);
		keysDown = new ArrayList<Integer>();
		rect = new Rectangle(0, 0, 50, 50);
	}
 	public void paint(Graphics g) {
 		setSize(500, 500);
 		
 		Graphics2D g2 = (Graphics2D)g;
 		g2.fill(rect);
 	}
	@Override
	public void keyPressed(KeyEvent e) {
		if (!keysDown.contains(e.getKeyCode()) && e.getKeyCode() != 86)
			keysDown.add(new Integer(e.getKeyCode()));
		
		moveRect();
	}
	@Override
	public void keyReleased(KeyEvent e) {
		keysDown.remove(new Integer(e.getKeyCode()));
		
	}
	
	public void moveRect() {
		int x = rect.x;
		int y = rect.y;
		
		if (keysDown.contains(KeyEvent.VK_UP))
			y -= 2;
		if (keysDown.contains(KeyEvent.VK_DOWN))
			y += 2;
		if (keysDown.contains(KeyEvent.VK_LEFT))
			x -= 2;
		if (keysDown.contains(KeyEvent.VK_RIGHT))
			x += 2;
		rect.setLocation(x, y);
		repaint();
		
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}