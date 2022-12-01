package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class Day1A {

  public static void main(String[] args) throws IOException {
    List<String> lines = Files.readAllLines(
        Paths.get("/Users/rcepeda/src/rubencepeda/advent_of_code_2022/src/main/resources/day_1_a.txt"));
    int max = -1;
    int count = 0;

    for (String line : lines) {
      if (StringUtils.isNumeric(line)) {
        count += Integer.parseInt(line);
      }

      if (StringUtils.isBlank(line)) {
        if (count > max) {
          max = count;
        }
        count = 0;
      }
    }
    System.out.println("final max: " + max);
  }
}
