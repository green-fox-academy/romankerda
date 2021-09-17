package Fractals;

import javax.swing.*;

import java.awt.*;
import java.awt.geom.Line2D;
import java.util.Random;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Circles {

  public static void drawImage(Graphics graphics){
    drawCircle(320,320,640, graphics);
  }

  public static void drawCircle(int xCenter, int yCenter, int dia, Graphics g){
    if (dia < 30) {
      return;
    }
    int xOvalPos = xCenter - dia/2;
    int yOvalPos = yCenter - dia/2;

    g.drawOval (xOvalPos, yOvalPos, dia, dia);

    double xOffset = Math.cos(Math.toRadians(30)) * dia/4;
    double yOffset = Math.sin(Math.toRadians(30)) * dia/4;

    drawCircle(xCenter,yCenter - dia/4, dia/2, g);
    drawCircle(xCenter - (int)xOffset, yCenter + (int)yOffset, dia/2, g);
    drawCircle(xCenter + (int)xOffset, yCenter + (int)yOffset, dia/2, g);
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