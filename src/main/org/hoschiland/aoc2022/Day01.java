package org.hoschiland.aoc2022;

//--- Day 1:  ---
// https://adventofcode.com/2022/day/1

import org.hoschiland.common.AoCInputReader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day01 extends AoCInputReader {

    public static void main(String[] args) {
        System.out.println("=== part 1");
        new Day01().part1();
        System.out.println("=== part 2");
        new Day01().part2();
    }

    List<String> data = fileToStrLines("input01.txt");

    private void part1() {

       List<Integer> calList = new ArrayList<>();
        Integer calElf = 0;
        for (String line : data) {

            if(!line.isEmpty())
                calElf = calElf + Integer.parseInt(line);

            if(line.isEmpty()) {
                calList.add(calElf);
                calElf = 0;
            }
        }

        System.out.println(Collections.max(calList));
    }

    private void part2() {

        List<Integer> calList = new ArrayList<>();
        Integer calElf = 0;
        for (String line : data) {

            if(!line.isEmpty())
                calElf = calElf + Integer.parseInt(line);

            if(line.isEmpty()) {
                calList.add(calElf);
                calElf = 0;
            }
        }

        Collections.sort(calList);
        Collections.reverse(calList);

        System.out.println(calList.get(0)+ calList.get(1)+ calList.get(2));
    }
}
