package com.netcracker.Rectangle;

public class MainRectangle {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(20, 20);

        System.out.println(rectangle.toString());

        System.out.println("Area of rectangle is " + rectangle.getArea());
        System.out.println("Perimeter of rectangle" + rectangle.getPerimetr());
    }
}
