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
  private BufferedImage plS = new BufferedImage(1, 1, 1);
  private BufferedImage gKSprite = new BufferedImage(1, 1, 1);
  private BufferedImage rG = new BufferedImage(1, 1, 1);
  private BufferedImage bG = new BufferedImage(1, 1, 1);
  private GoblinKing gK;
  private Knight player;
  private Goblin g1;
  private Goblin g2;
  private Goblin g3;
  private Goblin g4;
  private Map m;
  private Terrain tree;
  private Entity[][] locs;
  
  private ArrayList<Integer> keysDown;
  
  public void init() 
  {
    try
    {
      plS = ImageIO.read(new File("Knight Rest.PNG"));
      gKSprite = ImageIO.read(new File("Goblin Jester King.PNG"));
      rG = ImageIO.read(new File("Goblin (Front).PNG"));
      bG = ImageIO.read(new File("grass map.PNG"));
    }
    catch (IOException e){System.out.println(e);}
    locs = new Entity[800][600];
    m = new Map(locs);
    gK = new GoblinKing(gKSprite, 200, 200, 1000, m);
    g1 = new Goblin(rG, 100, 300, 300, m);
    g2 = new Goblin(rG, 100, 499, 300, m);
    g3 = new Goblin(rG, 500, 300, 300, m);
    g4 = new Goblin(rG, 300, 499, 300, m);
    player = new Knight(plS, 100, 100, 2000, m);

    this.addKeyListener(this);
    keysDown = new ArrayList<Integer>();
  }

  public void paint(Graphics g) 
  {
    setSize(800, 600);
    
    Graphics2D g2d = (Graphics2D)g;
    g2d.drawImage(bG, 0, 0, null);
    g2d.drawImage(plS, player.x, player.y, null);
    g2d.drawImage(gKSprite, gK.x, gK.y, null);
    g2d.drawImage(rG, g1.x, g1.y, null);
    g2d.drawImage(rG, g2.x, g2.y, null);
    g2d.drawImage(rG, g3.x, g3.y, null);
    g2d.drawImage(rG, g4.x, g4.y, null);

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
    
    if (keysDown.contains(KeyEvent.VK_UP) && player.canMove(m, x, y-10))
      y -= 10;
    if (keysDown.contains(KeyEvent.VK_DOWN) && player.canMove(m, x, y+10))
      y += 10;
    if (keysDown.contains(KeyEvent.VK_LEFT) && player.canMove(m, x-10, y))
      x -= 10;
    if (keysDown.contains(KeyEvent.VK_RIGHT) && player.canMove(m, x+10, y))
      x += 10;
    player.move(m, x, y);
    repaint();
    
    
  }
  public void keyTyped(KeyEvent e) 
  {
    
  }
}
