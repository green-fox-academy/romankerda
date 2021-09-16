import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class LinePlay {
  public static void drawImage(Graphics graphics) {

    for (int x = 0; x < WIDTH; x += WIDTH / 16) {
      for (int y = 0; y < HEIGHT; y += HEIGHT / 16) {
        if (x == 0 && y > 0) {
          drawLine(x, y, y, WIDTH, Color.BLUE, graphics);
        }
        if (y == 0 && x > 0) {
          drawLine(x, y, HEIGHT, x, Color.ORANGE, graphics);
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