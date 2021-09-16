import javax.swing.*;

import java.awt.*;

import static java.awt.image.ImageObserver.HEIGHT;
import static java.awt.image.ImageObserver.WIDTH;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class SuperHexagon {
  public static void drawImage(Graphics graphics) {

    draw6Hex(160, 160, graphics, 0);
  }

  public static void draw6Hex(int xPos, int yPos, Graphics g, int count) {
    int[] xCenter = {xPos - 18, xPos, xPos + 18, xPos + 18, xPos, xPos - 18};
    int[] yCenter = {yPos + 10, yPos + 20, yPos + 10, yPos - 10, yPos - 20, yPos - 10};

    for (int i = 0; i < 6; i++) {
      int xPosition = xCenter[i];
      int yPosition = yCenter[i];
      int[] xpoints = {xPosition - 6, xPosition + 6, xPosition + 12, xPosition + 6, xPosition - 6, xPosition - 12};
      int[] ypoints = {yPosition + 10, yPosition + 10, yPosition, yPosition - 10, yPosition - 10, yPosition};
      g.drawPolygon(xpoints, ypoints, 6);
    }
    count++;
    if (count > 3) {
      return;
    }
    for (int i = 0; i < 6; i++) {
      draw6Hex(xCenter[i], yCenter[i], g, count);
    }
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