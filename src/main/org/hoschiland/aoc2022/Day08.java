package org.hoschiland.aoc2022;

//--- Day 8:  ---
// https://adventofcode.com/2022/day/8

import org.hoschiland.common.AoCInputReader;

import java.util.Arrays;
import java.util.List;


public class Day08 extends AoCInputReader {

    public static void main(String[] args) {
        System.out.println("=== part 1");
        new Day08().part1();
        System.out.println("=== part 2");
        new Day08().part2();
    }

    List<String> data = fileToStrLines("input08.txt");

    Integer[][] treeMap = new Integer[data.get(0).length()][data.size()];

    private void part1() {

        System.out.println(data);

        for (int i = 0; i < data.size(); i++) {
            String str = data.get(i);
            for (int j = 0; j < str.length(); j++) {
                treeMap[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }

        //printTreeMap();

        var count = findInteriorTree();
        System.out.println(count);
    }

    private Integer findInteriorTree() {

        var highCount = 0;

        for (int i = 0; i < treeMap.length - 1; i++) {
            for (int j = 0; j < treeMap.length - 1; j++) {

                if(i == 0 || j == 0) {
                    continue;
                }

                var count = isTreeTopVisible(i,j) * isTreeRightVisible(i,j) * isTreeButtonVisible(i,j) * isTreeLeftVisible(i,j);

                if (count > highCount) {
                    highCount = count;
                }
            }
        }

        return highCount;
    }

    private Integer countEdge() {
        var length = data.get(0).length();
        var hight = data.size();

        return length + length + hight + hight - 4;

    }

    private Integer isTreeTopVisible(Integer i, Integer j) {
        var tree = treeMap[i][j];
        var count = 0;

        for (int k = i - 1; k >= 0; k--) {
            var treeTop = treeMap[k][j];
            if (treeTop >= tree) {
                count++;
                return count;
            }
            count++;
        }
        return count;
    }

    private Integer isTreeRightVisible(Integer i, Integer j) {
        var tree = treeMap[i][j];
        var count = 0;

        for (int k = j + 1; k < treeMap.length; k++) {
            var treeRight = treeMap[i][k];
            if (treeRight >= tree ) {
                count++;
                return count;
            }
            count++;
        }
        return count;
    }

    private Integer isTreeButtonVisible(Integer i, Integer j) {
        var tree = treeMap[i][j];
        var count = 0;
        for (int k = i + 1; k < treeMap.length; k++) {
            var treeButton = treeMap[k][j];
            if (treeButton >= tree ) {
                count++;
                return count;
            }
            count++;
        }
        return count;
    }

    private Integer isTreeLeftVisible(Integer i, Integer j) {
        var tree = treeMap[i][j];
        var count = 0;

        for (int k = j - 1; k >= 0; k--) {
            var treeLeft = treeMap[i][k];
            if (treeLeft >= tree ) {
                count++;
                return count;
            }
            count++;
        }
        return count;
    }

    private void printTreeMap() {

        for (int i = 0; i < treeMap.length; i++) {
            for (int j = 0; j < treeMap.length; j++) {
                System.out.print(treeMap[i][j] + " ");
            }

            System.out.println();
        }
    }

    private void part2() {

    }
}
