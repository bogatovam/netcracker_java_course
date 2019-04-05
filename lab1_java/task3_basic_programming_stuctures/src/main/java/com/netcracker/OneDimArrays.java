package com.netcracker;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class OneDimArrays {
    final static Random random = new Random();

    public static void main(String[] args) {
        int n = 10;
        Integer[] array = new Integer[n];

        System.out.println("Task #1");

        for (int i = 0; i < array.length; ++i) {
            int num = random.nextInt(99) + 1;
            while (num % 2 != 1) num = random.nextInt(98) + 1;
            array[i] = num;
        }

        Arrays.sort(array);
        for (Integer el : array)
            System.out.print(el + " ");
        System.out.println();

        Arrays.sort(array, Collections.reverseOrder());
        for (Integer el : array)
            System.out.print(el + " ");
        System.out.println();

        System.out.println("\nTask #2");
        n = 20;
        int numEven = 0, numOdd = 0;
        array = new Integer[n];
        for (int i = 0; i < array.length; ++i) {
            array[i] = random.nextInt(11);
            if (array[i] % 2 == 0) ++numEven;
            else ++numOdd;
        }

        for (Integer el : array)
            System.out.print(el + " ");
        System.out.println();

        System.out.println("Number of even numbers=" + numEven);
        System.out.println("Number of odd numbers=" + numOdd);

        System.out.println("\nTask #3");
        n = 10;
        array = new Integer[n];
        for (int i = 0; i < array.length; ++i) {
            array[i] = random.nextInt(100) + 1;
        }

        for (Integer el : array)
            System.out.print(el + " ");
        System.out.println();

        for (int i = 0; i < array.length; ++i) {
            if (i % 2 == 1)
                array[i] = 0;
        }
        for (Integer el : array)
            System.out.print(el + " ");
        System.out.println();

        System.out.println("\nTask #4");
        n = 15;
        int max = -51, min = 51;
        int lastOccurrenceMax = -1, lastOccurrenceMin = -1;
        array = new Integer[n];

        for (int i = 0; i < array.length; ++i) {
            array[i] = random.nextInt(101) - 50;
            if (array[i] < min) min = array[i];
            if (array[i] > max) max = array[i];
        }

        for (Integer el : array)
            System.out.print(el + " ");
        System.out.println();

        for (int i = 0; i < array.length; ++i) {
            if (array[i] == max) lastOccurrenceMax = i;
            if (array[i] == min) lastOccurrenceMin = i;
        }
        System.out.println("Minimal element=" + min + ", last occurrence=" + lastOccurrenceMin);
        System.out.println("Maximal element=" + max + ", last occurrence=" + lastOccurrenceMax);

        System.out.println("\nTask #5");
        n = 10;
        double avg1 = 0.0, avg2 = 0.0;
        array = new Integer[n];
        Integer[] array2 = new Integer[n];

        for (int i = 0; i < array.length; ++i) {
            array[i] = random.nextInt(11);
            array2[i] = random.nextInt(11);

            avg1 += array[i];
            avg2 += array2[i];
        }

        for (Integer el : array)
            System.out.print(el + " ");
        System.out.println();

        for (Integer el : array2)
            System.out.print(el + " ");
        System.out.println();

        avg1 /= n;
        avg2 /= n;
        if (avg1 == avg2)
            System.out.println("Average arithmetic arrays are equal to " + avg1);
        else if (avg1 > avg2)
            System.out.println("The arithmetic mean of the first array (" + avg1 + ") is greater " +
                    "than the arithmetic mean of the second array(" + avg2 + ")");
        else System.out.println("The arithmetic mean of the second array(" + avg2 + ") is greater " +
                    "than the arithmetic mean of the first array(" + avg2 + ")");

        System.out.println("\nTask #6");
        n = 20;
        int dsp = 1;
        int[] count = new int[]{0, 0, 0};
        array = new Integer[n];

        for (int i = 0; i < array.length; ++i) {
            array[i] = random.nextInt(3) - dsp;
            count[array[i] + dsp]++;
        }

        for (Integer el : array)
            System.out.print(el + " ");
        System.out.println();

        max = -1;
        for (int i = 0; i < 3; ++i)
            if (count[i] > max) max = count[i];
        System.out.println("Frequent element(s)");
        for (int i = 0; i < 3; ++i)
            if (count[i] == max)
                System.out.println("Element:" + (i - dsp) + ", number of repetitions is " + count[i]);

    }
}
