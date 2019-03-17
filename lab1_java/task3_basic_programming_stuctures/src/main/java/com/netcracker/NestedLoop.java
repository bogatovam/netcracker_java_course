package com.netcracker;

public class NestedLoop {
    public static void main(String[] args) {
        char c = '#';

        // task1
        int size = 5;
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j)
                System.out.print(c);
            System.out.println();
        }
        System.out.println();

        //task2
        size = 8;
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j <= i; ++j)
                System.out.print(c);
            System.out.println();
        }

        System.out.println();

        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size - i; ++j)
                System.out.print(c);
            System.out.println();
        }
        System.out.println();

        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < i; ++j)
                System.out.print(' ');
            for (int j = 0; j < size - i; ++j)
                System.out.print(c);
            System.out.println();
        }
        System.out.println();

        for (int i = 0; i < size; ++i) {
            for (int j = i + 1; j < size; ++j)
                System.out.print(' ');

            for (int j = 0; j <= i; ++j)
                System.out.print(c);
            System.out.println();
        }

        System.out.println();

        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                if (i == 0 || i == size-1 || j == i)
                    System.out.print(c);
                else System.out.print(' ');
            }
            System.out.println();
        }
        System.out.println();

        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                if (i == 0 || i == size-1 || j == 0 || j == size-1)
                    System.out.print(c);
                else System.out.print(' ');
            }
            System.out.println();
        }
    }
}
