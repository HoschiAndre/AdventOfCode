package org.hoschiland.aoc2022;

//--- Day 4:  ---
// https://adventofcode.com/2022/day/4

import org.hoschiland.common.AoCInputReader;

import java.util.List;


public class Day04 extends AoCInputReader {

    public static void main(String[] args) {
        System.out.println("=== part 1");
        //new Day04().part1();
        System.out.println("=== part 2");
        new Day04().part2();
    }

    List<String> data = fileToStrLines("input04.txt");

    private void part1() {

        System.out.println(data);

        Integer count = 0;

        for (String str : data) {
            Boolean containFirst = isFirstSectionContained(
                    str.substring(0, str.indexOf(',')),
                    str.substring(str.indexOf(',') + 1)
            );
            if (containFirst) {
                count++;
            }
        }
        System.out.println(count);
    }

    private void part2() {
        Integer count = 0;

        for (String str : data) {
            Boolean containFirst = isOverlapping(
                    str.substring(0, str.indexOf(',')),
                    str.substring(str.indexOf(',') + 1)
            );
            if (containFirst) {
                count++;
            }
        }
        System.out.println(count);
    }

    private Boolean isFirstSectionContained(String first, String second) {

        System.out.println(first + ":" + second);

        Integer index1 = first.indexOf('-');
        Integer first_begin = Integer.parseInt(first.substring(0, index1));
        Integer first_end = Integer.parseInt(first.substring(index1 + 1, first.length()));
        System.out.println(first_begin + ":" + first_end);
        Integer index2 = second.indexOf('-');
        Integer second_begin = Integer.parseInt(second.substring(0, index2));
        Integer second_end = Integer.parseInt(second.substring(index2 + 1, second.length()));
        System.out.println(second_begin + ":" + second_end);

        if(first_begin <= second_begin && first_end >= second_end ) {
            return true;
        }

        if(second_begin <= first_begin && second_end >= first_end) {
            return true;
        }

        return false;
    }

    private Boolean isOverlapping(String first, String second) {

        System.out.println(first + ":" + second);

        Integer index1 = first.indexOf('-');
        Integer first_begin = Integer.parseInt(first.substring(0, index1));
        Integer first_end = Integer.parseInt(first.substring(index1 + 1, first.length()));
        System.out.println(first_begin + ":" + first_end);
        Integer index2 = second.indexOf('-');
        Integer second_begin = Integer.parseInt(second.substring(0, index2));
        Integer second_end = Integer.parseInt(second.substring(index2 + 1, second.length()));
        System.out.println(second_begin + ":" + second_end);

        if(first_begin >= second_begin && first_begin <= second_end) {
            return true;
        }

        if(first_end >= second_begin && first_end <= second_end) {
            return true;
        }

        if(second_begin >= first_begin && second_begin <= first_end) {
            return true;
        }

        if(second_end >= first_begin && second_end <= first_end) {
            return true;
        }

        return false;
    }
}
