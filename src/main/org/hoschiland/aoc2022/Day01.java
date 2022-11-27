package org.hoschiland.aoc2022;

//--- Day 1:  ---
// https://adventofcode.com/2022/day/1

import org.hoschiland.common.AoCInputReader;

import java.util.List;

public class Day01 extends AoCInputReader {

    public static void main(String[] args) {
        System.out.println("=== part 1");
        new Day01().part1();
        System.out.println("=== part 2");
        new Day01().part2();
    }

    List<Integer> dataInt = fileToIntLines("input01.txt");

    private void part1() {
        System.out.println(dataInt);
    }

    private void part2() {
    }

}
