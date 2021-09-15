import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class CenteredSquare {

  public static void drawImage(Graphics g) {
    // Draw a green 10x10 square to the canvas' center
    g.setColor(Color.GREEN);
    int xpoints[] = {WIDTH/2-5, WIDTH/2+5, WIDTH/2+5, WIDTH/2-5};
    int ypoints[] = {HEIGHT/2-5, HEIGHT/2-5, HEIGHT/2+5,HEIGHT/2+5};
    int npoints = 4;
    g.fillPolygon(xpoints, ypoints, npoints);
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