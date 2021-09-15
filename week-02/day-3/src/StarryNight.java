import javax.swing.*;

import java.awt.*;
import java.util.Random;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class StarryNight {
  public static void drawImage(Graphics graphics) {
    // Draw the night sky:
    //  - The background should be black
    //  - The stars can be small squares
    //  - The stars should have random positions on the canvas
    //  - The stars should have random color (some shade of grey)


    Random rn = new Random();
    graphics.setColor(Color.BLACK);
    graphics.fillRect(0,0,320, 320);

    int nrStars = 200 + rn.nextInt(500);
    for (int i = 0; i < nrStars; i++) {
      int x = rn.nextInt(320);
      int y = rn.nextInt(320);
      int starSize = 1 + rn.nextInt(2);
      int z = rn.nextInt(256);
      Color starColor = new Color (z, z, z);
      drawStar(x, y, starSize, starColor, graphics);
    }
  }

  public static void drawStar(int x, int y, int size, Color c, Graphics g){
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