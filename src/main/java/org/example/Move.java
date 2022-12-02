package org.example;

import java.util.HashMap;
import java.util.Map;

public enum Move {
  ROCK(1),
  PAPER(2),
  SCISSORS(3);

  private final int points;

  private static final Map<String, Move> PLAYER_MOVE_TO_MOVE = new HashMap<>() {{
    put("A", ROCK);
    put("B", PAPER);
    put("C", SCISSORS);

    put("X", ROCK);
    put("Y", PAPER);
    put("Z", SCISSORS);
  }};

  Move(int points) {
    this.points = points;
  }

  public static Move from(String playerAMove) {
    return PLAYER_MOVE_TO_MOVE.get(playerAMove);
  }

  public int getPoints() {
    return points;
  }
}
