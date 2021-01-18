package com.example.sort;

/**
 * in previous example we divide sort from left to right.
 * can we change it from right to left ?
 * that mean, first sort array residing at right side
 * then move to left */
public class MergeSortV6 {


    public static void main(String[] args) {
        int[] arr = {4, 0, 6, 1, 5, 2, 3};
        divide(arr, 0, arr.length-1);
    }

    private static void divide(int[] arr, int l, int h) {
        if( l == h) {
            System.out.println(arr[l]);
        }else{
            int m = (l+h)/2;
            divide(arr, m+1, h);
            divide(arr, l, m);
        }
    }
}
