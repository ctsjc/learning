package com.example.tree;

public class Tree {
    Node head = new Node(0);


    Node createTree() {
        return head;

    }

    void addNode(int value) {
        // where to add the new node ?
        // check whats the depth of current tree
        int depth = getDepth();
        Integer count = 1;
        Payload p = new Payload();
        p.count = 1;
        count = totalNodeCount(head, p);
        double space = 2 * Math.pow(2, depth) - 1;
        System.out.println("Depth :: " + depth);
        System.out.println("Count :: " + p.count);
        System.out.println("Space :: " + space);
        if (space <= count) {
            // There is need to increase depth;
            increaseDepth(value);
        } else {
            // Space is available.
            // find the space and add the element

            findAndAddNode(head, value, p);
        }
        System.out.println(head);
    }

    private void increaseDepth(int value) {
        Node runner = head;
        // Assumption: First leaf node is always at the left most end of tree
        while (runner.getLeft() != null) {
            runner = runner.left;
        }
        System.out.println("Increasing depth " + value);
        runner.setLeft(new Node(value));
    }

    int getDepth() {
        Node runner = head;
        int depth = 0;
        // Assumption: First leaf node is always at the left most end of tree
        while (runner.getLeft() != null) {
            runner = runner.left;
            depth++;
        }
        return depth;
    }

    int totalNodeCount(Node node, Payload payload) {
        if (node.left != null) {
            payload.count = payload.count + 1;
            totalNodeCount(node.getLeft(), payload);
        }
        if (node.right != null) {
            payload.count = payload.count + 1;
            totalNodeCount(node.getRight(), payload);
        }
        return payload.count;
    }

    // Issue is, You Recursion dont know that the element is already added.
    Node findAndAddNode(Node node, int value, Payload payload) {
        System.out.println("Node :: "+node);
        if(!payload.isRequired )
            return node;
        if (node.left == null) {
            System.out.println("Adding Left " + node.getMyIndex());
            node.setLeft(new Node(value));
            payload.isRequired=false;
            return node.getLeft();
        }
        else if (node.right == null) {
            System.out.println("Adding Right " + node.getMyIndex());
            node.setRight(new Node(value));
            payload.isRequired=false;
            return node.getRight();
        }
        else {
            System.out.println("Searching child of  " + node);
            findAndAddNode(node.getLeft(), value , payload);
            findAndAddNode(node.getRight(), value, payload);
            return node;
        }
    }

    void display(Node node) {
        System.out.println(getDepth());
        // System.out.println(totalNodeCount(node, 0));
        for (int i = 0; i < getDepth(); i++) {
            display(node, i, 0);
        }
    }

    private void display(Node node, int level, int currentLevel) {
        if (level == currentLevel) {
            System.out.println(node.getMyIndex());
            return;
        } else {
            currentLevel = currentLevel + 1;
            display(node.getLeft(), level, currentLevel);
            display(node.getRight(), level, currentLevel);
        }
    }

}
