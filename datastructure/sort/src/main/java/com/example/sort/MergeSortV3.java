package com.example.sort;

public class MergeSortV3 {
    /*
     * Merge Sort
     *
     * break to single chunk
     * then compare two stuff
     * then add the element depending
     * */
    public static void main(String[] args) {
        int[] arr = {5, 2, 7, 3, 1, 9, 4, 2, 6};
        System.out.println("Arr Len " + arr.length);
        // So there will be n arrays
        int b[][] = new int[arr.length][];
        for (int i = 0; i < arr.length; i++) {
            int[] a = {arr[i]};
            b[i] = a;
        }


        int len = 0;
        while (len < arr.length) {
            int val = b.length /2 + b.length % 2;
            int c[][] = new int[val][];
            int k = 0;

            for (int i = 0; i < b.length; i=i+2) {
                if (i == b.length - 1 || i == b.length) {
                    c[k] = b[i];
                    k++;
                } else {
                    c[k] = compareAndShift(b[i], b[i + 1]);
                    k++;
                }
            }
            b = c;
            len++;
        }


        System.out.println("\n====================\n");
        display(b);

    }

    private static void display(int[][] b) {
        if(b !=null) {
            for (int i = 0; i < b.length; i++) {
                for (int j = 0; j < b[i].length; j++) {
                    System.out.print("\t" + b[i][j]);
                }
                System.out.println("\n");
            }
        }
        else
            System.out.println("Empty");
    }

    private static int[] compareAndShift(int[] a, int[] b) {
        int i = 0;
        int j = 0;
        int k = 0;
        int[] c = new int[a.length + b.length];
        while (i < a.length && j < b.length) {
            if (a[i] > b[j]) {
                c[k] = b[j];
                k++;
                j++;
            } else {
                c[k] = a[i];
                k++;
                i++;
            }
        }
        // now copy all the remaining elements
        while (i < a.length) {
            c[k] = a[i];
            k++;
            i++;
        }
        while (j < b.length) {
            c[k] = b[j];
            k++;
            j++;
        }
        return c;
    }

    private static String display(int[] arr) {
        String value = "";
        if(arr !=null) {
            if (arr != null) {
                for (int i = 0; i < arr.length; i++) {
                    value += arr[i] + " ";
                }
            }
        }else{
            System.out.println("-empty-");
        }
        return value;
    }
}
