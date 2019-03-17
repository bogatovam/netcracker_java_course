package com.netcracker;

import java.util.Random;

public class Factorial {
    final static Random random = new Random();

    public static long factorial(int number) {
        if (number == 1 || number == 0) return 1;
        return number * factorial(number - 1);
    }

    public static void main(String[] args) {
        long startTime;
        double loopTime, recursionTime;
        int number = random.nextInt(10);

        startTime = System.nanoTime();
        long resLoop = 1;
        for (int i = number; i > 0; --i) {
            resLoop *= i;
        }
        loopTime = (System.nanoTime() - startTime) / 1000000.0;

        startTime = System.nanoTime();
        long resRec = factorial(number);
        recursionTime = (System.nanoTime() - startTime) / 1000000.0;

        System.out.println("Factorial " + number);
        System.out.println("Result of loop: " + resLoop);
        System.out.println("Result of recursion: " + resRec);

        System.out.println("Time of loop: " + loopTime);
        System.out.println("Time of recursion: " + recursionTime);
    }
}
