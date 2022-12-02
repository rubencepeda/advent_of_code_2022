package org.example;

import static org.example.Move.PAPER;
import static org.example.Move.ROCK;
import static org.example.Move.SCISSORS;
import static org.example.Result.DRAW;
import static org.example.Result.LOSS;
import static org.example.Result.WIN;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Day2BTest {

  static Stream<Arguments> myMoveArguments() {
    return Stream.of(
        arguments(ROCK, DRAW, ROCK),
        arguments(ROCK, WIN, PAPER),
        arguments(ROCK, LOSS, SCISSORS),

        arguments(PAPER, DRAW, PAPER),
        arguments(PAPER, WIN, SCISSORS),
        arguments(PAPER, LOSS, ROCK),

        arguments(SCISSORS, DRAW, SCISSORS),
        arguments(SCISSORS, WIN, ROCK),
        arguments(SCISSORS, LOSS, PAPER)

    );
  }

  @ParameterizedTest(name = "{index} => opponent plays ''{0}'' -> result ''{1}'' if I play ''{2}''")
  @MethodSource("myMoveArguments")
  void myMove(Move opponent, Result result, Move myMove) {
    assertEquals(myMove, Day2B.myMove(opponent, result));
  }
}