package pathaway;

public class Point {

  public Long x;
  public Long y;

  public Point(long new_x, long new_y) {
    super();
    this.x = new_x;
    this.y = new_y;
  }

  public Point move(int distance, int angle) {
    final double radangle = angle * Math.PI / 180.0;
    final long new_x = Math.round(x + Math.cos(radangle) * distance);
    final long new_y = Math.round(y + Math.sin(radangle) * distance);
    return new Point(new_x, new_y);
  }

  public int getX() {
    return x.intValue();
  }

  public int getY() {
    return y.intValue();
  }

  @Override
  public boolean equals(Object obj) {
    final Point p;
    if (obj instanceof Point) {
      p = (Point) obj;
    } else {
      return false;
    }
    return p.x.equals(this.x) && p.y.equals(y);
  }

}
