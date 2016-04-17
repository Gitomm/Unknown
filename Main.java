import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

public class main {
  public static void main(String[] args) {
      NewControl n = new NewControl();
      BufferedImage i = new BufferedImage(1, 1, 1);
      System.out.print("It works!");
      try
      {
        i = ImageIO.read(new File("goblin jester king.PNG"));
      }
      catch (IOException e){}
      Entity[][] m = new Entity[25][19];
      Map level = new Map(m);
      Chara player = new Chara(i, 16, 16, 200, 5, 4, level);
      level.showMap();
      n.init();
    }
}
