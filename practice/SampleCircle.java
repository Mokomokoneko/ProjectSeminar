import javax.swing.JFrame;
import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.*;
import java.awt.Color;
import java.awt.BasicStroke;

public class SampleCircle extends JPanel{
  void run(String[] args) throws IOException{
    JFrame frame = new JFrame("sampleCircle");

    //frame.addNotify();
    //System.out.println(frame.getInsets());

    SampleCircle app = new SampleCircle();
    frame.getContentPane().add(app);

    frame.setSize(500, 522);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public void paintComponent(Graphics spiroGraph){
    Graphics2D largeGear = (Graphics2D)spiroGraph;
    largeGear.draw(new Ellipse2D.Double(10.0d, 10.0d, 480.0d, 480.0d));

    Graphics2D smallGear = (Graphics2D)spiroGraph;
    smallGear.draw(new Ellipse2D.Double(330.0d, 170.0d, 160.0d, 160.0d));
  }

  public static void main(String[] args) throws IOException{
    SampleCircle sampleCircle = new SampleCircle();
    sampleCircle.run(args);
  }
}
