package org.hoschiland.aoc2022;

//--- Day 6:  ---
// https://adventofcode.com/2022/day/6

import org.hoschiland.common.AoCInputReader;

import java.util.List;


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
    }

    private void part2() {

    }
}
