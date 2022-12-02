package org.hoschiland.aoc2022;

//--- Day 2:  ---
// https://adventofcode.com/2022/day/2

import org.hoschiland.common.AoCInputReader;

import java.util.List;


public class Day02 extends AoCInputReader {

    public static void main(String[] args) {
        System.out.println("=== part 1");
        new Day02().part1();
        System.out.println("=== part 2");
        new Day02().part2();
    }

    List<String> data = fileToStrLines("input02.txt");

    private void part1() {

        System.out.println(data);

        Integer sum = 0;

        for (String line : data) {

            System.out.println(line.substring(0, 1));
            System.out.println(line.substring(2, 3));

            Integer lineInt = RockPaperScissors(line.substring(0, 1), line.substring(2, 3));
            if (lineInt.equals(-1))
                throw new RuntimeException();

            sum = sum + lineInt;

            System.out.println(lineInt);

        }

        System.out.println(sum);
    }

    private void part2() {

    }

    private Integer RockPaperScissors(String elf, String you) {
        // A: X: 1 for Rock,
        // B: Y: 2 for Paper,
        // C: Z: 3 for Scissors
        // 0 if you lost,
        // 3 if the round was a draw, and
        // 6 if you won
        // X lose
        // Y draw
        // Z win

        // Rock : Scissors : lose
        if (elf.equals("A") && you.equals("X")) {
            return 3 + 0;
        }
        // Rock : Rock : draw
        if (elf.equals("A") && you.equals("Y")) {
            return 1 + 3;
        }
        // Rock : Paper : win
        if (elf.equals("A") && you.equals("Z")) {
            return 2 + 6;
        }
        // Paper : Rock : lose
        if (elf.equals("B") && you.equals("X")) {
            return 1 + 0;
        }
        // Paper : Paper : draw
        if (elf.equals("B") && you.equals("Y")) {
            return 2 + 3;
        }
        // Paper : Scissors : win
        if (elf.equals("B") && you.equals("Z")) {
            return 3 + 6;
        }
        // Scissors : Paper : lose
        if (elf.equals("C") && you.equals("X")) {
            return 2 + 0;
        }
        // Scissors : Scissors : draw
        if (elf.equals("C") && you.equals("Y")) {
            return 3 + 3;
        }
        // Scissors : Rock : win
        if (elf.equals("C") && you.equals("Z")) {
            return 1 + 6;
        }

        return -1;
    }
}
