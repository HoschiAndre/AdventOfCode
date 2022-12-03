package org.hoschiland.aoc2022;

//--- Day 5:  ---
// https://adventofcode.com/2022/day/5

import org.hoschiland.common.AoCInputReader;

import java.util.List;


public class Day05 extends AoCInputReader {

    public static void main(String[] args) {
        System.out.println("=== part 1");
        new Day05().part1();
        System.out.println("=== part 2");
        new Day05().part2();
    }

    List<String> data = fileToStrLines("input05.txt");

    private void part1() {

        System.out.println(data);
    }

    private void part2() {

    }
}
