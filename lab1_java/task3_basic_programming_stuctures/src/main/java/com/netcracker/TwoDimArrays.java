package com.netcracker;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class TwoDimArrays {
    final static Random random = new Random();

    public static void main(String[] args) {
        int nstr = 8, ncol = 8;
        Integer[][] array = new Integer[nstr][ncol];

        System.out.println("\nTask #1");
        long sum = 0, multi = 1;
        for (int i = 0; i < nstr; ++i) {
            for (int j = 0; j < ncol; ++j) {
                array[i][j] = random.nextInt(99) + 1;
            }
        }

        for (int i = 0; i < nstr; ++i) {
            for (int j = 0; j < ncol; ++j) {
                if (j == i) {
                    multi *= array[i][j];
                    sum += array[i][j];
                }
            }
        }

        System.out.println("Multiplication of elements of the primary diagonal: " + multi +
                "\nSum of elements: " + sum);

        multi = 1;
        sum = 0;
        for (int i = 0; i < nstr; ++i) {
            for (int j = 0; j < ncol; ++j) {
                if (j == ncol - i - 1) {
                    multi *= array[i][j];
                    sum += array[i][j];
                }
            }
        }

        System.out.println("Multiplication of elements of the secondary diagonal: " + multi +
                "\nSum of elements: " + sum);

        System.out.println("\nTask #2");
        int imax = 0, jmax = 0;
        nstr = 8;
        ncol = 5;
        array = new Integer[nstr][ncol];

        for (int i = 0; i < nstr; ++i) {
            for (int j = 0; j < ncol; ++j) {
                array[i][j] = random.nextInt(199) - 99;
                if (array[i][j] > array[imax][jmax]) {
                    imax = i;
                    jmax = j;
                }
            }
        }

        for (int i = 0; i < nstr; ++i) {
            for (int j = 0; j < ncol; ++j) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Max element: array[" + imax +1+ "][" + jmax+1 + "]=" + array[imax][jmax]);

        System.out.println("\nTask #3");
        long maxMult = -11;
        nstr = 8;
        ncol = 5;
        imax = -1;
        array = new Integer[nstr][ncol];

        for (int i = 0; i < nstr; ++i) {
            for (int j = 0; j < ncol; ++j) {
                array[i][j] = random.nextInt(21) - 10;
            }
        }

        for (int i = 0; i < nstr; ++i) {
            long tmpMult = 1;
            for (int j = 0; j < ncol; ++j) {
                tmpMult *= array[i][j];
            }
            if (Math.abs(tmpMult) > maxMult) {
                maxMult = tmpMult;
                imax = i;
            }
        }
        for (int i = 0; i < nstr; ++i) {
            for (int j = 0; j < ncol; ++j) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("The row with the maximum multiplication of elements is " + imax+1);

        System.out.println("\nTask #4");
        nstr = 10;
        ncol = 7;
        array = new Integer[nstr][ncol];

        for (int i = 0; i < nstr; ++i) {
            for (int j = 0; j < ncol; ++j) {
                array[i][j] = random.nextInt(101);
            }
        }

        for (int i = 0; i < nstr; ++i) {
            for (int j = 0; j < ncol; ++j) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < nstr; ++i) {
            Arrays.sort(array[i], Collections.reverseOrder());
        }
        for (int i = 0; i < nstr; ++i) {
            for (int j = 0; j < ncol; ++j) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

}
