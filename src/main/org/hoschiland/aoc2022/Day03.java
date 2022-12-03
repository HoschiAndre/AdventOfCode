package org.hoschiland.aoc2022;

//--- Day 3:  ---
// https://adventofcode.com/2022/day/3

import org.hoschiland.common.AoCInputReader;

import java.util.ArrayList;
import java.util.List;


public class Day03 extends AoCInputReader {

    public static void main(String[] args) {
        System.out.println("=== part 1");
        new Day03().part1();
        System.out.println("=== part 2");
        new Day03().part2();
    }

    List<String> data = fileToStrLines("input03.txt");

    private void part1() {

        System.out.println(data);
        Integer prioSum = 0;
        for (String str : data) {
            String comp1 = getCompartment1(str);
            String comp2 = getCompartment2(str);
            Character sharedComp = getShareCompartment(comp1, comp2);
            System.out.println(sharedComp);
            Integer prio = getPrio(sharedComp);
            prioSum = prio + prioSum;
            System.out.println(prio);
        }
        System.out.println(prioSum);
    }

    private void part2() {

        Integer countGroup = 0;
        List<String> groupItems = new ArrayList<>();
        Integer sumPrio = 0;

        for(String str : data) {
            countGroup++;
            groupItems.add(str);
            if(countGroup==3) {
                Character comItem = getItemOfThree(groupItems);
                System.out.println(comItem);
                Integer prio = getPrio(comItem);
                sumPrio = sumPrio + prio;
                groupItems.clear();
                countGroup = 0;
            }
        }
        System.out.println(sumPrio);
    }

    private Character getItemOfThree(List<String> items) {

        return getShareItem(items.get(0), items.get(1), items.get(2));

    }

    private Integer getPrio(Character item) {

        return "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(item) + 1;


    }

    private Character getShareItem(String comp1, String comp2, String comp3) {

        for (int i = 0; i < comp1.length(); i++) {
            Character item1 = comp1.charAt(i);

            for (int j = 0; j < comp2.length(); j++) {
                Character item2 = comp2.charAt(j);

                for (int k = 0; k < comp3.length(); k++) {
                    Character item3 = comp3.charAt(k);
                    //System.out.println(item1 + ":" + itme2);

                    if ( (item1.equals(item2)) && (item2.equals(item3)) ) {
                        return item1;                }
                }
            }
        }
        return null;
    }
    private Character getShareCompartment(String comp1, String comp2) {

        for (int i = 0; i < comp1.length(); i++) {
            Character item1 = comp1.charAt(i);

            for (int j = 0; j < comp2.length(); j++) {
                Character itme2 = comp2.charAt(j);

                //System.out.println(item1 + ":" + itme2);

                if (item1.equals(itme2)) {
                    return item1;
                }
            }
        }
        return null;
    }

    private String getCompartment1(String items) {

        String compartment1 = items.substring(0, items.length()/2);

        System.out.println(compartment1);

        return compartment1;
    }

    private String getCompartment2(String items) {
        String compartment2 = items.substring(items.length()/2, items.length());

        System.out.println(compartment2);

        return compartment2;
    }
}
