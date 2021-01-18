package com.example.tree;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Node {
    Node left;
    Node right;
    int value;
    //int count;
    //int depth;
    static int index;
    int myIndex;
    public Node() {
        myIndex = index++;
    }

    @Override
    public String toString() {
        return "Node{" +
                "" + myIndex +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
