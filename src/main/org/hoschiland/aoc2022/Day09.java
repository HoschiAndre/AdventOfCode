package org.hoschiland.aoc2022;

//--- Day 9:  ---
// https://adventofcode.com/2022/day/9

import org.hoschiland.common.AoCInputReader;

import java.util.List;


public class Day09 extends AoCInputReader {

    public static void main(String[] args) {
        System.out.println("=== part 1");
        new Day09().part1();
        System.out.println("=== part 2");
        new Day09().part2();
    }

    List<String> data = fileToStrLines("input09.txt");

    private void part1() {

        System.out.println(data);
    }

    private void part2() {

    }
}
