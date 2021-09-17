package Fractals;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class KochLine {

  public static void drawImage(Graphics graphics){
   int[][] points = {{10, 10}, {630, 10}};
   kochLine(points, graphics, 0);
  }

  public static void kochLine(int[][] line, Graphics g, int counter) {
    if (counter == 3) {
      return;
    }
    int[][] points = new int[5][2];
    points = getPoints(line);
    g.setColor(Color.BLACK);
    g.drawLine(points[0][0], points[0][1], points[4][0], points[4][1]);
    g.setColor(new Color(238, 238, 238));
    g.drawLine(points[1][0], points[1][1], points[3][0], points[3][1]);
    g.setColor(Color.BLACK);
    g.drawLine(points[1][0], points[1][1], points[2][0], points[2][1]);
    g.drawLine(points[2][0], points[2][1], points[3][0], points[3][1]);
    counter++;
    int[][] segment1 = { points[0], points[1]};
    int[][] segment2 = { points[1], points[2]};
    int[][] segment3 = { points[2], points[3]};
    int[][] segment4 = { points[3], points[4]};
    kochLine(segment1, g, counter);
    kochLine(segment2, g, counter);
    kochLine(segment3, g, counter);
    kochLine(segment4, g, counter);
  }

  public static int[][] getPoints(int[][] base) {
    int[][] points = new int[5][2];
    int x1 = base[0][0];
    int y1 = base[0][1];
    int x2 = base[1][0];
    int y2 = base[1][1];
    points[0] = base [0];
    points[1][0] = x1 + (x2-x1)/3;
    points[1][1] = y1 + (y2-y1)/3;
    points[3][0] = x2 - (x2-x1)/3;
    points[3][1] = y2 - (y2-y1)/3;
    points[4] = base[1];
    points[2] = rotate60(points[0], points[4]);
    return points;
  }

  public static int[] rotate60(int[] pt1, int[] pt2) {
    int x1 = pt1[0];
    int y1 = pt1[1];
    int x2 = pt2[0];
    int y2 = pt2[1];

    int[] newPt = new int[2];
    double newPtX;
    double newPtY;
    newPtX = (x1+x2)/2 + 1.73205080757*(y1-y2)/6;
    newPtY = (y1+y2)/2 + 1.73205080757*(x2-x1)/6;
    newPt[0] = (int) newPtX;
    newPt[1] = (int) newPtY;
    return newPt;
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