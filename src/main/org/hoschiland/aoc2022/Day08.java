package org.hoschiland.aoc2022;

//--- Day 8:  ---
// https://adventofcode.com/2022/day/8

import org.hoschiland.common.AoCInputReader;

import java.util.List;


public class Day08 extends AoCInputReader {

    public static void main(String[] args) {
        System.out.println("=== part 1");
        new Day08().part1();
        System.out.println("=== part 2");
        new Day08().part2();
    }

    List<String> data = fileToStrLines("input08.txt");

    private void part1() {

        System.out.println(data);
    }

    private void part2() {

    }
}
