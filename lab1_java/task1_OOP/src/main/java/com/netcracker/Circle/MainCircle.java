package com.netcracker.Circle;

public class MainCircle {
    public static void main(String[] args) {
        Circle circle1 = new Circle(5);
        Circle circle2 = new Circle(5, "green");
        System.out.println(circle1.toString());
        System.out.println(circle2.toString());
        System.out.println("Circle1 and Circle2 is " +
                (circle1.equals(circle2) ? " equals" : " not equals"));
        System.out.println("Area of the first circle is " + circle1.getArea());
        System.out.println("Area of the second circle  is " + circle2.getArea());
    }
}
