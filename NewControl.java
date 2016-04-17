import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Graphics2D;

public class NewControl extends Applet implements KeyListener{
    public void init() {
      this.addKeyListener(this);
    }
    public void keyTyped(KeyEvent e){}
    @Override
    public void keyPressed(KeyEvent e) {
      if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
        System.out.println("Right");
      }
      else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
        System.out.println("Left");
      }
      else if (e.getKeyCode() == KeyEvent.VK_UP) {
        System.out.println("Up");
      }
      else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
        System.out.println("Down");
      }
    }
    @Override
    public void keyReleased(KeyEvent e) {

    }
}
