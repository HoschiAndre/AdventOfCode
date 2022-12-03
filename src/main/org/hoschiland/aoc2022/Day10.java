package org.hoschiland.aoc2022;

//--- Day 10:  ---
// https://adventofcode.com/2022/day/5

import org.hoschiland.common.AoCInputReader;

import java.util.List;


public class Day10 extends AoCInputReader {

    public static void main(String[] args) {
        System.out.println("=== part 1");
        new Day10().part1();
        System.out.println("=== part 2");
        new Day10().part2();
    }

    List<String> data = fileToStrLines("input10.txt");

    private void part1() {

        System.out.println(data);
    }

    private void part2() {

    }
}
