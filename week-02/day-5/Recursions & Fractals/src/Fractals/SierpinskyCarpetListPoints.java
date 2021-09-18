package Fractals;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import javax.swing.Timer;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class SierpinskyCarpetListPoints {

  public static void drawImage(Graphics graphics) {


    ArrayList<ArrayList<Integer>> boxes = new ArrayList<>();
    ArrayList<ArrayList<Integer>> listForPrint = getPoints(0,0,WIDTH, graphics, 5, boxes);

    for (ArrayList<Integer> box : listForPrint) {
      System.out.printf("#%d  /  %d - %d - %d\n",listForPrint.indexOf(box), box.get(0), box.get(1), box.get(2));
      graphics.fillRect(box.get(0), box.get(1), box.get(2), box.get(2));
    }
  }

  public static ArrayList<ArrayList<Integer>> getPoints(int x, int y, int size, Graphics g, int level, ArrayList<ArrayList<Integer>> boxes ) {
    if (level == 0) {
      return boxes;
    }
    g.setColor(Color.ORANGE);
    g.fillRect(x + size/3, y + size/3, size/3, size/3);

    ArrayList<Integer> oneBox = new ArrayList<>();
    oneBox.add(x + size/3);
    oneBox.add(y + size/3);
    oneBox.add(size/3);
    boxes.add(oneBox);
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        getPoints(x + i * size/3, y + j * size/3, size / 3, g, level-1, boxes);
      }
    }
    return boxes;
  }


  // Don't touch the code below
  static int WIDTH = 640;
  static int HEIGHT = 640;

  public static void main(String[] args) {
    JFrame jFrame = new JFrame("Drawing");
    jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    SierpinskyCarpetListPoints.ImagePanel panel = new SierpinskyCarpetListPoints.ImagePanel();
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