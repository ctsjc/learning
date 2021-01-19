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
    int level;
    static int index;
    int myIndex;
    public Node() {
        myIndex = index++;
    }

    public Node(int value, int level) {
        this.value = value;
        this.level= level;
    }

    @Override
    public String toString() {
        return "{ " +value+
                " , level :: " + level +
                (left !=null ?", left=" + left:"") +
                (right !=null ?", right=" + right : "")+
                '}';
    }
}
