package org.hoschiland.aoc2022;

//--- Day 7:  ---
// https://adventofcode.com/2022/day/7

import org.hoschiland.common.AoCInputReader;

import java.util.List;


public class Day07 extends AoCInputReader {

    public static void main(String[] args) {
        System.out.println("=== part 1");
        new Day07().part1();
        System.out.println("=== part 2");
        new Day07().part2();
    }

    List<String> data = fileToStrLines("input07.txt");

    private void part1() {

        System.out.println(data);
    }

    private void part2() {

    }
}
