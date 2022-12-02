package org.example;

import static java.lang.System.out;
import static org.example.Move.PAPER;
import static org.example.Move.ROCK;
import static org.example.Move.SCISSORS;
import static org.example.Result.DRAW;
import static org.example.Result.LOSS;
import static org.example.Result.WIN;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Day2A {

  public static void main(String[] args) throws IOException {
    List<String> lines = Files.readAllLines(
        Paths.get("/Users/rcepeda/src/rubencepeda/advent_of_code_2022/src/main/resources/day_2_a.txt"));

    int totalScore = 0;
    for (String line : lines) {
      String[] moves = line.split("\\s");

      Move opponent = Move.from(moves[0]);
      Move me = Move.from(moves[1]);
      Result result = play(opponent, me);
      int score = me.getPoints() + result.getPoints();

      out.format("opponent: %s(%d) me: %s(%d) --> %s(%d) total: %d%n", opponent, opponent.getPoints(), me,
          me.getPoints(), result, result.getPoints(), score);

      totalScore += score;
    }
    out.println("----------------------------");
    out.format("total score: %d%n", totalScore);

  }

  public static Result play(Move opponent, Move me) {
    if (opponent == me) {
      return DRAW;
    }

    if ((me == ROCK && opponent == SCISSORS) || (me == SCISSORS && opponent == PAPER) || (me == PAPER
        && opponent == ROCK)) {
      return WIN;
    }

    return LOSS;
  }
}
