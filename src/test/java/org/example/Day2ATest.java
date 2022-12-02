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

class Day2ATest {

  static Stream<Arguments> calculateOutcomeFromStringArguments() {
    return Stream.of(
        arguments("A", "Y", WIN),
        arguments("B", "X", LOSS),
        arguments("C", "Z", DRAW)
    );
  }

  @ParameterizedTest(name = "{index} => ''{0}'' -> ''{1}'' should be ''{2}''")
  @MethodSource("calculateOutcomeFromStringArguments")
  void calculateOutcomeFromString(String opponent, String me, Result expectedOutcome) {
    assertEquals(expectedOutcome, Day2A.play(Move.from(opponent), Move.from(me)));
  }

  static Stream<Arguments> calculateOutcomeFromMovesArguments() {
    return Stream.of(
        arguments(ROCK, ROCK, DRAW),
        arguments(ROCK, PAPER, WIN),
        arguments(ROCK, SCISSORS, LOSS),

        arguments(PAPER, PAPER, DRAW),
        arguments(PAPER, ROCK, LOSS),
        arguments(PAPER, SCISSORS, WIN),

        arguments(SCISSORS, SCISSORS, DRAW),
        arguments(SCISSORS, ROCK, WIN),
        arguments(SCISSORS, PAPER, LOSS)

    );
  }

  @ParameterizedTest(name = "{index} => opponent plays ''{0}'' -> I play ''{1}'' result ''{2}''")
  @MethodSource("calculateOutcomeFromMovesArguments")
  void calculateOutcomeFromMoves(Move opponent, Move me, Result expectedOutcome) {
    assertEquals(expectedOutcome, Day2A.play(opponent, me));
  }

}