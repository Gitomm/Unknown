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
  private Chara player;
  private Map m;
  private Entity[][] locs;
  
  private ArrayList<Integer> keysDown;
  
  public void init() 
  {
    try
    {
      plS = ImageIO.read(new File("\\Enemies\\Goblin Jester King.PNG"));
    }
    catch (IOException e){System.out.println(e);}
    locs = new Entity[32][25];
    m = new Map(locs);
    player = new Chara(plS, 100, 100, 2000, 5, 2, m);
    this.addKeyListener(this);
    keysDown = new ArrayList<Integer>();
    rect = new Rectangle(0, 0, 50, 50);
  }

  public void paint(Graphics g) 
  {
    setSize(1024, 800);
    
    Graphics2D g2 = (Graphics2D)g;
    g2.drawImage(plS, 100, 100, null);
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
      y -= 2;
    if (keysDown.contains(KeyEvent.VK_DOWN))
      y += 2;
    if (keysDown.contains(KeyEvent.VK_LEFT))
      x -= 2;
    if (keysDown.contains(KeyEvent.VK_RIGHT))
      x += 2;
    player.move(m, x, y);
    repaint();
    
    
  }
  public void keyTyped(KeyEvent e) 
  {
    
  }
}
