package com.example.tree;

public class Tree {
    Node head = new Node();
    Node createTree(){
        return head;

    }

    void addNode(){
        // where to add the new node ?
        // check whats the depth of current tree
        int depth = getDepth();

        int count = getBredth(head, 0);
        double space = 2 * Math.pow(2, depth) - 1;
        System.out.println("Depth :: "+depth);
        System.out.println("Count :: "+count);
        System.out.println("Space :: "+space);
        if( space < count){
            // There is need to increase depth;
            increaseDepth();
        }
            // Space is available.
            // find the space and add the element
        findAndAddNode(head);
    }

    private void increaseDepth() {
        Node runner=head;
        // Assumption: First leaf node is always at the left most end of tree
        while( runner.getLeft() != null ){
            runner = runner.left;
        }
        runner.setLeft(new Node());
    }

    int getDepth(){
        Node runner=head;
        int depth =0;
        // Assumption: First leaf node is always at the left most end of tree
        while( runner.getLeft() != null ){
            runner = runner.left;
            depth++;
        }
        return depth;
    }

    int getBredth(Node node, int count){
        if( node == null || node.left == null && node.right == null){
            return count;
        }
        else{
            count=count+1;
            getBredth(node.getLeft(), count);
            count=count+1;
            getBredth(node.getRight(), count);
        }
        return count;
    }

    Node findAndAddNode(Node node){
        if( node.left == null){
            System.out.println("Adding Left");
            node.setLeft(new Node());
            return node.getLeft();
        }
        if( node.right == null){
            System.out.println("Adding Right ");
            node.setRight(new Node());
            return node.getRight();
        }
        else{
            System.out.println("findAndAddNode "+node);
            findAndAddNode(node.getLeft());
            findAndAddNode(node.getRight());
            return node;
        }
    }

    void display(Node node){
        System.out.println(getDepth());
        System.out.println(getBredth(node,0));
        for(int i=0;i< getDepth(); i++){
            display(node, i, 0 );
        }
    }

    private void display(Node node, int level, int currentLevel) {
        if( level == currentLevel){
            System.out.println(node.getMyIndex());
            return;
        }else{
            currentLevel=currentLevel+1;
            display(node.getLeft(), level, currentLevel);
            display(node.getRight(), level, currentLevel);
        }
    }
}
