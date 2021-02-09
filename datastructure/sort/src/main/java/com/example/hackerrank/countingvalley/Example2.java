package com.example.hackerrank.countingvalley;

import java.util.*;

public class Example2 {
    // Complete the arrayManipulation function below.
    static class Tuple{
        int index;
        int l;
        int h;
        long sum;

        public Tuple(int index, int l, int h, long sum) {
            this.index = index;
            this.l = l;
            this.h = h;
            this.sum = sum;
        }

        @Override
        public String toString() {
            return "{" +
                    "" + index +
                    ",[" + l +
                    "," + h +
                    "]," + sum +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Tuple)) return false;
            Tuple tuple = (Tuple) o;
            return
                    l == tuple.l &&
                    h == tuple.h;
        }

        @Override
        public int hashCode() {
            return Objects.hash(l, h);
        }
    }

    static long arrayManipulation(int n, int[][] queries) {

        Tuple[] tuples = new Tuple[n];

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int h = queries[i][1];
            int sum = queries[i][2];
            tuples[l]= new Tuple(l, l, h, sum);
        }
        // Sort it by l
        List<Tuple> tuples2= new ArrayList<>(Arrays.asList(tuples));
        Set<Tuple> tuples1 = new HashSet<Tuple>(Arrays.asList(tuples));

        for (int i = 0; i < tuples2.size(); i++) {
            if( tuples2.get(i) != null ) {
                for (int j = i; j < tuples2.size(); j++) {
                    if (i != j && tuples2.get(i) != null && tuples2.get(j) != null) {
                        //tuples1.add(tuples2.get(i));
                        //tuples1.add(tuples2.get(j));
                        fracture(tuples2.get(i), tuples2.get(j), tuples1);
                        System.out.println("\t\t=>>"+tuples1);
                    }
                }
                if(!tuples2.containsAll(tuples1)) {
                    tuples1.removeAll(tuples2);
                    tuples2.addAll(tuples1);
                }
            }
        }
        System.out.println(tuples1);
        Tuple t = (Tuple) tuples1.toArray()[0];
        return t.sum;
    }

    static void fracture(Tuple t1, Tuple t2, Set<Tuple> tuples1){
        System.out.println(t1+"\t"+t2);
        if(t1.l > t2.l){
            Tuple temp = t1;
            t1 = t2;
            t2=temp;
        }
        // full inclusive
        if( t1.l < t2.l && t1.h > t2.h){
            // update t2'sum
            t2.sum += t1.sum;

        }
        else if( t1.h > t2.l ){
            int l = t2.l;
            int h = t1.h;
            Tuple tuple = new Tuple(0, l,h,t1.sum+t2.sum);
            tuples1.add(tuple);
        }
    }

    public static void main(String[] args) {
        int[][] quries =
               {{2, 6, 8},
                {3, 5, 7},
                {1, 8, 1},
                {5, 9, 15}};
        int n = 10;
        System.out.println(arrayManipulation(n, quries));
    }
}
