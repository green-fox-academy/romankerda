import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class ConnectTheDots {
  public static void drawImage(Graphics graphics) {
    // Create a function that takes 2 parameters:
    // an array of {x, y} points and graphics
    // and connects them with green lines.
    // Connect these to get a box: {{10, 10}, {290,  10}, {290, 290}, {10, 290}}
    // Connect these: {{50, 100}, {70, 70}, {80, 90}, {90, 90}, {100, 70},
    // {120, 100}, {85, 130}, {50, 100}}

    int[][] points1 = {{10, 10}, {290,  10}, {290, 290}, {10, 290}};
    int[][] points2 = {{50, 100}, {70, 70}, {80, 90}, {90, 90}, {100, 70}, {120, 100}, {85, 130}, {50, 100}};

    connectPoints (points1, graphics);
    connectPoints (points2, graphics);
  }

  public static void connectPoints(int[][] points, Graphics g) {
    int[] xpoints = new int[points.length];
    int[] ypoints = new int[points.length];
    int npoints = points.length;
    for (int i = 0; i < points.length; i++) {
      xpoints[i] = points[i][0];
      ypoints[i] = points[i][1];
    }
    g.drawPolygon(xpoints, ypoints, npoints);
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