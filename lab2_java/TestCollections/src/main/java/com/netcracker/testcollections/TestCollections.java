package com.netcracker.testcollections;

import java.util.*;

public class TestCollections {
    static Random random = new Random();
    static final int size = 100000;

    public static void measureList(List<Double> list) {
        double startTime, finishTime;
        Double value = random.nextDouble();

        startTime = System.nanoTime();
        list.add(0, value);
        finishTime = System.nanoTime();
        System.out.println("Insert in in the beginning:\t" + (finishTime - startTime) / 1000000.0);

        value = random.nextDouble();
        startTime = System.nanoTime();
        list.add(random.nextInt(size) % list.size(), value);
        finishTime = System.nanoTime();
        System.out.println("Insert in in the random\t" + (finishTime - startTime) / 1000000.0);

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
        list.remove(random.nextInt(size) % list.size());
        finishTime = System.nanoTime();
        System.out.println("Delete from the random\t" + (finishTime - startTime) / 1000000.0);

        startTime = System.nanoTime();
        list.remove(list.size() - 1);
        finishTime = System.nanoTime();
        System.out.println("Delete from the ending\t" + (finishTime - startTime) / 1000000.0);

        startTime = System.nanoTime();
        list.get(random.nextInt(size) % list.size());
        finishTime = System.nanoTime();
        System.out.println("Get random element\t" + (finishTime - startTime) / 1000000.0);

        startTime = System.nanoTime();
        for (Iterator<Double> iter = list.iterator(); iter.hasNext(); ) {
            Double element = iter.next();
        }
        finishTime = System.nanoTime();
        System.out.println("Pass iterator from start to finish;\t" + (finishTime - startTime) / 1000000.0);
        startTime = System.nanoTime();
        for (ListIterator<Double> iter =  list.listIterator(); iter.hasPrevious(); ) {
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

    public static void measureSet(Set<Double> set) {
        double startTime, finishTime;
        Double value = random.nextDouble();

        startTime = System.nanoTime();
        set.add(value);
        finishTime = System.nanoTime();
        System.out.println("Add element\t" + (finishTime - startTime) / 1000000.0);

        startTime = System.nanoTime();
        set.remove(value);
        finishTime = System.nanoTime();
        System.out.println("Remove\t" + (finishTime - startTime) / 1000000.0);

        startTime = System.nanoTime();
        for (Iterator<Double> iter = set.iterator(); iter.hasNext(); ) {
            Double element = iter.next();
        }
        finishTime = System.nanoTime();
        System.out.println("Pass iterator from start to finish\t" + (finishTime - startTime) / 1000000.0);

        startTime = System.nanoTime();
        set.contains(value);
        finishTime = System.nanoTime();
        System.out.println("Contains\t" + (finishTime - startTime) / 1000000.0);

        startTime = System.nanoTime();
        set.clear();
        finishTime = System.nanoTime();
        System.out.println("Clear\t" + (finishTime - startTime) / 1000000.0);
    }

    public static void measureMap(Map<Double, Double> map) {
        double startTime, finishTime;
        Double key = random.nextDouble();
        Double value = random.nextDouble();

        startTime = System.nanoTime();
        map.put(key, value);
        finishTime = System.nanoTime();
        System.out.println("Add element\t" + (finishTime - startTime) / 1000000.0);

        startTime = System.nanoTime();
        map.get(key);
        finishTime = System.nanoTime();
        System.out.println("Get element\t" + (finishTime - startTime) / 1000000.0);

        startTime = System.nanoTime();
        value = random.nextDouble();
        map.replace(key, value);
        finishTime = System.nanoTime();
        System.out.println("Set element\t" + (finishTime - startTime) / 1000000.0);

        startTime = System.nanoTime();
        map.remove(key);
        finishTime = System.nanoTime();
        System.out.println("Remove\t" + (finishTime - startTime) / 1000000.0);

        startTime = System.nanoTime();
        for (Map.Entry<Double, Double> entry : map.entrySet()) {
            Double tKey = entry.getKey();
            Double tVal = entry.getValue();
        }
        finishTime = System.nanoTime();
        System.out.println("Pass iterator from start to finish\t" + (finishTime - startTime) / 1000000.0);

        startTime = System.nanoTime();
        map.containsKey(key);
        map.containsValue(value);
        finishTime = System.nanoTime();
        System.out.println("Contains\t" + (finishTime - startTime) / 1000000.0);

        startTime = System.nanoTime();
        map.clear();
        finishTime = System.nanoTime();
        System.out.println("Clear\t" + (finishTime - startTime) / 1000000.0);
    }

    public static void fill(Collection<Double> c) {
        for (int i = 0; i < size; ++i) {
            c.add(random.nextDouble());
        }
    }

    public static void fill(Map<Double, Double> map) {
        for (int i = 0; i < size; ++i) {
            map.put(random.nextDouble(), random.nextDouble());
        }
    }

    public static void main(String[] args) {
        //ArrayList vs LinkedList
        List<Double> arrayList = new ArrayList<>();
        List<Double> linkedList = new LinkedList<>();

        fill(arrayList);
        fill(linkedList);
        System.out.println("\n ArrayList vs LinkedList\n");
        System.out.println("ArrayList\n");
        measureList(arrayList);
        System.out.println("LinkedList\n");
        measureList(linkedList);
        // HashSet vs LinkedHashSet vs TreeSet
        Set<Double> hashSet = new HashSet<>();
        Set<Double> linkedHashSet = new LinkedHashSet<>();
        Set<Double> treeSet = new TreeSet<>();

        fill(hashSet);
        fill(linkedHashSet);
        fill(treeSet);
        System.out.println("\n HashSet vs LinkedHashSet vs TreeSet\n");
        System.out.println("HashSet\n");
        measureSet(hashSet);
        System.out.println("LinkedHashSet\n");
        measureSet(linkedHashSet);
        System.out.println("TreeSet\n");
        measureSet(treeSet);

        //HashMap vs LinkedHashMap vs TreeMap
        Map<Double, Double>  hashMap= new HashMap<>();
        Map<Double, Double> linkedHashMap = new LinkedHashMap<>();
        Map<Double, Double>  treeMap= new TreeMap<>();

        fill(hashMap);
        fill(linkedHashMap);
        fill(treeMap);
        System.out.println("\n HashMap vs LinkedHashMap vs TreeMap\n");
        System.out.println("HashMap\n");
        measureMap(hashMap);
        System.out.println("LinkedHashMap\n");
        measureMap(linkedHashMap);
        System.out.println("TreeMap\n");
        measureMap(treeMap);
    }

}
