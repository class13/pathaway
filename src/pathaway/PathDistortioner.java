package pathaway;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import pathaway.Path.Line;

public class PathDistortioner {
  public final static int DEFAULT_RADIUS = 80;
  public final static int ANGLE_MARGIN = 360;
  // public final static double ANGLE_BURNDOWN = 0.8;

  private final static SecureRandom random = new SecureRandom();
  private static final double RADIUS_BREAKDOWN = 0.9;

  private int angle = -1;
  int angleCounter = 0;
  private double radiusCounter;

  public Path distort(Path path) {

    final List<Line> lines = path.getLines();
    final List<Point> points = new ArrayList<Point>();
    for (final Line line : lines) {
      if (points.isEmpty()) {
        points.add(line.getP1());
      }
      points.add(line.getCenter());
      points.add(line.getP2());
    }
    final List<Point> newPoints = new ArrayList<Point>();
    for (int i = 0; i < points.size(); i++) {
      Point point = points.get(i);
      if (!(i == 0 || i == points.size() - 1)) {
        point = point.move(nextRadius(), nextAngle());
      }
      newPoints.add(point);
    }
    return new Path(newPoints);
  }

  public Path distort(Path p, int loops) {
    Path path = p;
    for (int i = 0; i < loops; i++) {
      path = distort(path);
    }
    return path;
  }

  public int nextAngle() {
    int angle;

    final int randomAdd = random.nextInt(ANGLE_MARGIN) - random.nextInt(ANGLE_MARGIN);
    angle = this.angle + randomAdd;

    angleCounter++;
    this.angle = angle;
    return angle;
  }

  public int nextRadius() {
    int radius;

    radius = new Long(Math.round(DEFAULT_RADIUS * Math.pow(RADIUS_BREAKDOWN, radiusCounter))).intValue();

    radiusCounter++;
    return radius;
  }
}
