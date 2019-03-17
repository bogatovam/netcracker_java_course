package com.netcracker.MyTriangle;

import com.netcracker.MyPoint.MyPoint;

public class MainTriangle {
    public static void main(String[] args) {
        MyPoint point1 = new MyPoint(0, 0);
        MyPoint point2 = new MyPoint(0, 2);
        MyPoint point3 = new MyPoint(2, 0);
        MyPoint point4 = new MyPoint(3, 0);
        MyTriangle triangle1 = new MyTriangle(point1, point2, point3);
        MyTriangle triangle2 = new MyTriangle(point1, point2, point4);

        System.out.println(triangle1.toString());
        System.out.println(triangle2.toString());

        System.out.println("Type of triangle 1 is " + triangle1.getType());
        System.out.println("Type of triangle 2 is " + triangle2.getType());

        System.out.println("Perimeter of triangle 1 is " + triangle1.getPerimeter());
        System.out.println("Perimeter of triangle 2 is " + triangle2.getPerimeter());

        System.out.println(triangle1.toString() + " and " + triangle2.toString() + " is" +
                (triangle1.equals(triangle2) ? " equals" : " not equals"));

    }
}
