import java.awt.*;
import java.applet.*;
import java.util.ArrayList;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

public class main extends Applet implements KeyListener 
{
  private Rectangle rect;
  private BufferedImage plS = new BufferedImage(1, 1, 1);
  private Knight player;
  private Map m;
  private Entity[][] locs;
  
  private ArrayList<Integer> keysDown;
  
  public void init() 
  {
    try
    {
      plS = ImageIO.read(new File("Knight Rest.PNG"));
    }
    catch (IOException e){System.out.println(e);}
    locs = new Entity[800][600];
    m = new Map(locs);
    player = new Knight(plS, 100, 100, 2000, m);
    this.addKeyListener(this);
    keysDown = new ArrayList<Integer>();
  }

  public void paint(Graphics g) 
  {
    setSize(800, 600);
    
    Graphics2D g2 = (Graphics2D)g;
    g2.drawImage(plS, player.x, player.y, null);
  }
  
  public void keyPressed(KeyEvent e) {
    if (!keysDown.contains(e.getKeyCode()) && e.getKeyCode() != 86)
      keysDown.add(new Integer(e.getKeyCode()));
    
    movement();
  }

  public void keyReleased(KeyEvent e) 
  {
    keysDown.remove(new Integer(e.getKeyCode()));
    
  }
  
  public void movement() {
    int x = player.x;
    int y = player.y;
    
    if (keysDown.contains(KeyEvent.VK_UP))
      y -= 10;
    if (keysDown.contains(KeyEvent.VK_DOWN))
      y += 10;
    if (keysDown.contains(KeyEvent.VK_LEFT))
      x -= 10;
    if (keysDown.contains(KeyEvent.VK_RIGHT))
      x += 10;
    player.move(m, x, y);
    repaint();
    
    
  }
  public void keyTyped(KeyEvent e) 
  {
    
  }
}
