package org.hoschiland.aoc2022;

//--- Day 5:  ---
// https://adventofcode.com/2022/day/5

import org.hoschiland.common.AoCInputReader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Day05 extends AoCInputReader {

    public static void main(String[] args) {
        System.out.println("=== part 1");
        new Day05().part1();
        System.out.println("=== part 2");
        new Day05().part2();
    }

    List<String> data = fileToStrLines("input05.txt");

    // Reihe:Spalte
    Character[][] stacksOfCrates = new Character[100][10];

    private void part1() {

        System.out.println(data);
        initCrates();

        for (String str : data) {
            Scanner scanner = new Scanner(str).useDelimiter("\\D+");

            Integer move = scanner.nextInt();
            Integer from = scanner.nextInt();
            Integer to = scanner.nextInt();

            moveCrates(move, from, to);


        }
        printCrates();


    }

    private void part2() {

        initCrates();

        for (String str : data) {
            Scanner scanner = new Scanner(str).useDelimiter("\\D+");

            Integer move = scanner.nextInt();
            Integer from = scanner.nextInt();
            Integer to = scanner.nextInt();

            moveCratesPart2(move, from, to);

        }
        printCrates();
    }

    private void printCrates() {
        for (int i = 99; i >= 0; i--) {
            for (int j = 1; j < 10; j++) {
                if (stacksOfCrates[i][j] == null) {
                    stacksOfCrates[i][j] = ' ';
                }
                System.out.print(stacksOfCrates[i][j] + " ");

            }
            System.out.println();
        }
    }

    private void moveCrates(Integer move, Integer from, Integer to) {

        Character crateMove = ' ';

        for (int k = 0; k < move; k++) {

            for (int i = 99; i >= 0; i--) {
                crateMove = stacksOfCrates[i][from];
                if (!(crateMove == null || crateMove.equals(' '))) {
                    //System.out.println(crateMove);
                    stacksOfCrates[i][from] = null;
                    break;
                }
            }

            for (int j = 99; j >= 0; j--) {
                Character crate = stacksOfCrates[j][to];
                if (!(crate == null || crate.equals(' '))) {
                    //System.out.println(crate);
                    stacksOfCrates[j + 1][to] = crateMove;
                    break;
                }
            }
        }
    }

    private void moveCratesPart2(Integer move, Integer from, Integer to) {
        List<Character> crateMoveList = new ArrayList<>();
        Character crateMove = ' ';

        for (int k = 0; k < move; k++) {

            for (int i = 99; i >= 0; i--) {
                crateMove = stacksOfCrates[i][from];
                if (!(crateMove == null || crateMove.equals(' '))) {
                    //System.out.println(crateMove);
                    crateMoveList.add(stacksOfCrates[i][from]);
                    stacksOfCrates[i][from] = null;
                    break;
                }
            }
        }

        Collections.reverse(crateMoveList);

        Integer index = 0;
        for (int l = 0; l < 99; l++) {
            Character crate = stacksOfCrates[l][to];
            if (crate == null || crate.equals(' ')) {
                stacksOfCrates[l][to] = crateMoveList.get(index);
                index++;
            }
            if (index == crateMoveList.size()) {
                break;
            }
        }
     }

    private void initCrates() {

//               [F] [Q]         [Q]
//       [B]     [Q] [V] [D]     [S]
//       [S] [P] [T] [R] [M]     [D]
//       [J] [V] [W] [M] [F]     [J]     [J]
//       [Z] [G] [S] [W] [N] [D] [R]     [T]
//       [V] [M] [B] [G] [S] [C] [T] [V] [S]
//       [D] [S] [L] [J] [L] [G] [G] [F] [R]
//       [G] [Z] [C] [H] [C] [R] [H] [P] [D]
//        1   2   3   4   5   6   7   8   9

        stacksOfCrates[0][1] = '1';
        stacksOfCrates[0][2] = '2';
        stacksOfCrates[0][3] = '3';
        stacksOfCrates[0][4] = '4';
        stacksOfCrates[0][5] = '5';
        stacksOfCrates[0][6] = '6';
        stacksOfCrates[0][7] = '7';
        stacksOfCrates[0][8] = '8';
        stacksOfCrates[0][9] = '9';

        stacksOfCrates[1][1] = 'G';
        stacksOfCrates[1][2] = 'Z';
        stacksOfCrates[1][3] = 'C';
        stacksOfCrates[1][4] = 'H';
        stacksOfCrates[1][5] = 'C';
        stacksOfCrates[1][6] = 'R';
        stacksOfCrates[1][7] = 'H';
        stacksOfCrates[1][8] = 'P';
        stacksOfCrates[1][9] = 'D';

        stacksOfCrates[2][1] = 'D';
        stacksOfCrates[2][2] = 'S';
        stacksOfCrates[2][3] = 'L';
        stacksOfCrates[2][4] = 'J';
        stacksOfCrates[2][5] = 'L';
        stacksOfCrates[2][6] = 'G';
        stacksOfCrates[2][7] = 'G';
        stacksOfCrates[2][8] = 'F';
        stacksOfCrates[2][9] = 'R';

        stacksOfCrates[3][1] = 'V';
        stacksOfCrates[3][2] = 'M';
        stacksOfCrates[3][3] = 'B';
        stacksOfCrates[3][4] = 'G';
        stacksOfCrates[3][5] = 'S';
        stacksOfCrates[3][6] = 'C';
        stacksOfCrates[3][7] = 'T';
        stacksOfCrates[3][8] = 'V';
        stacksOfCrates[3][9] = 'S';

        stacksOfCrates[4][1] = 'Z';
        stacksOfCrates[4][2] = 'G';
        stacksOfCrates[4][3] = 'S';
        stacksOfCrates[4][4] = 'W';
        stacksOfCrates[4][5] = 'N';
        stacksOfCrates[4][6] = 'D';
        stacksOfCrates[4][7] = 'R';
        stacksOfCrates[4][8] = ' ';
        stacksOfCrates[4][9] = 'T';

        stacksOfCrates[5][1] = 'J';
        stacksOfCrates[5][2] = 'V';
        stacksOfCrates[5][3] = 'W';
        stacksOfCrates[5][4] = 'M';
        stacksOfCrates[5][5] = 'F';
        stacksOfCrates[5][6] = ' ';
        stacksOfCrates[5][7] = 'J';
        stacksOfCrates[5][8] = ' ';
        stacksOfCrates[5][9] = 'J';

        stacksOfCrates[6][1] = 'S';
        stacksOfCrates[6][2] = 'P';
        stacksOfCrates[6][3] = 'T';
        stacksOfCrates[6][4] = 'R';
        stacksOfCrates[6][5] = 'M';
        stacksOfCrates[6][6] = ' ';
        stacksOfCrates[6][7] = 'D';
        stacksOfCrates[6][8] = ' ';
        stacksOfCrates[6][9] = ' ';

        stacksOfCrates[7][1] = 'B';
        stacksOfCrates[7][2] = ' ';
        stacksOfCrates[7][3] = 'Q';
        stacksOfCrates[7][4] = 'V';
        stacksOfCrates[7][5] = 'D';
        stacksOfCrates[7][6] = ' ';
        stacksOfCrates[7][7] = 'S';
        stacksOfCrates[7][8] = ' ';
        stacksOfCrates[7][9] = ' ';

        stacksOfCrates[8][1] = ' ';
        stacksOfCrates[8][2] = ' ';
        stacksOfCrates[8][3] = 'F';
        stacksOfCrates[8][4] = 'Q';
        stacksOfCrates[8][5] = ' ';
        stacksOfCrates[8][6] = ' ';
        stacksOfCrates[8][7] = 'Q';
        stacksOfCrates[8][8] = ' ';
        stacksOfCrates[8][9] = ' ';

    }
}
