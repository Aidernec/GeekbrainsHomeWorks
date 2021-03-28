package com.company;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static Object obj = new Object();
    private static volatile String letter = "A";
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.submit(() -> {
           try {
               for (int i = 0; i < 5; i++) {
                   synchronized (obj){
                       while (letter != "A"){
                           obj.wait();
                       }
                       System.out.println("A");
                       letter = "B";
                       obj.notifyAll();
                   }
               }
           } catch (Exception e) {
               e.printStackTrace();
           }
        });

        executorService.submit(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    synchronized (obj){
                        while (letter != "B"){
                            obj.wait();
                        }
                        System.out.println("B");
                        letter = "C";
                        obj.notifyAll();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        executorService.submit(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    synchronized (obj){
                        while (letter != "C"){
                            obj.wait();
                        }
                        System.out.println("C");
                        letter = "A";
                        obj.notifyAll();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
