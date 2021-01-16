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

        merge(listOfList, listOfList.length, listOfList.length, 0, 0);
        System.out.println("Done");
        System.out.println(listOfList[0]);

    }

    private static void merge(int[][] listOfList, int totalLen, int currentLength,   int currentRunnerIndex, int currentMergeIndex) {
        if( currentRunnerIndex <= currentLength){
            // Horizontal movement
            int[] c = null;
            int[] a = listOfList[currentRunnerIndex];

            // if last element
            if (currentRunnerIndex == currentLength-1) {
                c = a;
                System.out.println("C :: " + display(c));

            } else {
                int[] b = listOfList[currentRunnerIndex + 1];
                c = compareAndSort(a, b);
            }
            listOfList[currentMergeIndex] = c;
        }

        currentMergeIndex = currentMergeIndex +1;
        currentRunnerIndex = currentRunnerIndex +2;
        // stop condition
        if( listOfList[0].length == totalLen){
            return;
        }
        // forward
        if( currentRunnerIndex >= currentLength){
            currentMergeIndex =0;
            currentRunnerIndex = 0;
            currentLength = totalLen / listOfList[0].length + totalLen % listOfList[0].length;
        }
        merge(listOfList, totalLen, currentLength, currentRunnerIndex, currentMergeIndex);
    }

    private static int[] compareAndSort(int[] a, int[] b) {
        System.out.println("Compare And Sort [" + display(a) + "], [" + display(b) + "]");
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
        System.out.println("C :: " + display(c));
        return c;
    }

    private static String display(int[] arr) {
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
