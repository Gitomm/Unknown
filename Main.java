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
  private BufferedImage bs = new BufferedImage(1, 1, 1);
  private BufferedImage fight = new BufferedImage(1, 1, 1);
  private BufferedImage pFight = new BufferedImage(1, 1, 1);
  private BufferedImage arrow = new BufferedImage(1, 1, 1);
  private BufferedImage iM = new BufferedImage(1, 1, 1);
  private BufferedImage arrow2 = new BufferedImage(1, 1, 1);
  private Chara collided;
  private GoblinKing gK;
  private Knight player;
  private Goblin g1;
  private Goblin g2;
  private Goblin g3;
  private Goblin g4;
  private Map m;
  private Terrain tree;
  private Entity[][] locs;
  private String[] menu = {"Attack", "Item"};
  private int index = 0;
  private boolean battle = false;
  private int turn = 0;
  private int a2x = 250;
  private int a2y = 500;
  
  private ArrayList<Integer> keysDown;
  
  public void init() 
  {
    try
    {
      plS = ImageIO.read(new File("Knight Rest.PNG"));
      gKSprite = ImageIO.read(new File("Goblin Jester King.PNG"));
      rG = ImageIO.read(new File("Goblin (Front).PNG"));
      bG = ImageIO.read(new File("grass map.PNG"));
      bs = ImageIO.read(new File("battle map.PNG"));
      fight = ImageIO.read(new File("attack word.PNG"));
      pFight = ImageIO.read(new File("Knight attack 1.PNG"));
      arrow = ImageIO.read(new File("Arrow.PNG"));
      iM = ImageIO.read(new File("item command.PNG"));
      arrow2 = ImageIO.read(new File("arrow2.PNG"));
    }
    catch (IOException e){System.out.println(e);}
    locs = new Entity[800][600];
    m = new Map(locs);
    gK = new GoblinKing(gKSprite, 200, 200, 1, m);
    g1 = new Goblin(rG, 100, 300, 300, m);
    g2 = new Goblin(rG, 100, 500, 300, m);
    g3 = new Goblin(rG, 500, 300, 300, m);
    g4 = new Goblin(rG, 300, 500, 300, m);
    player = new Knight(plS, 0, 0, m);

    this.addKeyListener(this);
    keysDown = new ArrayList<Integer>();
  }

  public void paint(Graphics g) 
  {
    setSize(800, 600);
    
    Graphics2D g2d = (Graphics2D)g;
      if (!battle)
      {
        g2d.drawImage(bG, 0, 0, null);
        g2d.drawImage(plS, player.x, player.y, null);
        g2d.drawImage(gKSprite, gK.x, gK.y, null);
        g2d.drawImage(rG, g1.x, g1.y, null);
        g2d.drawImage(rG, g2.x, g2.y, null);
        g2d.drawImage(rG, g3.x, g3.y, null);
        g2d.drawImage(rG, g4.x, g4.y, null);
      }
      else
      {
        g2d.drawImage(bG, 0, 0, null);
        g2d.drawImage(pFight, 200, 200, null);
        g2d.drawImage(collided.sprite, 600, 200, null);
        g2d.drawImage(fight, 300, 500, null);
        g2d.drawImage(iM, 400, 500, null);
        g2d.drawImage(arrow, 250, 500, null);
        g2d.drawImage(arrow, 350, 500, null);
        g2d.drawImage(arrow2, a2x, a2y, null);
      }
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
  
  public void movement() 
  {
    if (battle)
    {
      if (collided.health <= 0)
      {
        battle = false;
        m.map[collided.y][collided.x] = null;
        collided.y = 0;
        collided.x = 0;
        collided = null;
        repaint();
      }
      if (turn == 1)
      {
        collided.hit(player);
        turn = 0;
      }
      if (keysDown.contains(KeyEvent.VK_LEFT))
      {
        index = 0;
        a2x = 250;
      }
      else if (keysDown.contains(KeyEvent.VK_RIGHT))
      {
        index = 1;
        a2x = 350;
      }
      else if (keysDown.contains(KeyEvent.VK_SPACE))
      {
        if (index == 0)
        {
          player.stab(collided);
          turn = 1;
        }
        else
        {
          player.useItem(new Item("Elixer"));
          turn = 1;
        }
      }
      repaint();
    }
    if (!battle)
    {
      int x = player.x;
      int y = player.y;
      
      if (keysDown.contains(KeyEvent.VK_UP))
      {
        if (player.canMove(m, x, y-10))
        {
          y -= 10;
          battle = false;
        }
        else
        {
          battle = true;
          collided = (Chara) m.map[y-10][x];
        }
      }
      if (keysDown.contains(KeyEvent.VK_DOWN))
        if (player.canMove(m, x, y+10))
        {
          y += 10;
          battle = false;
        }
        else
        {
          battle = true;
          collided = (Chara) m.map[y+10][x];
        }
      if (keysDown.contains(KeyEvent.VK_LEFT) && player.canMove(m, x-10, y))
        if (player.canMove(m, x-10, y))
        {
          x -= 10;
          battle = false;
        }
        else
        {
          battle = true;
          collided = (Chara) m.map[y][x-10];
        }
      if (keysDown.contains(KeyEvent.VK_RIGHT) && player.canMove(m, x+10, y))
        if (player.canMove(m, x+10, y))
        {
          x += 10;
          battle = false;
        }
        else
        {
          battle = true;
          collided = (Chara) m.map[y][x+10];
        }
      if (!battle)
        player.move(m, x, y);
      repaint();
      
      
    }
  }
    public void keyTyped(KeyEvent e) 
    {
      
    }
}
