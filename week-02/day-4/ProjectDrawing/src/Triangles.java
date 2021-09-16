import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Triangles {
  public static void drawImage(Graphics graphics) {

    int offsetRow = 22;   //size of one element in y-axis
    int offsetCol = 25;   //size of one element in x-axis

    int xOrigin = 10;     //where the big triangle starts (left-bottom);
    int yOrigin = 310;    //where the big triangle starts (left-bottom);
    int size = 300 / offsetCol;
    int count = size;


    for (int row = 0; row < size; row++) {
      for (int col = 0; col < size - row; col++) {
        drawTriangle(xOrigin, yOrigin, offsetCol, offsetRow, graphics);
        xOrigin += offsetCol;
      }
      yOrigin -= offsetRow;
      xOrigin += -count * offsetCol + offsetCol/2 ;
      count--;
    }
  }

  public static void drawTriangle(int x, int y, int offsetX, int offsetY, Graphics g) {
    int[] xpoints = {x, x+offsetX, x+offsetX/2};
    int[] ypoints = {y, y, y-offsetY};
    g.drawPolygon(xpoints, ypoints, 3);
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