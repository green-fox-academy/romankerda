import javax.swing.*;

import java.awt.*;

import static java.awt.image.ImageObserver.HEIGHT;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Checkerboard {
  public static void drawImage(Graphics graphics) {
    // Fill the canvas with a checkerboard pattern

    Color color;
    int x = 0;
    int y = 0;

    for (int row = 0; row < 8; row++) {
      for (int col = 0; col < 8; col++) {
        if (row % 2 == 0 && col % 2 == 0 || row % 2 != 0 && col % 2 != 0) {
          color = Color.WHITE;
        } else color = Color.BLACK;
        drawSquare(x, y, WIDTH / 8, color, graphics);
        x += WIDTH / 8;
      }
      x = 0;
      y += HEIGHT / 8;
    }
  }


  public static void drawSquare(int x, int y, int size, Color c, Graphics g) {
    g.setColor(c);
    g.fillRect(x, y, size, size);
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