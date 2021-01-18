package com.example.tree;

public class ShowTree {
    static int nodeNumber=0;
    Tree tree=new Tree();
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};

        ShowTree showTree=new ShowTree();
        showTree.tree.createTree();
        for (int i = 0; i < 3; i++) {
            showTree.tree.addNode();
        }
        System.out.println("---- Tree ----");
        showTree.tree.display(showTree.tree.head);
        System.out.println(showTree.tree.head);
    }// main
}
