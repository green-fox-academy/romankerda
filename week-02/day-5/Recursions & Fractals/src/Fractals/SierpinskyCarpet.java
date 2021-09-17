package Fractals;

import javax.swing.*;

import java.awt.*;
import java.awt.geom.Line2D;
import java.util.Random;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class SierpinskyCarpet {

  public static void drawImage(Graphics graphics){
    drawBox(320,320,640/3, graphics);
  }

  public static void drawBox(int xCenter, int yCenter, int size, Graphics g) {
    if (size < 1) {
      return;
    }
    int xBoxPos = xCenter - size / 2;
    int yBoxPos = yCenter - size / 2;
    g.setColor(Color.ORANGE);
    g.fillRect(xBoxPos, yBoxPos, size, size);

    drawBox(xCenter, yCenter - size, size/3, g);
    drawBox(xCenter, yCenter + size, size/3, g);
    drawBox(xCenter + size, yCenter, size/3, g);
    drawBox(xCenter - size, yCenter, size/3, g);
    drawBox(xCenter - size, yCenter + size, size/3, g);
    drawBox(xCenter - size, yCenter - size, size/3, g);
    drawBox(xCenter + size, yCenter - size, size/3, g);
    drawBox(xCenter + size, yCenter + size, size/3, g);
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