package com.example.hackerrank;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
public class ArrayMan {

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\repo\\learning\\datastructure\\sort\\output"));
        final Scanner scanner = new Scanner(new File("C:\\repo\\learning\\datastructure\\sort\\input"));

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

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
        long max=0;
        long[] d = new long[n+2];
        long[] a=new long[n+1];
/*         Arrays.fill(d, 0l);
        Arrays.fill(a, 0l);
       for(int i=0;i< queries.length;i++){
            d[  queries[i][0] ]+= queries[i][2];
            d[ queries[i][1]+1] -= queries[i][2];
        }*/

        Arrays.stream(queries).parallel().forEach( tup ->{
            d[  tup[0] ]+= tup[2];
            d[ tup[1]+1] -= tup[2];
        });

        for(int i=1; i<=n;i++){
            a[i]  = d[i]+a[i-1];
            if(max < a[i]){
                max = a[i];
            }
        }
        System.out.println(max);
        return max;
    }
}
