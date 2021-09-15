import javax.swing.*;

import java.awt.*;
import java.util.Random;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class FourRectangles {

  public static void drawImage(Graphics graphics){
    // Draw four different size and color rectangles
    // Avoid code duplication!

    Random rn = new Random();
    for (int i = 0; i < 4; i++) {
      int x = rn.nextInt(321);
      int y = rn.nextInt(321);
      int width = rn.nextInt(321-x);
      int height = rn.nextInt(321-y);
      int r = rn.nextInt(256);
      int g = rn.nextInt(256);
      int b = rn.nextInt(256);
      drawRectangle(x, y, width, height, new Color(r,g,b), graphics);
    }

  }
  public static void drawRectangle(int x, int y, int width, int height, Color c, Graphics g) {
    g.setColor(c);
    g.drawRect(x, y, width, height);
  }

  // Don't touch the code below
  static int WIDTH = 320;
  static int HEIGHT = 320;

  public static void main(String[] args) {
    JFrame jFrame = new JFrame("Drawing");
    jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    ImagePanel panel = new ImagePanel();
    panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
    jFrame.add(panel);
    jFrame.setLocationRelativeTo(null);
    jFrame.setVisible(true);
    jFrame.pack();
  }

  static class ImagePanel extends JPanel {
    @Override
    protected void paintComponent(Graphics graphics) {
      super.paintComponent(graphics);
      drawImage(graphics);
    }
  }
}
