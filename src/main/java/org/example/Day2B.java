package org.example;

import static java.lang.System.out;
import static org.example.Move.PAPER;
import static org.example.Move.ROCK;
import static org.example.Move.SCISSORS;
import static org.example.Result.DRAW;
import static org.example.Result.WIN;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day2B {

  private static final Map<Move, Move> MOVE_TO_WINNING_MOVE = new HashMap<>() {{
    put(SCISSORS, ROCK);
    put(PAPER, SCISSORS);
    put(ROCK, PAPER);
  }};

  private static final Map<Move, Move> MOVE_TO_LOSING_MOVE = new HashMap<>() {{
    put(SCISSORS, PAPER);
    put(PAPER, ROCK);
    put(ROCK, SCISSORS);
  }};

  public static void main(String[] args) throws IOException {
    List<String> lines = Files.readAllLines(
        Paths.get("/Users/rcepeda/src/rubencepeda/advent_of_code_2022/src/main/resources/day_2_a.txt"));

    int totalScore = 0;
    for (String line : lines) {
      String[] moves = line.split("\\s");

      Move opponent = Move.from(moves[0]);
      Result result = Result.from(moves[1]);

      Move me = myMove(opponent, result);
      int score = me.getPoints() + result.getPoints();

      out.format("opponent: %s(%d) me: %s(%d) --> %s(%d) score: %d%n",
          opponent, opponent.getPoints(),
          me, me.getPoints(),
          result, result.getPoints(),
          score);

      totalScore += score;
    }
    out.println("----------------------------");
    out.format("total score: %d%n", totalScore);
  }

  public static Move myMove(Move opponent, Result result) {
    if (result == DRAW) {
      return opponent;
    }

    if (result == WIN) {
      return MOVE_TO_WINNING_MOVE.get(opponent);
    }

    return MOVE_TO_LOSING_MOVE.get(opponent);
  }

}
