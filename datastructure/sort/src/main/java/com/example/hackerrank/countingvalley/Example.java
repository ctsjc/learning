package com.example.hackerrank.countingvalley;

public class Example {
    static int max_h = 6;
    static int max_l = 6;

    static void getHour(int[][] arr, int m, int n) {
        // m = 5
        if ((m + 2) < max_l && (n + 2) < max_h) {
            int[] r1 = new int[3];
            int[] r3 = new int[3];
            int c=0;
            for (int i = m; i < (m + 2); i++) {
                r1[c] = arr[i][n];
                r3[c] = arr[i][n + 2];
                c++;
            }
            long sum = sum(r1, arr[m + 1][n + 1], r3);
            System.out.printf("\n%s %s %s \n",m,n,sum);

            show(r1);
            show(r3);
        }

    }

    static  void show(int[] r){
        for(int i= 0 ; i < r.length; i++){
            System.out.print(r[i]+"  ");
        }
        System.out.println("\n");
    }

    static private long sum(int[] r1, int num, int[] r3) {

        long sum = num;
        for (int i = 0; i < 3; i++) {
            sum = r1[i] + r3[i];
        }
        return sum;
    }

    static int hourglassSum(int[][] arr) {
        for( int i=0; i< 6; i++){
            for( int j=0; j< 6; j++){
                getHour(arr, i , j);
            }
        }
        return 0;

    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 0, 2, 4, 4, 0},
                {0, 0, 0, 2, 0, 0},
                {0, 0, 1, 2, 4, 0}};
        System.out.println(hourglassSum(arr));
        //  1 -9 -9  1
    }
}
