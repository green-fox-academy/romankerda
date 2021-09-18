package Fractals;

import javax.swing.*;

import java.awt.*;
import java.awt.geom.Line2D;
import java.util.Random;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class SierpinskyCarpet {

  public static void drawImage(Graphics graphics){
    drawBox(0,0,WIDTH, graphics, 5);
  }

  public static void drawBox(int x, int y, int size, Graphics g, int level) {
    if (level == 0) {
      return;
    }
    g.setColor(Color.ORANGE);
    g.fillRect(x + size/3, y + size/3, size/3, size/3);

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
          drawBox(x + i * size/3, y + j * size/3, size / 3, g, level-1);
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