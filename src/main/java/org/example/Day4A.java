package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Day4A {

  public static void main(String[] args) throws IOException {
    List<String> lines = Files.readAllLines(
        Paths.get("/Users/rcepeda/src/rubencepeda/advent_of_code_2022/src/main/resources/day_4_a.txt"));

    int count = 0;
    for (String line : lines) {
      int[] firstElf = Arrays.stream(line.split(",")[0].split("-")).sequential().map(Integer::parseInt).collect(
          Collectors.toList()).stream().mapToInt(Integer::intValue).toArray();

      Set<Integer> firstElfIds = new HashSet<>();
      for (int i = firstElf[0]; i <= firstElf[1]; i++) {
        firstElfIds.add(i);
      }

      int[] secondElf = Arrays.stream(line.split(",")[1].split("-")).sequential().map(Integer::parseInt).collect(
          Collectors.toList()).stream().mapToInt(Integer::intValue).toArray();
      Set<Integer> secondElfIds = new HashSet<>();
      for (int i = secondElf[0]; i <= secondElf[1]; i++) {
        secondElfIds.add(i);
      }

//      System.out.format("firstElfIds: %s, secondElfIds: %s%n", firstElfIds, secondElfIds);

      //      //first elf encomposes second elf
      if (firstElfIds.containsAll(secondElfIds)) {
        System.out.format("firstElfIds: %s, secondElfIds: %s%n", firstElfIds, secondElfIds);

        count++;
      }else if (secondElfIds.containsAll(firstElfIds)) {
        System.out.format("firstElfIds: %s, secondElfIds: %s%n", firstElfIds, secondElfIds);

        count++;
      }
    }
    System.out.println("count: " + count);
  }

}
