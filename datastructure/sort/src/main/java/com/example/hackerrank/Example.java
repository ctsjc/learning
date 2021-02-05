package com.example.hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Example {
    public static void main(String[] args) {
        int[][] arr =
                {{1, 5, 3},
                        {6, 9, 1}, {4, 8, 7},};
        arrayManipulation(10, arr);
    }
    static class Node{
        Tuple tuple;
        Node node;
        public Node(Tuple tuple) {
            this.tuple = tuple;
        }
    }
    static class Tuple {
        int l;
        int h;
        long sum;

        public Tuple(int l, int h, long sum) {
            this.l = l;
            this.h = h;
            this.sum = sum;
        }

        @Override
        public String toString() {
            return "{" +
                    "[" + l +
                    "," + h +
                    ",] sum=" + sum +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Tuple)) return false;

            Tuple tuple = (Tuple) o;

            if (l != tuple.l) return false;
            return h == tuple.h;
        }

        @Override
        public int hashCode() {
            int result = l;
            result = 31 * result + h;
            return result;
        }
    }

    static long arrayManipulation(int n, int[][] queries) {
        // Convert queries to Tuple
        Node node = new Node(null);
        Node temp = node;
        LinkedList<Tuple> roqTuples = new LinkedList<>();
        for (int i = 0; i < queries.length; i++) {
            roqTuples.add(new Tuple(queries[i][0], queries[i][1], queries[i][2]));
        }
        System.out.println(roqTuples);

        Collections.sort(roqTuples, Comparator.comparingInt(t -> t.l));

        // Sort
        for (int i = 0; i < roqTuples.size(); i++) {
            Node node1= new Node(roqTuples.get(i));
            temp.node = node1;
            temp = node1;
        }
        Node lastNode= temp;
        temp = node.node;
        while( temp != null){

            Node jIndex = temp.node;
            while( jIndex  != null){
                System.out.println(temp.tuple+"  <>  " +jIndex.tuple);
                Node newList = fracture(temp.tuple, jIndex.tuple);
                jIndex = jIndex.node;


               /* Node node2 = new Node(new Tuple(123,123,123l));
                node2.node=null;
                lastNode.node = node2;
                lastNode=node2;*/
            }
            temp = temp.node;
        }
        System.out.println("Finally");
        temp = node;
        while( temp != null ){
            System.out.println(temp.tuple);
            temp = temp.node;
        }
        return 0;
    }

    private static Node fracture(Tuple t1, Tuple t2) {
        if( t1.h > t2.l){

        }
        if( t1.h > t2.l ){
            //t1
            t1.h = t2.l-1;

            //t2
            t2.l= t1.h+1;
            //t3
            Tuple t3=new Tuple(t2.l, t1.h, t1.sum+t2.sum);
        }
        return null;
    }


    /*static long arrayManipulation(int n, int[][] queries) {
        // Convert queries to Tuple
        LinkedList<Tuple> roqTuples = new LinkedList<>();

        for (int i = 0; i < queries.length; i++) {
            roqTuples.add(new Tuple(queries[i][0], queries[i][1], queries[i][2]));
        }
        System.out.println(roqTuples);
        // Sort
        Collections.sort(roqTuples, Comparator.comparingInt(t -> t.l));
        System.out.println(roqTuples);
        // Fracture
        ListIterator<Tuple> it = roqTuples.listIterator();
        int cnt = 0;
        while (it.hasNext()) {
            cnt++;
            Tuple t1 = it.next();
            ListIterator<Tuple> it2 = roqTuples.listIterator(roqTuples.indexOf(t1) + 1);
            System.out.println(">>>> " + t1);
            while (it2.hasNext()) {
                Tuple t2 = it2.next();
                System.out.println(t2);

            }

            if (cnt == 2) {
                it2.add(new Tuple(123,123,123l));
                System.out.println("::::: "+roqTuples);
            }

        }

        return 0;
    }*/
}
