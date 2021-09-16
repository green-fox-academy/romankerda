import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class LinePlayQuarters {
  public static void drawImage(Graphics graphics) {


    int width = 160;
    int height = width;

    for (int i = 0; i < 320; i += width) {
      for (int j = 0; j < 320; j += height) {
        int xOrigin = i;
        int yOrigin = j;
        for (int x = xOrigin; x < xOrigin + width; x += width / 16) {
          for (int y = yOrigin; y < yOrigin + height; y += height / 16) {
            if (x == xOrigin && y > yOrigin) {
              drawLine(x, y, xOrigin + y - yOrigin, yOrigin + width, Color.BLUE, graphics);
            }
            if (y == yOrigin && x > xOrigin) {
              drawLine(x, y, xOrigin + width, yOrigin + x - xOrigin, Color.ORANGE, graphics);
            }
          }
        }
      }
    }
  }

  public static void drawLine(int x1, int y1, int x2, int y2, Color c, Graphics g) {
    g.setColor(c);
    g.drawLine(x1, y1, x2, y2);
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