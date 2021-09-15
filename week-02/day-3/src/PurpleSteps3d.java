import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class PurpleSteps3d {
  public static void drawImage(Graphics graphics) {
    // Reproduce this:
    // [https://github.com/green-fox-academy/teaching-materials/blob/master/workshop/drawing/assets/r4.png]

    Color color = new Color(160, 80, 235);
    double size = 5;
    int number = 20;
    int x = 20;
    int y = 20;
    for (int i = 0; i < number; i++) {
      drawSquare(x, y, size, color, graphics);
      x += size;
      y += size;
      size = 1.3 * size;
      if (x > WIDTH - size - 20) {
        break;
      }
    }
  }

  public static void drawSquare(int x, int y, double size, Color c, Graphics g) {
    g.setColor(c);
    g.fillRect(x, y, (int) size, (int) size);
    g.setColor(Color.BLACK);
    g.drawRect(x, y, (int) size, (int) size);
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
