package org.example;

import java.util.HashMap;
import java.util.Map;

public enum Result {
  WIN(6),
  LOSS(0),
  DRAW(3);

  private static final Map<String, Result> KEY_TO_RESULT = new HashMap<>() {{
    put("X", LOSS);
    put("Y", DRAW);
    put("Z", WIN);
  }};


  private final int points;

  Result(int points) {
    this.points = points;
  }


  public int getPoints() {
    return points;
  }

  public static Result from(String key) {
    return KEY_TO_RESULT.get(key);
  }
}
