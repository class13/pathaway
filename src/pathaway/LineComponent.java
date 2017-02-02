package pathaway;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;

import pathaway.Path.Line;

public class LineComponent extends JComponent {
  List<Path> paths;

  public LineComponent() {
    super();
    this.paths = new ArrayList<Path>();
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(Color.BLACK);
    for (final Line line : path.getLines()) {
      g.drawLine(line.getP1().getX(), line.getP1().getY(), line.getP2().getX(), line.getP2().getY());

    }
    for (final Line line : path2.getLines()) {
      g.drawLine(line.getP1().getX(), line.getP1().getY(), line.getP2().getX(), line.getP2().getY());

    }
  }

  public void distortPath() {
    this.path = distort.distort(path, 6);
    this.path2 = distort2.distort(path2, 6);
    repaint();
  }
}
