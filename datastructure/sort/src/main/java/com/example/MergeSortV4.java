package com.example;

public class MergeSortV4 {
    public static void main(String[] args) {
        int[] arr = {5, 2, 7, 3, 1, 9, 4, 2, 6};

        // divide arr into smallest comparable chunks
        // compare, sort and merge two chunks
        int[][] listOfList = new int[arr.length][];

        for (int i = 0; i < arr.length; i++) {
            int[] a = {arr[i]};
            listOfList[i] = a;
        }

        merge(listOfList.length, listOfList, 0, 0);
        System.out.println("Done");
        System.out.println(listOfList[0]);

    }

    // compare, sort and merge two chunks
    private static void merge(int len, int[][] listOfList, int currentRunnerIndex, int currentMergeIndex) {
        System.out.println("\nlen :: "+len+"\ncurrentMergeIndex :: "+currentMergeIndex+"\ncurrentRunnerIndex :: "+currentRunnerIndex+"\nlist :: ["+listOfList+"]\t"+display(listOfList[currentRunnerIndex]));
        // take two chunks. compare and merge to new list
        int[] c = null;
        int[] a = listOfList[currentRunnerIndex];

        if (currentRunnerIndex == len-1) {
            c = a;
        } else {
            int[] b = listOfList[currentRunnerIndex + 1];
            c = compareAndSort(a, b);
        }
        listOfList[currentMergeIndex] = c;
        // but how many times ?
        if (listOfList[0].length < len) {
            merge(len, listOfList, currentRunnerIndex + 2, ++currentMergeIndex);
        }else{
            return;
        }
    }

    private static int[] compareAndSort(int[] a, int[] b) {
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
