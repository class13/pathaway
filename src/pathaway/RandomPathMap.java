package pathaway;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class RandomPathMap {

  public final static int MIN_POINTS = 2;
  public final static int MAX_POINTS = 10;

  private final SecureRandom random;
  private List<Path> paths;
  private List<Point> points;

  private final int dimensionX;
  private final int dimensionY;

  public RandomPathMap(int dimensionX, int dimensionY) {
    this.dimensionX = dimensionX;
    this.dimensionY = dimensionY;
    this.random = new SecureRandom();
    generatePoints();
    generatePaths();
  }

  private void generatePaths() {

  }

  private void generatePoints() {
    generatePoints(random.nextInt(MAX_POINTS - MIN_POINTS) + MIN_POINTS);
  }

  private void generatePoints(int amount) {
    this.points = new ArrayList<Point>();
    for (int i = 0; i < amount; i++) {
      final int x = random.nextInt(dimensionX);
      final int y = random.nextInt(dimensionY);
      this.points.add(new Point(x, y));
    }

  }
}
