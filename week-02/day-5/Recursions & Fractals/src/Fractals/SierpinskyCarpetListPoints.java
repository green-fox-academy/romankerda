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
    ArrayList<ArrayList<Integer>> listForPrint = getPoints(320, 320, 640 / 3, boxes);

    for (ArrayList<Integer> box : listForPrint) {
      System.out.printf("#%d  /  %d - %d - %d\n",listForPrint.indexOf(box), box.get(0), box.get(1), box.get(2));
      graphics.fillRect(box.get(0), box.get(1), box.get(2), box.get(2));
    }
  }

  public static ArrayList<ArrayList<Integer>> getPoints(int xCenter, int yCenter, int size, ArrayList<ArrayList<Integer>> boxes) {
    if (size < 2) {
      return  null;
    }
    ArrayList<Integer> oneBox = new ArrayList<>();

    int xBoxPos = xCenter - size / 2;
    int yBoxPos = yCenter - size / 2;
    oneBox.add(xBoxPos);
    oneBox.add(yBoxPos);
    oneBox.add(size);
    boxes.add(oneBox);


    getPoints(xCenter, yCenter - size, size/3, boxes);
    getPoints(xCenter, yCenter + size, size/3, boxes);
    getPoints(xCenter + size, yCenter, size/3, boxes);
    getPoints(xCenter - size, yCenter, size/3, boxes);
    getPoints(xCenter - size, yCenter + size, size/3, boxes);
    getPoints(xCenter - size, yCenter - size, size/3, boxes);
    getPoints(xCenter + size, yCenter - size, size/3, boxes);
    getPoints(xCenter + size, yCenter + size, size/3, boxes);

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