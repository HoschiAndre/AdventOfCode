package org.hoschiland.aoc2022;

//--- Day 2:  ---
// https://adventofcode.com/2022/day/4

import org.hoschiland.common.AoCInputReader;

import java.util.List;


public class Day04 extends AoCInputReader {

    public static void main(String[] args) {
        System.out.println("=== part 1");
        new Day04().part1();
        System.out.println("=== part 2");
        new Day04().part2();
    }

    List<String> data = fileToStrLines("input04.txt");

    private void part1() {

        System.out.println(data);
    }

    private void part2() {

    }
}
