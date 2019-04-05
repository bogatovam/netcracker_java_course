package com.netcracker;

import java.util.Random;

public class ControlStructures {
    enum MyEnum {
        FIRST, SECOND, THIRD, FORTH, FIFTH
    }

    final static Random random = new Random();

    public static void main(String[] args) {
        MyEnum e = MyEnum.THIRD;
        long startTime = System.nanoTime();

        System.out.println("Task #1");
        switch (e) {
            case FIRST:
                System.out.print("");
                break;
            case SECOND:
                System.out.print("");
                break;
            case THIRD:
                System.out.print("");
                break;
            case FORTH:
                System.out.print("");
                break;
            case FIFTH:
                System.out.print("");
                break;
        }

        System.out.println("Time of switch-case is: " + (System.nanoTime() - startTime));

        startTime = System.nanoTime();
        if (e == MyEnum.FIRST) System.out.print("");
        else if (e == MyEnum.SECOND) System.out.print("");
        else if (e == MyEnum.THIRD) System.out.print("");
        else if (e == MyEnum.FORTH) System.out.print("");
        else if (e == MyEnum.FIFTH) System.out.print("");
        System.out.println("Time of if-else is: " + (System.nanoTime() - startTime));

        System.out.println("\nTask #2");
        int n = 50;
        int[] array = new int[n];
        int[] count = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0; i < n; ++i)
            array[i] = random.nextInt(11);

        startTime = System.nanoTime();
        for (int i = 0; i < n; ++i) {
            switch (array[i]) {
                case 0:
                    System.out.print("");
                    count[0]++;
                    break;
                case 1:
                    System.out.print("");
                    count[1]++;
                    break;
                case 2:
                    System.out.print("");
                    count[2]++;
                    break;
                case 3:
                    System.out.print("");
                    count[3]++;
                    break;
                case 4:
                    System.out.print("");
                    count[4]++;
                    break;
                case 5:
                    System.out.print("");
                    count[5]++;
                    break;
                case 6:
                    System.out.print("");
                    count[6]++;
                    break;
                case 7:
                    System.out.print("");
                    count[7]++;
                    break;
                case 8:
                    System.out.print("");
                    count[8]++;
                    break;
                case 9:
                    System.out.print("");
                    count[array[i]]++;
                    count[9]++;
                    break;
                case 10:
                    System.out.print("");
                    count[10]++;
                    break;
            }
        }
        System.out.println("Time of switch-case with array is: " + (System.nanoTime() - startTime));

        for (int v : count) v = 0;
        startTime = System.nanoTime();
        for (int i = 0; i < n; ++i) {
            if (array[i] == 0) {
                count[0]++;
                System.out.print("");
            } else if (array[i] == 1) {
                count[1]++;
                System.out.print("");
            } else if (array[i] == 2) {
                count[3]++;
                System.out.print("");
            } else if (array[i] == 3) {
                count[3]++;
                System.out.print("");
            } else if (array[i] == 4) {
                count[4]++;
                System.out.print("");
            } else if (array[i] == 5) {
                count[5]++;
                System.out.print("");
            } else if (array[i] == 6) {
                count[6]++;
                System.out.print("");
            } else if (array[i] == 7) {
                count[7]++;
                System.out.print("");
            } else if (array[i] == 8) {
                count[8]++;
                System.out.print("");
            } else if (array[i] == 9) {
                count[9]++;
                System.out.print("");
            } else if (array[i] == 10) {
                count[10]++;
                System.out.print("");
            }
        }
        System.out.println("Time of if-else with array is: " + (System.nanoTime() - startTime));

    }
}

