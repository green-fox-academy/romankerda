package Fractals;

import javax.swing.*;

import java.awt.*;
import java.awt.geom.Line2D;
import java.util.Random;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class SquareGrid {

  public static void drawImage(Graphics graphics){
    drawBox(320,320,640/2, graphics);
  }

  public static void drawBox(int xCenter, int yCenter, int size, Graphics g) {
    if (size < 50) {
      return;
    }
    int xBoxPos = xCenter - size / 2;
    int yBoxPos = yCenter - size / 2;
    g.setColor(Color.DARK_GRAY);
    g.fillRect(xCenter - size/2, yCenter - size/2,size, size/20);
    g.fillRect(xCenter - size/2, yCenter - size/2,size/20, size);
    g.fillRect(xCenter - size/2, yCenter + size/2 - size/20,size, size/20);
    g.fillRect(xCenter + size/2 -size/20, yCenter - size/2,size/20, size);

    for (int i = -1; i < 2; i += 2) {
      for (int j = -1; j < 2; j += 2) {
        drawBox(xCenter + i * size/2, yCenter + j * size/2, size/2, g);
      }
    }
  }


  // Don't touch the code below
  static int WIDTH = 640;
  static int HEIGHT = 640;

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