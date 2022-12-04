package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Day3A {

  public static void main(String[] args) throws IOException {
    List<String> rucksacks = Files.readAllLines(
        Paths.get("/Users/rcepeda/src/rubencepeda/advent_of_code_2022/src/main/resources/day_3_a.txt"));

    int sum = 0;
    for (String rucksack : rucksacks) {
      String leftCompartment = rucksack.substring(0, rucksack.length() / 2);
      String rightCompartment = rucksack.substring(rucksack.length() / 2);
      //      System.out.format("rucksack: %s left: %s right: %s%n", rucksack, leftCompartment, rightCompartment);

      Set<Character> leftCompartmentSet = leftCompartment.chars().mapToObj(e -> (char) e).collect(Collectors.toSet());
      Set<Character> rightCompartmentSet = rightCompartment.chars().mapToObj(e -> (char) e).collect(Collectors.toSet());

      //      System.out.format("leftCompartmentSet: %s rightCompartmentSet: %s %n", leftCompartmentSet, rightCompartmentSet);

      leftCompartmentSet.retainAll(rightCompartmentSet);
//      System.out.format("intersection: %s %n", leftCompartmentSet);

      for (Character character : leftCompartmentSet) {
        int c = (int) character;
        if (Character.isUpperCase(character)) {
            c -= 38;
        } else {
            c -= 96;
        }
//        System.out.format("c: %d %n", c);
        sum += c;
      }
    }
    System.out.format("sum: %d" , sum);
  }

}
