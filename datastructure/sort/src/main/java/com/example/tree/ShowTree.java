package com.example.tree;

public class ShowTree {
    static int nodeNumber=0;
    Tree tree=new Tree();
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};

        ShowTree showTree=new ShowTree();
        showTree.tree.createTree();
        for (int i = 1; i <= 12; i++) {
            System.out.println("\n\nAdding "+(i));
            showTree.tree.addNode(i);
        }
        System.out.println("---- Tree ----");
       /// showTree.tree.display(showTree.tree.head);
        System.out.println(showTree.tree.head);
    }// main
}
