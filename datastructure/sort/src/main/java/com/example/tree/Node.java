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

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "{ " +value+
                " , " + myIndex +
                (left !=null ?", left=" + left:"") +
                (right !=null ?", right=" + right : "")+
                '}';
    }
}
