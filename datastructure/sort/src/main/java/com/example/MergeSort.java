package com.example;

public class MergeSort {
    /*
    * Merge Sort
    *
    * break to single chunk
    * then compare two stuff
    * then add the element depending
    * */
    public static void main(String[] args) {
        int[] arr = { 2, 7, 3, 1, 9};
        // So there will be n arrays
        int b[][]=new int[arr.length][];
        for(int i=0;i< arr.length;i++){
            int[] a = {arr[i]};
            b[i]=a;
        }
        // compare two array
        for(int j =0;  j < 3; j++){

        }
        int c[][]=new int[3][];
        int k=0;

        for(int i=0;i<arr.length;i+=2){
            if(i == arr.length-1){
                System.out.println(display(b[i]));
                c[k]=b[i];
                k++;
            }else {

                System.out.println(display(b[i]) + " ? " + display(b[i + 1]));
                c[k]=compareAndShift(b[i], b[i+1]);
                k++;
            }
        }

        int d[][]=new int[3][];
        k=0;

        for(int i=0;i<c.length;i+=2){
            if(i == c.length-1){
                System.out.println(display(c[i]));
                d[k]=c[i];
                k++;
            }else {

                System.out.println(display(c[i]) + " ? " + display(c[i + 1]));
                d[k]=compareAndShift(c[i], c[i+1]);
                k++;
            }
        }
        System.out.println("D is "+display(d[0]));
    }

    private static int[] compareAndShift(int[] a, int[] b) {
        int i=0;
        int j=0;
        int k=0;
        int[] c=new int[a.length+b.length];
        while( i< a.length && j < b.length ){
           // System.out.println("1 :"+i+"\t"+j);
           // System.out.println("2 :"+a[i]+"\t"+b[j]);
            if(a[i] > b[j]){
                c[k]=b[j];
                k++;
                j++;
            }else{
                c[k]=a[i];
                k++;
                i++;
            }
        }
        // now copy all the remaining elements
        while(i<a.length){
            c[k]=a[i];
            k++;
            i++;
        }
        while(j < b.length){
            c[k]=b[j];
            k++;
            j++;
        }

        System.out.println("C is :: "+display(c));
        return c;
    }

    private static String display(int[] arr){
        String value ="";
        for(int i=0; i < arr.length; i++){
            value += arr[i]+" ";
        }
        return value;
    }
}
