package com.example.threadingexamples;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample {
    public static void main(String[] args) throws Exception {
        CompletableFuture<Tuple> completableFuture = CompletableFuture.
                supplyAsync(() -> {
                    return new Tuple();
                });
        Tuple t = completableFuture.get();


    }
}
class Tuple{
    static int count=0;
    String name;
    int[] array;

    public Tuple() {
        System.out.println("I am getting called.");
        name="Some "+count++;
        for(int i=0; i< 10; i ++){
            array[i]=i;
        }
    }
}