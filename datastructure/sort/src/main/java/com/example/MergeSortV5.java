package com.example;

public class MergeSortV5 {
    public static void main(String[] args) {
        int[] arr = {4, 0, 6, 1, 5, 2, 3};
        divide(arr, 0, arr.length - 1);
    }

    private static void divide(int[] arr, int l, int h) {


        if (l == h) {
            return;
        } else {
            // divide array into two chunks.
            int middle = (l + h) / 2;

            divide(arr, l, middle);
            divide(arr, middle + 1, h);
            merge(arr, l , middle, h);

        }
        System.out.println("Sorted List \n"+ divide(arr));
    }

    private static void merge(int[] arr, int l, int middle, int h) {
        int i=l;
        int j= middle+1;
        int[] helper = new int[h-l+1];
        int k=0;
        while( i <= middle && j <= h){
            if( arr[i] < arr[j]){
                helper[k] = arr[i];
                k++;
                i++;
            }else{
                helper[k] = arr[j];
                k++;
                j++;
            }
        }
        while( i<= middle){
            helper[k] = arr[i];
            k++;
            i++;
        }

        while( j<= h){
            helper[k] = arr[j];
            k++;
            j++;
        }

        k=0;
        for( int z= l; z<= h; z++){
            arr[z]=helper[k];
            k++;
        }
        System.out.println(">"+ divide(helper));
    }

    private static String divide(int[] arr) {
        String value = "";
        if (arr != null) {
            if (arr != null) {
                for (int i = 0; i < arr.length; i++) {
                    value += arr[i] + " ";
                }
            }
        } else {
            System.out.println("-empty-");
        }
        return value;
    }
}
