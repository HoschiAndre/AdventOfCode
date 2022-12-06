package org.hoschiland.aoc2022;

//--- Day 6:  ---
// https://adventofcode.com/2022/day/6

import org.hoschiland.common.AoCInputReader;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Day06 extends AoCInputReader {

    public static void main(String[] args) {
        System.out.println("=== part 1");
        new Day06().part1();
        System.out.println("=== part 2");
        new Day06().part2();
    }

    List<String> data = fileToStrLines("input06.txt");

    private void part1() {

        System.out.println(data);

        List<Character> dataChar = data.get(0).chars().mapToObj(c -> (char) c).toList();
        Set<Character> uniSet = new HashSet<>();
        Integer counter = 0;
        Integer overallCount = 0;

        for (Character c : dataChar) {

            for (int i = 0; i < 14; i++) {
                if(uniSet.add(dataChar.get(overallCount + i))) {
                    counter++;
                    if (counter==14) {
                        System.out.println(overallCount + 14);
                        System.out.println(uniSet);
                        break;
                    }
                } else {
                    counter=0;
                    uniSet.clear();
                    break;
                }
            }
            overallCount++;
        }
    }


    private void part2() {

    }
}
