package org.example;

public enum Result {
  WIN(6),
  LOSS(0),
  DRAW(3);

  private final int points;

  Result(int points) {
    this.points = points;
  }

  public int getPoints() {
    return points;
  }
}
