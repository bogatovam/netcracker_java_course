package com.netcracker.MyPoint;

public class MainPoint {
    public static void main(String[] args) {
        MyPoint point1 = new MyPoint(1, 5);
        MyPoint point2 = new MyPoint(2, 2);
        MyPoint point3 = new MyPoint(2, 2);

        System.out.println(point1.toString());
        System.out.println(point2.toString());

        System.out.println("Distance between " + point1.toString() +
                " and (0,0) is" + point1.distance());
        System.out.println("Distance between " + point1.toString() +
                " and (1,1) is" + point2.distance(1, 1));
        System.out.println("Distance between " + point1.toString() +
                " and " + point2.toString() + " is" + point1.distance(point2));

        System.out.println(point1.toString() + " and " + point2.toString() + " is" +
                (point1.equals(point2) ? " equals" : " not equals"));
        System.out.println(point2.toString() + " and " + point2.toString() + " is" +
                (point2.equals(point3) ? " equals" : " not equals"));
    }
}
