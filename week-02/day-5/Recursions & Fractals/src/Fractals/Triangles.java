package Fractals;

import javax.swing.*;

import java.awt.*;
import java.awt.geom.Line2D;
import java.util.Random;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Triangles {

  public static void drawImage(Graphics graphics){

    drawTriangle(10,10,630,10, graphics);
  }

  public static void drawTriangle(int x1, int y1, int x2, int y2, Graphics g) {
    if(x2 - x1 < 5) {
      return;
    }
    int height = (int) (Math.sin(Math.toRadians(60))*(x2 - x1));
    int[] xPoints = {x1, x2, x1 + (x2 - x1)/2};
    int[] yPoints = {y1, y2, y1 + height};
    g.drawPolygon(xPoints, yPoints, 3);
    int[] xPointsInnerTri = {x1 + (x2 - x1)/2, x2 - (x2 - x1)/4, x1 + (x2 - x1)/4 };
    int[] yPointsInnerTri = {y1, y1 + height/2, y1 + height/2};
    g.drawPolygon(xPointsInnerTri, yPointsInnerTri, 3);
    drawTriangle(x1, y1, x1 + (x2 - x1)/2, y2, g);
    drawTriangle(x1 + (x2 - x1)/2, y1, x2, y2, g);
    drawTriangle(x1 + (x2 - x1)/4, y1 + height/2, x2 - (x2 - x1)/4, y1 + height/2, g);
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