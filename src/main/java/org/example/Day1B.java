package org.example;

import static java.util.Comparator.reverseOrder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.PriorityQueue;

import org.apache.commons.lang3.StringUtils;

public class Day1B {

  public static void main(String[] args) throws IOException {
    List<String> lines = Files.readAllLines(
        Paths.get("/Users/rcepeda/src/rubencepeda/advent_of_code_2022/src/main/resources/day_1_b.txt"));
    int count = 0;

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(reverseOrder());
    for (String line : lines) {
      if (StringUtils.isNumeric(line)) {
        count += Integer.parseInt(line);
      }

      if (StringUtils.isBlank(line)) {
        maxHeap.add(count);
        count = 0;
      }
    }

    int totalMax = 0;
    for (int i = 0; i < 3; i++) {
      totalMax += maxHeap.remove();
    }
    System.out.println("total max: " + totalMax);
  }

}
