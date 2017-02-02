package pathaway;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Path {
  public class Line {
    Point p1;
    Point p2;

    public Line(Point p1, Point p2) {
      super();
      this.p1 = p1;
      this.p2 = p2;
    }

    public Point getP1() {
      return p1;
    }

    public void setP1(Point p1) {
      this.p1 = p1;
    }

    public Point getP2() {
      return p2;
    }

    public void setP2(Point p2) {
      this.p2 = p2;
    }

    public Point getCenter() {
      return new Point(Math.round((p1.x + p2.x) / 2), Math.round((p1.y + p2.y) / 2));
    }

  }

  private final List<Point> points;

  public Path(List<Point> points) {
    super();
    this.points = points;
  }

  public Path(Point... points) {
    this(Arrays.asList(points));
  }

  public static List<Point> allPoints(List<Point> rawPoints) {
    final List<Point> allPoints = new ArrayList<Point>();
    for (int i = 0; i < rawPoints.size() - 1; i++) {
      final Point p1 = rawPoints.get(i);
      final Point p2 = rawPoints.get(i + 1);
      allPoints.addAll(allPoints(p1, p2));
    }
    return allPoints;
  }

  public static Collection<? extends Point> allPoints(Point p1, Point p2) {
    final long x2 = p2.x;
    long x = p1.x;
    final long y2 = p2.y;
    long y = p1.y;
    final long w = x2 - x;
    final long h = y2 - y;
    int dx1 = 0, dy1 = 0, dx2 = 0, dy2 = 0;
    if (w < 0) {
      dx1 = -1;
    } else if (w > 0) {
      dx1 = 1;
    }
    if (h < 0) {
      dy1 = -1;
    } else if (h > 0) {
      dy1 = 1;
    }
    if (w < 0) {
      dx2 = -1;
    } else if (w > 0) {
      dx2 = 1;
    }
    long longest = Math.abs(w);
    long shortest = Math.abs(h);
    if (!(longest > shortest)) {
      longest = Math.abs(h);
      shortest = Math.abs(w);
      if (h < 0) {
        dy2 = -1;
      } else if (h > 0) {
        dy2 = 1;
      }
      dx2 = 0;
    }
    long numerator = longest >> 1;
    final List<Point> allPoints = new ArrayList<Point>();
    for (int i = 0; i <= longest; i++) {
      allPoints.add(new Point(x, y));
      numerator += shortest;
      if (!(numerator < longest)) {
        numerator -= longest;
        x += dx1;
        y += dy1;
      } else {
        x += dx2;
        y += dy2;
      }
    }
    return allPoints;
  }

  public List<Point> getPoints() {
    return points;
  }

  public List<Line> getLines() {
    final List<Line> lines = new ArrayList<Line>();
    for (int i = 0; i < points.size() - 1; i++) {
      final Point p1 = points.get(i);
      final Point p2 = points.get(i + 1);
      lines.add(new Line(p1, p2));
    }
    return lines;
  }

}
