package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Day3B {

  public static void main(String[] args) throws IOException {
    List<String> rucksacks = Files.readAllLines(
        Paths.get("/Users/rcepeda/src/rubencepeda/advent_of_code_2022/src/main/resources/day_3_a.txt"));

    int sum = 0;
    for (int i = 0; i < rucksacks.size(); i += 3) {
      Set<Character> first = rucksacks.get(i).chars().mapToObj(e -> (char) e).collect(Collectors.toSet());
      Set<Character> second = rucksacks.get(i + 1).chars().mapToObj(e -> (char) e).collect(Collectors.toSet());
      Set<Character> third = rucksacks.get(i + 2).chars().mapToObj(e -> (char) e).collect(Collectors.toSet());

      System.out.format("first: %s second: %s third: %s%n", first, second, third);

      first.retainAll(second);
      first.retainAll(third);

      System.out.format("intersection: %s %n", first);

      for (Character character : first) {
        int c = (int) character;
        if (Character.isUpperCase(character)) {
          c -= 38;
        } else {
          c -= 96;
        }
        sum += c;
      }
    }
    System.out.format("sum: %d", sum);
  }
}
