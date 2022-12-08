package org.hoschiland.aoc2022;

//--- Day 7:  ---
// https://adventofcode.com/2022/day/7

import org.hoschiland.common.AoCInputReader;

import java.util.*;


public class Day07 extends AoCInputReader {

    public static void main(String[] args) {
        System.out.println("=== part 1");
        new Day07().part1();
        System.out.println("=== part 2");
        new Day07().part2();
    }

    List<String> data = fileToStrLines("input07.txt");
    Map<String, Integer> mapSize = new HashMap<>();

    private void part1() {

        System.out.println(data);

        Node root = new Node("/");
        Node currentNode = root;

        for (String str : data) {

            if (str.startsWith("dir")) {
                String element = str.substring(4);
                currentNode.addChild(element);
            } else if (str.equals("$ cd ..")) {
                currentNode = currentNode.getParent();
            } else if (str.startsWith("$ cd")) {
                String moveElement = str.substring(5);
                List<Node> childList = currentNode.getChildren();

                for (Node element : childList) {
                    if (element.getData().equals(moveElement)) {
                        currentNode = element;
                    }
                }

            } else if (str.equals("$ ls")) {


            } else if (Character.isDigit(str.charAt(0))) {
                //Integer size = Integer.parseInt(str.replaceAll("[\\D]", ""));
                currentNode.addChild(str);
            }

        }
        traverse(root);
        printNode(mapSize);

    }

    private void traverse(Node node) {
        Integer totalSize = 0;

        List<Node> root = node.getChildren();

        for (Node child : root) {

            //System.out.println(child.getData());

            if (child.isLeaf()) {
                Integer size = Integer.parseInt(child.getData().replaceAll("[\\D]", ""));
                //totalSize = totalSize + size;
                //System.out.println("Dir: " + child.getParent().getData() + " Total Size: " + totalSize);
                Integer rootCount = 0;
                Node childGoesUp = child;
                while (!childGoesUp.isRoot()) {
                    rootCount = rootCount + size;
                    childGoesUp = childGoesUp.getParent();
                }

                addSize(childGoesUp.getData(), rootCount);

            }

            traverse(child);
        }
    }

    private void addSize(String parent, Integer size) {

        Integer mapElement = mapSize.get(parent);

        if (mapElement == null || mapElement == 0) {
            mapSize.put(parent, size);
        } else {
            mapElement = mapElement + size;
            mapSize.replace(parent, mapElement);
        }


    }

    private void printNode(Map map) {
        System.out.println(map);
    }

    private void part2() {

    }

    public class Node {
        private List<Node> children = new ArrayList<Node>();
        private Node parent = null;
        private String data = null;

        public Node(String data) {
            this.data = data;
        }

        public Node(String data, Node parent) {
            this.data = data;
            this.parent = parent;
        }

        public List<Node> getChildren() {
            return children;
        }

        public void setParent(Node parent) {
            parent.addChild(this);
            this.parent = parent;
        }

        public Node getParent() {
            return this.parent;
        }

        public void addChild(String data) {
            Node child = new Node(data);
            child.parent = this;
            this.children.add(child);
        }

        public void addChild(Node child) {
            child.parent = this;
            this.children.add(child);
        }

        public String getData() {
            return this.data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public boolean isRoot() {
            return (this.parent == null);
        }

        public boolean isLeaf() {
            return this.children.size() == 0;
        }

        public void removeParent() {
            this.parent = null;
        }
    }
}
