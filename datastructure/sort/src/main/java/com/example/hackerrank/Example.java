package com.example.hackerrank;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Example {


    private static final File text = new File("/mnt/9236B00836AFEB83/repo/learning/datastructure/sort/input");

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(text);

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/mnt/9236B00836AFEB83/repo/learning/datastructure/output"));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

    static class Node {
        Tuple tuple;
        Node node;

        public Node(Tuple tuple) {
            this.tuple = tuple;
        }
    }

    static class Tuple {
        int index;
        int l;
        int h;
        long sum;
        static int count;

        public Tuple(int l, int h, long sum) {
            this.l = l;
            this.h = h;
            this.sum = sum;
            index = ++count;
        }

        @Override
        public String toString() {
            return "{ " + index +
                    ":[" + l +
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
        //    System.out.println(roqTuples);

        Collections.sort(roqTuples, Comparator.comparingInt(t -> t.l));

        // Sort
        for (int i = 0; i < roqTuples.size(); i++) {
            Node node1 = new Node(roqTuples.get(i));
            temp.node = node1;
            temp = node1;
        }
        Node lastNode = temp;
 //       System.out.println("Last Node :: " + lastNode.tuple);
        temp = node.node;
  //      show(node);
        long startTime = System.nanoTime();
        while (temp != null) {
            Node jIndex = temp.node;
       //     System.out.println("\n\n :: " + temp.tuple);
            while (jIndex != null) {
                if(temp.tuple != null && jIndex.tuple != null ) {
                 //   System.out.println("\n\nBefore :: " + temp.tuple + "  <>  " + jIndex.tuple);
                    long startTime2 = System.nanoTime();
                    Node newList = fracture(temp, jIndex);
                    long elapsedTime2 = System.nanoTime() - startTime2;

                    System.out.println("fracture: "
                            + elapsedTime2/1000000);

                    if (newList != null) {
                        lastNode.node = newList;
                        lastNode = newList;
         //               show(node);
                    }
                  //  System.out.println("After :: " + temp.tuple + "  <>  " + jIndex.tuple + "   <>   " + (newList != null ? newList.tuple : ""));
                    // show(node);
                }
                jIndex = jIndex.node;
            }
            // System.out.println(":: " + temp.tuple );

            temp = temp.node;
        }
        long elapsedTime = System.nanoTime() - startTime;

        System.out.println("fracture: "
                + elapsedTime/1000000);
        //     System.out.println("Finally");
        temp = node;
        long sum = 0;
        long startTime3 = System.nanoTime();
        while (temp != null) {
            if (temp.tuple != null && temp.tuple.sum > sum) {
                sum = temp.tuple.sum;
            }
            //System.out.println(temp.tuple);
            temp = temp.node;
        }
        long elapsedTime3 = System.nanoTime() - startTime3;

        System.out.println("fracture: "
                + elapsedTime3/1000000);
      //  show(node);
        return sum;
    }

    private static void show(Node node) {
        Node temp = node;
        List<Tuple> dis = new ArrayList<>();
        while (temp != null) {
            if (temp.tuple != null)
                dis.add(temp.tuple);
            temp = temp.node;
        }
        Collections.sort(dis, Comparator.comparingInt(t -> t.l));
      //  System.out.println(dis);
    }

    private static Node fracture(Node n1, Node n2) {
        Tuple t1 = n1.tuple;
        Tuple t2 = n2.tuple;

        if (t1.l > t2.l) {
            Node temp = n1;
            n1 = n2;
            n2 = temp;
        }
        t1 = n1.tuple;
        t2 = n2.tuple;

        Tuple t3 = null;
        int t1l = t1.l;
        int t1h = t1.h;
        int t2l = t2.l;
        int t2h = t2.h;

        // first check is there any thing common
        if (t1l < t2l && t1h < t2l) {
            return null;
        }

        if (t1l == t2l) {
            //which ever is smaller, that will be t1, and rest will be t2
            if (t1h == t2h) {
//                System.out.println("    1       " );
                t1.sum += t2.sum;
                t2 = null;
            } else if (t1h > t2h) {
  //              System.out.println("    2       " );
                t2.sum += t1.sum;
                t1.l = t2h + 1;

            } else {
  //              System.out.println("    3       " );
                t1.sum += t2.sum;
                t2.l = t1h + 1;
            }
        } else if (t2l > t1l) {
            // t1l < t2l
            if (t1h == t2h) {
     //           System.out.println("    4       " );
                t1.h = t2.l - 1;
                t2.sum += t1.sum;

            } else if (t1h > t2h) {
   //             System.out.println("    5       " );
                t3 = new Tuple(t2h + 1, t1h, t1.sum);
                t2.sum += t1.sum;

                t1.h = t2.l - 1;

            } else {
      //          System.out.println("    6       " );
                t3 = new Tuple(t1h + 1, t2h, t2.sum);

                t2.sum += t1.sum;
                t2.h = t1h;
                t1.h = t2l - 1;
            }
        }

        n1.tuple = t1;
        n2.tuple = t2;
        Node node = null;


        if (t3 != null) {
            /*System.out.println(">>>t1 " + t1);
            System.out.println(">>>t2 " + t2);
            System.out.println(">>>t3 " + t3);*/
            node = new Node(t3);
        }
        return node;
    }

}
