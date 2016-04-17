public class main {
  public static void main(String[] args) {
      NewControl n = new NewControl();
      System.out.print("It works!");
      try
      {
        BufferedImage i = ImageIO.read(new File("goblin jester king.PNG"));
      }
      catch (IOException e){}
      Object[][] m = new Object[25][19];
      Map level = new Map();
      Chara player = new Chara(i, 16, 16, 200, 5, 4);
      level.showMap();
      n.init();
    }
}
