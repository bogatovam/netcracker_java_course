package com.netcracker;

import java.util.Arrays;
import java.util.Random;

public class CmpSorts {
    final static Random random = new Random();

    public static void generateRandomArray(int[] array) {
        for (int i = 0; i < array.length; ++i)
            array[i] = random.nextInt(100);
    }

    public static void insertSort(int[] array) {
        for (int i = 0; i < array.length; ++i) {
            for (int j = i; j > 0 && array[j] < array[j - 1]; --j) {
                int tmp = array[j - 1];
                array[j - 1] = array[j];
                array[j] = tmp;
            }
        }
    }

    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; ++i) {
            for (int j = 0; j < array.length - i - 1; ++j) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = 10;
        long startTime;
        double insertSortTime, bubbleSortTime, defaultSortTime;
        int[] array = new int[n];
        generateRandomArray(array);

        int[] sortedArray = array.clone();
        startTime = System.nanoTime();
        insertSort(sortedArray);
        insertSortTime = (System.nanoTime() - startTime) / 1000000.0;

        sortedArray = array.clone();
        startTime = System.nanoTime();
        bubbleSort(sortedArray);
        bubbleSortTime = (System.nanoTime() - startTime) / 1000000.0;

        sortedArray = array.clone();
        startTime = System.nanoTime();
        Arrays.sort(sortedArray);
        defaultSortTime = (System.nanoTime() - startTime) / 1000000.0;

        System.out.println("Size of array=" + n);
        System.out.println("Insert sort: time= " + insertSortTime + "ms");
        System.out.println("Bubble sort: time= " + bubbleSortTime + "ms");
        System.out.println("Arrays.sort(): time= " + defaultSortTime + "ms");
    }
}
