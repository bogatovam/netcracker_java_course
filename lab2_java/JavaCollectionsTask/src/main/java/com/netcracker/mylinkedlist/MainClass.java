package com.netcracker.mylinkedlist;


import java.util.*;

public class MainClass {
    private static Random random = new Random();
    private static final int size = 100000;
    private static Double[] sourceArray = new Double[size];

    public static void measureList(List<Double> list) {
        double startTime, finishTime;
        Double value = random.nextDouble();

        startTime = System.nanoTime();
        list.add(0, value);
        finishTime = System.nanoTime();
        System.out.println("Insert in in the beginning:\t" + (finishTime - startTime) / 1000000.0);

        value = random.nextDouble();
        startTime = System.nanoTime();
        list.add(size/2, value);
        finishTime = System.nanoTime();
        System.out.println("Insert in in the middle\t" + (finishTime - startTime) / 1000000.0);

        value = random.nextDouble();
        startTime = System.nanoTime();
        list.add(list.size() - 1, value);
        finishTime = System.nanoTime();
        System.out.println("Insert in in the ending\t" + (finishTime - startTime) / 1000000.0);

        startTime = System.nanoTime();
        list.remove(0);
        finishTime = System.nanoTime();
        System.out.println("Delete from the beginning\t" + (finishTime - startTime) / 1000000.0);

        startTime = System.nanoTime();
        list.remove(size/2);
        finishTime = System.nanoTime();
        System.out.println("Delete from the middle\t" + (finishTime - startTime) / 1000000.0);

        startTime = System.nanoTime();
        list.remove(list.size() - 1);
        finishTime = System.nanoTime();
        System.out.println("Delete from the ending\t" + (finishTime - startTime) / 1000000.0);

        startTime = System.nanoTime();
        list.get((int)(size/2));
        finishTime = System.nanoTime();
        System.out.println("Get middle element\t" + (finishTime - startTime) / 1000000.0);

        startTime = System.nanoTime();
        for (Iterator<Double> iter = list.iterator(); iter.hasNext(); ) {
            Double element = iter.next();
        }
        finishTime = System.nanoTime();
        System.out.println("Pass iterator from start to finish;\t" + (finishTime - startTime) / 1000000.0);
        startTime = System.nanoTime();
        for (ListIterator<Double> iter = list.listIterator(); iter.hasPrevious(); ) {
            Double element = iter.previous();
        }
        finishTime = System.nanoTime();
        System.out.println("Pass iterator from finish to start;\t" + (finishTime - startTime) / 1000000.0);

        startTime = System.nanoTime();
        list.contains(value);
        finishTime = System.nanoTime();
        System.out.println("Contains \t" + (finishTime - startTime) / 1000000.0);

        startTime = System.nanoTime();
        list.clear();
        finishTime = System.nanoTime();
        System.out.println("Clear\t" + (finishTime - startTime) / 1000000.0);
    }

    public static void measureMyList(ILinkedList<Double> list) {
        double startTime, finishTime;
        Double value = random.nextDouble();

        startTime = System.nanoTime();
        list.add(0, value);
        finishTime = System.nanoTime();
        System.out.println("Insert in in the beginning:\t" + (finishTime - startTime) / 1000000.0);

        value = random.nextDouble();
        startTime = System.nanoTime();
        list.add(size/2, value);
        finishTime = System.nanoTime();
        System.out.println("Insert in in the middle\t" + (finishTime - startTime) / 1000000.0);

        value = random.nextDouble();
        startTime = System.nanoTime();
        list.add(list.size() - 1, value);
        finishTime = System.nanoTime();
        System.out.println("Insert in in the ending\t" + (finishTime - startTime) / 1000000.0);

        startTime = System.nanoTime();
        list.remove(0);
        finishTime = System.nanoTime();
        System.out.println("Delete from the beginning\t" + (finishTime - startTime) / 1000000.0);

        startTime = System.nanoTime();
        list.remove(size/2);
        finishTime = System.nanoTime();
        System.out.println("Delete from the middle\t" + (finishTime - startTime) / 1000000.0);

        startTime = System.nanoTime();
        list.remove(list.size() - 1);
        finishTime = System.nanoTime();
        System.out.println("Delete from the ending\t" + (finishTime - startTime) / 1000000.0);

        startTime = System.nanoTime();
        list.get((int)(size/2));
        finishTime = System.nanoTime();
        System.out.println("Get middle element\t" + (finishTime - startTime) / 1000000.0);

        startTime = System.nanoTime();
        for (Iterator<Double> iter = list.iterator(); iter.hasNext(); ) {
            Double element = iter.next();
        }
        finishTime = System.nanoTime();
        System.out.println("Pass iterator from start to finish;\t" + (finishTime - startTime) / 1000000.0);
        startTime = System.nanoTime();
        for (IListIterator<Double> iter = list.listIterator(); iter.hasPrevious(); ) {
            Double element = iter.previous();
        }
        finishTime = System.nanoTime();
        System.out.println("Pass iterator from finish to start;\t" + (finishTime - startTime) / 1000000.0);

        startTime = System.nanoTime();
        list.contains(value);
        finishTime = System.nanoTime();
        System.out.println("Contains \t" + (finishTime - startTime) / 1000000.0);

        startTime = System.nanoTime();
        list.clear();
        finishTime = System.nanoTime();
        System.out.println("Clear\t" + (finishTime - startTime) / 1000000.0);
    }

    public static void fill(Collection<Double> c) {
        for (int i = 0; i < size; ++i) {
            c.add(sourceArray[i]);
        }
    }

    public static void fill(ILinkedList<Double> c) {
        for (int i = 0; i < size; ++i) {
            c.add(sourceArray[i]);
        }
    }

    public static void main(String[] args) {
        MyLinkedList<Double> myLinkedList = new MyLinkedList<>();
        LinkedList<Double> linkedList = new LinkedList<>();


        for (int i = 0; i < size; ++i) {
            sourceArray[i] = random.nextDouble();
        }

        fill(myLinkedList);
        fill(linkedList);

        System.out.println("\n MyLinkedList vs default LinkedList \n");
        System.out.println("\n MyLinkedList\n");
        measureMyList(myLinkedList);
        System.out.println("\n LinkedList\n");
        measureList(linkedList);
    }
}
